package controller;

import java.awt.Color;

import javax.swing.border.LineBorder;

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

    public void verifierInscription()
    {
        boolean estValide = true;

        if (inscriptionView.getTxtNom().getText().equals(""))
        {
            inscriptionView.getLabelRequis5().setText("Ce champ est requis");
            inscriptionView.getTxtNom().setBorder(new LineBorder(Color.RED, 2));
            estValide = false;
        }
        if (inscriptionView.getTxtPrenom().getText().equals(""))
        {
            inscriptionView.getLabelRequis6().setText("Ce champ est requis");
            inscriptionView.getTxtPrenom().setBorder(new LineBorder(Color.RED, 2));
            estValide = false;
        }
        if (inscriptionView.getTxtTelephone().getText().equals(""))
        {
            inscriptionView.getLabelRequis7().setText("Ce champ est requis");
            inscriptionView.getTxtTelephone().setBorder(new LineBorder(Color.RED, 2));
            estValide = false;
        }
        /*
         * if (inscriptionView.getDateChooser().getDate().get) {
         * inscriptionView.getLabelRequis8().setText("Ce champ est requis"); //
         * REVOIR ICI //inscriptionView.getTxtTelephone().setBorder(new
         * LineBorder(Color.RED, 2)); estValide = false; }
         */
        if (inscriptionView.getTxtCourriel().getText().equals(""))
        {
            inscriptionView.getLabelRequis9().setText("Ce champ est requis");
            inscriptionView.getTxtCourriel().setBorder(new LineBorder(Color.RED, 2));
            estValide = false;
        }
        if (inscriptionView.getTxtNumero().getText().equals(""))
        {
            inscriptionView.getLabelRequis1().setText("Ce champ est requis");
            inscriptionView.getTxtNumero().setBorder(new LineBorder(Color.RED, 2));
            estValide = false;
        }
        if (inscriptionView.getTxtCodepostal().getText().equals(""))
        {
            inscriptionView.getLabelRequis2().setText("Ce champ est requis");
            inscriptionView.getTxtCodepostal().setBorder(new LineBorder(Color.RED, 2));
            estValide = false;
        }
        if (inscriptionView.getTxtVille().getText().equals(""))
        {
            inscriptionView.getLabelRequis3().setText("Ce champ est requis");
            inscriptionView.getTxtVille().setBorder(new LineBorder(Color.RED, 2));
            estValide = false;
        }
        /*if (inscriptionView.getTxtPays().getText().equals(""))
        {
            inscriptionView.getLabelRequis4().setText("Ce champ est requis");
            inscriptionView.getTxtPays().setBorder(new LineBorder(Color.RED, 2));
            estValide = false;
        }*/
    }
}