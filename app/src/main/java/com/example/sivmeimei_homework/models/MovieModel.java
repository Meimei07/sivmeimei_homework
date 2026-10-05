package com.example.sivmeimei_homework.models;

import com.example.sivmeimei_homework.R;

import java.util.ArrayList;
import java.util.List;

public class MovieModel {
    private double rating;
    private String accessBadge;
    private String title;
    private int year;
    private int duration;
    private String ageRating;
    private String genre;
    private int imageName;

    public MovieModel(double rating, String accessBadge, String title, int year, int duration, String ageRating, String genre, int imageName) {
        this.rating         = rating;
        this.accessBadge    = accessBadge;
        this.title          = title;
        this.year           = year;
        this.duration       = duration;
        this.ageRating      = ageRating;
        this.genre          = genre;
        this.imageName      = imageName;
    }

    public String getRating() {
        return String.valueOf(rating);
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAccessBadge() {
        return accessBadge;
    }

    public void setAccessBadge(String accessBadge) {
        this.accessBadge = accessBadge;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return String.valueOf(year);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDuration() {
        return duration + " Minutes";
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getImageName() {
        return imageName;
    }

    public void setImageName(int imageName) {
        this.imageName = imageName;
    }

    public static List<MovieModel> generateData() {
        return List.of(
                new MovieModel(4.8, "Premium", "Inception", 2010, 148, "NC-15", "Sci-Fi", R.drawable.movie_1),
                new MovieModel(0, "Free", "The Dark Knight", 2008, 152, "NC-15", "Action", R.drawable.movie_2),
                new MovieModel(1.5, "Premium", "Pulp Fiction", 1994, 154, "R-18", "Crime", R.drawable.movie_1),
                new MovieModel(4.1, "Free", "Interstellar", 2014, 169, "NC-15", "Sci-Fi", R.drawable.movie_2),
                new MovieModel(0, "Premium", "Spider-Man: Into the Spider-Verse", 2018, 117, "G", "Animation", R.drawable.movie_1),
                new MovieModel(0.8, "Free", "Parasite", 2019, 132, "R-18", "Thriller", R.drawable.movie_2),
                new MovieModel(5.0, "Premium", "The Lord of the Rings: The Fellowship of the Ring", 2001, 178, "NC-15", "Fantasy", R.drawable.movie_1),
                new MovieModel(3.7, "Free", "Spirited Away", 2001, 125, "G", "Animation", R.drawable.movie_2),
                new MovieModel(4.3, "Premium", "The Matrix", 1999, 136, "NC-15", "Sci-Fi", R.drawable.movie_1),
                new MovieModel(2.1, "Free", "Whiplash", 2014, 106, "NC-15", "Drama", R.drawable.movie_2),
                new MovieModel(3.9, "Premium", "Iron Man", 2008, 126, "NC-15", "Action", R.drawable.movie_1),
                new MovieModel(4.6, "Free", "Coco", 2017, 105, "G", "Animation", R.drawable.movie_2),
                new MovieModel(1.2, "Premium", "Blade Runner 2049", 2017, 164, "R-18", "Sci-Fi", R.drawable.movie_1),
                new MovieModel(3.4, "Free", "Grand Budapest Hotel", 2014, 99, "NC-15", "Comedy", R.drawable.movie_2),
                new MovieModel(4.9, "Premium", "The Silence of the Lambs", 1991, 118, "R-18", "Horror", R.drawable.movie_1),
                new MovieModel(2.5, "Free", "Get Out", 2017, 104, "R-18", "Horror", R.drawable.movie_2),
                new MovieModel(3.8, "Premium", "Knives Out", 2019, 130, "NC-15", "Mystery", R.drawable.movie_1),
                new MovieModel(4.4, "Free", "Toy Story", 1995, 81, "G", "Animation", R.drawable.movie_2),
                new MovieModel(1.9, "Premium", "Alien", 1979, 117, "R-18", "Sci-Fi", R.drawable.movie_1),
                new MovieModel(3.0, "Free", "Avatar", 2009, 162, "NC-15", "Action", R.drawable.movie_2)
        );
    }
}
