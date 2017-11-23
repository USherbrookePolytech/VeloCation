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
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.LouerController;

/**
 * Vue qui s'occupe de l'affichge de la partie location
 */
public class LouerView extends AbstractView
{
    private LouerController louerController;
    private JFrame frmLouer;
    private JButton LouerBtnValider, LouerBtnAnnuler;

    public LouerView()
    {
        this.louerController = new LouerController(this);

        initLouer();
        initValiderPaiementCaution();
        initValiderPaiementSansCompte();
    }

    private void initLouer()
    {
        frmLouer = new JFrame();
        frmLouer.setTitle("Louer");
        frmLouer.setBounds(0, 0, 600, 500);
        frmLouer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLouer.setLocationRelativeTo(null);

        JPanel LouerPanel = new JPanel();
        LouerPanel.setBorder(
                new TitledBorder(null, "Choisir votre location", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        frmLouer.getContentPane().add(LouerPanel, BorderLayout.CENTER);

        JButton LouerBtnAide = new JButton("Aide");

        SpinnerModel sm = new SpinnerNumberModel(1, 1, 9, 1);
        JSpinner LouerSpinnerVelo = new JSpinner(sm);
        LouerSpinnerVelo.setFont(new Font("Tahoma", Font.BOLD, 24));

        LouerBtnValider = new JButton("Valider");
        LouerBtnValider.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frmLouer.setVisible(false);
                accueilView.getLblEtesvousCertainDee()
                        .setText("<html>Êtes-vous certain de réserver " + LouerSpinnerVelo.getValue()
                                + " vélos pour une <br>caution totale de "
                                + Integer.parseInt(LouerSpinnerVelo.getValue().toString()) * 200 + " $CAN ?</html>");
                accueilView.frmValiderPaiementCaution.setVisible(true);
            }
        });
        LouerBtnValider.setFont(new Font("Tahoma", Font.PLAIN, 16));

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
        LouerBtnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        GroupLayout gl_LouerPanel = new GroupLayout(LouerPanel);
        gl_LouerPanel.setHorizontalGroup(gl_LouerPanel.createParallelGroup(Alignment.TRAILING).addGroup(gl_LouerPanel
                .createSequentialGroup()
                .addGroup(gl_LouerPanel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
                        gl_LouerPanel.createSequentialGroup().addContainerGap(486, Short.MAX_VALUE)
                                .addComponent(LouerBtnAide, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                        .addGroup(Alignment.LEADING, gl_LouerPanel.createSequentialGroup().addContainerGap()
                                .addGroup(gl_LouerPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(Alignment.TRAILING, gl_LouerPanel.createSequentialGroup()
                                                .addComponent(LouerBtnAnnuler, GroupLayout.PREFERRED_SIZE, 225,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                                                .addComponent(LouerBtnValider, GroupLayout.PREFERRED_SIZE, 225,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED))
                                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 552, Short.MAX_VALUE))))
                .addGap(18)));
        gl_LouerPanel.setVerticalGroup(gl_LouerPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_LouerPanel
                .createSequentialGroup()
                .addComponent(LouerBtnAide, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addGap(10)
                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(gl_LouerPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(LouerBtnValider, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                        .addComponent(LouerBtnAnnuler, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addContainerGap()));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup().addContainerGap()
                        .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                .addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                                .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                        .addContainerGap()));
        gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup().addContainerGap()
                        .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        JLabel LouerLblNombreDeVlo = new JLabel("Nombre de vélo souhaité :");
        LouerLblNombreDeVlo.setFont(new Font("Tahoma", Font.PLAIN, 20));

        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_2.createSequentialGroup().addGap(65).addComponent(LouerLblNombreDeVlo).addGap(32)
                        .addComponent(LouerSpinnerVelo, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(130, Short.MAX_VALUE)));
        gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_2.createSequentialGroup().addGap(31).addComponent(LouerLblNombreDeVlo)
                        .addContainerGap(19, Short.MAX_VALUE))
                .addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup().addContainerGap(21, Short.MAX_VALUE)
                        .addComponent(LouerSpinnerVelo, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                        .addGap(20)));
        panel_2.setLayout(gl_panel_2);

        JLabel lblPourVlo = new JLabel("Pour 1 vélo");
        lblPourVlo.setFont(new Font("Tahoma", Font.BOLD, 16));

        JScrollPane scrollPane = new JScrollPane();

        JTable table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
        table.setModel(new DefaultTableModel(
                new Object[][] { { "Location", "1 heure", "5$ CAN" }, { "Caution", "", "200$ CAN" }, },
                new String[] { "Libell\u00E9", "Dur\u00E9e", "Prix" }));
        scrollPane.setViewportView(table);

        JLabel LouerLblVotreLocationSera = new JLabel("Votre location sera valable 24 heures");
        LouerLblVotreLocationSera.setFont(new Font("Tahoma", Font.BOLD, 18));
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup().addGap(95).addComponent(LouerLblVotreLocationSera))
                        .addGroup(gl_panel_1.createSequentialGroup().addGap(36)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPourVlo))))
                        .addContainerGap(36, Short.MAX_VALUE)));
        gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup().addGap(5).addComponent(LouerLblVotreLocationSera)
                        .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblPourVlo).addGap(11)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                        .addGap(25)));
        panel_1.setLayout(gl_panel_1);
        panel.setLayout(gl_panel);
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