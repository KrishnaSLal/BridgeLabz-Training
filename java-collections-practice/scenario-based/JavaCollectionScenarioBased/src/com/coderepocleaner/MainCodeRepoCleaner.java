package com.coderepocleaner;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class MainCodeRepoCleaner {

    public static void main(String[] args) {

        Path sourceDir = Paths.get("source");

        Map<FileCategory, List<Path>> categorizedFiles =
                new EnumMap<>(FileCategory.class);

        for (FileCategory fc : FileCategory.values()) {
            categorizedFiles.put(fc, new ArrayList<>());
        }

        Set<String> unusedImports = new HashSet<>();

        try {
            //  Scan files
            List<Path> javaFiles =
                    CodeScanner.scanJavaFiles(sourceDir);

            //  Analyze files
            for (Path file : javaFiles) {
                FileCategory category =
                        CodeAnalyzer.analyze(file, unusedImports);
                categorizedFiles.get(category).add(file);
            }

            //  Create folders
            for (FileCategory fc : FileCategory.values()) {
                Files.createDirectories(sourceDir.resolve(fc.name()));
            }

            //  Move files
            for (Map.Entry<FileCategory, List<Path>> entry :
                    categorizedFiles.entrySet()) {

                for (Path file : entry.getValue()) {
                    Files.copy(file,
                            sourceDir.resolve(entry.getKey().name())
                                    .resolve(file.getFileName()),
                            StandardCopyOption.REPLACE_EXISTING);
                }
            }

            //Stream filtering examples
            System.out.println("\n Large files (>2KB):");
            javaFiles.stream()
                    .filter(p -> {
                        try {
                            return Files.size(p) > 2048;
                        } catch (IOException e) {
                            return false;
                        }
                    })
                    .forEach(System.out::println);

            System.out.println("\n📦 Unused Imports:");
            unusedImports.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
