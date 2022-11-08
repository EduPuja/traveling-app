package objectes;

import Interfaces.InterfaceBitllets;

public class Billet
{
    private int idBillet;
    private  int idViatge;
    private TipusBillet tipusBillet;
    private int preuBillet;
    private int maxPersones;

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
    public void setAllBillet(int idBillet,int idViatge,TipusBillet typeBillet,int preuBillet,int numPersones)
    {
        this.idBillet=idBillet;
        this.idViatge = idViatge;
        this.tipusBillet =typeBillet;
        this.preuBillet=preuBillet;
        this.maxPersones=numPersones;
    }

    public String getInfoBillet()
    {
        return "ID BILLET: "+idBillet+"\nTIPUS_BILLET: "+tipusBillet.toString()+"\nPREU_BILLET: "+preuBillet+"\nNUM_PERSONES: "+this.maxPersones;
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
    public int getPreuBillet()
    {
        return preuBillet;
    }
    public int getMaxPersones()
    {
        return maxPersones;
    }
    public int getIdViatge()
    {
        return this.idViatge;
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
    public void setPreuBillet(int preuBillet)
    {
        this.preuBillet = preuBillet;
    }
    public void setMaxPersones(int maxPersones)
    {
        this.maxPersones = maxPersones;
    }
    public void setIdViatge(int idViatge){this.idViatge = idViatge;}
}
