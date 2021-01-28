package android.example.moviedoomy;

import android.app.Application;
import android.example.moviedoomy.MoviesData.MovieDBService;
import android.example.moviedoomy.MoviesData.MoviesRepository;
import android.example.moviedoomy.domain.APIInteractor;
import android.util.Log;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private static App instance;
    public MovieDBService movieDBService;
    public APIInteractor apiInteractor;
    public MoviesRepository moviesRepository = new MoviesRepository();
    public static final String BASE_URL = "http://api.themoviedb.org/3/movie/";

    public static App getInstance() { return instance; }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("interactor", "app");
        instance = this;
        initRetrofit();
        initInteractor();
    }

    private void initInteractor() {
        apiInteractor = new APIInteractor(movieDBService, moviesRepository);
    }

    private void initRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        movieDBService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieDBService.class);
    }
}
