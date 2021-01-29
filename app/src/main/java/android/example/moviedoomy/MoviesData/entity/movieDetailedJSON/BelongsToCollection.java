package android.example.moviedoomy.MoviesData.entity.movieDetailedJSON;

import com.google.gson.annotations.SerializedName;

public class BelongsToCollection {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("backdrop_path")
    private String backdropPath;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }
}
