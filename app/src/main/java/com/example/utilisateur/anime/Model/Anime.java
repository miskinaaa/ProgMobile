package com.example.utilisateur.anime.Model;

import java.io.Serializable;

public class Anime implements Serializable {
    //@SerializedName("title_sr")
    private String title;
    //@SerializedName("score_sr")
    private String score;
   // @SerializedName("image_url_sr")
    private String image_url;
    //@SerializedName("start_date_sr")
    private String start_date;
    //@SerializedName("end_date_sr")
    private String end_date;
   // @SerializedName("episodes_sr")
    private String episodes ;
    //@SerializedName("rank_sr")
    private String rank ;
    //@SerializedName("type_sr")
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