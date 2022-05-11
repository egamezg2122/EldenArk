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
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author cep
 */
public class Gameplay extends JFrame implements ActionListener{

    	
	//Frame variables
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
	
	// GAMEPLAY VARIABLES
	String nickname = EldenArk.nicknameUser();
    int[][] map = new int[NUM_TILES_Y][NUM_TILES_X];
    static Random rn = new Random();
    Character mainCharacter = new Character();
    boolean running = false;
    boolean inMap = true;
    JFrame f;
    int floor = 1;
    Merchant merchant;
	
	
    public Gameplay(Character mainCharacter) {
        this.mainCharacter = mainCharacter;
        createMap();
        reprint();
        running = true;
		this.setTitle("Map");
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);

        //Creating and adding the key listener
        MyKeyAdapter k;
        k = new MyKeyAdapter();

        this.addKeyListener(k);
		
		this.setPreferredSize(new Dimension(ACTUAL_SCREEN_WIDTH, ACTUAL_SCREEN_HEIGHT));

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
	
	//FRAME METHODS
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
		mainCharacterLabel.setBounds((LABEL_SIZE*mainCharacter.getX()) - 2, (LABEL_SIZE*mainCharacter.getY()), LABEL_SIZE, LABEL_SIZE);
		mainCharacterLabel.setName("MAIN CHARACTER LABEL"); // NOI18N
		
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

    // GENERATING THE MAP
    public void createMap() {
        /* 0 - Nothing
        1 - Loot
        2 - Enemy
		3 - Merchant
		4 - Minor Boss
		5 - Final Boss
		10 - Mountains
         */
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = rn.nextInt(3);
            }
        }
        generateMountains();
        generateMinorBoss();
        generateBoss();
        generateMerchant();

    }

    //Function to generate Mountains
    public void generateMountains() {
        int x, y, i, random, tempX, tempY;
        i = 0;
        //Check the first mountain tile
        do {
            x = rn.nextInt(30);
            y = rn.nextInt(5);
        } while (!checkUsageTile(x, y));

        //Generation mountains close to each other
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

    //Function to generate the location Minor Bosses
    public void generateMinorBoss() {
        int x, y, i = 0;
        do {
            x = rn.nextInt(map[i].length);
            y = rn.nextInt(map.length);
            if (checkUsageTile(x, y)) {
                map[y][x] = 4;
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
                map[y][x] = 5;
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
        if (!(map[y][x] == 10 || map[y][x] == 4 || map[y][x] == 5 || (mainCharacter.getX() == x && mainCharacter.getY() == y))) {
            isUsable = true;
        }

        return isUsable;
    }

    // PRINT THE MAP 
    public void reprint() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        mapTiles();
        printMap();
        printMoveOptions();
    }

    public void mapTiles() {
        System.out.println("M - Merchant\tY - MiniBoss\tX - Final Boss\t^ - Spikes");
    }

    public void printMoveOptions() {
        System.out.println("\nQ - Stats\tW - Upwards\tE - Equip\tR - Loot\nA - Left\tS - Downwards\tD - Right\t0 - Exit Game\nI - Inventory");
    }

    //Method to print the map
    public void printMap() {
        for (int i = 0; i < map.length; i++) {
            System.out.println("_________________________________________________________________________________________");
            for (int j = 0; j < map[i].length; j++) {
                if (j == mainCharacter.getX() && i == mainCharacter.getY()) {
                    System.out.print("\u001B[34m" + "O" + "\u001B[30m");
                } else if (map[i][j] == 10) {
                    System.out.print("^");
                } else if (map[i][j] == 4) {
                    System.out.print("Y");
                } else if (map[i][j] == 5) {
                    System.out.print("X");
                } else if (map[i][j] == 3) {
                    System.out.print("M");
                } else {
                    System.out.print(" ");
                }
                System.out.print("  ");
            }
            System.out.println("");
        }
        System.out.println("_________________________________________________________________________________________");
    }

    // MOVING METHODS 
    public void tryToMoveUP() {
        try {
            if (map[mainCharacter.getY() - 1][mainCharacter.getX()] != 10) {
                mainCharacter.moveUP();
                reprint();
            } else {
                System.out.println("You can't move there");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            mainCharacter.moveDown();
            System.out.println("You're at the edge of the map.");
        }

    }

    public void tryToMoveDown() {
        try {
            if (map[mainCharacter.getY() + 1][mainCharacter.getX()] != 10) {
                mainCharacter.moveDown();
                reprint();
            } else {
                System.out.println("You can't move there");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            mainCharacter.moveUP();
            System.out.println("You're at the edge of the map.");
        }

    }

    public void tryToMoveRight() {
        try {
            if (map[mainCharacter.getY()][mainCharacter.getX() + 1] != 10) {
                mainCharacter.moveRight();
                reprint();
            } else {
                System.out.println("You can't move there");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            mainCharacter.moveLeft();
            System.out.println("You're at the edge of the map.");
        }
    }

    public void tryToMoveLeft() {
        try {
            if (map[mainCharacter.getY()][mainCharacter.getX() - 1] != 10) {
                mainCharacter.moveLeft();
                reprint();
            } else {
                System.out.println("You can't move there");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            mainCharacter.moveRight();
            System.out.println("You're at the edge of the map.");
        }
    }

    public void checkNewTile() {

        switch (map[mainCharacter.getY()][mainCharacter.getX()]) {
            case 1:
                System.out.println("You found loot");
                break;
			/*
            case 2:
                System.out.println("You found a normal enemy. Starting combat");
                startCombat();
                break;
            case 3:
                //Merchant
                merchant.trade();
                f.setVisible(true);
                reprint();
                break;
            case 4:
                System.out.println("You found a miniBoss. Get ready to fight!");
                startCombat();
                break;
            case 5:
                System.out.println("FINAL BOSS");
                startCombat();
                if (mainCharacter.getHp() > 0) {
                    newFloor();
                }
                break;
*/
        }

    }

    public void newFloor() {
        f.setVisible(false);
        System.out.println("Good job defeating the final boss of " + floor + " floor.");
        if (floor < 4) {
            System.out.println("You're now in the " + (floor + 1) + " floor. New adventures are comming.");
            floor++;
            createMap();
            mainCharacter.setX(10);
            mainCharacter.setY(2);
            System.out.println("Are you ready?");
            String s = Teclat.llegirString();
            reprint();
            f.setVisible(true);
        } else {
            f.dispose();
            running = false;
            EldenArk.win(nickname);
        }

    }

    public int checkEnemyLevel() {

        return map[mainCharacter.getY()][mainCharacter.getX()] * floor;
    }

    //Enemy creation
    public Character createEnemy(int difficulty) {

        Character enemy;

        switch (rn.nextInt(3)) {

            case 0:

                enemy = new Warrior(20 * difficulty, 8 * difficulty, 70 * difficulty, 70 * difficulty, 50 * difficulty, 50 * difficulty, 14 * difficulty);

                break;

            case 1:

                enemy = new Mage(13 * difficulty, 4 * difficulty, 66 * difficulty, 66 * difficulty, 70 * difficulty, 70 * difficulty, 30 * difficulty);

                break;

            case 2:

                enemy = new Priest(11 * difficulty, 6 * difficulty, 84 * difficulty, 84 * difficulty, 60 * difficulty, 60 * difficulty, 25 * difficulty);

                break;

            default:

                enemy = new Warrior(20 * difficulty, 8 * difficulty, 70 * difficulty, 70 * difficulty, 50 * difficulty, 50 * difficulty, 12 * difficulty);
        }

        return enemy;
    }

    public void startCombat() {
        f.setVisible(false);
        int combatLevel = checkEnemyLevel();
        Character enemy = createEnemy(combatLevel);
        mainCharacter.fight(map, enemy, floor, nickname);
        if (mainCharacter.getHp() <= 0) {
            f.dispose();
            running = false;
            EldenArk.gameOver();
        } else {
            generateLoot(combatLevel);
            mainCharacter.checkLevelUp(getExperience(combatLevel));
            System.out.println("Returning to the map");
            System.out.println("\t\t\t\tPress enter to continue...");
            String s = Teclat.llegirString();
            map[mainCharacter.getY()][mainCharacter.getX()] = 0;
            f.setVisible(true);
            reprint();
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
                generateEquipmentLoot(14);
                break;
            case 5:
                generateEquipmentLoot(4);
                break;
        }
    }

    public void generateEquipmentLoot(int probability) {
        int random = rn.nextInt(probability);
        switch (random) {
            case 0:
                System.out.println("\nYou found a Weapon!\n" + mainCharacter.newWeapons[floor].getName());
                System.out.println(String.format("%-40.40s %5.5s %9.9s", ("Actual: " + mainCharacter.getEquipment()[0].getName()), ("+" + mainCharacter.getEquipment()[0].getProfit()), " damage"));
                System.out.println(String.format("%-40.40s %5.5s %9.9s", ("Found: " + mainCharacter.newWeapons[floor].getName()), ("+" + mainCharacter.newWeapons[floor].getProfit()), " damage"));
                mainCharacter.changeEquip(mainCharacter.getEquipment(), mainCharacter.newWeapons[floor]);
                System.out.println("\n");
                break;
            case 1:
                System.out.println("You found a Helmet!\n" + mainCharacter.newHelmets[floor].getName());
                System.out.println(String.format("%-40.40s %5.5s %9.9s", ("Actual: " + mainCharacter.getEquipment()[1].getName()), ("+" + mainCharacter.getEquipment()[1].getProfit()), " defence"));
                System.out.println(String.format("%-40.40s %5.5s %9.9s", mainCharacter.newHelmets[floor].getName(), ("+" + mainCharacter.newHelmets[floor].getProfit()), " defence"));
                mainCharacter.changeEquip(mainCharacter.getEquipment(), mainCharacter.newHelmets[floor]);
                break;
            case 2:
                System.out.println("You found a Chestplate!\n" + mainCharacter.newChestPlates[floor].getName());
                System.out.println(String.format("%-40.40s %5.5s %9.9s", ("Actual: " + mainCharacter.getEquipment()[2].getName()), ("+" + mainCharacter.getEquipment()[2].getProfit()), " defence"));
                System.out.println(String.format("%-40.40s %5.5s %9.9s", ("Found: " + mainCharacter.newChestPlates[floor].getName()), ("+" + mainCharacter.newChestPlates[floor].getProfit()), " defence"));
                mainCharacter.changeEquip(mainCharacter.getEquipment(), mainCharacter.newChestPlates[floor]);
                break;
            case 3:
                System.out.println("You found a Leg Armor!\n" + mainCharacter.newLegArmors[floor].getName());
                System.out.println(String.format("%-40.40s %5.5s %9.9s", ("Actual: " + mainCharacter.getEquipment()[3].getName()), ("+" + mainCharacter.getEquipment()[3].getProfit()), " defence"));
                System.out.println(String.format("%-40.40s %5.5s %9.9s", ("Found: " + mainCharacter.newLegArmors[floor].getName()), ("+" + mainCharacter.newLegArmors[floor].getProfit()), " defence"));
                mainCharacter.changeEquip(mainCharacter.getEquipment(), mainCharacter.newLegArmors[floor]);
                break;
        }

    }

    public void generateLoot(int level) {
        int gold = rn.nextInt(10 * level);
        System.out.println("You found " + gold + " gold!\n" + mainCharacter.getGold() + " - " + (mainCharacter.getGold() + gold));
        mainCharacter.setGold(mainCharacter.getGold() + gold);
        int objects = rn.nextInt(20 / level);
        try {
            System.out.print("You found a " + mainCharacter.getInventory()[objects].getName());
            System.out.println(": " + mainCharacter.getInventory()[objects].getNumOfUses() + " -> " + (mainCharacter.getInventory()[objects].getNumOfUses() + 1));
            mainCharacter.getInventory()[objects].setNumOfUses(mainCharacter.getInventory()[objects].getNumOfUses() + 1);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You found no additionals objects");
        }
        newEquipmentProbability();

    }
	
	public void changeMainCharacterLabel(int direction){
		mainCharacterLabel.setBounds((LABEL_SIZE * mainCharacter.getX()) - 2, (LABEL_SIZE * mainCharacter.getY()), LABEL_SIZE, LABEL_SIZE);
		//1 - UP, 2 - Left, 3 - Down, 4 - Right
		switch(direction){
			case 1: mainCharacterLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/PRIEST/PRIEST_M_BACK.png")));
			break;
			case 2: mainCharacterLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/PRIEST/PRIEST_M_LEFT.png")));
			break;
			case 3: mainCharacterLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/PRIEST/PRIEST_M_FRONT.png")));
			break;
			case 4: mainCharacterLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/PRIEST/PRIEST_M_RIGHT.png")));
		}
	}

    public class MyKeyAdapter implements KeyListener {

        MyKeyAdapter() {

        }

        @Override
        public void keyTyped(KeyEvent e) {
            switch (e.getKeyChar()) {
                case 'w':
                    //Thing that happens when the 'w' key is pressed
                    tryToMoveUP();
                    checkNewTile();
                    changeMainCharacterLabel(1);
                    break;
                case 's':
                    //Thing that happens when the 's' key is pressed
                    if (inMap) {
                        tryToMoveDown();
                        checkNewTile();
						changeMainCharacterLabel(3);
                    }
                    break;
                case 'd':
                    //Thing that happens when the 'd' key is pressed
                    if (inMap) {
                        tryToMoveRight();
                        checkNewTile();
						changeMainCharacterLabel(4);
                    }
                    break;
                case 'a':
                    //Thing that happens when the 'a' key is pressed
                    if (inMap) {
                        tryToMoveLeft();
                        checkNewTile();
						changeMainCharacterLabel(2);
                    }
                    break;
                case 'r':
                    //Loot tile
                    if (inMap) {
                        if (map[mainCharacter.getY()][mainCharacter.getX()] == 1) {
                            reprint();
                            generateLoot(floor);
                            map[mainCharacter.getY()][mainCharacter.getX()] = 0;

                        }

                    }
                    break;
                case 'q':
                    reprint();
                    mainCharacter.showStats();
                    break;
                case 'e':
                    reprint();
                    mainCharacter.showEquipment();
                    break;
                case '0':
                    f.dispose();
                    System.out.println("Byebye");
                    break;
                case 'i':
                    reprint();
                    mainCharacter.showInventory();
                    askObject();

            }
        }

        public void askObject() {
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
        }

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
