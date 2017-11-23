package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import model.Session;

/**
 * Vue principale du package. L'accès au contrôleur est établi grâce à
 * l'attribut de type AccueilView
 */
public abstract class AbstractView
{
    protected static AccueilView accueilView;

    private static JFrame frmAide;
    protected static JFrame frmPaiement;
    protected static JFrame frmPaiementValid;
    protected static JFrame frmValiderPaiementAbo;
    protected static JFrame frmPaiementValidSansCompte;
    protected static JFrame frmValiderPaiementCaution;

    protected static JButton btnAide = new JButton("Aide");

    private static JLabel lblPrixTotal, lblEtesvousCertainDe, lblEtesvousCertainDee;
    private static JTable table;

    // Initialisation de la vue d'accueil
    public static void initView()
    {
        accueilView = new AccueilView();

        initAide();
    }

    private static void initAide()
    {
        frmAide = new JFrame();
        frmAide.setResizable(false);
        frmAide.setTitle("Aide");
        frmAide.setBounds(100, 100, 718, 569);
        frmAide.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frmAide.setLocationRelativeTo(null);

        JScrollPane AideScrollPaneFAQ = new JScrollPane();
        AideScrollPaneFAQ.setViewportBorder(
                new TitledBorder(null, "Foire Aux Questions", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        JScrollPane AideScrollPaneInfoAbo = new JScrollPane();
        AideScrollPaneInfoAbo.setViewportBorder(new TitledBorder(null, "Informations sur les abonnements",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));

        JScrollPane AideScrollPane = new JScrollPane();
        AideScrollPane.setViewportBorder(new TitledBorder(null, "R\u00E8gles d\u2019utilisation et de location :",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));

        JPanel AidePanel = new JPanel();
        AidePanel.setBorder(
                new TitledBorder(null, "Contactez-nous", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        JButton AideBtnRetour = new JButton("Retour");
        GroupLayout groupLayout = new GroupLayout(frmAide.getContentPane());
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
                .createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup().addGap(401).addComponent(AidePanel,
                                GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup().addGap(310).addComponent(AideBtnRetour,
                                GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(AideScrollPane, Alignment.LEADING).addComponent(AideScrollPaneFAQ,
                                                Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                                        .addComponent(AideScrollPaneInfoAbo, Alignment.LEADING, 0, 0,
                                                Short.MAX_VALUE))))
                .addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                        .addComponent(AideScrollPaneInfoAbo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(AideScrollPaneFAQ, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(AideScrollPane, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(AideBtnRetour).addGap(103)
                        .addComponent(AidePanel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        JLabel label = new JLabel("Courriel : velocation.assist@velocation.fr");
        label.setFont(new Font("Dialog", Font.BOLD, 14));

        JLabel label_1 = new JLabel("Numéro d'assistance gratuit : +33 0 800 424 424");
        label_1.setFont(new Font("Dialog", Font.BOLD, 14));
        GroupLayout gl_AidePanel = new GroupLayout(AidePanel);
        gl_AidePanel
                .setHorizontalGroup(
                        gl_AidePanel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
                                gl_AidePanel.createSequentialGroup().addContainerGap(169, Short.MAX_VALUE)
                                        .addGroup(gl_AidePanel.createParallelGroup(Alignment.LEADING)
                                                .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 344,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGroup(Alignment.TRAILING,
                                                        gl_AidePanel.createSequentialGroup()
                                                                .addComponent(label, GroupLayout.PREFERRED_SIZE, 314,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addGap(30)))
                                        .addGap(157)));
        gl_AidePanel.setVerticalGroup(gl_AidePanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_AidePanel.createSequentialGroup().addContainerGap()
                        .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label).addGap(14)));
        AidePanel.setLayout(gl_AidePanel);

        JTree tree = new JTree();
        tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Règles")
        {
            {
                DefaultMutableTreeNode node_1;
                node_1 = new DefaultMutableTreeNode("Perte Vélo");
                node_1.add(new DefaultMutableTreeNode("Réponse:"));
                add(node_1);
                node_1 = new DefaultMutableTreeNode("Durée location ");
                node_1.add(new DefaultMutableTreeNode("Réponse:"));
                add(node_1);
                node_1 = new DefaultMutableTreeNode("Dégradation Vélo");
                node_1.add(new DefaultMutableTreeNode("Réponse:"));
                add(node_1);
                node_1 = new DefaultMutableTreeNode("Combien de vélos puis-je louer en une seule fois ? ");
                node_1.add(new DefaultMutableTreeNode("Réponse:"));
                add(node_1);
            }
        }));
        tree.setFont(new Font("Tahoma", Font.BOLD, 14));
        AideScrollPane.setViewportView(tree);

        JTextPane textPaneInfoAbo = new JTextPane();
        textPaneInfoAbo.setEditable(false);
        textPaneInfoAbo.setFont(new Font("Tahoma", Font.BOLD, 14));
        textPaneInfoAbo.setText(
                "Tarif journalier\r\n\r\n- Sans abonnement --> L'heure de location d'un vélo est de 5$ CAN\r\n\r\n- Abonnement --> Accès illimité pour louer un vélo d'une durée de 24 heures. \r\n\r\nNote : L'utilisateur devra rapporter son vélo avant les 24h . Dans le cas où il souhaite renouveller ou simplement rendre le vélo pour récupérer sa caution.");
        AideScrollPaneInfoAbo.setViewportView(textPaneInfoAbo);

        JTree AideTreeFAQ = new JTree();
        AideTreeFAQ.setFont(new Font("Tahoma", Font.BOLD, 14));
        AideTreeFAQ.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("FAQ")
        {
            {
                DefaultMutableTreeNode node_1;
                node_1 = new DefaultMutableTreeNode("Comment faire s’il n’y a plus de place pour reposer son vélo ? ");
                node_1.add(new DefaultMutableTreeNode("Reponse:"));
                add(node_1);
                node_1 = new DefaultMutableTreeNode("Comment faire si le vélo ne se décroche pas ? ");
                node_1.add(new DefaultMutableTreeNode("Reponse:"));
                add(node_1);
                node_1 = new DefaultMutableTreeNode("Que faire si le vélo libéré est abîmé ? ");
                node_1.add(new DefaultMutableTreeNode("Reponse:"));
                add(node_1);
                node_1 = new DefaultMutableTreeNode(
                        "Quel est le prix d’une location à la journée (sur deux jours, etc.) ? ");
                node_1.add(new DefaultMutableTreeNode("Reponse:"));
                add(node_1);
                node_1 = new DefaultMutableTreeNode("Il y a t-il différents types de vélo ? Ville, route, etc. ?");
                node_1.add(new DefaultMutableTreeNode("Reponse:"));
                add(node_1);
                node_1 = new DefaultMutableTreeNode("Rangements bagages ou non ? ");
                node_1.add(new DefaultMutableTreeNode("Reponse:"));
                add(node_1);
            }
        }));
        AideScrollPaneFAQ.setViewportView(AideTreeFAQ);
        frmAide.getContentPane().setLayout(groupLayout);

        // ActionListener

        AideBtnRetour.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                frmAide.setVisible(false);
            }
        });

        btnAide.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                frmAide.setVisible(true);
            }
        });
    }

    public static void initPaiement()
    {
        frmPaiement = new JFrame();
        frmPaiement.setResizable(false);
        frmPaiement.setTitle("Paiement");
        frmPaiement.setBounds(0, 0, 600, 500);
        frmPaiement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPaiement.setLocationRelativeTo(null);
        
        JPanel PaiementPanel = new JPanel();
        PaiementPanel.setBorder(new TitledBorder(null, "Proc\u00E9dez au paiement", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        frmPaiement.getContentPane().add(PaiementPanel, BorderLayout.CENTER);
        
        JScrollPane scrollPane = new JScrollPane();                
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null},
                    {null, null, null},
                },
            new String[] {
                "Qte", "Libell\u00E9", "Prix uni. $CAN"
            }
        ) {
            Class[] columnTypes = new Class[] {
                Object.class, Object.class, Integer.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(32);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(96);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        scrollPane.setViewportView(table);
        
        JPanel PaiementPanelBoutons = new JPanel();
        
        JPanel PaiementPanelMonPanier = new JPanel();
        PaiementPanelMonPanier.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        
        JLabel lblMonPanier = new JLabel("Mon Panier");
        lblMonPanier.setFont(new Font("Tahoma", Font.BOLD, 14));
        GroupLayout gl_PaiementPanel = new GroupLayout(PaiementPanel);
        gl_PaiementPanel.setHorizontalGroup(
            gl_PaiementPanel.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_PaiementPanel.createSequentialGroup()
                    .addContainerGap(192, Short.MAX_VALUE)
                    .addGroup(gl_PaiementPanel.createParallelGroup(Alignment.TRAILING)
                        .addComponent(PaiementPanelMonPanier, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                        .addGroup(Alignment.LEADING, gl_PaiementPanel.createSequentialGroup()
                            .addGap(62)
                            .addComponent(lblMonPanier)
                            .addPreferredGap(ComponentPlacement.RELATED, 72, GroupLayout.PREFERRED_SIZE)))
                    .addGap(179))
                .addGroup(Alignment.LEADING, gl_PaiementPanel.createSequentialGroup()
                    .addGap(10)
                    .addGroup(gl_PaiementPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_PaiementPanel.createSequentialGroup()
                            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(Alignment.TRAILING, gl_PaiementPanel.createSequentialGroup()
                            .addComponent(PaiementPanelBoutons, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(Alignment.TRAILING, gl_PaiementPanel.createSequentialGroup()
                            .addComponent(btnAide, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())))
        );
        gl_PaiementPanel.setVerticalGroup(
            gl_PaiementPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_PaiementPanel.createSequentialGroup()
                    .addComponent(btnAide, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addGap(29)
                    .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addGap(18)
                    .addComponent(lblMonPanier)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(PaiementPanelMonPanier, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(47)
                    .addComponent(PaiementPanelBoutons, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        
        lblPrixTotal = new JLabel("Prix total : 310$ CAN");
        PaiementPanelMonPanier.add(lblPrixTotal);
        lblPrixTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JButton PaiementBtnAbandonner = new JButton("Abandonner");
        PaiementBtnAbandonner.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        PaiementBtnAbandonner.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JButton PaiementBtnPayerViaPaypal = new JButton("Payer via Paypal");
        PaiementBtnPayerViaPaypal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GroupLayout gl_PaiementPanelBoutons = new GroupLayout(PaiementPanelBoutons);
        gl_PaiementPanelBoutons.setHorizontalGroup(
            gl_PaiementPanelBoutons.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_PaiementPanelBoutons.createSequentialGroup()
                    .addComponent(PaiementBtnAbandonner, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addGap(41)
                    .addComponent(btnRetour, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addGap(41)
                    .addComponent(PaiementBtnPayerViaPaypal, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
        );
        gl_PaiementPanelBoutons.setVerticalGroup(
            gl_PaiementPanelBoutons.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_PaiementPanelBoutons.createSequentialGroup()
                    .addGroup(gl_PaiementPanelBoutons.createParallelGroup(Alignment.TRAILING)
                        .addComponent(btnRetour, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                        .addGroup(gl_PaiementPanelBoutons.createParallelGroup(Alignment.BASELINE)
                            .addComponent(PaiementBtnAbandonner, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(PaiementBtnPayerViaPaypal, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
                    .addGap(0))
        );
        PaiementPanelBoutons.setLayout(gl_PaiementPanelBoutons);
        PaiementBtnPayerViaPaypal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        PaiementPanel.setLayout(gl_PaiementPanel);
        
        // ActionListener
        
        PaiementBtnPayerViaPaypal.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frmPaiement.setVisible(false);

                if (accueilView.getInscriptionView().getChoixAbonnement() == 1)
                    lblEtesvousCertainDe.setText("Êtes-vous certain de souscrire à l'abonnement 50$ CAN / mois ?");
                else if (accueilView.getInscriptionView().getChoixAbonnement() == 2)
                    lblEtesvousCertainDe.setText("Êtes-vous certain de souscrire à l'abonnement 130$ CAN / mois ?");
                else
                    lblEtesvousCertainDe.setText("Êtes-vous certain de souscrire à l'abonnement 540$ CAN / mois ?");

                frmValiderPaiementAbo.setVisible(true);
            }
        });

        
        
        PaiementBtnAbandonner.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frmPaiement.setVisible(false);
                accueilView.getInscriptionController().hideMessage();
                accueilView.getInscriptionController().resetValeur();
                accueilView.getInscriptionController().setEmptyBorder();
                accueilView.getFrmAccueil().setVisible(true);
            }
        });

        
        
        btnRetour.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frmPaiement.setVisible(false);
                accueilView.getInscriptionView().getFrmAbonnement().setVisible(true);
            }
        });

        PaiementPanel.setLayout(gl_PaiementPanel);
    }

    public static void initValiderPaiement()
    {
        frmPaiementValid = new JFrame();
        frmPaiementValid.setTitle("Paiement validé !");
        frmPaiementValid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPaiementValid.setResizable(false);
        frmPaiementValid.setBounds(0, 0, 600, 500);
        frmPaiementValid.setLocationRelativeTo(null);
        
        JLabel lblPaiementValid = new JLabel("Paiement validé");
        lblPaiementValid.setForeground(new Color(0, 128, 0));
        lblPaiementValid.setFont(new Font("Tahoma", Font.PLAIN, 34));
        lblPaiementValid.setIcon(new ImageIcon(AbstractView.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
        
        JButton btnAppuyerPourContinuer = new JButton("Appuyer pour continuer");
        btnAppuyerPourContinuer.setFont(new Font("Tahoma", Font.PLAIN, 18));
        GroupLayout groupLayout = new GroupLayout(frmPaiementValid.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addComponent(btnAppuyerPourContinuer, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                            .addComponent(lblPaiementValid)
                            .addGap(158))))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(115)
                    .addComponent(lblPaiementValid)
                    .addGap(87)
                    .addComponent(btnAppuyerPourContinuer, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(147, Short.MAX_VALUE))
        );
        frmPaiementValid.getContentPane().setLayout(groupLayout);
        
        btnAppuyerPourContinuer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                accueilView.getInscriptionController().validerInscription();
                accueilView.getProfilController().afficherProfil();
                accueilView.getProfilController().afficherAbo();
                frmPaiementValid.setVisible(false);
                accueilView.getProfilController().getProfilView().getFrmMonProfil().setVisible(true);
            }
        });
    }

    public static void initValiderPaiementSansCompte()
    {
        frmPaiementValidSansCompte = new JFrame();
        frmPaiementValidSansCompte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPaiementValidSansCompte.setResizable(false);
        frmPaiementValidSansCompte.setBounds(0, 0, 192, 120);
        frmPaiementValidSansCompte.setLocationRelativeTo(null);

        JLabel lblPaiementValid = new JLabel("Paiement validé");

        JButton btnAppuyerPourContinuer = new JButton("Appuyer pour continuer");
        btnAppuyerPourContinuer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frmPaiementValidSansCompte.setVisible(false);
                accueilView.getFrmAccueil().setVisible(true);
            }
        });

        GroupLayout groupLayout = new GroupLayout(frmPaiementValidSansCompte.getContentPane());
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addGroup(groupLayout.createSequentialGroup().addGap(50).addComponent(lblPaiementValid))
                                .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                                        .addComponent(btnAppuyerPourContinuer)))
                        .addContainerGap(29, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addGap(21).addComponent(lblPaiementValid).addGap(18)
                        .addComponent(btnAppuyerPourContinuer).addContainerGap(16, Short.MAX_VALUE)));
        frmPaiementValidSansCompte.getContentPane().setLayout(groupLayout);
    }

    public static void initValiderPaiementAbo()
    {
        frmValiderPaiementAbo = new JFrame();
        frmValiderPaiementAbo.setTitle("Confirmation du paiement");
        frmValiderPaiementAbo.setBounds(0, 0, 600, 500);
        frmValiderPaiementAbo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmValiderPaiementAbo.setLocationRelativeTo(null);
        
        lblEtesvousCertainDe = new JLabel("Êtes-vous certain de souscrire à l'abonnement XX$ CAN / mois ?");
        lblEtesvousCertainDe.setIcon(new ImageIcon(AbstractView.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
        lblEtesvousCertainDe.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JPanel panelBouton = new JPanel();
        GroupLayout groupLayout = new GroupLayout(frmValiderPaiementAbo.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panelBouton, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(20)
                            .addComponent(lblEtesvousCertainDe)))
                    .addContainerGap())
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(151)
                    .addComponent(lblEtesvousCertainDe)
                    .addPreferredGap(ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                    .addComponent(panelBouton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        
        JButton btnModifierMonChoix = new JButton("Modifier mon choix");
        btnModifierMonChoix.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JButton btnPayer = new JButton("Payer");
        btnPayer.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_panelBouton = new GroupLayout(panelBouton);
        gl_panelBouton.setHorizontalGroup(
            gl_panelBouton.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panelBouton.createSequentialGroup()
                    .addComponent(btnModifierMonChoix, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                    .addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(btnPayer, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelBouton.setVerticalGroup(
            gl_panelBouton.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_panelBouton.createSequentialGroup()
                    .addGroup(gl_panelBouton.createParallelGroup(Alignment.TRAILING)
                        .addComponent(btnAnnuler, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                        .addGroup(gl_panelBouton.createParallelGroup(Alignment.BASELINE)
                            .addComponent(btnModifierMonChoix, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(btnPayer, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)))
                    .addGap(20))
        );
        panelBouton.setLayout(gl_panelBouton);
        frmValiderPaiementAbo.getContentPane().setLayout(groupLayout);
        
        // ActionListener
        
        btnModifierMonChoix.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frmValiderPaiementAbo.setVisible(false);
                accueilView.getInscriptionView().getFrmAbonnement().setVisible(true);
            }
        });

        
        btnAnnuler.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                accueilView.getFrmAccueil().setVisible(true);
                accueilView.getInscriptionController().hideMessage();
                accueilView.getInscriptionController().resetValeur();
                accueilView.getInscriptionController().setEmptyBorder();
            }
        });

        
        btnPayer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frmValiderPaiementAbo.setVisible(false);
                frmPaiementValid.setVisible(true);
            }
        });
    }

    public static void initValiderPaiementCaution()
    {
        frmValiderPaiementCaution = new JFrame();
        frmValiderPaiementCaution.setTitle("Confirmation du paiement");
        frmValiderPaiementCaution.setBounds(100, 100, 495, 132);
        frmValiderPaiementCaution.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmValiderPaiementCaution.setLocationRelativeTo(null);

        JLabel label = new JLabel("");

        lblEtesvousCertainDee = new JLabel("Êtes-vous certain de souscrire à l'abonnement XX$ CAN / mois ?");

        JButton btnModifierMonChoix = new JButton("Modifier mon choix");
        btnModifierMonChoix.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frmValiderPaiementCaution.setVisible(false);
                accueilView.getLouerView().getFrmLouer().setVisible(true);
            }
        });

        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frmValiderPaiementCaution.setVisible(false);
                accueilView.getFrmAccueil().setVisible(true);
            }
        });

        JButton btnPayer = new JButton("Payer");
        btnPayer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frmValiderPaiementCaution.setVisible(false);
                frmPaiementValidSansCompte.setVisible(true);
            }
        });

        GroupLayout groupLayout = new GroupLayout(frmValiderPaiementCaution.getContentPane());
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(
                                Alignment.LEADING)
                                .addGroup(groupLayout.createSequentialGroup().addGap(121).addComponent(label))
                                .addGroup(groupLayout.createSequentialGroup().addGap(31).addGroup(groupLayout
                                        .createParallelGroup(Alignment.LEADING).addGroup(groupLayout
                                                .createSequentialGroup().addComponent(btnModifierMonChoix).addGap(66)
                                                .addComponent(btnAnnuler).addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(btnPayer))
                                        .addComponent(lblEtesvousCertainDee))))
                        .addContainerGap(51, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addGap(19).addComponent(lblEtesvousCertainDee).addGap(18)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnPayer)
                                .addComponent(btnAnnuler).addComponent(btnModifierMonChoix))
                        .addGap(34).addComponent(label).addContainerGap(154, Short.MAX_VALUE)));
        frmValiderPaiementCaution.getContentPane().setLayout(groupLayout);
    }

    /**
     * @return the lblPrixTotal
     */
    public static JLabel getLblPrixTotal()
    {
        return lblPrixTotal;
    }

    /**
     * @return the table
     */
    public static JTable getTable()
    {
        return table;
    }

    /**
     * @return the lblEtesvousCertainDe
     */
    public static JLabel getLblEtesvousCertainDe()
    {
        return lblEtesvousCertainDe;
    }

    /**
     * @return the lblEtesvousCertainDee
     */
    public static JLabel getLblEtesvousCertainDee()
    {
        return lblEtesvousCertainDee;
    }

}