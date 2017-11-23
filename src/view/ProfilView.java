package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.LouerController;
import controller.ProfilController;
import view.InscriptionView;

/**
 * Vue qui s'occupe de l'affichge de la partie profil
 */
public class ProfilView extends AbstractView
{
    private ProfilController profilController;
    private LouerController louerController;

    private JFrame frmMonProfil;
    private JFrame frmScannerVotreCarte;

    private JTextField CxCarteTxtId;

    public JLabel labelPrenomNom;
    public JTable ProfilTableInformation;
    public JTable ProfilTableInfoAbonnement;

    public ProfilView(LouerController louerController)
    {
        this.profilController = new ProfilController(this);
        this.louerController = louerController;

        initProfil();
        initConnexionCarte();
    }

    private void initConnexionCarte()
    {
        frmScannerVotreCarte = new JFrame();
        frmScannerVotreCarte.setTitle("Scanner votre carte");
        frmScannerVotreCarte.setBounds(100, 100, 450, 184);
        frmScannerVotreCarte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmScannerVotreCarte.setLocationRelativeTo(null);

        JButton CxCarteBtnAnnuler = new JButton("Annuler");

        JLabel CxCarteLblScannerVotreCarte = new JLabel("Scanner votre carte sur le lecteur");
        CxCarteLblScannerVotreCarte.setFont(new Font("Tahoma", Font.BOLD, 16));

        JButton CxCarteBtnScanner = new JButton("Scanner");

        JTextField CxCarteTxtId = new JTextField();
        CxCarteTxtId.setColumns(10);

        JLabel CxCarteLblVotreId = new JLabel("Votre id :");
        GroupLayout groupLayout = new GroupLayout(frmScannerVotreCarte.getContentPane());
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
                .createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                                .addComponent(CxCarteLblScannerVotreCarte)
                                .addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addComponent(btnAide, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup().addGap(116).addComponent(CxCarteLblVotreId)
                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(CxCarteTxtId,
                                        GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
                .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(97)
                        .addComponent(CxCarteBtnScanner, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE).addGap(85))
                .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(189, Short.MAX_VALUE)
                        .addComponent(CxCarteBtnAnnuler).addGap(176)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnAide)
                                .addComponent(CxCarteLblScannerVotreCarte))
                        .addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(CxCarteLblVotreId)
                                .addComponent(CxCarteTxtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(CxCarteBtnScanner).addGap(11)
                        .addComponent(CxCarteBtnAnnuler).addGap(33)));
        frmScannerVotreCarte.getContentPane().setLayout(groupLayout);

        // ActionListener

        CxCarteBtnAnnuler.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                frmScannerVotreCarte.setVisible(false);
                accueilView.getFrmAccueil().setVisible(true);
            }
        });

        CxCarteBtnScanner.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Ceci est l'id card quand le périphérique scanner lit la
                // carte (on simule)
                if (profilController.connexion(Integer.parseInt(CxCarteTxtId.getText())))
                    frmScannerVotreCarte.setVisible(false);
                else
                    JOptionPane.showMessageDialog(new JFrame(), "Erreur dans l'id !", "Dialog",
                            JOptionPane.ERROR_MESSAGE);
            }

        });
    }

    private void initProfil()
    {
        frmMonProfil = new JFrame();
        frmMonProfil.setTitle("Profil");
        frmMonProfil.setResizable(false);
        frmMonProfil.setBounds(0, 0, 600, 500);
        frmMonProfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMonProfil.setLocationRelativeTo(null);

        JPanel ProfilPanel = new JPanel();
        ProfilPanel.setBorder(new TitledBorder(null, "Mon Profil", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        frmMonProfil.getContentPane().add(ProfilPanel, BorderLayout.CENTER);

        JTabbedPane ProfilTabbedPane = new JTabbedPane(JTabbedPane.TOP);

        JLabel ProfilLblConnectEnTant = new JLabel("Connecté en tant que");
        ProfilLblConnectEnTant.setHorizontalAlignment(SwingConstants.LEFT);
        ProfilLblConnectEnTant.setFont(new Font("Tahoma", Font.BOLD, 18));

        JButton ProfilBtnDeconnexion = new JButton("Deconnexion");
        ProfilBtnDeconnexion.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                profilController.seDeconnecter();
                accueilView.getFrmAccueil().setVisible(true);
            }
        });

        JButton ProfilBtnLouer = new JButton("Louer");
        ProfilBtnLouer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frmMonProfil.setVisible(false);
                louerController.location();
            }
        });

        labelPrenomNom = new JLabel("Prenom Nom");
        labelPrenomNom.setForeground(Color.RED);
        labelPrenomNom.setFont(new Font("Tahoma", Font.BOLD, 18));
        GroupLayout gl_ProfilPanel = new GroupLayout(ProfilPanel);
        gl_ProfilPanel.setHorizontalGroup(gl_ProfilPanel.createParallelGroup(
                Alignment.LEADING)
                .addGroup(gl_ProfilPanel.createSequentialGroup().addGroup(gl_ProfilPanel
                        .createParallelGroup(Alignment.LEADING).addGroup(gl_ProfilPanel.createSequentialGroup()
                                .addContainerGap().addGroup(gl_ProfilPanel
                                        .createParallelGroup(Alignment.LEADING).addGroup(gl_ProfilPanel
                                                .createSequentialGroup()
                                                .addComponent(ProfilLblConnectEnTant, GroupLayout.PREFERRED_SIZE, 196,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(labelPrenomNom))
                                        .addComponent(ProfilTabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
                                                562, Short.MAX_VALUE)
                                        .addGroup(Alignment.TRAILING,
                                                gl_ProfilPanel.createSequentialGroup()
                                                        .addComponent(ProfilBtnDeconnexion).addPreferredGap(
                                                                ComponentPlacement.RELATED,
                                                                393, Short.MAX_VALUE)
                                                        .addComponent(btnAide, GroupLayout.PREFERRED_SIZE, 74,
                                                                GroupLayout.PREFERRED_SIZE))))
                        .addGroup(gl_ProfilPanel.createSequentialGroup().addGap(20).addComponent(ProfilBtnLouer,
                                GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap()));
        gl_ProfilPanel.setVerticalGroup(gl_ProfilPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_ProfilPanel
                .createSequentialGroup()
                .addGroup(gl_ProfilPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_ProfilPanel.createSequentialGroup().addContainerGap().addComponent(
                                ProfilBtnDeconnexion, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnAide, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addGap(18)
                .addGroup(gl_ProfilPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(ProfilLblConnectEnTant, GroupLayout.PREFERRED_SIZE, 33,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelPrenomNom))
                .addGap(18).addComponent(ProfilTabbedPane, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(ProfilBtnLouer, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addContainerGap()));

        JPanel ProfilPanelLocation = new JPanel();
        ProfilTabbedPane.addTab("Location", null, ProfilPanelLocation, null);

        JLabel ProfilLblMesLocationsCours = new JLabel("Historique de mes locations :");
        ProfilLblMesLocationsCours.setFont(new Font("Tahoma", Font.BOLD, 11));

        JScrollPane ProfilScrollPaneLocation = new JScrollPane();
        GroupLayout gl_ProfilPanelLocation = new GroupLayout(ProfilPanelLocation);
        gl_ProfilPanelLocation.setHorizontalGroup(gl_ProfilPanelLocation.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_ProfilPanelLocation.createSequentialGroup()
                        .addGroup(gl_ProfilPanelLocation.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_ProfilPanelLocation.createSequentialGroup().addGap(173)
                                        .addComponent(ProfilLblMesLocationsCours))
                                .addGroup(gl_ProfilPanelLocation.createSequentialGroup().addContainerGap().addComponent(
                                        ProfilScrollPaneLocation, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)))
                        .addContainerGap()));
        gl_ProfilPanelLocation.setVerticalGroup(gl_ProfilPanelLocation.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_ProfilPanelLocation.createSequentialGroup().addContainerGap()
                        .addComponent(ProfilLblMesLocationsCours).addGap(17).addComponent(ProfilScrollPaneLocation,
                                GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(82, Short.MAX_VALUE)));

        JTable ProfilTableLocation = new JTable();
        ProfilTableLocation.setModel(new DefaultTableModel(
                new Object[][] { { new Integer(2), "10/11/2017 11:05:23", "11/11/2017 11:00:00", Boolean.TRUE }, },
                new String[] { "Qte.", "Date emprunt", "Date limite retour", "Rendu" })
        {
            Class[] columnTypes = new Class[] { Integer.class, Object.class, Object.class, Boolean.class };

            public Class getColumnClass(int columnIndex)
            {
                return columnTypes[columnIndex];
            }

            boolean[] columnEditables = new boolean[] { true, true, true, false };

            public boolean isCellEditable(int row, int column)
            {
                return columnEditables[column];
            }
        });
        ProfilTableLocation.getColumnModel().getColumn(0).setResizable(false);
        ProfilTableLocation.getColumnModel().getColumn(0).setPreferredWidth(33);
        ProfilTableLocation.getColumnModel().getColumn(0).setMinWidth(4);
        ProfilTableLocation.getColumnModel().getColumn(1).setPreferredWidth(120);
        ProfilTableLocation.getColumnModel().getColumn(2).setPreferredWidth(120);
        ProfilTableLocation.getColumnModel().getColumn(3).setResizable(false);
        ProfilScrollPaneLocation.setViewportView(ProfilTableLocation);
        ProfilPanelLocation.setLayout(gl_ProfilPanelLocation);

        JPanel ProfilPanelInformation = new JPanel();
        ProfilTabbedPane.addTab("Mes informations", null, ProfilPanelInformation, null);

        JScrollPane ProfilScrollPaneInformation = new JScrollPane();

        JButton ProfilBtnSeDesinscrire = new JButton("Se désinscrire");
        ProfilBtnSeDesinscrire.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                profilController.supprimerCompte();
            }
        });
        GroupLayout gl_ProfilPanelInformation = new GroupLayout(ProfilPanelInformation);
        gl_ProfilPanelInformation.setHorizontalGroup(gl_ProfilPanelInformation.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_ProfilPanelInformation.createSequentialGroup().addGroup(gl_ProfilPanelInformation
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_ProfilPanelInformation.createSequentialGroup().addContainerGap().addComponent(
                                ProfilScrollPaneInformation, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
                        .addGroup(gl_ProfilPanelInformation.createSequentialGroup().addGap(227).addComponent(
                                ProfilBtnSeDesinscrire, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap()));
        gl_ProfilPanelInformation.setVerticalGroup(gl_ProfilPanelInformation.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_ProfilPanelInformation.createSequentialGroup().addContainerGap()
                        .addComponent(ProfilScrollPaneInformation, GroupLayout.PREFERRED_SIZE, 44,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(32).addComponent(ProfilBtnSeDesinscrire, GroupLayout.PREFERRED_SIZE, 49,
                                GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(111, Short.MAX_VALUE)));

        ProfilTableInformation = new JTable();
        ProfilTableInformation.setShowHorizontalLines(false);
        ProfilTableInformation.setModel(new DefaultTableModel(
                new Object[][] { { "Efema", "Dodu", "31/12/1996", new Integer(1), "rue du Montagnais", "J1HQ23",
                        "Sherbrooke" }, },
                new String[] { "Nom", "Pr\u00E9nom", "Date Naissance", "N\u00B0 voie", "Voie", "Code postal", "Ville" })
        {
            Class[] columnTypes = new Class[] { String.class, Object.class, Object.class, Integer.class, Object.class,
                    Object.class, Object.class };

            public Class getColumnClass(int columnIndex)
            {
                return columnTypes[columnIndex];
            }
        });
        ProfilTableInformation.getColumnModel().getColumn(0).setResizable(false);
        ProfilTableInformation.getColumnModel().getColumn(1).setResizable(false);
        ProfilTableInformation.getColumnModel().getColumn(2).setResizable(false);
        ProfilTableInformation.getColumnModel().getColumn(2).setPreferredWidth(96);
        ProfilTableInformation.getColumnModel().getColumn(3).setResizable(false);
        ProfilTableInformation.getColumnModel().getColumn(3).setPreferredWidth(45);
        ProfilTableInformation.getColumnModel().getColumn(4).setPreferredWidth(104);
        ProfilTableInformation.getColumnModel().getColumn(5).setPreferredWidth(67);
        ProfilTableInformation.getColumnModel().getColumn(6).setResizable(false);
        ProfilScrollPaneInformation.setViewportView(ProfilTableInformation);
        ProfilPanelInformation.setLayout(gl_ProfilPanelInformation);

        JPanel ProfilPanelInfoAbonnement = new JPanel();
        ProfilTabbedPane.addTab("Mon abonnement", null, ProfilPanelInfoAbonnement, null);

        JScrollPane ProfilScrollPaneInfoAbonnement = new JScrollPane();

        JButton ProfilButtonResilier = new JButton("Résilier");
        ProfilButtonResilier.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                profilController.supprimerAbo();
                profilController.afficherAbo();
            }
        });

        JButton ProfilBtnRenouveler = new JButton("Renouveler");
        ProfilBtnRenouveler.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                profilController.renouvelerAbo();
                profilController.afficherAbo();
            }
        });

        JButton ProfilBtnChanger = new JButton("Changer");
        ProfilBtnChanger.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                profilController.modifierAbo();
                profilController.afficherAbo();
            }
        });

        GroupLayout gl_ProfilPanelInfoAbonnement = new GroupLayout(ProfilPanelInfoAbonnement);
        gl_ProfilPanelInfoAbonnement
                .setHorizontalGroup(
                        gl_ProfilPanelInfoAbonnement
                                .createParallelGroup(
                                        Alignment.LEADING)
                                .addGroup(gl_ProfilPanelInfoAbonnement.createSequentialGroup()
                                        .addGroup(gl_ProfilPanelInfoAbonnement.createParallelGroup(Alignment.LEADING)
                                                .addGroup(gl_ProfilPanelInfoAbonnement.createSequentialGroup()
                                                        .addContainerGap().addComponent(ProfilScrollPaneInfoAbonnement,
                                                                GroupLayout.PREFERRED_SIZE, 489,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addGroup(gl_ProfilPanelInfoAbonnement.createSequentialGroup()
                                                        .addGap(65)
                                                        .addComponent(ProfilButtonResilier, GroupLayout.PREFERRED_SIZE,
                                                                129, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18)
                                                        .addComponent(ProfilBtnChanger, GroupLayout.PREFERRED_SIZE, 129,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18).addComponent(ProfilBtnRenouveler,
                                                                GroupLayout.PREFERRED_SIZE, 130,
                                                                GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap(58, Short.MAX_VALUE)));
        gl_ProfilPanelInfoAbonnement.setVerticalGroup(gl_ProfilPanelInfoAbonnement
                .createParallelGroup(Alignment.LEADING)
                .addGroup(gl_ProfilPanelInfoAbonnement.createSequentialGroup().addContainerGap()
                        .addComponent(ProfilScrollPaneInfoAbonnement, GroupLayout.PREFERRED_SIZE, 44,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(34)
                        .addGroup(gl_ProfilPanelInfoAbonnement.createParallelGroup(Alignment.BASELINE)
                                .addComponent(ProfilBtnRenouveler, GroupLayout.PREFERRED_SIZE, 55,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(ProfilBtnChanger, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                .addComponent(ProfilButtonResilier, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                        .addContainerGap(103, Short.MAX_VALUE)));

        ProfilTableInfoAbonnement = new JTable();
        ProfilTableInfoAbonnement.setShowHorizontalLines(false);
        ProfilTableInfoAbonnement.setRowSelectionAllowed(false);
        ProfilTableInfoAbonnement.setModel(new DefaultTableModel(
                new Object[][] { { new Integer(1), "10/11/2017 11:03:20", "10/12/2017 11:03:20", new Integer(50) }, },
                new String[] { "Dur\u00E9e en mois", "Date d\u00E9but", "Date fin", "Prix $CAN" })
        {
            Class[] columnTypes = new Class[] { Integer.class, Object.class, Object.class, Integer.class };

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
        ProfilTableInfoAbonnement.getColumnModel().getColumn(0).setResizable(false);
        ProfilTableInfoAbonnement.getColumnModel().getColumn(0).setPreferredWidth(83);
        ProfilTableInfoAbonnement.getColumnModel().getColumn(1).setResizable(false);
        ProfilTableInfoAbonnement.getColumnModel().getColumn(1).setPreferredWidth(120);
        ProfilTableInfoAbonnement.getColumnModel().getColumn(2).setResizable(false);
        ProfilTableInfoAbonnement.getColumnModel().getColumn(2).setPreferredWidth(120);
        ProfilTableInfoAbonnement.getColumnModel().getColumn(3).setResizable(false);
        ProfilTableInfoAbonnement.getColumnModel().getColumn(3).setPreferredWidth(58);
        ProfilScrollPaneInfoAbonnement.setViewportView(ProfilTableInfoAbonnement);
        ProfilPanelInfoAbonnement.setLayout(gl_ProfilPanelInfoAbonnement);
        ProfilPanel.setLayout(gl_ProfilPanel);
    }

    /**
     * @return the frmMonProfil
     */
    public JFrame getFrmMonProfil()
    {
        return frmMonProfil;
    }

    /**
     * @return the frmScannerVotreCarte
     */
    public JFrame getFrmScannerVotreCarte()
    {
        return frmScannerVotreCarte;
    }
}
