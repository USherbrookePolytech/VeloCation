package controller;

import view.InscriptionView;

/**
 * Controler de la vue inscription
 */
public class InscriptionController extends AbstractController
{
    private InscriptionView inscriptionView;

    /**
     * @param inscriptionViewArg
     */
    public InscriptionController(InscriptionView inscriptionViewArg)
    {
        this.inscriptionView = inscriptionViewArg;
    }

    public void inscrireMembre()
    {
        inscriptionView.getFrmInscription().setVisible(true);
    }
}