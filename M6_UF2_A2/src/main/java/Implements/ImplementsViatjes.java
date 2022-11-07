package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceViatjes;
import objectes.Viatje;

public class ImplementsViatjes implements InterfaceViatjes
{
    public void nouViatje(Viatje vNou) throws Exception {
        ConnexioBDD.conexioDB();
    }
    public void eliminarViatje(Viatje vEliminar) throws Exception {
        ConnexioBDD.conexioDB();
    }
    public void modificarViatje(Viatje vUpdate) throws Exception {
        ConnexioBDD.conexioDB();
    }
    public void llistarViatje() throws Exception {
        ConnexioBDD.conexioDB();
    }
}
