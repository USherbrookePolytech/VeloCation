package controller;

import view.ProfilView;

/**
 * Controleur de la vue Profil
 */
public class ProfilController extends AbstractController
{
    private ProfilView profilView;

    public ProfilController(ProfilView profilViewArg)
    {
        this.profilView = profilViewArg;
    }

    public void afficherProfil()
    {
        profilView.getFrmMonProfil().setVisible(true);
    }

    public void afficherAbo()
    {

    }

    public void louer()
    {

    }

    public void renouvelerAbo()
    {

    }

    public void supprimerAbo()
    {

    }

    public void modifierAbo()
    {

    }

    public void modifierCompte()
    {

    }

    public void supprimerCompte()
    {

    }

    public void scannerCarte()
    {
        profilView.getFrmScannerVotreCarte().setVisible(true);
    }

    public boolean connexion(int id) throws Exception
    {
        try
        {
            if (session.connexion(id))
            {
                profilView.getFrmMonProfil().setVisible(true);
                return true;
            }
        }
        catch (Exception e)
        {
            throw e;
        }

        return false;
    }
}