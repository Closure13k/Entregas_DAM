/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.Dimension;

/**
 *
 * @author AaronFM
 */
public class Ex3 extends javax.swing.JFrame {

    /**
     * Creates new form Ex3
     */
    public Ex3() {
        initComponents();
        jButton3.setMaximumSize(new Dimension(200, (int)(jButton1.getMaximumSize().getHeight()/2)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jButton1.setText("jButton1");
        jButton1.setAlignmentX(1.0F);
        jButton1.setMaximumSize(new java.awt.Dimension(200, 10000));
        jButton1.setMinimumSize(new java.awt.Dimension(200, 25));
        jButton1.setPreferredSize(new java.awt.Dimension(200, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        jButton2.setText("jButton2");
        jButton2.setAlignmentX(1.0F);
        jButton2.setMaximumSize(new java.awt.Dimension(200, 100));
        jButton2.setMinimumSize(new java.awt.Dimension(200, 100));
        jButton2.setPreferredSize(new java.awt.Dimension(200, 100));
        getContentPane().add(jButton2);

        jButton3.setText("jButton3");
        jButton3.setAlignmentX(1.0F);
        jButton3.setMaximumSize(new java.awt.Dimension(200, 25));
        jButton3.setMinimumSize(new java.awt.Dimension(200, 25));
        jButton3.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jButton3);

        jButton4.setText("jButton4");
        jButton4.setAlignmentX(1.0F);
        jButton4.setMaximumSize(new java.awt.Dimension(200, 100));
        jButton4.setMinimumSize(new java.awt.Dimension(200, 100));
        jButton4.setPreferredSize(new java.awt.Dimension(200, 100));
        getContentPane().add(jButton4);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Ex3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ex3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ex3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ex3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ex3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    // End of variables declaration//GEN-END:variables
}
