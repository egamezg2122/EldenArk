/* 
 
 /$$$$$$$$ /$$       /$$                            /$$$$$$            /$$      
| $$_____/| $$      | $$                           /$$__  $$          | $$      
| $$      | $$  /$$$$$$$  /$$$$$$  /$$$$$$$       | $$  \ $$  /$$$$$$ | $$   /$$
| $$$$$   | $$ /$$__  $$ /$$__  $$| $$__  $$      | $$$$$$$$ /$$__  $$| $$  /$$/
| $$__/   | $$| $$  | $$| $$$$$$$$| $$  \ $$      | $$__  $$| $$  \__/| $$$$$$/ 
| $$      | $$| $$  | $$| $$_____/| $$  | $$      | $$  | $$| $$      | $$_  $$ 
| $$$$$$$$| $$|  $$$$$$$|  $$$$$$$| $$  | $$      | $$  | $$| $$      | $$ \  $$
|________/|__/ \_______/ \_______/|__/  |__/      |__/  |__/|__/      |__/  \__/
        


Authors:

    * Elías Gámez
    * Marcel Homar
    * Albert Salazar
    * Leo Ferraz

Copyright:

    * © 2022 Abobinados <abobinados@losbobis.com>

Version:
    
    * Version 1.0

 */
package eldenark;

import java.util.Random;

public class EldenArk {

	static Random rn = new Random();

	public static void main(String[] args) {


		// Main Logic
		Character mainCharacter;

		int[][] map = new int[10][10];

        // Main Logic
        
		Gameplay g = new Gameplay();
		
		/*
        Character mainCharacter;
        
        int[][] map = new int[10][10];
		
		map[11][10] = 1;


		mainCharacter = pickClass();
		
        mainCharacter = pickClass();
        createMap(map);
        
        printMap(map, mainCharacter);
        
		mainCharacter.move();

		 */

		printMap(map, mainCharacter);

		mainCharacter.menu();

		printMap(map, mainCharacter);

		do {

			mainCharacter.menu();

		} while (mainCharacter.getHp() > 0);


		/*
		Warrior personajeInicial = createWarrior();

		personajeInicial.showStats();
		personajeInicial.setHp(25);
		for (int i = 0; i < 5; i++) {
			personajeInicial.levelUp();
		}
		System.out.println("\n\n\n");
		personajeInicial.showStats();
		 */
	}

	// User picking their character class
	public static Character pickClass() {

		Character main = new Character();

		int option;

		System.out.println("What class do you want to choose?\n\t1 - Warrior\n\t2 - Mage\n\t3 - Priest");

		option = Teclat.llegirInt();

		switch (option) {

			case 1:

				main = createWarrior();

				break;

			case 2:

				main = createMage();

				break;

			case 3:

				main = createPriest();

				break;

			default:

				System.err.println("Not a valid number");

		}

		return main;
	}

	// Testins creating a basic map
	public static void createMap(int[][] array) {
		/* 0 - Nothing
        1 - Loot
        2 - Enemy
		 */
		for (int[] array1 : array) {
			for (int j = 0; j < array.length; j++) {
				array1[j] = rn.nextInt(3);
			}
		}
	}

	// Print map
	public static void printMap(int[][] map, Character mainCharacter) {
		for (int i = 0; i < map.length; i++) {
			System.out.println("\n_____________________________________________________________\n");
			for (int j = 0; j < map[i].length; j++) {
				if (j == mainCharacter.getX() && i == mainCharacter.getY()) {
					System.out.print("|" + "\u001B[34m" + "    O" + "\u001B[30m");
				} else if (map[i][j] == 0) {
					System.out.print(String.format("|%5s", ""));
				} else {
					System.out.print(String.format("|%5d", map[i][j]));
				}
			}
			System.out.print("|");
		}
		System.out.println("\n_____________________________________________________________");
	}

	// Test creating Warrior character

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
	}


	// Test create a Priest object


	

	

