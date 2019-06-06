package com.example.utilisateur.anime.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.utilisateur.anime.Model.Anime;
import com.example.utilisateur.anime.R;
import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    private TextView title;
    private TextView start_date;
    private TextView end_date;
    private TextView type;
    private TextView score;
    private TextView episodes;
    private TextView rank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Anime anime = (Anime) getIntent().getSerializableExtra("Anime");


        ImageView productImageView = findViewById(R.id.imageView);
        title = findViewById(R.id.titre);
        start_date = findViewById(R.id.start_date);
        end_date = findViewById(R.id.end_date);
        type = findViewById(R.id.type);
        score = findViewById(R.id.score);
        episodes = findViewById(R.id.episode);
        rank = findViewById(R.id.rank);

        title.setText(anime.getTitle());
        start_date.setText(anime.getStart_date());
        end_date.setText(anime.getEnd_date());
        type.setText(anime.getType());
        episodes.setText(anime.getEpisodes());
        score.setText(anime.getScore());
        rank.setText(anime.getRank());
        Picasso.get().load(anime.getImage_url()).into(productImageView);

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

