package Interfaces;

import objectes.Billet;

public interface InterfaceBitllets {
    public void llistarBitllets() throws Exception;
    public void compraBitllets(String bCompra) throws Exception;
    public void eliminarBitllets(String bElimina) throws Exception;
    public void creaBitllets(Billet bCrea) throws Exception;
}
