package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceEquipatge;
import Objectes.Equipatge;

import java.sql.ResultSet;
import java.sql.Statement;

public class ImplementsEquipatge implements InterfaceEquipatge
{


    /**
     * Insertar equipatge base de dades ✅
     *
     */
    @Override
    public void afegirEquipatge(Equipatge equipatge) throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();

        String insertQuery = "INSERT INTO `equipatge`(`id_equip`, `num_factura`, `linia_factura`, `pes_kg`, `num_maletes`) VALUES ("+equipatge.getIdEquipatge()+","+equipatge.getNumFactura()+","+equipatge.getLiniaFactura()+","+equipatge.getPesKg()+","+equipatge.getNumMaletes();
        if(statement.executeUpdate(insertQuery) ==1)
        {
            System.out.println("Equipatge insertat");
        }
        else System.out.println("Equipatge NO insertat");
        statement.close();

    }

    @Override
    public void eliminarEquipatge(int idEquipatge)throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();



        con.close();
    }

    @Override
    public void modificarEquipatge(String dades) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();



        con.close();
    }

    /**
     * Llistar equipatge ✅
     * @throws Exception
     */
    @Override
    public void llistarEquipatge()throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();
        String query = "SELECT * FROM `equipatge`";

        ResultSet rs = con.executeQuery(query);


        while (rs.next())
        {
           System.out.println("ID_Equip: "+rs.getInt("id_equip"));
            System.out.println("Num_FACTURA: "+rs.getInt("num_factura"));
            System.out.println("Lina_Factura: "+rs.getInt("lina_factura"));
            System.out.println("Pes_kg: "+rs.getInt("pes_kg"));
            System.out.println("Num_Maletes: "+rs.getInt("num_maletes"));
            System.out.println("");
        }

        rs.close();
        con.close();
    }

    public static void comprovarEquipatge(int idEquipatge) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();


        con.close();
    }
}
