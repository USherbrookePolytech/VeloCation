package view;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import model.Session;

/**
 * Vue principale du package. L'accès au contrôleur est établi grâce à
 * l'attribut de type AccueilView
 */
public abstract class AbstractView
{
    protected static AccueilView accueilView;
    
    private static JFrame frmContacter;
    
    // Initialisation de la vue d'accueil
    public static void initView()
    {
        accueilView = new AccueilView();
        
        initContacter();
    }
    
    private static void initContacter()
    {
        frmContacter = new JFrame();
        frmContacter.setTitle("Contacter");
        frmContacter.setBounds(100, 100, 450, 151);
        frmContacter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel ContacterPanel = new JPanel();
        ContacterPanel.setBorder(new TitledBorder(null, "Coordonn\u00E9es de l'assistance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        
        JButton ContacterBtnRetour = new JButton("Retour");
        GroupLayout groupLayout = new GroupLayout(frmContacter.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(ContacterPanel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(185)
                            .addComponent(ContacterBtnRetour)))
                    .addContainerGap())
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ContacterPanel, GroupLayout.PREFERRED_SIZE, 60, Short.MAX_VALUE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(ContacterBtnRetour)
                    .addContainerGap())
        );
        
        JLabel ContacterLblNumero = new JLabel("Numéro d'assistance gratuit : +33 0 800 424 424");
        ContacterLblNumero.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JLabel ContacterLblCourrielVelocationassistvelocationfr = new JLabel("Courriel : velocation.assist@velocation.fr");
        ContacterLblCourrielVelocationassistvelocationfr.setFont(new Font("Tahoma", Font.BOLD, 11));
        GroupLayout gl_ContacterPanel = new GroupLayout(ContacterPanel);
        gl_ContacterPanel.setHorizontalGroup(
            gl_ContacterPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_ContacterPanel.createSequentialGroup()
                    .addGap(48)
                    .addGroup(gl_ContacterPanel.createParallelGroup(Alignment.LEADING)
                        .addComponent(ContacterLblCourrielVelocationassistvelocationfr)
                        .addComponent(ContacterLblNumero))
                    .addGap(49))
        );
        gl_ContacterPanel.setVerticalGroup(
            gl_ContacterPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_ContacterPanel.createSequentialGroup()
                    .addGap(5)
                    .addComponent(ContacterLblNumero)
                    .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ContacterLblCourrielVelocationassistvelocationfr))
        );
        ContacterPanel.setLayout(gl_ContacterPanel);
        frmContacter.getContentPane().setLayout(groupLayout);
    }
}