package Interfaces;

import objectes.Persona;

public interface InterfaceUsuari
{
    public void altaUser(Persona u) throws Exception;
    public void baixaUser(String dniUser) throws Exception;
    public void modificacioUser(String dades) throws Exception;
    public void llistarUser() throws Exception;
}
