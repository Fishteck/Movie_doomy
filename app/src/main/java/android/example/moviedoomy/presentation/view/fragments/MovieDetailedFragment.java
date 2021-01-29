package android.example.moviedoomy.presentation.view.fragments;

import android.example.moviedoomy.MoviesData.models.MovieDetailed;
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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;


public class MovieDetailedFragment extends Fragment {
    public final static String TAG = "MovieDetailedFragment";
    private MovieListViewModel viewModel;
    private TextView title;
    private ImageView poster;
    private TextView originalTitle;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_movie_detailed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.fragment_movie_detailed__title);
        poster = view.findViewById(R.id.fragment_movie_poster);
        originalTitle = view.findViewById(R.id.fragment_movie_detailed__original_title);

        viewModel = ViewModelProviders.of(getActivity()).get(MovieListViewModel.class);
        viewModel.getDetaileMovie().observe(getViewLifecycleOwner(), new Observer<MovieDetailed>() {
            @Override
            public void onChanged(MovieDetailed movieDetailed) {
                Picasso.get()
                        .load(movieDetailed.getPoster())
                        .transform(new RoundedCornersTransformation(15, 0, RoundedCornersTransformation.CornerType.ALL))
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .into(poster);
                title.setText(movieDetailed.getTitle());
                originalTitle.setText(movieDetailed.getOriginalTitle());

            }
        });



    }



}
