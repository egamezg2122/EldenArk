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

import static eldenark.Gameplay.generateEquipment;
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

                main = Gameplay.createWarrior();
                
                System.out.println("You have chosen the warrior class");

                break;

            case 2:

                main = Gameplay.createMage();
                
                System.out.println("You have chosen the mage class");

                break;

            case 3:

                main = Gameplay.createPriest();
                
                System.out.println("You have chosen the priest class");

                break;

            default:

                System.err.println("Not a valid number");

        }     
        

        return main;
    }
    
}

