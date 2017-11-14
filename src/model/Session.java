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

    public boolean connexion(int id) throws Exception
    {
        for(int boucle = 0; boucle < listMembre.size(); boucle++) {
            if(id == listMembre.get(boucle).getId()) {
                membre = listMembre.get(boucle);
                return true;
            }
        }
        
        if(membre == null)
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

    }

    public void nouveauAbo(String nom, String prenom, String numTel, String adresse, Abonnement abonnement)
    {
        listMembre.add(new MembreAbonne(listMembre.size(), nom, prenom, numTel, adresse, abonnement, null));
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