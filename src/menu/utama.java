/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import koneksidb.koneksi;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import java.awt.color.ColorSpace;

/**
 *
 * @author ASUS
 */
public class utama extends javax.swing.JFrame {
    

    /**
     * Creates new form utama
     */
    public utama() {
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

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        daftar = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        profil = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        contact_us = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        jLabel1.setText("Pengawasan PENJUALAN MOBIL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 98, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, 309, 10));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 8)); // NOI18N
        jLabel2.setText("Friska Rahayu   ||   Indah Lugianti   ||   Ismail Yushar");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 270, -1, 14));

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel3.setText("PT. OPPASELLBUY");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 139, -1, -1));

        daftar.setText("Daftar");
        daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftarActionPerformed(evt);
            }
        });

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Penjualan/Bulan");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        daftar.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Daftar Customer");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        daftar.add(jCheckBoxMenuItem2);

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("Pembelian [Grafik]");
        jCheckBoxMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem3ActionPerformed(evt);
            }
        });
        daftar.add(jCheckBoxMenuItem3);

        jMenuBar1.add(daftar);

        profil.setText("Profil");
        profil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Profil");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        profil.add(jMenuItem1);

        jMenuBar1.add(profil);

        contact_us.setText("Contact Us");

        jMenuItem2.setText("Contact Us");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        contact_us.add(jMenuItem2);

        jMenuBar1.add(contact_us);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarActionPerformed
       new daftar().setVisible(true);
    }//GEN-LAST:event_daftarActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
       String query = "SELECT t_waktu.bulan, t_fact_penjualan.kd_waktu, t_fact_penjualan.jumlah_unit\n" +
           "FROM t_waktu, t_fact_penjualan WHERE t_fact_penjualan.kd_waktu=t_waktu.kd_waktu;";
       
       try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            JDBCCategoryDataset data= new JDBCCategoryDataset("jdbc:mysql://localhost/db_penjualan", "com.mysql.jdbc.Driver", "root", "");
            data.executeQuery(query);
            DefaultCategoryDataset df = data;
            
            JFreeChart chart = ChartFactory.createLineChart("GRAFIK PENJUALAN MOBIL per BULAN", "Bulan", "Jumlah Unit", df);
            CategoryPlot objCategoryPlot = chart.getCategoryPlot();
            objCategoryPlot.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("Grafik BATANG",chart);
            frame.setSize(1000,400);
            frame.setVisible(true);
       }catch(Exception e){
           
       }         
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void profilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilActionPerformed
         new profil().setVisible(true);
    }//GEN-LAST:event_profilActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new profil().setVisible(true);
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new contact_us().setVisible(true); 
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        // TODO add your handling code here:
        tabel x = new tabel();
        x.setVisible(true);
        
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void jCheckBoxMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem3ActionPerformed
        // TODO add your handling code here:
        String query = "SELECT jenis_pelunasan, SUM( jumlah_unit ) FROM t_fact_penjualan\n" +
                        "GROUP BY jenis_pelunasan";
       
       try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            JDBCCategoryDataset data= new JDBCCategoryDataset("jdbc:mysql://localhost/db_penjualan", "com.mysql.jdbc.Driver", "root", "");
            data.executeQuery(query);
            DefaultCategoryDataset df = data;
            
            JFreeChart chart = ChartFactory.createBarChart("Grafik Perbandingan Jumlah Pelunasan CASH&CREDIT", "Jenis Pelunasan", "Jumlah Unit", df);
            CategoryPlot objCategoryPlot = chart.getCategoryPlot();
            objCategoryPlot.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("Grafik BATANG",chart);
            frame.setSize(325,400);
            frame.setVisible(true);
       }catch(Exception e){
           
       }
    }//GEN-LAST:event_jCheckBoxMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu contact_us;
    private javax.swing.JMenu daftar;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenu profil;
    // End of variables declaration//GEN-END:variables
}
