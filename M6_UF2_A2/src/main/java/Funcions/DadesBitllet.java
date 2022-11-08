package Funcions;

import Implements.ImplementsBitllets;
import Implements.ImplementsViatjes;
import objectes.Billet;
import objectes.TipusBillet;

import java.util.Scanner;
public class DadesBitllet
{
    // intentar cerrar
    static  Scanner lector = new Scanner(System.in);
    public static String formCompraBitllet()
    {

        /*Billet billet= new Billet();

        System.out.println("Digues el numero del bitllet a comprar: ");
        int idBillet = lector.nextInt();
        lector.nextLine();


        boolean okaBillet = implementsBillets.comprovarBillet(idBillet);
        if(!okaBillet)
        {
            System.out.println("Billet entrat Correctament");
            //continuar preguntant les coses de un bitllet.
        }
        else System.out.println("Billet REPETIT! ");*/



        return null;
    }
    public static String formEliminarBitllet()
    {
        return null;
    }
    public static Billet formCreaBitllet() throws Exception {
       Billet billet = new Billet();

       boolean menu = false;
       boolean menu2 = false;
       boolean menu3 = false;
       int idBillet;
       int idViatge;
       int preuBillet;
       String auxTipusBitllet;
       TipusBillet turista = TipusBillet.TURISTA;
       TipusBillet bussines = TipusBillet.BUISSNES;
       TipusBillet premium = TipusBillet.PREMIUM;
       TipusBillet finalTip = null;
       int maxPersones;

       do{
           System.out.println("Entra el id del bitllet que vos comprar: ");
           idBillet = lector.nextInt();
           lector.nextLine();
           if(ImplementsBitllets.comprovarBillet(idBillet)) menu = true;
           else System.out.println("Aquest bitllet no existeix.");
       }while(!menu);
       do{
           System.out.println("Entra el id de el Viatge de el bitllet: ");
           idViatge = lector.nextInt();
           lector.nextLine();
           if(ImplementsViatjes.comprovarViatge(idViatge)) menu2 = true;
           else System.out.println("Aquest viatge no existeix.");
       }while(!menu2);
       System.out.println("Entra el preu que te el bitllet: ");
       preuBillet = lector.nextInt();
       lector.nextLine();
       do{
           System.out.println("Entra de quin tipus sera el bitllet: (turista,bussines,premium)");
           auxTipusBitllet = lector.nextLine();
           if(auxTipusBitllet.equalsIgnoreCase(String.valueOf(turista))){
               menu3 = true;
               finalTip = turista;
           }
           else if(auxTipusBitllet.equalsIgnoreCase(String.valueOf(bussines))){
               menu3 = true;
               finalTip = bussines;
           }
           else if(auxTipusBitllet.equalsIgnoreCase(String.valueOf(premium))){
               menu3 = true;
               finalTip = premium;
           }
           else System.out.println("Aquest tipus no existeix.");
       }while(!menu3);

       System.out.println("Entra el maxim de Persones que tindran el aquest bitllet: ");
       maxPersones = lector.nextInt();
       lector.nextLine();

       billet.setIdBillet(idBillet);
       billet.setIdViatge(idViatge);
       billet.setPreuBillet(preuBillet);
       billet.setTipusBillet(finalTip);
       billet.setMaxPersones(maxPersones);

       return billet;
    }
}
