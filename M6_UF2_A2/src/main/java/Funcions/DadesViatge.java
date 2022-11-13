package Funcions;

import Implements.ImplementsEstacio;
import Implements.ImplementsViatjes;
import Interfaces.InterfaceEstacio;
import Objectes.Viatje;

import java.util.Scanner;

public class DadesViatge
{


    static Scanner lector =new Scanner(System.in);

    /**
     * Metode que crea un nou viatge en el main ✅
     * @return
     * @throws Exception
     */
    public static Viatje formNouViatge()  throws Exception
    {
        // necesitas el dao para poder listar todas las estaciones :D
        InterfaceEstacio estacioDao = new ImplementsEstacio();

        // varibles per origen i desti
        boolean okaIdOrigen = false;
        boolean okaIdDesti = false;
        int idOrigen =-1;
        int idDesti =-1;

        // objecte que sera retornat
        Viatje viatge = new Viatje();

        // pregunto les metadades de cada objecte
        System.out.println("Digues el teu id Viatge");
        int idViatge = lector.nextInt();
        lector.nextLine();


        estacioDao.llistarEstacio();

        while (!okaIdOrigen)
        {
            System.out.println("Digues el teu idOrigen ");
            idOrigen = lector.nextInt();
            lector.nextLine();

            if(ImplementsEstacio.comprovarEstacio(idOrigen))
            {
                System.out.println("Origen Correcte\n");
                okaIdOrigen= true;
            }
            else System.out.println("Aquest origen no egisteix\n");

        }


        estacioDao.llistarEstacio();

        while (!okaIdDesti)
        {
            System.out.println("Digues el teu idDesti");
            idDesti = lector.nextInt();
            lector.nextLine();

            if(ImplementsEstacio.comprovarEstacio(idDesti))
            {
                System.out.println("Desti correcte\n");
                okaIdDesti=true;
            }
            else System.out.println("Desti No trobat\n");
        }


        System.out.println("Digues el pais que volugis");
        String pais = lector.nextLine();


        if(okaIdOrigen && okaIdDesti)
        {
            // empleno el objecet amb un set general
            viatge.setAllViajte(idViatge,idOrigen,idDesti,pais);
            return  viatge;
        }
        else
        {
            System.out.println("Error en els origens o destins D:\n");
        }


        return  viatge;

    }

    /**
     * Metode que et retorna el id del Viatge per poderlo eliminar ✅
     * @return
     * @throws Exception
     */
    public static int formEliminarViatge() throws Exception
    {
        boolean menu = false;
        do
        {
            System.out.println("Digues el idViatge que vols eliminar");
            int idViatgeDelete = lector.nextInt();
            lector.nextLine();

            if(ImplementsViatjes.comprovarViatge(idViatgeDelete))
            {
                menu=true;
                return idViatgeDelete;
            }
            else System.out.println("Aquest viatge no exgisteix");
        }while (!menu);

        return -1;
    }
    public static String formUpdateViatge() throws Exception
    {
        return " ";
    }
}
