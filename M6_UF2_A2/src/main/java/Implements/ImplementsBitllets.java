package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceBitllets;
import objectes.Billet;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ImplementsBitllets implements InterfaceBitllets
{
    public void llistarBitllets() throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();
        String query = "SELECT * FROM `bitllets`";

        ResultSet rs = statement.executeQuery(query);
        while (rs.next())
        {
            System.out.println("ID_BITLLET: "+rs.getString("id_billet"));
            System.out.println("ID_VIATGE: "+rs.getString("id_viatge"));
            System.out.println("TIPUS BITLLET: "+rs.getString("tipus_billet"));
            System.out.println("PREU BITLLET: "+rs.getDate("preu").toString());
            System.out.println("MAXIM DE PERSONES: "+rs.getDate("max_billets_tipus").toString());
            System.out.println("");
        }
        statement.close();
    }
    public void compraBitllets(int bCompra) throws Exception
    {

    }
    public void eliminarBitllets(int bIDElimina) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();
        String query = "DELETE FROM billets WHERE id_billet="+bIDElimina;
        // con.executeQuery
        if(con.executeUpdate(query) == 1)
        {
            System.out.println("Se ha elimiant el billet!");
        }
        else System.out.println("No se ha eliminat el billet.");
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
    public static boolean comprovarBillet(int idBillet) throws Exception {
        // billet  num 1
        // billet entrat 2  -ok
        // billet entrat 1  --esta repetit
        Statement statement = ConnexioBDD.conexioDB();

        String query = "select `id_billet` from `billets` where `id_billet` ="+idBillet;

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
