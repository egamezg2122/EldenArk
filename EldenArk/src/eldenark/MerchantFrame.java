/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the tedddddmplate in the editor.
 */
package eldenark;

import java.util.HashSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Gato
 */
public class MerchantFrame extends javax.swing.JFrame {

    Merchant merchant;
    Character mainCharacter;
    JLabel background = new JLabel();
    Gameplay x;

    public MerchantFrame(Merchant merchant, Character mainCharacter) {

        this.merchant = merchant;
        this.mainCharacter = mainCharacter;
        initComponents();
        JLabel background = new JLabel();
        this.add(background);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/alfombraMerchant.png")));
        background.setBounds(0, 0, 1200, 700);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exitMerchant = new javax.swing.JButton();
        smallObjectimg = new javax.swing.JLabel();
        largeObjectImg = new javax.swing.JLabel();
        equipImg = new javax.swing.JLabel();
        merchantMan1 = new javax.swing.JLabel();
        smallObject = new javax.swing.JButton();
        smallObject1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setResizable(false);

        exitMerchant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        exitMerchant.setText("Exit Shop");
        exitMerchant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMerchantActionPerformed(evt);
            }
        });

        smallObjectimg.setIcon(new javax.swing.ImageIcon(getClass().getResource(merchant.getSmallObjImage())));

        largeObjectImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(merchant.getLargeObjImage())));

        equipImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(merchant.getEquipImage())));
        equipImg.setMinimumSize(new java.awt.Dimension(51, 14));

        merchantMan1.setIcon(new javax.swing.ImageIcon(getClass().getResource(merchant.getMerchantImage())));
        merchantMan1.setPreferredSize(new java.awt.Dimension(1265, 700));

        smallObject.setText(merchant.getSellingObject1().getName());
        smallObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smallObjectActionPerformed(evt);
            }
        });

        smallObject1.setText(merchant.getSellingObject2().getName());
        smallObject1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smallObject1ActionPerformed(evt);
                bigObjectActionPerformed(evt);
            }
        });

        jButton1.setText(merchant.getSellingEquip().getName());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitMerchant, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(smallObject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(smallObjectimg, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(smallObject1)
                            .addComponent(largeObjectImg, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(equipImg, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(merchantMan1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(645, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitMerchant, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(merchantMan1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(largeObjectImg, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(equipImg, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(smallObjectimg, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(smallObject1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(smallObject, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMerchantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMerchantActionPerformed
            this.dispose();
    }//GEN-LAST:event_exitMerchantActionPerformed

    private void smallObject1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smallObject1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_smallObject1ActionPerformed

    private void smallObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smallObjectActionPerformed
        if (mainCharacter.getGold() >= merchant.getPriceSmallObject() && merchant.getQuantitySmallObject() > 0) {
            mainCharacter.getInventory()[merchant.getTypeObject1()].setNumOfUses(mainCharacter.getInventory()[merchant.getTypeObject1()].getNumOfUses()+1);
            mainCharacter.setGold(mainCharacter.getGold()-merchant.getPriceSmallObject());
            merchant.setQuantitySmallObject(-1);
        }
    }//GEN-LAST:event_smallObjectActionPerformed

    private void bigObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bigObjectActionPerformed
        if (mainCharacter.getGold() >= merchant.getPriceBigObject() && merchant.getQuantityBigObject() > 0) {
            mainCharacter.getInventory()[merchant.getTypeObject2()].setNumOfUses(mainCharacter.getInventory()[merchant.getTypeObject2()].getNumOfUses()+1);
            mainCharacter.setGold(mainCharacter.getGold()-merchant.getPriceBigObject());
            merchant.setQuantityBigObject(-1);
        }

    }//GEN-LAST:event_bigObjectActionPerformed

    private void equipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipActionPerformed
        if (mainCharacter.getGold() >= merchant.getPriceEquip() && merchant.getQuantityEquip()> 0) {
            mainCharacter.setGold(mainCharacter.getGold() - merchant.getPriceEquip());
            mainCharacter.changeEquip(mainCharacter.getEquipment(), merchant.getSellingEquip());
            merchant.setQuantityEquip(-1);
        }
    }//GEN-LAST:event_equipActionPerformed
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
            java.util.logging.Logger.getLogger(MerchantFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MerchantFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MerchantFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MerchantFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MerchantFrame().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel equipImg;
    private javax.swing.JButton exitMerchant;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel largeObjectImg;
    private javax.swing.JLabel merchantMan1;
    private javax.swing.JButton smallObject;
    private javax.swing.JButton smallObject1;
    private javax.swing.JLabel smallObjectimg;
    // End of variables declaration//GEN-END:variables
}
