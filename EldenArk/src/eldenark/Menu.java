package eldenark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author cep
 */
public class Menu extends javax.swing.JFrame {

	/**
	 * Creates new form Menu
	 */
	
	public Menu() {
		
	
		initComponents();
		JLabel background = new JLabel();
		this.add(background);
		background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/MENU BACKGROUND.jpg")));
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

        jLabel1 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        continueButton = new javax.swing.JButton();
        leaderboardButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ELDEN ARK");
        setBackground(new java.awt.Color(0, 51, 51));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ELDEN ARK");

        startButton.setText("New Game");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        continueButton.setText("Continue");
        continueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueButtonActionPerformed(evt);
            }
        });

        leaderboardButton.setText("Leaderboard");
        leaderboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderboardButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(556, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(leaderboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(507, 507, 507))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(leaderboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
		// TODO add your handling code here:
		String username = JOptionPane.showInputDialog("Introduce your username");
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
		
		/*mainCharacter.setLevel(20);
		mainCharacter.getOtherStatsFromLevel(20);
		mainCharacter.setHp(mainCharacter.getMaxHP());
		mainCharacter.setMp(mainCharacter.getMaxMP());
		
		mainCharacter.changeEquip(mainCharacter.getEquipment(), mainCharacter.newWeapons[4]);
		mainCharacter.changeEquip(mainCharacter.getEquipment(), mainCharacter.newHelmets[4]);
		mainCharacter.changeEquip(mainCharacter.getEquipment(), mainCharacter.newChestPlates[4]);
		mainCharacter.changeEquip(mainCharacter.getEquipment(), mainCharacter.newLegArmors[4]);*/
		
		
		Gameplay g = new Gameplay(mainCharacter, 1);
    }//GEN-LAST:event_startButtonActionPerformed

    private void continueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueButtonActionPerformed
		// TODO add your handling code here:
		System.out.println("Continue");
		int i = 0;

		ArrayList<Gameplay> saves = BinaryFile.getSaves();
		String[] savedNames = new String[saves.size()];
		System.out.println("Chose your character");

		for (Gameplay a : saves) {

			savedNames[i] = a.mainCharacter.getNickname();
			i++;

			System.out.println(a.mainCharacter.getNickname());
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

		Warrior warrior = new Warrior(25, 15, 140, 140, 60, 60, 15, sex, generateInventory(), name);

		return warrior;

	}

	// Create a Mage object
	public static Mage createMage(String name, int sex) {

		Mage mage = new Mage(12, 5, 100, 100, 160, 160, 25, sex, generateInventory(), name);

		return mage;

	}

	// Create a Priest object
	public static Priest createPriest(String name, int sex) {

		Priest priest = new Priest(20, 10, 120, 120, 120, 120, 15, sex, generateInventory(), name);

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton leaderboardButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
