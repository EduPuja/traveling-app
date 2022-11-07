package Interfaces;

import objectes.Persona;

public interface InterfaceUsuari
{
    public void altaUser(Persona u) throws Exception;
    public void baixaUser(String dniUser) throws Exception;
    public void modificacioUser(Persona u) throws Exception;
    public void llistarUser() throws Exception;
}
