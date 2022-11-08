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
        Statement statement = ConnexioBDD.conexioDB();
        String query = "SELECT * FROM `billets`";

        ResultSet rs = statement.executeQuery(query);
        while (rs.next())
        {
            System.out.println("ID_BITLLET: "+rs.getInt("id_billet"));       // esto era string .-. !!
            System.out.println("ID_VIATGE: "+rs.getInt("id_viatge"));        // esto era string .-. !!
            System.out.println("TIPUS BITLLET: "+rs.getString("tipus_billet"));
            System.out.println("PREU BITLLET: "+rs.getInt("preu"));
            System.out.println("MAXIM DE PERSONES: "+rs.getInt("max_billets_tipus"));
            System.out.println("");
        }
        statement.close();
    }
    public void compraBitllets(int bIdCompra,String dniClient) throws Exception
    {
        System.out.println("Bitllet comprat.");
        //TODO Llamar a crearfactura(bIDCompra,dniClient)
        //dentro de crearfactura creas las lineas de la misma
        //quan per cada bitllet es compri s'ha de borrar 1 a el numero de stock que hi ha de el bitllet.
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
        String query = "INSERT INTO `billets`(`id_viatge`,`tipus_billet`,`preu`,`max_billets_tipus`) VALUES ("+bCrea.getIdViatge()+",'"+bCrea.getTipusBillet().toString()+"',"+bCrea.getPreuBillet()+","+bCrea.getMaxPersones()+")";

       // con.executeQuery(query);
        if(con.executeUpdate(query) == 1)
        {
            System.out.println("Billet CREAT! ");
        }
        else System.out.println("Billet NO created ;( ");
        con.close();
    }
    public static boolean comprovarBillet(int idBillet) throws Exception
    {
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
    public static int preuBitllet(int idBillet) throws Exception
    {
        // billet  num 1
        // billet entrat 2  -ok
        // billet entrat 1  --esta repetit
        Statement statement = ConnexioBDD.conexioDB();

        String query = "select `preu` from `billets` where `id_billet` ="+idBillet;

        ResultSet resultSet = statement.executeQuery(query);

        if(resultSet.next())
        {
            statement.close();
            return resultSet.getInt("preu");
        }
        else
        {
            statement.close();
            return 0;
        }
    }
}
