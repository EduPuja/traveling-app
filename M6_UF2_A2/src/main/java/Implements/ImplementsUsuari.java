package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceUsuari;
import com.sun.tools.javac.Main;
import objectes.Persona;

import static com.sun.tools.javac.Main.*;

public class ImplementsUsuari implements InterfaceUsuari
{
    public void altaUser(Persona u) throws Exception {
        ConnexioBDD.conexioDB();

    }
    public void baixaUser(Persona u) throws Exception {
        ConnexioBDD.conexioDB();
    }
    public void modificacioUser(Persona u) throws Exception {
        ConnexioBDD.conexioDB();
    }
    public void llistarUser() throws Exception {
        ConnexioBDD.conexioDB();
    }
    public static Boolean comprovarUser(String nom, String password, boolean admin)
    {
        //comprovarUser en la bdd.
        return true;
    }
}
