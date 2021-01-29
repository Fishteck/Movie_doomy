package android.example.moviedoomy.MoviesData.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GenresJSON {
    @SerializedName("genres")
    private List<GenreJSONResult> genres = null;

    public List<GenreJSONResult> getGenres() {
        return genres;
    }
}
