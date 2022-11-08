package Funcions;

import Implements.ImplementsEstacio;
import Interfaces.InterfaceEstacio;
import objectes.Estacio;

import java.util.Scanner;

public class DadesEstacio
{
    /**
     * Metode per entrar una estacio
     */
    public void fromAltaEstacio() throws Exception
    {
        Scanner lector = new Scanner(System.in);



        boolean okaEstacio = false;

        while (!okaEstacio)
        {
            System.out.println("Digues el idEstacio que vols crear");
            int idEstacio = lector.nextInt();
            lector.nextLine();


            if (!ImplementsEstacio.comprovarEstacio(idEstacio))
            {
                System.out.println("Escriu una petita descripcio");
                String descrip = lector.nextLine();

                Estacio estacio = new Estacio(idEstacio,descrip);

                okaEstacio = true;
            } else System.out.println("Aquesta estacio ja exgisteix torna a escriure");


        }
        lector.close();


    }

    /**
     * Metode per donar de baixa una estacio
     */
    public void fromBaixaEstacio()
    {

    }

    /**
     * Metode per modifcar una estacio en aquest cas nomes sera la descripcio
     */
    public void modificacioEstacio()
    {

    }


}
