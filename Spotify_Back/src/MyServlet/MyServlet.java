package MyServlet;

import SqlAction.SqlAction;
import bean.Canciones;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("application/json");
        String action = request.getParameter("ACTION");
        String[] keepaction = action.split("\\.");

        PrintWriter out = response.getWriter();

        switch (keepaction[0]){
            case "SELECT_MUSIC":
                out.print(selectMusic(request, response));
                break;
        }



    }

    private String selectMusic(HttpServletRequest request, HttpServletResponse response) {
        SqlAction sql = new SqlAction();
        ArrayList<Canciones> canciones = sql.selectCanciones();
        return Canciones.convertirAJson(canciones);
    }
}
