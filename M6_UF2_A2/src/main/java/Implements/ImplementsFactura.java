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
import java.util.Random;

public class ImplementsFactura implements InterfaceFactura {

    @Override
    public void llistarFactura() throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();
        String query = "Select num_factura,p.dni as dni_persona,preu_total,data_factura from factura f inner join persona p on f.id_persona = p.id_persona";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            System.out.println("NUMERO FACTURA: " + rs.getInt("num_factura"));
            System.out.println("DNI PERSONA: " + rs.getInt("dni_persona"));
            System.out.println("PREU TOTAL FACTURA: " + rs.getInt("preu_total"));
            System.out.println("DATA FACTURA: " + rs.getInt("data_factura"));
        }
    } // ✅
    @Override
    public void crearFactura(Factura creaF,int idB) throws Exception
    {
        InterfaceLiniaFactura daoLF = new ImplementsLiniaFactura();

        Statement statement = ConnexioBDD.conexioDB();
        int nF = creaF.getNumFactura();
        int idP = creaF.getIdPersona();
        Date dataF = creaF.getData();

        String query = "Insert into factura(num_factura,id_persona,preu_total,data_factura) values("+nF+","+idP+","+(-1)+",'"+dataF+"')";

        if(statement.executeUpdate(query) == 1)
        {
            Linia_Factura lf = new Linia_Factura();

            boolean nlf = false;
            Random rdm = new Random();
            int numLF;
            do{
                numLF = rdm.nextInt(5000);
                if(!ImplementsLiniaFactura.consultarLiniaFactura(numLF)) nlf = true;
            }while (!nlf);

            lf.setLiniaFactura(nF);
            lf.setNumLinia(numLF);
            lf.setIdPersona(idP);
            lf.setPreu(ImplementsBitllets.preuBitllet(idB));

            daoLF.crearLiniaFactura(lf);
            int preu = lf.getPreu();
            updatePreu(preu,nF);
        }
    } // ✅
    @Override
    public void crearFacturaAdmin(Factura creaF) throws Exception
    {
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
    } // ✅
    private void updatePreu(int preu, int nF) throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();
        String query2 = "Update factura set preu_total="+ preu + " where num_factura="+nF;

        if(statement.executeUpdate(query2)==1) System.out.println("Factura creada");
        else System.out.println("Factura no creada.");
    } // ✅
    @Override
    public void eliminarFactura(int idLinaFactura) throws Exception
    {

    }
    @Override
    public void modificarFactura(String dades) throws Exception
    {

    }
    public static int dniAid(String dni) throws Exception
    {
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

    } // ✅
    public static boolean comprovaNumFact(int numF) throws Exception
    {
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
    } // ✅
}
