package Funcions;

import Implements.ImplementsBitllets;
import Implements.ImplementsViatjes;
import objectes.Billet;
import objectes.TipusBillet;

import java.util.Scanner;
public class DadesBitllet
{

    private static Scanner lector = new Scanner(System.in);         // intentar cerrar

    /**
     * Metode que se utiliza per comprar un billet
     * @return
     * @throws Exception
     */
    public static int formCompraBitllet() throws Exception
    {
        boolean menu = false;
        int idBitllet;
        do
        {
            System.out.println("Entra el id de el bitllet que vos comprar: ");
            idBitllet = lector.nextInt();
            lector.nextLine();
            if(ImplementsBitllets.comprovarBillet(idBitllet)) menu = true;
            else System.out.println("Aquest bitllet no existeix.");
        }while (!menu);
        int preu = ImplementsBitllets.preuBitllet(idBitllet);
        System.out.println("El bitllet costa " + preu + "€ el vos comprar? ");
        String resporsta = lector.nextLine();
        if(resporsta.equalsIgnoreCase("si")) return idBitllet;
        else return -1;
    }

    /**
     * Metode per eliminar un billlet
     * @return
     * @throws Exception
     */
    public static int formEliminarBitllet() throws Exception
    {
        boolean menu = false;
        int idBitllet;
        do
        {
            System.out.println("Entra el bitllet que vos eliminar: ");
            idBitllet = lector.nextInt();
            lector.nextLine();
            if(ImplementsBitllets.comprovarBillet(idBitllet)) menu = true;
            else System.out.println("Aquest bitllet no existeix.");
        }while (!menu);

        return idBitllet;
    }

    /**
     * Metode que crea un billlet i tel retorna
     * @return
     * @throws Exception
     */
    public static Billet formCreaBitllet() throws Exception
    {
       Billet billet = new Billet();


       boolean menu = false;      // Aqui hay una variable que no se utiliza ??
       boolean menu2 = false;
       boolean menu3 = false;
       int idViatge;
       int preuBillet;
       String auxTipusBitllet;
       // variables tipus billet Son enums
       TipusBillet turista = TipusBillet.TURISTA;
       TipusBillet bussines = TipusBillet.BUISSNES;
       TipusBillet premium = TipusBillet.PREMIUM;
       TipusBillet finalTip = null;
       int maxPersones;

       do
       {
           System.out.println("Entra el id de el Viatge de el bitllet: ");
           idViatge = lector.nextInt();
           lector.nextLine();
           if(ImplementsViatjes.comprovarViatge(idViatge)) menu2 = true;
           else System.out.println("Aquest viatge no existeix.");
       }while(!menu2);
       System.out.println("Entra el preu que te el bitllet: ");
       preuBillet = lector.nextInt();
       lector.nextLine();
       do
       {
           System.out.println("Entra de quin tipus sera el bitllet: (TURISTA,BUISSNES,PREMIUM)");
           auxTipusBitllet = lector.nextLine();
           if(auxTipusBitllet.equals(turista.toString()))
           {
               finalTip = turista;
               menu3 = true;
           }
           else if(auxTipusBitllet.equals(bussines.toString()))
           {
               finalTip = bussines;
               menu3 = true;
           }
           else if(auxTipusBitllet.equals(premium.toString()))
           {
               finalTip = premium;
               menu3 = true;
           }
           else System.out.println("Aquest tipus no existeix.");
       }while(!menu3);

       System.out.println("Entra el maxim de Persones que tindran el aquest bitllet: ");
       maxPersones = lector.nextInt();
       lector.nextLine();

       billet.setIdViatge(idViatge);
       billet.setPreuBillet(preuBillet);
       billet.setTipusBillet(finalTip);
       billet.setMaxPersones(maxPersones);

       return billet;
    }
}
