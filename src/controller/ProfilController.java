package controller;

import java.time.LocalDate;

import javax.swing.table.DefaultTableModel;

import model.Session;
import model.Membre;
import model.MembreAbonne;
import view.ProfilView;
import view.AbstractView;
import view.InscriptionView;
import controller.AbstractController;

/**
 * Controleur de la vue Profil
 */
public class ProfilController extends AbstractController
{
    private ProfilView profilView;
    private InscriptionView inscriptionView;

    public ProfilController(ProfilView profilViewArg)
    {
        this.profilView = profilViewArg;
    }

    public void afficherProfil()
    {
        profilView.getFrmMonProfil().setVisible(true);
        MembreAbonne membre = (MembreAbonne) session.getMembre();
        
        profilView.ProfilLblConnectEnTant.setText("Connecté en tant que " + membre.getPrenom() + membre.getNom());
        profilView.ProfilTableInformation.setModel(new DefaultTableModel(
                new Object[][] { { membre.getNom(), membre.getPrenom(), "date de naissance", membre.getAdresse().toString() }, },
        new String[] { "Nom", "Pr\u00E9nom", "Date Naissance", "Adresse" })
        
{
    Class[] columnTypes = new Class[] { String.class, String.class, Object.class, String.class};

    public Class getColumnClass(int columnIndex)
    {
        return columnTypes[columnIndex];
    }
});
        System.out.println(membre.getAdresse().toString());
    }

    public void afficherAbo()		
    {
    	MembreAbonne membre = (MembreAbonne) session.getMembre();
    	
    	profilView.ProfilTableInfoAbonnement.setModel(new DefaultTableModel(
                new Object[][] { { membre.getAbonnement().getDuree() , membre.getAbonnement().getDate().minusMonths(membre.getAbonnement().getDuree()), membre.getAbonnement().getDate(), membre.getAbonnement().getPrix() }, },
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


    public void renouvelerAbo()
    {
    	MembreAbonne membre = (MembreAbonne) session.getMembre();
    	membre.getAbonnement().setDate(membre.getAbonnement().getDate().plusMonths(1));
    }

    public void supprimerAbo()
    {
    	MembreAbonne membre = (MembreAbonne) session.getMembre();
    	membre.setAbonnement("Aucun abonnement", 0.0, 0, LocalDate.now());
    }

    public void modifierAbo()
    {
    	//a faire
    }

    public void modifierCompte()
    {
    	//a faire
    	
    }

    public void supprimerCompte()
    {
    	MembreAbonne membre = (MembreAbonne) session.getMembre();
    	session.supprimerMembre(membre);
    	profilView.getFrmMonProfil().setVisible(false);
    }
    
    public void seDeconnecter()
    {
    	session.deconnection();
    	profilView.getFrmMonProfil().setVisible(false);
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

    /**
     * @return the profilView
     */
    public ProfilView getProfilView()
    {
        return profilView;
    }
}