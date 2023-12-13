package com.example.spotify_descripcion.presenter;

import com.example.Beans.Canciones;
import com.example.spotify_descripcion.model.DescripcionModel;
import com.example.spotify_galery.ContractListGalery;

import java.util.ArrayList;

public class DescripcionPresenter implements ContractListGalery.Presenter , ContractListGalery.Model.OnLstProductoListener{

    private ContractListGalery.View vista;

    private DescripcionModel model;

    public DescripcionPresenter(ContractListGalery.View vista){
        this.vista = vista;
        model = new DescripcionModel(this);
    }
    @Override
    public void lstGalery(int id) {
        model.moviesAPI( id,this);

    }

    @Override
    public void onFinished(ArrayList<Canciones> lstProductos) {
        vista.success(lstProductos);
    }

    @Override
    public void onFailure(String err) {

    }


}
