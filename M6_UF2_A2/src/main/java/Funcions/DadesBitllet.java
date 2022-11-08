package Funcions;

import Implements.ImplementsBitllets;
import objectes.Billet;
import objectes.Persona;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;
public class DadesBitllet
{
    // intentar cerrar
    static  Scanner lector = new Scanner(System.in);
    public static Billet formCompraBitllet()
    {



        return null;
    }
    public static Billet formEliminarBitllet()
    {
        return null;
    }

    public static Billet formCreaBitllet() {
        Billet billet= new Billet();

        System.out.println("Digues el numero del bitllet a comprar: ");
        int idBillet = lector.nextInt();
        lector.nextLine();


        boolean okaBillet = ImplementsBitllets.comprovarBillet(idBillet);
        if(!okaBillet)
        {
            System.out.println("Billet entrat Correctament");
            //continuar preguntant les coses de un bitllet.
        }
        else System.out.println("Billet REPETIT! ");



        return billet;
    }
}
