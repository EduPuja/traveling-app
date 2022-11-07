package Funcions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnexioBDD
{

    public static Statement conexioDB() throws Exception
    {
        // url on esta la base de dades
        String url = "jdbc:mysql://192.168.18.184:3306/m6_uf2_a1";
        // usuari base de dades
        String user = "admin";
        // contrasenya base de dades
        String password = "123asd123";
        // Driver
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        return statement;

    }
}
