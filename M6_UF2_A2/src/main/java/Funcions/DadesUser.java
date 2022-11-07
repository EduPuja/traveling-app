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
        boolean menu = false;
        do
        {
            boolean menuDNI = false;
            do{
                System.out.println("Entra el dni de l'Usuari: ");
                auxDni = lector.nextLine();
                menuDNI = comprovaDNI(auxDni);
                if(!menuDNI) System.out.println("DNI incorrecte.");
            }while(!menuDNI);
            if(ImplementsUsuari.comprovarUserBaixa_Update_Alta(auxDni))System.out.println("Aquest DNI ja existeix.");
            else menu = true;
        }while(!menu);

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
            boolean menuDNI = false;
            do{
                System.out.println("Entra el DNI de l'Usuari que vos donar de baixa: ");
                dniB = lector.nextLine();
                menuDNI = comprovaDNI(dniB);
                if(!menuDNI) System.out.println("DNI incorrecte.");
            }while(!menuDNI);
            if(ImplementsUsuari.comprovarUserBaixa_Update_Alta(dniB))menu = true;
            else System.out.println("Aquest DNI no existeix.");
        }while(!menu);
        return dniB;
    }
    public static String formUpdateUser()
    {
        String dades = "";
        String dni = "";
        String nom = "";
        String auxData_naix = "";
        boolean menu = false;
        boolean menu2 = false;
        boolean menu3 = false;
        do
        {
            boolean menuDNI = false;
            do{
                System.out.println("Entra el DNI de l'Usuari que vos modificar: ");
                dades = lector.nextLine();
                menuDNI = comprovaDNI(dades);
                if(!menuDNI) System.out.println("DNI incorrecte.");
            }while(!menuDNI);
            if(ImplementsUsuari.comprovarUserBaixa_Update_Alta(dades))menu = true;
            else System.out.println("Aquest DNI no existeix.");
        }while(!menu);
        if(menu)
        {
            do{
                System.out.println("Entra una opcio:");
                System.out.println("1 - Modificar el DNI.");
                System.out.println("2 - Modificar el NOM.");
                System.out.println("3 - Modificar la DATA DE NAIXEMENT.");
                System.out.println("0 - Sortir.");
                int opcio = lector.nextInt();
                lector.nextLine();
                switch(opcio){
                    case 1:

                        do
                        {
                            boolean menuDNI = false;
                            do{
                                System.out.println("Entra el dni nou de l'Usuari: ");
                                dni = lector.nextLine();
                                menuDNI = comprovaDNI(dni);
                                if(!menuDNI) System.out.println("DNI incorrecte.");
                            }while(!menuDNI);
                            if(ImplementsUsuari.comprovarUserBaixa_Update_Alta(dni))System.out.println("Aquest DNI ja existeix.");
                            else menu3 = true;
                        }while(!menu3);
                        dades = dades + "/" + dni + "/dni";
                        break;
                    case 2:
                        System.out.println("Entra el nom nou de l'Usuari: ");
                        nom = lector.nextLine();
                        dades = dades + "/" + nom + "/nom";
                        break;
                    case 3:
                        System.out.println("Entra la data de naixement nova de l'Usuari: ");
                        auxData_naix = lector.nextLine();
                        dades = dades + "/" + auxData_naix + "/data_naix";
                        break;
                    case 4:
                        menu2 = true;
                        dades = "no";
                        break;
                    default:
                        break;
                }
            }while(!menu2);
        }
        return dades;// dades esta format en el seguent format (dni/dade modificada/tipo de dada);
    }
}
