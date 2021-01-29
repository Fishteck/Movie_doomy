package android.example.moviedoomy.presentation.view.activity;

import android.example.moviedoomy.R;
import android.example.moviedoomy.presentation.view.fragments.NewMoviesFragment;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main__content_fragment, new NewMoviesFragment(), NewMoviesFragment.TAG)
                .commit();

    }



}