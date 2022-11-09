package Funcions;

import Implements.ImplementsLiniaFactura;
import Implements.ImplementsUsuari;
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

    /**
     * Metode donar de baixaLinaFactura el que fa és comprova a la base de dades si exgisteix aquell id de la lina factura
     * si el troba llavors te el retorna. En cas  de que no el trobi el que fa és et retorna -1
     * @return
     * @throws Exception
     */
    public static int fromBaixaLinaFactura() throws Exception
    {



        System.out.println("El numero de la linaFactura que vols ");
       int linaFactura= lector.nextInt();
        lector.nextLine();
        if(ImplementsLiniaFactura.consultarLiniaFactura(linaFactura))
        {
            return linaFactura;
        }
        else return -1;

    }
    public static void fromDeleteLinaFactura() throws Exception
    {

    }

    public static void fromUpdateLinaFactura() throws Exception
    {
        
    }






}
