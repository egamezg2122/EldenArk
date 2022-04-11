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

		Warrior w = new Warrior(12, 7, 120, 120, 80, 80, 20, "Warrior", generateInventory(), generateEquipment());

		return w;

	}

	// Test create a Mage object
	public static Mage createMage() {

		Mage m = new Mage(10, 4, 85, 85, 100, 100, 25, "Mage", generateInventory(), generateEquipment());

		return m;
	}
        
        // Test create a Priest object
	public static Priest createPriest() {

		Priest p = new Priest(7, 3, 150, 150, 90, 90, 15, "Priest", generateInventory(), generateEquipment());

		return p;
	}
        
	
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

	
        
}

