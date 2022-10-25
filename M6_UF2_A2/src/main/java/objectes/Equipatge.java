package objectes;

public class Equipatge
{
    int idEquipatge;
    int numFactura;
    int liniaFactura;
    double pesKg;
    int numMaletes;

    public Equipatge()
    {
    }

    public Equipatge(int idEquipatge, int numFactura, int liniaFactura, double pesKg, int numMaletes)
    {
        this.idEquipatge = idEquipatge;
        this.numFactura = numFactura;
        this.liniaFactura = liniaFactura;
        this.pesKg = pesKg;
        this.numMaletes = numMaletes;
    }

    public int getIdEquipatge()
    {
        return idEquipatge;
    }

    public void setIdEquipatge(int idEquipatge)
    {
        this.idEquipatge = idEquipatge;
    }

    public int getNumFactura()
    {
        return numFactura;
    }

    public void setNumFactura(int numFactura)
    {
        this.numFactura = numFactura;
    }

    public int getLiniaFactura()
    {
        return liniaFactura;
    }

    public void setLiniaFactura(int liniaFactura)
    {
        this.liniaFactura = liniaFactura;
    }

    public double getPesKg()
    {
        return pesKg;
    }

    public void setPesKg(double pesKg)
    {
        this.pesKg = pesKg;
    }

    public int getNumMaletes()
    {
        return numMaletes;
    }

    public void setNumMaletes(int numMaletes)
    {
        this.numMaletes = numMaletes;
    }
}
