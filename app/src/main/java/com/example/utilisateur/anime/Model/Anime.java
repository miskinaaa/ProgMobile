package com.example.utilisateur.anime.Model;

import java.io.Serializable;

public class Anime implements Serializable {
    private String title;
    private String score;
    private String image_url;
    private String start_date;
    private String end_date;
    private String episodes ;
    private String rank ;
    private String type ;


    public Anime() {
    }

    public String getTitle() {
        return title;
    }

    public String getScore() {
        return score;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getEpisodes() {
        return episodes;
    }

    public String getType() {
        return type;
    }
    public String getRank() {
        return rank;
    }
}