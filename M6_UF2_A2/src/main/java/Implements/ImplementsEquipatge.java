package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceEquipatge;
import Objectes.Equipatge;

import java.sql.ResultSet;
import java.sql.Statement;

public class ImplementsEquipatge implements InterfaceEquipatge
{


    public static void updateLiniaFact(int numLF, int nF) throws Exception {
        Statement statement = ConnexioBDD.conexioDB();
        String query2 = "Update equipatge set linia_factura="+ numLF + " where num_factura="+nF;

        if(statement.executeUpdate(query2)==1) System.out.println("Update fet");
        else System.out.println("Update no fet.");
    }

    /**
     * Insertar equipatge base de dades ✅
     *
     */
    @Override
    public void afegirEquipatge(Equipatge equipatge) throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();

        if(equipatge!=null)
        {
            String insertQuery = "INSERT INTO `equipatge`(`id_equip`, `num_factura`, `linia_factura`, `pes_kg`, `num_maletes`) VALUES ("+equipatge.getIdEquipatge()+","+equipatge.getNumFactura()+","+equipatge.getLiniaFactura()+","+equipatge.getPesKg()+","+equipatge.getNumMaletes()+")";
            if(statement.executeUpdate(insertQuery) ==1)
            {
                System.out.println("Equipatge insertat");
            }
            else System.out.println("Equipatge NO insertat");
        }
        else System.out.println("Equipatge Error No inserat");
        statement.close();

    } // ✅

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
    } // ✅

    /**
     * Modificar equipatge en la bbdd ✅
     * @param dades
     * @throws Exception
     */
    @Override
    public void modificarEquipatge(String dades) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();

        if(!dades.equalsIgnoreCase("no"))
        {
            String taula [] = dades.split("/");
            int idEquip = Integer.parseInt(taula[0]);
            int newInfo = Integer.parseInt(taula[1]); // peskg o num_maletes
            String tipoInfo = taula[2];

            String query = "Update equipatge set "+tipoInfo+"="+newInfo+" where id_equip="+idEquip;
            if(con.executeUpdate(query) == 1)
            {
               System.out.println("Equipatge modificat");
            }
            else System.out.println("Equipatge no modifcat");
            con.close();
        }
        else System.out.println("Modificacio Cancelada.");


        con.close();
    } // ✅

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
            System.out.println("Linia_Factura: "+rs.getInt("linia_factura"));
            System.out.println("Pes_kg: "+rs.getInt("pes_kg"));
            System.out.println("Num_Maletes: "+rs.getInt("num_maletes"));
            System.out.println("");
        }

        rs.close();
        con.close();
    } // ✅

    @Override
    public void afegirEquipatgeUser(Equipatge e) throws Exception {
        Statement statement = ConnexioBDD.conexioDB();

        if(e!=null)
        {
            String insertQuery = "INSERT INTO `equipatge`(`num_factura`,`linia_factura`,`pes_kg`, `num_maletes`) VALUES ("+e.getNumFactura()+","+(-1)+","+e.getPesKg()+","+e.getNumMaletes()+")";
            if(statement.executeUpdate(insertQuery) ==1)
            {
                System.out.println("Equipatge insertat");
            }
            else System.out.println("Equipatge NO insertat");
        }
        else System.out.println("Equipatge Error No inserat");
        statement.close();
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
    } // ✅
    public static int idEReturn(int num_fact,int idLF) throws Exception {
        Statement con = ConnexioBDD.conexioDB();
        int idE = -1;
        String query = "select id_equip from equipatge where num_factura ="+num_fact+ " and linia_factura="+ idLF+"";

        ResultSet rs = con.executeQuery(query);

        if(rs.next())
        {
            idE = rs.getInt("id_equip");
            rs.close();
            con.close();
            return  idE;
        }
        else
        {
            rs.close();
            con.close();
            return  idE;
        }
    }
}
