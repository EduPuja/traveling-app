package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceEstacio;
import Objectes.Estacio;

import java.sql.ResultSet;
import java.sql.Statement;

public class ImplementsEstacio implements InterfaceEstacio
{

    public void novaEstacio(Estacio eNou) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();

        String query = "INSERT INTO `estacio`(`id_estacio`, `descrip`) VALUES ("+eNou.getIdEstacio()+",'"+eNou.getDescripco()+"')";
        if(con.executeUpdate(query) == 1)
        {
            System.out.println("Estacio entrada Correctament.");
        }
        else System.out.println("Estacio no entrada.");

        con.close();
    } // ✅
    public void deleteEstacio(int idEstacio) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();
        if(comprovarEstacio(idEstacio))
        {
            String query = "DELETE FROM `estacio` WHERE id_estacio ="+ idEstacio;
            if(con.executeUpdate(query) ==1)
            {
                System.out.println("Estacio ha sigut eliminada correctament");
            }
            else System.out.println("Estacio NO DELETED");
        }
        else System.out.println("Aquesta estacio no exgisteix D: ");

        con.close();
    } // ✅
    public void modificarEstacio(String dades) throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();

        String taula [] = dades.split("/");
        int idEstacio = Integer.parseInt(taula[0]);
        String desNou = taula[1];

        String query = "UPDATE `estacio` SET `descrip`='"+ desNou+"' WHERE `id_estacio`= "+ idEstacio;

        if(statement.executeUpdate(query) == 1) System.out.println("Modificat Correcatament.");
        else System.out.println("Modificat Incorrectament.");
        statement.close();
    } // ✅
    public void llistarEstacio() throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();
        String query = "SELECT * FROM `estacio`";

        ResultSet rs = statement.executeQuery(query);
        while (rs.next())
        {
            System.out.println("ID_ESTACIO: "+rs.getString("id_estacio"));       // esto era string .-. !!
            System.out.println("DESCRIPCIO: "+rs.getString("descrip"));        // esto era string .-. !!
            System.out.println("");
        }
        statement.close();
    } // ✅
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

    } // ✅
}
