package android.example.moviedoomy.MoviesData.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewMoviesJSON {

    @SerializedName("page")
    private Integer page;
    @SerializedName("results")
    private List<NewMovieJSONResult> results = null;
    @SerializedName("total_pages")
    private Integer totalPages;
    @SerializedName("total_results")
    private Integer totalResults;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<NewMovieJSONResult> getResults() {
        return results;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }


}