package com.junit.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.junit.com.FileProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class FileProcessorTest {

    FileProcessor processor = new FileProcessor();
    String testFile = "testfile.txt";

    @AfterEach
    void cleanUp() throws IOException {
        Files.deleteIfExists(Path.of(testFile));
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello JUnit File Test";

        processor.writeToFile(testFile, content);
        String result = processor.readFromFile(testFile);

        assertEquals(content, result);
    }

    //File exists after writing
    @Test
    void testFileExistsAfterWriting() throws IOException {
        processor.writeToFile(testFile, "Some content");

        assertTrue(Files.exists(Path.of(testFile)));
    }

    // IOException when file does not exist
    @Test
    void testReadNonExistingFileThrowsException() {
        assertThrows(IOException.class, () -> {
            processor.readFromFile("non_existing.txt");
        });
    }
}