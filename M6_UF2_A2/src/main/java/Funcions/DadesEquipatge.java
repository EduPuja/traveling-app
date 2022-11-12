package Funcions;

import Implements.ImplementsEquipatge;
import Implements.ImplementsUsuari;
import Objectes.Equipatge;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

public class DadesEquipatge
{
    private static Scanner lector = new Scanner(System.in);

    /**
     * Metode que et retorna un objecte equipatge creat ✅
     * @return
     */
    public static Equipatge formCrearEquipatge()
    {
        System.out.println("CREAR EQUIPATGE\n");
        System.out.println("Digues el id equipatge ");
        int idEquip = lector.nextInt();
        lector.nextLine();

        //TODO NUM FACTURA!!! d:
        System.out.println("Digues una factura");
        int numFactura = lector.nextInt();
        lector.nextLine();


        //todo linafactura en equipatge ;(
        System.out.println("Digues la lina factura");
        int linaFactura = lector.nextInt();
        lector.nextLine();

        System.out.println("Digues el pes del equipatge");
        int pesKg = lector.nextInt();
        lector.nextLine();

        System.out.println("Digues les maletes que portes");
        int numMaletes = lector.nextInt();
        lector.nextLine();

        Equipatge equipatge = new Equipatge(); // objecte equipatge

        equipatge.setAllEquipatge(idEquip,numFactura,linaFactura,pesKg,numMaletes);

        return equipatge; // retorno el objecte equipatge
    }

    public static String  fromModificarEquipatge() throws Exception
    {

        boolean menu = false;
        boolean menu2= false;
        int opcio = -1;
        String dades="";
        int pesKg = 0;
        int numMaletes =0;


        do
        {
            System.out.println("Digues el id Equipate que vols entrar");
            int idEquip = lector.nextInt();
            lector.nextLine();
            if(ImplementsEquipatge.comprovarEquipatge(idEquip))
            {
                System.out.println("Equip FIND");
                // he contrado el equipo
                System.out.println("MODIFCAR EQUIPATGE \n");
                System.out.println("Escull la opcio que vols modificar");
                System.out.println("1.Modificar Pes");
                System.out.println("2.Modifcar Num Maletes");
                System.out.println("0.No modifcar res");
                switch (opcio)
                {
                    case 1:
                        // pes
                        System.out.println("Digues el NEW pes: ");
                        pesKg= lector.nextInt();
                        lector.nextLine();

                        dades = dades + "/" + pesKg + "/pes_kg";
                        break;
                    case 2:
                        //num maletes
                        System.out.println("Digues el NEW numero de maletes: ");
                        numMaletes= lector.nextInt();
                        lector.nextLine();
                        dades = dades + "/" + numMaletes + "/num_maletes";
                        break;
                    case 0:
                        System.out.println("Tornars al menu");
                        menu=true;
                        break;
                    default:
                        System.out.println("No tenim aquesta opcio");
                        break;

                }

            }
            else System.out.println("No tenim aquest equipatge");

        }while (!menu || opcio!=0);



    return dades;
    }

    public static void fromDeleteEquipatge()
    {

    }
}

