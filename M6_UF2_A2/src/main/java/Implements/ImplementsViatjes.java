package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceViatjes;
import Objectes.Viatje;

import java.sql.ResultSet;
import java.sql.Statement;

public class ImplementsViatjes implements InterfaceViatjes
{


    /**
     * Insertar viatge en la BBDD ✅
     * @param vNou
     * @throws Exception
     */
    @Override
    public void nouViatje(Viatje vNou) throws Exception
    {
        Statement con =ConnexioBDD.conexioDB();

        if(vNou != null)
        {
            String query = "INSERT INTO `viatges`(`id_viatge`, `id_origen`, `id_desti`, `pais`) VALUES ("+vNou.getIdViatge()+","+vNou.getIdOrigen()+","+vNou.getIdDesti()+",'"+vNou.getPais()+"')";
            if(con.executeUpdate(query) ==1)
            {
                System.out.println("Viatge Insertat correctament ");
            }
            else  System.out.println("Viatge NO INSERTAT D:");
        }
        else System.out.println("Viatge NULL ");

        con.close();



    } // ✅

    /**
     * eliminar viatge base de dades✅
     * @param idViatge
     * @throws Exception
     */
    @Override
    public void eliminarViatje(int idViatge) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();
        if(comprovarViatge(idViatge))
        {

            String query = "DELETE FROM `viatges` WHERE id_viatge="+idViatge;
            if(con.executeUpdate(query) ==1)
            {
                System.out.println("Viatge Eliminat");
            }
            else System.out.println("Viatge no eliminat");
        }
        else System.out.println("Aquest viatge no exgisiteix");

        con.close();

    } // ✅

    /**
     * Modificar viatge base de dades✅
     * @param dades
     * @throws Exception
     */
    @Override
    public void modificarViatje(String dades) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();

        if(!dades.equalsIgnoreCase("no"))
        {
            String taula [] = dades.split("/");
            int idViatge = Integer.parseInt(taula[0]);
            String newInfo = taula[1]; // id destio o id origen o pais
            String tipoInfo = taula[2];

            if(comprovarViatge(idViatge))
            {
                //
                String query = "Update viatges set "+tipoInfo+"='"+newInfo+"' where id_viatge="+idViatge;
                if(con.executeUpdate(query) == 1)
                {
                    System.out.println("VIATGE modificat");
                }
                else System.out.println("Viatge no modifcat");
            }
            else System.out.println("Viatge no exgisteix");


            con.close();
        }
        else System.out.println("Modificacio Cancelada.");


        con.close();
    } // ✅

    /**
     * llistar viatges desde la base de dades✅
     * @throws Exception
     */
    @Override
    public void llistarViatje() throws Exception
    {

        Statement con = ConnexioBDD.conexioDB();


        // viatge  -  idViatge pais
        // estacio -  descripciop
        String query ="select v.id_viatge,e.descrip as origen,e2.descrip as desti ,v.pais FROM viatges v INNER JOIN estacio e ON e.id_estacio = v.id_origen INNER JOIN estacio e2 ON e2.id_estacio= v.id_desti ";

        ResultSet rs = con.executeQuery(query);

        while (rs.next())
        {
            System.out.println("ID_VIATGE: "+rs.getInt("id_viatge"));
            System.out.println("ORIGEN : "+rs.getString("origen"));
            System.out.println("DESTI "+rs.getString("desti"));
            System.out.println("PAIS: "+rs.getString("pais"));
            System.out.println("");
        }

        rs.close();
        con.close();

    } // ✅

    /**
     * Comprovar un viatge ✅
     * @param idViatge
     * @return
     * @throws Exception
     */
    public static boolean comprovarViatge(int idViatge) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();
        String query = "Select * from viatges where id_viatge ="+idViatge;

        ResultSet rs = con.executeQuery(query);
        if(rs.next())
        {
            rs.close();
            con.close();
            return true;
        }
        else
        {
            rs.close();
            con.close();
            return false;
        }
    } // ✅

}
