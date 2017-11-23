package controller;

import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import model.MembreAbonne;
import view.AccueilView;
import view.ProfilView;
import controller.AbstractController;

/**
 * Controleur de la vue Profil
 */
public class ProfilController extends AbstractController
{
    private ProfilView profilView;

    /**
     * Constructeur de confort
     * 
     * @param profilViewArg
     */
    public ProfilController(ProfilView profilViewArg)
    {
        this.profilView = profilViewArg;
    }

    /**
     * Affiche les informations personnelles de l'utilisateur
     */
    public void afficherProfil()
    {
        profilView.getFrmMonProfil().setVisible(true);
        MembreAbonne membre = (MembreAbonne) session.getMembre();

        profilView.ProfilLblConnectEnTant.setText("Connect� en tant que " + membre.getPrenom() + membre.getNom());
        profilView.ProfilTableInformation
                .setModel(new DefaultTableModel(
                        new Object[][] { { membre.getNom(), membre.getPrenom(), membre.getDateNaiss().toString(),
                                membre.getAdresse() }, },
                        new String[] { "Nom", "Pr\u00E9nom", "Date Naissance", "Adresse" })

                {
                    Class[] columnTypes = new Class[] { String.class, String.class, Object.class, String.class };

                    public Class getColumnClass(int columnIndex)
                    {
                        return columnTypes[columnIndex];
                    }
                });
    }

    /**
     * Affiche les informations de l'abonnement de l'utilisateur
     */
    public void afficherAbo()
    {
        MembreAbonne membre = (MembreAbonne) session.getMembre();

        profilView.ProfilTableInfoAbonnement.setModel(new DefaultTableModel(
                new Object[][] { { membre.getAbonnement().getDuree(),
                        membre.getAbonnement().getDate().minusMonths(membre.getAbonnement().getDuree()),
                        membre.getAbonnement().getDate(), membre.getAbonnement().getPrix() }, },
                new String[] { "Dur\u00E9e en mois", "Date d\u00E9but", "Date fin", "Prix $CAN" })
        {
            Class[] columnTypes = new Class[] { Integer.class, Object.class, Object.class, double.class };

            public Class getColumnClass(int columnIndex)
            {
                return columnTypes[columnIndex];
            }

            boolean[] columnEditables = new boolean[] { false, false, false, false };

            public boolean isCellEditable(int row, int column)
            {
                return columnEditables[column];
            }
        });
    }

    /**
     * Renouvelle l'abonnement d'un mois
     */
    public void renouvelerAbo()
    {
        MembreAbonne membre = (MembreAbonne) session.getMembre();
        membre.getAbonnement().setDate(membre.getAbonnement().getDate().plusMonths(1));
    }

    /**
     * Résiliation de l'abonnement
     */
    public void supprimerAbo()
    {
        MembreAbonne membre = (MembreAbonne) session.getMembre();
        membre.setAbonnement("Aucun abonnement", 0.0, 0, LocalDate.now());
    }

    public void modifierAbo()
    {
        // a faire
    }

    public void modifierCompte()
    {
        // a faire

    }

    /**
     * Désinscription de l'utilisateur
     */
    public void supprimerCompte()
    {
        MembreAbonne membre = (MembreAbonne) session.getMembre();
        session.supprimerMembre(membre);
        profilView.getFrmMonProfil().setVisible(false);
    }

    /**
     * Déconnection de l'utilisateur
     */
    public void seDeconnecter()
    {
        session.deconnection();
        profilView.getFrmMonProfil().setVisible(false);
    }

    /**
     * Après connexion par carte
     */
    public void scannerCarte()
    {
        profilView.getFrmScannerVotreCarte().setVisible(true);
    }

    /**
     * 
     * @param id
     * @return boolean
     * @throws Exception
     */
    public boolean connexion(int id)
    {
        if (session.connexion(id))
        {
            profilView.getFrmMonProfil().setVisible(true);
            return true;
        }
        else
            return false;
    }

    /**
     * @return the profilView
     */
    public ProfilView getProfilView()
    {
        return profilView;
    }
}