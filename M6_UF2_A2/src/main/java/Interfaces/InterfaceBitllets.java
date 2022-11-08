package Interfaces;

import objectes.Billet;

public interface InterfaceBitllets {
    public void llistarBitllets() throws Exception;
    public void compraBitllets(int bIdCompra, String dniClient) throws Exception;
    public void eliminarBitllets(int bElimina) throws Exception;
    public void creaBitllets(Billet bCrea) throws Exception;
}
