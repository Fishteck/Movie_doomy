package android.example.moviedoomy.MoviesData.models;

import android.example.moviedoomy.MoviesData.entity.NewMovieJSONResult;

import java.util.Map;

public class Movie {
    private static final String POSTER_PATH = "https://image.tmdb.org/t/p/w200/";
    private String title;
    private String originalTitle;
    private int id;
    private Double rating;
    private String poster;
    private int quantityRating;
    private String releaseDate;
    private String genre;

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public Movie(NewMovieJSONResult result, Map<Integer, String> genresMap) {
        this.title = result.getTitle();
        this.originalTitle = result.getOriginalTitle();
        this.id = result.getId();
        this.rating = result.getVoteAverage();
        this.poster = POSTER_PATH + result.getPosterPath();
        this.quantityRating = result.getVoteCount();
        this.genre = Formater.formatGenre(genresMap, result.getGenreIds());
        this.releaseDate = Formater.formatDate(result.getReleaseDate());
    }

    public String getGenre() {
        return genre;
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
