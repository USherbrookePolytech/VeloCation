package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
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
        
    public InscriptionView(InscriptionController inscriptionController, ProfilController profilController)
    {
        this.inscriptionController = inscriptionController;
        this.profilController = profilController;
        
        init();
    }
    
    private void init()
    {
        frmInscription = new JFrame();
        frmInscription.setResizable(false);
        frmInscription.setTitle("Inscription");
        frmInscription.setBounds(100, 100, 392, 342);
        frmInscription.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel CreationPanelVous = new JPanel();
        CreationPanelVous.setBorder(new TitledBorder(null, "Qui \u00EAtes-vous ?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        
        JPanel CreationPanelAdresse = new JPanel();
        CreationPanelAdresse.setBorder(new TitledBorder(null, "Votre adresse principale", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        
        JButton CreationBtnReinitialiser = new JButton("Réinitialiser");
        CreationBtnReinitialiser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // TODO
            }
        });
        
        JButton CreationBtnValider = new JButton("Valider");
        CreationBtnReinitialiser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // TODO
            }
        });
        
        JButton CreationBtnRetour = new JButton("Retour");
        GroupLayout groupLayout = new GroupLayout(frmInscription.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                .addComponent(CreationPanelAdresse, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                                .addComponent(CreationPanelVous, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(67)
                            .addComponent(CreationBtnRetour)
                            .addGap(18)
                            .addComponent(CreationBtnReinitialiser)
                            .addGap(18)
                            .addComponent(CreationBtnValider)))
                    .addContainerGap())
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CreationPanelVous, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(CreationPanelAdresse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(CreationBtnReinitialiser)
                        .addComponent(CreationBtnRetour)
                        .addComponent(CreationBtnValider))
                    .addContainerGap(14, Short.MAX_VALUE))
        );        
        CreationBtnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // TODO
            }
        });
        
        JLabel lblNumero = new JLabel("Numéro :");
        lblNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JTextField txtNumero = new JTextField();
        txtNumero.setColumns(10);
        
        JLabel lblVoie = new JLabel("Voie :");
        
        JTextField txtVoie = new JTextField();
        txtVoie.setColumns(10);
        
        JLabel lblExVoie = new JLabel("(ex : 1)");
        
        JLabel lblexRue = new JLabel("(ex : rue le Montagnais)");
        
        JLabel lblVille = new JLabel("Ville :");
        
        JLabel lblCodePostal = new JLabel("Code postal :");
        
        JTextField txtCodepostal = new JTextField();
        txtCodepostal.setColumns(10);
        
        JLabel lblexJhw = new JLabel("(ex : J1H2W3)");
        
        JTextField txtVille = new JTextField();
        txtVille.setToolTipText("test");
        txtVille.setColumns(10);
        
        JLabel lblexSherbrooke = new JLabel("(ex : Sherbrooke)");
        GroupLayout gl_CreationPanelAdresse = new GroupLayout(CreationPanelAdresse);
        gl_CreationPanelAdresse.setHorizontalGroup(
            gl_CreationPanelAdresse.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_CreationPanelAdresse.createSequentialGroup()
                    .addGap(57)
                    .addGroup(gl_CreationPanelAdresse.createParallelGroup(Alignment.TRAILING)
                        .addComponent(lblCodePostal)
                        .addComponent(lblVille)
                        .addComponent(lblVoie)
                        .addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_CreationPanelAdresse.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_CreationPanelAdresse.createSequentialGroup()
                            .addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(lblExVoie))
                        .addGroup(gl_CreationPanelAdresse.createSequentialGroup()
                            .addComponent(txtVoie, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(lblexRue))
                        .addGroup(gl_CreationPanelAdresse.createSequentialGroup()
                            .addComponent(txtCodepostal, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(lblexJhw))
                        .addGroup(gl_CreationPanelAdresse.createSequentialGroup()
                            .addComponent(txtVille, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(lblexSherbrooke)))
                    .addGap(26))
        );
        gl_CreationPanelAdresse.setVerticalGroup(
            gl_CreationPanelAdresse.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_CreationPanelAdresse.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_CreationPanelAdresse.createParallelGroup(Alignment.BASELINE)
                        .addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblExVoie))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_CreationPanelAdresse.createParallelGroup(Alignment.BASELINE)
                        .addComponent(txtVoie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblVoie)
                        .addComponent(lblexRue))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_CreationPanelAdresse.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblCodePostal)
                        .addComponent(txtCodepostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblexJhw))
                    .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(gl_CreationPanelAdresse.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblVille)
                        .addComponent(txtVille, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblexSherbrooke))
                    .addContainerGap())
        );
        CreationPanelAdresse.setLayout(gl_CreationPanelAdresse);
        
        JTextField txtNom = new JTextField();
        txtNom.setColumns(10);
        
        JLabel lblNom = new JLabel("Nom :");
        
        JLabel lblPrenom = new JLabel("Prenom :");
        
        JTextField txtPrenom = new JTextField();
        txtPrenom.setColumns(10);
        
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        
        JLabel lblDateDeNaissance = new JLabel("Date de naissance :");
        
        JLabel lblexDateNaissance = new JLabel("(ex : 31/12/1996)");
        GroupLayout gl_CreationPanelVous = new GroupLayout(CreationPanelVous);
        gl_CreationPanelVous.setHorizontalGroup(
            gl_CreationPanelVous.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_CreationPanelVous.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_CreationPanelVous.createParallelGroup(Alignment.TRAILING, false)
                        .addGroup(gl_CreationPanelVous.createSequentialGroup()
                            .addComponent(lblDateDeNaissance)
                            .addGap(5)
                            .addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(gl_CreationPanelVous.createSequentialGroup()
                            .addGap(52)
                            .addComponent(lblPrenom)
                            .addGap(5)
                            .addComponent(txtPrenom))
                        .addGroup(gl_CreationPanelVous.createSequentialGroup()
                            .addGap(67)
                            .addComponent(lblNom)
                            .addGap(5)
                            .addComponent(txtNom, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblexDateNaissance)
                    .addContainerGap(67, Short.MAX_VALUE))
        );
        gl_CreationPanelVous.setVerticalGroup(
            gl_CreationPanelVous.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_CreationPanelVous.createSequentialGroup()
                    .addGroup(gl_CreationPanelVous.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_CreationPanelVous.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblNom))
                        .addGroup(gl_CreationPanelVous.createSequentialGroup()
                            .addGap(1)
                            .addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(gl_CreationPanelVous.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_CreationPanelVous.createSequentialGroup()
                            .addGap(9)
                            .addComponent(lblPrenom))
                        .addGroup(gl_CreationPanelVous.createSequentialGroup()
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(txtPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(gl_CreationPanelVous.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_CreationPanelVous.createSequentialGroup()
                            .addGap(9)
                            .addComponent(lblDateDeNaissance))
                        .addGroup(gl_CreationPanelVous.createSequentialGroup()
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addGroup(gl_CreationPanelVous.createParallelGroup(Alignment.TRAILING)
                                .addComponent(lblexDateNaissance)
                                .addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CreationPanelVous.setLayout(gl_CreationPanelVous);
        frmInscription.getContentPane().setLayout(groupLayout);
    }
}
