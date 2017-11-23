package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.LouerController;
import controller.ProfilController;

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

    public JLabel ProfilLblConnectEnTant;
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
        frmScannerVotreCarte.setTitle("S'identifier");
        frmScannerVotreCarte.setBounds(0, 0, 600, 500);
        frmScannerVotreCarte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmScannerVotreCarte.setLocationRelativeTo(null);
        
        JPanel CxCartePanel = new JPanel();
        CxCartePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        
        JPanel CxCartePanelBouton = new JPanel();
        GroupLayout groupLayout = new GroupLayout(frmScannerVotreCarte.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(CxCartePanelBouton, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                        .addComponent(CxCartePanel, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                        .addComponent(btnAide, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnAide, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(CxCartePanel, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addGap(4)
                    .addComponent(CxCartePanelBouton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        
        JButton CxCarteBtnAnnuler = new JButton("Annuler");
        CxCarteBtnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JButton CxCarteBtnScanner = new JButton("Valider");
        CxCarteBtnScanner.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GroupLayout gl_CxCartePanelBouton = new GroupLayout(CxCartePanelBouton);
        gl_CxCartePanelBouton.setHorizontalGroup(
            gl_CxCartePanelBouton.createParallelGroup(Alignment.TRAILING)
                .addGroup(Alignment.LEADING, gl_CxCartePanelBouton.createSequentialGroup()
                    .addComponent(CxCarteBtnAnnuler, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                    .addComponent(CxCarteBtnScanner, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
        );
        gl_CxCartePanelBouton.setVerticalGroup(
            gl_CxCartePanelBouton.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_CxCartePanelBouton.createSequentialGroup()
                    .addGroup(gl_CxCartePanelBouton.createParallelGroup(Alignment.BASELINE)
                        .addComponent(CxCarteBtnAnnuler, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                        .addComponent(CxCarteBtnScanner, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                    .addContainerGap())
        );
        CxCartePanelBouton.setLayout(gl_CxCartePanelBouton);
        
        JLabel lblOu = new JLabel("Ou");
        lblOu.setForeground(new Color(255, 0, 0));
        lblOu.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        JPanel CxCartePanelId = new JPanel();
        CxCartePanelId.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        
        JPanel CxCartePanelCarte = new JPanel();
        CxCartePanelCarte.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        GroupLayout gl_CxCartePanel = new GroupLayout(CxCartePanel);
        gl_CxCartePanel.setHorizontalGroup(
            gl_CxCartePanel.createParallelGroup(Alignment.TRAILING)
                .addGroup(Alignment.LEADING, gl_CxCartePanel.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_CxCartePanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_CxCartePanel.createSequentialGroup()
                            .addComponent(lblOu)
                            .addGap(267))
                        .addGroup(Alignment.TRAILING, gl_CxCartePanel.createSequentialGroup()
                            .addGroup(gl_CxCartePanel.createParallelGroup(Alignment.TRAILING)
                                .addComponent(CxCartePanelId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                                .addComponent(CxCartePanelCarte, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
                            .addContainerGap())))
        );
        gl_CxCartePanel.setVerticalGroup(
            gl_CxCartePanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_CxCartePanel.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CxCartePanelCarte, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblOu)
                    .addGap(3)
                    .addComponent(CxCartePanelId, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE))
        );
        
        JLabel CxCarteLblScannerVotreCarte = new JLabel("Scanner votre carte sur le lecteur");
        CxCarteLblScannerVotreCarte.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        JLabel CxCarteScannerLogo = new JLabel("");
        CxCarteScannerLogo.setIcon(new ImageIcon(ProfilView.class.getResource("/com/sun/java/swing/plaf/motif/icons/DesktopIcon.gif")));
        GroupLayout gl_CxCartePanelCarte = new GroupLayout(CxCartePanelCarte);
        gl_CxCartePanelCarte.setHorizontalGroup(
            gl_CxCartePanelCarte.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_CxCartePanelCarte.createSequentialGroup()
                    .addGroup(gl_CxCartePanelCarte.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_CxCartePanelCarte.createSequentialGroup()
                            .addGap(246)
                            .addComponent(CxCarteScannerLogo))
                        .addGroup(gl_CxCartePanelCarte.createSequentialGroup()
                            .addGap(134)
                            .addComponent(CxCarteLblScannerVotreCarte)))
                    .addContainerGap(134, Short.MAX_VALUE))
        );
        gl_CxCartePanelCarte.setVerticalGroup(
            gl_CxCartePanelCarte.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_CxCartePanelCarte.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CxCarteLblScannerVotreCarte)
                    .addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                    .addComponent(CxCarteScannerLogo)
                    .addGap(10))
        );
        CxCartePanelCarte.setLayout(gl_CxCartePanelCarte);
        
        CxCarteTxtId = new JTextField();
        CxCarteTxtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        CxCarteTxtId.setColumns(10);
        
        JLabel CxCarteLblVotreId = new JLabel("Votre numéro client :");
        CxCarteLblVotreId.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JLabel lblSaisirVotreIdentifiant = new JLabel("Saisir votre identifiant");
        lblSaisirVotreIdentifiant.setFont(new Font("Tahoma", Font.BOLD, 16));
        GroupLayout gl_CxCartePanelId = new GroupLayout(CxCartePanelId);
        gl_CxCartePanelId.setHorizontalGroup(
            gl_CxCartePanelId.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_CxCartePanelId.createSequentialGroup()
                    .addGap(179)
                    .addComponent(lblSaisirVotreIdentifiant)
                    .addContainerGap(174, Short.MAX_VALUE))
                .addGroup(gl_CxCartePanelId.createSequentialGroup()
                    .addContainerGap(102, Short.MAX_VALUE)
                    .addComponent(CxCarteLblVotreId)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(CxCarteTxtId, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                    .addGap(98))
        );
        gl_CxCartePanelId.setVerticalGroup(
            gl_CxCartePanelId.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_CxCartePanelId.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblSaisirVotreIdentifiant)
                    .addGap(18)
                    .addGroup(gl_CxCartePanelId.createParallelGroup(Alignment.BASELINE)
                        .addComponent(CxCarteLblVotreId)
                        .addComponent(CxCarteTxtId, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(90, Short.MAX_VALUE))
        );
        CxCartePanelId.setLayout(gl_CxCartePanelId);
        CxCartePanel.setLayout(gl_CxCartePanel);
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
                
                try {
                    if(!profilController.connexion(Integer.parseInt(CxCarteTxtId.getText())))
                        throw new Exception("Compte client inexistant ! Contacter l'assistance ou réessayer.");
                    frmScannerVotreCarte.setVisible(false);
                    profilController.getProfilView().getCxCarteTxtId().setBorder(UIManager.getBorder("TextField.border"));

                } catch (NumberFormatException exception)
                {
                    profilController.getProfilView().getCxCarteTxtId().setBorder(new LineBorder(Color.RED, 2));
                    JOptionPane.showMessageDialog(new JFrame(), "Saisir votre identifiant !", "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception exception)
                {
                    profilController.getProfilView().getCxCarteTxtId().setBorder(new LineBorder(Color.RED, 2));
                    JOptionPane.showMessageDialog(new JFrame(), exception.getMessage(), "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        });
    }

    private void initProfil()
    {
        frmMonProfil = new JFrame();
        frmMonProfil.setTitle("Profil");
        frmMonProfil.setResizable(false);
        frmMonProfil.setBounds(100, 100, 542, 314);
        frmMonProfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMonProfil.setLocationRelativeTo(null);

        JPanel ProfilPanel = new JPanel();
        ProfilPanel.setBorder(new TitledBorder(null, "Mon Profil", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        frmMonProfil.getContentPane().add(ProfilPanel, BorderLayout.CENTER);

        JTabbedPane ProfilTabbedPane = new JTabbedPane(JTabbedPane.TOP);

        JLabel ProfilLblBonjourBienvenue = new JLabel("Profil");
        ProfilLblBonjourBienvenue.setFont(new Font("Tahoma", Font.BOLD, 14));

        ProfilLblConnectEnTant = new JLabel("Connecté en tant que XX XXX");

        JButton ProfilBtnDeconnexion = new JButton("Deconnexion");

        ProfilBtnDeconnexion.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                profilController.seDeconnecter();
                accueilView.getFrmAccueil().setVisible(true);
            }
        });

        GroupLayout gl_ProfilPanel = new GroupLayout(ProfilPanel);
        gl_ProfilPanel.setHorizontalGroup(gl_ProfilPanel.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_ProfilPanel.createSequentialGroup().addContainerGap()
                        .addGroup(gl_ProfilPanel.createParallelGroup(Alignment.TRAILING)
                                .addComponent(ProfilTabbedPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 514,
                                        Short.MAX_VALUE)
                                .addGroup(Alignment.LEADING,
                                        gl_ProfilPanel.createSequentialGroup().addComponent(ProfilLblBonjourBienvenue)
                                                .addPreferredGap(ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                                                .addComponent(btnAide))
                                .addGroup(Alignment.LEADING,
                                        gl_ProfilPanel.createSequentialGroup().addComponent(ProfilLblConnectEnTant)
                                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(
                                                        ProfilBtnDeconnexion)))
                        .addContainerGap()));
        gl_ProfilPanel.setVerticalGroup(gl_ProfilPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_ProfilPanel.createSequentialGroup()
                        .addGroup(gl_ProfilPanel.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_ProfilPanel.createSequentialGroup().addContainerGap()
                                        .addComponent(ProfilLblBonjourBienvenue))
                                .addComponent(btnAide))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_ProfilPanel.createParallelGroup(Alignment.BASELINE)
                                .addComponent(ProfilLblConnectEnTant).addComponent(ProfilBtnDeconnexion))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(ProfilTabbedPane, GroupLayout.PREFERRED_SIZE, 198, Short.MAX_VALUE)
                        .addContainerGap()));

        JPanel ProfilPanelLocation = new JPanel();
        ProfilTabbedPane.addTab("Location", null, ProfilPanelLocation, null);

        JButton ProfilBtnLouer = new JButton("Louer");
        ProfilBtnLouer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frmMonProfil.setVisible(false);
                louerController.location();
            }
        });

        JLabel ProfilLblMesLocationsCours = new JLabel("Historique de mes locations :");
        ProfilLblMesLocationsCours.setFont(new Font("Tahoma", Font.BOLD, 11));

        JScrollPane ProfilScrollPaneLocation = new JScrollPane();
        GroupLayout gl_ProfilPanelLocation = new GroupLayout(ProfilPanelLocation);
        gl_ProfilPanelLocation.setHorizontalGroup(gl_ProfilPanelLocation.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_ProfilPanelLocation.createSequentialGroup()
                        .addGroup(gl_ProfilPanelLocation.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_ProfilPanelLocation.createSequentialGroup().addContainerGap().addComponent(
                                        ProfilScrollPaneLocation, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
                                .addGroup(gl_ProfilPanelLocation.createSequentialGroup().addGap(173)
                                        .addComponent(ProfilLblMesLocationsCours))
                                .addGroup(gl_ProfilPanelLocation.createSequentialGroup().addGap(225)
                                        .addComponent(ProfilBtnLouer)))
                        .addContainerGap()));
        gl_ProfilPanelLocation.setVerticalGroup(gl_ProfilPanelLocation.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_ProfilPanelLocation.createSequentialGroup().addContainerGap()
                        .addComponent(ProfilLblMesLocationsCours).addGap(17)
                        .addComponent(ProfilScrollPaneLocation, GroupLayout.PREFERRED_SIZE, 96,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE).addComponent(ProfilBtnLouer)
                        .addGap(9)));

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
        // ProfilBtnSeDesinscrire.setBackground(new Color(204, 0, 0));

        ProfilBtnSeDesinscrire.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                profilController.supprimerCompte();
            }
        });

        GroupLayout gl_ProfilPanelInformation = new GroupLayout(ProfilPanelInformation);
        gl_ProfilPanelInformation.setHorizontalGroup(gl_ProfilPanelInformation.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_ProfilPanelInformation.createSequentialGroup().addContainerGap()
                        .addGroup(gl_ProfilPanelInformation.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_ProfilPanelInformation.createSequentialGroup()
                                        .addComponent(ProfilScrollPaneInformation, GroupLayout.DEFAULT_SIZE, 489,
                                                Short.MAX_VALUE)
                                        .addContainerGap())
                                .addGroup(Alignment.TRAILING, gl_ProfilPanelInformation.createSequentialGroup()
                                        .addComponent(ProfilBtnSeDesinscrire).addGap(202)))));
        gl_ProfilPanelInformation.setVerticalGroup(gl_ProfilPanelInformation.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_ProfilPanelInformation.createSequentialGroup().addContainerGap()
                        .addComponent(ProfilScrollPaneInformation, GroupLayout.PREFERRED_SIZE, 44,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(18).addComponent(ProfilBtnSeDesinscrire).addContainerGap(171, Short.MAX_VALUE)));

        ProfilTableInformation = new JTable();
        ProfilTableInformation.setShowHorizontalLines(false);
        ProfilTableInformation.setModel(new DefaultTableModel(
                new Object[][] {
                        { "Efema", "Dodu", "31/12/1996", new Integer(1) + " rue du Montagnais J1HQ23 Sherbrooke" }, },
                new String[] { "Nom", "Pr\u00E9nom", "Date Naissance", "Adresse" })
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
        ProfilTableInformation.getColumnModel().getColumn(3).setPreferredWidth(300);
        // ProfilTableInformation.getColumnModel().getColumn(4).setPreferredWidth(104);
        // ProfilTableInformation.getColumnModel().getColumn(5).setPreferredWidth(67);
        // ProfilTableInformation.getColumnModel().getColumn(6).setResizable(false);
        ProfilScrollPaneInformation.setViewportView(ProfilTableInformation);
        ProfilPanelInformation.setLayout(gl_ProfilPanelInformation);

        JPanel ProfilPanelInfoAbonnement = new JPanel();
        ProfilTabbedPane.addTab("Mon abonnement", null, ProfilPanelInfoAbonnement, null);

        JScrollPane ProfilScrollPaneInfoAbonnement = new JScrollPane();

        JButton ProfilButtonResilier = new JButton("Résilier");
        // ProfilButtonResilier.setBackground(new Color(255, 0, 0));

        ProfilButtonResilier.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                profilController.supprimerAbo();
                profilController.afficherAbo();
            }
        });

        JButton ProfilBtnRenouveler = new JButton("Renouveler");
        // ProfilBtnRenouveler.setBackground(new Color(51, 204, 0));

        ProfilBtnRenouveler.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                profilController.renouvelerAbo();
                profilController.afficherAbo();
            }
        });

        JButton ProfilBtnChanger = new JButton("Changer");
        // ProfilBtnChanger.setBackground(new Color(102, 204, 0));

        ProfilBtnChanger.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                profilController.modifierAbo();
                profilController.afficherAbo();
            }
        });

        GroupLayout gl_ProfilPanelInfoAbonnement = new GroupLayout(ProfilPanelInfoAbonnement);
        gl_ProfilPanelInfoAbonnement.setHorizontalGroup(gl_ProfilPanelInfoAbonnement
                .createParallelGroup(Alignment.LEADING)
                .addGroup(gl_ProfilPanelInfoAbonnement.createSequentialGroup().addContainerGap()
                        .addComponent(ProfilScrollPaneInfoAbonnement, GroupLayout.PREFERRED_SIZE, 489,
                                GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(Alignment.TRAILING, gl_ProfilPanelInfoAbonnement.createSequentialGroup()
                        .addContainerGap(65, Short.MAX_VALUE)
                        .addComponent(ProfilButtonResilier, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                        .addGap(55).addComponent(ProfilBtnChanger).addGap(49).addComponent(ProfilBtnRenouveler)
                        .addGap(81)));
        gl_ProfilPanelInfoAbonnement
                .setVerticalGroup(gl_ProfilPanelInfoAbonnement.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_ProfilPanelInfoAbonnement.createSequentialGroup().addContainerGap()
                                .addComponent(ProfilScrollPaneInfoAbonnement, GroupLayout.PREFERRED_SIZE, 44,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addGroup(gl_ProfilPanelInfoAbonnement.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(ProfilButtonResilier).addComponent(ProfilBtnRenouveler)
                                        .addComponent(ProfilBtnChanger))
                                .addContainerGap(171, Short.MAX_VALUE)));

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

    /**
     * @return the cxCarteTxtId
     */
    public JTextField getCxCarteTxtId()
    {
        return CxCarteTxtId;
    }
}
