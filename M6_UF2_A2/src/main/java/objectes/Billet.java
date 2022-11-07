package objectes;

import Interfaces.InterfaceBitllets;

public class Billet
{
    int idBillet;

    TipusBillet tipusBillet;
    double preuBillet;
    int maxPersones;


    /**
     * Construcotr buit
     */
    public Billet()
    {

    }

    /**
     * Metode que el que crea es un billet de forma general
     * @param idBillet
     * @param typeBillet
     * @param preuBillet
     * @param numPersones
     */
    public void setAllBillet(int idBillet,TipusBillet typeBillet,double preuBillet,int numPersones)
    {
        this.idBillet=idBillet;
        this.tipusBillet =typeBillet;
        this.preuBillet=preuBillet;
        this.maxPersones=numPersones;
    }

    public String getInfoBillet()
    {
        return "ID_Billet: "+idBillet+" TIPUS_BILLET: "+tipusBillet.toString()+" PREU_BILLET: "+preuBillet+" NUM_PERSONES: "+this.maxPersones;
    }

    public int getIdBillet()
    {
        return idBillet;
    }

    public void setIdBillet(int idBillet)
    {
        this.idBillet = idBillet;
    }

    public TipusBillet getTipusBillet()
    {
        return tipusBillet;
    }

    public void setTipusBillet(TipusBillet tipusBillet)
    {
        this.tipusBillet = tipusBillet;
    }

    public double getPreuBillet()
    {
        return preuBillet;
    }

    public void setPreuBillet(double preuBillet)
    {
        this.preuBillet = preuBillet;
    }

    public int getMaxPersones()
    {
        return maxPersones;
    }

    public void setMaxPersones(int maxPersones)
    {
        this.maxPersones = maxPersones;
    }
}
