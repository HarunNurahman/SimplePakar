/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistempakar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author harun
 */
public class FormAdmin extends javax.swing.JFrame {

    /**
     * Creates new form FormAdmin
     */
    Connection koneksi;
    DefaultTableModel dtm;
    int selected, baris = -1;
    static final int min = 1;
    static final int max = 10000;

    public FormAdmin() {
        initComponents();
        koneksi = Koneksi.getKoneksi("localhost", "3306", "root", "", "db_pakar");
        loading.setMinimum(min);
        ShowData();
        ShowUser();
        loading.setMaximum(max);

    }

    public void ShowData() {
        String kolom[] = {"No", "ID Penyakit", "Gejala 1", "Gejala 2", "Gejala 3", "Penyakit", "Penyebab"};
        dtm = new DefaultTableModel(null, kolom);
        try {
            Statement stmt = koneksi.createStatement();
            String query = "SELECT id, gejala1, gejala2, gejala3, diagnosa, cegah FROM penyakit";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            int no = 1;
            while (rs.next()) {
                String id = rs.getString("id");
                String gj1 = rs.getString("gejala1");
                String gj2 = rs.getString("gejala2");
                String gj3 = rs.getString("gejala3");
                String diag = rs.getString("diagnosa");
                String cgh = rs.getString("cegah");
                dtm.addRow(new String[]{no + "", id, gj1, gj2, gj3, diag, cgh});
                no++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Kesalahan DB");
        }
        tbl_sick.setModel(dtm);
    }

    public void ShowUser() {
        String kolom[] = {"No", "ID", "Username", "Password", "Level", "NIK", "Nama", "Tempat Lahir", "Tanggal Lahir", "Alamat", "No. Telp/HP"};
        dtm = new DefaultTableModel(null, kolom);
        try {
            Statement stmt = koneksi.createStatement();
            String query = "SELECT * FROM login";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            int no = 1;
            while (rs.next()) {
                String id = rs.getString("id");
                String user = rs.getString("username");
                String pass = rs.getString("password");
                String lvl = rs.getString("level");
                String nik = rs.getString("nik");
                String nm = rs.getString("nama");
                String tplhr = rs.getString("tmplahir");
                String tglhr = rs.getString("tgllahir");
                String alamat = rs.getString("alamat");
                String telp = rs.getString("telp");
                dtm.addRow(new Object[]{no + "", id, user, pass, lvl, nik, nm, tplhr, tglhr, alamat, telp});
                no++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Kesalahan DB");
        }
        tbl_user.setModel(dtm);
    }

    public void addData() {
        ManageSick add = new ManageSick(this, true, "add", "");
        add.setVisible(true);
    }

    public void addUser() {
        ManageUser add = new ManageUser(this, true, "add", "");
        add.setVisible(true);
    }

    public void editData() {
        String id = tbl_sick.getValueAt(baris, 1).toString();
        if (baris == -1) {
            JOptionPane.showMessageDialog(null, "Data Belum Dipilih");
        } else {
            new ManageSick(this, true, "edit", id).setVisible(true);
        }
    }

    public void editUser() {
        String id = tbl_user.getValueAt(baris, 1).toString();
        if (baris == -1) {
            JOptionPane.showMessageDialog(null, "Data Belum Dipilih");
        } else {
            new ManageUser(this, true, "edit", id).setVisible(true);
        }
    }

    public void deleteSick() {
        String id = tbl_sick.getValueAt(baris, 1).toString();
        if (baris == -1) {
            JOptionPane.showMessageDialog(null, "Data Belum Dipilih");
        } else {
            try {
                Statement stmt = koneksi.createStatement();
                String del = "DELETE FROM penyakit WHERE id = '" + id + "'";
                int berhasil = stmt.executeUpdate(del);
                if (berhasil == 1) {
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    dtm.getDataVector().removeAllElements();
                    ShowData();
                } else {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Kesalahan DB or Query");
            }
        }
    }

    public void deleteUser() {
        String id = tbl_user.getValueAt(baris, 1).toString();
        if (baris == -1) {
            JOptionPane.showMessageDialog(null, "Data Belum Dipilih");
        } else {
            try {
                Statement stmt = koneksi.createStatement();
                String del = "DELETE * FROM login WHERE id = '" + id + "'";
                int berhasil = stmt.executeUpdate(del);
                if (berhasil == 1) {
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    dtm.getDataVector().removeAllElements();
                    ShowUser();
                } else {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Kesalahan DB atau Query");
            }
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

        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        loading = new javax.swing.JProgressBar();
        btnOut = new javax.swing.JButton();
        btnFresh = new javax.swing.JButton();
        lbl_proses = new javax.swing.JLabel();
        tabcontent = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_sick = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_user = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Site");

        jLabel1.setFont(new java.awt.Font("Bebas", 0, 24)); // NOI18N
        jLabel1.setText("Administrator Form");

        btnAdd.setFont(new java.awt.Font("Impact", 0, 11)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistempakar/add.png"))); // NOI18N
        btnAdd.setText("Tambah");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Impact", 0, 11)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistempakar/edit.png"))); // NOI18N
        btnEdit.setText("Ubah");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDel.setFont(new java.awt.Font("Impact", 0, 11)); // NOI18N
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistempakar/del.png"))); // NOI18N
        btnDel.setText("Hapus");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnOut.setFont(new java.awt.Font("Impact", 0, 11)); // NOI18N
        btnOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistempakar/exit.png"))); // NOI18N
        btnOut.setText("Logout");
        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });

        btnFresh.setFont(new java.awt.Font("Impact", 0, 11)); // NOI18N
        btnFresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistempakar/refresh.png"))); // NOI18N
        btnFresh.setText("Refresh");
        btnFresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFreshActionPerformed(evt);
            }
        });

        lbl_proses.setText("Status Bar");

        tabcontent.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabcontentStateChanged(evt);
            }
        });

        tbl_sick.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_sick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sickMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_sick);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabcontent.addTab("Penyakit", jPanel1);

        tbl_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_userMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_user);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        tabcontent.addTab("User", jPanel2);

        jMenu1.setText("File");

        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(loading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_proses)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(tabcontent, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnFresh, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(jLabel1))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabcontent)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187)
                        .addComponent(btnOut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_proses)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        loading.setValue(0);
        lbl_proses.setText("Adding....");
        loading.setStringPainted(true);

        if (selected == 0) {
            addData();
            ShowData();
        } else if (selected == 1) {
            addUser();
            ShowUser();
        }

        loading.setValue(max);
        lbl_proses.setText("Add Data Completed!");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        loading.setValue(0);
        if (baris == -1) {
            JOptionPane.showMessageDialog(null, "Data Belum Dipilih");

        } else {
            lbl_proses.setText("Updating....");
            loading.setStringPainted(true);

            if (selected == 0) {
                editData();
                ShowData();
            } else if (selected == 1) {
                editUser();
                ShowUser();
            }
            loading.setValue(max);
            lbl_proses.setText("Update Data Complete.");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnFreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFreshActionPerformed
        // TODO add your handling code here:
        if (selected == 0) {
            ShowData();
        } else if (selected == 1) {
            ShowUser();
        }

    }//GEN-LAST:event_btnFreshActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
        loading.setValue(0);
        if (baris == -1) {
            JOptionPane.showMessageDialog(null, "Data Belum Dipilih");
        } else {
            lbl_proses.setText("Deleting....");
            loading.setStringPainted(true);
            int input = JOptionPane.showConfirmDialog(null, "Anda Yakin Ingin Menghapus Data Ini?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (input == JOptionPane.YES_OPTION) {
                loading.setValue(max);
                lbl_proses.setText("Deleting Completed");
                if (selected == 0) {
                    deleteSick();
                    ShowData();
                } else if (selected == 1) {
                    deleteUser();
                    ShowUser();
                }
            }
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed
        // TODO add your handling code here:
        int input = JOptionPane.showConfirmDialog(null, "Anda Yakin Ingin Keluar?", "Logout", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (input == JOptionPane.YES_OPTION) {
            LoginForm fl = new LoginForm();
            fl.show();
            this.dispose();
        }
    }//GEN-LAST:event_btnOutActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new About(this, rootPaneCheckingEnabled).show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tabcontentStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabcontentStateChanged
        // TODO add your handling code here:
        selected = tabcontent.getSelectedIndex();
        baris = -1;
    }//GEN-LAST:event_tabcontentStateChanged

    private void tbl_sickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sickMouseClicked
        // TODO add your handling code here:
        baris = tbl_sick.getSelectedRow();
    }//GEN-LAST:event_tbl_sickMouseClicked

    private void tbl_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_userMouseClicked
        // TODO add your handling code here:
        baris = tbl_user.getSelectedRow();
    }//GEN-LAST:event_tbl_userMouseClicked

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
            java.util.logging.Logger.getLogger(FormAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFresh;
    private javax.swing.JButton btnOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_proses;
    private javax.swing.JProgressBar loading;
    private javax.swing.JTabbedPane tabcontent;
    private javax.swing.JTable tbl_sick;
    private javax.swing.JTable tbl_user;
    // End of variables declaration//GEN-END:variables
}
