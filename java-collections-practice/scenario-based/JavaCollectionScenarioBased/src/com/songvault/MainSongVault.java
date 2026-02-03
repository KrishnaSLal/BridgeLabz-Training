//SongVault – Personal Music Library Manager
//Story: Nina is a music enthusiast who collects .txt files, each representing a song in the
//format:
//Title: Bohemian Rhapsody
//Artist: Queen
//Duration: 5:55
//Genre: Rock
//With hundreds of such files, she wants to create SongVault, a desktop app that:
//● Reads song files using I/O Streams
//● Extracts fields using Regex
//● Stores songs in a List<Song> and groups them by genre using Map<String,
//List<Song>>
//● Uses Set<String> to list unique artists
//● Allows filtering and sorting using Java Streams
//● Supports Generics for different types of media: audio, video, podcast


package com.songvault;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class MainSongVault {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter songs folder path: ");
        File folder = new File(sc.nextLine());

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path!");
        }

        List<Song> songs = new ArrayList<>();
        Set<String> artists = new HashSet<>();

        try {
            for (File file : Objects.requireNonNull(folder.listFiles())) {

                if (file.getName().endsWith(".txt")) {
                    Song song = SongReader.readSong(file);
                    songs.add(song);
                    artists.add(song.getArtist());
                }
            }

            // Group by genre
            Map<String, List<Song>> byGenre =
                    songs.stream()
                         .collect(Collectors.groupingBy(Song::getGenre));

            System.out.println("\nSongs by Genre:");
            byGenre.forEach((genre, list) -> {
                System.out.println("\n" + genre + ":");
                list.forEach(System.out::println);
            });

            // Unique artists
            System.out.println("\nUnique Artists:");
            artists.forEach(System.out::println);

            // Stream filtering & sorting
            System.out.println("\nSorted Songs by Title:");
            songs.stream()
                 .sorted(Comparator.comparing(Song::getTitle))
                 .forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
