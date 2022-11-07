package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceBitllets;
import objectes.Billet;

public class ImplementsBitllets implements InterfaceBitllets
{
    public void llistarBitllets() throws Exception {
        ConnexioBDD.conexioDB();
    }
    public void compraBitllets(Billet bCompra) throws Exception {
        ConnexioBDD.conexioDB();
    }
    public void eliminarBitllets(Billet bElimina) throws Exception {
        ConnexioBDD.conexioDB();
    }
}
