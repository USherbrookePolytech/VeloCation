package model;

/**
 * Classe qui représente un socle
 */
public class Socle
{
    private int id;
    private boolean dispo;
    private boolean utilisable;
    private Velo velo;

    /**
     * Instance d'un nouveau socle
     * 
     * @param id
     * @param utiliser
     * @param utilisable
     * @param velo
     */
    public Socle(int id, boolean dispo, boolean utilisable, Velo velo)
    {
        this.id = id;
        this.dispo = dispo;
        this.utilisable = utilisable;
        this.velo = velo;
    }

    public Velo verifierV()
    {
        return velo;
    }
}
