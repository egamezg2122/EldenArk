/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eldenark;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author cep
 */
public class Gameplay extends JFrame implements ActionListener {

	//Frame variables
	static final int SCREEN_WIDTH = 1200;
	static final int SCREEN_HEIGHT = 600;
	static final int ACTUAL_SCREEN_WIDTH = 1205;
	static final int ACTUAL_SCREEN_HEIGHT = 700;
	static final int LABEL_SIZE = 30;
	static final int NUM_TILES_X = SCREEN_WIDTH / LABEL_SIZE;
	static final int NUM_TILES_Y = SCREEN_HEIGHT / LABEL_SIZE;

	private JLabel[][] solidTiles = new JLabel[NUM_TILES_Y][NUM_TILES_X];

	private ArrayList<JLabel> spikes = new ArrayList<JLabel>();

	private JLabel[] minorBosses = new JLabel[4];

	private JLabel finalBoss;

	private JLabel mainCharacterLabel;

	private JLabel merchantLabel;

	private JLabel[] moveOptions = new JLabel[11];

	private JLabel information = new JLabel();

	private JMenuBar frameMenu = new JMenuBar();

	private JMenu gameOption;

	private JMenuItem save, exit;

	private String[] bossesPath = new String[4];

	private String mapPath;

	// GAMEPLAY VARIABLES
	int[][] map = new int[NUM_TILES_Y][NUM_TILES_X];
	static Random rn = new Random();
	Character mainCharacter = new Character();
	boolean running = false;
	boolean inMap = true;
	JFrame f;
	int floor;
	Merchant merchant;

	// VARIABLES FOR SAVING THE GAME
	static final int SIZE = 3324;
	static final int STRING_SIZE = 12;

	public Gameplay(Character mainCharacter, int floor) {
		this.mainCharacter = mainCharacter;
		this.floor = floor;
		createMap();
		running = true;
		//Creating and adding the key listener
		setFrame();
	}

	public Gameplay(Character mainCharacter, Merchant merchant, int[][] map, int floor) {
		this.mainCharacter = mainCharacter;
		this.merchant = merchant;
		this.map = map;
		this.floor = floor;

	}

	//FRAME METHODS
	public void setFrame() {
		setMapPath();
		MyKeyAdapter k;
		k = new MyKeyAdapter();
		this.addKeyListener(k);
		this.setPreferredSize(new Dimension(ACTUAL_SCREEN_WIDTH, ACTUAL_SCREEN_HEIGHT));

		spawnMainCharacter();

		spawnMobs();

		setMerchant();

		setSpikes();

		setMap();

		this.pack();

		setOptions();

		this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		this.setJMenuBar(frameMenu);
		this.setTitle("Map");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);

		setMenu();

	}

	private void setMapPath() {
		switch (floor) {
			case 1:
				mapPath = "/FOTOS ELDEN ARK/MAP/SUELO.png";
				break;
			case 2:
				mapPath = "/FOTOS ELDEN ARK/MAP/SUELO2.png";
				break;
			case 3:
				mapPath = "/FOTOS ELDEN ARK/MAP/SUELO3.png";
				break;
			case 4:
				mapPath = "/FOTOS ELDEN ARK/MAP/SUELO4.png";
				break;
		}
	}

	private void setInformation(String string) {

		moveOptions[moveOptions.length - 3].setText(string);

	}

	private void setSecondInformation(String string) {

		moveOptions[moveOptions.length - 2].setText(string);
	}

	private void setMap() {

		for (int i = 0; i < NUM_TILES_Y; i++) {
			for (int j = 0; j < NUM_TILES_X; j++) {
				solidTiles[i][j] = new javax.swing.JLabel();
				this.add(solidTiles[i][j]);
				solidTiles[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource(mapPath))); // NOI18N
				solidTiles[i][j].setBounds(LABEL_SIZE * j, LABEL_SIZE * i, LABEL_SIZE, LABEL_SIZE);
				solidTiles[i][j].setName("SOLID TILE"); // NOI18N
			}
		}
		JLabel finalSolidTile = new JLabel();
		this.add(finalSolidTile);
		finalSolidTile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/MAP/SUELO.png"))); // NOI18N
		finalSolidTile.setBounds(SCREEN_WIDTH, SCREEN_HEIGHT, LABEL_SIZE, LABEL_SIZE);

	}

	private void setMerchant() {
		merchantLabel = new javax.swing.JLabel();
		this.add(merchantLabel);
		merchantLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/MERCHANT/MERCHANT_MAP.png"))); // NOI18N
		merchantLabel.setBounds((LABEL_SIZE * merchant.getX()) - 2, LABEL_SIZE * merchant.getY(), LABEL_SIZE, LABEL_SIZE);
		merchantLabel.setName("SOLID TILE"); // NOI18N

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
		moveOptions[4].setText("Welcome to floor " + floor + "!");
		moveOptions[5].setText("Q - Stats");
		moveOptions[6].setText("E - Equipment");
		moveOptions[7].setText("R - Loot");

		moveOptions[0].setBounds(200, 600, 300, 30);
		moveOptions[1].setBounds(0, 615, 300, 30);
		moveOptions[2].setBounds(200, 615, 300, 30);
		moveOptions[3].setBounds(400, 615, 300, 30);
		moveOptions[5].setBounds(0, 600, 300, 30);
		moveOptions[6].setBounds(400, 600, 300, 30);
		moveOptions[7].setBounds(600, 600, 300, 30);

		moveOptions[moveOptions.length - 3].setBounds(800, 600, 300, 30);
		moveOptions[moveOptions.length - 2].setBounds(800, 615, 300, 30);

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
		mainCharacterLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(mainCharacter.getCharacterLookingDown()))); // NOI18N
		mainCharacterLabel.setBounds((LABEL_SIZE * mainCharacter.getX()) - 2, (LABEL_SIZE * mainCharacter.getY()), LABEL_SIZE, LABEL_SIZE);
		mainCharacterLabel.setName("MAIN CHARACTER LABEL"); // NOI18N

	}

	private void setSpikes() {
		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 10) {
					JLabel spike = new javax.swing.JLabel();
					spikes.add(spike);
					this.add(spikes.get(count));
					spikes.get(count).setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/MAP/SPIKE.png"))); // NOI18N
					spikes.get(count).setBounds(LABEL_SIZE * j, LABEL_SIZE * i, LABEL_SIZE, LABEL_SIZE);
					spikes.get(count).setName("Spikes"); // NOI18N
					count++;
				}
			}
		}
		/*
		for (int i = 0; i < spikes.length; i++) {
			spikes[i] = new javax.swing.JLabel();
			this.add(spikes[i]);
			spikes[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/MAP/SPIKE.png"))); // NOI18N
			spikes[i].setBounds(LABEL_SIZE, LABEL_SIZE*i , LABEL_SIZE, LABEL_SIZE);
			spikes[i].setName("Spikes"); // NOI18N
				
		}
		 */
	}

	private void spawnMobs() {
		//FALTAN FOTOS
		int counter = 0;
		setBossesPath();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] >= 4 && map[i][j] <= 6) {
					minorBosses[counter] = new javax.swing.JLabel();
					this.add(minorBosses[counter]);
					minorBosses[counter].setIcon(new javax.swing.ImageIcon(getClass().getResource(bossesPath[counter]))); // NOI18N
					minorBosses[counter].setBounds(((LABEL_SIZE * j) - 2), ((LABEL_SIZE * i) - 2), LABEL_SIZE, LABEL_SIZE);
					minorBosses[counter].setName("Minor Boss"); // NOI18N
					counter++;
				} else if (map[i][j] >= 7 && map[i][j] <= 9) {
					finalBoss = new javax.swing.JLabel();
					this.add(finalBoss);
					finalBoss.setIcon(new javax.swing.ImageIcon(getClass().getResource(bossesPath[bossesPath.length - 1]))); // NOI18N
					finalBoss.setBounds(((LABEL_SIZE * j) - 2), LABEL_SIZE * i, LABEL_SIZE, LABEL_SIZE);
					finalBoss.setName("Final Boss"); // NOI18N
				}
			}
		}
	}

	private void deleteMiniBoss() {
		for (int i = 0; i < 3; i++) {
			if ((mainCharacter.getY() * LABEL_SIZE) == (minorBosses[i].getY() + 2) && (mainCharacter.getX() * LABEL_SIZE) == (minorBosses[i].getX() + 2)) {
				this.remove(minorBosses[i]);
			}
		}

	}

	private void setBossesPath() {
		switch (floor) {
			case 1:
				setBosses1Floor();
				break;
			case 2:
				setBosses2Floor();
				break;
			case 3:
				setBosses3Floor();
				break;
			case 4:
				setBosses4Floor();
				break;
		}
	}

	private void setBosses1Floor() {

		int counter = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				switch (map[i][j]) {
					case 4:
						bossesPath[counter] = "/FOTOS ELDEN ARK/ENEMY MAP/1 FLOOR/MINIBOSS/MINIBOSS_WARRIOR_1.png";
						counter++;
						break;
					case 5:
						bossesPath[counter] = "/FOTOS ELDEN ARK/ENEMY MAP/1 FLOOR/MINIBOSS/MINIBOSS_MAGE_1.png";
						counter++;
						break;
					case 6:
						bossesPath[counter] = "/FOTOS ELDEN ARK/ENEMY MAP/1 FLOOR/MINIBOSS/MINIBOSS_PRIEST_1.png";
						counter++;
						break;
					case 7:
						bossesPath[bossesPath.length - 1] = "/FOTOS ELDEN ARK/ENEMY MAP/1 FLOOR/BOSS/BOSS_WARRIOR_1.png";
						break;
					case 8:
						bossesPath[bossesPath.length - 1] = "/FOTOS ELDEN ARK/ENEMY MAP/1 FLOOR/BOSS/BOSS_MAGE_1.png";
						break;
					case 9:
						bossesPath[bossesPath.length - 1] = "/FOTOS ELDEN ARK/ENEMY MAP/1 FLOOR/BOSS/BOSS_PRIEST_1.png";
						break;

				}
			}
		}
		/*
		for (int i = 0; i < (bossesPath.length - 1); i++) {
			switch (rn.nextInt(3)) {
				case 0:
					bossesPath[i] = "/FOTOS ELDEN ARK/ENEMY MAP/1 FLOOR/MINIBOSS/MINIBOSS_WARRIOR_1.png";
					break;
				case 1:
					bossesPath[i] = "/FOTOS ELDEN ARK/ENEMY MAP/1 FLOOR/MINIBOSS/MINIBOSS_MAGE_1.png";
					break;
				case 2:
					bossesPath[i] = "/FOTOS ELDEN ARK/ENEMY MAP/1 FLOOR/MINIBOSS/MINIBOSS_PRIEST_1.png";
					break;
				default:
					bossesPath[i] = "/FOTOS ELDEN ARK/ENEMY MAP/1 FLOOR/MINIBOSS/MINIBOSS_WARRIOR_1.png";
			}
		}
		
		switch (rn.nextInt(3)) {
			case 0:
				bossesPath[bossesPath.length - 1] = "/FOTOS ELDEN ARK/ENEMY MAP/1 FLOOR/BOSS/BOSS_WARRIOR_1.png";
				break;
			case 1:
				bossesPath[bossesPath.length - 1] = "/FOTOS ELDEN ARK/ENEMY MAP/1 FLOOR/BOSS/BOSS_MAGE_1.png";
				break;
			case 2:
				bossesPath[bossesPath.length - 1] = "/FOTOS ELDEN ARK/ENEMY MAP/1 FLOOR/BOSS/BOSS_PRIEST_1.png";
				break;
			default:
				bossesPath[bossesPath.length - 1] = "/FOTOS ELDEN ARK/ENEMY MAP/1 FLOOR/BOSS/BOSS_WARRIOR_1.png";
		}
		 */
	}

	private void setBosses2Floor() {
		int counter = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				switch (map[i][j]) {
					case 4:
						bossesPath[counter] = "/FOTOS ELDEN ARK/ENEMY MAP/2 FLOOR/MINIBOSS/MINIBOSS_WARRIOR_2.png";
						counter++;
						break;
					case 5:
						bossesPath[counter] = "/FOTOS ELDEN ARK/ENEMY MAP/2 FLOOR/MINIBOSS/MINIBOSS_MAGE_2.png";
						counter++;
						break;
					case 6:
						bossesPath[counter] = "/FOTOS ELDEN ARK/ENEMY MAP/2 FLOOR/MINIBOSS/MINIBOSS_PRIEST_2.png";
						counter++;
						break;
					case 7:
						bossesPath[bossesPath.length - 1] = "/FOTOS ELDEN ARK/ENEMY MAP/2 FLOOR/BOSS/BOSS_WARRIOR_2.png";
						break;
					case 8:
						bossesPath[bossesPath.length - 1] = "/FOTOS ELDEN ARK/ENEMY MAP/2 FLOOR/BOSS/BOSS_MAGE_2.png";
						break;
					case 9:
						bossesPath[bossesPath.length - 1] = "/FOTOS ELDEN ARK/ENEMY MAP/2 FLOOR/BOSS/BOSS_PRIEST_2.png";
						break;

				}
			}
		}

	}

	private void setBosses3Floor() {
		int counter = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				switch (map[i][j]) {
					case 4:
						bossesPath[counter] = "/FOTOS ELDEN ARK/ENEMY MAP/3 FLOOR/MINIBOSS/MINIBOSS_WARRIOR_3.png";
						counter++;
						break;
					case 5:
						bossesPath[counter] = "/FOTOS ELDEN ARK/ENEMY MAP/3 FLOOR/MINIBOSS/MINIBOSS_MAGE_3.png";
						counter++;
						break;
					case 6:
						bossesPath[counter] = "/FOTOS ELDEN ARK/ENEMY MAP/3 FLOOR/MINIBOSS/MINIBOSS_PRIEST_3.png";
						counter++;
						break;
					case 7:
						bossesPath[bossesPath.length - 1] = "/FOTOS ELDEN ARK/ENEMY MAP/3 FLOOR/BOSS/BOSS_WARRIOR_3.png";
						break;
					case 8:
						bossesPath[bossesPath.length - 1] = "/FOTOS ELDEN ARK/ENEMY MAP/3 FLOOR/BOSS/BOSS_MAGE_3.png";
						break;
					case 9:
						bossesPath[bossesPath.length - 1] = "/FOTOS ELDEN ARK/ENEMY MAP/3 FLOOR/BOSS/BOSS_PRIEST_3.png";
						break;

				}
			}
		}

	}

	private void setBosses4Floor() {
		int counter = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				switch (map[i][j]) {
					case 4:
						bossesPath[counter] = "/FOTOS ELDEN ARK/ENEMY MAP/4 FLOOR/MINIBOSS/MINIBOSS_WARRIOR_4.png";
						counter++;
						break;
					case 5:
						bossesPath[counter] = "/FOTOS ELDEN ARK/ENEMY MAP/4 FLOOR/MINIBOSS/MINIBOSS_MAGE_4.png";
						counter++;
						break;
					case 6:
						bossesPath[counter] = "/FOTOS ELDEN ARK/ENEMY MAP/4 FLOOR/MINIBOSS/MINIBOSS_PRIEST_4.png";
						counter++;
						break;
					case 7:
						bossesPath[bossesPath.length - 1] = "/FOTOS ELDEN ARK/ENEMY MAP/4 FLOOR/BOSS/BOSS_WARRIOR_4.png";
						break;
					case 8:
						bossesPath[bossesPath.length - 1] = "/FOTOS ELDEN ARK/ENEMY MAP/4 FLOOR/BOSS/BOSS_MAGE_4.png";
						break;
					case 9:
						bossesPath[bossesPath.length - 1] = "/FOTOS ELDEN ARK/ENEMY MAP/4 FLOOR/BOSS/BOSS_PRIEST_4.png";
						break;

				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == save) {
			//Save WORK IN PROGRESS
			BinaryFile.saveGame(this);
		}
		if (e.getSource() == exit) {
			this.dispose();
		}
	}

	// GENERATING THE MAP
	public void createMap() {
		/* 0 - Nothing
        1 - Loot
        2 - Enemy
		3 - Merchant
		4 - Minor Boss (Warrior)
		5 - Minor Boss (Mage)
		6 - Minor Boss (Priest)
		7 - Final Boss (Warrior)
		8 - Final Boss (Mage)
		9 - Final Boss (Priest)
		10 - Mountains
		 */

		generateLootTiles();
		generateEnemyTiles();

		for (int i = 0; i < 7; i++) {
			generateMountains();
		}
		generateMinorBoss();
		generateBoss();
		generateMerchant();

	}

	public void generateLootTiles() {
		int x, y, i = 0;
		do {
			x = rn.nextInt(map[2].length);
			y = rn.nextInt(map.length);
			if (checkUsageTile(x, y)) {
				map[y][x] = 1;
				i++;
			}
		} while (i < 30);
	}

	public void generateEnemyTiles() {
		int x, y, i = 0;
		do {
			x = rn.nextInt(map[i].length);
			y = rn.nextInt(map.length);
			if (checkUsageTile(x, y)) {
				map[y][x] = 2;
				i++;
			}
		} while (i < 20);
	}

	//Function to generate Mountains
	public void generateMountains() {
		int x, y, i, random, tempX, tempY;
		i = 0;
		//Check the first mountain tile
		do {
			x = rn.nextInt(NUM_TILES_X);
			y = rn.nextInt(NUM_TILES_Y);
		} while (!checkUsageTile(x, y));

		//Generation mountains close to each other
		for (int j = 0; j < 10; j++) {
			do {
				tempX = x;
				tempY = y;
				random = rn.nextInt(4);
				switch (random) {
					case 0:
						x++;
						break;
					case 1:
						x--;
						break;
					case 2:
						y++;
						break;
					case 3:
						y--;
						break;
				}
				try {
					map[y][x] = 10;
					i++;
				} catch (ArrayIndexOutOfBoundsException e) {
					x = tempX;
					y = tempY;
				}
			} while (i < 5);
		}

	}

	//Function to generate the location Minor Bosses
	public void generateMinorBoss() {
		int x, y, i = 0;
		do {
			x = rn.nextInt(map[i].length);
			y = rn.nextInt(map.length);
			if (checkUsageTile(x, y)) {
				map[y][x] = rn.nextInt(7 - 4) + 4;
				i++;
			}
		} while (i < 3);
	}

	//Function to generate the location of Final Boss
	public void generateBoss() {
		int x, y;
		boolean isUsable;
		do {
			x = rn.nextInt(map[0].length);
			y = rn.nextInt(map.length);
			isUsable = checkUsageTile(x, y);
			if (isUsable) {
				map[y][x] = rn.nextInt(10 - 7) + 7;
			}
		} while (!isUsable);
	}

	public void generateMerchant() {
		merchant = new Merchant(0, 0, floor, mainCharacter);
		int x, y;
		boolean isUsable;
		do {
			x = rn.nextInt(map[0].length);
			y = rn.nextInt(map.length);
			isUsable = checkUsageTile(x, y);
			if (isUsable) {
				map[y][x] = 3;
				merchant.setX(x);
				merchant.setY(y);
			}
		} while (!isUsable);

	}

	//Function to check if the tile does not containt special events
	public boolean checkUsageTile(int x, int y) {
		boolean isUsable = false;
		if (!(map[y][x] == 10 || map[y][x] == 4 || map[y][x] == 5 || map[y][x] == 6
				|| map[y][x] == 7 || map[y][x] == 8 || map[y][x] == 9 || (mainCharacter.getX() == x && mainCharacter.getY() == y))) {
			isUsable = true;
		}

		return isUsable;
	}

	// MOVING METHODS 
	public void tryToMoveUP() {
		try {
			if (map[mainCharacter.getY() - 1][mainCharacter.getX()] != 10) {
				mainCharacter.moveUP();
			} else {
				setInformation("You can't move there");
			}
		} catch (ArrayIndexOutOfBoundsException e) {

			setInformation("You're at the edge of the map.");

		}

	}

	public void tryToMoveDown() {
		try {
			if (map[mainCharacter.getY() + 1][mainCharacter.getX()] != 10) {
				mainCharacter.moveDown();

			} else {
				setInformation("You can't move there");
			}
		} catch (ArrayIndexOutOfBoundsException e) {

			setInformation("You're at the edge of the map.");
		}

	}

	public void tryToMoveRight() {
		try {
			if (map[mainCharacter.getY()][mainCharacter.getX() + 1] != 10) {
				mainCharacter.moveRight();

			} else {
				setInformation("You can't move there");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			setInformation("You're at the edge of the map.");
		}
	}

	public void tryToMoveLeft() {

		try {
			if (map[mainCharacter.getY()][mainCharacter.getX() - 1] != 10) {
				mainCharacter.moveLeft();

			} else {
				setInformation("You can't move there");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			setInformation("You're at the edge of the map.");
		}
	}

	public void checkNewTile() {

		setSecondInformation("");
		switch (map[mainCharacter.getY()][mainCharacter.getX()]) {
			case 1:
				setInformation("You found loot");
				break;

			case 2:
				
				startCombat();
				break;

			case 3:
				//Merchant
				/*merchant.trade();
				this.setVisible(true);
				reprint();*/
				break;
			case 4:
			case 5:
			case 6:
				
				startCombat();
				break;
			case 7:
			case 8:
			case 9:
				
				startCombat();
				break;

		}

	}

	public void newFloor() {
		this.setVisible(false);
		JOptionPane.showMessageDialog(this, "Good job defeating the final boss of " + floor + " floor.", "Information", JOptionPane.INFORMATION_MESSAGE);
		
		if (floor < 4) {
			JOptionPane.showMessageDialog(this, "You're now in the " + (floor + 1) + " floor. New adventures are comming.", "Information", JOptionPane.INFORMATION_MESSAGE);
			
			floor++;
			mainCharacter.setX(20);
			mainCharacter.setY(10);
			this.dispose();
			Gameplay newFloor = new Gameplay(mainCharacter, floor);

			//setFrame();
			//reprint();
		} else {
			this.dispose();
			running = false;
			GameEndFrame end = new GameEndFrame(mainCharacter, "WIN");
			end.setVisible(true);
			//EldenArk.win(mainCharacter.getNickname());
		}

	}

	public int checkEnemyLevel() {
		int level = 2;
		if (floor == 1) {
			switch (map[mainCharacter.getY()][mainCharacter.getX()]) {
				case 2:
					level = 2;
					break;
				case 4:
				case 5:
				case 6:
					level = 4;
					break;
				case 7:
				case 8:
				case 9:
					level = 5;
					break;
			}
		} else {
			switch (map[mainCharacter.getY()][mainCharacter.getX()]) {
				case 2:
					level = 5;
					break;
				case 4:
				case 5:
				case 6:
					level = 10;
					break;
				case 7:
				case 8:
				case 9:
					level = 20;
					break;
			}
		}

		return level * floor;
	}

	//Enemy creation
	public Character createEnemy(int difficulty) {

		Character enemy;
		int type;

		switch (map[mainCharacter.getY()][mainCharacter.getX()]) {
			case 2:
				type = 2;
				enemy = newNormalEnemy(type, difficulty);
				break;
			case 4:
				type = 4;
				enemy = new Warrior(20 * difficulty, 8 * difficulty, 70 * difficulty, 70 * difficulty, 50 * difficulty, 50 * difficulty, 14 * difficulty, type, floor);
				break;
			case 7:
				type = 7;
				enemy = new Warrior(20 * difficulty, 8 * difficulty, 70 * difficulty, 70 * difficulty, 50 * difficulty, 50 * difficulty, 14 * difficulty, type, floor);
				break;
			case 5:
				type = 4;
				enemy = new Mage(13 * difficulty, 4 * difficulty, 66 * difficulty, 66 * difficulty, 70 * difficulty, 70 * difficulty, 30 * difficulty, type, floor);
				break;
			case 8:
				type = 7;
				enemy = new Mage(13 * difficulty, 4 * difficulty, 66 * difficulty, 66 * difficulty, 70 * difficulty, 70 * difficulty, 30 * difficulty, type, floor);
				break;
			case 6:
				type = 4;
				enemy = new Priest(11 * difficulty, 6 * difficulty, 84 * difficulty, 84 * difficulty, 60 * difficulty, 60 * difficulty, 25 * difficulty, type, floor);
				break;
			case 9:
				type = 7;
				enemy = new Priest(11 * difficulty, 6 * difficulty, 84 * difficulty, 84 * difficulty, 60 * difficulty, 60 * difficulty, 25 * difficulty, type, floor);
				break;
			default:
				type = 4;
				enemy = new Warrior(20 * difficulty, 8 * difficulty, 70 * difficulty, 70 * difficulty, 50 * difficulty, 50 * difficulty, 14 * difficulty, type, floor);
		}

		return enemy;
	}

	private Character newNormalEnemy(int type, int difficulty) {
		Character enemy;
		switch (rn.nextInt(3)) {
			case 0:
				enemy = new Warrior(20 * difficulty, 8 * difficulty, 70 * difficulty, 70 * difficulty, 50 * difficulty, 50 * difficulty, 14 * difficulty, type, floor);
				break;
			case 1:
				enemy = new Mage(13 * difficulty, 4 * difficulty, 66 * difficulty, 66 * difficulty, 70 * difficulty, 70 * difficulty, 30 * difficulty, type, floor);
				break;
			case 2:
				enemy = new Priest(11 * difficulty, 6 * difficulty, 84 * difficulty, 84 * difficulty, 60 * difficulty, 60 * difficulty, 25 * difficulty, type, floor);
				break;
			default:
				enemy = new Warrior(20 * difficulty, 8 * difficulty, 70 * difficulty, 70 * difficulty, 50 * difficulty, 50 * difficulty, 14 * difficulty, type, floor);

		}
		return enemy;
	}

	public void startCombat() {
		this.setVisible(false);
		int combatLevel = checkEnemyLevel();
		Character enemy = createEnemy(combatLevel);
		Combat c = new Combat(mainCharacter, enemy, this);
		c.setVisible(true);
		//mainCharacter.fight(map, enemy, floor);

	}

	public void endBattle() {

		int combatLevel = checkEnemyLevel();

		if (mainCharacter.getHp() <= 0) {
			this.dispose();
			running = false;
			GameEndFrame o = new GameEndFrame(mainCharacter, "GAME OVER");
			o.setVisible(true);
			//EldenArk.gameOver();
		} else {
			if (map[mainCharacter.getY()][mainCharacter.getX()] >= 7) {
				newFloor();
			} else {
				this.setVisible(true);
			}
			deleteMiniBoss();
			generateLoot(combatLevel);
			int tempLvl = mainCharacter.getLevel();
			mainCharacter.checkLevelUp(getExperience(combatLevel));
			if (tempLvl != mainCharacter.getLevel()) {
				JOptionPane.showMessageDialog(this, "Check your new awasstats!", "LEVEL UP!", JOptionPane.INFORMATION_MESSAGE);
			}
			map[mainCharacter.getY()][mainCharacter.getX()] = 0;

		}
	}

	public int getExperience(int level) {
		int base = 30;
		return base * level;
	}

	public void newEquipmentProbability() {
		switch (map[mainCharacter.getY()][mainCharacter.getX()]) {
			case 2:
				generateEquipmentLoot(98);
				break;
			case 4:
			case 5:
			case 6:
				generateEquipmentLoot(14);
				break;
			case 7:
			case 8:
			case 9:
				generateEquipmentLoot(4);
				break;
		}
	}

	public void generateEquipmentLoot(int probability) {
		int random = rn.nextInt(probability);
		String text;
		switch (random) {
			case 0:
				text = "You found a Weapon!\n" + mainCharacter.newWeapons[floor].getName() + "\n"
						+ String.format("%-40.40s %5.5s %9.9s", ("Actual: " + mainCharacter.getEquipment()[0].getName()), ("+" + mainCharacter.getEquipment()[0].getProfit()), " damage")
						+ "\n" + String.format("%-40.40s %5.5s %9.9s", ("Found: " + mainCharacter.newWeapons[floor].getName()), ("+" + mainCharacter.newWeapons[floor].getProfit()), " damage");
				JOptionPane.showMessageDialog(this, text, "Equipment found", JOptionPane.INFORMATION_MESSAGE);

				break;
			case 1:
				text = "You found a Helmet!\n" + mainCharacter.newHelmets[floor].getName() + "\n"
						+ String.format("%-40.40s %5.5s %9.9s", ("Actual: " + mainCharacter.getEquipment()[1].getName()), ("+" + mainCharacter.getEquipment()[1].getProfit()), " defence")
						+ "\n" + String.format("%-40.40s %5.5s %9.9s", ("Found: " + mainCharacter.newHelmets[floor].getName()), ("+" + mainCharacter.newHelmets[floor].getProfit()), " defence");
				JOptionPane.showMessageDialog(this, text, "Equipment found", JOptionPane.INFORMATION_MESSAGE);

				break;
			case 2:
				text = "You found a Chestplate!\n" + mainCharacter.newChestPlates[floor].getName() + "\n"
						+ String.format("%-40.40s %5.5s %9.9s", ("Actual: " + mainCharacter.getEquipment()[2].getName()), ("+" + mainCharacter.getEquipment()[2].getProfit()), " defence")
						+ "\n" + String.format("%-40.40s %5.5s %9.9s", ("Found: " + mainCharacter.newChestPlates[floor].getName()), ("+" + mainCharacter.newChestPlates[floor].getProfit()), " defence");
				JOptionPane.showMessageDialog(this, text, "Equipment found", JOptionPane.INFORMATION_MESSAGE);

				break;
			case 3:
				text = "You found a Leg Armor!\n" + mainCharacter.newLegArmors[floor].getName() + "\n"
						+ String.format("%-40.40s %5.5s %9.9s", ("Actual: " + mainCharacter.getEquipment()[3].getName()), ("+" + mainCharacter.getEquipment()[3].getProfit()), " defence")
						+ "\n" + String.format("%-40.40s %5.5s %9.9s", ("Found: " + mainCharacter.newLegArmors[floor].getName()), ("+" + mainCharacter.newLegArmors[floor].getProfit()), " defence");
				JOptionPane.showMessageDialog(this, text, "Equipment found", JOptionPane.INFORMATION_MESSAGE);

				break;
		}

	}

	public void generateLoot(int level) {
		int gold = rn.nextInt(10 * level);
		String goldText = "You found " + gold + " gold! " + mainCharacter.getGold() + " - " + (mainCharacter.getGold() + gold);

		setInformation(goldText);
		mainCharacter.setGold(mainCharacter.getGold() + gold);
		int objects = rn.nextInt(20 / level);
		try {
			String objectText = "You found a " + mainCharacter.getInventory()[objects].getName();
			setSecondInformation(objectText);
			mainCharacter.getInventory()[objects].setNumOfUses(mainCharacter.getInventory()[objects].getNumOfUses() + 1);

		} catch (ArrayIndexOutOfBoundsException e) {
		}
		if (floor != 4 && map[mainCharacter.getY()][mainCharacter.getX()] < 7) {
			newEquipmentProbability();
		}

	}

	public void changeMainCharacterLabel(int direction) {
		mainCharacterLabel.setBounds((LABEL_SIZE * mainCharacter.getX()) - 2, (LABEL_SIZE * mainCharacter.getY()), LABEL_SIZE, LABEL_SIZE);
		//1 - UP, 2 - Left, 3 - Down, 4 - Right
		switch (direction) {
			case 1:
				mainCharacterLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(mainCharacter.getCharacterLookingUp())));
				break;
			case 2:
				mainCharacterLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(mainCharacter.getCharacterLookingLeft())));
				break;
			case 3:
				mainCharacterLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(mainCharacter.getCharacterLookingDown())));
				break;
			case 4:
				mainCharacterLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(mainCharacter.getCharacterLookingRight())));
		}
	}

	public static String stringParser(String a) {
		String toReturn = a;
		toReturn = String.format("%-" + STRING_SIZE + "." + STRING_SIZE + "s", toReturn);
		return toReturn;
	}

	public int getFloor() {
		return floor;
	}

	public class MyKeyAdapter implements KeyListener {

		MyKeyAdapter() {

		}

		@Override
		public void keyTyped(KeyEvent e) {
			switch (e.getKeyChar()) {
				case 'w':
					//Thing that happens when the 'w' key is pressed
					setInformation("");
					tryToMoveUP();
					checkNewTile();
					changeMainCharacterLabel(1);
					break;
				case 's':
					//Thing that happens when the 's' key is pressed

					setInformation("");
					tryToMoveDown();
					checkNewTile();
					changeMainCharacterLabel(3);

					break;
				case 'd':
					//Thing that happens when the 'd' key is pressed

					setInformation("");
					tryToMoveRight();
					checkNewTile();
					changeMainCharacterLabel(4);

					break;
				case 'a':
					//Thing that happens when the 'a' key is pressed

					setInformation("");
					tryToMoveLeft();
					checkNewTile();
					changeMainCharacterLabel(2);

					break;
				case 'r':
					//Loot tile
					if (map[mainCharacter.getY()][mainCharacter.getX()] == 1) {
						generateLoot(floor);
						map[mainCharacter.getY()][mainCharacter.getX()] = 0;
					}
					break;
				case 'q':

					JOptionPane.showMessageDialog(rootPane, mainCharacter.showStats(), "Stats", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 'e':
					EquipmentFrame equip = new EquipmentFrame(mainCharacter);
					equip.setVisible(true);

					break;
			}
		}

		/*public void askObject() {
		int i = 0;
		boolean confirm;
		boolean on = true;
		do {
		if (mainCharacter.inventory[i].getNumOfUses() > 0) {
		System.out.println("\nDo you want to use any object?");
		confirm = confirmationO();
		if (confirm) {
		useObject(mainCharacter);
		mainCharacter.hp = mainCharacter.checkMaxValues(mainCharacter.hp, mainCharacter.maxHP);
		mainCharacter.mp = mainCharacter.checkMaxValues(mainCharacter.mp, mainCharacter.maxMP);
		on = false;
		reprint();
		System.out.println("\nOpen the Map Movement window");
		} else {
		on = false;
		reprint();
		System.out.println("\nOpen the Map Movement window");
		
		}
		}
		on = false;
		System.out.println("You dont have potions.");
		System.out.println("I guess you are out of luck. Try going to the merchant.");
		System.out.println("Type to keep playing.");
		Teclat.llegirString();
		reprint();
		System.out.println("\nOpen the Map Movement window");
		} while (on);
		i++;
		}
		
		public boolean confirmationO() {
		boolean answer = false;
		boolean on = true;
		String ask;
		do {
		System.out.println("Type (Y/N)");
		ask = Teclat.llegirString();
		ask = ask.toLowerCase();
		if (ask.equals("y")) {
		answer = true;
		on = false;
		} else if (ask.equals("n")) {
		answer = false;
		on = false;
		} else {
		System.out.println("Invalid answer.");
		}
		} while (on);
		
		return answer;
		}
		
		public void useObject(Character mainCharacter) {
		int option;
		boolean on = true;
		do {
		System.out.println("\nWhat object do you want to use?");
		System.out.println("Type 4 to go back");
		option = Teclat.llegirInt();
		if (option == 4) {
		on = false;
		} else if (option > 4) {
		on = true;
		System.err.println("Invalid option");
		} else if (mainCharacter.inventory[option].getNumOfUses() > 0) {
		System.out.println(mainCharacter.inventory[option].getDescription());
		if (mainCharacter.confirmation()) {
		mainCharacter.inventory[option].use(mainCharacter);
		on = false;
		}
		} else {
		System.out.println("\nYou don't have this potion anymore.");
		}
		} while (on);
		}*/
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					//Thing that happens when the ArrowUp key is pressed
					break;
				case KeyEvent.VK_DOWN:
					//Thing that happens when the ArrowDown key is pressed
					break;
				case KeyEvent.VK_RIGHT:
					//Thing that happens when the ArrowRight key is pressed
					break;
				case KeyEvent.VK_LEFT:
					//Thing that happens when the ArrowLeft key is pressed
					break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

	}

}
