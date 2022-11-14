package Funcions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnexioBDD
{

    /**
     * Metode que el que fa es la connexio a la base de dades mysql utilizant XAMPP
     * @return
     * @throws Exception
     */
    public static Statement conexioDB() throws Exception
    {
        // url on esta la base de dades

        //Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:3306/travelling_app";       // Per ara ho fem amb localhost ja que tenim la mateix arxiu bbdd
        // usuari base de dades
        String user = "admin";
        // contrasenya base de dades
        String password = "123asd123";
        // Driver
        //Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        return statement;

    }
}
