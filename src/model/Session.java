package model;

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

    public boolean connexion(int id) throws Exception
    {
        for (int boucle = 0; boucle < listMembre.size(); boucle++)
        {
            if (id == listMembre.get(boucle).getId())
            {
                membre = listMembre.get(boucle);
                return true;
            }
        }

        if (membre == null)
            try
            {
                throw new Exception("Utilisateur non trouvé");
            }
            catch (Exception e)
            {
                throw e;
            }

        return false;
    }

    public void deconnection()
    {
    	membre = null;
        AbstractView.initView();
        AbstractController.init();
    }

    public MembreAbonne nouveauAbo(String nom, String prenom, String numTel, String courriel, String adresse,
            Abonnement abonnement)
    {
        MembreAbonne membre = new MembreAbonne(listMembre.size(), nom, prenom, numTel, courriel, adresse, abonnement,
                null);
        listMembre.add(membre);
        return membre;
    }

    public void supprimerMembre(Membre membre)
    {
    	listMembre.remove(membre);
        AbstractView.initView();
        AbstractController.init();
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