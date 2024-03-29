package Interfaces;

import Objectes.Factura;
import Objectes.Linia_Factura;

public interface InterfaceFactura
{

    public void llistarFactura() throws Exception;
    public void crearFactura(Factura creaF,int idB) throws Exception;
    public void crearFacturaAdmin(Factura creaF) throws Exception;
    public void eliminarFactura(int idFactura) throws Exception;
    public void modificarFactura(String dades) throws Exception;
}
