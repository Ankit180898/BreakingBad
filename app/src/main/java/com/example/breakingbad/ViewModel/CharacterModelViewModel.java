package com.example.breakingbad.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.breakingbad.api.ApiInterface;
import com.example.breakingbad.api.RetrofitInstance;
import com.example.breakingbad.model.CharacterModel;
import com.example.breakingbad.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterModelViewModel extends ViewModel {

    private MutableLiveData<List<CharacterModel>> moviesList;

    public CharacterModelViewModel(){
        moviesList = new MutableLiveData<>();
    }

    public MutableLiveData<List<CharacterModel>> getMoviesListObserver() {
        return moviesList;

    }

    //Retrofit
    public void makeApiCall() {
        ApiInterface apiService = RetrofitInstance.getClient().create(ApiInterface.class);
        Call<List<CharacterModel>> call = apiService.getAllCharacters();
        call.enqueue(new Callback<List<CharacterModel>>() {

            @Override
            public void onResponse(Call<List<CharacterModel>> call, Response<List<CharacterModel>> response) {
                moviesList.postValue(response.body());

                Log.d("TAG","Response = "+moviesList);
            }

            @Override
            public void onFailure(Call<List<CharacterModel>> call, Throwable t) {
                moviesList.postValue(null);
                Log.d("TAG","Response = "+t.toString());
            }
        });

    }


}
