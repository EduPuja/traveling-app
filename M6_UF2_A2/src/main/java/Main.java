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
        String dni = "";
        String password = "";

        //variables de user && admin ( no se utilizan por ahora)
        boolean admin = false;
        boolean userExist = false;

        boolean menu = false;
        do{
            System.out.println("------------------------------------");
            System.out.println("               LogIn                ");
            System.out.println("------------------------------------");
            System.out.println("       Entra el nom d'Usurai:       ");
            dni = lector.nextLine();
            if(dni.equalsIgnoreCase("sortir") || dni.equalsIgnoreCase("exit"))
            {
                menu=true;
                lector.close();
                System.out.println("FI programa");
            }
            else
            {
                System.out.println("     Entra el password d'Usurai:    ");
                password = lector.nextLine();
                System.out.println("------------------------------------");
                userExist = ImplementsUsuari.comprovarUser(dni,password);
                if(dni.equalsIgnoreCase("admin") && password.equalsIgnoreCase("1234"))
                {
                /*admin = true;
                menuGeneral(admin);*/
                    menuAdmin();
                }
                else if (userExist)
                {
                    menuUser();
                }
                else
                {
                    System.out.println("Usuari Incorrecte.");
                }
            }

            /*userExist = ImplementsUsuari.comprovarUser(nom,password,admin);
            if(userExist)
            {
                menuGeneral(admin);
                menu = true;
            }
            else System.out.println("Usuari Incorrecte.");*/
        }while (!menu);

        // falta un else if comprovant que el usuari existeix.

    }

    /**
     * Gestio usuaris
     * @throws Exception
     */
    private static void gestioUsuaris() throws Exception
    {
        InterfaceUsuari daoU = new ImplementsUsuari();
        boolean menu = false;
        int opcio = -1;
        do
        {
            System.out.println("Gestio usuaris\n");
            System.out.println("Entra una opcio: ");
            System.out.println("1 - Alta Usuari");
            System.out.println("2 - Baixa Usuari");
            System.out.println("3 - Modificar Usuari");
            System.out.println("4 - Llistar Usuari");
            System.out.println("0 - Sortir");

            opcio= lector.nextInt();
            lector.nextLine();

            switch (opcio)
            {
                case 1:
                    Persona uAlta = DadesUser.formAltaUser();
                    daoU.altaUser(uAlta);
                    break;
                case 2:
                    String dniUser = DadesUser.formBaixaUser();
                    daoU.baixaUser(dniUser);
                    break;
                case 3:
                    String dades = DadesUser.formUpdateUser();
                    daoU.modificacioUser(dades);
                    break;

                case 0:
                    System.out.println("Toranras al menu Admin\n");
                    menu = true;
                    break;
                default:
                    System.out.println("Opcio incorrecta, Torna a intentar.");
                    break;
            }
        }while(!menu && opcio!=0);
    }

    /**
     * Gestio viatges
     * @throws Exception
     */
    private static void gestioViatges() throws Exception
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

    /**
     * Gestio billets
     * @throws Exception
     */
    private static void gestioBillets() throws Exception
    {
        InterfaceBitllets daoB = new ImplementsBitllets();
        boolean menu = false;
        int opcio=-1;
        do
        {
            System.out.println("GESTIO BILLETS\n");
            System.out.println("Entra una opcio: ");
            System.out.println("1 - Llista Bitllets");
            System.out.println("2 - Compra Bitllets");
            System.out.println("3 - Eliminar Bittlets");
            System.out.println("4 - Crear Bittlets");
            System.out.println("0 - Turn Back");
            opcio = lector.nextInt();
            lector.nextLine();

            switch (opcio)
            {
                case 1:
                    DadesBitllet.formLlistarBitllets();
                    daoB.llistarBitllets();
                    break;
                case 2:
                    Billet bCompra = DadesBitllet.formCompraBitllet();
                    daoB.compraBitllets(bCompra);
                    break;
                case 3:
                    Billet bElimina = DadesBitllet.formEliminarBitllet();
                    daoB.eliminarBitllets(bElimina);
                    break;
                case 4:
                    Billet bCrea = DadesBitllet.formCreaBitllet();
                    daoB.eliminarBitllets(bCrea);
                    break;
                case 0:
                    System.out.println("Toranras al menu admin\n");
                    menu = true;
                    break;
                default:
                    System.out.println("Opcio incorrecta, Torna a intentar.");
                    break;
            }
        }while(!menu && opcio!=0);
    }


    /**
     * menu de admin nomes pot accedir l'admin :D
     * */
    private static void menuAdmin() throws Exception
    {
        boolean menu = false;
        int opcioMenu =-1;

        do
        {
            System.out.println("Benvingut Admin! \n");
            System.out.println("MENU ADMIN\n");
            System.out.println("1.Gestio Users");
            System.out.println("2.Gestio Billets");
            System.out.println("3.Equipatge Stuff");
            System.out.println("4.Factura Stuff");
            System.out.println("5.Gestio Viatge");
            System.out.println("0.Log out");

            opcioMenu= lector.nextInt();
            lector.nextLine();

            switch (opcioMenu)
            {
                case 1:
                    gestioUsuaris();
                    break;
                case 2:
                    gestioBillets();
                    break;
                case 3:
                    //TODO GESTIO EQUIPATGE
                    break;
                case 4:
                    //TODO GESTIO FACTURA
                    break;
                case 5:
                    gestioViatges();
                    break;

                case 0:
                    menu= true;
                    System.out.println("Has tencat la sessio Admin");
                    break;

                default:
                    System.out.println("No tenim aquesta opcio");
                    break;
            }
        }while (!menu && opcioMenu!=0);
    }

    /**
     * MENU DEL USUARI
     */
    private static void menuUser() throws Exception
    {
        boolean menu = false;
        int opcioMenu =-1;

        do
        {
            System.out.println("Benvingut User! \n");
            System.out.println("MENU USER\n");
            System.out.println("1.Listar Viatges");
            System.out.println("2.Comprar Billets");
            System.out.println("0.Log out");

            opcioMenu= lector.nextInt();
            lector.nextLine();

            switch (opcioMenu)
            {
                case 1:
                        //TODO LLISTAR VIATGES
                    break;
                case 2:
                    //TODO COMPRAR BILLETS
                    break;
                case 0:
                    menu= true;
                    System.out.println("Has tencat la sessio admin");

                    //lector.close();
                    break;

                default:
                    System.out.println("No tenim aquesta opcio");
                    break;
            }
        }while (!menu && opcioMenu!=0);

    }
}
