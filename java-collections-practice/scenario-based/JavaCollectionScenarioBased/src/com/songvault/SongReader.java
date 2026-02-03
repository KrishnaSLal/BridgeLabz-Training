package com.songvault;

import java.io.*;
import java.util.regex.*;

public class SongReader {

    private static final Pattern FIELD_PATTERN =
        Pattern.compile("(Title|Artist|Duration|Genre):\\s*(.*)");

    public static Song readSong(File file) throws IOException {

        String title = "", artist = "", duration = "", genre = "";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {

                Matcher matcher = FIELD_PATTERN.matcher(line);
                if (matcher.matches()) {

                    String field = matcher.group(1);
                    String value = matcher.group(2);

                    switch (field) {
                        case "Title": title = value; break;
                        case "Artist": artist = value; break;
                        case "Duration": duration = value; break;
                        case "Genre": genre = value; break;
                    }
                }
            }
        }

        return new Song(title, artist, duration, genre);
    }
}
