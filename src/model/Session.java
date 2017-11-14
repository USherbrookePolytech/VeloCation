package model;

import java.util.ArrayList;

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

    public void connexion(int id)
    {

    }

    public void deconnection()
    {

    }

    public void nouveauAbo(String nom, String prenom, String adresse, Abonnement abonnement)
    {

    }

    public void supprimer(int id)
    {

    }

    public void connexionTemp(String numTel)
    {
        listMembre.add(new MembreTemp(numTel));
    }

    public void louer(Membre membre)
    {

    }
}