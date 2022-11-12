package Funcions;

import Implements.ImplementsFactura;
import Implements.ImplementsUsuari;
import Interfaces.InterfaceFactura;
import Objectes.Factura;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class DadesFactura {

    public static Scanner lector = new Scanner(System.in);

    public static Factura fromAltaFactura(String dni) throws Exception {
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
    }
    public static Factura fromAltaFacturaAdmin() throws Exception {
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
    }
}
