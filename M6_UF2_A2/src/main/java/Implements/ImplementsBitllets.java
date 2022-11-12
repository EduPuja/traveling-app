package Implements;

import Funcions.ConnexioBDD;
import Funcions.DadesFactura;
import Interfaces.InterfaceBitllets;
import Interfaces.InterfaceFactura;
import Objectes.Billet;
import Objectes.Factura;

import java.sql.ResultSet;
import java.sql.Statement;

public class ImplementsBitllets implements InterfaceBitllets
{
    // todo ImplementsBitllets nomes falta la compra.
    public void llistarBitllets() throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();
        // consulta que sabe el usuari donde va a ir el precio i cantidad de personas
        String query = "" +
                "SELECT id_billet,b.id_viatge as idviatge, tipus_billet, preu, max_billets_tipus, " +
                "e.descrip as origen, e1.descrip as desti FROM billets b " +
                "INNER JOIN viatges v on v.id_viatge = b.id_viatge " +
                "INNER JOIN estacio e on e.id_estacio = v.id_origen " +
                "INNER JOIN estacio e1 on e1.id_estacio = v.id_desti";

        ResultSet rs = statement.executeQuery(query);
        while (rs.next())
        {
            System.out.println("ID_BITLLET: "+rs.getInt("id_billet"));       // esto era string .-. !!
            System.out.println("ID_VIATGE: "+rs.getInt("idviatge"));        // esto era string .-. !!
            System.out.println("ESTACIO ORIGEN: "+rs.getString("origen"));
            System.out.println("ESTACIO DESTI: "+rs.getString("desti"));
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
        InterfaceFactura daoF = new ImplementsFactura();
        Factura f = DadesFactura.fromAltaFactura(dniClient);
        daoF.crearFactura(f,bIdCompra);
        stockDown(bIdCompra);
        //TODO Llamar a crearfactura(bIDCompra,dniClient)
        //dentro de crearfactura creas las lineas de la misma
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
    public static void stockDown(int bIDStock) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();
        String query = "UPDATE max_billets_tipus FROM billets SET max_billets_tipus = " +(max_billets_tipusBitllet(bIDStock)-1)+" WHERE id_billet="+bIDStock;
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
        Statement statement = ConnexioBDD.conexioDB();

        String query = "select `preu` from `billets` where `id_billet` ="+idBillet;

        ResultSet resultSet = statement.executeQuery(query);
        int preu = -1;
        if(resultSet.next())
        {
            preu = resultSet.getInt("preu");
            statement.close();
            return preu ;
        }
        else
        {
            statement.close();
            return preu;
        }
    }
    public static int max_billets_tipusBitllet(int idBillet) throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();

        String query = "select `max_billets_tipus` from `billets` where `id_billet` ="+idBillet;

        ResultSet resultSet = statement.executeQuery(query);

        if(resultSet.next())
        {
            statement.close();
            return resultSet.getInt("max_billets_tipus");
        }
        else
        {
            statement.close();
            return 0;
        }
    }
    public static void llistarBitlletsPerLF() throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();
        // consulta que sabe el usuari donde va a ir el precio i cantidad de personas
        String query = "" +
                "SELECT id_billet,b.id_viatge as idviatge, tipus_billet, preu, max_billets_tipus, " +
                "e.descrip as origen, e1.descrip as desti FROM billets b " +
                "INNER JOIN viatges v on v.id_viatge = b.id_viatge " +
                "INNER JOIN estacio e on e.id_estacio = v.id_origen " +
                "INNER JOIN estacio e1 on e1.id_estacio = v.id_desti";

        ResultSet rs = statement.executeQuery(query);
        while (rs.next())
        {
            System.out.println("ID_BITLLET: "+rs.getInt("id_billet"));       // esto era string .-. !!
            System.out.println("ID_VIATGE: "+rs.getInt("idviatge"));        // esto era string .-. !!
            System.out.println("ESTACIO ORIGEN: "+rs.getString("origen"));
            System.out.println("ESTACIO DESTI: "+rs.getString("desti"));
            System.out.println("TIPUS BITLLET: "+rs.getString("tipus_billet"));
            System.out.println("PREU BITLLET: "+rs.getInt("preu"));
            System.out.println("MAXIM DE PERSONES: "+rs.getInt("max_billets_tipus"));
            System.out.println("");
        }
        statement.close();
    }
}
