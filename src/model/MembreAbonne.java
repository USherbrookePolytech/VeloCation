package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe qui représente un membre ayant déjà un compte
 */
public class MembreAbonne extends Membre
{
    private String nom;
    private String prenom;
    private String courriel;
    private String adresse;
    private LocalDate dateNaiss;
    private Abonnement abonnement;

    /**
     * Constructeur de confort
     * 
     * @param id
     * @param nom
     * @param prenom
     * @param numTel
     * @param adresse
     * @param adresse2
     * @param abonnement
     * @param listeLocation
     */
    public MembreAbonne(int id, String nom, String prenom, String numTel, String courriel, String adresse,
            LocalDate dateNaiss, Abonnement abonnement, ArrayList<Location> listeLocation)
    {
        super(id, numTel, listeLocation);
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
        this.adresse = adresse;
        this.dateNaiss = dateNaiss;
        this.abonnement = abonnement;
    }

    public void renouvelerAbo()
    {

    }

    public void supprimerAbo()
    {

    }

    public String getNom()
    {
        return nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public String getCourriel()
    {
        return courriel;
    }

    public String getAdresse()
    {
        return adresse;
    }

    public Abonnement getAbonnement()
    {
        return abonnement;
    }

    public void setAbonnement(String type, double prix, int duree, LocalDate date)
    {
        this.abonnement.setType(type);
        this.abonnement.setPrix(prix);
        this.abonnement.setDuree(duree);
        this.abonnement.setDate(date);
    }

    /**
     * @return the dateNaiss
     */
    public LocalDate getDateNaiss()
    {
        return dateNaiss;
    }

    /**
     * @param dateNaiss
     *            the dateNaiss to set
     */
    public void setDateNaiss(LocalDate dateNaiss)
    {
        this.dateNaiss = dateNaiss;
    }

}