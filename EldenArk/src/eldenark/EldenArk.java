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
        Gameplay g = new Gameplay();
    }

    // User picking their character class
    public static Character pickClass() {

        Character main = new Character();

        int option;

        System.out.println("What class do you want to choose?\n\t1 - Warrior\n\t2 - Mage\n\t3 - Priest");

        option = Teclat.llegirInt();

        switch (option) {

            case 1:

                //main = createWarrior();

                break;

            case 2:

                //main = createMage();

                break;

            case 3:

                //main = createPriest();

                break;

            default:

                System.err.println("Not a valid number");

        }

        return main;
    }
}

