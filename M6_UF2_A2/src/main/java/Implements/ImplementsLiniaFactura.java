package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceLiniaFactura;
import Objectes.Linia_Factura;

import java.sql.ResultSet;
import java.sql.Statement;

public class ImplementsLiniaFactura implements InterfaceLiniaFactura
{

    public static void updateIdEquipatge(int idE, int numLF, int nF) throws Exception {
        Statement statement = ConnexioBDD.conexioDB();
        String query2 = "Update linia_factura set linia_factura="+ numLF + " id_equip="+idE+" where num_factura="+nF;

        if(statement.executeUpdate(query2)==1) System.out.println("Update fet");
        else System.out.println("Update no fet.");
    }

    /**
     * Metode per llistar totes les linia factura de la taula
     * @throws Exception
     */
    public void llistarLiniaFactura() throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();
        String query= "SELECT lf.linia_factura,lf.num_factura,lf.preu,p.dni FROM `linia_factura` lf INNER JOIN persona p ON p.id_persona = lf.id_persona";

        ResultSet rs = con.executeQuery(query);
        while (rs.next())
        {
            System.out.println("LINIA_FACUTRA: "+rs.getInt("linia_factura"));
            System.out.println("NUM_FACTURA: "+rs.getInt("num_factura"));
            System.out.println("DNI_PERSONA : "+rs.getString("p.dni"));
            System.out.println("PREU: "+rs.getInt("preu"));
            System.out.println("");
        }
        rs.close();
        con.close();    // tencar la conexio
    } // ✅

    /**
     * Metode per insertar una linia factura
     * @param creaLF
     * @throws Exception
     */
    public void crearLiniaFactura(Linia_Factura creaLF) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();
        String query = "INSERT INTO linia_factura(linia_factura,num_factura,id_persona,preu,id_billet) VALUES ("+creaLF.getNumLinia()+","+creaLF.getLiniaFactura()+","+creaLF.getIdPersona()+","+creaLF.getPreu()+","+creaLF.getId_billet()+")";
        //System.out.println(query);
        if(con.executeUpdate(query) == 1) System.out.println("Se ha insertat una Linia factura :D");
        else System.out.println("No se ha insertat D: la linia factura");
        con.close(); // cerrar
    } // ✅

    /**
     * metode per eliminar una liniafactura de la taula
     * @param //deleteLF
     * @throws Exception
     */

    public void eliminarLiniaFactura(int idLinaFactura) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();
        if(consultarLiniaFactura(idLinaFactura))
        {
            // exgisteix llavors haig de fer el delelte
            String query = "DELETE FROM `linia_factura` WHERE lina_facutra="+idLinaFactura;
            if(con.executeUpdate(query) == 1)
            {
                System.out.println("Se ha eliminat una LinaFactura");
            }
            else System.out.println("No se ha eliminat");
        }
        else System.out.println("Lina factura no trobada");

        con.close();
    } // ✅

    /**
     * Metode per modificar la linia factura
     * @param dades
     * @throws Exception
     */
    public void modificarLiniaFactura(String dades) throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();
        // EXEMPLE MODIFICAR estacio

        String taula [] = dades.split("/");
        int linaFactura = Integer.parseInt(taula[0]);
        //int numFactura = Integer.parseInt(taula[1]);
        //int idPersona = Integer.parseInt(taula[2]);
        int preu = Integer.parseInt(taula[1]);

        String query = "UPDATE `linia_factura` SET `preu`="+preu+" WHERE `linia_factura`="+linaFactura;

        if(statement.executeUpdate(query) == 1) System.out.println("La linaFactura ha sigut Modificada .");
        else System.out.println("Modificat Incorrectament.");
        statement.close();
    } // ✅

    /**
     * Metode per consultar si exgisteix una linaFactura amb un id concret
     * @param linaFactura
     * @return
     * @throws Exception
     */
    public static boolean consultarLiniaFactura(int linaFactura) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();
        String query = "Select linia_factura from linia_factura where linia_factura="+linaFactura;

        ResultSet resultSet = con.executeQuery(query);
        if(resultSet.next())
        {
            con.close();
            return true;
        }
        else con.close(); return false;
    } // ✅

    public static void eliminarLinFactDeFact(int idFactura) throws Exception {

        Statement con = ConnexioBDD.conexioDB();
        if(ImplementsFactura.comprovaNumFact(idFactura))
        {
            // exgisteix llavors haig de fer el delelte
            String query = "DELETE FROM `linia_factura` WHERE num_factura="+idFactura;
            if(con.executeUpdate(query) == 1)
            {
                System.out.println("Se ha eliminat una LinaFactura");
            }
            else System.out.println("No se ha eliminat");
        }
        else System.out.println("Lina factura no trobada");

        con.close();
    }

}
