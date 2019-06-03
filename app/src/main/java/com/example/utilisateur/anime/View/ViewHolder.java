package com.example.utilisateur.anime.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.utilisateur.anime.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView txtFirstLine;
    public TextView txtFooter;
    public ImageView img;
    public View layout;

    public ViewHolder(View v) {
        super(v);
        layout = v;
        txtFirstLine = (TextView) v.findViewById(R.id.firstLine);
        txtFooter = (TextView) v.findViewById(R.id.secondLine);
        img = v.findViewById(R.id.icon);
    }
}
