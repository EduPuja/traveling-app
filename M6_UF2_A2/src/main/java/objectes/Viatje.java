package objectes;

import Interfaces.InterfaceViatjes;

public class Viatje
{
    private int idViatge;
    private int idOrigen;
    private int idDesti;
    private String pais;


    /**
     * Construcotr sin parametros
     */
    public Viatje()
    {

    }

    /**
     * Construcotr con parametros
     * @param idViatge
     * @param idOrigen
     * @param idDesti
     * @param pais
     */
    public Viatje(int idViatge, int idOrigen, int idDesti, String pais)
    {
        this.idViatge = idViatge;
        this.idOrigen = idOrigen;
        this.idDesti = idDesti;
        this.pais = pais;
    }

    /**
     * Metodo general para poder crear un viage
     * @param idViatge
     * @param idOrigen
     * @param idDesti
     * @param pais
     */
    public void setAllViajte(int idViatge, int idOrigen, int idDesti, String pais)
    {
        this.idViatge = idViatge;
        this.idOrigen = idOrigen;
        this.idDesti = idDesti;
        this.pais = pais;
    }

    /**
     * Metode que te retorna tota la informacio 
     * @return
     */
    public String getInfoViatge()
    {
        return this.idViatge+" "+this.idOrigen +" "+this.idOrigen+" "+this.pais;
    }


    // **  metodes gets ** //
    public int getIdViatge()
    {
        return idViatge;
    }
    public int getIdOrigen()
    {
        return idOrigen;
    }
    public int getIdDesti()
    {
        return idDesti;
    }
    public String getPais()
    {
        return pais;
    }

    //  **  metodes sets ** //
    public void setIdViatge(int idViatge)
    {
        this.idViatge = idViatge;
    }
    public void setIdOrigen(int idOrigen)
    {
        this.idOrigen = idOrigen;
    }
    public void setIdDesti(int idDesti)
    {
        this.idDesti = idDesti;
    }
    public void setPais(String pais)
    {
        this.pais = pais;
    }
}
