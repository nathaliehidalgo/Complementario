package com.example.complementario2;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AnimeAdapter extends
        RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {
    ArrayList<Anime> animes = new ArrayList<>();
    Context context;

    public AnimeAdapter(ArrayList<Anime> anime, Context context) {
        this.animes = anime;
        this.context = context;
    }

    @Override

    public AnimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.anime_row, parent, false);
        return new AnimeViewHolder(row);
    }

    @Override
    public void onBindViewHolder(AnimeViewHolder holder, final int position) {
        Anime anime = animes.get(position);

        Picasso.get().load(anime.getImg()).into(holder.imageLogo);
        holder.animeDescription.setText(anime.getDescription());
        holder.animeName.setText(anime.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AnimeDetailActivity.class);
                intent.putExtra("animedetail", (Parcelable) animes.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public static class AnimeViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageLogo;
        private TextView animeName;
        private TextView animeDescription;

        public AnimeViewHolder(View itemView) {
            super(itemView);
            imageLogo = (ImageView) itemView.findViewById(R.id.animeImage);
            animeName = (TextView) itemView.findViewById(R.id.animeName);
            animeDescription = (TextView)
                    itemView.findViewById(R.id.animeDescription);
        }

        public ImageView getImageLogo() {
            return imageLogo;
        }

        public void setImageLogo(ImageView imageLogo) {
            this.imageLogo = imageLogo;

        }

        public TextView getAnimeName() {
            return animeName;
        }

        public void setAnimeName(TextView animeName) {
            this.animeName = animeName;
        }

        public TextView getAnimeDescription() {
            return animeDescription;
        }

        public void setAnimeDescription(TextView animeDescription) {
            this.animeDescription = animeDescription;
        }
    }
}
