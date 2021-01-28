package android.example.moviedoomy.MoviesData;

import android.example.moviedoomy.MoviesData.entity.NewMoviesJSON;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDBService {
    @GET("now_playing?")
     Single<NewMoviesJSON> getMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language
    );
}
