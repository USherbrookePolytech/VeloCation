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
}