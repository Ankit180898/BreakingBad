package com.example.breakingbad.model;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Model {

    @SerializedName("title")
    String title;
    @SerializedName("season")
    String season;
    @SerializedName("episode")
    String episode;
    @SerializedName("air_date")
    String air_date;
    @SerializedName("characters")
    private List<String> characters = null;


    public Model(String title, String season, String episode, String air_date,List<String> characters ) {
        this.title = title;
        this.season = season;
        this.episode = episode;
        this.air_date = air_date;
        this.characters=characters;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }
}
