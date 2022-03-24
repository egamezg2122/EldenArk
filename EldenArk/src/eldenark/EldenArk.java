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
        Characters mainCharacter;
        int[][] map = new int[10][10];
        mainCharacter = pickClass();
        createMap(map);
        printMap(map);
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
    public static Characters pickClass() {
        Characters main = new Characters();
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
        /* 0 - Enemy
        1 - Loot
        2 - Nothing
         */
        for (int[] array1 : array) {
            for (int j = 0; j < array.length; j++) {
                array1[j] = rn.nextInt(3);
            }
        }
    }

    // Print map
    public static void printMap(int[][] map) {
        for (int[] map1 : map) {
            System.out.println("\n_____________________________________________________________\n");
            for (int j = 0; j < map1.length; j++) {
                System.out.print(String.format("|%5d", map1[j]));
            }
            System.out.print("|");
        }
        System.out.println("\n_____________________________________________________________");
    }

    // Test creating Warrior character
    public static Warrior createWarrior() {

        Warrior w = new Warrior(10, 10, 50, 50, 20, 20, 10);

        return w;

    }

    // Test create a Mage object
    public static Mage createMage() {

        Mage m = new Mage(10, 10, 50, 50, 20, 20, 10);

        return m;

    }

    // Test create a Priest object
    public static Priest createPriest() {

        Priest p = new Priest(10, 10, 50, 50, 20, 20, 10);

        return p;

    }

}
