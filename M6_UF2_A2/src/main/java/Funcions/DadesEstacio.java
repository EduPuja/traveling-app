package Funcions;

import Implements.ImplementsEstacio;
import Objectes.Estacio;

import java.util.Scanner;

public class DadesEstacio
{
    /**
     * Metode per entrar una estacio
     */
    public static Estacio fromAltaEstacio() throws Exception
    {
        Scanner lector = new Scanner(System.in);
        boolean okaEstacio = false;
        int idEstacio=-1;
        String descrip="";
        while (!okaEstacio)
        {
            System.out.println("Digues el idEstacio que vols crear");
             idEstacio = lector.nextInt();
            lector.nextLine();
            if (!ImplementsEstacio.comprovarEstacio(idEstacio))
            {
                System.out.println("Escriu una petita descripcio");
                descrip = lector.nextLine();
                okaEstacio = true;
            } else System.out.println("Aquesta estacio ja exgisteix torna a escriure");
        }
        if(okaEstacio)
        {
            Estacio estacio = new Estacio();
            estacio.setAllEstacio(idEstacio,descrip);
            return estacio;
        }
        return null;
    }

    /**
     * Metode per donar de baixa una estacio
     */
    public static int fromBaixaEstacio() throws Exception
    {
        Scanner lector = new Scanner(System.in);
        System.out.println("Digues la ID de la estacio");
        int idEstacio = lector.nextInt();
        lector.nextLine();

        if(ImplementsEstacio.comprovarEstacio(idEstacio))
        {
            return idEstacio;
        }
        else return -1;
    }
    /**
     * Metode per modifcar una estacio en aquest cas nomes sera la descripcio
     */
    public static String fromUpdateEstacio() throws Exception
    {
        String dades = "";
        Scanner lector = new Scanner(System.in);
        System.out.println("Digues la ID de la estacio");
        int idEstacio = lector.nextInt();
        lector.nextLine();

        if(ImplementsEstacio.comprovarEstacio(idEstacio))
        {
            System.out.println("Entra la nova descripcio: ");
            String desc = lector.nextLine();
            dades = idEstacio + "/" + desc;
            return dades;
        }
        else return dades;
    }




}
