package com.example.rany.moviescrapdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.rany.moviescrapdemo.adapter.MovieAdapter;
import com.example.rany.moviescrapdemo.callback.MovieCallback;
import com.example.rany.moviescrapdemo.callback.OnMovieClickListener;
import com.example.rany.moviescrapdemo.model.Movie;
import com.example.rany.moviescrapdemo.server.MovieParser;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieCallback, OnMovieClickListener {

    private RecyclerView rcMovie;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcMovie = findViewById(R.id.rcMovie);
        GridLayoutManager manager = new GridLayoutManager(this, 2);

        rcMovie.setLayoutManager(manager);
        adapter = new MovieAdapter(this);
        adapter.onClickListener(this);
        rcMovie.setAdapter(adapter);
        new MovieParser(this).execute();
    }
    @Override
    public void onPreExecute() {
        // loading
    }

    @Override
    public void onPostExecute(List<Movie> movieList) {
        adapter.addMovie(movieList);
        for(Movie  movie : movieList){
            Log.e("ooooo", movie.getTitle() );
        }
    }

    @Override
    public void onDetailClick(String url) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }
}
