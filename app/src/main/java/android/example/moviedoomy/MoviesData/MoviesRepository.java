package android.example.moviedoomy.MoviesData;

import android.example.moviedoomy.MoviesData.entity.NewMoviesJSON;
import android.example.moviedoomy.MoviesData.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MoviesRepository {
    private List<Movie> cachedMovies = new ArrayList<>();
    private NewMoviesJSON moviesJSON;
    //this.cachedMovies.addAll(movies);
    public void addToCache( NewMoviesJSON newMoviesJSON) { this.moviesJSON = newMoviesJSON; }
}
