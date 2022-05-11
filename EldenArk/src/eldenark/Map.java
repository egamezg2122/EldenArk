package eldenark;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Map extends JFrame implements ActionListener {

    static final int SCREEN_WIDTH = 1200;
    static final int SCREEN_HEIGHT = 600;
	static final int ACTUAL_SCREEN_WIDTH = 1205;
    static final int ACTUAL_SCREEN_HEIGHT = 700;
	static final int LABEL_SIZE = 30;
	static final int NUM_TILES_X = SCREEN_WIDTH / LABEL_SIZE;
	static final int NUM_TILES_Y = SCREEN_HEIGHT / LABEL_SIZE;
	
	private JLabel[][] solidTiles = new JLabel[NUM_TILES_Y][NUM_TILES_X];
	
	private JLabel[] spikes = new JLabel[10];
	
	private JLabel[] minorBosses = new JLabel[4];
	
	private JLabel finalBoss;
	
	private JLabel mainCharacterLabel;
	
	private JLabel[] moveOptions = new JLabel[5];
	
	private JMenuBar frameMenu = new JMenuBar();
	
	private JMenu gameOption;
	
	private JMenuItem save, exit;

    Map() {
		
		

        this.setPreferredSize(new Dimension(ACTUAL_SCREEN_WIDTH, ACTUAL_SCREEN_HEIGHT));
        
         
        //this.addKeyListener(new MyKeyAdapter());
		
		spawnMainCharacter();
		
		spawnMobs();
		
		setSpikes();
		
		setMap();
		
		this.pack();
		
		setOptions();
		
		
		
		this.getContentPane().setBackground(Color.BLACK);
		
		this.setResizable(false);
		
		this.setJMenuBar(frameMenu);
		
		setMenu();

    }

    public void startGame() {

    }

	private void setMap() {
		
		
		for (int i = 0; i < NUM_TILES_Y; i++) {
			for (int j = 0; j < NUM_TILES_X; j++) {
				solidTiles[i][j] = new javax.swing.JLabel();
				this.add(solidTiles[i][j]);
				solidTiles[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/MAP/SUELO.png"))); // NOI18N
				solidTiles[i][j].setBounds(LABEL_SIZE*j, LABEL_SIZE*i, LABEL_SIZE, LABEL_SIZE);
				/*
				solidTiles[i][j].setMaximumSize(new java.awt.Dimension(30, 30));
				solidTiles[i][j].setMinimumSize(new java.awt.Dimension(30, 30));
*/
				solidTiles[i][j].setName("SOLID TILE"); // NOI18N
				
				
			}
		}
		JLabel finalSolidTile = new JLabel();
		this.add(finalSolidTile);
		finalSolidTile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/MAP/SUELO.png"))); // NOI18N
		finalSolidTile.setBounds(SCREEN_WIDTH, SCREEN_HEIGHT, LABEL_SIZE, LABEL_SIZE);
		
		
		
	}

	private void setOptions() {
		for (int i = 0; i < moveOptions.length; i++) {
			moveOptions[i] = new JLabel();
			this.add(moveOptions[i]);
			moveOptions[i].setForeground(Color.WHITE);
		}
		moveOptions[0].setText("W - Upwards");
		moveOptions[1].setText("A - Left");
		moveOptions[2].setText("S - Downwards");
		moveOptions[3].setText("D - Right");
		
		moveOptions[0].setBounds(200, 600, 300, 30);
		moveOptions[1].setBounds(0, 615, 300, 30);
		moveOptions[2].setBounds(200, 615, 300, 30);
		moveOptions[3].setBounds(400, 615, 300, 30);
		
		
		/*	
		JLabel moveOptions = new JLabel();
		this.add(moveOptions);
		String text = "\nQ - Stats\tW - Upwards\tE - Equip\tR - Loot\nA - Left\tS - Downwards\tD - Right\t0 - Exit Game\nI - Inventory";
		moveOptions.setText(text);
		moveOptions.setName("Move Options");
		moveOptions.setBounds(0, 600, 1200, 30);
		moveOptions.setForeground(Color.WHITE);
		*/
		
	}

	private void setMenu() {
		gameOption = new JMenu("Game");
        frameMenu.add(gameOption);
		save = new JMenuItem("Save");
		exit = new JMenuItem("Exit");
		save.addActionListener(this);
		exit.addActionListener(this);
		gameOption.add(save);
		gameOption.add(exit);
		
	}
	
	private void spawnMainCharacter() {
		mainCharacterLabel = new JLabel();
		this.add(mainCharacterLabel);
		mainCharacterLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/WARRIOR/WARRIOR_M_BACK.png"))); // NOI18N
		mainCharacterLabel.setBounds((LABEL_SIZE*12) - 2, LABEL_SIZE*12, LABEL_SIZE, LABEL_SIZE);
		mainCharacterLabel.setName("Spikes"); // NOI18N
		
	}
	
	private void setSpikes() {
		for (int i = 0; i < spikes.length; i++) {
			spikes[i] = new javax.swing.JLabel();
			this.add(spikes[i]);
			spikes[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/MAP/SPIKE.png"))); // NOI18N
			spikes[i].setBounds(LABEL_SIZE, LABEL_SIZE*i , LABEL_SIZE, LABEL_SIZE);
			spikes[i].setName("Spikes"); // NOI18N
				
		}
	}
	
	private void spawnMobs(){
		//FALTAN FOTOS
		
		for (int i = 0; i < 4; i++) {
			minorBosses[i] = new javax.swing.JLabel();
			this.add(minorBosses[i]);
			minorBosses[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/MAP/sPIKE.png"))); // NOI18N
			minorBosses[i].setBounds(LABEL_SIZE, LABEL_SIZE*2*i, LABEL_SIZE, LABEL_SIZE);
			minorBosses[i].setName("Minor Boss"); // NOI18N
		}
	}
	
	
	
	
	
	@Override
	 public void actionPerformed(ActionEvent e) {
        if (e.getSource()==save) {
            //Save WORK IN PROGRESS
        }
        if (e.getSource()==exit) {
            this.dispose();
        }
    }

	

    

}
