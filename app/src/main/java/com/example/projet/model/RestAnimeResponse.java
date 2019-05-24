package com.example.projet.model;

import com.example.projet.model.Anime;

import java.util.List;

public class RestAnimeResponse {
    private Integer count;
    private List<Anime> results;

   public List<Anime> getResults() {
        return results;
    }
}
