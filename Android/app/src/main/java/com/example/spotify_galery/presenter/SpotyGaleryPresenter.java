package com.example.spotify_galery.presenter;

import com.example.Beans.Canciones;
import com.example.spotify_galery.ContractListGalery;
import com.example.spotify_galery.mode.SpotyGaleryModel;

import java.util.ArrayList;

public class SpotyGaleryPresenter implements ContractListGalery.Presenter , ContractListGalery.Model.OnLstProductoListener{
    private ContractListGalery.View vista;

    private SpotyGaleryModel model;

    public SpotyGaleryPresenter(ContractListGalery.View vista){
        this.vista = vista;
        model = new SpotyGaleryModel(this);
    }

    @Override
    public void onFinished(ArrayList<Canciones> lstProductos) {
        vista.success(lstProductos);
    }

    @Override
    public void onFailure(String err) {

    }


    @Override
    public void lstGalery(int id) {
        model.moviesAPI( 0,this);
    }
}
