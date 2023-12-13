package SqlAction;

import bean.Canciones;
import motorsql.MotorSql;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SqlAction {
private final String SQl_SELECT_CANCIONES = "SELECT id ,titulo, url_imagen from  Canciones";



    private ResultSet res;
    private MotorSql motorSql;

    public ArrayList<Canciones> selectCanciones(){
        ArrayList<Canciones> canciones = new ArrayList<Canciones>();
        motorSql = new MotorSql();
        motorSql.connect();
        res = motorSql.executeQuery(SQl_SELECT_CANCIONES);
        try {
            while (res.next()){
                Canciones cancion = new Canciones();
                cancion.setId(res.getInt(1));
                cancion.setTitulo(res.getString(2));
                cancion.setUrl_imagen(res.getString(3));
                canciones.add(cancion);
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
        motorSql.disconnect();
        return canciones;

    }


}
