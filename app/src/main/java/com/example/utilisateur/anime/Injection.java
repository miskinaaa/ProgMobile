package com.example.utilisateur.anime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {
    static final String BASE_URL = "https://api.jikan.moe/v3/top/";
    static AnimeRestApi animeRestApi;

    public static AnimeRestApi getRestApiInstance(){
        if(animeRestApi == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            animeRestApi = retrofit.create(AnimeRestApi.class);
        }


        return animeRestApi;
    }
}

