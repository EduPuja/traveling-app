package Interfaces;

import Objectes.Viatje;

public interface InterfaceViatjes
{
    public void nouViatje(Viatje vNou) throws Exception;
    public void eliminarViatje(int idViatge) throws Exception;
    public void modificarViatje(Viatje vUpdate) throws Exception;
    public void llistarViatje() throws Exception;
}
