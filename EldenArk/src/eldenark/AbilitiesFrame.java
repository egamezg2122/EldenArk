/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eldenark;

import static eldenark.EldenArk.rn;

/**
 *
 * @author cep
 */
public class AbilitiesFrame extends javax.swing.JFrame {

	/**
	 * Creates new form AbilitiesFrame
	 */
	Character mainCharacter;
	Character enemy;
	Combat combat;

	public AbilitiesFrame(Character mainCharacter, Character enemy, Combat combat) {
		this.mainCharacter = mainCharacter;
		this.enemy = enemy;
		this.combat = combat;
		initComponents();
		abilitiesNames();
		showAbilities();

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
        ab2Button = new javax.swing.JButton();
        ab4Button = new javax.swing.JButton();
        ab1Button = new javax.swing.JButton();
        ab3Button = new javax.swing.JButton();
        abilityDesc = new javax.swing.JTextField();
        abilityDesc2 = new javax.swing.JTextField();

        ab2Button.setText("Ability2");
        ab2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ab2ButtonActionPerformed(evt);
            }
        });

        ab4Button.setText("Ability4");
        ab4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ab4ButtonActionPerformed(evt);
            }
        });

        ab1Button.setText("Ability1");
        ab1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ab1ButtonActionPerformed(evt);
            }
        });

        ab3Button.setText("Ability3");
        ab3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ab3ButtonActionPerformed(evt);
            }
        });

        abilityDesc.setEditable(false);

        abilityDesc2.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(abilityDesc2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(abilityDesc)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ab3Button, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                            .addComponent(ab1Button, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                            .addComponent(ab4Button, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                            .addComponent(ab2Button, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ab1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ab2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ab3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ab4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(abilityDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(abilityDesc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ab2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ab2ButtonActionPerformed
		int enemyDef, charDef;
		enemyDef = enemy.getDefence();
		charDef = mainCharacter.getDefence();
		int enemyOption = rn.nextInt(2);
		if (enemyOption == 0) {
			enemy.setDefence((int) (enemy.getDefence() * 1.3));
			abilityDesc.setText("The enemy auments his defence");
		}
		if (mainCharacter.getMp() >= 40) {

			int damageDone = ((mainCharacter.getSpecialDamage() * 5) - enemy.getDefence());

			enemy.setHp(enemy.getHp() - damageDone);

			mainCharacter.setMp(mainCharacter.getMp() - 40);
			mainCharacter.setDefence(charDef);
			enemy.setDefence(enemyDef);
			combat.recheckValues();
			abilityDesc.setText("You used " + mainCharacter.abilities[1] + " on the enemy.");
			abilityDesc2.setText("You did " + damageDone + " damage to the enemy.");

		} else {
			mainCharacter.setDefence(charDef);
			enemy.setDefence(enemyDef);
			System.out.println("You don't have mana");
		}
    }//GEN-LAST:event_ab2ButtonActionPerformed

    private void ab1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ab1ButtonActionPerformed
		int enemyDef, charDef;
		enemyDef = enemy.getDefence();
		charDef = mainCharacter.getDefence();
		int enemyOption = rn.nextInt(2);
		if (enemyOption == 0) {
			enemy.setDefence((int) (enemy.getDefence() * 1.3));
			abilityDesc.setText("The enemy auments his defence");
		}
		if (mainCharacter.getMp() >= 20) {

			int damageDone = ((mainCharacter.getSpecialDamage() * 4) - enemy.getDefence());

			enemy.setHp(enemy.getHp() - damageDone);

			mainCharacter.setMp(mainCharacter.getMp() - 20);
			mainCharacter.setDefence(charDef);
			enemy.setDefence(enemyDef);
			combat.recheckValues();
			abilityDesc.setText("You used " + mainCharacter.abilities[0] + " on the enemy.");
			abilityDesc2.setText("You did " + damageDone + " damage to the enemy.");

		} else {
			mainCharacter.setDefence(charDef);
			enemy.setDefence(enemyDef);
			System.out.println("You don't have mana");
		}
    }//GEN-LAST:event_ab1ButtonActionPerformed

    private void ab3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ab3ButtonActionPerformed
		int enemyDef, charDef;
		enemyDef = enemy.getDefence();
		charDef = mainCharacter.getDefence();
		int enemyOption = rn.nextInt(2);
		if (enemyOption == 0) {
			enemy.setDefence((int) (enemy.getDefence() * 1.3));
			abilityDesc.setText("The enemy auments his defence");
		}
		if (mainCharacter.getMp() >= 60) {

			int damageDone = ((mainCharacter.getSpecialDamage() * 6) - enemy.getDefence());

			enemy.setHp(enemy.getHp() - damageDone);

			mainCharacter.setMp(mainCharacter.getMp() - 60);
			mainCharacter.setDefence(charDef);
			enemy.setDefence(enemyDef);
			combat.recheckValues();
			abilityDesc.setText("You used " + mainCharacter.abilities[2] + " on the enemy.");
			abilityDesc2.setText("You did " + damageDone + " damage to the enemy.");

		} else {
			mainCharacter.setDefence(charDef);
			enemy.setDefence(enemyDef);
			System.out.println("You don't have mana");
		}
    }//GEN-LAST:event_ab3ButtonActionPerformed

    private void ab4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ab4ButtonActionPerformed
		int enemyDef, charDef;
		enemyDef = enemy.getDefence();
		charDef = mainCharacter.getDefence();
		int enemyOption = rn.nextInt(2);
		if (enemyOption == 0) {
			enemy.setDefence((int) (enemy.getDefence() * 1.3));
			abilityDesc.setText("The enemy auments his defence");
		}
		if (mainCharacter.getMp() >= 80) {

			int damageDone = ((mainCharacter.getSpecialDamage() * 7) - enemy.getDefence());

			enemy.setHp(enemy.getHp() - damageDone);

			mainCharacter.setMp(mainCharacter.getMp() - 80);
			mainCharacter.setDefence(charDef);
			enemy.setDefence(enemyDef);
			combat.recheckValues();
			abilityDesc.setText("You used " + mainCharacter.abilities[0] + " on the enemy.");
			abilityDesc2.setText("You did " + damageDone + " damage to the enemy.");

		} else {
			mainCharacter.setDefence(charDef);
			enemy.setDefence(enemyDef);
			System.out.println("You don't have mana");
		}
    }//GEN-LAST:event_ab4ButtonActionPerformed

	private void showAbilities() {
		ab1Button.setVisible(true);
		ab2Button.setVisible(false);
		ab3Button.setVisible(false);
		ab4Button.setVisible(false);
		if (mainCharacter.getLevel() >= 5) {
			ab2Button.setVisible(true);
		} else if (mainCharacter.getLevel() >= 10) {
			ab3Button.setVisible(true);
		} else if (mainCharacter.getLevel() >= 15) {
			ab4Button.setVisible(true);
		}
	}

	private void abilitiesNames() {
		ab1Button.setText(mainCharacter.abilities[0] + "\n20 Mana");
		ab2Button.setText(mainCharacter.abilities[1] + "\n40 Mana");
		ab3Button.setText(mainCharacter.abilities[2] + "\n60 Mana");
		ab4Button.setText(mainCharacter.abilities[3] + "\n80 Mana");
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
			java.util.logging.Logger.getLogger(AbilitiesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AbilitiesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AbilitiesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AbilitiesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
		public void run() {
		new AbilitiesFrame().setVisible(true);
		}
		});*/
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ab1Button;
    private javax.swing.JButton ab2Button;
    private javax.swing.JButton ab3Button;
    private javax.swing.JButton ab4Button;
    private javax.swing.JTextField abilityDesc;
    private javax.swing.JTextField abilityDesc2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
