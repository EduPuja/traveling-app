package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceUsuari;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;
import objectes.Persona;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ImplementsUsuari implements InterfaceUsuari
{
    public void altaUser(Persona u) throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();

        String dni = u.getDni();
        String nom = u.getNom();
        Date data_naix = u.getData_naix();

        String query = "INSERT INTO `persona` (`dni`,`nom`,`data_naix`) VALUES('"+ dni + "','" + nom + "','" + data_naix + "')";

        if(statement.executeUpdate(query) == 1){
            System.out.println("Usuari entrat.");
        }
        else System.out.println("Usuari no entrat.");
        statement.close();
    }
    public void baixaUser(String dniUser) throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();

        String query = "DELETE FROM `persona` WHERE `dni` = '" + dniUser + "'";

        if(statement.executeUpdate(query) == 1){
            System.out.println("Baixa de l'usuari completada.");
        }
        else System.out.println("Baixa de l'usuari no completada.");
        statement.close();
    }
    public void modificacioUser(String dades) throws Exception {
        Statement statement = ConnexioBDD.conexioDB();
        // dades esta format en el seguent format (dni/dade modificada/tipo de dada);
        // fer split de dades per treure cada valor. Tot en tipos String;
        if(!dades.equalsIgnoreCase("no"))
        {
            String taula [] = dades.split("/");
            String dni = taula[0];
            String novaInfo = taula[1];
            String tipoInfo = taula[2];

            String query = "UPDATE `persona` SET `" + tipoInfo + "` ='" + novaInfo +"' WHERE `dni` = '" + dni + "'";

            if(statement.executeUpdate(query) == 1){
                System.out.println("Modificacio de " + tipoInfo + " de l'usuari completada.");
            }
            else System.out.println("Modificacio de " + tipoInfo + " de l'usuari no completada.");
            statement.close();
        }
        else System.out.println("Modificacio Cancelada.");
    }
    public void llistarUser() throws Exception {
        ConnexioBDD.conexioDB();
    }
    public static boolean comprovarUser(String dni, String password) throws Exception {
        //comprovarUser en la bdd.
        Statement statement = ConnexioBDD.conexioDB();

        String query = "SELECT * FROM `persona` WHERE `dni`= '" + dni + "'";

        ResultSet rs = statement.executeQuery(query);
        if(rs.next())
        {
            if(rs.getString("dni").equalsIgnoreCase(dni)){
                statement.close();
                return true;
            }
            else
            {
                statement.close();
                return false;
            }
        }
        else {
            statement.close();
            return false;
        }

    }
    public static boolean comprovarUserBaixa_Update_Alta(String dni) throws Exception {
        //comprovarUser en la bdd.
        Statement statement = ConnexioBDD.conexioDB();

        String query = "SELECT * FROM `persona` WHERE `dni`= '" + dni + "'";

        ResultSet rs = statement.executeQuery(query);
        if(rs.next())
        {
            if(rs.getString("dni").equalsIgnoreCase(dni)){
                statement.close();
                return true;
            }
            else
            {
                statement.close();
                return false;
            }
        }
        else {
            statement.close();
            return false;
        }

    }
}
