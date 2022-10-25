package objectes;

import java.util.Date;

public class Factura
{
    int numFactura;
    int idPersona;
    double preuTotal;
    Date data;

    public Factura(int numFactura, int idPersona, double preuTotal, Date data)
    {
        this.numFactura = numFactura;
        this.idPersona = idPersona;
        this.preuTotal = preuTotal;
        this.data = data;
    }

    public int getNumFactura()
    {
        return numFactura;
    }

    public void setNumFactura(int numFactura)
    {
        this.numFactura = numFactura;
    }

    public int getIdPersona()
    {
        return idPersona;
    }

    public void setIdPersona(int idPersona)
    {
        this.idPersona = idPersona;
    }

    public double getPreuTotal()
    {
        return preuTotal;
    }

    public void setPreuTotal(double preuTotal)
    {
        this.preuTotal = preuTotal;
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date data)
    {
        this.data = data;
    }
}
