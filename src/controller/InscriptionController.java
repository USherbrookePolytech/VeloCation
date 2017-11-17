package controller;

import java.awt.Color;
import java.util.Locale;

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

    public boolean verifierInscription()
    {
        boolean estValide = true;

        if (inscriptionView.getGroupeRadioBtn().getSelection() == null)
        {
            inscriptionView.getLabelRequis9().setText("Ce champ est requis");
            estValide = false;
        }
        else
        {
            inscriptionView.getLabelRequis9().setText("");
        }

        if (inscriptionView.getTxtNom().getText().equals(""))
        {
            inscriptionView.getLabelRequis5().setText("Ce champ est requis");
            inscriptionView.getTxtNom().setBorder(new LineBorder(Color.RED, 2));
            estValide = false;
        }
        else
        {
            inscriptionView.getLabelRequis5().setText("");
            inscriptionView.getTxtNom().setBorder(new LineBorder(Color.GREEN, 2));
        }

        if (inscriptionView.getTxtPrenom().getText().equals(""))
        {
            inscriptionView.getLabelRequis6().setText("Ce champ est requis");
            inscriptionView.getTxtPrenom().setBorder(new LineBorder(Color.RED, 2));
            estValide = false;
        }
        else
        {
            inscriptionView.getLabelRequis6().setText("");
            inscriptionView.getTxtPrenom().setBorder(new LineBorder(Color.GREEN, 2));
        }

        if (inscriptionView.getTxtTelephone().getText().equals(""))
        {
            inscriptionView.getLabelRequis7().setText("Ce champ est requis");
            inscriptionView.getTxtTelephone().setBorder(new LineBorder(Color.RED, 2));
            estValide = false;
        }
        else if (!inscriptionView.getTxtTelephone().getText().matches("[0-9]+")
                || inscriptionView.getTxtTelephone().getText().length() != 10)
        {
            inscriptionView.getLabelRequis7().setText("");
            inscriptionView.getTxtTelephone().setBorder(new LineBorder(Color.RED, 2));
        }
        else
        {
            inscriptionView.getLabelRequis7().setText("");
            inscriptionView.getTxtTelephone().setBorder(new LineBorder(Color.GREEN, 2));
        }

        if (inscriptionView.getDateChooser().getDate() == null)
        {
            inscriptionView.getLabelRequis8().setText("Ce champ est requis");
            inscriptionView.getDateChooser().setBorder(new LineBorder(Color.RED, 2));
        }
        else
        {
            inscriptionView.getLabelRequis8().setText("");
            inscriptionView.getDateChooser().setBorder(new LineBorder(Color.GREEN, 2));
        }

        if (inscriptionView.getTxtNumero().getText().equals(""))
        {
            inscriptionView.getLabelRequis1().setText("Ce champ est requis");
            inscriptionView.getTxtNumero().setBorder(new LineBorder(Color.RED, 2));
            estValide = false;
        }
        else
        {
            inscriptionView.getLabelRequis1().setText("");
            inscriptionView.getTxtNumero().setBorder(new LineBorder(Color.GREEN, 2));
        }

        if (inscriptionView.getTxtCodepostal().getText().equals(""))
        {
            inscriptionView.getLabelRequis2().setText("Ce champ est requis");
            inscriptionView.getTxtCodepostal().setBorder(new LineBorder(Color.RED, 2));
            estValide = false;
        }
        else
        {
            inscriptionView.getLabelRequis2().setText("");
            inscriptionView.getTxtCodepostal().setBorder(new LineBorder(Color.GREEN, 2));
        }

        if (inscriptionView.getTxtVille().getText().equals(""))
        {
            inscriptionView.getLabelRequis3().setText("Ce champ est requis");
            inscriptionView.getTxtVille().setBorder(new LineBorder(Color.RED, 2));
            estValide = false;
        }
        else
        {
            inscriptionView.getLabelRequis3().setText("");
            inscriptionView.getTxtVille().setBorder(new LineBorder(Color.GREEN, 2));
        }

        // Champs non obligatoires
        if (inscriptionView.getTxtCourriel().getText().equals(""))
        {
            inscriptionView.getTxtCourriel().setBorder(new LineBorder(Color.GREEN, 2));
        }
        else if (inscriptionView.getTxtCourriel().getText().contains("@")
                && inscriptionView.getTxtCourriel().getText().contains("."))
        {
            inscriptionView.getTxtCourriel().setBorder(new LineBorder(Color.GREEN, 2));
        }
        else
            inscriptionView.getTxtCourriel().setBorder(new LineBorder(Color.RED, 2));

        return estValide;
    }
}