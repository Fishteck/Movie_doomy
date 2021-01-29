package android.example.moviedoomy.MoviesData.entity.movieDetailedJSON;

import android.example.moviedoomy.MoviesData.entity.GenreJSONResult;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDetailedJSON {

    @SerializedName("adult")
    private Boolean adult;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("belongs_to_collection")
    private BelongsToCollection belongsToCollection;

    @SerializedName("budget")
    private Integer budget;

    @SerializedName("genres")
    private List<GenreJSONResult> genres = null;

    @SerializedName("homepage")
    private String homepage;

    @SerializedName("id")
    private Integer id;

    @SerializedName("imdb_id")
    private String imdbId;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("overview")
    private String overview;

    @SerializedName("popularity")
    private Double popularity;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("production_companies")
    private List<ProductionCompany> productionCompanies = null;

    @SerializedName("production_countries")
    private List<ProductionCountry> productionCountries = null;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("revenue")
    private Integer revenue;

    @SerializedName("runtime")
    private Integer runtime;

    @SerializedName("status")
    private String status;

    @SerializedName("tagline")
    private String tagline;

    @SerializedName("title")
    private String title;

    @SerializedName("video")
    private Boolean video;

    @SerializedName("vote_average")
    private Double voteAverage;

    @SerializedName("vote_count")
    private Integer voteCount;

    public Boolean getAdult() {
        return adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public BelongsToCollection getBelongsToCollection() {
        return belongsToCollection;
    }

    public Integer getBudget() {
        return budget;
    }

    public List<GenreJSONResult> getGenres() {
        return genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public Integer getId() {
        return id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public List<ProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public Integer getRuntime() {
        return runtime;
    }


    public String getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getVideo() {
        return video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

}
