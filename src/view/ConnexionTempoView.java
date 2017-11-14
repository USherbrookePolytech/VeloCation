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
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
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
        frmConnexionTempValidation.setBounds(100, 100, 450, 194);
        frmConnexionTempValidation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmConnexionTempValidation.setLocationRelativeTo(null);
        
        JLabel CxTempValidationLblSaisirLeCode = new JLabel("Saisir le code reçu par SMS :");
        CxTempValidationLblSaisirLeCode.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JButton CxTempValidationBtnAide = new JButton("Aide");
        CxTempValidationBtnAide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        JLabel CxTempValidationLblCodeReu = new JLabel("Code (3 chiffres)");
        
        CxTempValidationTextFieldCode = new JTextField();
        CxTempValidationTextFieldCode.setColumns(10);
        
        JLabel CxTempValidationLblEx = new JLabel("(ex : 243)");
        
        JButton CxTempValidationBtnValider = new JButton("Valider");
        
        JButton CxTempValidationBtnAnnuler = new JButton("Annuler");
        GroupLayout groupLayout = new GroupLayout(frmConnexionTempValidation.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(174)
                    .addComponent(CxTempValidationLblCodeReu)
                    .addContainerGap(179, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(185)
                    .addComponent(CxTempValidationTextFieldCode, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                    .addGap(10)
                    .addComponent(CxTempValidationLblEx)
                    .addContainerGap(121, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap(344, Short.MAX_VALUE)
                    .addComponent(CxTempValidationBtnAide, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
                .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                    .addGap(118)
                    .addComponent(CxTempValidationLblSaisirLeCode, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addGap(118))
                .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                    .addGap(139)
                    .addComponent(CxTempValidationBtnAnnuler, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(CxTempValidationBtnValider, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(155, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CxTempValidationBtnAide)
                    .addGap(8)
                    .addComponent(CxTempValidationLblSaisirLeCode, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(CxTempValidationLblCodeReu)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(9)
                            .addComponent(CxTempValidationLblEx))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(6)
                            .addComponent(CxTempValidationTextFieldCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(9)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(CxTempValidationBtnAnnuler)
                        .addComponent(CxTempValidationBtnValider))
                    .addContainerGap(18, Short.MAX_VALUE))
        );
        frmConnexionTempValidation.getContentPane().setLayout(groupLayout);

        // ActionListener

        CxTempValidationBtnAide.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

            }
        });

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
        frmConnexionTemporaire.setBounds(100, 100, 482, 220);
        frmConnexionTemporaire.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmConnexionTemporaire.setLocationRelativeTo(null);
        
        JLabel CxTempLblSaisirVotreNumro = new JLabel("Saisir votre numéro de téléphone :");
        CxTempLblSaisirVotreNumro.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel CxTempLblCodePays = new JLabel("Code pays");

        JLabel CxTempLblNumro = new JLabel("Numéro");

        CxTempTextFieldCode = new JTextField();
        CxTempTextFieldCode.setText("+33");
        CxTempTextFieldCode.setColumns(10);

        CxTempTextFieldNumero = new JTextField();
        CxTempTextFieldNumero.setColumns(10);

        JButton CxTempBtnAnnuler = new JButton("Annuler");

        JButton CxTempBtnValider = new JButton("Valider");                

        JButton CxTempBtnAide = new JButton("Aide");

        JLabel CxTempLblEx = new JLabel("(ex : 0643302958)");
        GroupLayout groupLayout = new GroupLayout(frmConnexionTemporaire.getContentPane());
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
                .createSequentialGroup().addGap(98)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(CxTempLblSaisirVotreNumro)
                        .addGroup(groupLayout.createSequentialGroup().addGap(6)
                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(CxTempTextFieldCode, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                        .addComponent(CxTempLblCodePays, Alignment.LEADING))
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup().addGap(18)
                                                .addComponent(CxTempTextFieldNumero, GroupLayout.PREFERRED_SIZE, 157,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(CxTempLblEx))
                                        .addGroup(groupLayout.createSequentialGroup().addGap(74)
                                                .addComponent(CxTempLblNumro))))
                        .addGroup(groupLayout.createSequentialGroup().addGap(47).addComponent(CxTempBtnAnnuler)
                                .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(CxTempBtnValider)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup().addContainerGap(403, Short.MAX_VALUE)
                        .addComponent(CxTempBtnAide, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(CxTempBtnAide).addGap(8)
                        .addComponent(CxTempLblSaisirVotreNumro).addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(CxTempLblCodePays)
                                .addComponent(CxTempLblNumro))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(CxTempTextFieldCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(CxTempTextFieldNumero, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(CxTempLblEx))
                        .addGap(18)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(CxTempBtnAnnuler)
                                .addComponent(CxTempBtnValider))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
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
        
        CxTempBtnAide.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
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
