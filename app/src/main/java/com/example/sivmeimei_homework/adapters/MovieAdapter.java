package com.example.sivmeimei_homework.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sivmeimei_homework.R;
import com.example.sivmeimei_homework.models.MovieModel;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<MovieModel> data;

    public MovieAdapter(List<MovieModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMovie;
        private TextView tvRating;
        private TextView tvAccessBadge;
        private TextView tvTitle;
        private TextView tvYear;
        private TextView tvDuration;
        private TextView tvAgeRating;
        private TextView tvGenre;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgMovie       = itemView.findViewById(R.id.imgMovie);
            this.tvRating       = itemView.findViewById(R.id.tvRating);
            this.tvAccessBadge  = itemView.findViewById(R.id.tvAccessBadge);
            this.tvTitle        = itemView.findViewById(R.id.tvTitle);
            this.tvYear         = itemView.findViewById(R.id.tvYear);
            this.tvDuration     = itemView.findViewById(R.id.tvDuration);
            this.tvAgeRating    = itemView.findViewById(R.id.tvAgeRating);
            this.tvGenre        = itemView.findViewById(R.id.tvGenre);
        }

        public void setData(MovieModel item) {
            imgMovie.setImageResource(item.getImageName());
            tvRating.setText(item.getRating());
            tvAccessBadge.setText(item.getAccessBadge());
            tvTitle.setText(item.getTitle());
            tvYear.setText(item.getYear());
            tvDuration.setText(item.getDuration());
            tvAgeRating.setText(item.getAgeRating());
            tvGenre.setText(item.getGenre());

            // set access badge bg color
            if(item.getAccessBadge().equals("Free")) {
                tvAccessBadge.setBackgroundResource(R.drawable.free_access_badge);
            } else if(item.getAccessBadge().equals("Premium")) {
                tvAccessBadge.setBackgroundResource(R.drawable.premium_access_badge);
            }
        }
    }
}
