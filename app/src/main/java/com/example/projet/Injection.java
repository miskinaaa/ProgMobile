package com.example.projet;

import com.example.projet.model.RestAnimeResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {


    public static final String BASE_URL = "https://ghibliapi.herokuapp.com/";
    public static Retrofit retrofit;


    public static AnimeRestApi getRestApiInstance(){
        //Debut creation instance de l'interface PokemonRestApi
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //FIN creation instance de l'interface PokemonRestApi
        return retrofit.create(AnimeRestApi.class);
    }
}
