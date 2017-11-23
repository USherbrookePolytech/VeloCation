package model;

import java.util.ArrayList;

/**
 * Classe qui représente un membre lambda. Les deux types de membres vont
 * hériter de cette classe.
 */
public abstract class Membre
{
    private int id;
    private String numTel;
    private ArrayList<Location> listLocation = new ArrayList<Location>();
           
    public Membre()
    {        
    }
    
    /**
     * Constructeur de confort
     * 
     * @param id
     * @param numTel
     * @param listLocation
     */
    public Membre(int id, String numTel, ArrayList<Location> listLocation)
    {
        super();
        this.id = id;
        this.numTel = numTel;
        this.listLocation = listLocation;
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }
}