package com.example.spotify_descripcion.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Beans.Canciones;
import com.example.spotify_android.R;
import com.example.spotify_descripcion.presenter.DescripcionPresenter;
import com.example.spotify_galery.ContractListGalery;

import java.util.ArrayList;

public class DescripcionView  extends AppCompatActivity implements ContractListGalery.View{

    private DescripcionPresenter presenter= new DescripcionPresenter(this);

    private static DescripcionView mainActivity = null;

    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galery_spotify);
        mainActivity = this;
        initComponents();
    }
    private void initComponents() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        presenter.lstGalery(id);
    }
    @Override
    public void success(ArrayList<Canciones> lstCanciones) {

    }

    @Override
    public void failure(String err) {

    }
}
