import java.util.Scanner;

public class main
{
    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args)
    {
        conexioDB();
        boolean menu = false;
        do{
            System.out.println("Entra una opcio: ");
            System.out.println("1 - Gestio d'Usuaris");
            System.out.println("2 - Gestio de Viatges");
            System.out.println("3 - Compra Bitllets");
            System.out.println("0 - Sortir");
            
            int opcio = lector.nextInt();
            lector.nextLine();
            
            switch (opcio){
                case 1:
                        menuUsuaris();
                    break;
                case 2:
                        menuViatges();
                    break;
                case 3:
                        menuBitllets();
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
    private static void menuUsuaris()
    {
        boolean menu = false;
        do{
            System.out.println("Entra una opcio: ");
            System.out.println("1 - Alta Usuari");
            System.out.println("2 - Baixa Usuari");
            System.out.println("3 - Modificar Usuari");
            System.out.println("0 - Sortir");

            int opcio = lector.nextInt();
            lector.nextLine();

            switch (opcio){
                case 1:
                    altaUser();
                    break;
                case 2:
                    baixaUser();
                    break;
                case 3:
                    modificacioUser();
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

    private static void altaUser()
    {
    }

    private static void baixaUser()
    {
    }

    private static void modificacioUser()
    {
    }


    private static void menuViatges()
    {
        boolean menu = false;
        do{
            System.out.println("Entra una opcio: ");
            System.out.println("1 - Nou Viatje");
            System.out.println("2 - Eliminar Viatje");
            System.out.println("3 - Modificar Viatje");
            System.out.println("0 - Sortir");

            int opcio = lector.nextInt();
            lector.nextLine();

            switch (opcio){
                case 1:
                    nouViatje();
                    break;
                case 2:
                    eliminarViatje();
                    break;
                case 3:
                    modificarViatje();
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

    private static void nouViatje()
    {
    }

    private static void eliminarViatje()
    {
    }

    private static void modificarViatje()
    {
    }

    private static void menuBitllets()
    {
    }

    private static void conexioDB()
    {
    }
}
