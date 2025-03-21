/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static sun.font.SunLayoutEngine.instance;

/**
 *
 * @author hp
 */
public class MDIApplication extends javax.swing.JFrame {

    public static MDIApplication instance;

    /**
     * Creates new form MDIApplication
     */
    public MDIApplication() {
        initComponents();
        this.setTitle("Gestion des infrastructures scolaires");
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    public static MDIApplication getInstance() {
        if (instance == null) {
            instance = new MDIApplication();
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        SalleMenuItem = new javax.swing.JMenuItem();
        EquipementMenuItem = new javax.swing.JMenuItem();
        affecterequipement = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Gestion");

        SalleMenuItem.setMnemonic('o');
        SalleMenuItem.setText("Salle");
        SalleMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalleMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(SalleMenuItem);

        EquipementMenuItem.setMnemonic('s');
        EquipementMenuItem.setText("Équipement");
        EquipementMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EquipementMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(EquipementMenuItem);

        affecterequipement.setMnemonic('a');
        affecterequipement.setText("Affecter Équipement");
        affecterequipement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                affecterequipementActionPerformed(evt);
            }
        });
        fileMenu.add(affecterequipement);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Fonctionnalité");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Filtrer les équipements par salle");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(cutMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void SalleMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalleMenuItemActionPerformed
        SalleForm ss = SalleForm.getInstance(); // ✅ Récupération de l'unique instance
        if (!ss.isVisible()) { // Vérifier si la fenêtre est déjà affichée
            desktopPane.add(ss);
            ss.setVisible(true);
            ss.toFront(); // Amène la fenêtre au premier plan
        }

    }//GEN-LAST:event_SalleMenuItemActionPerformed

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        // TODO add your handling code here:
        FiltreEquipementParSalleForm fs = FiltreEquipementParSalleForm.getInstance(); // ✅ Récupération de l'unique instance
        if (!fs.isVisible()) { // Vérifier si la fenêtre est déjà affichée
            desktopPane.add(fs);
            fs.setVisible(true);
            fs.toFront(); // Amène la fenêtre au premier plan
        }
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void EquipementMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EquipementMenuItemActionPerformed
        // TODO add your handling code here:
        EquipementForm es = EquipementForm.getInstance(); // ✅ Récupération de l'unique instance
        if (!es.isVisible()) { // Vérifier si la fenêtre est déjà affichée
            desktopPane.add(es);
            es.setVisible(true);
            es.toFront(); // Amène la fenêtre au premier plan
        }
    }//GEN-LAST:event_EquipementMenuItemActionPerformed

    private void affecterequipementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affecterequipementActionPerformed
        // TODO add your handling code here:
        AffectationEquipementForm as = AffectationEquipementForm.getInstance(); // ✅ Récupération de l'unique instance
        if (!as.isVisible()) { // Vérifier si la fenêtre est déjà affichée
            desktopPane.add(as);
            as.setVisible(true);
            as.toFront(); // Amène la fenêtre au premier plan
        }
    }//GEN-LAST:event_affecterequipementActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIApplication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem EquipementMenuItem;
    private javax.swing.JMenuItem SalleMenuItem;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem affecterequipement;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
