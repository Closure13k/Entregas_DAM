/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

/**
 *
 * @author AaronFM
 */
public class form extends javax.swing.JFrame {

    /**
     * Creates new form form
     */
    public form() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        pnlIdentification = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblSurnameOne = new javax.swing.JLabel();
        txtSurnameOne = new javax.swing.JTextField();
        lblSurnameTwo = new javax.swing.JLabel();
        txtSurnameTwo = new javax.swing.JTextField();
        pnlProvince = new javax.swing.JPanel();
        cmbProvince = new javax.swing.JComboBox<>();
        btnProvinceRemove = new javax.swing.JButton();
        txtProvinceAdd = new javax.swing.JTextField();
        btnProvinceAdd = new javax.swing.JButton();
        pnlProfession = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProfession = new javax.swing.JList<>();
        btnProfessionRemove = new javax.swing.JButton();
        txtProfessionAdd = new javax.swing.JTextField();
        btnProfessionAdd = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblWorker = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("sad");
        setMinimumSize(new java.awt.Dimension(900, 450));
        setPreferredSize(new java.awt.Dimension(900, 450));
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        pnlIdentification.setBorder(javax.swing.BorderFactory.createTitledBorder("Identificación do traballador"));
        pnlIdentification.setLayout(new java.awt.GridLayout(4, 2));

        lblID.setText("DNI");
        pnlIdentification.add(lblID);
        pnlIdentification.add(txtID);

        lblName.setText("Nome");
        pnlIdentification.add(lblName);
        pnlIdentification.add(txtName);

        lblSurnameOne.setText("Apelido 1");
        pnlIdentification.add(lblSurnameOne);
        pnlIdentification.add(txtSurnameOne);

        lblSurnameTwo.setText("Apelido 2");
        pnlIdentification.add(lblSurnameTwo);
        pnlIdentification.add(txtSurnameTwo);

        jPanel1.add(pnlIdentification);

        pnlProvince.setBorder(javax.swing.BorderFactory.createTitledBorder("Provincia do traballador"));
        pnlProvince.setLayout(new java.awt.GridLayout(2, 2, 15, 15));

        pnlProvince.add(cmbProvince);

        btnProvinceRemove.setText("Eliminar provincia");
        btnProvinceRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProvinceRemoveActionPerformed(evt);
            }
        });
        pnlProvince.add(btnProvinceRemove);

        txtProvinceAdd.setText("A Coruña");
        pnlProvince.add(txtProvinceAdd);

        btnProvinceAdd.setText("Engadir provincia");
        btnProvinceAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProvinceAddActionPerformed(evt);
            }
        });
        pnlProvince.add(btnProvinceAdd);

        jPanel1.add(pnlProvince);

        pnlProfession.setBorder(javax.swing.BorderFactory.createTitledBorder("Profesión do traballador"));
        pnlProfession.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setAutoscrolls(true);

        lstProfession.setMaximumSize(new java.awt.Dimension(80, 25));
        lstProfession.setMinimumSize(new java.awt.Dimension(80, 25));
        lstProfession.setPreferredSize(new java.awt.Dimension(80, 25));
        jScrollPane1.setViewportView(lstProfession);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlProfession.add(jScrollPane1, gridBagConstraints);

        btnProfessionRemove.setText("Eliminar profesión");
        btnProfessionRemove.setMaximumSize(new java.awt.Dimension(80, 25));
        btnProfessionRemove.setMinimumSize(new java.awt.Dimension(80, 25));
        btnProfessionRemove.setPreferredSize(new java.awt.Dimension(80, 25));
        btnProfessionRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfessionRemoveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlProfession.add(btnProfessionRemove, gridBagConstraints);

        txtProfessionAdd.setText("Carpintero");
        txtProfessionAdd.setMaximumSize(new java.awt.Dimension(80, 25));
        txtProfessionAdd.setMinimumSize(new java.awt.Dimension(80, 25));
        txtProfessionAdd.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlProfession.add(txtProfessionAdd, gridBagConstraints);

        btnProfessionAdd.setText("Engadir profesión");
        btnProfessionAdd.setMaximumSize(new java.awt.Dimension(80, 25));
        btnProfessionAdd.setMinimumSize(new java.awt.Dimension(80, 25));
        btnProfessionAdd.setPreferredSize(new java.awt.Dimension(80, 25));
        btnProfessionAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfessionAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlProfession.add(btnProfessionAdd, gridBagConstraints);

        jPanel1.add(pnlProfession);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 10, 5));

        jButton1.setText("Engadir");
        jPanel2.add(jButton1);

        jButton2.setText("Pechar");
        jPanel2.add(jButton2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        jPanel6.setLayout(new java.awt.BorderLayout(0, 10));

        jButton3.setText("jButton3");
        jPanel6.add(jButton3, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Trabajadores Disponibles"));
        jPanel4.setLayout(new java.awt.BorderLayout());

        tblWorker.setAutoCreateRowSorter(true);
        tblWorker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre y apellidos", "Provincia", "Profesión"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblWorker.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblWorker.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblWorker.getTableHeader().setReorderingAllowed(false);
        tblWorker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblWorkerMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblWorker);

        jPanel4.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel6);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles del trabajador"));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setViewportView(jTextPane1);

        jPanel5.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(916, 489));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProvinceRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProvinceRemoveActionPerformed

    }//GEN-LAST:event_btnProvinceRemoveActionPerformed

    private void btnProvinceAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProvinceAddActionPerformed

    }//GEN-LAST:event_btnProvinceAddActionPerformed

    private void btnProfessionRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfessionRemoveActionPerformed

    }//GEN-LAST:event_btnProfessionRemoveActionPerformed

    private void btnProfessionAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfessionAddActionPerformed

    }//GEN-LAST:event_btnProfessionAddActionPerformed

    private void tblWorkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblWorkerMouseClicked

    }//GEN-LAST:event_tblWorkerMouseClicked

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
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProfessionAdd;
    private javax.swing.JButton btnProfessionRemove;
    private javax.swing.JButton btnProvinceAdd;
    private javax.swing.JButton btnProvinceRemove;
    private javax.swing.JComboBox<String> cmbProvince;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSurnameOne;
    private javax.swing.JLabel lblSurnameTwo;
    private javax.swing.JList<String> lstProfession;
    private javax.swing.JPanel pnlIdentification;
    private javax.swing.JPanel pnlProfession;
    private javax.swing.JPanel pnlProvince;
    private javax.swing.JTable tblWorker;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtProfessionAdd;
    private javax.swing.JTextField txtProvinceAdd;
    private javax.swing.JTextField txtSurnameOne;
    private javax.swing.JTextField txtSurnameTwo;
    // End of variables declaration//GEN-END:variables
}
