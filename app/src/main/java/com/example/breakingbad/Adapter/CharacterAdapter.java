package com.example.breakingbad.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.breakingbad.R;
import com.example.breakingbad.model.CharacterModel;
import com.example.breakingbad.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.MyViewHolder>{

    List<CharacterModel> characterModels=new ArrayList<>();
    Context context;

    public CharacterAdapter(List<CharacterModel> characterModels, Context context) {
        this.characterModels = characterModels;
        this.context = context;
    }

    @NonNull
    @Override
    public CharacterAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v= inflater.inflate(R.layout.character_recycler_items, parent, false);;
        return new MyViewHolder(v);
    }

    public void setDataList(List<CharacterModel> characterModels) {
        this.characterModels = characterModels;
        notifyDataSetChanged();
    }


    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.MyViewHolder holder, int position) {
        holder.characterName.setText(characterModels.get(position).getName());
        CharacterModel currentItem= characterModels.get(position);
        Glide.with(holder.characterImage.getContext()).load(currentItem.getImg()).into(holder.characterImage);
    }

    @Override
    public int getItemCount() {
        return characterModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView characterName;
        ImageView characterImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            characterImage=itemView.findViewById(R.id.charImg);
            characterName=itemView.findViewById(R.id.charName);
        }
    }
}
