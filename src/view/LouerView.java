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
        initPaiement();
    }

    private void initLouer()
    {
        frmLouer = new JFrame();
        frmLouer.setTitle("Louer");
        frmLouer.setBounds(100, 100, 450, 200);
        frmLouer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel LouerPanel = new JPanel();
        LouerPanel.setBorder(new TitledBorder(null, "Choisir votre location", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        frmLouer.getContentPane().add(LouerPanel, BorderLayout.CENTER);
        
        JLabel LouerLblNombreDeVlo = new JLabel("Nombre de vélo souhaité :");
        
        JSpinner LouerSpinnerVelo = new JSpinner();
        
        JLabel LouerLblVotreLocationSera = new JLabel("Votre location sera valable 24 heures");
        LouerLblVotreLocationSera.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JButton LouerBtnAide = new JButton("Aide");
        
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
                            .addComponent(LouerBtnAide, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(LouerBtnAide))
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

    private void initPaiement()
    {
        frmPaiement = new JFrame();
        frmPaiement.setResizable(false);
        frmPaiement.setTitle("Paiement");
        frmPaiement.setBounds(100, 100, 353, 231);
        frmPaiement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel PaiementPanel = new JPanel();
        PaiementPanel.setBorder(new TitledBorder(null, "Proc\u00E9dez au paiement", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        frmPaiement.getContentPane().add(PaiementPanel, BorderLayout.CENTER);
        
        JButton PaiementBtnPayerViaPaypal = new JButton("Payer via Paypal");
        PaiementBtnPayerViaPaypal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        JButton PaiementBtnAbandonner = new JButton("Abandonner");
        
        JLabel PaiementLblMontantPayer = new JLabel("Montant à payer : XX $CAN");
        PaiementLblMontantPayer.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        JScrollPane scrollPane = new JScrollPane();
        
        JLabel lblPrixTotal = new JLabel("Prix total : 310$ CAN");
        lblPrixTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
        GroupLayout gl_PaiementPanel = new GroupLayout(PaiementPanel);
        gl_PaiementPanel.setHorizontalGroup(
            gl_PaiementPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_PaiementPanel.createSequentialGroup()
                    .addContainerGap(84, Short.MAX_VALUE)
                    .addComponent(PaiementLblMontantPayer)
                    .addGap(73))
                .addGroup(gl_PaiementPanel.createSequentialGroup()
                    .addGap(19)
                    .addComponent(PaiementBtnAbandonner)
                    .addGap(18)
                    .addComponent(PaiementBtnPayerViaPaypal, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                .addGroup(gl_PaiementPanel.createSequentialGroup()
                    .addContainerGap(100, Short.MAX_VALUE)
                    .addComponent(lblPrixTotal)
                    .addGap(89))
                .addGroup(gl_PaiementPanel.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addContainerGap())
        );
        gl_PaiementPanel.setVerticalGroup(
            gl_PaiementPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_PaiementPanel.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PaiementLblMontantPayer)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblPrixTotal)
                    .addGap(14)
                    .addGroup(gl_PaiementPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(PaiementBtnPayerViaPaypal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PaiementBtnAbandonner)))
        );
        
        JTable table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {"2", "V\u00E9lo Caution", new Integer(300)},
                {"2", "V\u00E9lo non abo 24h", new Integer(10)},
            },
            new String[] {
                "Qte", "Libell\u00E9", "Prix uni. $CAN"
            }
        ) {
            Class[] columnTypes = new Class[] {
                Object.class, Object.class, Integer.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
            boolean[] columnEditables = new boolean[] {
                true, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(32);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(96);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        scrollPane.setViewportView(table);
        PaiementPanel.setLayout(gl_PaiementPanel);
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
