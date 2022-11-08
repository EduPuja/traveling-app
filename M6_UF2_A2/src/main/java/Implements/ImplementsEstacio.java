package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceEstacio;
import objectes.Estacio;
import objectes.Viatje;

import java.sql.ResultSet;
import java.sql.Statement;

public class ImplementsEstacio implements InterfaceEstacio
{

    public void novaEstacio(Estacio eNou) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();

        String query = "INSERT INTO `estacio`(`id_estacio`, `descrip`) VALUES ("+eNou.getIdEstacio()+","+eNou.getDescripco()+")";
        if(con.executeUpdate(query) ==1)
        {
            System.out.println("Estacio insertada correctament");

        }
        else System.out.println("Estacio NO insertada <");

        con.close();
    }


    public void deleteEstacio(Estacio eDelete) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();
        if(comprovarEstacio(eDelete.getIdEstacio()))
        {
            String query = "DELETE FROM `estacio` WHERE id_estacio ="+ eDelete.getIdEstacio();
            if(con.executeUpdate(query) ==1)
            {
                System.out.println("Estacio ha sigut eliminada correctament");
            }
            else System.out.println("Estacio NO DELETED");
        }
        else System.out.println("Aquesta estacio no exgisteix D: ");

        con.close();
    }

    public void modificarEstacio(Estacio eUpdate) throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();

        if(comprovarEstacio(eUpdate.getIdEstacio()))
        {
            String query = "UPDATE `estacio` SET `descrip`='"+ eUpdate.getDescripco()+"' WHERE id_estacio= "+ eUpdate.getIdEstacio();

            if(statement.executeUpdate(query) == 1)
            {
               System.out.println("La descrip De la estacio ha sigut modificada");
            }
            else System.out.println("Descrip NOT MODED ");
        }
        else System.out.println("Aquesta estacio no esta registrada D:");



        statement.close();
    }

    public void llistarEstacio() throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();

    }

    /**
     * Metode per comprovar si una estacio esta insertada a la base de dades
     * @param idEstacio
     * @return
     * @throws Exception
     */
    public static boolean comprovarEstacio(int idEstacio) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();

        String query = "SELECT * FROM `estacio` WHERE id_estacio="+idEstacio;

        ResultSet resultSet =con.executeQuery(query);

        if(resultSet.next())
        {
            con.close();
            return true;
        }
        else
        {
            con.close();
            return false;
        }

    }


}
