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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
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
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(CxCarteLblScannerVotreCarte)
                            .addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                            .addComponent(btnAide, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(116)
                            .addComponent(CxCarteLblVotreId)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(CxCarteTxtId, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
                .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                    .addGap(97)
                    .addComponent(CxCarteBtnScanner, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addGap(85))
                .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                    .addContainerGap(189, Short.MAX_VALUE)
                    .addComponent(CxCarteBtnAnnuler)
                    .addGap(176))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnAide)
                        .addComponent(CxCarteLblScannerVotreCarte))
                    .addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(CxCarteLblVotreId)
                        .addComponent(CxCarteTxtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(CxCarteBtnScanner)
                    .addGap(11)
                    .addComponent(CxCarteBtnAnnuler)
                    .addGap(33))
        );
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
                try {
                if(profilController.connexion(Integer.parseInt(CxCarteTxtId.getText()))) // Ceci est l'id card quand le périphérique scanner lit la carte (on simule)
                    frmScannerVotreCarte.setVisible(false);
                }
                catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(new JFrame(), "Erreur dans l'id !", "Dialog", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                }                
                catch(Exception exception) {
                    JOptionPane.showMessageDialog(new JFrame(), exception.getMessage(), "Dialog", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
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

        JLabel ProfilLblBonjourBienvenue = new JLabel("Bonjour ! Bienvenue sur votre profil ;)");
        ProfilLblBonjourBienvenue.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel ProfilLblConnectEnTant = new JLabel("Connecté en tant que Dodu Efema");

        JButton ProfilBtnDeconnexion = new JButton("Deconnexion");
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
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(ProfilBtnDeconnexion)))
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
        ProfilBtnLouer.setBackground(new Color(51, 204, 0));

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
        ProfilBtnSeDesinscrire.setBackground(new Color(204, 0, 0));
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

        JTable ProfilTableInformation = new JTable();
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
        ProfilButtonResilier.setBackground(new Color(255, 0, 0));

        JButton ProfilBtnRenouveler = new JButton("Renouveler");
        ProfilBtnRenouveler.setBackground(new Color(51, 204, 0));

        JButton ProfilBtnChanger = new JButton("Changer");
        ProfilBtnChanger.setBackground(new Color(102, 204, 0));
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

        JTable ProfilTableInfoAbonnement = new JTable();
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
