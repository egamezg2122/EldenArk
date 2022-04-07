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

import static eldenark.Gameplay.generateInventory;
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
    
    public Warrior createWarrior() {

        Warrior w = new Warrior(12, 7, 120, 120, 80, 80, 20, generateInventory(), generateEquipment());

        return w;

    }

    // Test create a Mage object
    public Mage createMage() {

        Mage m = new Mage(10, 4, 85, 85, 100, 100, 25, generateInventory(), generateEquipment());

        return m;
        
    }

    // Test create a Priest object
    public Priest createPriest() {

        Priest p = new Priest(7, 3, 150, 150, 90, 90, 15, generateInventory(), generateEquipment());

        return p;
        
    }  
    
}

