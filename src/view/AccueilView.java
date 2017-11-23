package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.ConnexionTempoController;
import controller.InscriptionController;
import controller.LouerController;
import controller.ProfilController;

public class AccueilView extends AbstractView
{
    private InscriptionView inscriptionView;
    private ProfilView profilView;
    private ConnexionTempoView connexionTempoView;
    private LouerView louerView;

    private ConnexionTempoController connexionTempoController;
    private InscriptionController inscriptionController;
    private LouerController louerController;
    private ProfilController profilController;

    private static JFrame frmAccueil;
    private static JFrame frmPaiement;

    public AccueilView()
    {
        super();
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
        frmAccueil.setBounds(0, 0, 600, 500);
        frmAccueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAccueil.setLocationRelativeTo(null);

        JLabel AccueilLblVelocation = new JLabel("Bienvenue !");
        AccueilLblVelocation.setFont(new Font("Tahoma", Font.BOLD, 25));

        JLabel AccueilLblBorne = new JLabel("Vous \u00EAtes sur la borne n°72");
        AccueilLblBorne.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel AccueilLblBienvenue = new JLabel("5 rue de l'Interface - J1H Q4H Sherbrooke");
        AccueilLblBienvenue.setFont(new Font("Tahoma", Font.ITALIC, 13));

        JButton AccueilBtnAide = AbstractView.btnAide;

        JButton AccueilBtnSinscrire = new JButton("INSCRIPTION");
        AccueilBtnSinscrire.setBackground(new Color(255, 228, 196));
        AccueilBtnSinscrire.setFont(new Font("Tahoma", Font.BOLD, 11));

        JButton AccueilBtnSeConnecterTemp = new JButton("LOCATION TEMPORAIRE");
        AccueilBtnSeConnecterTemp.setBackground(new Color(22, 184, 78));
        AccueilBtnSeConnecterTemp.setFont(new Font("Tahoma", Font.BOLD, 13));

        JButton AccueilBtnSeConnecter = new JButton("CONNEXION");
        AccueilBtnSeConnecter.setBackground(new Color(22, 184, 78));
        AccueilBtnSeConnecter.setFont(new Font("Tahoma", Font.BOLD, 13));

        JButton AccueilBtnAfficherCarte = new JButton("Carte bornes");

        JButton btnContact = new JButton("Contact");

        JSeparator separator = new JSeparator();

        JLabel lblVousLouezRgulirement = new JLabel(
                "Vous louez r\u00E9guli\u00E8rement et n'\u00EAtes pas encore inscrit ?");
        lblVousLouezRgulirement.setFont(new Font("Tahoma", Font.ITALIC, 13));

        JLabel lblVelocation = new JLabel("Velocation");
        lblVelocation.setFont(new Font("Tahoma", Font.ITALIC, 16));

        GroupLayout groupLayout = new GroupLayout(frmAccueil.getContentPane());
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
                .createSequentialGroup().addGap(103)
                .addComponent(AccueilBtnAide, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE).addGap(32)
                .addComponent(AccueilBtnAfficherCarte, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                .addGap(34).addComponent(btnContact, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                .addGap(111))
                .addGroup(Alignment.LEADING,
                        groupLayout.createSequentialGroup().addGap(81)
                                .addComponent(AccueilBtnSeConnecterTemp, GroupLayout.PREFERRED_SIZE, 205,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(AccueilBtnSeConnecter, GroupLayout.PREFERRED_SIZE, 204,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(86, Short.MAX_VALUE))
                .addComponent(separator, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addGroup(
                        groupLayout.createSequentialGroup().addGap(210)
                                .addComponent(AccueilBtnSinscrire, GroupLayout.PREFERRED_SIZE, 167,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(217, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup().addGap(132)
                        .addComponent(lblVousLouezRgulirement, GroupLayout.PREFERRED_SIZE, 337,
                                GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(125, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                        .addComponent(lblVelocation, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                        .addGap(141).addComponent(AccueilLblVelocation, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addGap(202))
                .addGroup(groupLayout.createSequentialGroup().addContainerGap(183, Short.MAX_VALUE)
                        .addComponent(AccueilLblBienvenue).addGap(171))
                .addGroup(groupLayout.createSequentialGroup().addContainerGap(211, Short.MAX_VALUE)
                        .addComponent(AccueilLblBorne).addGap(191)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(AccueilLblVelocation, GroupLayout.PREFERRED_SIZE, 50,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblVelocation))
                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(AccueilLblBorne)
                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(AccueilLblBienvenue).addGap(46)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(AccueilBtnSeConnecter, GroupLayout.PREFERRED_SIZE, 95,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(AccueilBtnSeConnecterTemp, GroupLayout.PREFERRED_SIZE, 94,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(38).addComponent(lblVousLouezRgulirement, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(AccueilBtnSinscrire, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                        .addGap(34).addComponent(separator, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
                        .addGap(8)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(AccueilBtnAide, GroupLayout.PREFERRED_SIZE, 32,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(AccueilBtnAfficherCarte, GroupLayout.PREFERRED_SIZE, 32,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnContact, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));
        frmAccueil.getContentPane().setLayout(groupLayout);

        // ActionListener
        AccueilBtnSinscrire.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frmAccueil.setVisible(false);
                inscriptionController.inscrireMembre();
                inscriptionController.hideMessage();
                inscriptionController.resetValeur();
                inscriptionController.setEmptyBorder();
            }
        });

        AccueilBtnSeConnecterTemp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                frmAccueil.setVisible(false);
                connexionTempoController.numTel();
                connexionTempoController.setEmptyBorder();
                connexionTempoController.hideMessage();
            }
        });

        AccueilBtnSeConnecter.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frmAccueil.setVisible(false);
                profilController.scannerCarte();
                profilController.setEmptyBorder();
                profilController.hideMessage();
            }
        });

        AccueilBtnAfficherCarte.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO
            }
        });

        frmAccueil.setVisible(true);
    }

    /**
     * @return the frmAccueil
     */
    public JFrame getFrmAccueil()
    {
        return frmAccueil;
    }

    /**
     * @return the profilView
     */
    public ProfilView getProfilView()
    {
        return profilView;
    }

    /**
     * @return the inscriptionView
     */
    public InscriptionView getInscriptionView()
    {
        return inscriptionView;
    }

    /**
     * @return the inscriptionController
     */
    public InscriptionController getInscriptionController()
    {
        return inscriptionController;
    }

    /**
     * @return the profilController
     */
    public ProfilController getProfilController()
    {
        return profilController;
    }

    /**
     * @return the louerView
     */
    public LouerView getLouerView()
    {
        return louerView;
    }
}