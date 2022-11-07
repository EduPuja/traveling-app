package Funcions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnexioBDD {

    public static void conexioDB() throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/m6_uf2_a1";         // url on esta la base de dades
        String user = "Daniel";                            // usuari base de dades
        String password = "1234";              // contrasenya base de dades
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("Select * from persones");

        while (rs.next()) {

        }
    }
}
