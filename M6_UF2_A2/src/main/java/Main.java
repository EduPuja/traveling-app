import Funcions.*;
import Implements.*;
import Interfaces.*;
import Objectes.*;

import java.util.Scanner;

public class Main
{
    public static Scanner lector = new Scanner(System.in);
    public static String dniUserLog = "";
    public static String passwordUserLog = "";

    /**
     * Main ✅
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {


        //variables admin ( no se utilizan por ahora)
         // boolean admin = false;
        boolean userExist = false;

        boolean menu = false;
        do{
            System.out.println("------------------------------------");
            System.out.println("               LogIn                ");
            System.out.println("------------------------------------");
            System.out.println("       Entra el DNI d'Usurai:       ");
            dniUserLog = lector.nextLine();
            if(dniUserLog.equalsIgnoreCase("sortir") || dniUserLog.equalsIgnoreCase("exit"))
            {
                System.out.println("End Program");
                menu=true;
                lector.close();

            }
            else
            {
                System.out.println("     Entra el password d'Usurai:    ");
                passwordUserLog = lector.nextLine();
                System.out.println("------------------------------------");

                if(dniUserLog.equalsIgnoreCase("admin") && passwordUserLog.equalsIgnoreCase("1234"))
                {

                    menuAdmin();
                }
                else
                {
                    userExist = ImplementsUsuari.comprovarUser(dniUserLog,passwordUserLog);
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
    } // main ✅

    /**
     * menu de admin nomes pot accedir l'admin :D ✅
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
                    gestioUsuaris();        // menu de gestrio usuari entra users modificar i elminar usuaris✅
                    break;
                case 2:
                    gestioBillets();        // menu de gesito de bitllets ✅
                    break;
                case 3:
                    gestioEquipatge();      // TODO falta this meode
                    break;
                case 4:
                    gestioFactura();        //gestio de cada factura ✅
                    break;
                case 5:
                    gestioViatges();        //gestio vaitges ✅
                    break;
                case 6:
                    gestioEstacio();     // gestio de cada estacio ✅
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
     * MENU DEL USUARI ✅
     */
    private static void menuUser() throws Exception
    {
        InterfaceBitllets daoB = new ImplementsBitllets();
        boolean menu = false;
        int opcioMenu =-1;

        do
        {
            System.out.println("Benvingut User! \n");
            System.out.println("MENU USER\n");
            System.out.println("1.Listar Bitllets");
            System.out.println("2.Comprar Billets");
            System.out.println("0.Log out");

            opcioMenu= lector.nextInt();
            lector.nextLine();

            switch (opcioMenu)
            {
                case 1:
                  //LLISTAR TOTS BILLETS
                    daoB.llistarBitllets();
                    break;
                case 2:
                    //TODO COMPRAR BILLETS
                    int idBCompra = DadesUser.formCompraBitllet();
                    daoB.compraBitllets(idBCompra,dniUserLog);
                    break;
                case 0:
                    menu= true;
                    System.out.println("Has tencat la sessio admin");
                    break;

                default:
                    System.out.println("No tenim aquesta opcio");
                    break;
            }
        }while (!menu && opcioMenu!=0);

    }

    // ************ METODES GESTIO *****////////

    /**
     * Metode que el que fa es gestiona les estacions ✅
     *
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
            System.out.println("1.Llistar estacions");
            System.out.println("2.Crear una estacio");
            System.out.println("3.Baixa estacio");
            System.out.println("4.Modificar estacions");
            System.out.println("0.Turn back");

            opcio =lector.nextInt();
            lector.nextLine();

            switch (opcio)
            {
                case 1:
                    estacioDao.llistarEstacio();
                    break;
                case 2:
                    Estacio estacio = DadesEstacio.fromAltaEstacio();
                    estacioDao.novaEstacio(estacio);
                    break;
                case 3:
                    int idEstacio = DadesEstacio.fromBaixaEstacio();
                    estacioDao.deleteEstacio(idEstacio);
                    break;
                case 4:
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
     * TODO FALTA TODO EL EQUPAGE.
     */
    private static void gestioEquipatge() throws Exception
    {
        InterfaceEquipatge daoEquipatge = new ImplementsEquipatge();
        boolean menu = false;
        int opcio = -1;
        do
        {
            System.out.println("GESTIO EQUIPATGE\n");
            System.out.println("1.Llistar Equipatge Usuari");
            System.out.println("2.Alta Equipatge");
            System.out.println("3.Baixa Equipatge");
            System.out.println("4.Modificar Equipatge");
            System.out.println("0.Turn Back");
            opcio=lector.nextInt();
            lector.nextLine();
            switch (opcio)
            {
                case 1:
                        //listar
                    daoEquipatge.llistarEquipatge();
                    break;
                case 2:
                        //alta
                    Equipatge equip = DadesEquipatge.formCrearEquipatge();
                    daoEquipatge.afegirEquipatge(equip);
                    break;
                case 3:
                    //baixa
                    int idEquip = DadesEquipatge.fromDeleteEquipatge();
                    daoEquipatge.eliminarEquipatge(idEquip);
                    break;
                case 4:
                        // mod
                    String dades = DadesEquipatge.fromModificarEquipatge();
                    daoEquipatge.modificarEquipatge(dades);
                    break;
                case 0:
                    System.out.println("Toranras al menu admin");
                    menu=true;
                    break;
                default:
                    System.out.println("No tenim aquesta opico");
                    break;
            }
        }while (!menu && opcio!=0);

    }

    /**
     * Getstio LINIA factura ✅
     *
     */
   /* private static void gestioLiniaFactura() throws Exception
    {
        InterfaceLiniaFactura daoLinaFactura = new ImplementsLiniaFactura();
        boolean menu =false;
        int opcio = -1;

        do
        {
            System.out.println("GESTIO LINIA FACTURA\n");
            System.out.println("1.Llista lineas de una factura.");
            System.out.println("2.ALTA LINIA FACTURA");
            System.out.println("3.Baixa LINIA FACTURA");
            System.out.println("4.Modificacio FACTURA");
            System.out.println("0.Turn back");
            opcio=lector.nextInt();
            lector.nextLine();
            switch (opcio)
            {
                case 1:
                      //llistar lina
                    daoLinaFactura.llistarLiniaFactura();
                    break;
                case 2:
                    //alta lina
                    Linia_Factura liniaFactura = DadesLiniaFactura.fromAltaLinaFactura();
                    daoLinaFactura.crearLiniaFactura(liniaFactura);
                    break;
                case 3:
                    ///baixa lina
                    int idLinaFactura = DadesLiniaFactura.fromBaixaLinaFactura();
                    daoLinaFactura.eliminarLiniaFactura(idLinaFactura);
                    break;
                case 4:
                    //modiiciar lina
                    String dades = DadesEstacio.fromUpdateEstacio();
                    daoLinaFactura.modificarLiniaFactura(dades);
                    break;
                case 0:
                    System.out.println("Toranras al menu admin");
                    menu=true;
                    break;
                default:
                    System.out.println("No tenim aquesta opico");
                    break;

            }
        }while (!menu && opcio!=0);

    }*/

    /**
     * gestio factura  ✅
     *
     */
    private static void gestioFactura() throws Exception
    {
        InterfaceFactura daoF = new ImplementsFactura();
        boolean menu = false;
        int opcio=-1;
        do
        {
            System.out.println("GESTIO FACUTRA\n");
            System.out.println("1.Llistar factures");
            System.out.println("2.Alta factura");
            System.out.println("3.Baixa factura");
            System.out.println("4.Modifciar factura");
            System.out.println("0.Turn back");
            opcio=lector.nextInt();
            lector.nextLine();

            switch (opcio)
            {
                case 1:
                    daoF.llistarFactura();
                    break;
                case 2:
                    Factura f = DadesFactura.fromAltaFacturaAdmin();
                    daoF.crearFacturaAdmin(f);
                    break;
                case 3:
                    int idF = DadesFactura.fromBaixaFactura();
                    daoF.eliminarFactura(idF);
                    break;
                case 4:
                    String dades = DadesFactura.fromUpdateFactura();
                    daoF.modificarFactura(dades);
                    break;
                case 0:
                    System.out.println("Tornaras al menu admin");
                    menu=true;
                    break;
                default:
                    System.out.println("No tenim aquesta opcio");
                    break;
            }
        }while (!menu && opcio!=0);

    }  // ✅

    /**
     * Gestio billets✅
     * @throws Exception
     *
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
            System.out.println("2 - Eliminar Bittlets");
            System.out.println("3 - Crear Bittlets");
            System.out.println("0 - Turn Back");
            opcio = lector.nextInt();
            lector.nextLine();

            switch (opcio)
            {
                case 1:
                    //LLISTAR
                    daoB.llistarBitllets();
                    break;
                case 2:
                    // ELIMINAR
                    int bIdElimina = DadesBitllet.formEliminarBitllet();
                    daoB.eliminarBitllets(bIdElimina);
                    break;
                case 3:
                    // CREAR
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
     * Gestio usuaris ✅
     * @throws Exception
     *
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
                    // ALTA
                    Persona uAlta = DadesUser.formAltaUser();
                    daoU.altaUser(uAlta);
                    break;
                case 2:
                    //BAIXA
                    String dniUser = DadesUser.formBaixaUser();
                    daoU.baixaUser(dniUser);
                    break;
                case 3:
                    //MOD
                    String dades = DadesUser.formUpdateUser();
                    daoU.modificacioUser(dades);
                    break;
                case 4:
                    //LISTAR
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
     * Gestio viatges ✅
     * @throws Exception
     *
     */
    private static void gestioViatges() throws Exception
    {
        InterfaceViatjes daoV = new ImplementsViatjes();
        boolean menu = false;
        do
        {
            System.out.println("Entra una opcio: ");
            System.out.println("1 - Llistar Viatjes");
            System.out.println("2 - Nou Viatje");
            System.out.println("3 - Eliminar Viatje");
            System.out.println("4 - Modificar Viatje");
            System.out.println("0 - Sortir");

            int opcio = lector.nextInt();
            lector.nextLine();

            switch (opcio)
            {
                case 1:
                    //LLISTAR
                    daoV.llistarViatje();
                    break;
                case 2:
                    //  ADD
                    Viatje vNou = DadesViatge.formNouViatge();
                    daoV.nouViatje(vNou);
                    break;
                case 3:
                    //DELETE
                    int IdViatge = DadesViatge.formEliminarViatge();
                    daoV.eliminarViatje(IdViatge);
                    break;
                case 4:
                    //UPDATE
                    String dades = DadesViatge.formUpdateViatge();
                    daoV.modificarViatje(dades);
                    break;
                case 0:
                    System.out.println("Toranras al menu Admin\n");
                    menu = true;
                    break;
                default:
                    System.out.println("Opcio incorrecta, Torna a intentar.");
                    break;
            }
        }while(!menu);
    } //✅


}
