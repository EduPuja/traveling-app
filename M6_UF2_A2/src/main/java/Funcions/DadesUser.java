package Funcions;

import objectes.Persona;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;
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
        return false;
    }
    public static Persona formBaixaUser()
    {
        return null;
    }
    public static Persona formUpdateUser()
    {
        return null;
    }
}
