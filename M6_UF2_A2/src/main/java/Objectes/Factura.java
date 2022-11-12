package Objectes;

import java.util.Date;

public class Factura
{
    private int numFactura;
    private int idPersona;
    private int preuTotal;
    private Date data;

    /**
     * Builder empty
     */
    public Factura()
    {

    }

    /**
     * Builder with params
     * @param numFactura
     * @param idPersona
     * @param preuTotal
     * @param data
     */
    public Factura(int numFactura, int idPersona, int preuTotal, Date data)
    {
        this.numFactura = numFactura;
        this.idPersona = idPersona;
        this.preuTotal = preuTotal;
        this.data = data;
    }

    /**
     * Metode general per entrar totes les dades de una factura
     * @param numFactura
     * @param idPersona
     * @param preuTotal
     * @param data
     */
    public void setAllFactura(int numFactura, int idPersona, int preuTotal, Date data)
    {
        this.numFactura = numFactura;
        this.idPersona = idPersona;
        this.preuTotal = preuTotal;
        this.data = data;

    }

    /**
     * metode que et retorna tota la info de un objecte
     * @return
     */
    public String getInfoFactura()
    {
        return "NUMERO FACTURA: "+this.numFactura +" \nID PERSONA: "+this.idPersona+"\nPREU TOTAL: "+this.preuTotal+"\nDATA: "+this.data;
    }


    //** GETS **//
    public int getNumFactura()
    {
        return numFactura;
    }
    public int getIdPersona()
    {
        return idPersona;
    }
    public int getPreuTotal()
    {
        return preuTotal;
    }
    public Date getData()
    {
        return data;
    }
    // ** SETS **//
    public void setNumFactura(int numFactura)
    {
        this.numFactura = numFactura;
    }
    public void setIdPersona(int idPersona)
    {
        this.idPersona = idPersona;
    }
    public void setPreuTotal(int preuTotal)
    {
        this.preuTotal = preuTotal;
    }
    public void setData(Date data)
    {
        this.data = data;
    }
}
