package android.example.moviedoomy.MoviesData.entity;

import com.google.gson.annotations.SerializedName;

public class GenreJSONResult {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
