package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * Vue principale du package. L'accès au contrôleur est établi grâce à
 * l'attribut de type AccueilView
 */
public abstract class AbstractView
{
    protected static AccueilView accueilView;
    
    private static JFrame frmAide;
    
    protected static JButton btnAide = new JButton("Aide");
    
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
        AideScrollPaneFAQ.setViewportBorder(new TitledBorder(null, "Foire Aux Questions", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        
        JScrollPane AideScrollPaneInfoAbo = new JScrollPane();
        AideScrollPaneInfoAbo.setViewportBorder(new TitledBorder(null, "Informations sur les abonnements", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        
        JScrollPane AideScrollPane = new JScrollPane();
        AideScrollPane.setViewportBorder(new TitledBorder(null, "R\u00E8gles d\u2019utilisation et de location :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        
        JPanel AidePanel = new JPanel();
        AidePanel.setBorder(new TitledBorder(null, "Contactez-nous", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        
        JButton AideBtnRetour = new JButton("Retour");
        GroupLayout groupLayout = new GroupLayout(frmAide.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(401)
                            .addComponent(AidePanel, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(310)
                            .addComponent(AideBtnRetour, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                                .addComponent(AideScrollPane, Alignment.LEADING)
                                .addComponent(AideScrollPaneFAQ, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                                .addComponent(AideScrollPaneInfoAbo, Alignment.LEADING, 0, 0, Short.MAX_VALUE))))
                    .addContainerGap())
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(AideScrollPaneInfoAbo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(AideScrollPaneFAQ, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(AideScrollPane, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(AideBtnRetour)
                    .addGap(103)
                    .addComponent(AidePanel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        JLabel label = new JLabel("Courriel : velocation.assist@velocation.fr");
        label.setFont(new Font("Dialog", Font.BOLD, 14));
        
        JLabel label_1 = new JLabel("Numéro d'assistance gratuit : +33 0 800 424 424");
        label_1.setFont(new Font("Dialog", Font.BOLD, 14));
        GroupLayout gl_AidePanel = new GroupLayout(AidePanel);
        gl_AidePanel.setHorizontalGroup(
            gl_AidePanel.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_AidePanel.createSequentialGroup()
                    .addContainerGap(169, Short.MAX_VALUE)
                    .addGroup(gl_AidePanel.createParallelGroup(Alignment.LEADING)
                        .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
                        .addGroup(Alignment.TRAILING, gl_AidePanel.createSequentialGroup()
                            .addComponent(label, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
                            .addGap(30)))
                    .addGap(157))
        );
        gl_AidePanel.setVerticalGroup(
            gl_AidePanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_AidePanel.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label)
                    .addGap(14))
        );
        AidePanel.setLayout(gl_AidePanel);
        
        JTree tree = new JTree();
        tree.setModel(new DefaultTreeModel(
            new DefaultMutableTreeNode("Règles") {
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
            }
        ));
        tree.setFont(new Font("Tahoma", Font.BOLD, 14));
        AideScrollPane.setViewportView(tree);
        
        JTextPane textPaneInfoAbo = new JTextPane();
        textPaneInfoAbo.setEditable(false);
        textPaneInfoAbo.setFont(new Font("Tahoma", Font.BOLD, 14));
        textPaneInfoAbo.setText("Tarif journalier\r\n\r\n- Sans abonnement --> Le prix hebdomadaire d'un vélo est de 20$ CAN\r\n\r\n- Abonnement --> Accès illimité pour louer un vélo d'une durée de 24 heures. \r\n\r\nNote : L'utilisateur devra rapporter son vélo avant les 24h . Dans le cas où il souhaite renouveller ou simplement rendre le vélo pour récupérer sa caution.");
        AideScrollPaneInfoAbo.setViewportView(textPaneInfoAbo);
        
        JTree AideTreeFAQ = new JTree();
        AideTreeFAQ.setFont(new Font("Tahoma", Font.BOLD, 14));
        AideTreeFAQ.setModel(new DefaultTreeModel(
            new DefaultMutableTreeNode("FAQ") {
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
                    node_1 = new DefaultMutableTreeNode("Quel est le prix d’une location à la journée (sur deux jours, etc.) ? ");
                        node_1.add(new DefaultMutableTreeNode("Reponse:"));
                    add(node_1);
                    node_1 = new DefaultMutableTreeNode("Il y a t-il différents types de vélo ? Ville, route, etc. ?");
                        node_1.add(new DefaultMutableTreeNode("Reponse:"));
                    add(node_1);
                    node_1 = new DefaultMutableTreeNode("Rangements bagages ou non ? ");
                        node_1.add(new DefaultMutableTreeNode("Reponse:"));
                    add(node_1);
                }
            }
        ));
        AideScrollPaneFAQ.setViewportView(AideTreeFAQ);
        frmAide.getContentPane().setLayout(groupLayout);
     
        // ActionListener
        
        AideBtnRetour.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                frmAide.setVisible(false);
            }            
        });
        
        btnAide.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {                
                frmAide.setVisible(true);
            }            
        });
    }
}