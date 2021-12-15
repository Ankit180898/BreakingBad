package com.example.breakingbad.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.breakingbad.Adapter.CharacterAdapter;
import com.example.breakingbad.Adapter.ModelAdapter;
import com.example.breakingbad.R;
import com.example.breakingbad.ViewModel.CharacterModelViewModel;
import com.example.breakingbad.ViewModel.ModelViewModel;
import com.example.breakingbad.model.CharacterModel;
import com.example.breakingbad.model.Model;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

public class CharacterDescription extends AppCompatActivity {
    private RecyclerView rv;
    private List<CharacterModel> modelList;
    private CharacterAdapter adapter;
    private CharacterModelViewModel viewModel;
    private ShimmerFrameLayout mShimmerViewContainer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_description);
        mShimmerViewContainer = findViewById(R.id.shimmer_view_container1);
        modelList=new ArrayList<>();

        //recylerView for characters
        rv=findViewById(R.id.charRecycler);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        adapter=new CharacterAdapter(modelList,getApplicationContext());
        rv.setAdapter(adapter);

        //viewModel for characters
        viewModel = ViewModelProviders.of(this).get(CharacterModelViewModel.class);
        viewModel.getMoviesListObserver().observe(this, new Observer<List<CharacterModel>>() {
            @Override
            public void onChanged(List<CharacterModel> movieModels) {
                if(movieModels != null) {
                    modelList = movieModels;
                    mShimmerViewContainer.stopShimmer();
                    mShimmerViewContainer.setVisibility(View.GONE);
                    rv.setVisibility(View.VISIBLE);
                    adapter.setDataList(movieModels);
                }
            }
        });
        viewModel.makeApiCall();
    }
}