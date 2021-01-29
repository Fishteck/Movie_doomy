package android.example.moviedoomy.presentation.viewModel;

import android.example.moviedoomy.App;
import android.example.moviedoomy.MoviesData.entity.GenreJSONResult;
import android.example.moviedoomy.MoviesData.models.Movie;
import android.example.moviedoomy.MoviesData.models.MovieDetailed;
import android.example.moviedoomy.R;
import android.example.moviedoomy.domain.APIInteractor;
import android.example.moviedoomy.presentation.view.activity.MainActivity;
import android.example.moviedoomy.presentation.view.fragments.MovieDetailedFragment;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MovieListViewModel extends ViewModel {
    private MutableLiveData<List<Movie>> moviesLiveData = new MutableLiveData<>();
    private MutableLiveData<List<GenreJSONResult>> genresLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();
    private MutableLiveData<MovieDetailed> movieDetailedLiveData = new MutableLiveData<>();
    private APIInteractor apiInteractor = App.getInstance().apiInteractor;



    public void onRestartGetMovies() {

        apiInteractor.getMovies( new APIInteractor.GetRepoCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                moviesLiveData.setValue(movies);
            }

            @Override
            public void onError(String error) {
                errorLiveData.setValue(error);
            }
        });
        apiInteractor.getGenres( new APIInteractor.GetGenresCallback() {
            @Override
            public void onSuccess(List<GenreJSONResult> genres) {
                genresLiveData.setValue(genres);
            }

            @Override
            public void onError(String error) {
                errorLiveData.setValue(error);
            }
        });
    }


    public void onMovieClick(String id) {
        apiInteractor.getDetailedMovie(id, new APIInteractor.GetDetailedMovieCallback() {
            @Override
            public void onSuccess(MovieDetailed movie) {
                movieDetailedLiveData.setValue(movie);
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.activity_main__content_fragment, new MovieDetailedFragment(), MovieDetailedFragment.TAG)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(null)
                        .commit();
            }

            @Override
            public void onError(String error) {
                errorLiveData.setValue(error);
            }
        });
    }

    public LiveData<List<Movie>> getMovies() { return moviesLiveData; }
    public LiveData<String> getError() { return errorLiveData; }
    public LiveData<MovieDetailed> getDetaileMovie() { return movieDetailedLiveData; }
}
