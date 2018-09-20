package com.example.rany.moviescrapdemo.callback;

import com.example.rany.moviescrapdemo.model.Movie;

import java.util.List;

public interface MovieCallback {
    void onPreExecute();
    void onPostExecute(List<Movie> movieList);

}
