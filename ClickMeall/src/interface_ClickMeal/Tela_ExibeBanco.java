/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_ClickMeal;

import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author IFMG
 */
public class Tela_ExibeBanco extends javax.swing.JFrame {
    DefaultListModel model = new DefaultListModel();
       
        
    
    public Tela_ExibeBanco() {
        initComponents();
         model.addElement("Testeas");
        jList_ing=new JList(model);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_ing = new javax.swing.JList<>();
        jLabel_ing = new javax.swing.JLabel();
        jButton_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setLayout(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(120, 20, 120, 120);

        jList_ing.setFont(new java.awt.Font("Albertus Medium", 1, 12)); // NOI18N
        jScrollPane1.setViewportView(jList_ing);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 190, 340, 240);

        jLabel_ing.setFont(new java.awt.Font("Albertus Medium", 1, 12)); // NOI18N
        jLabel_ing.setText("Ingredientes Cadastrados");
        jPanel1.add(jLabel_ing);
        jLabel_ing.setBounds(10, 160, 160, 20);

        jButton_back.setFont(new java.awt.Font("Albertus Medium", 1, 12)); // NOI18N
        jButton_back.setText("Voltar");
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_back);
        jButton_back.setBounds(140, 440, 80, 25);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 360, 490);

        setSize(new java.awt.Dimension(372, 527));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
        Tela_MenuAdm tela = new Tela_MenuAdm();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton_backActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_ExibeBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_ExibeBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_ExibeBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_ExibeBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_ExibeBanco().setVisible(true);
            }
        });
    } 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_back;
    private javax.swing.JLabel jLabel_ing;
    private javax.swing.JList<String> jList_ing;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
