package com.example.utilisateur.anime.View;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.utilisateur.anime.Controller.MainController;
import com.example.utilisateur.anime.Injection;
import com.example.utilisateur.anime.Model.Anime;
import com.example.utilisateur.anime.R;

import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        MainController controller = new MainController(this, Injection.getRestApiInstance(), sharedPreferences);
        controller.start();
    }

    public void showList(List<Anime> animeList) {
        //Initialisation de la variable recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        //Optimisation des performances
        recyclerView.setHasFixedSize(true);
        // Layout Manager = Manage l'affichage
        //Initialisation de la variable layoutManager
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        //Initialisation de la variable mAdapter
        mAdapter = new MyAdapter(animeList);
        recyclerView.setAdapter(mAdapter);
    }
}
