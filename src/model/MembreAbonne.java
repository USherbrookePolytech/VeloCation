package model;

import java.util.ArrayList;

/** 
 * Classe qui représente un membre ayant déjà un compte
 */
public class MembreAbonne extends Membre
{
    private String nom;
    private String prenom;
    private String adresse;
    private Abonnement abonnement;
    
    /**
     * Constructeur de confort
     * 
     * @param id
     * @param nom
     * @param prenom
     * @param numTel
     * @param adresse
     * @param abonnement
     * @param listeLocation
     */
    public MembreAbonne(int id, String nom, String prenom, String numTel, String adresse, Abonnement abonnement, ArrayList<Location> listeLocation)
    {
        super(id, numTel, listeLocation);
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.abonnement = abonnement;
    }
    
    public void renouvelerAbo()
    {
        
    }
    
    public void supprimerAbo()
    {
        
    }
}