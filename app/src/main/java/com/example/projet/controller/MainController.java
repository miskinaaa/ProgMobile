package com.example.projet.controller;

import android.util.Log;

import com.example.projet.model.Anime;
import com.example.projet.AnimeRestApi;
import com.example.projet.view.MainActivity;

import java.util.List;

import com.example.projet.model.RestAnimeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainController {

    private MainActivity view;

    private AnimeRestApi animeRestApi;

    public MainController(MainActivity view, AnimeRestApi animeRestApi) {
        this.view = view;
        this.animeRestApi = animeRestApi;
    }

    public void start() {
        Call<RestAnimeResponse> call = animeRestApi.getAnimeList();
        call.enqueue(new Callback<RestAnimeResponse>() {
            @Override
            public void onResponse(Call<RestAnimeResponse> call, Response<RestAnimeResponse> response) {
                if(response.isSuccessful()) {
                    RestAnimeResponse restAnimeResponse = response.body();
                    List<Anime> animeList = restAnimeResponse.getResults();
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
