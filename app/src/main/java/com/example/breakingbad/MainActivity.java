package com.example.breakingbad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.breakingbad.Adapter.ModelAdapter;
import com.example.breakingbad.ViewModel.ModelViewModel;
import com.example.breakingbad.model.Model;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private List<Model> modelList;
    private ModelAdapter adapter;
    private ModelViewModel viewModel;
    private ShimmerFrameLayout mShimmerViewContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShimmerViewContainer=findViewById(R.id.shimmer_view_container);
        modelList=new ArrayList<>();

        //recyclerView
        rv=findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter=new ModelAdapter(getApplicationContext(),modelList);
        rv.setAdapter(adapter);

        //viewModel
        viewModel = ViewModelProviders.of(this).get(ModelViewModel.class);
        viewModel.getMoviesListObserver().observe(this, new Observer<List<Model>>() {
            @Override
            public void onChanged(List<Model> movieModels) {
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


