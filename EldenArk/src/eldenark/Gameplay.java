/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eldenark;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import javax.swing.*;

/**
 *
 * @author cep
 */

public class Gameplay implements ActionListener {

	int[][] map = new int[5][30];
	static Random rn = new Random();
	Character mainCharacter = new Character();
	boolean running = false;
	boolean inMap = true;
	//Timer timer;
	JFrame f;
	JPanel Combat;
	int level = 1;
	Merchant merchant = new Merchant(0, 0);

	public Gameplay(Character mainCharacter) {
		this.mainCharacter = mainCharacter;
		createMap();
		reprint();
		running = true;
		//timer = new Timer();
		f = new JFrame("Demo");

		f.setLayout(new FlowLayout());
		f.setSize(400, 400);
		Label l = new Label();

		l.setText("This is Map movement");
		f.add(l);

		f.setVisible(true);

		//Creating and adding the key listener
		MyKeyAdapter k;
		k = new MyKeyAdapter();

		f.addKeyListener(k);

	}

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
		//generateMountains(array);
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
			} catch (ArrayIndexOutOfBoundsException e) {
				x = tempX;
				y = tempY;
			} finally {
				i++;
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

	public void reprint() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		printMap();
		printMoveOptions();
	}

	public void printMoveOptions() {
		System.out.println("\t\tW - Upwards\tR - Loot tile\nA - Left\tS - Downwards\tD - Downwards");
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

	public static Warrior createWarrior() {

		Warrior w = new Warrior(12, 7, 120, 120, 80, 80, 20, generateInventory(), generateEquipment());

		return w;

	}

	// Test create a Mage object
	public static Mage createMage() {

		Mage m = new Mage(10, 4, 85, 85, 100, 100, 25, generateInventory(), generateEquipment());

		return m;
	}
        
        // Test create a Priest object
	public static Priest createPriest() {

		Priest p = new Priest(7, 3, 150, 150, 90, 90, 15, generateInventory(), generateEquipment());

		return p;
	}
        
	/*
	public Character createEnemy(){
		Character enemy;
		int random = rn.nextInt();
		switch(random){
		F	case 0:
				enemy = new Warrior(50 * level, 20 * level);
				break;
			case 1:
				enemy = new Mage();
				break;
			case 2:
				enemy = new Priest();
				break;
		}
		return enemy;
		
	}
	 */

	public static Equip[] generateEquipment() {

		Equip[] equipment = new Equip[4];

		Equip weapon = new Equip("Weapon", "WeaponType", 5);
		Equip helmet = new Equip("Helmet", "HelmetType", 2);
		Equip chest = new Equip("Chest", "ChestType", 2);
		Equip leg = new Equip("Leg", "LegType", 2);

		equipment[0] = weapon;
		equipment[1] = helmet;
		equipment[2] = chest;
		equipment[3] = leg;

		return equipment;
	}

	public static Object[] generateInventory() {

		Potion smallHealing = new Potion("Small Healing Potion", 30, "healing", "It restores 30% health of your max HP", 2);

		Potion largeHealing = new Potion("Large Healing Potion", 50, "healing", "It restores 50% health of your max HP", 2);

		Potion smallMana = new Potion("Small Mana Potion", 30, "mana", "It restores 30% mana of your max MP", 2);

		Potion largeMana = new Potion("Large Mana Potion", 50, "mana", "It restores 50% mana of your max MP", 2);

		Object[] inventory = new Object[4];

		inventory[0] = smallHealing;
		inventory[1] = largeHealing;
		inventory[2] = smallMana;
		inventory[3] = largeMana;

		return inventory;
	}

	/*
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
                //Thing that happens when the 'w' key is pressed
                mainCharacter.moveUP();
                reprint();
                break;
            case 's':
                //Thing that happens when the 's' key is pressed
                mainCharacter.moveDown();
                reprint();
                break;
            case 'd':
                //Thing that happens when the 'd' key is pressed
                mainCharacter.moveRight();
                reprint();
                break;
            case 'a':
                //Thing that happens when the 'a' key is pressed
                mainCharacter.moveLeft();
                reprint();
                break;
        }
    }
	 */
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
			case 2:
				System.out.println("You found a normal enemy. Starting combat");
				startCombat();
				break;
			case 3:
				//Merchant
				merchant.trade(mainCharacter);
				break;
			case 4:
				System.out.println("You found a miniBoss. Get ready to fight!");
				startCombat();
				break;
			case 5:
				System.out.println("FINAL BOSS");
				startCombat();
				break;

		}

	}
        //Enemy creation
        public Character createEnemy (int difficulty) {
        
            Character enemy;
            
            switch  (rn.nextInt(3)) {
                case 0:
                    
                    enemy = new Warrior (12 * difficulty, 6 * difficulty, 70 * difficulty, 70 * difficulty, 50 * difficulty, 50 * difficulty, 12 * difficulty);
                   
                    break;
                    
                case 1:
                    
                    enemy = new Mage (6 * difficulty, 2 * difficulty, 65 * difficulty, 65 * difficulty, 75 * difficulty, 75* difficulty, 17 * difficulty);
                    
                    break;
                    
                case 2:
                    
                    enemy = new Priest (4 * difficulty, 1 * difficulty, 85 * difficulty, 85 * difficulty, 60 * difficulty, 60 * difficulty, 8 * difficulty);
                    
                    break;
                    
                default:
                    
                    enemy = new Warrior (6 * difficulty, 8 * difficulty, 70 * difficulty, 70 * difficulty, 40 * difficulty, 40 * difficulty, 10 * difficulty);
            }
            
            return enemy;
        }

	public void startCombat() {
		try {
			f.setVisible(false);
			Warrior enemy = createWarrior();
			//Combat combat = new Combat(mainCharacter, enemy);
			//f.add(Combat);
			mainCharacter.fight(enemy);
			if (mainCharacter.getHp() <= 0) {
				System.out.println("GAME OVER");
			} else {
				generateLoot(level);
				System.out.println("Returning to the map");
				map[mainCharacter.getY()][mainCharacter.getX()] = 0;
				f.setVisible(true);
				reprint();
			}
		} catch (java.lang.NullPointerException e) {
			
		}

	}

	public void generateLoot(int level) {
		int gold = rn.nextInt(10 * level);
		System.out.println("You found " + gold + " gold!\n" + mainCharacter.getGold() + " - " + (mainCharacter.getGold() + gold));
		mainCharacter.setGold(mainCharacter.getGold() + gold);
		int objects = rn.nextInt();
		try {
			System.out.println("You found a " + mainCharacter.getInventory()[objects].getName());
			mainCharacter.getInventory()[objects].setNumOfUses(mainCharacter.getInventory()[objects].getNumOfUses() + 1);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("You found no additionals objects");
		}
		System.out.println("\t\t\t\t\tPress enter to continue...");
		String s = Teclat.llegirString();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public class MyKeyAdapter implements KeyListener {

		MyKeyAdapter() {

		}

		@Override
		public void keyTyped(KeyEvent e) {
			switch (e.getKeyChar()) {
				case 'w':
					//Thing that happens when the 'w' key is pressed
					if (inMap) {
						tryToMoveUP();
						checkNewTile();
					}
					break;
				case 's':
					//Thing that happens when the 's' key is pressed
					if (inMap) {
						tryToMoveDown();
						checkNewTile();
					}
					break;
				case 'd':
					//Thing that happens when the 'd' key is pressed
					if (inMap) {
						tryToMoveRight();
						checkNewTile();
					}
					break;
				case 'a':
					//Thing that happens when the 'a' key is pressed
					if (inMap) {
						tryToMoveLeft();
						checkNewTile();
					}
					break;
				case 'r':
					//Loot tile
					if (inMap) {

					}

			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					//Thing that happens when the ArrowUp key is pressed
					mainCharacter.moveUP();

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
