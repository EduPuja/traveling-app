package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceBitllets;
import com.sun.javafx.image.BytePixelSetter;
import objectes.Billet;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ImplementsBitllets implements InterfaceBitllets
{
    public void llistarBitllets() throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();
        String query = "SELECT * FROM `persona`";

        ResultSet rs = statement.executeQuery(query);
        while (rs.next())
        {
            System.out.println("ID_BITLLET: "+rs.getString("id_persona"));
            System.out.println("ID_VIATGE: "+rs.getString("dni"));
            System.out.println("TIPUS BITLLET: "+rs.getString("nom"));
            System.out.println("PREU BITLLET: "+rs.getDate("data_naix").toString());
            System.out.println("MAXIM DE PERSONES: "+rs.getDate("data_naix").toString());
            System.out.println("");
        }
        statement.close();

    }
    public void compraBitllets(Billet bCompra) throws Exception
    {
        Scanner lector = new Scanner(System.in);
        Statement con =ConnexioBDD.conexioDB();

        int pagar=-1;
        int canvi=-1;
        // comprovar en la base de dades
        if(comprovarBillet(bCompra.getIdBillet()))
        {
            System.out.println("Numero del billet :" + bCompra.getIdBillet());
            // si exgisteix doncs se ha de guardar la COMPRA
            // en la base de dades

            boolean okPagat= false;
            // mientras el precio no sea mes petit que el preu
            /*while (!okPagat && pagar< bCompra.getPreuBillet())
            {
                System.out.println("El preu del billet és :" +bCompra.getPreuBillet());
                pagar=lector.nextInt();
                lector.nextLine();

                if(pagar< bCompra.getPreuBillet())
                {
                    System.out.println("Et falta ");
                }

                if(pagar>=bCompra.getPreuBillet())
                {
                    canvi= pagar- bCompra.getPreuBillet();
                    System.out.println("El canvi és de: "+canvi);
                    okPagat=true;
                }
                else
                {
                    System.out.println("Preu oka");
                    okPagat=true;
                }
            }*/

        }
        else
        {
            System.out.println("No s'ha trobat el billet ");
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
