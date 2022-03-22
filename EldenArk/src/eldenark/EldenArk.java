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

public class EldenArk {

    public static void main(String[] args) {
        
        // Main Logic and code
        
        Warrior personajeInicial = createWarrior();
        
    }
    
    // Test creating Warrior character
    
    public static Warrior createWarrior(){
        
        Warrior w = new Warrior(10, 10, 50, 50, 20, 20, 10);
        
        return w;
    
    }
    
    // Test create a Mage object
    
    public static Mage createMage(){
        
        Mage m = new Mage(10, 10, 50, 50, 20, 20, 10);
        
        return m;
    
    }
    
    // Test create a Priest object
    
    public static Priest createPriest(){
        
        Priest p = new Priest(10, 10, 50, 50, 20, 20, 10);
        
        return p;
    
    }
    
}
