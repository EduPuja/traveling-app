package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceViatjes;
import objectes.Viatje;

import java.sql.Statement;

public class ImplementsViatjes implements InterfaceViatjes
{
    public void nouViatje(Viatje vNou) throws Exception
    {
       Statement con =ConnexioBDD.conexioDB();


    }
    public void eliminarViatje(Viatje vEliminar) throws Exception
    {
       Statement statement=  ConnexioBDD.conexioDB();
    }
    public void modificarViatje(Viatje vUpdate) throws Exception
    {
        Statement stat= ConnexioBDD.conexioDB();
    }
    public void llistarViatje() throws Exception
    {
        Statement statement =ConnexioBDD.conexioDB();
    }
}
