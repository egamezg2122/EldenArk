package eldenark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame {

	/**
	 * Creates new form Menu
	 */
    
        ImageIcon img = new ImageIcon("/FOTOS ELDEN ARK/icon.ico");
        
        
        
	private javax.swing.JTextField nicknameField;
	private javax.swing.JButton enterButton;
	private javax.swing.JButton exitSmallButton;
	private javax.swing.JRadioButton genderMale;
	private javax.swing.JRadioButton genderFemale;
	private javax.swing.JRadioButton warriorRadio;
	private javax.swing.JRadioButton mageRadio;
	private javax.swing.JRadioButton priestRadio;
	private javax.swing.JLabel warriorImg;
	private javax.swing.JLabel warriorMapImg;
	private javax.swing.JLabel mageImg;
	private javax.swing.JLabel mageMapImg;
	private javax.swing.JLabel priestImg;
	private javax.swing.JLabel priestMapImg;

	public Menu() {
		initC();
		initComponents();
		JLabel background = new JLabel();
		this.add(background);
                this.setIconImage(img.getImage());
		background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/MENUBKGRND.gif")));
		background.setBounds(0, 0, 800, 600);

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
        startButton = new javax.swing.JButton();
        continueButton = new javax.swing.JButton();
        leaderboardButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ELDEN ARK");
        setBackground(new java.awt.Color(0, 51, 51));
        setBounds(new java.awt.Rectangle(0, 25, 800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/TITLE.gif"))); // NOI18N

        startButton.setBackground(null);
        startButton.setForeground(null);
        startButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/NEWGAME.png"))); // NOI18N
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setOpaque(false);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        continueButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/CONTINUE.png"))); // NOI18N
        continueButton.setBorderPainted(false);
        continueButton.setContentAreaFilled(false);
        continueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueButtonActionPerformed(evt);
            }
        });

        leaderboardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/LEADERBOARD.png"))); // NOI18N
        leaderboardButton.setBorderPainted(false);
        leaderboardButton.setContentAreaFilled(false);
        leaderboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderboardButtonActionPerformed(evt);
            }
        });

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/EXIT.png"))); // NOI18N
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 224, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(continueButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leaderboardButton, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(219, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(leaderboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void initC() {
		nicknameField = new javax.swing.JTextField();
		enterButton = new javax.swing.JButton();
		exitSmallButton = new javax.swing.JButton();
		genderMale = new javax.swing.JRadioButton();
		genderFemale = new javax.swing.JRadioButton();
		warriorImg = new javax.swing.JLabel();
		warriorMapImg = new javax.swing.JLabel();
		mageImg = new javax.swing.JLabel();
		mageMapImg = new javax.swing.JLabel();
		priestImg = new javax.swing.JLabel();
		priestMapImg = new javax.swing.JLabel();
		warriorRadio = new javax.swing.JRadioButton();
		mageRadio = new javax.swing.JRadioButton();
		priestRadio = new javax.swing.JRadioButton();
		this.add(nicknameField);
		this.add(enterButton);
		this.add(exitSmallButton);
		this.add(genderMale);
		this.add(genderFemale);
		this.add(warriorImg);
		this.add(warriorMapImg);
		this.add(mageImg);
		this.add(mageMapImg);
		this.add(priestImg);
		this.add(priestMapImg);
		this.add(warriorRadio);
		this.add(mageRadio);
		this.add(priestRadio);
		nicknameField.setVisible(false);
		enterButton.setVisible(false);
		exitSmallButton.setVisible(false);
		genderMale.setVisible(false);
		genderFemale.setVisible(false);
		warriorImg.setVisible(false);
		warriorMapImg.setVisible(false);
		mageImg.setVisible(false);
		mageMapImg.setVisible(false);
		priestImg.setVisible(false);
		priestMapImg.setVisible(false);
		warriorRadio.setVisible(false);
		mageRadio.setVisible(false);
		priestRadio.setVisible(false);
                
                

	}

	private void genderMaleActionPerformed(java.awt.event.ActionEvent evt) {
		genderMale.setEnabled(false);
		genderFemale.setSelected(false);
		genderFemale.setEnabled(true);
		warriorImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Warrior.maleCombatPath)));
		warriorMapImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Warrior.maleMapLookingDownPath)));
		mageImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Mage.maleCombatPath)));
		mageMapImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Mage.maleMapLookingDownPath)));
		priestImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Priest.maleCombatPath)));
		priestMapImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Priest.maleMapLookingDownPath)));

	}

	private void genderFemaleActionPerformed(java.awt.event.ActionEvent evt) {
		genderFemale.setEnabled(false);
		genderMale.setSelected(false);
		genderMale.setEnabled(true);
		warriorImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Warrior.femaleCombatPath)));
		warriorMapImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Warrior.femaleMapLookingDownPath)));
		mageImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Mage.femaleCombatPath)));
		mageMapImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Mage.femaleMapLookingDownPath)));
		priestImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Priest.femaleCombatPath)));
		priestMapImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Priest.femaleMapLookingDownPath)));
		
	}

	private void warriorRadioActionPerformed(java.awt.event.ActionEvent evt) {
		warriorRadio.setEnabled(false);
		mageRadio.setSelected(false);
		mageRadio.setEnabled(true);
		priestRadio.setSelected(false);
		priestRadio.setEnabled(true);
	}

	private void mageRadioActionPerformed(java.awt.event.ActionEvent evt) {
		mageRadio.setEnabled(false);
		warriorRadio.setSelected(false);
		warriorRadio.setEnabled(true);
		priestRadio.setSelected(false);
		priestRadio.setEnabled(true);
	}

	private void priestRadioActionPerformed(java.awt.event.ActionEvent evt) {
		priestRadio.setEnabled(false);
		mageRadio.setSelected(false);
		mageRadio.setEnabled(true);
		warriorRadio.setSelected(false);
		warriorRadio.setEnabled(true);
	}

	private void setGenderRadio() {
		genderMale.setVisible(true);

		genderMale.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				genderMaleActionPerformed(evt);
			}
		});

		genderFemale.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				genderFemaleActionPerformed(evt);
			}
		});

		genderFemale.setVisible(true);
		genderMale.setText("Male");
		genderFemale.setText("Female");
		genderMale.setBounds(300, 460, 100, 30);
		genderFemale.setBounds(400, 460, 100, 30);
		genderMale.setSelected(true);
		genderMale.setEnabled(false);
                
                
                genderMale.setBackground(null);

                genderMale.setForeground(Color.WHITE);

                genderMale.setBorderPainted(false);
                
                genderMale.setOpaque(false);
                
                genderFemale.setBackground(null);

                genderFemale.setForeground(Color.WHITE);

                genderFemale.setBorderPainted(false);
                
                genderFemale.setOpaque(false);
	}

	private void setCharsLabels() {
		warriorImg.setVisible(true);
		warriorMapImg.setVisible(true);
		mageImg.setVisible(true);
		mageMapImg.setVisible(true);
		priestImg.setVisible(true);
		priestMapImg.setVisible(true);
		warriorRadio.setVisible(true);
		mageRadio.setVisible(true);
		priestRadio.setVisible(true);

		warriorImg.setBounds(0, 50, 200, 200);
		warriorMapImg.setBounds(100, 280, 30, 30);
		warriorRadio.setBounds(60, 320, 100, 30);
		mageImg.setBounds(300, 50, 200, 200);
		mageMapImg.setBounds(380, 280, 30, 30);
		mageRadio.setBounds(340, 320, 100, 30);
		priestImg.setBounds(600, 50, 200, 200);
		priestMapImg.setBounds(680, 280, 30, 30);
		priestRadio.setBounds(640, 320, 100, 30);

		warriorImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Warrior.maleCombatPath)));
		warriorMapImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Warrior.maleMapLookingDownPath)));
		mageImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Mage.maleCombatPath)));
		mageMapImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Mage.maleMapLookingDownPath)));
		priestImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Priest.maleCombatPath)));
		priestMapImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(Priest.maleMapLookingDownPath)));

                warriorRadio.setBackground(null);

                warriorRadio.setForeground(Color.WHITE);

                warriorRadio.setBorderPainted(false);
                
                warriorRadio.setOpaque(false);
                
                mageRadio.setBackground(null);

                mageRadio.setForeground(Color.WHITE);

                mageRadio.setBorderPainted(false);
                
                mageRadio.setOpaque(false);
                
                priestRadio.setBackground(null);

                priestRadio.setForeground(Color.WHITE);

                priestRadio.setBorderPainted(false);
                
                priestRadio.setOpaque(false);             
                
		warriorRadio.setText("Warrior");
		mageRadio.setText("Mage");
		priestRadio.setText("Priest");

		warriorRadio.setSelected(true);
		warriorRadio.setEnabled(false);

		warriorRadio.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				warriorRadioActionPerformed(evt);
			}
		});

		mageRadio.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mageRadioActionPerformed(evt);
			}
		});

		priestRadio.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				priestRadioActionPerformed(evt);
			}
		});

	}

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed

		// TODO add your handling code here:

		jLabel1.setVisible(false);
		exitButton.setVisible(false);
		continueButton.setVisible(false);
		startButton.setVisible(false);
		leaderboardButton.setVisible(false);


        
		/*
		this.remove(jLabel1);
		this.remove(exitButton);
		this.remove(continueButton);
		this.remove(startButton);
		this.remove(leaderboardButton);
		*/
                
                nicknameField.setBackground(null);

                nicknameField.setForeground(Color.WHITE);

                nicknameField.setOpaque(false);
		nicknameField.setVisible(true);
		nicknameField.setBounds(300, 500, 200, 20);
		nicknameField.setText("Nickname");

		enterButton.setVisible(true);
		exitSmallButton.setVisible(true);

		enterButton.setBounds(300, 530, 100, 30);
		exitSmallButton.setBounds(400, 530, 100, 30);

		enterButton.setText("Start");
		exitSmallButton.setText("Go back");

		setGenderRadio();

		setCharsLabels();
		

		enterButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				enterButtonActionPerformed(evt);
			}
		});
		exitSmallButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitSmallButtonActionPerformed(evt);
			}
		});

		
		/*
        String username = JOptionPane.showInputDialog(null, "Introduce your username");
        
        username = Gameplay.stringParser(username).trim();
        
        int sex = JOptionPane.showOptionDialog(this, "Choose your gender", "Gender", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, new String[]{"Male", "Female"}, "Male");
        int characterClass = JOptionPane.showOptionDialog(this, "Choose your class", "Class", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, new String[]{"Warrior", "Mage", "Priest"}, "Warrior");
        Character mainCharacter;
        switch (characterClass) {
            case 0:
                //CREATE WARRIOR
                mainCharacter = createWarrior(username, sex);
                break;
            case 1:
                //CREATE MAGE
                mainCharacter = createMage(username, sex);
                break;
            case 2:
                //CREATE PRIEST
                mainCharacter = createPriest(username, sex);
                break;
            default:
                mainCharacter = createWarrior(username, sex);
        }

        this.dispose();

        Gameplay g = new Gameplay(mainCharacter, 1);
		

		*/
    }//GEN-LAST:event_startButtonActionPerformed

	private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String username = nicknameField.getText();
		int sex = 1;
		Character mainCharacter;
		if (genderMale.isSelected()) {
			sex = 0;
		}
		if (warriorRadio.isSelected()) {
			mainCharacter = createWarrior(username, sex);
		} else if (mageRadio.isSelected()){
			mainCharacter = createMage(username, sex);
		} else{
			mainCharacter = createPriest(username, sex);
		}
		this.dispose();

                mainCharacter.getOtherStatsFromLevel(16);
        Gameplay g = new Gameplay(mainCharacter, 3);
		
		
	}
	
	private void exitSmallButtonActionPerformed (java.awt.event.ActionEvent evt) {
		jLabel1.setVisible(true);
		exitButton.setVisible(true);
		continueButton.setVisible(true);
		startButton.setVisible(true);
		leaderboardButton.setVisible(true);
		
		nicknameField.setVisible(false);
		enterButton.setVisible(false);
		exitSmallButton.setVisible(false);
		genderMale.setVisible(false);
		genderFemale.setVisible(false);
		warriorImg.setVisible(false);
		warriorMapImg.setVisible(false);
		mageImg.setVisible(false);
		mageMapImg.setVisible(false);
		priestImg.setVisible(false);
		priestMapImg.setVisible(false);
		warriorRadio.setVisible(false);
		mageRadio.setVisible(false);
		priestRadio.setVisible(false);
		
		warriorRadio.setEnabled(true);
		warriorRadio.setSelected(false);
		mageRadio.setEnabled(true);
		mageRadio.setSelected(false);
		priestRadio.setEnabled(true);
		priestRadio.setSelected(false);
		
		genderMale.setEnabled(true);
		genderMale.setSelected(false);
		genderFemale.setEnabled(true);
		genderFemale.setSelected(false);
	}
	
    private void continueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueButtonActionPerformed
		// TODO add your handling code here:

		int i = 0;

		ArrayList<Gameplay> saves = BinaryFile.getSaves();
		String[] savedNames = new String[saves.size()];

		for (Gameplay a : saves) {

			savedNames[i] = a.mainCharacter.getNickname();
			i++;

		}
		int option = JOptionPane.showOptionDialog(this, "Choose your game", "Load game", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, savedNames, "1");
                
		if (option >= 0) {
			this.dispose();
			saves.get(option).setFrame();
		}


    }//GEN-LAST:event_continueButtonActionPerformed

    private void leaderboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderboardButtonActionPerformed
		// TODO add your handling code here:
		this.dispose();
		GameEndFrame leaderboard = new GameEndFrame("LEADERBOARD");
		leaderboard.setVisible(true);
    }//GEN-LAST:event_leaderboardButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
		this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

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
			java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Menu().setVisible(true);
			}
		});
	}

	/* ************************************************************
     *                                                            *
     *                     CLASS GENERATORS                       *
     *                                                            *
     **************************************************************/
	// Create a Warrior object
	public static Warrior createWarrior(String name, int sex) {

		Warrior warrior = new Warrior(30, 20, 200, 200, 100, 100, 15, sex, generateInventory(), name);

		return warrior;

	}

	// Create a Mage object
	public static Mage createMage(String name, int sex) {

		Mage mage = new Mage(15, 8, 120, 120, 240, 240, 30, sex, generateInventory(), name);

		return mage;

	}

	// Create a Priest object
	public static Priest createPriest(String name, int sex) {

		Priest priest = new Priest(25, 17, 180, 180, 180, 180, 55, sex, generateInventory(), name);

		return priest;

	}

	// Function to generate inventory
	public static Object[] generateInventory() {

		Potion smallHealing = new Potion("Small Healing Potion", 30, "healing", "It restores 30% health of your max HP", 2);

		Potion largeHealing = new Potion("Large Healing Potion", 50, "healing", "It restores 50% health of your max HP", 0);

		Potion smallMana = new Potion("Small Mana Potion", 30, "mana", "It restores 30% mana of your max MP", 2);

		Potion largeMana = new Potion("Large Mana Potion", 50, "mana", "It restores 50% mana of your max MP", 0);

		Object[] inventory = new Object[4];

		inventory[0] = smallHealing;

		inventory[1] = largeHealing;

		inventory[2] = smallMana;

		inventory[3] = largeMana;

		return inventory;

	}

	public static Object[] reDoInventory(int obj1, int obj2, int obj3, int obj4) {

		Potion smallHealing = new Potion("Small Healing Potion", 30, "healing", "It restores 30% health of your max HP", obj1);

		Potion largeHealing = new Potion("Large Healing Potion", 50, "healing", "It restores 50% health of your max HP", obj2);

		Potion smallMana = new Potion("Small Mana Potion", 30, "mana", "It restores 30% mana of your max MP", obj3);

		Potion largeMana = new Potion("Large Mana Potion", 50, "mana", "It restores 50% mana of your max MP", obj4);

		Object[] inventory = new Object[4];

		inventory[0] = smallHealing;

		inventory[1] = largeHealing;

		inventory[2] = smallMana;

		inventory[3] = largeMana;

		return inventory;
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continueButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton leaderboardButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
