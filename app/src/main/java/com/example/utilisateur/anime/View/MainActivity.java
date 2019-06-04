package com.example.utilisateur.anime.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        //sets the layout of the activity to activity_main.xml
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
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        recyclerView.setLayoutManager(layoutManager);

        //Initialisation de la variable mAdapter
        mAdapter = new MyAdapter(animeList);
        recyclerView.setAdapter(mAdapter);
    }


    public void clickMe(View view) {
        TextView textView = (TextView) view.findViewById(R.id.firstLine);
        if (textView != null) {
            Toast.makeText(this, textView.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        Intent secondeActivite = new Intent(MainActivity.this, SecondActivity.class);
        // Puis on lance l'intent !
        startActivity(secondeActivite);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
