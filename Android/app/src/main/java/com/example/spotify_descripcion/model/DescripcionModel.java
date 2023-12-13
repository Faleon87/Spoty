package com.example.spotify_descripcion.model;

import com.example.Beans.Canciones;
import com.example.spotify_descripcion.presenter.DescripcionPresenter;
import com.example.spotify_galery.ContractListGalery;
import com.example.utils.ApiService;
import com.example.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class DescripcionModel implements ContractListGalery.Model{
    private static final String IP_BASE = "192.168.0.22:8080";

    private DescripcionPresenter presenter;

    public DescripcionModel(DescripcionPresenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void moviesAPI(int id, OnLstProductoListener respuestaMovies) {
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/Spotify_Back/").
                create(ApiService.class);
        Call<ArrayList<Canciones>> call = apiService.getDataCancionesDes("SELECT_DESCRIPCION" ,id );
        call.enqueue(new Callback<ArrayList<Canciones>>() {
            @Override
            public void onResponse(Call<ArrayList<Canciones>> call, Response<ArrayList<Canciones>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Canciones> myData = response.body();
                    respuestaMovies.onFinished(myData);
                }else{
                    // Manejar una respuesta no exitosa
                    try {
                        String errorBody = response.errorBody().string();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Canciones>> call, Throwable t) {

            }
        });
    }
}
