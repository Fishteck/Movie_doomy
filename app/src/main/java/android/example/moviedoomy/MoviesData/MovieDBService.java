package android.example.moviedoomy.MoviesData;

import android.example.moviedoomy.MoviesData.entity.GenresJSON;
import android.example.moviedoomy.MoviesData.entity.NewMoviesJSON;
import android.example.moviedoomy.MoviesData.entity.movieDetailedJSON.MovieDetailedJSON;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieDBService {
    @GET("{path}/now_playing?")
     Single<NewMoviesJSON> getMovies(
             @Path("path") String path,
             @Query("api_key") String apiKey,
             @Query("language") String language
    );
    @GET("genre/movie/list?")
    Single<GenresJSON> getGenres(
            @Query("api_key") String apiKey,
            @Query("language") String language
    );
    @GET("movie/{id}?")
    Single<MovieDetailedJSON> getDetailedMovie(
            @Path("id") String id,
            @Query("api_key") String apiKey,
            @Query("language") String language
    );
}
