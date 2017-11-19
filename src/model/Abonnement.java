package model;

import java.time.LocalDate;
import java.util.Date;

/**
 * Represente l'abonnement d'un membre
 */
public class Abonnement
{

    private String type;
    private double prix;
    private int duree;
    private LocalDate date;

    /**
     * Instance d'un nouvel abonnement
     * 
     * @param type
     * @param prix
     * @param duree
     * @param date
     */
    public Abonnement(String type, double prix, int duree, LocalDate date)
    {
        this.type = type;
        this.prix = prix;
        this.duree = duree;
        this.date = date;
    }
    
    public String getType()
    {
    	return type;
    }
    
    public Double getPrix()
    {
    	return prix;
    }
    
    public int getDuree()
    {
    	return duree;
    }
    
    public LocalDate getDate()
    {
    	return date;
    }
    
    public void setType(String type)
    {
    	this.type = type;
    }
    
    public void setPrix(double prix)
    {
    	this.prix = prix;
    }
    
    public void setDuree(int duree)
    {
    	this.duree = duree;
    }
    
    public void setDate(LocalDate date)
    {
    	this.date = date;
    }
}