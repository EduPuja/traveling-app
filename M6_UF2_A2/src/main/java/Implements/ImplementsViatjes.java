package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceViatjes;
import Objectes.Viatje;

import java.sql.ResultSet;
import java.sql.Statement;

public class ImplementsViatjes implements InterfaceViatjes
{




    /**
     * Metode per crear un nou viatge a la base de dades ✅
     * @param vNou
     * @throws Exception
     */
    public void nouViatje(Viatje vNou) throws Exception
    {
       Statement con =ConnexioBDD.conexioDB();
       String query = "INSERT INTO `viatges`(`id_viatge`, `id_origen`, `id_desti`, `pais`) VALUES ("+vNou.getIdViatge()+","+vNou.getIdOrigen()+","+vNou.getIdDesti()+","+vNou.getPais();
        if(con.executeUpdate(query) ==1)
        {
            System.out.println("Viatge Insertat correctament ");
        }
        else  System.out.println("Viatge NO INSERTAT D:");
        con.close();
    }

    /**
     * Eliminar viatge ✅
     * @param idViatge
     * @throws Exception
     */
    public void eliminarViatje(int idViatge) throws Exception
    {
       Statement statement=  ConnexioBDD.conexioDB();
       if(comprovarViatge(idViatge))
       {
           String query = "DELETE FROM `viatges` WHERE id_viatge ="+idViatge;
           if(statement.executeUpdate(query) == 1)
           {
               System.out.println("Viatge ELIMINAT");
           }
           else System.out.println("Viatge no Eliminat");
       }
       else System.out.println("Aquest viatge no exgisteix");

       statement.close();
    }

    // TODO FALTA MODIFICAR VIATGE
    public void modificarViatje(Viatje vUpdate) throws Exception
    {
        Statement statement= ConnexioBDD.conexioDB();

        // todo comprovar que el viatge sigui el que has preguntat i un cop preguntat has de preguntar el que vol modifcar en cas de que sigui alguna de les opcions MENYS PAIS se ha d'anar a modifcar estacio


        statement.close();
    }

    /**
     * Metode de llistar un vaitge ✅
     * @throws Exception
     */
    public void llistarViatje() throws Exception
    {
        Statement statement =ConnexioBDD.conexioDB();

        String query = "SELECT * FROM `viatges`";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next())
        {
            System.out.println("ID_VIATGE: "+ rs.getInt("id_viatge"));
            System.out.println("ID_ORIGEN: "+ rs.getInt("id_origen"));
            System.out.println("ID_DESTI: "+ rs.getInt("id_desti"));
            System.out.println("PAIS: "+ rs.getString("pais"));
            System.out.println("");
        }
        rs.close();
        statement.close();
    }

    /**
     * Metode que comprova un viatge a la base de dades ✅
     * @param idViatge
     * @return
     * @throws Exception
     */
    public static boolean comprovarViatge(int idViatge) throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();

        String query = "select `id_viatge` from `viatges` where `id_viatge` ="+idViatge;

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
