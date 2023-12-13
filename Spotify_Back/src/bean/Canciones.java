package bean;

import com.google.gson.Gson;

import java.util.ArrayList;

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

    public static String convertirAJson(ArrayList<Canciones> canciones){
        String json = "[";
        for (int i = 0; i < canciones.size(); i++) {
            Canciones cancion = canciones.get(i);
            json += "{";
            json += "\"id\": \"" + cancion.getId() + "\",";
            json += "\"titulo\": \"" + cancion.getTitulo() + "\",";
            json += "\"url_imagen\": \"" + cancion.getUrl_imagen() + "\"";
            json += "}";
            if (i < canciones.size() - 1) {
                json += ",";
            }
        }
        json += "]";
        return json;
    }
}
