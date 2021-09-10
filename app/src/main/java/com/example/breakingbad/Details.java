package com.example.breakingbad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.breakingbad.databinding.ActivityDetailsBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class Details extends AppCompatActivity {
    ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_details);


        // Recieve data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("title");
        String Episode = intent.getExtras().getString("episode");
        String Season=intent.getExtras().getString("season");
        String Air_date=intent.getExtras().getString("air_date");
        ArrayList<String> test = (ArrayList<String>) getIntent().getSerializableExtra("characters");
        String str1= Arrays.toString(new ArrayList[]{test}).replace("[[", "").replace("]]", "");




        // Setting values

        binding.title1.setText(Title);
        binding.episode1.setText(Episode);
        binding.season1.setText(Season);
        binding.airDate.setText(Air_date);
        binding.names.setText(str1);

    }
}