package Funcions;

import Objectes.Linia_Factura;

import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;

public class DadesLiniaFactura
{
    private static Scanner lector = new Scanner(System.in);


    public static void fromAltaLinaFactura(Linia_Factura factura) throws Exception
    {
        Statement con = ConnexioBDD.conexioDB();
        String query = "INSERT INTO `linia_factura`(`linia_factura`, `num_factura`, `id_persona`, `preu`) VALUES ("+factura.getLiniaFactura()+","+factura.getNumLinia()+","+factura.getIdPersona()+","+factura.getPreu()+")";

        if(con.executeUpdate(query) == 1)
        {
            System.out.println("Linia Factura se ha inserit");
        }
        else System.out.println("Linfactura No insertada");


    }
    public static void fromBaixaLinaFactura(Linia_Factura factura) throws Exception
    {

    }
    public static void fromDeleteLinaFactura(Linia_Factura factura) throws Exception
    {

    }

    public static void fromUpdateLinaFactura(Linia_Factura factura) throws Exception
    {
        
    }




}
