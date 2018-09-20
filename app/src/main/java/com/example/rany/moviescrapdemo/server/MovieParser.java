package com.example.rany.moviescrapdemo.server;

import android.os.AsyncTask;
import android.util.Log;

import com.example.rany.moviescrapdemo.callback.MovieCallback;
import com.example.rany.moviescrapdemo.model.Movie;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieParser extends AsyncTask<Void, Void, List<Movie>> {

    private static final String BASE_URL = "http://www.legend.com.kh";
    private static final String URL = BASE_URL + "/movies/nowshowing.aspx";
    private static final String DETAIL_URL = "http://www.legend.com.kh/movies/";
    public static final String TAG = "ooooo";
    private MovieCallback movieCallback;

    public MovieParser(MovieCallback movieCallback) {
        this.movieCallback = movieCallback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // loading .....................
        movieCallback.onPreExecute();
    }

    @Override
    protected List<Movie> doInBackground(Void... voids) {
        List<Movie> movieList = new ArrayList<>();
        try {
            Document document = Jsoup.connect(URL).get();
            Elements elements = document.select("div.ContentWrap div.row div.text-center");
            for(Element element : elements){
                String thumbnail = BASE_URL + element.select(
                        "div.box >img").get(0).attr("src");
                if(thumbnail.contains(" ")){
                    thumbnail = thumbnail.replaceAll(" ", "%20");
                }
                String description = element.select("span").html();
                // get title
                int position = description.indexOf("&nbsp");
                String title = description.substring(0, position);
                // get Sub title
                int subStart = description.indexOf("(sub:");
                int subEnd = description.indexOf(")<br>");
                String subTitle = description.substring(subStart + 5, subEnd);
                // get Detail url and duration
                String url = DETAIL_URL + element.select("div.InfoGroup >a").get(0).attr("href");
                int durStart = description.lastIndexOf("/");
                int durEnd = description.indexOf("Minutes");
                String duration = description.substring(durStart + 2, durEnd);

                movieList.add(new Movie(title, thumbnail, subTitle, duration, url));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    @Override
    protected void onPostExecute(List<Movie> movies) {
        super.onPostExecute(movies);
        movieCallback.onPostExecute(movies);
    }
}
