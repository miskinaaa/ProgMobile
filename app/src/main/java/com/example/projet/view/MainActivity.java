package com.example.projet.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.projet.model.Anime;
import com.example.projet.Injection;
import com.example.projet.R;
import com.example.projet.controller.MainController;

import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainController controller = new MainController(this, Injection.getRestApiInstance());
        controller.start();
    }

    public void showList(List<Anime> pokemonList) {
        //Initialisation de la variable recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        //Optimisation des performances
        recyclerView.setHasFixedSize(true);

        //Initialisation de la variable layoutManager
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        //Initialisation de la variable mAdapter
        mAdapter = new MyAdapter(pokemonList);
        recyclerView.setAdapter(mAdapter);
    }
}
