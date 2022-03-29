/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eldenark;

import static eldenark.EldenArk.generateInventory;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;

/**
 *
 * @author cep
 */
public class Gameplay extends KeyAdapter {

	int[][] map = new int[5][30];
	static Random rn = new Random();
	Character mainCharacter = new Character();

	Gameplay() {
		mainCharacter = createWarrior();
		createMap(map, mainCharacter);
		printMap(map, mainCharacter);
	}

	
	
	public static void createMap(int[][] array, Character mainCharacter) {
		/* 0 - Nothing
        1 - Loot
        2 - Enemy
		4 - Minor Boss
		5 - Final Boss
		10 - Mountains
		 */
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = rn.nextInt(3);
			}
		}
		//generateMountains(array);
		generateMountains(array, mainCharacter);
		generateMinorBoss(array, mainCharacter);
		generateBoss(array, mainCharacter);
		

	}

	
	//Function to generate Mountains
	public static void generateMountains(int[][] map, Character mainCharacter) {
		int x, y, i, random, tempX, tempY;
		i = 0;
		//Check the first mountain tile
		do {
			x = rn.nextInt(30);
			y = rn.nextInt(5);
		} while (!checkUsageTile(map, mainCharacter, x, y));
		
		
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
	public static void generateMinorBoss(int[][] map, Character mainCharacter){
		int x, y, i = 0;
		do {
			x = rn.nextInt(map[i].length);
			y = rn.nextInt(map.length);
			if (checkUsageTile(map, mainCharacter, x, y)) {
				map[y][x] = 4;
				i++;
			}
		} while (i < 3);
	}
	
	//Function to generate the location of Final Boss
	public static void generateBoss(int[][] map, Character mainCharacter){
		int x, y;
		boolean isUsable;
		do {
			x = rn.nextInt(map[0].length);
			y = rn.nextInt(map.length);
			isUsable = checkUsageTile(map, mainCharacter, x, y);
			if (isUsable) {
				map[y][x] = 5;
			}
		} while (!isUsable);
	}
	
	//Function to check if the tile does not containt special events
	public static boolean checkUsageTile(int[][] map, Character mainCharacter, int x, int y){
		boolean isUsable = false;
		if (!(map[y][x] == 10 || map[y][x] == 4 || map[y][x] == 5 || (mainCharacter.getX() == x && mainCharacter.getY() == y))) {
			isUsable = true;
		} 
		
		
		return isUsable;
	}

	
	//Method to print the map
	public static void printMap(int[][] map, Character mainCharacter) {
		for (int i = 0; i < map.length; i++) {
			System.out.println("_________________________________________________________________________________________");
			for (int j = 0; j < map[i].length; j++) {
				if (j == mainCharacter.getX() && i == mainCharacter.getY()) {
					System.out.print("\u001B[34m" + "O" + "\u001B[30m");
				} else if (map[i][j] == 10) {
					System.out.print("^");
				} else if (map[i][j] == 4){
					System.out.print("Y");
				} else if (map[i][j] == 5){
					System.out.print("X");
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

		Warrior w = new Warrior(10, 10, 50, 50, 20, 20, 10, generateInventory());

		return w;

	}

	public static Object[] generateInventory() {

		Potion smallHealing = new Potion("Small Healing Potion", 30, "tipo", "descripcion", 2);

		Potion largeHealing = new Potion("Large Healing Potion", 50, "tipo", "descripcion", 2);

		Potion smallMana = new Potion("Small Mana Potion", 30, "tipo", "descripcion", 2);

		Potion largeMana = new Potion("Large Mana Potion", 50, "tipo", "descripcion", 2);

		Object[] inventory = new Object[4];

		inventory[0] = smallHealing;
		inventory[1] = largeHealing;
		inventory[2] = smallMana;
		inventory[3] = largeMana;

		return inventory;
	}

	/*
	Timer timer;
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyChar()) {
			case 'w':
				//Thing that happens when the 'w' key is pressed
				break;
			case 's':
				//Thing that happens when the 's' key is pressed
				break;
			case 'd':
				//Thing that happens when the 'd' key is pressed
				break;
			case 'a':
				//Thing that happens when the 'a' key is pressed
				break;
		}
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

	}*/
}
