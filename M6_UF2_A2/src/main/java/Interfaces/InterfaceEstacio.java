package Interfaces;

import objectes.Estacio;

public interface InterfaceEstacio
{
    public void novaEstacio(Estacio eNou) throws Exception;
    public void deleteEstacio(int idEstacio) throws Exception;
    public void modificarEstacio(String eUpdate) throws Exception;
    public void llistarEstacio() throws Exception;
}
