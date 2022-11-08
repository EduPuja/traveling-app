package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceBitllets;
import com.sun.javafx.image.BytePixelSetter;
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
        Statement con =ConnexioBDD.conexioDB();

        if(comprovarBillet(bCompra.getIdBillet()))
        {
            System.out.println("Numero del billet :" + bCompra.getIdBillet());
        }
    }
    public void eliminarBitllets(Billet bElimina) throws Exception
    {


        Statement con = ConnexioBDD.conexioDB();
        String query = "DELETE FROM billets WHERE id_billet="+bElimina.getIdBillet();


        // con.executeQuery
        if(con.executeUpdate(query) == 1)
        {
            System.out.println("Se ha elimiant el billet!");
        }
        else System.out.println("No se ha eliminat el billet ;( ");



        con.close();    // cierro la conexion
    }

    public void creaBitllets(Billet bCrea) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();
        String query = "INSERT INTO billets(id_billet, id_viatge,tipus_billet,preu,max_billets_tipus) VALUES ("+bCrea.getIdBillet()+" "+bCrea.getIdViatge()+"'"+bCrea.getTipusBillet().toString()+"'"+bCrea.getPreuBillet()+" "+bCrea.getMaxPersones()+")";

       // con.executeQuery(query);

        if(con.executeUpdate(query) == 1)
        {
            System.out.println("Billet CREAT! ");
        }
        else System.out.println("Billet NO created ;( ");


        con.close();


    }

    public static boolean comprovarBillet(int idBillet)
    {

        // billet  num 1
        // billet entrat 2  -ok
        // billet entrat 1  --esta repetit
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


    }
}
