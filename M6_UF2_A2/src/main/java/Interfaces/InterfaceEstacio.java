package Interfaces;

import objectes.Estacio;
import objectes.Viatje;

public interface InterfaceEstacio
{
    public void novaEstacio(Estacio eNou) throws Exception;
    public void deleteEstacio(int idEstacio) throws Exception;
    public void modificarEstacio(Estacio eUpdate) throws Exception;
    public void llistarEstacio() throws Exception;
}
