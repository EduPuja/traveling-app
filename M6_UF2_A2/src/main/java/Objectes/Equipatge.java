package Objectes;

public class Equipatge
{
    private int idEquipatge;
    private int numFactura;
    private int liniaFactura;
    private double pesKg;
    private int numMaletes;

    /**
     * Construcotr buit
     */
    public Equipatge()
    {
    }

    /**
     * Constructor amb parametres
     * @param idEquipatge
     * @param numFactura
     * @param liniaFactura
     * @param pesKg
     * @param numMaletes
     */
    public Equipatge(int idEquipatge, int numFactura, int liniaFactura, double pesKg, int numMaletes)
    {
        this.idEquipatge = idEquipatge;
        this.numFactura = numFactura;
        this.liniaFactura = liniaFactura;
        this.pesKg = pesKg;
        this.numMaletes = numMaletes;
    }


    /**
     * Set general paara crear un solo equipage
     * @param idEquipatge
     * @param numFactura
     * @param liniaFactura
     * @param pesKg
     * @param numMaletes
     */
    public void setAllEquipatge(int idEquipatge, int numFactura, int liniaFactura, double pesKg, int numMaletes)
    {
        this.idEquipatge = idEquipatge;
        this.numFactura = numFactura;
        this.liniaFactura = liniaFactura;
        this.pesKg = pesKg;
        this.numMaletes = numMaletes;
    }

    /**
     * Metode que te devuelve toda la inforamcio de un equipaje
     * @return
     */
    public String getInfoEquipatge()
    {
        return "ID_EQUIPATGE: "+this.idEquipatge+"\nNUMERO FACTURA:"+this.numFactura+"\nLINIA FACTURA: "+this.liniaFactura+"\nPES_KG: "+this.pesKg+"\nNUM MALETES: "+this.numMaletes;
    }

    // ** GETS ** //
    public int getIdEquipatge()
    {
        return idEquipatge;
    }
    public int getNumFactura()
    {
        return numFactura;
    }
    public int getLiniaFactura()
    {
        return liniaFactura;
    }
    public double getPesKg()
    {
        return pesKg;
    }
    public int getNumMaletes()
    {
        return numMaletes;
    }

    //** SETS **//

    public void setIdEquipatge(int idEquipatge)
    {
        this.idEquipatge = idEquipatge;
    }
    public void setNumFactura(int numFactura)
    {
        this.numFactura = numFactura;
    }
    public void setLiniaFactura(int liniaFactura)
    {
        this.liniaFactura = liniaFactura;
    }
    public void setPesKg(double pesKg)
    {
        this.pesKg = pesKg;
    }
    public void setNumMaletes(int numMaletes)
    {
        this.numMaletes = numMaletes;
    }
}
