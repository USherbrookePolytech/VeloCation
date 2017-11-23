package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
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
        frmPaiement.setBounds(100, 100, 377, 233);
        frmPaiement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPaiement.setLocationRelativeTo(null);

        JPanel PaiementPanel = new JPanel();
        PaiementPanel.setBorder(new TitledBorder(null, "Proc\u00E9dez au paiement", TitledBorder.LEADING,
                TitledBorder.TOP, null, null));
        frmPaiement.getContentPane().add(PaiementPanel, BorderLayout.CENTER);

        JButton PaiementBtnPayerViaPaypal = new JButton("Payer via Paypal");
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

        JButton PaiementBtnAbandonner = new JButton("Annuler");
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

        JScrollPane scrollPane = new JScrollPane();

        lblPrixTotal = new JLabel("Prix total : 310$ CAN");
        lblPrixTotal.setFont(new Font("Tahoma", Font.BOLD, 14));

        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frmPaiement.setVisible(false);
                accueilView.getInscriptionView().getFrmAbonnement().setVisible(true);
            }
        });

        GroupLayout gl_PaiementPanel = new GroupLayout(PaiementPanel);
        gl_PaiementPanel
                .setHorizontalGroup(gl_PaiementPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_PaiementPanel.createSequentialGroup().addContainerGap()
                                .addGroup(gl_PaiementPanel.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(Alignment.LEADING,
                                                gl_PaiementPanel.createSequentialGroup().addComponent(
                                                        scrollPane, GroupLayout.PREFERRED_SIZE, 338,
                                                        GroupLayout.PREFERRED_SIZE).addContainerGap())
                                        .addGroup(gl_PaiementPanel.createSequentialGroup().addComponent(btnRetour)
                                                .addGap(22)
                                                .addGroup(gl_PaiementPanel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblPrixTotal).addGroup(
                                                                gl_PaiementPanel.createSequentialGroup()
                                                                        .addComponent(PaiementBtnAbandonner)
                                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                                        .addComponent(PaiementBtnPayerViaPaypal,
                                                                                GroupLayout.PREFERRED_SIZE, 138,
                                                                                GroupLayout.PREFERRED_SIZE)))
                                                .addGap(34))))
                        .addGroup(Alignment.TRAILING, gl_PaiementPanel.createSequentialGroup()
                                .addContainerGap(271, Short.MAX_VALUE).addComponent(btnAide).addGap(42)));
        gl_PaiementPanel.setVerticalGroup(gl_PaiementPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_PaiementPanel.createSequentialGroup().addComponent(btnAide).addGap(11)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblPrixTotal).addGap(15)
                        .addGroup(gl_PaiementPanel.createParallelGroup(Alignment.BASELINE).addComponent(btnRetour)
                                .addComponent(PaiementBtnAbandonner).addComponent(PaiementBtnPayerViaPaypal,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(17, Short.MAX_VALUE)));

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] { { "", "", null }, { "", "", null }, },
                new String[] { "Qte", "Libell\u00E9", "Prix uni. $CAN" })
        {
            Class[] columnTypes = new Class[] { Object.class, Object.class, Integer.class };

            public Class getColumnClass(int columnIndex)
            {
                return columnTypes[columnIndex];
            }
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(32);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(96);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        scrollPane.setViewportView(table);
        PaiementPanel.setLayout(gl_PaiementPanel);
    }

    public static void initValiderPaiement()
    {
        frmPaiementValid = new JFrame();
        frmPaiementValid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPaiementValid.setResizable(false);
        frmPaiementValid.setBounds(0, 0, 192, 120);
        frmPaiementValid.setLocationRelativeTo(null);

        JLabel lblPaiementValid = new JLabel("Paiement validé");

        JButton btnAppuyerPourContinuer = new JButton("Appuyer pour continuer");
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

        GroupLayout groupLayout = new GroupLayout(frmPaiementValid.getContentPane());
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
        frmPaiementValid.getContentPane().setLayout(groupLayout);
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
        frmValiderPaiementAbo.setBounds(100, 100, 495, 132);
        frmValiderPaiementAbo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmValiderPaiementAbo.setLocationRelativeTo(null);

        JLabel label = new JLabel("");

        lblEtesvousCertainDe = new JLabel("Êtes-vous certain de souscrire à l'abonnement XX$ CAN / mois ?");

        JButton btnModifierMonChoix = new JButton("Modifier mon choix");
        btnModifierMonChoix.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frmValiderPaiementAbo.setVisible(false);
                accueilView.getInscriptionView().getFrmAbonnement().setVisible(true);
            }
        });

        JButton btnAnnuler = new JButton("Annuler");
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

        JButton btnPayer = new JButton("Payer");
        btnPayer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frmValiderPaiementAbo.setVisible(false);
                frmPaiementValid.setVisible(true);
            }
        });

        GroupLayout groupLayout = new GroupLayout(frmValiderPaiementAbo.getContentPane());
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
                                .createSequentialGroup().addGap(121)
                                .addComponent(label))
                                .addGroup(groupLayout.createSequentialGroup().addGap(31).addGroup(groupLayout
                                        .createParallelGroup(Alignment.LEADING).addGroup(groupLayout
                                                .createSequentialGroup().addComponent(btnModifierMonChoix).addGap(66)
                                                .addComponent(btnAnnuler).addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(btnPayer))
                                        .addComponent(lblEtesvousCertainDe))))
                        .addContainerGap(51, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addGap(19).addComponent(lblEtesvousCertainDe).addGap(18)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnPayer)
                                .addComponent(btnAnnuler).addComponent(btnModifierMonChoix))
                        .addGap(34).addComponent(label).addContainerGap(154, Short.MAX_VALUE)));
        frmValiderPaiementAbo.getContentPane().setLayout(groupLayout);
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