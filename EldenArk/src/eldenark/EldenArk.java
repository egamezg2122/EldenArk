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
		Character mainCharacter = pickClass();

		Gameplay g = new Gameplay(mainCharacter);
		

	}

	public static void gameOver() {
		System.out.println("GAME OVER");
		System.out.println("Do you want to play again?");
		char option = Teclat.llegirChar();
		if (option == 'y') {
			Character newMainCharacter = pickClass();

			Gameplay newGameplay = new Gameplay(newMainCharacter);
		} else{
			System.out.println("GoodBye!");
		}
	}
	
	public static void win() {
		System.out.println("Congratulations on compleating sucessfully Elden Ark. We hope you enjoyed the game and stay tuned for futures updates\n\n\n");
		credits();
		
	}
	
	public static void credits() {
		System.out.println(String.format("%50.50s %20.20s", "", "GAME DEVELOPED BY"));
		System.out.println("\n\n");
		System.out.println(String.format("%50.50s %20.20s", "", "Elias Gamez"));
		System.out.println(String.format("%50.50s %20.20s", "", "Albert Salazar"));
		System.out.println(String.format("%50.50s %20.20s", "", "Leo Ferraz"));
		System.out.println(String.format("%50.50s %20.20s", "", "Marcel Homar"));
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

				System.out.println("You have chosen the warrior class");

				break;

			case 2:

				main = createMage();

				System.out.println("You have chosen the mage class");

				break;

			case 3:

				main = createPriest();

				System.out.println("You have chosen the priest class");

				break;

			default:

				System.err.println("Not a valid number");

		}

		return main;
	}

	// CLASS GENERATORS 
	public static Warrior createWarrior() {

		Warrior w = new Warrior(12, 7, 120, 120, 80, 80, 20, "Warrior", generateInventory());

		return w;

	}

	// Test create a Mage object
	public static Mage createMage() {

		Mage m = new Mage(10, 4, 85, 85, 100, 100, 25, "Mage", generateInventory());

		return m;
	}

	// Test create a Priest object
	public static Priest createPriest() {

		Priest p = new Priest(7, 3, 150, 150, 90, 90, 15, "Priest", generateInventory());

		return p;
	}

	/*
	public static Equip[] generateEquipment() {

		Equip[] equipment = new Equip[4];

		Equip weapon = new Equip("Basic Weapon", "WeaponType", 5);
		Equip helmet = new Equip("Basic Helmet", "HelmetType", 2);
		Equip chest = new Equip("Basic Chestplate", "ChestType", 5);
		Equip leg = new Equip("Basic Leg Armor", "LegType", 3);

		equipment[0] = weapon;
		equipment[1] = helmet;
		equipment[2] = chest;
		equipment[3] = leg;

		return equipment;
	}*/

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

}
