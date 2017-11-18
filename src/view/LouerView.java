package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.LouerController;
import controller.ProfilController;

/**
 * Vue qui s'occupe de l'affichge de la partie location
 */
public class LouerView extends AbstractView
{
    private LouerController louerController;

    private JFrame frmLouer;
    private JFrame frmPaiement;

    private JButton LouerBtnValider, LouerBtnAnnuler;

    public LouerView()
    {
        this.louerController = new LouerController(this);

        initLouer();
    }

    private void initLouer()
    {
        frmLouer = new JFrame();
        frmLouer.setTitle("Louer");
        frmLouer.setBounds(100, 100, 485, 267);
        frmLouer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLouer.setLocationRelativeTo(null);

        JPanel LouerPanel = new JPanel();
        LouerPanel.setBorder(
                new TitledBorder(null, "Choisir votre location", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        frmLouer.getContentPane().add(LouerPanel, BorderLayout.NORTH);

        JLabel LouerLblNombreDeVlo = new JLabel("Nombre de vélo souhaité :");

        SpinnerModel sm = new SpinnerNumberModel(1, 1, 9, 1);
        JSpinner LouerSpinnerVelo = new JSpinner(sm);

        JLabel LouerLblVotreLocationSera = new JLabel("Votre location sera valable 24 heures");
        LouerLblVotreLocationSera.setFont(new Font("Tahoma", Font.BOLD, 14));

        JButton LouerBtnValider = new JButton("Valider");
        LouerBtnValider.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frmLouer.setVisible(false);
                accueilView.getLblEtesvousCertainDe()
                        .setText("Êtes-vous certain de réserver " + LouerSpinnerVelo.getValue()
                                + " vélos pour une caution totale de "
                                + Integer.parseInt(LouerSpinnerVelo.getValue().toString()) * 200 + " $CAN ?");
                accueilView.frmValiderPaiementAbo.setVisible(true);
            }
        });

        LouerBtnAnnuler = new JButton("");
        LouerBtnAnnuler.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (LouerBtnAnnuler.getText().equals("Annuler"))
                    accueilView.getFrmAccueil().setVisible(true);
                else
                    accueilView.getProfilView().getFrmMonProfil().setVisible(true);

                frmLouer.setVisible(false);
            }
        });

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblPourVlo = new JLabel("Pour 1 vélo");
        lblPourVlo.setFont(new Font("Tahoma", Font.BOLD, 13));
        GroupLayout gl_LouerPanel = new GroupLayout(LouerPanel);
        gl_LouerPanel.setHorizontalGroup(gl_LouerPanel.createParallelGroup(
                Alignment.TRAILING)
                .addGroup(gl_LouerPanel
                        .createSequentialGroup().addGap(
                                23)
                        .addGroup(gl_LouerPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_LouerPanel
                                .createParallelGroup(Alignment.TRAILING, false)
                                .addGroup(gl_LouerPanel.createSequentialGroup().addComponent(LouerLblVotreLocationSera)
                                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(btnAide, GroupLayout.PREFERRED_SIZE, 65,
                                                GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblPourVlo, Alignment.LEADING).addComponent(scrollPane, Alignment.LEADING,
                                        GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_LouerPanel.createSequentialGroup().addComponent(LouerLblNombreDeVlo)
                                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(LouerSpinnerVelo,
                                                GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(17, Short.MAX_VALUE))
                .addGroup(gl_LouerPanel.createSequentialGroup().addContainerGap(273, Short.MAX_VALUE)
                        .addComponent(LouerBtnAnnuler).addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(LouerBtnValider).addGap(40)));
        gl_LouerPanel.setVerticalGroup(gl_LouerPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_LouerPanel.createSequentialGroup()
                        .addGroup(gl_LouerPanel.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_LouerPanel.createSequentialGroup().addContainerGap()
                                        .addComponent(LouerLblVotreLocationSera))
                                .addComponent(btnAide))
                        .addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE).addComponent(lblPourVlo)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(
                                gl_LouerPanel.createParallelGroup(Alignment.BASELINE).addComponent(LouerLblNombreDeVlo)
                                        .addComponent(LouerSpinnerVelo, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(gl_LouerPanel.createParallelGroup(Alignment.BASELINE).addComponent(LouerBtnValider)
                                .addComponent(LouerBtnAnnuler))
                        .addContainerGap()));

        JTable table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] { { "Location", "1 heure", "5$ CAN" }, { "Caution", "", "200$ CAN" }, },
                new String[] { "Libell\u00E9", "Dur\u00E9e", "Prix" }));
        scrollPane.setViewportView(table);
        LouerPanel.setLayout(gl_LouerPanel);
    }

    /**
     * @return the frmLouer
     */
    public JFrame getFrmLouer()
    {
        return frmLouer;
    }

    /**
     * @return the frmPaiement
     */
    public JFrame getFrmPaiement()
    {
        return frmPaiement;
    }

    /**
     * @return the louerBtnValider
     */
    public JButton getLouerBtnValider()
    {
        return LouerBtnValider;
    }

    /**
     * @return the louerBtnAnnuler
     */
    public JButton getLouerBtnAnnuler()
    {
        return LouerBtnAnnuler;
    }
}