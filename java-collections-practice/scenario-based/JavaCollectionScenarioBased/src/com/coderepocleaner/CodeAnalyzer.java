package com.coderepocleaner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.*;

public class CodeAnalyzer {

    // camelCase method naming
    private static final Pattern METHOD_PATTERN =
            Pattern.compile("\\bvoid\\s+([A-Z][a-zA-Z0-9]*)\\s*\\(");

    private static final Pattern IMPORT_PATTERN =
            Pattern.compile("^import\\s+([\\w\\.]+);", Pattern.MULTILINE);

    public static FileCategory analyze(Path file, Set<String> unusedImports)
            throws IOException {

        String content = Files.readString(file);

        boolean hasErrors = false;
        boolean hasWarnings = false;

        //Method naming violations
        Matcher methodMatcher = METHOD_PATTERN.matcher(content);
        if (methodMatcher.find()) {
            hasErrors = true;
        }

        //Unused imports (simple heuristic)
        Matcher importMatcher = IMPORT_PATTERN.matcher(content);
        while (importMatcher.find()) {
            String imp = importMatcher.group(1);
            String className =
                    imp.substring(imp.lastIndexOf('.') + 1);

            if (!content.contains(className + ".")) {
                unusedImports.add(className);
                hasWarnings = true;
            }
        }

        if (hasErrors) return FileCategory.ERRORS;
        if (hasWarnings) return FileCategory.WARNINGS;
        return FileCategory.VALID;
    }
}
