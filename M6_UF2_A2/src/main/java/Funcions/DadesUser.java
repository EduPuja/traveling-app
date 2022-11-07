package Funcions;

import Implements.ImplementsUsuari;
import objectes.Persona;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class DadesUser {
    public static Scanner lector = new Scanner(System.in);
    public static Persona formAltaUser()
    {
        Persona p = new Persona();
        String auxDni = "";
        String nom = "";
        boolean menuDNI = false;
        do{
            System.out.println("Entra el dni de l'Usuari: ");
            auxDni = lector.nextLine();
            menuDNI = comprovaDNI(auxDni);
            if(!menuDNI) System.out.println("DNI incorrecte.");
        }while(!menuDNI);

        System.out.println("Entra el nom de l'Usuari: ");
        nom = lector.nextLine();
        System.out.println("Entra la data de naixement de l'Usuari: ");
        String auxData_naix = lector.nextLine();
        String taula [] = auxData_naix.split("/");
        int dia = Integer.parseInt(taula[0]);
        int mes = Integer.parseInt(taula[1]);
        int any = Integer.parseInt(taula[2]);
        LocalDate data_naixLD = LocalDate.of(any,mes,dia);
        Date data_naixD = Date.valueOf(data_naixLD);

        p.setDni(auxDni);
        p.setNom(nom);
        p.setData_naix(data_naixD);

        return p;
    }
    private static boolean comprovaDNI(String auxDni)
    {
        String codiValidacioDNI="TRWAGMYFPDXBNJZSQVHLCKE";

        boolean valid=true;

        if (auxDni.length()==9) {
            //primer mirem si hi ha 8 nombres
            int i=0;
            while(valid&&i<8) {
                if(!Character.isDigit(auxDni.charAt(i))) valid=false;
                else i++;
            }

            //i ara comprovem la lletra
            long valorDniLong=(Long.parseLong(auxDni.substring(0,8)))%23;// els 8 numeros del dni son massa per integer, hem de fer servir long
            int valorDni=(int)valorDniLong;	// Ara convertim el resultat a enter.
            if(!(auxDni.charAt(8)==codiValidacioDNI.charAt(valorDni))) valid=false;
        }
        else valid = false;

        return valid;

    }
    public static String formBaixaUser()
    {
        String dniB = "";
        boolean menu = false;
        do
        {
            System.out.println("Entra el DNI de l'Usuari que vos donar de baixa: ");
            dniB = lector.nextLine();
            if(ImplementsUsuari.comprovarUserBaixa_Update(dniB))menu = true;
            else System.out.println("Aquest DNI no existeix.");
        }while(!menu);
        return dniB;
    }
    public static String formUpdateUser()
    {
        String dades = "";
        boolean menu = false;
        boolean menu2 = false;
        do
        {
            System.out.println("Entra el DNI de l'Usuari que vos modificar: ");
            dades = lector.nextLine();
            if(ImplementsUsuari.comprovarUserBaixa_Update(dades))menu = true;
            else System.out.println("Aquest DNI no existeix.");
        }while(!menu);
        if(menu)
        {
            do{
                System.out.println("Entra una opcio:");
                System.out.println("1 - Modificar el DNI.");
                System.out.println("2 - Modificar el NOM.");
                System.out.println("3 - Modificar la DATA DE NAIXEMENT.");
            }while(!menu2);
        }
        return dades;
    }
}
