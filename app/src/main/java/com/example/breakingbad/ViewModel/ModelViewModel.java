package com.example.breakingbad.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breakingbad.api.ApiInterface;
import com.example.breakingbad.api.RetrofitInstance;
import com.example.breakingbad.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelViewModel extends ViewModel {

    private MutableLiveData<List<Model>> moviesList;

    public ModelViewModel(){
        moviesList = new MutableLiveData<>();
    }

    public MutableLiveData<List<Model>> getMoviesListObserver() {
        return moviesList;

    }

    //Retrofit
    public void makeApiCall() {
        ApiInterface apiService = RetrofitInstance.getClient().create(ApiInterface.class);
        Call<List<Model>> call = apiService.getData();
        call.enqueue(new Callback<List<Model>>() {

            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                moviesList.postValue(response.body());

                Log.d("TAG","Response = "+moviesList);
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                moviesList.postValue(null);
                Log.d("TAG","Response = "+t.toString());
            }
        });

    }
}
