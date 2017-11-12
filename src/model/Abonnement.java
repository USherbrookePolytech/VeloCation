package model;

import java.util.Date;

/**
 * Represente l'abonnement d'un membre
 */
public class Abonnement
{

    private String type;
    private double prix;
    private int duree;
    private Date date;

    /**
     * Instance d'un nouvel abonnement
     * 
     * @param type
     * @param prix
     * @param duree
     * @param date
     */
    public Abonnement(String type, double prix, int duree, Date date)
    {
        this.type = type;
        this.prix = prix;
        this.duree = duree;
        this.date = date;
    }
}