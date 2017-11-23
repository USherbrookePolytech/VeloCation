package view;

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
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import controller.ConnexionTempoController;
import controller.LouerController;

/**
 * Vue qui s'occupe de l'affichage de la partie connexion temporaire
 */
public class ConnexionTempoView extends AbstractView
{
    private ConnexionTempoController connexionTempoController;
    private LouerController louerController;

    private JFrame frmConnexionTemporaire;
    private JFrame frmConnexionTempValidation;
    
    private JTextField CxTempTextFieldCode;
    private JTextField CxTempTextFieldNumero;
    private JTextField CxTempValidationTextFieldCode;

    public ConnexionTempoView(LouerController louerControllerArg)
    {
        this.connexionTempoController = new ConnexionTempoController(this);
        this.louerController = louerControllerArg;

        initConnexionTempNumero();
        initConnexionTempValidation();
    }

    private void initConnexionTempValidation()
    {
        frmConnexionTempValidation = new JFrame();
        frmConnexionTempValidation.setTitle("Vérification téléphone");
        frmConnexionTempValidation.setBounds(0, 0, 600, 500);
        frmConnexionTempValidation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmConnexionTempValidation.setLocationRelativeTo(null);
        
        JPanel CxTempValidationPanelBouton = new JPanel();
        
        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        GroupLayout groupLayout = new GroupLayout(frmConnexionTempValidation.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                        .addComponent(CxTempValidationPanelBouton, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAide, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnAide, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                    .addComponent(CxTempValidationPanelBouton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        
        JLabel CxTempValidationLblEx = new JLabel("(ex : 243)");
        CxTempValidationLblEx.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        CxTempValidationTextFieldCode = new JTextField();
        CxTempValidationTextFieldCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
        CxTempValidationTextFieldCode.setColumns(10);
        
        JLabel CxTempValidationLblCodeReu = new JLabel("Code (3 chiffres)");
        CxTempValidationLblCodeReu.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JLabel CxTempValidationLblSaisirLeCode = new JLabel("Saisir le code reçu par SMS :");
        CxTempValidationLblSaisirLeCode.setFont(new Font("Tahoma", Font.BOLD, 16));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(212)
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(CxTempValidationLblCodeReu)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addComponent(CxTempValidationTextFieldCode, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(CxTempValidationLblEx)))
                    .addContainerGap(207, Short.MAX_VALUE))
                .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
                    .addContainerGap(167, Short.MAX_VALUE)
                    .addComponent(CxTempValidationLblSaisirLeCode)
                    .addGap(163))
        );
        gl_panel.setVerticalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CxTempValidationLblSaisirLeCode)
                    .addGap(22)
                    .addComponent(CxTempValidationLblCodeReu)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(CxTempValidationTextFieldCode, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(CxTempValidationLblEx))
                    .addContainerGap(27, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);
        
        JButton CxTempValidationBtnValider = new JButton("Valider");
        CxTempValidationBtnValider.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JButton CxTempValidationBtnAnnuler = new JButton("Annuler");
        CxTempValidationBtnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GroupLayout gl_CxTempValidationPanelBouton = new GroupLayout(CxTempValidationPanelBouton);
        gl_CxTempValidationPanelBouton.setHorizontalGroup(
            gl_CxTempValidationPanelBouton.createParallelGroup(Alignment.TRAILING)
                .addGroup(Alignment.LEADING, gl_CxTempValidationPanelBouton.createSequentialGroup()
                    .addComponent(CxTempValidationBtnAnnuler, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                    .addComponent(CxTempValidationBtnValider, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
        );
        gl_CxTempValidationPanelBouton.setVerticalGroup(
            gl_CxTempValidationPanelBouton.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_CxTempValidationPanelBouton.createSequentialGroup()
                    .addGroup(gl_CxTempValidationPanelBouton.createParallelGroup(Alignment.BASELINE)
                        .addComponent(CxTempValidationBtnAnnuler, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                        .addComponent(CxTempValidationBtnValider, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(38, Short.MAX_VALUE))
        );
        CxTempValidationPanelBouton.setLayout(gl_CxTempValidationPanelBouton);
        frmConnexionTempValidation.getContentPane().setLayout(groupLayout);

        // ActionListener

        CxTempValidationBtnValider.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    Integer.parseInt(CxTempValidationTextFieldCode.getText());  
                    
                    if(CxTempValidationTextFieldCode.getText().length() != 3)
                        throw new Exception("Erreur ! Le code doit être 3 chiffres !");
                    
                    frmConnexionTempValidation.setVisible(false);
                    connexionTempoController.creerUserTemp(CxTempTextFieldCode.getText(), CxTempTextFieldNumero.getText());
                    louerController.location();
                }
                catch (NumberFormatException exception) {
                    CxTempValidationTextFieldCode.setBorder(new LineBorder(Color.RED, 2));
                    JOptionPane.showMessageDialog(new JFrame(), "Erreur dans le code !", "Dialog", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                }
                catch (Exception exception)
                {
                    CxTempValidationTextFieldCode.setBorder(new LineBorder(Color.RED, 2));
                    JOptionPane.showMessageDialog(new JFrame(), exception.getMessage(), "Dialog", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                }                
            }
        });

        CxTempValidationBtnAnnuler.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                frmConnexionTempValidation.setVisible(false);
                accueilView.getFrmAccueil().setVisible(true);                
            }
        });

    }

    private void initConnexionTempNumero()
    {
        frmConnexionTemporaire = new JFrame();
        frmConnexionTemporaire.setTitle("Connexion temporaire");
        frmConnexionTemporaire.setBounds(0, 0, 600, 500);
        frmConnexionTemporaire.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmConnexionTemporaire.setLocationRelativeTo(null);
        
        JPanel CxTempPanelBouton = new JPanel();
        
        JPanel CxTempPanelSaisie = new JPanel();
        CxTempPanelSaisie.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        GroupLayout groupLayout = new GroupLayout(frmConnexionTemporaire.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(CxTempPanelSaisie, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(500)
                            .addComponent(btnAide, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(CxTempPanelBouton, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnAide, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(CxTempPanelSaisie, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                    .addGap(98)
                    .addComponent(CxTempPanelBouton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        
        JLabel CxTempLblCodePays = new JLabel("Code pays");
        CxTempLblCodePays.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        CxTempTextFieldCode = new JTextField();
        CxTempTextFieldCode.setText("+33");
        CxTempTextFieldCode.setColumns(10);
        
        CxTempTextFieldNumero = new JTextField();
        CxTempTextFieldNumero.setColumns(10);
        
        JLabel CxTempLblNumro = new JLabel("Numéro");
        CxTempLblNumro.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JLabel CxTempLblEx = new JLabel("(ex : 0643302958)");
        CxTempLblEx.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JLabel CxTempLblSaisirVotreNumro = new JLabel("Saisir votre numéro de téléphone :");
        CxTempLblSaisirVotreNumro.setFont(new Font("Tahoma", Font.BOLD, 16));
        GroupLayout gl_CxTempPanelSaisie = new GroupLayout(CxTempPanelSaisie);
        gl_CxTempPanelSaisie.setHorizontalGroup(
            gl_CxTempPanelSaisie.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_CxTempPanelSaisie.createSequentialGroup()
                    .addContainerGap(82, Short.MAX_VALUE)
                    .addGroup(gl_CxTempPanelSaisie.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_CxTempPanelSaisie.createSequentialGroup()
                            .addComponent(CxTempTextFieldCode, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(CxTempTextFieldNumero, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                            .addGap(10)
                            .addComponent(CxTempLblEx))
                        .addGroup(gl_CxTempPanelSaisie.createSequentialGroup()
                            .addComponent(CxTempLblCodePays)
                            .addGap(74)
                            .addComponent(CxTempLblNumro)))
                    .addGap(86))
                .addGroup(Alignment.LEADING, gl_CxTempPanelSaisie.createSequentialGroup()
                    .addGap(139)
                    .addComponent(CxTempLblSaisirVotreNumro)
                    .addContainerGap(138, Short.MAX_VALUE))
        );
        gl_CxTempPanelSaisie.setVerticalGroup(
            gl_CxTempPanelSaisie.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_CxTempPanelSaisie.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CxTempLblSaisirVotreNumro)
                    .addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                    .addGroup(gl_CxTempPanelSaisie.createParallelGroup(Alignment.LEADING)
                        .addComponent(CxTempLblCodePays)
                        .addComponent(CxTempLblNumro))
                    .addGap(6)
                    .addGroup(gl_CxTempPanelSaisie.createParallelGroup(Alignment.LEADING)
                        .addComponent(CxTempTextFieldCode, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_CxTempPanelSaisie.createParallelGroup(Alignment.BASELINE)
                            .addComponent(CxTempTextFieldNumero, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addComponent(CxTempLblEx)))
                    .addContainerGap())
        );
        CxTempPanelSaisie.setLayout(gl_CxTempPanelSaisie);
        
        JButton CxTempBtnValider = new JButton("Valider");
        CxTempBtnValider.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JButton CxTempBtnAnnuler = new JButton("Annuler");
        CxTempBtnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GroupLayout gl_CxTempPanelBouton = new GroupLayout(CxTempPanelBouton);
        gl_CxTempPanelBouton.setHorizontalGroup(
            gl_CxTempPanelBouton.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_CxTempPanelBouton.createSequentialGroup()
                    .addComponent(CxTempBtnAnnuler, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                    .addComponent(CxTempBtnValider, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
        );
        gl_CxTempPanelBouton.setVerticalGroup(
            gl_CxTempPanelBouton.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_CxTempPanelBouton.createParallelGroup(Alignment.BASELINE)
                    .addComponent(CxTempBtnAnnuler, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(CxTempBtnValider, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
        );
        CxTempPanelBouton.setLayout(gl_CxTempPanelBouton);
        frmConnexionTemporaire.getContentPane().setLayout(groupLayout);
        
        // ActionListener
        
        CxTempBtnAnnuler.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frmConnexionTemporaire.setVisible(false);
                accueilView.getFrmAccueil().setVisible(true);  
            }
        });
        
        CxTempBtnValider.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    if(CxTempTextFieldCode.getText().isEmpty())
                        throw new Exception("Erreur dans le code du pays !");
                    else
                        CxTempTextFieldCode.setBorder(null);
                    
                    Integer.parseInt(CxTempTextFieldNumero.getText());
                    CxTempTextFieldNumero.setBorder(null);                    
                    
                    frmConnexionTemporaire.setVisible(false);
                    frmConnexionTempValidation.setVisible(true);
                }
                catch (NumberFormatException exception) {
                    CxTempTextFieldNumero.setBorder(new LineBorder(Color.RED, 2));
                    JOptionPane.showMessageDialog(new JFrame(), "Erreur dans le numero !", "Dialog", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                }
                catch (Exception exception)
                {
                    CxTempTextFieldCode.setBorder(new LineBorder(Color.RED, 2));
                    JOptionPane.showMessageDialog(new JFrame(), exception.getMessage(), "Dialog", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                }                    
            }
        });       
    }

    /**
     * @return the frmConnexionTemporaire
     */
    public JFrame getFrmConnexionTemporaire()
    {
        return frmConnexionTemporaire;
    }

    /**
     * @return the frmConnexionTempValidation
     */
    public JFrame getFrmConnexionTempValidation()
    {
        return frmConnexionTempValidation;
    }
}
