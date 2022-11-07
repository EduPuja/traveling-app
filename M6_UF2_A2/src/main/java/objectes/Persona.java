package objectes;

import Interfaces.InterfaceUsuari;

import java.util.Date;

public class Persona
{
  private int idPersona;
  private String dni;
  private String nom;
  private Date data_naix;

    /**
     * Construcor buit
     */
    public Persona()
    {

    }

    /**
     * Construcotr amb parametres
     * @param idPersona
     * @param dni
     * @param nom
     * @param data_naix
     */
    public Persona(int idPersona, String dni, String nom, Date data_naix)
    {
        this.idPersona = idPersona;
        this.dni = dni;
        this.nom = nom;
        this.data_naix = data_naix;
    }

    /**
     * Metode general per crear una persona
     * @param idPersona
     * @param dni
     * @param nom
     * @param data_naix
     */
    public void setAllPersona(int idPersona, String dni, String nom, Date data_naix)
    {
        this.idPersona = idPersona;
        this.dni = dni;
        this.nom = nom;
        this.data_naix = data_naix;
    }

    /**
     * Metode que et dona tota la info de una persona
     * @return
     */
    public String getInfoPersona()
    {
        return this.idPersona+" "+this.dni+" "+this.nom+" "+this.data_naix;
    }


    // ** METODES GETS ** //
    public int getIdPersona()
    {
        return idPersona;
    }
    public String getDni()
    {
        return dni;
    }
    public String getNom()
    {
        return nom;
    }
    public Date getData_naix()
    {
        return data_naix;
    }


    //** METODES SETS **//

    public void setIdPersona(int idPersona)
    {
        this.idPersona = idPersona;
    }
    public void setDni(String dni)
    {
        this.dni = dni;
    }
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    public void setData_naix(Date data_naix)
    {
        this.data_naix = data_naix;
    }
}
