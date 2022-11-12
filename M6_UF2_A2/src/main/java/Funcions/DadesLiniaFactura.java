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
    public static Linia_Factura fromAltaLinaFactura() throws Exception
    {
        System.out.println("Digues el numero de la lina factura");
        int linaFactnum = lector.nextInt();
        lector.nextLine();
        // EL LINES FACTURA ES AUTO INCREMENT...
        // SE TIENE QUE COMPROVAR SU EXISTENCIA
        System.out.println("Digues el num de la factura");
        int numFactura =  lector.nextInt();
        lector.nextLine();
        // ES A EL NUEMRO DE LA FACTURA A LA QUE VA REFERENCIADA LA LINEA.
        System.out.println("Digues el id de la persona a qui va a la lina factura");
        int idPersona = lector.nextInt();
        lector.nextLine();
        //todo comprovar que aquest id estigui realment a la basse de dades sino esta et surti un error
        System.out.println("Digues un preu a la linafactura");
        int preuLinaFactura = lector.nextInt();
        lector.nextLine();
        //EL PRECIO ES EL DE EL BILLETE QUE COJE EL USUARIO NO LO ENTRAS TU.


        Linia_Factura linaFact = new Linia_Factura(linaFactnum,numFactura,idPersona,preuLinaFactura); // objecte

        return linaFact;

    }

    /**
     * Metode donar de baixaLinaFactura el que fa és comprova a la base de dades si exgisteix aquell id de la lina factura
     * si el troba llavors te el retorna. En cas  de que no el trobi el que fa és et retorna -1
     * @return
     * @throws Exception
     */
    public static int fromBaixaLinaFactura() throws Exception
    {
        System.out.println("El numero de la linaFactura que vols: ");
       int linaFactura= lector.nextInt();
        lector.nextLine();
        if(ImplementsLiniaFactura.consultarLiniaFactura(linaFactura))
        {
            return linaFactura;
        }
        else return -1;

    }
    /**
     * Metode que acutliza una lina factura :D
     * @throws Exception
     */
    public static String fromUpdateLinaFactura() throws Exception
    {

        String dades = "";

        System.out.println("Digues el idLina que vols modificar");
        int idLinaFact = lector.nextInt();
        lector.nextLine();

        if(ImplementsLiniaFactura.consultarLiniaFactura(idLinaFact))
        {
            //quant trobi si exgisteix la lina factura el que ha de fer es actualizar el preu

            System.out.println("La lina que vols modificar Exgiteix");
            System.out.println("Digues el nou preu :");
            int preu = lector.nextInt();
            lector.nextLine();

            dades = ""+idLinaFact+"/"+preu;

            return dades;
            // como solo tienes que modifacr el precio  i necesitas el idFactura lo envio sin mas con un string

        }
        else
        {
            System.out.println("Aquesta linaFactura not found D:");
            return "";
        }



    }






}
