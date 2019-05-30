package com.example.utilisateur.anime;

import com.example.utilisateur.anime.Model.RestAnimeResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimeRestApi {
    @GET("anime")
    Call<RestAnimeResponse> getPokemonList();
}
