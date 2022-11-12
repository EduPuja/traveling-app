package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceViatjes;
import Objectes.Viatje;

import java.sql.ResultSet;
import java.sql.Statement;

public class ImplementsViatjes implements InterfaceViatjes
{


    // TODO FALTA TODO EL IMPLEMENTS VIATGE!!
    public void nouViatje(Viatje vNou) throws Exception
    {
       Statement con =ConnexioBDD.conexioDB();


    }
    public void eliminarViatje(Viatje vEliminar) throws Exception
    {
       Statement statement=  ConnexioBDD.conexioDB();
    }
    public void modificarViatje(Viatje vUpdate) throws Exception
    {
        Statement stat= ConnexioBDD.conexioDB();
    }
    public void llistarViatje() throws Exception
    {
        Statement statement =ConnexioBDD.conexioDB();
    }
    public static boolean comprovarViatge(int idViatge) throws Exception {
        Statement statement = ConnexioBDD.conexioDB();

        String query = "select `id_viatge` from `viatges` where `id_viatge` ="+idViatge;

        ResultSet resultSet = statement.executeQuery(query);

        if(resultSet.next())
        {
            statement.close();
            return true;
        }
        else
        {
            statement.close();
            return false;
        }
    }

}
