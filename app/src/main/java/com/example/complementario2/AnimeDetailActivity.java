package com.example.complementario2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class AnimeDetailActivity extends AppCompatActivity {
    ImageView animeImage;
    TextView animeDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_anime);
        Anime anime = (Anime) getIntent().getSerializableExtra("animedetail");
        animeImage = (ImageView) findViewById(R.id.animeImage);
        animeDescription = (TextView) findViewById(R.id.animeDescription);

        animeDescription.setText(anime.getDescription());
        Glide.with(this).load(anime.getImg()).fitCenter().bitmapTransform(new
                CropCircleTransformation(this)).into(animeImage);
    }
}

