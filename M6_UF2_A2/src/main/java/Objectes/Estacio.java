package Objectes;

public class Estacio
{
    private int idEstacio;
    private String descripcio;

    /**
     * Contructor buit
     */
    public Estacio()
    {

    }

    /**
     * Construcotr
     * @param idEstacio
     * @param descripcio
     */
    public Estacio(int idEstacio, String descripcio)
    {
        this.idEstacio = idEstacio;
        this.descripcio = descripcio;
    }

    /**
     * set general per estacio
     * @param idEstacio
     * @param descripcio
     */
    public void setAllEstacio(int idEstacio, String descripcio)
    {
        this.idEstacio = idEstacio;
        this.descripcio = descripcio;
    }

    public String getInfoEstacio()
    {
        return "ID_ESTACIO: "+this.idEstacio+"\nDESCRIPCIO: "+this.descripcio;
    }


    //** getts **//

    public int getIdEstacio()
    {
        return idEstacio;
    }

    public String getDescripco()
    {
        return descripcio;
    }

    // ** sets  **//
    public void setIdEstacio(int idEstacio)
    {
        this.idEstacio = idEstacio;
    }

    public void setDescripco(String descripcio)
    {
        this.descripcio = descripcio;
    }
}
