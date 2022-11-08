package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceUsuari;
import objectes.Persona;

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

        String query = "Insert Into persona('dni','nom','data_naix') values('"+ dni + "','" + nom + "','" + data_naix + "')";

        if(statement.executeUpdate(query) == 1){
            System.out.println("Usuari entrat.");
        }
        else System.out.println("Usuari no entrat.");
        statement.close();
    }
    public void baixaUser(String dniUser) throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();

        String query = "Delete FROM persona WHERE dni = '" + dniUser + "'";

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

            String query = "Update persona SET " + tipoInfo + " ='" + novaInfo +"' WHERE dni = '" + dni + "'";

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
    public static Boolean comprovarUser(String nom, String password, boolean admin)
    {
        //comprovarUser en la bdd.
        return false;
    }
    public static Boolean comprovarUserBaixa_Update_Alta(String dni)
    {
        //comprovarUser en la bdd.
        return false;
    }
}
