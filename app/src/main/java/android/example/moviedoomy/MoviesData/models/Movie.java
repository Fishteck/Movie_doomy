package android.example.moviedoomy.MoviesData.models;

import android.example.moviedoomy.MoviesData.entity.NewMovieJSONResult;

public class Movie {
    private static final String POSTER_PATH = "https://image.tmdb.org/t/p/w500/";
    private String title;
    private int id;
    private Double rating;
    private String poster;
    private int quantityRating;


    public Movie(NewMovieJSONResult result) {
        this.title = result.getTitle();
        this.id = result.getId();
        this.rating = result.getVoteAverage();
        this.poster = POSTER_PATH + result.getBackdropPath();
        this.quantityRating = result.getVoteCount();
    }

    public String getTitle() {
        return title;
    }

    public Double getRating() {
        return rating;
    }
    public int getId() {
        return id;
    }

    public String getPoster() {
        return poster;
    }

    public int getQuantityRating() {
        return quantityRating;
    }
}
