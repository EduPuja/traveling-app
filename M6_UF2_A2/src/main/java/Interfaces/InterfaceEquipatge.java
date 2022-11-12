package Interfaces;

import Objectes.Equipatge;

public interface InterfaceEquipatge
{
    public void afegirEquipatge(Equipatge equipatge) throws Exception;
    public void eliminarEquipatge(int idEquipatge) throws Exception;
    public void modificarEquipatge(String dades) throws  Exception;
    public void llistarEquipatge() throws Exception;
}
