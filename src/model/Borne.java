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
        this.id = 72;
        this.nombreVelosMax = 5;
        this.nombreVelosDispo = 5;
        this.listSocle = new ArrayList<Socle>();

        // Initialisation de 5 socles contenant un vélo chacun
        listSocle.add(0, new Socle(1, true, true, new Velo(1, true, true)));
        listSocle.add(1, new Socle(2, true, true, new Velo(2, true, true)));
        listSocle.add(2, new Socle(3, true, true, new Velo(3, true, true)));
        listSocle.add(3, new Socle(4, true, true, new Velo(4, true, true)));
        listSocle.add(4, new Socle(5, true, true, new Velo(5, true, true)));
    }

    /**
     * Vérifie si un vélo est disponible
     * 
     * @return
     */
    public Velo verifierVelo()
    {
        // RETURN A SUPPRIMER
        return new Velo(0, true, true);
    }
}