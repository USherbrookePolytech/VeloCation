package model;

/**
 * Classe qui représente un membre temporaire
 */
public class MembreTemp extends Membre
{
    private String codeTel;

    /**
     * Initialise un nouveau membre temporaire
     * 
     * @param codeTel
     */
    public MembreTemp(String codeTel)
    {
        this.codeTel = codeTel;
    }
}