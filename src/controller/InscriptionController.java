package controller;

import java.awt.Color;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import sun.font.CreatedFontTracker;
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

    public void resetValeur()
    {
        inscriptionView.getGroupeRadioBtn().clearSelection();
        inscriptionView.getTxtNom().setText("");
        inscriptionView.getTxtPrenom().setText("");
        inscriptionView.getTxtTelephone().setText("");
        inscriptionView.getDateChooser().setCalendar(null);
        inscriptionView.getTxtCourriel().setText("");
        inscriptionView.getTxtNumero().setText("");
        inscriptionView.getTxtCodepostal().setText("");
        inscriptionView.getTxtVille().setText("");

        setEmptyBorder();
        hideMessage();
    }

    public void setEmptyBorder()
    {
        inscriptionView.getTxtNom().setBorder(UIManager.getBorder("TextField.border"));
        inscriptionView.getTxtPrenom().setBorder(UIManager.getBorder("TextField.border"));
        inscriptionView.getTxtTelephone().setBorder(UIManager.getBorder("TextField.border"));
        inscriptionView.getDateChooser().setBorder(UIManager.getBorder("TextField.border"));
        inscriptionView.getTxtCourriel().setBorder(UIManager.getBorder("TextField.border"));
        inscriptionView.getTxtNumero().setBorder(UIManager.getBorder("TextField.border"));
        inscriptionView.getTxtCodepostal().setBorder(UIManager.getBorder("TextField.border"));
        inscriptionView.getTxtVille().setBorder(UIManager.getBorder("TextField.border"));
    }

    public void hideMessage()
    {
        inscriptionView.getLabelRequis1().setText("");
        inscriptionView.getLabelRequis2().setText("");
        inscriptionView.getLabelRequis3().setText("");
        inscriptionView.getLabelRequis4().setText("");
        inscriptionView.getLabelRequis5().setText("");
        inscriptionView.getLabelRequis6().setText("");
        inscriptionView.getLabelRequis7().setText("");
        inscriptionView.getLabelRequis8().setText("");
        inscriptionView.getLabelRequis9().setText("");
    }

    public void paiement(int i)
    {
        if (i == 1)
        {
            inscriptionView.getLblPrixTotal().setText("Prix total : 50$ CAN");
            inscriptionView.getTable().getModel().setValueAt("1", 0, 0);
            inscriptionView.getTable().getModel().setValueAt("Abonnement", 0, 1);
            inscriptionView.getTable().getModel().setValueAt("50", 0, 2);
        }
        else if (i == 2)
        {
            inscriptionView.getLblPrixTotal().setText("Prix total : 130$ CAN");
            inscriptionView.getTable().getModel().setValueAt("1", 0, 0);
            inscriptionView.getTable().getModel().setValueAt("Abonnement", 0, 1);
            inscriptionView.getTable().getModel().setValueAt("130", 0, 2);
        }
        else
        {
            inscriptionView.getLblPrixTotal().setText("Prix total : 540$ CAN");
            inscriptionView.getTable().getModel().setValueAt("1", 0, 0);
            inscriptionView.getTable().getModel().setValueAt("Abonnement", 0, 1);
            inscriptionView.getTable().getModel().setValueAt("540", 0, 2);
        }
    }
}