package com.example.utilisateur.anime.Controller;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.example.utilisateur.anime.AnimeRestApi;
import com.example.utilisateur.anime.Model.Anime;
import com.example.utilisateur.anime.Model.RestAnimeResponse;
import com.example.utilisateur.anime.View.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainController {
    private MainActivity view;
    private AnimeRestApi animeRestApi;
    private SharedPreferences sharedPreferences;

    public MainController(MainActivity view, AnimeRestApi animeRestApi, SharedPreferences sharedPreferences) {
        this.view = view;
        this.animeRestApi = animeRestApi;
        this.sharedPreferences = sharedPreferences;
    }

    public void start() {
        Call<RestAnimeResponse> call = animeRestApi.getAnimeList();
        call.enqueue(new Callback<RestAnimeResponse>() {
            @Override
            public void onResponse(Call<RestAnimeResponse> call, Response<RestAnimeResponse> response) {
                if(response.isSuccessful()) {
                    RestAnimeResponse restAnimeResponse = response.body();
                    List<Anime> animeList = restAnimeResponse.getTop();
                    storeData(animeList);
                    view.showList(animeList);
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<RestAnimeResponse> call, Throwable t) {
                Log.d("API ERROR", "onFailure");
                List<Anime> animeList = getDataFromCache();
                view.showList(animeList);
            }
        });
    }

    private void storeData(List<Anime> animeList) {
        Gson gson = new Gson();
        String listAnimeString = gson.toJson(animeList);
        sharedPreferences
                .edit()
                .putString("cle_string", listAnimeString)
                .apply();
    }

    private List<Anime> getDataFromCache() {
        String listAnimeString = sharedPreferences.getString("cle_string", "");
        if(listAnimeString != null && !TextUtils.isEmpty(listAnimeString)){
            Type listType = new TypeToken<List<Anime>>(){}.getType();
            List<Anime> animeList = new Gson().fromJson(listAnimeString, listType);
            return animeList;
        }
        return new ArrayList<>();
    }




}
