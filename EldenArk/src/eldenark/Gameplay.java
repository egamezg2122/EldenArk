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
import javax.swing.*;

/**
 *
 * @author cep
 */
public class Gameplay {

	int[][] map = new int[5][30];
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
				newFloor();
				break;

		}

	}

	public void newFloor() {
		f.setVisible(false);
		System.out.println("Congratilation defeating the final boss of " + floor + " floor.");
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
		} else{
			EldenArk.win();
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

				enemy = new Warrior(12 * difficulty, 6 * difficulty, 70 * difficulty, 70 * difficulty, 50 * difficulty, 50 * difficulty, 12 * difficulty);

				break;

			case 1:

				enemy = new Mage(6 * difficulty, 2 * difficulty, 66 * difficulty, 66 * difficulty, 70 * difficulty, 70 * difficulty, 16 * difficulty);

				break;

			case 2:

				enemy = new Priest(4 * difficulty, 2 * difficulty, 84 * difficulty, 84 * difficulty, 60 * difficulty, 60 * difficulty, 8 * difficulty);

				break;

			default:

				enemy = new Warrior(12 * difficulty, 6 * difficulty, 70 * difficulty, 70 * difficulty, 50 * difficulty, 50 * difficulty, 12 * difficulty);
		}

		return enemy;
	}

	public void startCombat() {
		f.setVisible(false);
		int combatLevel = checkEnemyLevel();
		Character enemy = createEnemy(combatLevel);
		mainCharacter.fight(enemy);
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
				System.out.println("You found a Weapon!\n" + mainCharacter.newWeapons[floor].getName());
				System.out.println(String.format("%-20.20s %5.5s %9.9s", mainCharacter.getEquipment()[0].getName(), ("+" + mainCharacter.getEquipment()[0].getProfit()), " damage"));
				System.out.println(String.format("%-20.20s %5.5s %9.9s", mainCharacter.newWeapons[floor].getName(), ("+" + mainCharacter.newWeapons[floor].getProfit()), " damage"));
				mainCharacter.changeEquip(mainCharacter.getEquipment(), mainCharacter.newWeapons[floor]);
				System.out.println("\n");
				break;
			case 1:
				System.out.println("You found a Helmet!\n" + mainCharacter.newHelmets[floor].getName());
				System.out.println(String.format("%-20.20s %5.5s %9.9s", mainCharacter.getEquipment()[1].getName(), ("+" + mainCharacter.getEquipment()[1].getProfit()), " defence"));
				System.out.println(String.format("%-20.20s %5.5s %9.9s", mainCharacter.newHelmets[floor].getName(), ("+" + mainCharacter.newHelmets[floor].getProfit()), " defence"));
				mainCharacter.changeEquip(mainCharacter.getEquipment(), mainCharacter.newHelmets[floor]);
				break;
			case 2:
				System.out.println("You found a Chestplate!\n" + mainCharacter.newChestPlates[floor].getName());
				System.out.println(String.format("%-20.20s %5.5s %9.9s", mainCharacter.getEquipment()[2].getName(), ("+" + mainCharacter.getEquipment()[2].getProfit()), " defence"));
				System.out.println(String.format("%-20.20s %5.5s %9.9s", mainCharacter.newChestPlates[floor].getName(), ("+" + mainCharacter.newChestPlates[floor].getProfit()), " defence"));
				mainCharacter.changeEquip(mainCharacter.getEquipment(), mainCharacter.newChestPlates[floor]);
				break;
			case 3:
				System.out.println("You found a Leg Armor!\n" + mainCharacter.newLegArmors[floor].getName());
				System.out.println(String.format("%-20.20s %5.5s %9.9s", mainCharacter.getEquipment()[3].getName(), ("+" + mainCharacter.getEquipment()[3].getProfit()), " defence"));
				System.out.println(String.format("%-20.20s %5.5s %9.9s", mainCharacter.newLegArmors[floor].getName(), ("+" + mainCharacter.newLegArmors[floor].getProfit()), " defence"));
				mainCharacter.changeEquip(mainCharacter.getEquipment(), mainCharacter.newLegArmors[floor]);
				break;
		}

	}

	public void generateLoot(int level) {
		int gold = rn.nextInt(10 * level);
		System.out.println("You found " + gold + " gold!\n" + mainCharacter.getGold() + " - " + (mainCharacter.getGold() + gold));
		mainCharacter.setGold(mainCharacter.getGold() + gold);
		int objects = rn.nextInt(10 / level);
		try {
			System.out.print("You found a " + mainCharacter.getInventory()[objects].getName());
			System.out.println(": " + mainCharacter.getInventory()[objects].getNumOfUses() + " -> " + (mainCharacter.getInventory()[objects].getNumOfUses() + 1));
			mainCharacter.getInventory()[objects].setNumOfUses(mainCharacter.getInventory()[objects].getNumOfUses() + 1);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("You found no additionals objects");
		}
		newEquipmentProbability();

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
				case 'p':
					reprint();
					mainCharacter.showEquipment();
					break;

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
