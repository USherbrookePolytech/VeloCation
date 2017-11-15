package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import controller.InscriptionController;
import controller.ProfilController;

/**
 * Vue qui s'occupe de l'affichge de la partie inscription
 */
public class InscriptionView extends AbstractView
{
    private InscriptionController inscriptionController;
    private ProfilController profilController;

    private JFrame frmInscription;
    private JFrame frmAbonnement;

    private JTextField txtNom, txtPrenom, txtCourriel, txtTelephone, txtNumero, txtVille, txtCodepostal;
    private JDateChooser dateChooser;
    private JComboBox comboBoxPays;
    private JRadioButton rdbtnMr, rdbtnMlle, rdbtnMme;
    private ButtonGroup groupeRadioBtn = new ButtonGroup();
    private JLabel labelRequis1, labelRequis2, labelRequis3, labelRequis4, labelRequis5, labelRequis6, labelRequis7,
            labelRequis8, labelRequis9;

    /**
     * Constructeur de confort
     * 
     * @param profilControllerArg
     */
    public InscriptionView(ProfilController profilControllerArg)
    {
        this.inscriptionController = new InscriptionController(this);
        this.profilController = profilControllerArg;

        initInscription();
        initAbonnement();
    }

    private void initAbonnement()
    {
        frmAbonnement = new JFrame();
        frmAbonnement.setResizable(false);
        frmAbonnement.setTitle("Abonnement");
        frmAbonnement.setBounds(100, 100, 555, 429);
        frmAbonnement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel AbonnementsPanel = new JPanel();
        AbonnementsPanel.setBorder(new TitledBorder(null, "Choisissez votre abonnement", TitledBorder.LEADING,
                TitledBorder.TOP, null, null));

        JButton AbonnementsBtnAnnulerLinscription = new JButton("Annuler l'inscription");

        JButton AbonnementsBtnRetour = new JButton("Retour");
        GroupLayout groupLayout = new GroupLayout(frmAbonnement.getContentPane());
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
                .createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(AbonnementsPanel,
                                GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup().addGap(137).addComponent(AbonnementsBtnRetour)
                                .addGap(84).addComponent(AbonnementsBtnAnnulerLinscription)))
                .addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup().addContainerGap()
                        .addComponent(AbonnementsPanel, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(AbonnementsBtnRetour)
                                .addComponent(AbonnementsBtnAnnulerLinscription))
                        .addContainerGap()));

        JPanel AbonnementsPanelAbo1 = new JPanel();
        AbonnementsPanelAbo1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

        JPanel AbonnementsPanelAbo3 = new JPanel();
        AbonnementsPanelAbo3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

        JLabel AbonnementsLblDetail3Mois = new JLabel("Accès illimité aux bornes VeloCation 24h/24 pendant 3 mois");

        JLabel AbonnementsLbl3Mois = new JLabel("3 Mois -> $130 (CAN)");
        AbonnementsLbl3Mois.setFont(new Font("Stencil", Font.PLAIN, 29));

        JButton AbonnementsBtn3Mois = new JButton("Choisir 3 mois");
        GroupLayout gl_AbonnementsPanelAbo3 = new GroupLayout(AbonnementsPanelAbo3);
        gl_AbonnementsPanelAbo3
                .setHorizontalGroup(
                        gl_AbonnementsPanelAbo3.createParallelGroup(Alignment.TRAILING)
                                .addGroup(gl_AbonnementsPanelAbo3.createSequentialGroup().addContainerGap()
                                        .addGroup(gl_AbonnementsPanelAbo3.createParallelGroup(Alignment.LEADING)
                                                .addGroup(gl_AbonnementsPanelAbo3.createSequentialGroup()
                                                        .addComponent(AbonnementsLblDetail3Mois)
                                                        .addPreferredGap(ComponentPlacement.RELATED, 93,
                                                                Short.MAX_VALUE)
                                                        .addComponent(AbonnementsBtn3Mois))
                                                .addComponent(AbonnementsLbl3Mois))
                                        .addContainerGap()));
        gl_AbonnementsPanelAbo3.setVerticalGroup(gl_AbonnementsPanelAbo3.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_AbonnementsPanelAbo3.createSequentialGroup().addContainerGap()
                        .addComponent(AbonnementsLbl3Mois).addGap(11)
                        .addGroup(gl_AbonnementsPanelAbo3
                                .createParallelGroup(Alignment.BASELINE).addComponent(AbonnementsBtn3Mois,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AbonnementsLblDetail3Mois))
                        .addContainerGap()));
        AbonnementsPanelAbo3.setLayout(gl_AbonnementsPanelAbo3);

        JPanel AbonnementsPanel1An = new JPanel();
        AbonnementsPanel1An.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

        JLabel AbonnementsLblDetail1An = new JLabel("Accès illimité aux bornes VeloCation 24h/24 pendant 1 an");

        JLabel AbonnementsLbl1An = new JLabel("1 an -> $540 (CAN)");
        AbonnementsLbl1An.setFont(new Font("Stencil", Font.PLAIN, 29));

        JButton AbonnementsBtn1An = new JButton("Choisir 1 an");
        GroupLayout gl_AbonnementsPanel1An = new GroupLayout(AbonnementsPanel1An);
        gl_AbonnementsPanel1An.setHorizontalGroup(gl_AbonnementsPanel1An.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_AbonnementsPanel1An.createSequentialGroup().addContainerGap()
                        .addGroup(gl_AbonnementsPanel1An.createParallelGroup(Alignment.LEADING)
                                .addComponent(AbonnementsLbl1An)
                                .addGroup(gl_AbonnementsPanel1An.createSequentialGroup()
                                        .addComponent(AbonnementsLblDetail1An)
                                        .addPreferredGap(ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                        .addComponent(AbonnementsBtn1An, GroupLayout.PREFERRED_SIZE, 100,
                                                GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap()));
        gl_AbonnementsPanel1An.setVerticalGroup(gl_AbonnementsPanel1An.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_AbonnementsPanel1An.createSequentialGroup().addContainerGap()
                        .addComponent(AbonnementsLbl1An).addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(gl_AbonnementsPanel1An.createParallelGroup(Alignment.BASELINE)
                                .addComponent(AbonnementsLblDetail1An).addComponent(AbonnementsBtn1An,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap()));
        AbonnementsPanel1An.setLayout(gl_AbonnementsPanel1An);

        JButton AbonnementsBtnAide = new JButton("Aide");
        GroupLayout gl_AbonnementsPanel = new GroupLayout(AbonnementsPanel);
        gl_AbonnementsPanel.setHorizontalGroup(gl_AbonnementsPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_AbonnementsPanel.createSequentialGroup().addContainerGap()
                        .addGroup(gl_AbonnementsPanel.createParallelGroup(Alignment.LEADING)
                                .addComponent(AbonnementsPanel1An, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                                .addComponent(AbonnementsPanelAbo3, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                                .addComponent(AbonnementsPanelAbo1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AbonnementsBtnAide, Alignment.TRAILING))
                        .addContainerGap()));
        gl_AbonnementsPanel.setVerticalGroup(gl_AbonnementsPanel.createParallelGroup(Alignment.LEADING).addGroup(
                Alignment.TRAILING,
                gl_AbonnementsPanel.createSequentialGroup().addComponent(AbonnementsBtnAide)
                        .addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(AbonnementsPanelAbo1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(AbonnementsPanelAbo3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(AbonnementsPanel1An, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));

        JLabel AbonnementsLbl1Mois = new JLabel("1 Mois -> $50 (CAN)");
        AbonnementsLbl1Mois.setFont(new Font("Stencil", Font.PLAIN, 29));

        JButton AbonnementsBtn1Mois = new JButton("Choisir 1 mois");
        AbonnementsBtn1Mois.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
            }
        });

        JLabel AbonnementsLblDetail1Mois = new JLabel("Accès illimité aux bornes VeloCation 24h/24 pendant 1 mois");
        GroupLayout gl_AbonnementsPanelAbo1 = new GroupLayout(AbonnementsPanelAbo1);
        gl_AbonnementsPanelAbo1.setHorizontalGroup(gl_AbonnementsPanelAbo1.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_AbonnementsPanelAbo1.createSequentialGroup().addContainerGap()
                        .addGroup(gl_AbonnementsPanelAbo1.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_AbonnementsPanelAbo1.createSequentialGroup()
                                        .addComponent(AbonnementsLblDetail1Mois)
                                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(AbonnementsBtn1Mois))
                                .addComponent(AbonnementsLbl1Mois))
                        .addContainerGap()));
        gl_AbonnementsPanelAbo1.setVerticalGroup(gl_AbonnementsPanelAbo1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_AbonnementsPanelAbo1.createSequentialGroup().addContainerGap()
                        .addComponent(AbonnementsLbl1Mois).addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(gl_AbonnementsPanelAbo1.createParallelGroup(Alignment.BASELINE)
                                .addComponent(AbonnementsLblDetail1Mois).addComponent(AbonnementsBtn1Mois,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap()));
        AbonnementsPanelAbo1.setLayout(gl_AbonnementsPanelAbo1);
        AbonnementsPanel.setLayout(gl_AbonnementsPanel);
        frmAbonnement.getContentPane().setLayout(groupLayout);
    }

    private void initInscription()
    {
        frmInscription = new JFrame();
        frmInscription.setResizable(false);
        frmInscription.setTitle("Inscription");
        frmInscription.setBounds(100, 100, 450, 504);
        frmInscription.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel CreationPanelVous = new JPanel();
        CreationPanelVous.setBorder(
                new TitledBorder(null, "Qui \u00EAtes-vous ?", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        JPanel CreationPanelAdresse = new JPanel();
        CreationPanelAdresse.setBorder(
                new TitledBorder(null, "Votre adresse principale", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        JButton CreationBtnReinitialiser = new JButton("Réinitialiser");
        CreationBtnReinitialiser.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
            }
        });

        JButton CreationBtnValider = new JButton("Valider");
        CreationBtnValider.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                inscriptionController.verifierInscription();
            }
        });

        JButton CreationBtnRetour = new JButton("Retour");
        CreationBtnRetour.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                frmInscription.setVisible(false);
                accueilView.getFrmAccueil().setVisible(true);
            }
        });

        JLabel lblChampObligatoire = new JLabel("<html><font color='red'>* Champs obligatoires</font></html>");
        GroupLayout groupLayout = new GroupLayout(frmInscription.getContentPane());
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
                .createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup().addGap(88).addComponent(CreationBtnRetour)
                                .addGap(18).addComponent(CreationBtnReinitialiser).addGap(18)
                                .addComponent(CreationBtnValider))
                        .addGroup(
                                groupLayout.createSequentialGroup().addContainerGap().addComponent(lblChampObligatoire))
                        .addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(CreationPanelVous,
                                GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(
                                CreationPanelAdresse, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup().addGap(16)
                        .addComponent(CreationPanelVous, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(CreationPanelAdresse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(lblChampObligatoire).addGap(18)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(CreationBtnReinitialiser).addComponent(CreationBtnValider).addComponent(
                                        CreationBtnRetour))
                        .addGap(15)));

        JLabel lblNumero = new JLabel("<html>Adresse <font color='red'>*</font></html>");
        lblNumero.setHorizontalAlignment(SwingConstants.RIGHT);

        txtNumero = new JTextField();
        txtNumero.setColumns(10);

        JLabel lblCodePostal = new JLabel("<html>Code postal <font color='red'>*</font></html>");
        lblCodePostal.setHorizontalAlignment(SwingConstants.RIGHT);

        txtCodepostal = new JTextField();
        txtCodepostal.setColumns(10);

        txtVille = new JTextField();
        txtVille.setToolTipText("test");
        txtVille.setColumns(10);

        JLabel lblVille = new JLabel("<html>Ville <font color='red'>*</font></html>");
        lblVille.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel lblPays = new JLabel("<html>Pays <font color='red'>*</font></html>");
        lblPays.setHorizontalAlignment(SwingConstants.RIGHT);

        comboBoxPays = new JComboBox();

        labelRequis1 = new JLabel("");
        labelRequis1.setForeground(Color.RED);
        labelRequis1.setFont(new Font("Tahoma", Font.PLAIN, 10));

        labelRequis2 = new JLabel("");
        labelRequis2.setForeground(Color.RED);
        labelRequis2.setFont(new Font("Tahoma", Font.PLAIN, 10));

        labelRequis3 = new JLabel("");
        labelRequis3.setForeground(Color.RED);
        labelRequis3.setFont(new Font("Tahoma", Font.PLAIN, 10));

        labelRequis4 = new JLabel("");
        labelRequis4.setForeground(Color.RED);
        labelRequis4.setFont(new Font("Tahoma", Font.PLAIN, 10));
        GroupLayout gl_CreationPanelAdresse = new GroupLayout(CreationPanelAdresse);
        gl_CreationPanelAdresse.setHorizontalGroup(
                gl_CreationPanelAdresse.createParallelGroup(Alignment.LEADING).addGroup(gl_CreationPanelAdresse
                        .createSequentialGroup().addGroup(gl_CreationPanelAdresse
                                .createParallelGroup(Alignment.LEADING).addGroup(gl_CreationPanelAdresse
                                        .createSequentialGroup().addContainerGap()
                                        .addGroup(gl_CreationPanelAdresse.createParallelGroup(Alignment.TRAILING)
                                                .addComponent(lblPays).addComponent(lblVille, GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(gl_CreationPanelAdresse.createSequentialGroup().addContainerGap()
                                        .addGroup(gl_CreationPanelAdresse.createParallelGroup(Alignment.TRAILING)
                                                .addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 61,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblCodePostal, GroupLayout.PREFERRED_SIZE, 75,
                                                        GroupLayout.PREFERRED_SIZE))))
                        .addGap(18)
                        .addGroup(gl_CreationPanelAdresse.createParallelGroup(Alignment.LEADING, false)
                                .addComponent(txtNumero, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                .addComponent(txtCodepostal, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBoxPays, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtVille, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_CreationPanelAdresse.createParallelGroup(Alignment.LEADING)
                                .addComponent(labelRequis1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelRequis2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelRequis3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelRequis4, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        gl_CreationPanelAdresse.setVerticalGroup(gl_CreationPanelAdresse.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_CreationPanelAdresse.createSequentialGroup().addContainerGap()
                        .addGroup(gl_CreationPanelAdresse.createParallelGroup(Alignment.BASELINE)
                                .addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelRequis1)
                                .addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(gl_CreationPanelAdresse.createParallelGroup(Alignment.BASELINE)
                                .addComponent(txtCodepostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelRequis2).addComponent(lblCodePostal))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(gl_CreationPanelAdresse.createParallelGroup(Alignment.BASELINE)
                                .addComponent(txtVille, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelRequis3).addComponent(lblVille))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(gl_CreationPanelAdresse.createParallelGroup(Alignment.BASELINE)
                                .addComponent(comboBoxPays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelRequis4).addComponent(lblPays))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        CreationPanelAdresse.setLayout(gl_CreationPanelAdresse);

        txtNom = new JTextField();
        txtNom.setColumns(10);

        JLabel lblPrenom = new JLabel("<html>Prenom <font color='red'>*</font></html>");
        lblPrenom.setHorizontalAlignment(SwingConstants.RIGHT);

        txtPrenom = new JTextField();
        txtPrenom.setColumns(10);

        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");

        JLabel lblDateDeNaissance = new JLabel("<html>Date de naissance <font color='red'>*</font></html>");
        lblDateDeNaissance.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel lblTelephone = new JLabel("<html>Téléphone <font color='red'>*</font></html>");
        lblTelephone.setHorizontalAlignment(SwingConstants.RIGHT);

        txtTelephone = new JTextField();
        txtTelephone.setColumns(10);

        JLabel lblCourriel = new JLabel("Courriel   ");
        lblCourriel.setHorizontalAlignment(SwingConstants.RIGHT);

        txtCourriel = new JTextField();
        txtCourriel.setForeground(Color.BLACK);
        txtCourriel.setColumns(10);

        JLabel lblNom = new JLabel("<html> Nom <font color='red'>*</font></html>");
        lblNom.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel lblCivilite = new JLabel("<html> Civilité <font color='red'>*</font></html>");
        lblCivilite.setHorizontalAlignment(SwingConstants.RIGHT);

        rdbtnMr = new JRadioButton("M.");
        rdbtnMr.setToolTipText("");

        rdbtnMme = new JRadioButton("Mme");

        rdbtnMlle = new JRadioButton("Mlle");

        groupeRadioBtn.add(rdbtnMr);
        groupeRadioBtn.add(rdbtnMlle);
        groupeRadioBtn.add(rdbtnMme);

        labelRequis5 = new JLabel("");
        labelRequis5.setForeground(Color.RED);
        labelRequis5.setFont(new Font("Tahoma", Font.PLAIN, 10));

        labelRequis6 = new JLabel("");
        labelRequis6.setForeground(Color.RED);
        labelRequis6.setFont(new Font("Tahoma", Font.PLAIN, 10));

        labelRequis7 = new JLabel("");
        labelRequis7.setForeground(Color.RED);
        labelRequis7.setFont(new Font("Tahoma", Font.PLAIN, 10));

        labelRequis8 = new JLabel("");
        labelRequis8.setForeground(Color.RED);
        labelRequis8.setFont(new Font("Tahoma", Font.PLAIN, 10));

        labelRequis9 = new JLabel("");
        labelRequis9.setForeground(Color.RED);
        labelRequis9.setFont(new Font("Tahoma", Font.PLAIN, 10));
        GroupLayout gl_CreationPanelVous = new GroupLayout(CreationPanelVous);
        gl_CreationPanelVous
                .setHorizontalGroup(
                        gl_CreationPanelVous
                                .createParallelGroup(
                                        Alignment.TRAILING)
                                .addGroup(gl_CreationPanelVous.createSequentialGroup().addContainerGap()
                                        .addGroup(gl_CreationPanelVous.createParallelGroup(Alignment.TRAILING).addGroup(
                                                gl_CreationPanelVous.createSequentialGroup().addGroup(
                                                        gl_CreationPanelVous
                                                                .createParallelGroup(Alignment.TRAILING).addGroup(
                                                                        gl_CreationPanelVous
                                                                                .createSequentialGroup()
                                                                                .addGroup(gl_CreationPanelVous
                                                                                        .createParallelGroup(
                                                                                                Alignment.LEADING)
                                                                                        .addComponent(lblCivilite)
                                                                                        .addComponent(
                                                                                                lblDateDeNaissance,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                121,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(
                                                                                        ComponentPlacement.RELATED))
                                                                .addComponent(lblTelephone, GroupLayout.DEFAULT_SIZE,
                                                                        121, Short.MAX_VALUE)
                                                                .addComponent(lblPrenom, GroupLayout.DEFAULT_SIZE, 121,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 72,
                                                                        GroupLayout.PREFERRED_SIZE))
                                                        .addGap(20))
                                                .addGroup(gl_CreationPanelVous.createSequentialGroup()
                                                        .addComponent(lblCourriel).addGap(18)))
                                        .addGroup(gl_CreationPanelVous.createParallelGroup(Alignment.LEADING)
                                                .addGroup(gl_CreationPanelVous.createSequentialGroup()
                                                        .addComponent(rdbtnMr)
                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                        .addComponent(rdbtnMme)
                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                        .addComponent(rdbtnMlle)
                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                        .addComponent(labelRequis9, GroupLayout.PREFERRED_SIZE, 90,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addContainerGap())
                                                .addGroup(Alignment.TRAILING, gl_CreationPanelVous
                                                        .createSequentialGroup()
                                                        .addGroup(gl_CreationPanelVous
                                                                .createParallelGroup(Alignment.TRAILING)
                                                                .addComponent(txtCourriel, Alignment.LEADING,
                                                                        GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                                                .addGroup(gl_CreationPanelVous.createSequentialGroup()
                                                                        .addGroup(gl_CreationPanelVous
                                                                                .createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(txtTelephone,
                                                                                        GroupLayout.DEFAULT_SIZE, 120,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(dateChooser,
                                                                                        GroupLayout.DEFAULT_SIZE, 120,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(txtPrenom,
                                                                                        GroupLayout.DEFAULT_SIZE, 120,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(txtNom,
                                                                                        Alignment.TRAILING,
                                                                                        GroupLayout.PREFERRED_SIZE, 120,
                                                                                        GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                        .addGroup(gl_CreationPanelVous
                                                                                .createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(labelRequis5)
                                                                                .addComponent(labelRequis6,
                                                                                        GroupLayout.PREFERRED_SIZE, 97,
                                                                                        GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(labelRequis7,
                                                                                        GroupLayout.PREFERRED_SIZE, 97,
                                                                                        GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(labelRequis8,
                                                                                        GroupLayout.PREFERRED_SIZE, 97,
                                                                                        GroupLayout.PREFERRED_SIZE))))
                                                        .addGap(24)))));
        gl_CreationPanelVous.setVerticalGroup(gl_CreationPanelVous.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_CreationPanelVous.createSequentialGroup().addGap(9)
                        .addGroup(gl_CreationPanelVous.createParallelGroup(Alignment.BASELINE).addComponent(lblCivilite)
                                .addComponent(rdbtnMr).addComponent(rdbtnMme).addComponent(rdbtnMlle)
                                .addComponent(labelRequis9, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_CreationPanelVous.createParallelGroup(Alignment.BASELINE)
                                .addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelRequis5).addComponent(lblNom))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_CreationPanelVous.createParallelGroup(Alignment.BASELINE)
                                .addComponent(txtPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelRequis6).addComponent(lblPrenom))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_CreationPanelVous.createParallelGroup(Alignment.BASELINE)
                                .addComponent(txtTelephone, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelRequis7).addComponent(lblTelephone))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_CreationPanelVous.createParallelGroup(Alignment.TRAILING)
                                .addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelRequis8).addComponent(lblDateDeNaissance))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(
                                gl_CreationPanelVous.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(txtCourriel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblCourriel))
                        .addContainerGap()));
        CreationPanelVous.setLayout(gl_CreationPanelVous);
        frmInscription.getContentPane().setLayout(groupLayout);
    }

    /**
     * @return the frmInscription
     */
    public JFrame getFrmInscription()
    {
        return frmInscription;
    }

    /**
     * @return the frmAbonnement
     */
    public JFrame getFrmAbonnement()
    {
        return frmAbonnement;
    }

    /**
     * @return the txtNom
     */
    public JTextField getTxtNom()
    {
        return txtNom;
    }

    /**
     * @return the txtPrenom
     */
    public JTextField getTxtPrenom()
    {
        return txtPrenom;
    }

    /**
     * @return the txtCourriel
     */
    public JTextField getTxtCourriel()
    {
        return txtCourriel;
    }

    /**
     * @return the txtTelephone
     */
    public JTextField getTxtTelephone()
    {
        return txtTelephone;
    }

    /**
     * @return the txtVille
     */
    public JTextField getTxtVille()
    {
        return txtVille;
    }

    /**
     * @return the txtCodepostal
     */
    public JTextField getTxtCodepostal()
    {
        return txtCodepostal;
    }

    /**
     * @return the txtNumero
     */
    public JTextField getTxtNumero()
    {
        return txtNumero;
    }

    /**
     * @return the dateChooser
     */
    public JDateChooser getDateChooser()
    {
        return dateChooser;
    }

    /**
     * @return the comboBoxPays
     */
    public JComboBox getComboBoxPays()
    {
        return comboBoxPays;
    }

    /**
     * @return the groupeRadioBtn
     */
    public ButtonGroup getGroupeRadioBtn()
    {
        return groupeRadioBtn;
    }

    /**
     * @return the labelRequis1
     */
    public JLabel getLabelRequis1()
    {
        return labelRequis1;
    }

    /**
     * @return the labelRequis2
     */
    public JLabel getLabelRequis2()
    {
        return labelRequis2;
    }

    /**
     * @return the labelRequis3
     */
    public JLabel getLabelRequis3()
    {
        return labelRequis3;
    }

    /**
     * @return the labelRequis4
     */
    public JLabel getLabelRequis4()
    {
        return labelRequis4;
    }

    /**
     * @return the labelRequis5
     */
    public JLabel getLabelRequis5()
    {
        return labelRequis5;
    }

    /**
     * @return the labelRequis6
     */
    public JLabel getLabelRequis6()
    {
        return labelRequis6;
    }

    /**
     * @return the labelRequis7
     */
    public JLabel getLabelRequis7()
    {
        return labelRequis7;
    }

    /**
     * @return the labelRequis8
     */
    public JLabel getLabelRequis8()
    {
        return labelRequis8;
    }

    /**
     * @return the labelRequis9
     */
    public JLabel getLabelRequis9()
    {
        return labelRequis9;
    }

}