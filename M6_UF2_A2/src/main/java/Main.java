import Funcions.DadesBitllet;
import Funcions.DadesEstacio;
import Funcions.DadesUser;
import Funcions.DadesViatge;
import Implements.ImplementsBitllets;
import Implements.ImplementsEstacio;
import Implements.ImplementsUsuari;
import Implements.ImplementsViatjes;
import Interfaces.InterfaceBitllets;
import Interfaces.InterfaceEstacio;
import Interfaces.InterfaceUsuari;
import Interfaces.InterfaceViatjes;
import objectes.Billet;
import objectes.Estacio;
import objectes.Persona;
import objectes.Viatje;

import java.util.Scanner;

public class Main
{
    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) throws Exception
    {
        String dni = "";
        String password = "";

        //variables admin ( no se utilizan por ahora)
         // boolean admin = false;
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

                if(dni.equalsIgnoreCase("admin") && password.equalsIgnoreCase("1234"))
                {

                    menuAdmin();
                }
                else
                {
                    userExist = ImplementsUsuari.comprovarUser(dni,password);
                    if (userExist)
                    {
                        menuUser();
                    }
                    else
                    {
                        System.out.println("Usuari Incorrecte.");
                    }
                }
            }

        }while (!menu);



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
            System.out.println("3.Gestio Equipatge");
            System.out.println("4.Gestio Factura");
            System.out.println("5.Gestio Viatge");
            System.out.println("6.Gestio Estacio");
            System.out.println("0.Log out");

            opcioMenu= lector.nextInt();
            lector.nextLine();

            switch (opcioMenu)
            {
                case 1:
                    gestioUsuaris();        // menu de gestrio usuari entra users modificar i elminar usuaris
                    break;
                case 2:
                    gestioBillets();        // gestio billets compra billet eliminiacio y llistat
                    break;
                case 3:
                    gestioEquipatge();      // TODO falta this meode
                    break;
                case 4:
                    gestioFactura();        //todo falta gestio factura
                    break;
                case 5:
                    gestioViatges();            // gestio de cada viatge
                    break;
                case 6:
                    gestioEstacio();            // gestio de cada estacio
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


    // ************ METODES GESTIO *****////////





    /**
     * Metode que el que fa es gestiona les estacions
     */
    private static void gestioEstacio() throws Exception
    {
        // interfece de dao estacio
        InterfaceEstacio estacioDao = new ImplementsEstacio();
        boolean menu =false;
        int opcio = -1;

        do
        {
            System.out.println("GESTIO ESTACIONS\n");
            System.out.println("1.Crear una estacio");
            System.out.println("2.Baixa estacio");
            System.out.println("3.Modificar estacions");
            System.out.println("0.Turn back");

            opcio =lector.nextInt();
            lector.nextLine();

            switch (opcio)
            {
                case 1:
                    Estacio estacio = DadesEstacio.fromAltaEstacio();
                    estacioDao.novaEstacio(estacio);
                    break;
                case 2:
                    int idEstacio = DadesEstacio.fromBaixaEstacio();
                    estacioDao.deleteEstacio(idEstacio);
                    break;
                case 3:
                    String dades = DadesEstacio.fromUpdateEstacio();
                    estacioDao.modificarEstacio(dades);
                    break;
                default:
                    System.out.println("No tenim aquesta opcio");
                    break;
            }
        }while (!menu && opcio!=0);

    }

    /**
     * gestio equipatge
     */
    private static void gestioEquipatge()
    {
        
    }

    /**
     * gestio factura
     */
    private static void gestioFactura()
    {
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
                    daoB.llistarBitllets();
                    break;
                case 2:
                    int bIdCompra = DadesBitllet.formCompraBitllet();
                   // daoB.compraBitllets(bIdCompra);           //todo esto no se para que es :D
                    break;
                case 3:
                    int bIdElimina = DadesBitllet.formEliminarBitllet();
                    daoB.eliminarBitllets(bIdElimina);
                    break;
                case 4:
                    Billet bCrea = DadesBitllet.formCreaBitllet();
                    daoB.creaBitllets(bCrea);
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
     * Gestio usuaris Ja esta fet
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
                case 4:
                    daoU.llistarUser();
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


}
