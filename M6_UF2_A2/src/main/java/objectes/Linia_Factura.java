package objectes;

public class Linia_Factura
{
    int numLinia;
    int idPersona;
    double preu;

    public Linia_Factura(int numLinia, int idPersona, double preu)
    {
        this.numLinia = numLinia;
        this.idPersona = idPersona;
        this.preu = preu;
    }

    public int getNumLinia()
    {
        return numLinia;
    }

    public void setNumLinia(int numLinia)
    {
        this.numLinia = numLinia;
    }

    public int getIdPersona()
    {
        return idPersona;
    }

    public void setIdPersona(int idPersona)
    {
        this.idPersona = idPersona;
    }

    public double getPreu()
    {
        return preu;
    }

    public void setPreu(double preu)
    {
        this.preu = preu;
    }
}
