package Interfaces;

import objectes.Billet;

public interface InterfaceBitllets {
    public void llistarBitllets() throws Exception;
    public void compraBitllets(Billet bCompra) throws Exception;
    public void eliminarBitllets(Billet bElimina) throws Exception;
    public void creaBitllets(Billet bCrea) throws Exception;
}
