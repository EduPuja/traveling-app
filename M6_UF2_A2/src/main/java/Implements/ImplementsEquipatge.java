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

    /**
     * Eliminar equipatge base de dades✅
     * @param idEquipatge
     * @throws Exception
     */
    @Override
    public void eliminarEquipatge(int idEquipatge)throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();

        if(comprovarEquipatge(idEquipatge))
        {
            String query = "Delete from equipatge where id_equip = "+idEquipatge;

            if(con.executeUpdate(query) ==1)
            {
                System.out.println("Equipatge ELIMINAT");
            }
            else System.out.println("Equipatge NO eliminat");
        }
        else System.out.println("Equipatge no exgisteix");


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

    /**
     * Metode que comprova a la base de dades si hi ha un equipatge  ✅
     * @param idEquipatge
     * @return
     * @throws Exception
     */
    public static boolean comprovarEquipatge(int idEquipatge) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();

        String query = "select id_equip from equipatge where id_equip = "+idEquipatge;

        ResultSet rs = con.executeQuery(query);

        if(rs.next())
        {
            rs.close();
            con.close();
            return  true;
        }
        else
        {
            rs.close();
            con.close();
            return  false;
        }



    }
}
