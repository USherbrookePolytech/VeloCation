package model;

import java.util.ArrayList;

/**
 * Classe qui représente une borne
 */
public class Borne
{
    private int id;
    private int nombreVelosMax;
    private int nombreVelosDispo;
    private ArrayList<Socle> listSocle;

    /**
     * Instance d'une nouvelle borne
     * 
     * @param id
     * @param nombreVelosMax
     * @param nombreVelosDispo
     * @param listSocle
     */
    public Borne(int id, int nombreVelosMax, int nombreVelosDispo, ArrayList<Socle> listSocle)
    {
        this.id = id;
        this.nombreVelosMax = nombreVelosMax;
        this.nombreVelosDispo = nombreVelosDispo;
        this.listSocle = listSocle;
    }

    public Velo verifierVelo()
    {
        return 0;
    }
}
