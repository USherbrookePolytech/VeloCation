package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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

        JLabel CxTempValidationLblSaisirLeCode = new JLabel("Saisir le code reçu par SMS :");
        CxTempValidationLblSaisirLeCode.setFont(new Font("Tahoma", Font.BOLD, 14));

        JButton CxTempValidationBtn = new JButton("Aide");

        JLabel CxTempValidationLblCodeReu = new JLabel("Code (3 chiffres)");

        JTextField CxTempValidationTextFieldCode = new JTextField();
        CxTempValidationTextFieldCode.setColumns(10);

        JLabel CxTempValidationLblEx = new JLabel("(ex : 24353)");

        JButton CxTempValidationBtnValider = new JButton("Valider");

        JButton CxTempValidationBtnAnnuler = new JButton("Annuler");
        GroupLayout groupLayout = new GroupLayout(frmConnexionTempValidation.getContentPane());
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
                .createSequentialGroup().addGap(98)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup().addGap(273).addComponent(CxTempValidationBtn,
                                GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup().addGap(47)
                                .addComponent(CxTempValidationBtnAnnuler, GroupLayout.PREFERRED_SIZE, 69,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(10).addComponent(CxTempValidationBtnValider, GroupLayout.PREFERRED_SIZE, 65,
                                        GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
                .addGroup(groupLayout.createSequentialGroup().addGap(174).addComponent(CxTempValidationLblCodeReu)
                        .addContainerGap(179, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup().addGap(185)
                        .addComponent(CxTempValidationTextFieldCode, GroupLayout.PREFERRED_SIZE, 58,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(10).addComponent(CxTempValidationLblEx).addContainerGap(121, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup().addGap(118)
                        .addComponent(CxTempValidationLblSaisirLeCode, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                        .addGap(118)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
                .createSequentialGroup().addContainerGap().addComponent(CxTempValidationBtn).addGap(8)
                .addComponent(CxTempValidationLblSaisirLeCode, GroupLayout.PREFERRED_SIZE, 17,
                        GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED).addComponent(CxTempValidationLblCodeReu)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup().addGap(9).addComponent(CxTempValidationLblEx))
                        .addGroup(groupLayout.createSequentialGroup().addGap(6).addComponent(
                                CxTempValidationTextFieldCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)))
                .addGap(18)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(CxTempValidationBtnAnnuler)
                        .addComponent(CxTempValidationBtnValider))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        frmConnexionTempValidation.getContentPane().setLayout(groupLayout);

        // ActionListener

        CxTempValidationBtn.addActionListener(new ActionListener()
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
                
            }

        });

    }

    private void initConnexionTempNumero()
    {
        frmConnexionTemporaire = new JFrame();
        frmConnexionTemporaire.setTitle("Connexion temporaire");
        frmConnexionTemporaire.setBounds(100, 100, 482, 220);
        frmConnexionTemporaire.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel CxTempLblSaisirVotreNumro = new JLabel("Saisir votre numéro de téléphone :");
        CxTempLblSaisirVotreNumro.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel CxTempLblCodePays = new JLabel("Code pays");

        JLabel CxTempLblNumro = new JLabel("Numéro");

        JTextField CxTempTextFieldCode = new JTextField();
        CxTempTextFieldCode.setText("+33");
        CxTempTextFieldCode.setColumns(10);

        JTextField CxTempTextFieldNumero = new JTextField();
        CxTempTextFieldNumero.setColumns(10);

        JButton CxTempBtnAnnuler = new JButton("Annuler");
        CxTempBtnAnnuler.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
            }
        });

        JButton CxTempBtnValider = new JButton("Valider");
        CxTempBtnValider.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("AAA");
            }
        });

        JButton CxTempBtnAide = new JButton("Aide");
        CxTempBtnAide.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            }
        });

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
