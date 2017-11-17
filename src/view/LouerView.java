package view;

import java.awt.BorderLayout;
import java.awt.Color;
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
    private JFrame frmPaiement;
    
    public LouerView()
    {
        this.louerController = new LouerController(this);
        
        initLouer();
    }

    private void initLouer()
    {
        frmLouer = new JFrame();
        frmLouer.setTitle("Louer");
        frmLouer.setBounds(100, 100, 450, 200);
        frmLouer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLouer.setLocationRelativeTo(null);
        
        JPanel LouerPanel = new JPanel();
        LouerPanel.setBorder(new TitledBorder(null, "Choisir votre location", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        frmLouer.getContentPane().add(LouerPanel, BorderLayout.CENTER);
        
        JLabel LouerLblNombreDeVlo = new JLabel("Nombre de vélo souhaité :");
        
        JSpinner LouerSpinnerVelo = new JSpinner();
        
        JLabel LouerLblVotreLocationSera = new JLabel("Votre location sera valable 24 heures");
        LouerLblVotreLocationSera.setFont(new Font("Tahoma", Font.BOLD, 14));
           
        JButton LouerBtnValider = new JButton("Valider");
        
        JButton LouerBtnAnnuler = new JButton("Annuler");
        
        JLabel LouerLblCaution = new JLabel("Note : Caution de 200$ CAN par vélo");
        LouerLblCaution.setFont(new Font("Tahoma", Font.BOLD, 11));
        LouerLblCaution.setForeground(new Color(102, 0, 0));
        GroupLayout gl_LouerPanel = new GroupLayout(LouerPanel);
        gl_LouerPanel.setHorizontalGroup(
            gl_LouerPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_LouerPanel.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_LouerPanel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, gl_LouerPanel.createSequentialGroup()
                            .addComponent(LouerLblVotreLocationSera)
                            .addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                            .addComponent(btnAide, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(gl_LouerPanel.createSequentialGroup()
                            .addComponent(LouerBtnAnnuler)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(LouerBtnValider)
                            .addGap(133))))
                .addGroup(gl_LouerPanel.createSequentialGroup()
                    .addGap(49)
                    .addComponent(LouerLblNombreDeVlo)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(LouerSpinnerVelo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(197, Short.MAX_VALUE))
                .addGroup(gl_LouerPanel.createSequentialGroup()
                    .addContainerGap(212, Short.MAX_VALUE)
                    .addComponent(LouerLblCaution)
                    .addContainerGap())
        );
        gl_LouerPanel.setVerticalGroup(
            gl_LouerPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_LouerPanel.createSequentialGroup()
                    .addGroup(gl_LouerPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_LouerPanel.createSequentialGroup()
                            .addGap(21)
                            .addComponent(LouerLblVotreLocationSera)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addGroup(gl_LouerPanel.createParallelGroup(Alignment.BASELINE)
                                .addComponent(LouerLblNombreDeVlo)
                                .addComponent(LouerSpinnerVelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnAide))
                    .addGap(10)
                    .addComponent(LouerLblCaution)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_LouerPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(LouerBtnAnnuler)
                        .addComponent(LouerBtnValider))
                    .addContainerGap())
        );
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
}
