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

        Statement con = ConnexioBDD.conexioDB();
        //String query = "INSERT INTO billets(id_billet, id_viatge,tipus_billet,preu,max_billets_tipus) VALUES ("+bCrea.getIdBillet()+" "+bCrea.getIdViatge()+"'"+bCrea.getTipusBillet().toString()+"'"+bCrea.getPreuBillet()+" "+bCrea.getMaxPersones()+")";

       // con.executeQuery(query);

        System.out.println("SE HA ELIMIANT UN BILLET A LA BBDD");
        con.close();
    }

    public void creaBitllets(Billet bCrea) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();
        String query = "INSERT INTO billets(id_billet, id_viatge,tipus_billet,preu,max_billets_tipus) VALUES ("+bCrea.getIdBillet()+" "+bCrea.getIdViatge()+"'"+bCrea.getTipusBillet().toString()+"'"+bCrea.getPreuBillet()+" "+bCrea.getMaxPersones()+")";

        con.executeQuery(query);

        System.out.println("SE HA CREAT UN BILLET A LA BBDD");
        con.close();


    }

    public static boolean comprovarBillet(int idBillet)
    {
        try
        {
            Statement statement = ConnexioBDD.conexioDB();

            String query = "select id_billet from billets where id_billet ="+idBillet;

            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.getInt("id_billet") == idBillet)
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
