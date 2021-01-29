package android.example.moviedoomy.presentation.view.fragments;

import android.example.moviedoomy.MoviesData.models.Movie;
import android.example.moviedoomy.R;
import android.example.moviedoomy.presentation.viewModel.MovieListViewModel;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;


public class NewMoviesFragment extends Fragment {
    public static final String TAG = "NewMoviesListFragment";
    private MovieListViewModel viewModel;
    private RecyclerView recyclerView;
    private MoviesNewRecyclerAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_movies, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initRecycler();

        viewModel = ViewModelProviders.of(getActivity()).get(MovieListViewModel.class);
        viewModel.getMovies().observe(getViewLifecycleOwner(), movies -> adapter.setMovies(movies));
        viewModel.onRestartGetMovies();

    }

    private void initRecycler() {
        adapter = new MoviesNewRecyclerAdapter(LayoutInflater.from(getContext()), id -> {
            viewModel.onMovieClick(id);
        });
        recyclerView = getView().findViewById(R.id.fragment_new_movies_recycler_view);
        recyclerView.setAdapter(adapter);
    }

    public static class MoviesNewRecyclerHolder extends RecyclerView.ViewHolder {

        public ImageView imageViewPoster;
        public TextView textViewTitle;
        public TextView textViewRating;
        public TextView textViewQuantityRating;
        public TextView textViewReleaseDate;
        public TextView textViewGenres;
        public TextView textViewOriginalTitle;

        public MoviesNewRecyclerHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPoster = itemView.findViewById(R.id.item_movie__poster);
            textViewTitle = itemView.findViewById(R.id.item_movie__title);
            textViewRating = itemView.findViewById(R.id.item_movie__rating);
            textViewQuantityRating = itemView.findViewById(R.id.item_movie__rating_quantity);
            textViewReleaseDate = itemView.findViewById(R.id.item_movie__rating_release_date);
            textViewGenres = itemView.findViewById(R.id.item_movie__genres);
            textViewOriginalTitle = itemView.findViewById(R.id.item_movie__original_title);


        }
    }

    public static class MoviesNewRecyclerAdapter extends RecyclerView.Adapter<MoviesNewRecyclerHolder>{

        private List<Movie> movies = new ArrayList<>();
        private LayoutInflater inflater;
        private OnMovieSelectedListener listener;

        public MoviesNewRecyclerAdapter(LayoutInflater inflater, OnMovieSelectedListener listener) {

            this.inflater = inflater;
            this.listener = listener;
        }

        public void setMovies(List<Movie> movies) {
            this.movies.clear();
            this.movies.addAll(movies);
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public MoviesNewRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MoviesNewRecyclerHolder(inflater.inflate(R.layout.item_movie, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MoviesNewRecyclerHolder holder, int position) {
            final Movie movie = movies.get(position);

            holder.itemView.setOnClickListener(v -> listener.onMovieSelect(movie.getId()+""));
            Picasso.get()
                    .load(movie.getPoster())
                    .transform(new RoundedCornersTransformation(15, 0, RoundedCornersTransformation.CornerType.ALL))
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(holder.imageViewPoster);
            holder.textViewTitle.setText(movie.getTitle());
            holder.textViewReleaseDate.setText(movie.getReleaseDate());
            holder.textViewGenres.setText(movie.getGenre());
            holder.textViewOriginalTitle.setText(movie.getOriginalTitle());
            if (movie.getRating() == 0) {
                holder.textViewRating.setText("0");
            } else  holder.textViewRating.setText(String.format("%.1f",movie.getRating()));

            if (movie.getQuantityRating() == 0) {
                holder.textViewQuantityRating.setText("0");
            } else  holder.textViewQuantityRating.setText(movie.getQuantityRating() + "");
        }

        @Override
        public int getItemCount() {
            return movies.size();
        }

        public interface OnMovieSelectedListener {
            void onMovieSelect(String id);
        }
    }
}


