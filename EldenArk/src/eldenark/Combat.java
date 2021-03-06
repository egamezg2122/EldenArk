/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eldenark;

import static eldenark.EldenArk.rn;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author cep
 */



public class Combat extends javax.swing.JFrame {
        Sound sound = new Sound();
	Gameplay game;
	Character mainCharacter;
	Character enemy;

	/**
	 * Creates new form NewJFrame
	 */
	public Combat(Character mainCharacter, Character enemy, Gameplay game) {
                
		this.mainCharacter = mainCharacter;
		this.enemy = enemy;
		this.game = game;
		initComponents();
		setInitialValues();
		jPanel2.setBackground(Color.GRAY);
		jPanel1.setBackground(Color.DARK_GRAY);
		this.getContentPane().setBackground(Color.DARK_GRAY);
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
        attackButton = new javax.swing.JButton();
        abilitiesButton = new javax.swing.JButton();
        defendButton = new javax.swing.JButton();
        objectsButton = new javax.swing.JButton();
        textoAttack = new javax.swing.JLabel();
        textDesc = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        mpUser = new javax.swing.JLabel();
        hpUser = new javax.swing.JLabel();
        hpUserPBar = new javax.swing.JProgressBar();
        mpUserPBar = new javax.swing.JProgressBar();
        swordsPhoto = new javax.swing.JLabel();
        mpEnemyPBar = new javax.swing.JProgressBar();
        hpEnemyPBar = new javax.swing.JProgressBar();
        hpEnemy = new javax.swing.JLabel();
        mpEnemy = new javax.swing.JLabel();
        enemysName = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        userPhoto = new javax.swing.JLabel();
        enemyPhoto = new javax.swing.JLabel();
        textEnemy1 = new javax.swing.JTextField();
        textEnemy2 = new javax.swing.JTextField();
        hpNumbers = new javax.swing.JLabel();
        mpNumbers = new javax.swing.JLabel();
        mpNumbersEnemy = new javax.swing.JLabel();
        hpNumbersEnemy = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Combat");
        setAutoRequestFocus(false);
        setBackground(java.awt.Color.red);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1205, 900));
        setResizable(false);

        attackButton.setText("Attack");
        attackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attackButtonActionPerformed(evt);
            }
        });

        abilitiesButton.setText("Abilities");
        abilitiesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abilitiesButtonActionPerformed(evt);
            }
        });

        defendButton.setText("Defend");
        defendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defendButtonActionPerformed(evt);
            }
        });

        objectsButton.setText("Objects");
        objectsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objectsButtonActionPerformed(evt);
            }
        });

        textoAttack.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        textDesc.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(objectsButton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(defendButton)
                        .addComponent(abilitiesButton)
                        .addComponent(attackButton)))
                .addGap(27, 27, 27)
                .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(textoAttack, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {abilitiesButton, attackButton, defendButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoAttack, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(attackButton)
                            .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(defendButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(objectsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(abilitiesButton)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        mpUser.setText("MP");

        hpUser.setText("HP");

        hpUserPBar.setForeground(new java.awt.Color(51, 255, 51));
        hpUserPBar.setValue(100);

        mpUserPBar.setForeground(new java.awt.Color(51, 51, 255));
        mpUserPBar.setValue(100);

        swordsPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/swords.jpg"))); // NOI18N
        swordsPhoto.setFocusable(false);
        swordsPhoto.setRequestFocusEnabled(false);
        swordsPhoto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                swordsPhotoKeyPressed(evt);
            }
        });

        mpEnemyPBar.setForeground(new java.awt.Color(51, 51, 255));
        mpEnemyPBar.setValue(100);

        hpEnemyPBar.setForeground(new java.awt.Color(51, 255, 51));
        hpEnemyPBar.setValue(100);

        hpEnemy.setText("HP");

        mpEnemy.setText("MP");

        enemysName.setText(enemy.getNickname());

        username.setText(mainCharacter.getNickname() + " (" + mainCharacter.getClass().getName().substring(9) + ")");

        userPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource(mainCharacter.getMainCharacterImg())));

        enemyPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource(enemy.getEnemyImg())));
        enemyPhoto.setMaximumSize(new java.awt.Dimension(200, 200));

        textEnemy1.setEditable(false);
        textEnemy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEnemy1ActionPerformed(evt);
            }
        });

        textEnemy2.setEditable(false);
        textEnemy2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEnemy2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hpUser)
                            .addComponent(mpUser))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(mpUserPBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mpNumbers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(hpUserPBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hpNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(userPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(username)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(enemysName)
                        .addGap(73, 73, 73))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(swordsPhoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(hpNumbersEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                    .addComponent(mpNumbersEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(hpEnemyPBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(hpEnemy))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(mpEnemyPBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(mpEnemy)))
                                .addGap(41, 41, 41))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textEnemy2, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                                    .addComponent(textEnemy1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enemyPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hpEnemyPBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hpEnemy)
                            .addComponent(hpNumbersEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mpEnemy)
                                    .addComponent(mpEnemyPBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(enemyPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(textEnemy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textEnemy2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(mpNumbersEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username)
                            .addComponent(enemysName))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hpUserPBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hpUser)
                            .addComponent(hpNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mpUser)
                                    .addComponent(mpUserPBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mpNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(userPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(swordsPhoto)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void swordsPhotoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_swordsPhotoKeyPressed
		// TODO add your handling code here:
    }//GEN-LAST:event_swordsPhotoKeyPressed

    private void attackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attackButtonActionPerformed
		int enemyDef, charDef;
		enemyDef = enemy.getDefence();
		charDef = mainCharacter.getDefence();
		int enemyOption = rn.nextInt(2);
		if (enemyOption == 0) {
                        sound.playSE(11);
			enemy.setDefence((int) (enemy.getDefence() * 1.3));
			textEnemy1.setText("The enemy aumented his defence");
			textEnemy2.setText("");
		}
		int damageDone = mainCharacter.getDamage() - enemy.getDefence();
		if (damageDone > 0) {
			enemy.setHp(enemy.getHp() - damageDone);
			textDesc.setText("You did " + damageDone + " damage.");
			//System.out.println("You did " + (damageDone) + " damage.");
		} else {
			textDesc.setText("You did 0 damage. The enemy's defense is to powerfull");
			//System.out.println("You did 0 damage. The enemy's defense is to powerfull");
		}
		combatStatus(enemyOption);
		recheckValues();
		mainCharacter.setDefence(charDef);
		enemy.setDefence(enemyDef);
    }//GEN-LAST:event_attackButtonActionPerformed

	protected void enemyAttacks() {
		int optionAttack;
		optionAttack = rn.nextInt(2);
		switch (optionAttack) {
			case 0:
				//BASIC ATTACK
                                
				enemyBasicAttack();
				break;
			case 1:
				//SPECIAL ABILITY
                                
				enemySpecialAbilities();

		}
	}

	private void enemyBasicAttack() {
                sound.playSE(10);

		int damageDone = enemy.getDamage() - mainCharacter.getDefence();
		//System.out.println("\nThe enemy used his basic attack.");
		textEnemy1.setText("The enemy used his basic attack");
		if (damageDone > 0) {
			mainCharacter.setHp(mainCharacter.getHp() - damageDone);
			textEnemy2.setText("The enemy did " + (damageDone) + " damage");
			//System.out.println("The enemy did " + (damageDone) + " damage.");
		} else {
			textEnemy2.setText("The enemy did 0 damage to you. Your defense is incredible");
			//System.out.println("The enemy did 0 damage to you. Your defense is incredible");
		}
	}

	private void enemySpecialAbilities() {
                sound.playSE(8);

		int damageDone = enemy.getSpecialDamage() - mainCharacter.getDefence();
		double enemyManaWasted;
		enemyManaWasted =  enemy.getMaxMP() * 0.3;
		if (enemy.getMp() >= enemyManaWasted) {
			if (damageDone > 0) {
				mainCharacter.setHp(mainCharacter.getHp() - damageDone);
				textEnemy1.setText("The enemy uses his special ability");
				textEnemy2.setText("The enemy did " + (damageDone) + " damage");
				//System.out.println("The enemy uses his special ability.");
				//System.out.println("The enemy did " + (damageDone) + " damage.");
			} else {
				textEnemy1.setText("The enemy uses his special ability");
				textEnemy2.setText("The enemy did 0 damage to you. Wow, how did you not get hurt!?");
				//System.out.println("The enemy uses his special ability.");
				//System.out.println("The enemy did 0 damage to you. Wow, how did you not get hurt!?");
			}
			enemy.setMp(enemy.getMp() - (int)enemyManaWasted);
			if (enemy.getMp() < 0) {
				enemy.setMp(0);
			}
		} else {
			enemyBasicAttack();
		}

	}

    private void defendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defendButtonActionPerformed
		int enemyDef, charDef;
		enemyDef = enemy.getDefence();
		charDef = mainCharacter.getDefence();
		int enemyOption = rn.nextInt(2);
		if (enemyOption == 0) {
			enemy.setDefence((int) (enemy.getDefence() * 1.3));
			textEnemy1.setText("The enemy aumented his defence");
			textEnemy2.setText("");
		}
		mainCharacter.setDefence((int) (charDef * 1.3));
		textDesc.setText("You aument your defence");
		combatStatus(enemyOption);

		recheckValues();
		mainCharacter.setDefence(charDef);
		enemy.setDefence(enemyDef);
    }//GEN-LAST:event_defendButtonActionPerformed

	protected void combatStatus(int enemyOption) {
		if (enemy.getHp() > 0 && mainCharacter.getHp() > 0) {
			if (enemyOption == 1) {
				enemyAttacks();
				if (mainCharacter.getHp() <= 0) {
					endCombat();
				}
			} else {
				textEnemy1.setText("The enemy aumented his defence");
				textEnemy2.setText("");
			}
		} else {
			endCombat();
		}
	}
    private void objectsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objectsButtonActionPerformed
		textDesc.setText("");
		textEnemy1.setText("");
		textEnemy2.setText("");
		PotionFrame potion = new PotionFrame(mainCharacter, enemy, this);
		potion.setVisible(true);
    }//GEN-LAST:event_objectsButtonActionPerformed

    private void abilitiesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abilitiesButtonActionPerformed
		AbilitiesFrame abilities = new AbilitiesFrame(mainCharacter, enemy, this);
		abilities.setVisible(true);
    }//GEN-LAST:event_abilitiesButtonActionPerformed

    private void textEnemy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEnemy1ActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_textEnemy1ActionPerformed

    private void textEnemy2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEnemy2ActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_textEnemy2ActionPerformed

	private void endCombat() {
		this.dispose();
		String textEndCombat = "";
		if (enemy.getHp() <= 0) {
			textEndCombat = "You have defeated " + enemy.getNickname() + "\nReturning to map...";
		} else if (mainCharacter.getHp() <= 0) {
			textEndCombat = "You have been defeated " + "\nEnding game...";
		}
		JOptionPane.showMessageDialog(this, textEndCombat);
		game.endBattle();
		this.dispose();
	}

	private void setInitialValues() {
		hpUserPBar.setMaximum(mainCharacter.getMaxHP());
		hpUserPBar.setValue(mainCharacter.getHp());
		mpUserPBar.setMaximum(mainCharacter.getMaxMP());
		mpUserPBar.setValue(mainCharacter.getMp());

		hpNumbers.setText(mainCharacter.getHp() + "/" + mainCharacter.getMaxHP());
		mpNumbers.setText(mainCharacter.getMp() + "/" + mainCharacter.getMaxMP());
		hpNumbersEnemy.setText(enemy.getHp() + "/" + enemy.getMaxHP());
		mpNumbersEnemy.setText(enemy.getMp() + "/" + enemy.getMaxMP());

		hpEnemyPBar.setMaximum(enemy.getMaxHP());
		hpEnemyPBar.setValue(enemy.getHp());
		mpEnemyPBar.setMaximum(enemy.getMaxMP());
		mpEnemyPBar.setValue(enemy.getMp());
	}

	protected void recheckValues() {
		mainCharacter.setHp(mainCharacter.checkMaxValues(mainCharacter.getHp(), mainCharacter.getMaxHP()));
		mainCharacter.setMp(mainCharacter.checkMaxValues(mainCharacter.getMp(), mainCharacter.getMaxMP()));
		hpUserPBar.setValue(mainCharacter.getHp());
		hpNumbers.setText(mainCharacter.getHp() + "/" + mainCharacter.getMaxHP());
		mpUserPBar.setValue(mainCharacter.getMp());
		mpNumbers.setText(mainCharacter.getMp() + "/" + mainCharacter.getMaxMP());
		hpEnemyPBar.setValue(enemy.getHp());
		hpNumbersEnemy.setText(enemy.getHp() + "/" + enemy.getMaxHP());
		mpEnemyPBar.setValue(enemy.getMp());
		mpNumbersEnemy.setText(enemy.getMp() + "/" + enemy.getMaxMP());
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
			java.util.logging.Logger.getLogger(Combat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Combat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Combat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Combat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
 /*
		java.awt.EventQueue.invokeLater(new Runnable() {
                        @Override
			public void run() {
				new Combat(mainCharacter, enemy).setVisible(true);
			}
		});
		 */
	}

	public JTextField getTextDesc() {
		return textDesc;
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abilitiesButton;
    private javax.swing.JButton attackButton;
    private javax.swing.JButton defendButton;
    private javax.swing.JLabel enemyPhoto;
    private javax.swing.JLabel enemysName;
    private javax.swing.JLabel hpEnemy;
    private javax.swing.JProgressBar hpEnemyPBar;
    private javax.swing.JLabel hpNumbers;
    private javax.swing.JLabel hpNumbersEnemy;
    private javax.swing.JLabel hpUser;
    private javax.swing.JProgressBar hpUserPBar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel mpEnemy;
    private javax.swing.JProgressBar mpEnemyPBar;
    private javax.swing.JLabel mpNumbers;
    private javax.swing.JLabel mpNumbersEnemy;
    private javax.swing.JLabel mpUser;
    private javax.swing.JProgressBar mpUserPBar;
    private javax.swing.JButton objectsButton;
    private javax.swing.JLabel swordsPhoto;
    private javax.swing.JTextField textDesc;
    private javax.swing.JTextField textEnemy1;
    private javax.swing.JTextField textEnemy2;
    private javax.swing.JLabel textoAttack;
    private javax.swing.JLabel userPhoto;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
