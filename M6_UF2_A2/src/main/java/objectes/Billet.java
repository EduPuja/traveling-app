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

    // ** METODES GET  ** //

    public int getIdBillet()
    {
        return idBillet;
    }
    public TipusBillet getTipusBillet()
    {
        return tipusBillet;
    }
    public double getPreuBillet()
    {
        return preuBillet;
    }
    public int getMaxPersones()
    {
        return maxPersones;
    }


    // ** METODES SET ** //
    public void setIdBillet(int idBillet)
    {
        this.idBillet = idBillet;
    }
    public void setTipusBillet(TipusBillet tipusBillet)
    {
        this.tipusBillet = tipusBillet;
    }
    public void setPreuBillet(double preuBillet)
    {
        this.preuBillet = preuBillet;
    }
    public void setMaxPersones(int maxPersones)
    {
        this.maxPersones = maxPersones;
    }
}
