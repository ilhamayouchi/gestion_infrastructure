/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import beans.AffectationÉquipement;
import beans.Salle;
import beans.Équipement;
import com.toedter.calendar.JDateChooser;
import java.awt.PopupMenu;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.AffectationService;
import services.EquipementServices;
import services.SalleServices;
import static sun.font.FontManagerNativeLibrary.load;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author hp
 */
public class AffectationEquipementForm extends javax.swing.JInternalFrame {
     private static AffectationEquipementForm instance;
    private SalleServices s;
    private EquipementServices es;
    private AffectationService as;
    private DefaultTableModel model;
    private static int id;
    private JDateChooser dateChooser;

    /**
     * Creates new form AffectationEquipementForm
     */
    private AffectationEquipementForm() {
        super("Gestion des affectation ", true, true, true, true);
        setSize(400, 300);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        initComponents();
        this.setTitle("Gestion des infrastructures scolaires");
        s = new SalleServices();
        es = new EquipementServices();
        as = new AffectationService();
        Date dateaffectation = jDateChooser1.getDate();
        loadSalle();
        loadEquipement();
        model = (DefaultTableModel) tabAffectation.getModel();
        loadAffectation();
    }
     public static synchronized AffectationEquipementForm getInstance() {
        if (instance == null) {
            instance = new AffectationEquipementForm();
        }
        return instance;
    }
    public void loadAffectation() {
        model.setRowCount(0);
        for (AffectationÉquipement a : as.findAll()) {
            model.addRow(new Object[]{
                a.getSalle().getNom(),
                a.getEquipement().getNom(),
                a.getDate_affectation()
            });
        }
    }

    private void loadSalle() {
        listeSalle.removeAllItems();
        for (Salle salle : s.findAll()) {
            listeSalle.addItem(salle);
        }
    }

    private void loadEquipement() {
        listequipement.removeAllItems();
        for (Équipement equipement : es.findAll()) {
            listequipement.addItem(equipement);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        btnupdate = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Jpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        listeSalle = new javax.swing.JComboBox();
        listequipement = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btnadd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabAffectation = new javax.swing.JTable();

        jTextField1.setText("jTextField1");

        btnupdate.setBackground(new java.awt.Color(102, 102, 255));
        btnupdate.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 16)); // NOI18N
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-update-50.png"))); // NOI18N
        btnupdate.setText("     Modifier");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 16)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-50.png"))); // NOI18N
        jButton3.setText("    Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(204, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        Jpanel.setBackground(new java.awt.Color(204, 204, 255));
        Jpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion d'Affectation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 1, 16))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 16)); // NOI18N
        jLabel1.setText("Nom du Salle");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 16)); // NOI18N
        jLabel2.setText("Nom d'équipement");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 16)); // NOI18N
        jLabel3.setText("Date d'affectation");

        listeSalle.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        listeSalle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        listequipement.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        listequipement.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnadd.setBackground(new java.awt.Color(102, 102, 255));
        btnadd.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 16)); // NOI18N
        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-50.png"))); // NOI18N
        btnadd.setText("              Ajouter");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-task-50.png"))); // NOI18N

        javax.swing.GroupLayout JpanelLayout = new javax.swing.GroupLayout(Jpanel);
        Jpanel.setLayout(JpanelLayout);
        JpanelLayout.setHorizontalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listeSalle, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listequipement, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(listeSalle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(listequipement, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnadd))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des Affectation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 1, 16))); // NOI18N

        tabAffectation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom du salle", "Nom d'equipement", "Date d'affectation"
            }
        ));
        tabAffectation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabAffectationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabAffectation);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 992, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        
    

    }//GEN-LAST:event_btnupdateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        if (listeSalle == null || listequipement == null) {
            JOptionPane.showMessageDialog(this, "La liste des salles ou des équipements n'est pas initialisée.");
            return;
        }

        if (as == null) {
            JOptionPane.showMessageDialog(this, "Le service d'affectation n'est pas initialisé.");
            return;
        }

        // Get selected values
        Salle salleselect = (Salle) listeSalle.getSelectedItem();
        Équipement equipementselect = (Équipement) listequipement.getSelectedItem();
        Date dateaffectation = jDateChooser1.getDate(); // Use jDateChooser1 instead of dateChooser

        // Validate inputs
        if (dateaffectation == null) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une date d'affectation.");
            return;
        }

        if (salleselect == null || equipementselect == null) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une salle et un équipement.");
            return;
        }

        // Check if the affectation already exists
        if (as.findAll().stream().anyMatch(a -> a.getSalle().equals(salleselect) && a.getEquipement().equals(equipementselect))) {
            JOptionPane.showMessageDialog(this, "Cette affectation existe déjà !");
            return;
        }

        // Create and save the new affectation
        if (as.create(new AffectationÉquipement(salleselect, equipementselect, dateaffectation))) {
            JOptionPane.showMessageDialog(this, "Affectation ajoutée avec succès !");
            loadAffectation(); // Reload the table to reflect the new data
        } else {
            JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout de l'affectation.");
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void tabAffectationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabAffectationMouseClicked
        // TODO add your handling code here:

       


    }//GEN-LAST:event_tabAffectationMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox listeSalle;
    private javax.swing.JComboBox listequipement;
    private javax.swing.JTable tabAffectation;
    // End of variables declaration//GEN-END:variables
}
