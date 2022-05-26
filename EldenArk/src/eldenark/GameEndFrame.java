/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eldenark;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author cep
 */
public class GameEndFrame extends javax.swing.JFrame {

	ArrayList<JLabel> data = new ArrayList<>();
	String mode;
	Character mainCharacter;
	Database db;
	private final int MAX_LEADERBOARD = 8;

	/**
	 * Creates new form NewJFrame
	 */
	public GameEndFrame(Character mainCharacter, String mode) {
		this.mainCharacter = mainCharacter;
		this.mode = mode;
		initComponents();
		this.getContentPane().setBackground(Color.DARK_GRAY);
		conectToDatabase();
		saveData();
		getData();
		closeDB();
	}
	
	public GameEndFrame(String mode) {
		this.mode = mode;
		initComponents();
		this.getContentPane().setBackground(Color.DARK_GRAY);
		conectToDatabase();
		getData();
		closeDB();
	}

	private void closeDB() {
		try {
			db.close();
		} catch (SQLException ex) {
			Logger.getLogger(GameEndFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void conectToDatabase() {
		try {
			db = new Database();

		} catch (SQLException ex) {
			Logger.getLogger(GameEndFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void saveData() {
		try {
			db.insert(mainCharacter.getNickname(), mainCharacter.getLevel(), mainCharacter.getCharacterLookingDown());
		} catch (SQLException ex) {
			Logger.getLogger(GameEndFrame.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void getData() {
		// NOMBRE - NIVEL - IMG
		try {
			int i = 0;
			ArrayList<String> nicknames = db.getNicknameData();
			ArrayList<Integer> levels = db.getLevelData();
			ArrayList<String> path = db.getPathData();
			
			setLeaderboard();
			
			do{
				JLabel nickname = new JLabel();
				JLabel level = new JLabel();
				JLabel image = new JLabel();
				this.add(nickname);
				this.add(level);
				this.add(image);

				nickname.setForeground(Color.WHITE);
				level.setForeground(Color.WHITE);

				nickname.setText(nicknames.get(i));
				level.setText(levels.get(i).toString());
				image.setIcon(new javax.swing.ImageIcon(getClass().getResource(path.get(i))));

				nickname.setBounds(520, 200 + (50 * i), 100, 100);
				level.setBounds(620, 200 + (50 * i), 100, 100);
				image.setBounds(720, 200 + (50 * i), 100, 100);

				i++;
			} while(i < nicknames.size() && i < MAX_LEADERBOARD);

			
		} catch (SQLException ex) {
			Logger.getLogger(GameEndFrame.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void setLeaderboard() {
		JLabel nickname = new JLabel();
		JLabel level = new JLabel();
		JLabel image = new JLabel();
		this.add(nickname);
		this.add(level);
		this.add(image);

		nickname.setForeground(Color.WHITE);
		level.setForeground(Color.WHITE);
		image.setForeground(Color.WHITE);

		nickname.setText("NICKNAME");
		level.setText("LEVEL");
		image.setText("IMAGE");

		nickname.setBounds(520, 150, 100, 100);
		level.setBounds(620, 150, 100, 100);
		image.setBounds(720, 150, 100, 100);

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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LeaderBoard");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.lightGray);
        setPreferredSize(new java.awt.Dimension(1265, 700));
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(mode);
        jLabel1.setToolTipText("You lost jijiji");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton1.setText("Go to menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 477, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
		this.dispose();
		Menu menu = new Menu();
		menu.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
			java.util.logging.Logger.getLogger(GameEndFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GameEndFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GameEndFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GameEndFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				//new GameOver().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
