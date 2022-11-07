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

        Billet billet= new Billet();

        System.out.println("Digues el numero del teu billet");
        int idBillet = lector.nextInt();
        lector.nextLine();


        boolean okaBillet = ImplementsBitllets.comprovarBillet(idBillet);
        if(okaBillet)
        {
            System.out.println("Billet entrat Correctament");
        }
        else System.out.println("Billet REPETIT! ");




        return billet;
    }
    public static Billet formEliminarBitllet()
    {
        return null;
    }
    public static void formLlistarBitllets()
    {

    }
}
