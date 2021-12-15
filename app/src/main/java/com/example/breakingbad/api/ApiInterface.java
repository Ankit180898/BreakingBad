package com.example.breakingbad.api;

import com.example.breakingbad.model.CharacterModel;
import com.example.breakingbad.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("episodes?series=Breaking+Bad")
    Call<List<Model>> getData();

    @GET("characters")
    Call<List<CharacterModel>> getAllCharacters();




}
