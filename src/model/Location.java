package model;

import java.util.ArrayList;

/**
 * Représente une location effectuée par un membre
 */
public class Location
{
    private int nombreVelo;
    private int dureeMax;
    private ArrayList<Velo> listVelo;
    private int numCarte;
    private double caution;

    /**
     * Initialisation d'une nouvelle location
     * 
     * @param nombreVelo
     * @param dureeMax
     * @param listVelo
     * @param numCarte
     * @param caution
     */
    public Location(int nombreVelo, int dureeMax, ArrayList<Velo> listVelo, int numCarte, double caution)
    {
        this.nombreVelo = nombreVelo;
        this.dureeMax = dureeMax;
        this.listVelo = listVelo;
        this.numCarte = numCarte;
        this.caution = caution;
    }

    public void ajouterVelo()
    {

    }

    public void enleverVelo(int id)
    {

    }
}