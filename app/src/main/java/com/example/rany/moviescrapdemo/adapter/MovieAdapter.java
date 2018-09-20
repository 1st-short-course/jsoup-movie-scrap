package com.example.rany.moviescrapdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rany.moviescrapdemo.R;
import com.example.rany.moviescrapdemo.callback.OnMovieClickListener;
import com.example.rany.moviescrapdemo.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> movieList;
    private Context context;
    private OnMovieClickListener listener;

    public MovieAdapter(Context context) {
        this.context = context;
        movieList = new ArrayList<>();
    }

    public void onClickListener(OnMovieClickListener listener){
        this.listener = listener;
    }

    public void addMovie(List<Movie> movies){
        this.movieList.addAll(movies);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
          R.layout.movie_item, parent, false
        );
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.title.setText(movie.getTitle());
        holder.duration.setText(movie.getDuration()+ "min");
        holder.subTitle.setText(movie.getSubTitle());
        Picasso.get()
                .load(movie.getThumbnail())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{

        CircleImageView thumbnail;
        TextView title, duration, subTitle;
        public MovieViewHolder(View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.mvThumbnail);
            title = itemView.findViewById(R.id.mvTitle);
            subTitle = itemView.findViewById(R.id.mvSubTitle);
            duration = itemView.findViewById(R.id.mvDuration);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onDetailClick(movieList.get(getAdapterPosition()).getUrl());
                }
            });
        }
    }

}
