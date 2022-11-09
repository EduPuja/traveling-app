package Interfaces;

import Objectes.Linia_Factura;

public interface InterfaceLiniaFactura
{
    public void llistarLiniaFactura() throws Exception;
    public void crearLiniaFactura(Linia_Factura creaLF) throws Exception;
    public void eliminarLiniaFactura(Linia_Factura deleteLF) throws Exception;
    public void modificarLiniaFactura(String dades) throws Exception;
}
