package Interfaces;

import objectes.Viatje;

public interface InterfaceViatjes
{
    public void nouViatje(Viatje vNou) throws Exception;
    public void eliminarViatje(Viatje vEliminar) throws Exception;
    public void modificarViatje(Viatje vUpdate) throws Exception;
    public void llistarViatje() throws Exception;
}
