package com.example.utilisateur.anime.Controller;

import android.util.Log;
import com.example.utilisateur.anime.AnimeRestApi;
import com.example.utilisateur.anime.Model.Anime;
import com.example.utilisateur.anime.Model.RestAnimeResponse;
import com.example.utilisateur.anime.View.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainController {
    private MainActivity view;

    private AnimeRestApi animeRestApi;

    public MainController(MainActivity view, AnimeRestApi animeRestApi) {
        this.view = view;
        this.animeRestApi = animeRestApi;
    }

    public void start() {
        Call<RestAnimeResponse> call = animeRestApi.getPokemonList();
        call.enqueue(new Callback<RestAnimeResponse>() {
            @Override
            public void onResponse(Call<RestAnimeResponse> call, Response<RestAnimeResponse> response) {
                if(response.isSuccessful()) {
                    RestAnimeResponse restAnimeResponse = response.body();
                    List<Anime> animeList = restAnimeResponse.getTop();
                    view.showList(animeList);
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<RestAnimeResponse> call, Throwable t) {
                Log.d("API ERROR", "onFailure");
            }
        });
    }
}
