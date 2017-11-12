package model;

/**
 * Représente un vélo qui peut être loué par un membre
 */
public class Velo
{
    private int id;
    private boolean dispo;
    private boolean utilisable;

    /**
     * Initialisation d'un nouveau vélo
     * 
     * @param id
     * @param dispo
     * @param utilisable
     */
    public Velo(int id, boolean dispo, boolean utilisable)
    {
        this.id = id;
        this.dispo = dispo;
        this.utilisable = utilisable;
    }
}