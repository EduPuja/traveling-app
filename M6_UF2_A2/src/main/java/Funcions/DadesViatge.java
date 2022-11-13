package Funcions;

import Implements.ImplementsEstacio;
import Implements.ImplementsUsuari;
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
        boolean okaIdViatge = false;
        int idOrigen =-1;
        int idDesti =-1;

        int idViatge= -1;

        // objecte que sera retornat
        Viatje viatge = new Viatje();

        // pregunto les metadades de cada objecte

        while (!okaIdViatge)
        {
            System.out.println("Digues el teu id Viatge");
            idViatge = lector.nextInt();
            lector.nextLine();

            if(!ImplementsViatjes.comprovarViatge(idViatge))
            {
               okaIdViatge=true;
            }
            else System.out.println("Aquest viatge ja exgisteix");
        }



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


        if(okaIdOrigen && okaIdDesti && okaIdViatge)
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

    /**
     * Metode que et retorna un string amb la info modificada de un viatge ✅
     * @return
     * @throws Exception
     */
    public static String formUpdateViatge() throws Exception
    {

       String dades = "";       // variable dades on passa la magia
       // variables menu ;D
       boolean menu = false;
       boolean menu2 =false;

       // variables que comproven si el origen i desti estan corretes
       boolean okaDesti=false;
       boolean okaOrigen =false;

       int idViatgeMod ;     // id del desti
        do
       {
           System.out.println("Digues el idViatge que vols modificar ");
           idViatgeMod = lector.nextInt();
           lector.nextLine();
           if(ImplementsViatjes.comprovarViatge(idViatgeMod))
           {
               menu=true;
           }
           else System.out.println("Viatge Not found D: ");
       }while (!menu);


       if(menu)
       {
           dades = ""+idViatgeMod;  // guardar la id del viatge en la variable dades
           InterfaceEstacio estacioDao = new ImplementsEstacio();

           do
           {
               System.out.println("Escull una opcio!\n");
               System.out.println("1 - Modificar Origen");
               System.out.println("2 - Modificar Desti");
               System.out.println("3 - Modificar Pais");
               System.out.println("0.Discard Changes");
               int opcio = lector.nextInt();
               lector.nextLine();
               switch (opcio)
               {
                   case 1:
                       //mod origen
                       int idOrigen = -1;
                       System.out.println("Llistat Estacions ");
                       estacioDao.llistarEstacio();
                      while (!okaOrigen)
                      {
                          System.out.println("Escull ID estacio ORIGEN: ");
                          idOrigen = lector.nextInt();
                          lector.nextLine();

                          if(ImplementsEstacio.comprovarEstacio(idOrigen))
                          {
                              okaOrigen=true;
                          }
                          else System.out.println("Origen not found ");
                      }
                      dades = dades+"/"+idOrigen+"/id_origen";
                      menu2 = true;


                       break;
                   case 2:
                       // mod desti
                       int idDesti=-1;
                       while (!okaDesti)
                       {

                           System.out.println("Llistat Estacions ");
                           estacioDao.llistarEstacio();;

                           System.out.println("Escull ID estacio DESTI: ");
                           idDesti = lector.nextInt();
                           lector.nextLine();
                           if (ImplementsEstacio.comprovarEstacio(idDesti))
                           {
                               okaDesti=true;
                           }
                           else System.out.println("Desti not found ");
                       }

                        if (okaDesti)  dades = dades+"/"+idDesti+"/id_desti";
                       menu2 = true;

                       break;
                   case 3:
                       // mod pais
                        System.out.println("Digues el nou PAIS: ");
                        String newPais = lector.nextLine();

                        dades = dades+"/"+newPais+"/pais";
                       menu2 = true;
                       break;
                   case 0:
                       System.out.println("NO SE HA MODIFCAT RES");
                       dades="no";
                       menu2=true;
                       break;
                   default:
                       System.out.println("No tenim aquesta opcio");
                       break;
               }


           }while (!menu2);
       }
        return dades;   // dades on passo faig la maiga
    }
}
