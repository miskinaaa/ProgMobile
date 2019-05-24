package com.example.projet;

import com.example.projet.model.RestAnimeResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;


public interface AnimeRestApi {
    @GET("films")
    Call<RestAnimeResponse> getAnimeList();
}
