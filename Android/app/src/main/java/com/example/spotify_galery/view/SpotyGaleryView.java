package com.example.spotify_galery.view;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.Beans.Canciones;
import com.example.spotify_android.R;
import com.example.spotify_galery.ContractListGalery;
import com.example.spotify_galery.presenter.SpotyGaleryPresenter;

import java.util.ArrayList;

public class SpotyGaleryView  extends AppCompatActivity implements ContractListGalery.View {

    private SpotyGaleryPresenter presenter= new SpotyGaleryPresenter(this);
    private static SpotyGaleryView mainActivity = null;

    private ArrayList<Canciones> lstCanciones = new ArrayList<>();

    private GridView gridView;

    public static SpotyGaleryView getInstance(){
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galery_spotify);
        mainActivity = this;
        initComponents();
    }

    private void initComponents() {
        gridView = findViewById(R.id.gridView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        presenter.lstGalery(0);

    }
    @Override
    public void success(ArrayList<Canciones> lstCanciones) {
        this.lstCanciones = lstCanciones;
        gridView.setAdapter(new SpotyGaleryAdapter(this, lstCanciones));
    }

    @Override
    public void failure(String err) {

    }
}
