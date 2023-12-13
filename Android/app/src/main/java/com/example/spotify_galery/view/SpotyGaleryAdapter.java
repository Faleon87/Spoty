package com.example.spotify_galery.view;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.Beans.Canciones;
import com.example.spotify_android.R;

import java.util.ArrayList;
import java.util.List;

public class SpotyGaleryAdapter extends BaseAdapter {

    Context context;

    List<Canciones> canciones = new ArrayList<>();
    LayoutInflater inflater;

    public SpotyGaleryAdapter(Context context , List<Canciones> canciones) {
        this.context = context;
        this.canciones = canciones;
    }

    @Override
    public int getCount() {
        return canciones.size();
    }

    @Override
    public Object getItem(int position) {
        return canciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){

            convertView = inflater.inflate(R.layout.grid_item,null);

        }

        ImageButton imageButton = convertView.findViewById(R.id.grid_image);
        TextView textView = convertView.findViewById(R.id.item_name);
        Canciones cancion = canciones.get(position);
       textView.setText(cancion.getTitulo());
       Glide.with(context).load(cancion.getUrl_imagen()).into(imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SpotyGaleryView.class);
                intent.putExtra("cancion", cancion.getId());
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
