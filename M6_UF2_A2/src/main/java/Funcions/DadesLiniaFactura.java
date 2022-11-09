package Funcions;

import Objectes.Linia_Factura;

import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;

public class DadesLiniaFactura
{
    private static Scanner lector = new Scanner(System.in);


    /**
     * metode per donar d'alta una lina factura
     * @throws Exception
     */
    public static void fromAltaLinaFactura() throws Exception
    {



        System.out.println("Digues el numero de la lina factura");
        int linaFactnum = lector.nextInt();
        lector.nextLine();
        System.out.println("Digues el num de la factura");
        int numFactura =  lector.nextInt();
        lector.nextLine();
        System.out.println("Digues el id de la persona a qui va a la lina factura");
        int idPersona = lector.nextInt();
        lector.nextLine();
        //todo comprovar que aquest id estigui realment a la basse de dades sino esta et surti un error
        System.out.println("Digues un preu a la linafactura");
        int preuLinaFactura = lector.nextInt();
        lector.nextLine();


        Linia_Factura linaFact = new Linia_Factura(linaFactnum,numFactura,idPersona,preuLinaFactura); // objecte

    }
    public static void fromBaixaLinaFactura() throws Exception
    {

    }
    public static void fromDeleteLinaFactura() throws Exception
    {

    }

    public static void fromUpdateLinaFactura() throws Exception
    {
        
    }






}
