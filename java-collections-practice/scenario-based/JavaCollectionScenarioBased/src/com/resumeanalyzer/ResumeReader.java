package com.resumeanalyzer;

import java.io.*;
import java.nio.file.Files;

public class ResumeReader {

    public static String readResume(File file) throws IOException, InvalidResumeFormatException {

        if (file.getName().endsWith(".txt")) {
            return Files.readString(file.toPath());
        } 
        else if (file.getName().endsWith(".pdf")) {
            // Simulated PDF reading (real projects use Apache PDFBox)
            return Files.readString(file.toPath());
        } 
        else {
            throw new InvalidResumeFormatException("Unsupported file: " + file.getName());
        }
    }
}
