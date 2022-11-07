package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceBitllets;
import objectes.Billet;

import java.sql.ResultSet;
import java.sql.Statement;

public class ImplementsBitllets implements InterfaceBitllets
{
    public void llistarBitllets() throws Exception
    {
        ConnexioBDD.conexioDB();
    }
    public void compraBitllets(Billet bCompra) throws Exception
    {
        ConnexioBDD.conexioDB();
    }
    public void eliminarBitllets(Billet bElimina) throws Exception
    {
        ConnexioBDD.conexioDB();
    }
    public static boolean comprovarBillet(int idBillet)
    {
        try
        {
            Statement statement = ConnexioBDD.conexioDB();

            String query = "select id_billet from billets where id_billet ="+idBillet;

            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.getInt("id_billet") == idBillet) return false;
            else return true;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return false;
        // billet  num 1
        // billet entrat 2  -ok
        // billet entrat 1  --esta repetit


    }
}
