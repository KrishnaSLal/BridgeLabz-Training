//Top 5 Trending Movies
//○ Scenario: From a huge movie list, find the top 5 based on rating and release
//year.
//○ Task: Use filter(), sorted(), limit().

package com.streamapi.toptredingmovies;

import java.util.*;
import java.util.stream.*;

class Movie {
    String name;
    double rating;
    int releaseYear;

    Movie(String name, double rating, int releaseYear) {
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }
    
    double getRating() {
        return rating;
    }

    int getReleaseYear() {
        return releaseYear;
    }


    @Override
    public String toString() {
        return name + " | Rating: " + rating + " | Year: " + releaseYear;
    }
}

public class MainTrendingMovie {
    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
                new Movie("Movie A", 8.5, 2024),
                new Movie("Movie B", 9.1, 2023),
                new Movie("Movie C", 7.8, 2022),
                new Movie("Movie D", 9.0, 2024),
                new Movie("Movie E", 8.9, 2023),
                new Movie("Movie F", 9.3, 2024),
                new Movie("Movie G", 8.2, 2021)
        );

        System.out.println("Top 5 Trending Movies:\n");

        movies.stream()
                .filter(m -> m.rating >= 8.0) 
                .sorted(
                        Comparator.comparingDouble(Movie::getRating).reversed()
                                .thenComparing(Movie::getReleaseYear, Comparator.reverseOrder())
                )
                .limit(5)
                .forEach(System.out::println);
    }
}
