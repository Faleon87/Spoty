package com.example.Beans;

public class Canciones {
    private String titulo;
    private String url_imagen;
    private int id;

    public Canciones(String titulo, String url_imagen , int id) {
        this.titulo = titulo;
        this.url_imagen = url_imagen;
        this.id= id;
    }

    public Canciones(){

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
