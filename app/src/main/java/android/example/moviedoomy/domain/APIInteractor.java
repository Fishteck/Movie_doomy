package android.example.moviedoomy.domain;
import android.example.moviedoomy.MoviesData.MovieDBService;
import android.example.moviedoomy.MoviesData.MoviesRepository;
import android.example.moviedoomy.MoviesData.entity.NewMovieJSONResult;
import android.example.moviedoomy.MoviesData.entity.NewMoviesJSON;
import android.example.moviedoomy.MoviesData.models.Movie;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class APIInteractor {
    private MovieDBService movieDBService;
    private MoviesRepository moviesRepository;

    public APIInteractor(MovieDBService movieDBService, MoviesRepository moviesRepository) {
        this.movieDBService = movieDBService;
        this.moviesRepository = moviesRepository;
        Log.d("interactor", "111111");
    }

    public void getMovies(String apiKey, String language, final GetRepoCallback callback) {
        movieDBService.getMovies(apiKey, language)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<NewMoviesJSON>() {
                    @Override
                    public void onSuccess(@NonNull NewMoviesJSON newMoviesJSON) {
                        moviesRepository.addToCache(newMoviesJSON);
                        List<Movie> tmpMoviesList = new ArrayList<>();
                        for (NewMovieJSONResult el : newMoviesJSON.getResults()) {
                            tmpMoviesList.add(new Movie(el));
                        }
                        callback.onSuccess(tmpMoviesList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.onError("Error");
                        Log.d("interactor", e.getMessage());
                    }
                });
    }
    public interface GetRepoCallback {
        void onSuccess(List<Movie> movies);
        void onError(String error);
    }
}
