package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ConnexionTempoController;
import controller.InscriptionController;
import controller.LouerController;
import controller.ProfilController;

public class AccueilView
{
    private InscriptionView inscriptionView;
    private ProfilView profilView;
    private ConnexionTempoView connexionTempoView;
    private LouerView louerView;
    
    private ConnexionTempoController connexionTempoController;
    private InscriptionController inscriptionController;
    private LouerController louerController;
    private ProfilController profilController;

    private JFrame frmAccueil;
    
    public AccueilView()
    {
        louerView = new LouerView();
        louerController = new LouerController(louerView);
               
        profilView = new ProfilView(louerController);
        profilController = new ProfilController(profilView);
        
        inscriptionView = new InscriptionView(profilController);
        inscriptionController = new InscriptionController(inscriptionView);
            
        connexionTempoView = new ConnexionTempoView(louerController);
        connexionTempoController = new ConnexionTempoController(connexionTempoView);

        init();         
    }
    
    private void init()
    {
        frmAccueil = new JFrame();
        frmAccueil.setResizable(false);
        frmAccueil.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        frmAccueil.setTitle("Accueil");
        frmAccueil.setBounds(100, 100, 555, 219);
        frmAccueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{80, 191, 0, 191, 80, 0};
        gridBagLayout.rowHeights = new int[]{0, 55, 0, 0, 0, 9, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        frmAccueil.getContentPane().setLayout(gridBagLayout);
        
        JLabel AccueilLblVelocation = new JLabel("VeloCation - Bienvenue !");
        AccueilLblVelocation.setFont(new Font("Tahoma", Font.BOLD, 17));
        GridBagConstraints gbc_AccueilLblVelocation = new GridBagConstraints();
        gbc_AccueilLblVelocation.fill = GridBagConstraints.VERTICAL;
        gbc_AccueilLblVelocation.gridwidth = 3;
        gbc_AccueilLblVelocation.insets = new Insets(0, 0, 5, 5);
        gbc_AccueilLblVelocation.gridx = 1;
        gbc_AccueilLblVelocation.gridy = 0;
        frmAccueil.getContentPane().add(AccueilLblVelocation, gbc_AccueilLblVelocation);
        
        JLabel AccueilLblBienvenue = new JLabel("Borne n°72 - 5 rue de l'Interface - J1H Q4H Sherbrooke");
        AccueilLblBienvenue.setFont(new Font("Tahoma", Font.BOLD, 12));
        GridBagConstraints gbc_AccueilLblBienvenue = new GridBagConstraints();
        gbc_AccueilLblBienvenue.gridwidth = 3;
        gbc_AccueilLblBienvenue.insets = new Insets(0, 0, 5, 5);
        gbc_AccueilLblBienvenue.gridx = 1;
        gbc_AccueilLblBienvenue.gridy = 1;
        frmAccueil.getContentPane().add(AccueilLblBienvenue, gbc_AccueilLblBienvenue);
        
        JButton AccueilBtnAide = new JButton("Aide");
        GridBagConstraints gbc_AccueilBtnAide = new GridBagConstraints();
        gbc_AccueilBtnAide.insets = new Insets(0, 0, 5, 0);
        gbc_AccueilBtnAide.gridx = 4;
        gbc_AccueilBtnAide.gridy = 1;
        frmAccueil.getContentPane().add(AccueilBtnAide, gbc_AccueilBtnAide);
        AccueilBtnAide.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO
            }      
        });
        
        
        JButton AccueilBtnSinscrire = new JButton("S'inscrire");
        AccueilBtnSinscrire.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_AccueilBtnSinscrire = new GridBagConstraints();
        gbc_AccueilBtnSinscrire.gridwidth = 3;
        gbc_AccueilBtnSinscrire.fill = GridBagConstraints.HORIZONTAL;
        gbc_AccueilBtnSinscrire.insets = new Insets(0, 0, 5, 5);
        gbc_AccueilBtnSinscrire.gridx = 1;
        gbc_AccueilBtnSinscrire.gridy = 2;
        frmAccueil.getContentPane().add(AccueilBtnSinscrire, gbc_AccueilBtnSinscrire);
        AccueilBtnSinscrire.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                frmAccueil.setVisible(false);
                inscriptionController.inscrireMembre();
            }      
        });
        
        JButton AccueilBtnSeConnecterTemp = new JButton("Se Connecter - Sans compte");
        AccueilBtnSeConnecterTemp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frmAccueil.setVisible(false);
                connexionTempoController.numTel();
            }
        });
        GridBagConstraints gbc_AccueilBtnSeConnecterTemp = new GridBagConstraints();
        gbc_AccueilBtnSeConnecterTemp.fill = GridBagConstraints.HORIZONTAL;
        gbc_AccueilBtnSeConnecterTemp.insets = new Insets(0, 0, 5, 5);
        gbc_AccueilBtnSeConnecterTemp.gridx = 1;
        gbc_AccueilBtnSeConnecterTemp.gridy = 3;
        frmAccueil.getContentPane().add(AccueilBtnSeConnecterTemp, gbc_AccueilBtnSeConnecterTemp);
        AccueilBtnSeConnecterTemp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO
            }      
        });
        
        JButton AccueilBtnSeConnecter = new JButton("S'identifier - Compte client");
        AccueilBtnSeConnecter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        AccueilBtnSeConnecter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                frmAccueil.setVisible(false);
                profilController.connexion();
            }      
        });
        
        JLabel AccueilLblOu = new JLabel("ou");
        GridBagConstraints gbc_AccueilLblOu = new GridBagConstraints();
        gbc_AccueilLblOu.insets = new Insets(0, 0, 5, 5);
        gbc_AccueilLblOu.gridx = 2;
        gbc_AccueilLblOu.gridy = 3;
        frmAccueil.getContentPane().add(AccueilLblOu, gbc_AccueilLblOu);
        GridBagConstraints gbc_AccueilBtnSeConnecter = new GridBagConstraints();
        gbc_AccueilBtnSeConnecter.fill = GridBagConstraints.HORIZONTAL;
        gbc_AccueilBtnSeConnecter.insets = new Insets(0, 0, 5, 5);
        gbc_AccueilBtnSeConnecter.gridx = 3;
        gbc_AccueilBtnSeConnecter.gridy = 3;
        frmAccueil.getContentPane().add(AccueilBtnSeConnecter, gbc_AccueilBtnSeConnecter);
        
        JButton AccueilBtnAfficherCarte = new JButton("Carte bornes");
        GridBagConstraints gbc_AccueilBtnAfficherCarte = new GridBagConstraints();
        gbc_AccueilBtnAfficherCarte.fill = GridBagConstraints.HORIZONTAL;
        gbc_AccueilBtnAfficherCarte.gridwidth = 3;
        gbc_AccueilBtnAfficherCarte.insets = new Insets(0, 0, 5, 5);
        gbc_AccueilBtnAfficherCarte.gridx = 1;
        gbc_AccueilBtnAfficherCarte.gridy = 4;
        frmAccueil.getContentPane().add(AccueilBtnAfficherCarte, gbc_AccueilBtnAfficherCarte);
        AccueilBtnAfficherCarte.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO
            }      
        });
        
        frmAccueil.setVisible(true);
    }
}
