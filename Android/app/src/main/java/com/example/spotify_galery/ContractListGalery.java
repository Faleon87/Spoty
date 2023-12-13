package com.example.spotify_galery;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Beans.Canciones;

import java.util.ArrayList;

public interface ContractListGalery {
    public interface Presenter{
        void lstGalery(int id);
    }

    public interface Model{
        void moviesAPI(int id,
                       OnLstProductoListener respuestaMovies);

        interface OnLstProductoListener{
            void onFinished(ArrayList<Canciones> lstProductos);
            void onFailure(String err);
        }

    }
    public interface View{
        public void success(ArrayList<Canciones>  lstCanciones);
        void failure(String err);
    }
}
