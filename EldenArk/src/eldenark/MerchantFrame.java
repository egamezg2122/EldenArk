/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the tedddddmplate in the editor.
 */
package eldenark;

import java.awt.Color;
import java.util.HashSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Gato
 */
public class MerchantFrame extends javax.swing.JFrame {

	Sound sound = new Sound();
	Merchant merchant;
	Character mainCharacter;
	Gameplay game;
	JLabel background = new JLabel();
	Gameplay x;

	public MerchantFrame(Merchant merchant, Character mainCharacter, Gameplay game) {

		this.merchant = merchant;
		this.mainCharacter = mainCharacter;
		this.game = game;
		initComponents();
                beautify();
                
		JLabel background = new JLabel();
		this.add(background);
		background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/MERCHANTBG.gif")));
		background.setBounds(0, 0, 1200, 700);
		setValues();

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
        currentGold = new javax.swing.JTextField();
        merchantNames = new javax.swing.JLabel();
        priceSmall = new javax.swing.JTextField();
        quantitySmall = new javax.swing.JTextField();
        priceBig = new javax.swing.JTextField();
        quantityBig = new javax.swing.JTextField();
        priceEquip = new javax.swing.JTextField();
        quantityEquip = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        spinnerSmall = new javax.swing.JSpinner();
        spinnerBig = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
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
                bigObjectActionPerformed(evt);
            }
        });

        jButton1.setText(merchant.getSellingEquip().getName());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipActionPerformed(evt);
            }
        });

        currentGold.setEditable(false);
        currentGold.setForeground(new java.awt.Color(255, 255, 255));
        currentGold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentGoldActionPerformed(evt);
            }
        });

        merchantNames.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        merchantNames.setForeground(new java.awt.Color(255, 255, 255));
        merchantNames.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        merchantNames.setText("jLabel1");

        priceSmall.setEditable(false);
        priceSmall.setText("jTextField1");

        quantitySmall.setEditable(false);
        quantitySmall.setText("jTextField1");

        priceBig.setEditable(false);
        priceBig.setText("jTextField1");

        quantityBig.setEditable(false);
        quantityBig.setText("jTextField1");

        priceEquip.setEditable(false);
        priceEquip.setText("jTextField1");

        quantityEquip.setEditable(false);
        quantityEquip.setText("jTextField1");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/COIN.gif"))); // NOI18N

        spinnerSmall.setModel(new javax.swing.SpinnerNumberModel(1, 0, 5, 1));
        spinnerSmall.setEditor(new javax.swing.JSpinner.NumberEditor(spinnerSmall, ""));

        spinnerBig.setModel(new javax.swing.SpinnerNumberModel(0, 0, 2, 1));
        spinnerBig.setEditor(new javax.swing.JSpinner.NumberEditor(spinnerBig, ""));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(currentGold, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(merchantMan1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 288, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(priceSmall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantitySmall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(216, 216, 216)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(priceBig, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantityBig, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(101, 101, 101))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(spinnerSmall, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(smallObject, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(spinnerBig, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(smallObject1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(equipImg, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(189, 189, 189))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(quantityEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(202, 202, 202))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(smallObjectimg, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(largeObjectImg, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(471, 471, 471))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(exitMerchant, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(332, 332, 332))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(merchantNames, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(merchantNames, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentGold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(merchantMan1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(smallObjectimg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(equipImg, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(largeObjectImg, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(priceBig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(quantityBig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(exitMerchant, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(smallObject1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(smallObject, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerSmall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerBig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceSmall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(quantitySmall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(131, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(priceEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(quantityEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void beautify(){
        currentGold.setBackground(null);
        currentGold.setForeground(Color.WHITE);
        currentGold.setBorder(null);
        currentGold.setOpaque(false);
        
        priceSmall.setBackground(null);
        priceSmall.setForeground(Color.WHITE);
        priceSmall.setBorder(null);
        priceSmall.setOpaque(false);
        
        quantitySmall.setBackground(null);
        quantitySmall.setForeground(Color.WHITE);
        quantitySmall.setBorder(null);
        quantitySmall.setOpaque(false);
        
        priceBig.setBackground(null);
        priceBig.setForeground(Color.WHITE);
        priceBig.setBorder(null);
        priceBig.setOpaque(false);
        
        quantityBig.setBackground(null);
        quantityBig.setForeground(Color.WHITE);
        quantityBig.setBorder(null);
        quantityBig.setOpaque(false);
        
        priceEquip.setBackground(null);
        priceEquip.setForeground(Color.WHITE);
        priceEquip.setBorder(null);
        priceEquip.setOpaque(false);
        
        quantityEquip.setBackground(null);
        quantityEquip.setForeground(Color.WHITE);
        quantityEquip.setBorder(null);
        quantityEquip.setOpaque(false);
        
        
    }
    
    private void exitMerchantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMerchantActionPerformed
		this.dispose();
		game.setVisible(true);

    }//GEN-LAST:event_exitMerchantActionPerformed

    private void smallObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smallObjectActionPerformed
		if (mainCharacter.getGold() >= merchant.getPriceSmallObject()) {
			int value = (Integer) spinnerSmall.getValue();
			if (merchant.getQuantitySmallObject() > 0) {
				if (value <= merchant.getQuantitySmallObject() && value != 0) {
					mainCharacter.getInventory()[merchant.getTypeObject1()].setNumOfUses(mainCharacter.getInventory()[merchant.getTypeObject1()].getNumOfUses() + value);
					mainCharacter.setGold(mainCharacter.getGold() - (merchant.getPriceSmallObject() * value));
					merchant.setQuantitySmallObject(merchant.getQuantitySmallObject() - value);
					JOptionPane.showMessageDialog(this, "You have bought succesfully " + value + " " + merchant.getSellingObject1().getName(), "Buy", JOptionPane.INFORMATION_MESSAGE);
					sound.playSE(5);
					setValues();
					spinnerSmall.setModel(new javax.swing.SpinnerNumberModel(0, 0, merchant.getQuantitySmallObject(), 1));
				}

			} else {
				JOptionPane.showMessageDialog(this, "You can't buy this object I ran out of this item", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {

			JOptionPane.showMessageDialog(this, "You can't buy this object you have no gold", "Error", JOptionPane.ERROR_MESSAGE);

		}
    }//GEN-LAST:event_smallObjectActionPerformed

    private void bigObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bigObjectActionPerformed

		if (mainCharacter.getGold() >= merchant.getPriceBigObject()) {
			int value = (Integer) spinnerBig.getValue();
			if (merchant.getQuantityBigObject() > 0) {
				if (value <= merchant.getQuantityBigObject() && value != 0) {
					mainCharacter.getInventory()[merchant.getTypeObject2()].setNumOfUses(mainCharacter.getInventory()[merchant.getTypeObject2()].getNumOfUses() + value);
					mainCharacter.setGold(mainCharacter.getGold() - merchant.getPriceBigObject());
					merchant.setQuantityBigObject(merchant.getQuantityBigObject() - value);
					JOptionPane.showMessageDialog(this, "You have bought succesfully " + value + " " + merchant.getSellingObject2().getName(), "Buy", JOptionPane.INFORMATION_MESSAGE);
					sound.playSE(5);
					setValues();
					spinnerBig.setModel(new javax.swing.SpinnerNumberModel(0, 0, merchant.getQuantityBigObject(), 1));
				} 

			} else {

				JOptionPane.showMessageDialog(this, "You can't buy this object I ran out of this item", "Error", JOptionPane.ERROR_MESSAGE);

			}

		} else {

			JOptionPane.showMessageDialog(this, "You can't buy this object you have no gold", "Error", JOptionPane.ERROR_MESSAGE);

		}


    }//GEN-LAST:event_bigObjectActionPerformed

    private void equipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipActionPerformed

		if (mainCharacter.getGold() >= merchant.getPriceEquip()) {
			if (merchant.getQuantityEquip() > 0) {
				mainCharacter.setGold(mainCharacter.getGold() - merchant.getPriceEquip());
				mainCharacter.changeEquip(mainCharacter.getEquipment(), merchant.getSellingEquip());
				merchant.setQuantityEquip(merchant.getQuantityEquip() - 1);
				JOptionPane.showMessageDialog(this, "You have bought succesfully " + merchant.getSellingEquip().getName(), "Buy", JOptionPane.INFORMATION_MESSAGE);
				sound.playSE(5);
				setValues();

			} else {

				JOptionPane.showMessageDialog(this, "You can't buy this object I ran out of this item", "Error", JOptionPane.ERROR_MESSAGE);

			}

		} else {

			JOptionPane.showMessageDialog(this, "You can't buy this object you have no gold", "Error", JOptionPane.ERROR_MESSAGE);

		}

    }//GEN-LAST:event_equipActionPerformed

    private void currentGoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentGoldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentGoldActionPerformed

	private void setValues() {
		merchantNames.setText(merchant.getName());
		priceSmall.setText(merchant.getPriceSmallObject() + " Gold");
		priceBig.setText(merchant.getPriceBigObject() + " Gold");
		priceEquip.setText(merchant.getPriceEquip() + " Gold");
		quantitySmall.setText(merchant.getQuantitySmallObject() + " Units");
		quantityBig.setText(merchant.getQuantityBigObject() + " Units");
		quantityEquip.setText(merchant.getQuantityEquip() + " Unit");
		currentGold.setText("Current Gold: " + mainCharacter.getGold());
	}

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
    private javax.swing.JTextField currentGold;
    private javax.swing.JLabel equipImg;
    private javax.swing.JButton exitMerchant;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel largeObjectImg;
    private javax.swing.JLabel merchantMan1;
    private javax.swing.JLabel merchantNames;
    private javax.swing.JTextField priceBig;
    private javax.swing.JTextField priceEquip;
    private javax.swing.JTextField priceSmall;
    private javax.swing.JTextField quantityBig;
    private javax.swing.JTextField quantityEquip;
    private javax.swing.JTextField quantitySmall;
    private javax.swing.JButton smallObject;
    private javax.swing.JButton smallObject1;
    private javax.swing.JLabel smallObjectimg;
    private javax.swing.JSpinner spinnerBig;
    private javax.swing.JSpinner spinnerSmall;
    // End of variables declaration//GEN-END:variables
}
