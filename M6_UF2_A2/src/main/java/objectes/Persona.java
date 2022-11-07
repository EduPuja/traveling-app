package objectes;

import Interfaces.InterfaceUsuari;

import java.util.Date;

public class Persona
{
    int idPersona;
    String dni;
    String nom;
    Date data_naix;

    public Persona(){

    }
    public Persona(int idPersona, String dni, String nom, Date data_naix)
    {
        this.idPersona = idPersona;
        this.dni = dni;
        this.nom = nom;
        this.data_naix = data_naix;
    }
    public int getIdPersona()
    {
        return idPersona;
    }

    public void setIdPersona(int idPersona)
    {
        this.idPersona = idPersona;
    }

    public String getDni()
    {
        return dni;
    }

    public void setDni(String dni)
    {
        this.dni = dni;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public Date getData_naix()
    {
        return data_naix;
    }

    public void setData_naix(Date data_naix)
    {
        this.data_naix = data_naix;
    }
}
