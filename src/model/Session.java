package model;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.AbstractController;
import view.AbstractView;

public class Session
{
    private ArrayList<Membre> listMembre;
    private Membre membre;
    private Borne borne;

    public Session()
    {
        this.listMembre = new ArrayList<Membre>();
        this.membre = null;
        this.borne = new Borne();
    }

    public boolean connexion(int id)
    {
        for (int boucle = 0; boucle < listMembre.size(); boucle++)
        {
            System.out.println("Une entrée");
            if (id == listMembre.get(boucle).getId())
            {
                membre = listMembre.get(boucle);
                return true;
            }
        }
        return false;
    }

    public void deconnection()
    {
        membre = null;
    }

    public MembreAbonne nouveauAbo(String nom, String prenom, String numTel, String courriel, String adresse,
            LocalDate dateNaiss, Abonnement abonnement)
    {
        MembreAbonne membre = new MembreAbonne(listMembre.size(), nom, prenom, numTel, courriel, adresse, dateNaiss,
                abonnement, null);
        listMembre.add(membre);
        return membre;
    }

    public void supprimerMembre(Membre membre)
    {
        listMembre.remove(membre);
    }

    public void connexionTemp(String numTel)
    {
        listMembre.add(new MembreTemp(numTel));
    }

    public void louer(Membre membre)
    {

    }

    /**
     * @return the membre
     */
    public Membre getMembre()
    {
        return membre;
    }

    /**
     * @param membre
     *            the membre to set
     */
    public void setMembre(Membre membre)
    {
        this.membre = membre;
    }
}