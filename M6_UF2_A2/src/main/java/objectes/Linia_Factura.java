package objectes;

public class Linia_Factura
{
    private int numLinia;
    private int idPersona;
    private double preu;

    /**
     * Construcor buit
     */
    public Linia_Factura()
    {

    }

    /**
     * Construcotr with params
     * @param numLinia
     * @param idPersona
     * @param preu
     */
    public Linia_Factura(int numLinia, int idPersona, double preu)
    {
        this.numLinia = numLinia;
        this.idPersona = idPersona;
        this.preu = preu;
    }

    /**
     * Metode general per afegir objecte liniaFactura
     * @param numLinia
     * @param idPersona
     * @param preu
     */
    public void setAllLiniaFact(int numLinia, int idPersona, double preu)
    {
        this.numLinia = numLinia;
        this.idPersona = idPersona;
        this.preu = preu;
    }

    /**
     * Metode per retornar tota la info de una linaFactura
     * @return
     */
    public String getInfoLinaFact()
    {
        return "NUM_LINIA:"+this.numLinia+"\nID_PERSONA: "+this.idPersona+"\nPREU: "+this.preu;
    }

    //** GETS **//

    public int getNumLinia()
    {
        return numLinia;
    }
    public int getIdPersona()
    {
        return idPersona;
    }
    public double getPreu()
    {
        return preu;
    }


    // ** SETS **//
    public void setNumLinia(int numLinia)
    {
        this.numLinia = numLinia;
    }
    public void setIdPersona(int idPersona)
    {
        this.idPersona = idPersona;
    }
    public void setPreu(double preu)
    {
        this.preu = preu;
    }
}
