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

import java.util.InputMismatchException;

import java.util.Random;

public class EldenArk {

    static Random rn = new Random();

    public static void main(String[] args) {

        // Show Introduction
        
        introduction();
        
        // Let the user to choose the main character
        
        Character mainCharacter = pickClass();
        
        // Create gameplay

        Gameplay g = new Gameplay(mainCharacter);

    }
    
    // The user can choose the name of the character 

    public static String nicknameUser() {
        
        boolean on = true;
        
        String nickname;
        
        do {
            
            System.out.println("Introduce your name.");
            
            nickname = Teclat.llegirString();
            
            if ("".equals(nickname)) {
                
                System.err.println("Try again.");
                
                on = false;
                
            }
            
        } while (!on && "".equals(nickname));

        return nickname;
    }
    
    // Function called when the game is over, and start again
    
    public static void gameOver() {
        
        System.out.println("GAME OVER");
        
        System.out.println("Do you want to play again? (Y/N)");
        
        char option = Teclat.llegirChar();
        
        if (option == 'y') {
            
            Character newMainCharacter = pickClass();

            Gameplay newGameplay = new Gameplay(newMainCharacter);
            
        } else {
            
            System.out.println("GoodBye!");
            
        }
    }
    
    // Function called if the user won the game
    
    public static void win(String nickname) {
        
        System.out.println("Congratulations " + nickname + " on compleating sucessfully EldenArk. We hope you enjoyed the game and stay tuned for future updates\n\n\n");
        
        credits();

    }
    
    // Show credits
    
    public static void credits() {

        System.out.println(String.format("%50.50s %20.20s", "", "GAME DEVELOPED BY"));
        
        System.out.println("\n\n");
        
        System.out.println(String.format("%50.50s %20.20s", "", "Elias Gamez"));
        
        System.out.println(String.format("%50.50s %20.20s", "", "Albert Salazar"));
        
        System.out.println(String.format("%50.50s %20.20s", "", "Leo Ferraz"));
        
        System.out.println(String.format("%50.50s %20.20s", "", "Marcel Homar"));
        
    }

    // User picking the character class
    
    public static Character pickClass() {

        Character main = new Character();

        int option;

        do {
            
            System.out.println("What class do you want to choose?\n\t1 - Warrior\n\t2 - Mage\n\t3 - Priest");
            
            // Validate user input
            
            option = validation();
            
            if (option <= 0 || option > 3) {
                
                System.err.println("Invalid option.");
            
            }
            
        } while (option <= 0 || option > 3);
        
        // Choosing the character based on input
        
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
        }

        return main;
        
    }
    
    // User input validation

    public static int validation() {
        
        int option;
        
        try {
            
            option = Teclat.llegirInt();
            
        } catch (InputMismatchException e) {
            
            option = -1;
        }
        
        return option;
        
    }

    /* ************************************************************
     *                                                            *
     *                     CLASS GENERATORS                       *
     *                                                            *
     **************************************************************/
    
    // Create a Warrior object
    
    public static Warrior createWarrior() {

        Warrior warrior = new Warrior(25, 15, 140, 140, 60, 60, 15, "Warrior", generateInventory());

        return warrior;

    }

    // Create a Mage object
    
    public static Mage createMage() {

        Mage mage = new Mage(12, 5, 100, 100, 160, 160, 25, "Mage", generateInventory());

        return mage;
        
    }

    // Create a Priest object
    
    public static Priest createPriest() {

        Priest priest = new Priest(15, 10, 120, 120, 120, 120, 15, "Priest", generateInventory());

        return priest;
        
    }
    
    // Function to generate inventory

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
    
    // Function to show a little explanation of the game
    
    private static void introduction() {
        
        System.out.println("\t\t\t\t\tWelcome to Elden Ark!");
        
        System.out.println("\n\nThis Roguelike Game is and RPG-playing video games characterized by a dungeon crawl through procedurally generated levels,\nturn-based gameplay, grid-based movement, and permanent death of the player character.");
        
        System.out.println("\nIf you die, you will need to start again losing all your progress.\n\n");
        
        System.out.println("The Tower of Elden Ark have 4 floors and when you kill the Final Boss you will advance to the next floor");
        
        System.out.println("In addition, there will be 3 minibosses that give extra loot and experience. Try killing them whenever you need power");
        
        System.out.println("Choose carefully your class and start leveling up to complete the TOWER OF THE ELDEN ARK\n");
    
    }

}
