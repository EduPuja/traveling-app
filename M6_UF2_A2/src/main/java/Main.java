import Funcions.DadesBitllet;
import Funcions.DadesUser;
import Funcions.DadesViatge;
import Implements.ImplementsBitllets;
import Implements.ImplementsUsuari;
import Implements.ImplementsViatjes;
import Interfaces.InterfaceBitllets;
import Interfaces.InterfaceUsuari;
import Interfaces.InterfaceViatjes;
import objectes.Billet;
import objectes.Persona;
import objectes.Viatje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main
{
    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) throws Exception
    {
        String nom = "";
        String password = "";
        boolean admin = false;
        boolean userExist = false;
        boolean menu = false;
        do{
            System.out.println("------------------------------------");
            System.out.println("               LogIn                ");
            System.out.println("------------------------------------");
            System.out.println("       Entra el nom d'Usurai:       ");
            nom = lector.nextLine();
            System.out.println("     Entra el password d'Usurai:    ");
            password = lector.nextLine();
            System.out.println("------------------------------------");

            if(nom.equalsIgnoreCase("admin") && password.equalsIgnoreCase("1234"))
            {
                admin = true;
                menuGeneral(admin);
            }
            userExist = ImplementsUsuari.comprovarUser(nom,password,admin);
            if(userExist)
            {
                menuGeneral(admin);
                menu = true;
            }
            else System.out.println("Usuari Incorrecte.");
        }while (!menu);

        // falta un else if comprovant que el usuari existeix.

    }
    private static void menuUsuaris() throws Exception
    {
        InterfaceUsuari daoU = new ImplementsUsuari();
        boolean menu = false;
        do{
            System.out.println("Entra una opcio: ");
            System.out.println("1 - Alta Usuari");
            System.out.println("2 - Baixa Usuari");
            System.out.println("3 - Modificar Usuari");
            System.out.println("0 - Sortir");

            int opcio = lector.nextInt();
            lector.nextLine();

            switch (opcio)
            {
                case 1:
                    Persona uAlta = DadesUser.formAltaUser();
                    daoU.altaUser(uAlta);
                    break;
                case 2:
                    Persona uBaixa = DadesUser.formBaixaUser();
                    daoU.baixaUser(uBaixa);
                    break;
                case 3:
                    Persona uUpdate = DadesUser.formUpdateUser();
                    daoU.modificacioUser(uUpdate);
                    break;
                case 0:
                    System.out.println("Adeu.");
                    menu = true;
                    break;
                default:
                    System.out.println("Opcio incorrecta, Torna a intentar.");
                    break;
            }
        }while(!menu);
    }
    private static void menuViatges() throws Exception
    {
        InterfaceViatjes daoV = new ImplementsViatjes();
        boolean menu = false;
        do
        {
            System.out.println("Entra una opcio: ");
            System.out.println("1 - Nou Viatje");
            System.out.println("2 - Eliminar Viatje");
            System.out.println("3 - Modificar Viatje");
            System.out.println("0 - Sortir");

            int opcio = lector.nextInt();
            lector.nextLine();

            switch (opcio)
            {
                case 1:
                    Viatje vNou = DadesViatge.formNouViatge();
                    daoV.nouViatje(vNou);
                    break;
                case 2:
                    Viatje vEliminar = DadesViatge.formEliminarViatge();
                    daoV.eliminarViatje(vEliminar);
                    break;
                case 3:
                    Viatje vUpdate = DadesViatge.formUpdateViatge();
                    daoV.modificarViatje(vUpdate);
                    break;
                case 0:
                    System.out.println("Adeu.");
                    menu = true;
                    break;
                default:
                    System.out.println("Opcio incorrecta, Torna a intentar.");
                    break;
            }
        }while(!menu);
    }
    private static void menuBitllets(Boolean admin) throws Exception
    {
        InterfaceBitllets daoB = new ImplementsBitllets();
        boolean menu = false;
        do
        {
            System.out.println("Entra una opcio: ");
            System.out.println("1 - Llista Bitllets");
            if(!admin) System.out.println("2 - Compra Bitllets");
            if(admin) System.out.println("3 - Eliminar Bittlets");
            System.out.println("0 - Sortir");
            int opcio = lector.nextInt();
            lector.nextLine();

            switch (opcio){
                case 1:
                    DadesBitllet.formLlistarBitllets();
                    daoB.llistarBitllets();
                    break;
                case 2:
                    Billet bCompra = DadesBitllet.formCompraBitllet();
                    daoB.compraBitllets(bCompra);
                    break;
                case 3:
                    if(admin)
                    {
                        Billet bElimina = DadesBitllet.formEliminarBitllet();
                        daoB.eliminarBitllets(bElimina);
                    }
                    else System.out.println("Opcio incorrecta, Torna a intentar.");
                    break;
                case 0:
                    System.out.println("Adeu.");
                    menu = true;
                    break;
                default:
                    System.out.println("Opcio incorrecta, Torna a intentar.");
                    break;
            }
        }while(!menu);
    }
    public static void menuGeneral(Boolean admin) throws Exception
    {
        boolean menu = false;
        do
        {
            System.out.println("Entra una opcio: ");
            if(admin)
            {
                System.out.println("1 - Gestio de Bitllets");
                System.out.println("2 - Gestio d'Usuaris");
                System.out.println("3 - Gestio de Viatges");
            }
            else System.out.println("1 - Compra Bitllets");
            System.out.println("0 - Sortir");

            int opcio = lector.nextInt();
            lector.nextLine();

            switch (opcio)
            {
                case 1:
                    menuBitllets(admin);
                    break;
                case 2:
                    if(admin) menuUsuaris();
                    else System.out.println("Opcio incorrecta, Torna a intentar.");
                    break;
                case 3:
                    if(admin) menuViatges();
                    else System.out.println("Opcio incorrecta, Torna a intentar.");
                    break;
                case 0:
                    System.out.println("Adeu.");
                    menu = true;
                    break;
                default:
                    break;
            }
        }while(!menu);
    }
}
