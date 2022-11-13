package Funcions;

import Implements.*;
import Objectes.Equipatge;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Map;
import java.util.Scanner;

public class DadesEquipatge
{
    private static Scanner lector = new Scanner(System.in);

    /**
     * Metode que et retorna un objecte equipatge creat ✅
     * @return
     */
    public static Equipatge formCrearEquipatge() throws Exception
    {

        Equipatge equipatge = new Equipatge(); // objecte equipatge

        boolean okaIdEquip = false;
        boolean okNumFact = false;
        boolean okaLinaFactura = false;


        int idEquip=-1 , numFactura =-1 , linaFactura =-1;

        System.out.println("CREAR EQUIPATGE\n");


        while (!okaIdEquip)
        {
            System.out.println("Digues el id equipatge ");
            idEquip = lector.nextInt();
            lector.nextLine();

            if(!ImplementsEquipatge.comprovarEquipatge(idEquip))
            {
                System.out.println("Equipatge GOOD");
                okaIdEquip=true;
            }
            else System.out.println("Aquest Equipatge ja exgisteix");
        }



        while (!okNumFact)
        {
            System.out.println("Digues una factura");
            numFactura = lector.nextInt();
            lector.nextLine();

            if(ImplementsFactura.comprovaNumFact(numFactura))
            {
                System.out.println("Numero de factura Correcte");
                okNumFact=true;
            }
            else System.out.println("Aquest numero factura no es correcte D:");
        }



        while (!okaLinaFactura)
        {
            System.out.println("Digues la lina factura");
            linaFactura = lector.nextInt();
            lector.nextLine();
            if(ImplementsLiniaFactura.consultarLiniaFactura(linaFactura))
            {
                System.out.println("Lina Factura correcte! ");
                okaLinaFactura=true;
            }
            else System.out.println("Lina factura NO correcte");
        }

        System.out.println("Digues el pes del equipatge");
        int pesKg = lector.nextInt();
        lector.nextLine();

        System.out.println("Digues les maletes que portes");
        int numMaletes = lector.nextInt();
        lector.nextLine();


        if(okaIdEquip && okaLinaFactura && okNumFact)
        {
            equipatge.setAllEquipatge(idEquip,numFactura,linaFactura,pesKg,numMaletes);

            return equipatge; // retorno el objecte equipatge
        }
        else System.out.println("Equipatge Error ");

        return equipatge;
    } // ✅


    /**
     * Equipatge modificacio ✅
     * @return
     * @throws Exception
     */
    public static String  fromModificarEquipatge() throws Exception
    {

        boolean menu = false;
        boolean okaIdEquip= false;
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
    } // ✅


    /**
     * Metode que elimina un equipatge i et retorna la posicio del id ✅
     * @return
     * @throws Exception
     */
    public static int fromDeleteEquipatge() throws Exception
    {
        boolean menu = false;
        do
        {
            System.out.println("Digues el idEquipatge que vols eliminar");
            int idEquip =lector.nextInt();
            if (ImplementsEquipatge.comprovarEquipatge(idEquip))
            {
                menu =true;
                return idEquip;
            }
            else System.out.println("Aquest Equipatge no exgisteix");
        }while (!menu);

        return -1;
    }
}

