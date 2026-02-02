package com.coderepocleaner;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class CodeScanner {

    public static List<Path> scanJavaFiles(Path root) throws IOException {

        return Files.walk(root)
                .filter(path -> path.toString().endsWith(".java"))
                .collect(Collectors.toList());
    }
}
