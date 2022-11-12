package Interfaces;

import Objectes.Linia_Factura;

public interface InterfaceLiniaFactura
{
    public void llistarLiniaFactura() throws Exception;
    public void crearLiniaFactura(Linia_Factura creaLF) throws Exception;
    public void eliminarLiniaFactura(int idLinaFactura) throws Exception;
    public void modificarLiniaFactura(String dades) throws Exception;
}
