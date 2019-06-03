package com.example.utilisateur.anime.View;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.utilisateur.anime.Model.Anime;
import com.example.utilisateur.anime.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Anime> animeList;

    public void add(int position, Anime item) {
        animeList.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        animeList.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Anime> myDataset) {
        animeList = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Anime currentAnime = animeList.get(position);
        ImageView imageView = holder.img;
        Picasso.get().load(currentAnime.getImage_url()).into(imageView);
        holder.txtFirstLine.setText(currentAnime.getTitle());
        holder.txtFooter.setText("Score: " + currentAnime.getScore());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return animeList.size();
    }

}

