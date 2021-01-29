package android.example.moviedoomy.domain;

import android.example.moviedoomy.MoviesData.MovieDBService;
import android.example.moviedoomy.MoviesData.entity.GenreJSONResult;
import android.example.moviedoomy.MoviesData.entity.GenresJSON;
import android.example.moviedoomy.MoviesData.entity.NewMovieJSONResult;
import android.example.moviedoomy.MoviesData.entity.NewMoviesJSON;
import android.example.moviedoomy.MoviesData.entity.movieDetailedJSON.MovieDetailedJSON;
import android.example.moviedoomy.MoviesData.models.Movie;
import android.example.moviedoomy.MoviesData.models.MovieDetailed;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class APIInteractor {

    private static final String API_KEY = "8486e323ff1d52005b54543dda2d8ec4";
    private static final String LANGUAGE_RU = "ru";
    private static final String LANGUAGE_EN = "en";
    private MovieDBService movieDBService;
    private static Map<Integer, String> genresMap = new HashMap<>();

    public APIInteractor(MovieDBService movieDBService) {
        this.movieDBService = movieDBService;
    }

    public void getDetailedMovie(String id, final GetDetailedMovieCallback callback) {
        movieDBService.getDetailedMovie(id, API_KEY, LANGUAGE_RU)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<MovieDetailedJSON>() {
                    @Override
                    public void onSuccess(@NonNull MovieDetailedJSON movieDetailedJSON) {
                        callback.onSuccess(new MovieDetailed(movieDetailedJSON));
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.onError("Error : " + e.getClass().getSimpleName());
                    }
                });
    }

    public void getGenres(final GetGenresCallback callback) {
        movieDBService.getGenres(API_KEY, LANGUAGE_RU)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<GenresJSON>() {
                    @Override
                    public void onSuccess(@NonNull GenresJSON genresJSON) {
                        genresMap.clear();
                        for (GenreJSONResult el : genresJSON.getGenres()) {
                            genresMap.put(el.getId(), el.getName());
                        }
                        callback.onSuccess(genresJSON.getGenres());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.onError("Error : " + e.getClass().getSimpleName());
                    }
                });
    }

    public void getMovies(final GetRepoCallback callback) {
        movieDBService.getMovies("movie", API_KEY, LANGUAGE_RU)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<NewMoviesJSON>() {
                    @Override
                    public void onSuccess(@NonNull NewMoviesJSON newMoviesJSON) {
                        List<Movie> tmpMoviesList = new ArrayList<>();
                        for (NewMovieJSONResult el : newMoviesJSON.getResults()) {
                            tmpMoviesList.add(new Movie(el, genresMap));
                        }

                        callback.onSuccess(tmpMoviesList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.onError("Error : " + e.getClass().getSimpleName());
                        Log.d("interactor", e.getMessage());
                    }
                });
    }
    public interface GetRepoCallback {
        void onSuccess(List<Movie> movies);
        void onError(String error);
    }
    public interface GetGenresCallback {
        void onSuccess(List<GenreJSONResult> genres);
        void onError(String error);
    }
    public interface GetDetailedMovieCallback {
        void onSuccess(MovieDetailed movie);
        void onError(String error);
    }
}
