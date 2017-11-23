package controller;

import view.LouerView;

/**
 * Contrôleur de la vue Louer
 */
public class LouerController extends AbstractController
{
    private LouerView louerView;

    public LouerController(LouerView louerViewArg)
    {
        this.louerView = louerViewArg;
    }

    public void location()
    {
        // Si on se connecte temporairement alors le bouton retour profil n'est
        // pas visible sinon il le sera
        if (session.getMembre() == null)
            louerView.getLouerBtnAnnuler().setText("Annuler");
        else
            louerView.getLouerBtnAnnuler().setText("Retour profil");

        louerView.getFrmLouer().setVisible(true);
    }

    public void finirLocation()
    {

    }

    public void prendreCaution()
    {

    }

    public void rendreCaution()
    {

    }

    public void recupererVelo()
    {

    }

    /**
     * @return the louerView
     */
    public LouerView getLouerView()
    {
        return louerView;
    }

}