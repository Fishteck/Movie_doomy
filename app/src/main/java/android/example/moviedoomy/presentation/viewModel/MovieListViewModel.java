package android.example.moviedoomy.presentation.viewModel;

import android.example.moviedoomy.App;
import android.example.moviedoomy.MoviesData.models.Movie;
import android.example.moviedoomy.domain.APIInteractor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MovieListViewModel extends ViewModel {
    private final String API_KEY = "8486e323ff1d52005b54543dda2d8ec4";
    private MutableLiveData<List<Movie>> moviesLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();
    private APIInteractor apiInteractor = App.getInstance().apiInteractor;

    public void onRestartGetMovies() {
        apiInteractor.getMovies(API_KEY, "ru", new APIInteractor.GetRepoCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                moviesLiveData.setValue(movies);
            }

            @Override
            public void onError(String error) {
                errorLiveData.setValue(error);
            }
        });
    }

    public LiveData<List<Movie>> getMovies() { return moviesLiveData; }
    public LiveData<String> getError() { return errorLiveData; }
}
