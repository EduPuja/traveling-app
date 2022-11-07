import Funcions.FuncionsBitllets;
import Funcions.FuncionsUsuari;
import Funcions.FuncionsViatjes;
import Funcions.InterfaceBitllets;
import Funcions.InterfaceUsuari;
import Funcions.InterfaceViatjes;
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
            Persona p = new Persona();
            System.out.println("Entra una opcio: ");
            System.out.println("1 - Alta Usuari");
            System.out.println("2 - Baixa Usuari");
            System.out.println("3 - Modificar Usuari");
            System.out.println("0 - Sortir");

            int opcio = lector.nextInt();
            lector.nextLine();

            switch (opcio){
                case 1:
                    p.altaUser();
                    break;
                case 2:
                    p.baixaUser();
                    break;
                case 3:
                    p.modificacioUser();
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
    private static void menuViatges()
    {
        boolean menu = false;
        do{
            Viatje v = new Viatje();
            System.out.println("Entra una opcio: ");
            System.out.println("1 - Nou Viatje");
            System.out.println("2 - Eliminar Viatje");
            System.out.println("3 - Modificar Viatje");
            System.out.println("0 - Sortir");

            int opcio = lector.nextInt();
            lector.nextLine();

            switch (opcio){
                case 1:
                    v.nouViatje();
                    break;
                case 2:
                    v.eliminarViatje();
                    break;
                case 3:
                    v.modificarViatje();
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

    private static void menuBitllets()
    {
        boolean menu = false;
        do{
            Billet b = new Billet();
            System.out.println("Entra una opcio: ");
            System.out.println("1 - Llista Bitllets");
            System.out.println("2 - Compra Bitllets");
            System.out.println("0 - Sortir");

            int opcio = lector.nextInt();
            lector.nextLine();

            switch (opcio){
                case 1:
                    b.llistarBitllets();
                    break;
                case 2:
                    b.compraBitllets();
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

    private static void conexioDB() throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/m6_uf2_a1";         // url on esta la base de dades
        String user = "Daniel";                            // usuari base de dades
        String password = "1234";              // contrasenya base de dades
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("Select * from persones");

        while(rs.next()){

        }
    }
}
