package com.travellog;

import java.io.*;
import java.util.List;

public class TravelLogReader {

    @SuppressWarnings("unchecked")
    public static List<Trip> readTrips(String fileName)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Trip>) ois.readObject();
        }
    }
}
