package android.example.moviedoomy.MoviesData.entity.movieDetailedJSON;

import com.google.gson.annotations.SerializedName;

public class ProductionCompany {
    @SerializedName("id")
    private Integer id;
    @SerializedName("logo_path")
    private String logoPath;
    @SerializedName("name")
    private String name;
    @SerializedName("origin_country")
    private String originCountry;

    public Integer getId() {
        return id;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public String getName() {
        return name;
    }

    public String getOriginCountry() {
        return originCountry;
    }
}
