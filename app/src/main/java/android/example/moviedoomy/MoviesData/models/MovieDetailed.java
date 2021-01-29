package android.example.moviedoomy.MoviesData.models;

import android.example.moviedoomy.MoviesData.entity.movieDetailedJSON.MovieDetailedJSON;

public class MovieDetailed  {
    private static final String POSTER_PATH = "https://image.tmdb.org/t/p/w500/";
    private String title;
    private String originalTitle;
    private int budget;
    private Double rating;
    private String poster;
    private int quantityRating;
    private String releaseDate;
    private String genre;
    private String overview;

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public int getBudget() {
        return budget;
    }

    public Double getRating() {
        return rating;
    }

    public String getPoster() {
        return poster;
    }

    public int getQuantityRating() {
        return quantityRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public String getOverview() {
        return overview;
    }

    public MovieDetailed(MovieDetailedJSON result) {
        this.title = result.getTitle();
        this.originalTitle = result.getOriginalTitle();
        this.budget = result.getBudget();
        this.rating = result.getVoteAverage();
        this.poster = POSTER_PATH + result.getPosterPath();
        this.quantityRating = result.getVoteCount();
        this.releaseDate = Formater.formatDate(result.getReleaseDate());
        this.genre = Formater.formatGenre(result.getGenres());
        this.overview = result.getOverview();
    }



}
