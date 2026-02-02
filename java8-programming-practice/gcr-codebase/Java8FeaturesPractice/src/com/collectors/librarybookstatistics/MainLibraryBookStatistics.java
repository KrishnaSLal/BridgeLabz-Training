//Library Book Statistics
//Given a list of books with their genres and number of pages, use
//Collectors.summarizingInt()
//to find total pages, average pages, and maximum pages per genre.


package com.collectors.librarybookstatistics;

import java.util.*;
import java.util.stream.Collectors;

public class MainLibraryBookStatistics {

    public static void main(String[] args) {

        List<Book> books = List.of(
            new Book("Java Basics", "Education", 300),
            new Book("Advanced Java", "Education", 450),
            new Book("Mystery Island", "Fiction", 250),
            new Book("Haunted House", "Fiction", 320),
            new Book("Space Science", "Science", 500)
        );

        Map<String, IntSummaryStatistics> statsByGenre =
                books.stream()
                     .collect(Collectors.groupingBy(
                         Book::getGenre,
                         Collectors.summarizingInt(Book::getPages)
                     ));

        statsByGenre.forEach((genre, stats) -> {
            System.out.println("\nGenre: " + genre);
            System.out.println("Total Pages: " + stats.getSum());
            System.out.println("Average Pages: " + stats.getAverage());
            System.out.println("Maximum Pages: " + stats.getMax());
        });
    }
}