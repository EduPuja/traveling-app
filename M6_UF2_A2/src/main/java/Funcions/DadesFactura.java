package Funcions;

import Implements.ImplementsFactura;
import Implements.ImplementsUsuari;
import Interfaces.InterfaceFactura;
import Interfaces.InterfaceUsuari;
import Objectes.Factura;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class DadesFactura {

    public static Scanner lector = new Scanner(System.in);

    public static Factura fromAltaFactura(String dni) throws Exception
    {
        boolean menu = false;

        Factura f = new Factura();
        boolean menu2 = false;
        Random rdm = new Random();
        int num_factura;
        do{
            num_factura = rdm.nextInt(5000);
            if(!ImplementsFactura.comprovaNumFact(num_factura)) menu2 = true;
        }while(!menu2);

        LocalDate data_naixLD = LocalDate.now();
        Date data_naixD = Date.valueOf(data_naixLD);

        f.setNumFactura(num_factura);
        f.setIdPersona(ImplementsFactura.dniAid(dni));
        f.setData(data_naixD);
        return f;
    } // ✅
    public static Factura fromAltaFacturaAdmin() throws Exception
    {
        boolean menu = false;
        String dni;
        int num_factura;
        Factura f = new Factura();
        boolean menu2 = false;
        do{
            System.out.println("Entra el numero de la factura: ");
            num_factura = lector.nextInt();
            lector.nextLine();
            if(ImplementsFactura.comprovaNumFact(num_factura)) System.out.println("Numero de la factura.");
            else menu2 = true;
        }while(!menu2);
        do{
            System.out.println("Entra el dni de l'usuari: ");
            dni = lector.nextLine();
            if(ImplementsUsuari.comprovarUserBaixa_Update_Alta(dni)) menu = true;
            else System.out.println("Dni es incorrecte.");
        }while(!menu);
        System.out.println("Entra la data de la factura: ");
        String data = lector.nextLine();

        String taula[] = data.split("/");
        int dia = Integer.parseInt(taula[0]);
        int mes = Integer.parseInt(taula[1]);
        int any = Integer.parseInt(taula[2]);
        LocalDate data_naixLD = LocalDate.of(any,mes,dia);
        Date data_naixD = Date.valueOf(data_naixLD);

        f.setNumFactura(num_factura);
        f.setIdPersona(ImplementsFactura.dniAid(dni));
        f.setData(data_naixD);
        return f;
    } // ✅
    public static int fromBaixaFactura() throws Exception
    {

        boolean menu = false;
        int num_factura;
        boolean menu2 = false;
        do{
            System.out.println("Entra el numero de la factura: ");
            num_factura = lector.nextInt();
            lector.nextLine();
            if(ImplementsFactura.comprovaNumFact(num_factura)) menu2 = true;
            else System.out.println("Numero de la factura inexistent.");
        }while(!menu2);

        return num_factura;
    } // ✅
    public static String fromUpdateFactura() throws Exception
    {
        String dades = "";
        int num_factura;
        int num_factura2;
        String dni_persona;
        int id_persona;
        int preu_total;
        String data_factura;
        boolean menu = false;
        boolean menu2 = false;

        do{
            System.out.println("Enscull el numero de factura a modificar: ");
            num_factura = lector.nextInt();
            lector.nextLine();
            if(ImplementsFactura.comprovaNumFact(num_factura)) menu = true;
            else System.out.println("Aquest num no existeix.");
        }while(!menu);
        if(menu)
        {
            dades = dades + num_factura;
            do{
                System.out.println("Entra una opcio: ");
                System.out.println("1 - Modifica NUMERO FACTURA: ");
                System.out.println("2 - Modifica DNI PERSONA: ");
                System.out.println("3 - Modifica PREU TOTAL: ");
                System.out.println("4 - Modifica DATA FACTURA: ");
                int opcio = lector.nextInt();
                lector.nextLine();
                switch (opcio){
                    case 1:
                        boolean menu3 = false;
                        do{
                            System.out.println("Enscull el nou numero factura: ");
                            num_factura2 = lector.nextInt();
                            lector.nextLine();
                            if(ImplementsFactura.comprovaNumFact(num_factura2))System.out.println("Aquest num ja existeix.");
                            else  menu3 = true;
                        }while(!menu3);
                        dades = dades + "/" + num_factura2 + "/num_factura";
                        menu2 = true;
                        break;
                    case 2:
                        boolean menu4 = false;
                        InterfaceUsuari daoU = new ImplementsUsuari();
                        System.out.println("Llistat usuaris: ");
                        daoU.llistarUser();
                        do{
                            System.out.println("Enscull el dni de el usuari: ");
                            dni_persona = lector.nextLine();
                            if(ImplementsUsuari.comprovarUserBaixa_Update_Alta(dni_persona)) menu4 = true;
                            else System.out.println("Aquest id no existeix.");
                        }while(!menu4);
                        id_persona = ImplementsFactura.dniAid(dni_persona);
                        dades = dades + "/" + id_persona + "/id_persona";
                        menu2 = true;
                        break;
                    case 3:
                        System.out.println("Entra el nou preu:");
                        preu_total = lector.nextInt();
                        lector.nextLine();
                        dades = dades + "/" + preu_total + "/preu_total";
                        menu2 = true;
                        break;
                    case 4:
                        System.out.println("Entra la data de naixement nova de l'Usuari: ");
                        data_factura = lector.nextLine();
                        dades = dades + "/" + data_factura + "/data_factura";
                        menu2 = true;
                        break;
                    case 5:
                        dades = "no";
                        menu2 = true;
                        break;
                    default:
                        break;
                }
            }while (!menu2);

        }
        return dades;
    } // ✅
}
