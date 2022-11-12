package Interfaces;

import Objectes.Factura;
import Objectes.Linia_Factura;

public interface InterfaceFactura
{

    public void llistarFactura() throws Exception;
    public void crearFactura(Factura creaF) throws Exception;
    public void eliminarFactura(int idLinaFactura) throws Exception;
    public void modificarFactura(String dades) throws Exception;
}
