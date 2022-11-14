package Funcions;

import Implements.ImplementsBitllets;
import Implements.ImplementsFactura;
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
        int linaFactnum = -1;
        int numFactura;
        String dni;
        int bitllet;
        boolean menuf= false;
        do{
            System.out.println("Digues el num de la factura: ");
            numFactura =  lector.nextInt();
            lector.nextLine();
            if(ImplementsFactura.comprovaNumFact(numFactura))menuf = true;
            else System.out.println("Numero de factura ja existeix.");

        }while(!menuf);
        boolean menud= false;
        do{
            System.out.println("Digues el dni de la persona a qui va a la lina factura: ");
            dni = lector.nextLine();
            if(ImplementsUsuari.comprovarUserBaixa_Update_Alta(dni)) menud = true;
            else System.out.println("Dni incorrecte.");
        }while(!menud);
        System.out.println("------------------------------------------");
        System.out.println("             Bitllets Actuals             ");
        System.out.println("------------------------------------------");
        ImplementsBitllets.llistarBitlletsPerLF();
        System.out.println("");
        System.out.println("Escull un bitllet: ");
        bitllet = lector.nextInt();
        lector.nextLine();

        int preu = ImplementsBitllets.preuBitllet(bitllet);

        Linia_Factura linaFact = new Linia_Factura(linaFactnum,numFactura, ImplementsFactura.dniAid(dni),preu,bitllet); // objecte

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
