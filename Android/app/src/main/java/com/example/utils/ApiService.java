package com.example.utils;

import com.example.Beans.Canciones;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface ApiService {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })

    @GET("MyServlet")
    Call<ArrayList<Canciones>> getDataCanciones(@Query("ACTION") String action);

    @GET("MyServlet")
    Call<ArrayList<Canciones>> getDataCancionesDes(@Query("ACTION") String action,
                                                @Query("ID") int id);

}
