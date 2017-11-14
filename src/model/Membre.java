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
    private ArrayList<Location> listLocation;
    
    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }
}