package com.example.breakingbad.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breakingbad.Details;
import com.example.breakingbad.R;
import com.example.breakingbad.model.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.MyViewHolder> {

    List<Model> modelLists=new ArrayList<>();
    Context context;

    public ModelAdapter(Context context,List<Model> modelList) {

        this.context=context;
        this.modelLists = modelList;
    }

    @NonNull
    @Override
    public ModelAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v= inflater.inflate(R.layout.list_items, parent, false);;
        return new MyViewHolder(v);
    }

    public void setDataList(List<Model> modelList) {
        this.modelLists = modelList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ModelAdapter.MyViewHolder holder, int position) {

        holder.episode.setText(modelLists.get(position).getEpisode());
        holder.title.setText(modelLists.get(position).getTitle());
        holder.season.setText(modelLists.get(position).getSeason());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Details.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                // passing data to the Details activity
                intent.putExtra("title",modelLists.get(position).getTitle());
                intent.putExtra("episode",modelLists.get(position).getEpisode());
                intent.putExtra("season",modelLists.get(position).getSeason());
                intent.putExtra("air_date",modelLists.get(position).getAir_date());
                //List of characters
                intent.putStringArrayListExtra("characters", (ArrayList<String>) modelLists.get(position).getCharacters());

                // start the activity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,season,episode;
        CardView linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.listview);
            title=itemView.findViewById(R.id.title1);
            season=itemView.findViewById(R.id.season1);
            episode=itemView.findViewById(R.id.episode1);
        }
    }
}
