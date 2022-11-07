package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceUsuari;
import objectes.Persona;

public class ImplementsUsuari implements InterfaceUsuari
{
    public void altaUser(Persona u) throws Exception {
        ConnexioBDD.conexioDB();
        //fer alta de l'usuari
    }
    public void baixaUser(String dniUser) throws Exception {
        ConnexioBDD.conexioDB();
        //fer la baixa de l'usuai
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
    public static Boolean comprovarUserBaixa_Update(String dni)
    {
        //comprovarUser en la bdd.
        return true;
    }
}
