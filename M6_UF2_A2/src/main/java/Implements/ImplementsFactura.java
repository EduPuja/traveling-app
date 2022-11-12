package Implements;

import Funcions.ConnexioBDD;
import Funcions.DadesLiniaFactura;
import Interfaces.InterfaceFactura;
import Interfaces.InterfaceLiniaFactura;
import Objectes.Factura;
import Objectes.Linia_Factura;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class ImplementsFactura implements InterfaceFactura {

    @Override
    public void llistarFactura() throws Exception {

    }

    @Override
    public void crearFactura(Factura creaF) throws Exception {
        InterfaceLiniaFactura daoLF = new ImplementsLiniaFactura();
        Statement statement = ConnexioBDD.conexioDB();
        int nF = creaF.getNumFactura();
        int idP = creaF.getIdPersona();
        Date dataF = creaF.getData();

        String query = "Insert into factura(num_factura,id_persona,preu_total,data_factura) values("+nF+","+idP+","+(-1)+",'"+dataF+"')";

        if(statement.executeUpdate(query) == 1)
        {
            Linia_Factura lf = DadesLiniaFactura.fromAltaLinaFactura();
            daoLF.crearLiniaFactura(lf);
            int preu = lf.getPreu();
            updatePreu(preu,nF);
        }
    }

    private void updatePreu(int preu, int nF) throws Exception {
        Statement statement = ConnexioBDD.conexioDB();
        String query2 = "Update factura set preu_total="+ preu + " where num_factura="+nF;

        if(statement.executeUpdate(query2)==1) System.out.println("Factura creada");
        else System.out.println("Factura no creada.");
    }

    @Override
    public void eliminarFactura(int idLinaFactura) throws Exception {

    }

    @Override
    public void modificarFactura(String dades) throws Exception {

    }

    public static int dniAid(String dni) throws Exception {
        Statement statement = ConnexioBDD.conexioDB();

        String query = "Select id_persona from persona where dni='"+dni+"'";

        ResultSet rs = statement.executeQuery(query);
        int id = -1;
        if(rs.next()){
            id = rs.getInt("id_persona");
            rs.close();
            statement.close();
            return id;
        }

        else{
            rs.close();
            statement.close();
            return id;
        }

    }
    public static boolean comprovaNumFact(int numF) throws Exception {
        //comprovarUser en la bdd.
        Statement statement = ConnexioBDD.conexioDB();

        String query = "SELECT * FROM `factura` WHERE `num_factura`= '" + numF + "'";

        ResultSet rs = statement.executeQuery(query);
        if(rs.next())
        {
            if(rs.getInt("num_factura") == numF){
                statement.close();
                return true;
            }
            else
            {
                statement.close();
                return false;
            }
        }
        else {
            statement.close();
            return false;
        }
    }
}
