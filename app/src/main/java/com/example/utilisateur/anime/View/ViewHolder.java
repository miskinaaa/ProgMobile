package com.example.utilisateur.anime.View;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.utilisateur.anime.Model.Anime;
import com.example.utilisateur.anime.R;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtFirstLine;
    public TextView txtFooter;
    public ImageView img;
    public View layout;
    public Anime curr_anime = new Anime();


    public ViewHolder(View v) {
        super(v);
        layout = v;
        txtFirstLine = (TextView) v.findViewById(R.id.firstLine);
        txtFooter = (TextView) v.findViewById(R.id.secondLine);
        img = v.findViewById(R.id.icon);
        itemView.setClickable(true);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), SecondActivity.class);
        intent.putExtra("Anime", curr_anime);
        v.getContext().startActivity(intent);
    }

    /*public void setCurr_anime(Anime curr_anime) {
        this.curr_anime = curr_anime;
    }*/
}
