package eldenark;

/**
 *
 * @author egame
 * 
 */

public class Ability {
    
    String abilitiesWarrior[] = {"Habilidad 1", "Habilidad 2", "Habilidad 3", "Habilidad 4", "Habilidad 5"};
    
    String abilitiesMage[] = {"Habilidad 1", "Habilidad 2", "Habilidad 3", "Habilidad 4", "Habilidad 5"};
    
    String abilitiesPriest[] = {"Habilidad 1", "Habilidad 2", "Habilidad 3", "Habilidad 4", "Habilidad 5"};
    
    public static void showAbilities (Character mainCharacter, String[] abilities){      
        
        for (int i = 0; i < ((mainCharacter.getLevel() / 5) + 2); i++) {
            
            System.out.println(abilities[i]);
            
        }

    }
    
    public static void specialAbilities (Character mainCharacter, Character enemy){
        
        if (mainCharacter.getClass().equals("class eldenark.Warrior")) {
            
            
            warriorAbility (mainCharacter, enemy);
            
        }
        
        else if (mainCharacter.getClass().equals("class eldenark.Mague")) {
            
            showAbilities(mainCharacter, abilitiesMage);
            
        } 
        
        else {
        
            showAbilities(mainCharacter, abilitiesPriest);
            
        }
    }
    
    // Warrior
    
    public static void warriorAbility (Character enemy, Character mainCharacter){
        
        int option;
        
        boolean control = false;
        
        do {
            
            System.out.println("Que habilidad quieres usar?");  

            showAbilities(mainCharacter, abilitiesWarrior);

            option = Teclat.llegirInt();
            
            if ((option < (mainCharacter.getLevel() / 5) + 2) && option >= 1) {
                
                control = true;
                
            } else{
            
                System.out.println("The ability is not avilable, caldo de pollo");
              
            }
        
        } while (!control);
        
        switch (option){
        
            case 1: enemy.setHp(enemy.getHp() - 40);
                    
                    System.out.println("has usado la habilidad 1");

                    break;
                    
            case 2: enemy.setHp(enemy.getHp() - 50);
            
                    System.out.println("has usado la habilidad 2");
                    
                    break;
                    
            case 3: enemy.setHp(enemy.getHp() - 60);
            
                    System.out.println("has usado la habilidad 3");
                    
                    break;
                    
            case 4: enemy.setHp(enemy.getHp() - 70);
            
                    System.out.println("has usado la habilidad 4");
                    
                    break;
        
        }
        
    }
    
    // Priest
    
    public static void priestAbility (Character mainCharacter){
    
        int option;
        
        boolean control = false;
        
        do {
            
            System.out.println("Que habilidad quieres usar?");  

            //showAbiities

            option = Teclat.llegirInt();
            
            if ((option < (mainCharacter.getLevel() / 5) + 2) && option >= 1) {
                
                control = true;
                
            } else{
            
                System.out.println("The ability is not avilable, caldo de pollo");
              
            }
        
        } while (!control);

        switch (option){
        
            case 1:  mainCharacter.setHp(mainCharacter.getHp() + 40);
                    
                    System.out.println("has usado la habilidad 1");

                    break;
                    
            case 2:  mainCharacter.setHp(mainCharacter.getHp() + 50);
            
                    System.out.println("has usado la habilidad 2");
                    
                    break;
                    
            case 3:  mainCharacter.setHp(mainCharacter.getHp() + 60);
            
                    System.out.println("has usado la habilidad 3");
                    
                    break;
                    
            case 4:  mainCharacter.setHp(mainCharacter.getHp() + 70);
            
                    System.out.println("has usado la habilidad 4");
                    
                    break;
        
        }
        
    }
    
    // Mage
    
    public static void  mageAbility (Character enemy, Character mainCharacter){
    
        int option;
        
        boolean control = false;
        
        do {
            
            System.out.println("Que habilidad quieres usar?");  

            //showAbilities

            option = Teclat.llegirInt();
            
            if ((option < (mainCharacter.getLevel() / 5) + 2) && option >= 1) {
                
                control = true;
                
            } else{
            
                System.out.println("The ability is not avilable, caldo de pollo");
              
            }
        
        } while (!control);
        
        switch (option){
        
            case 1: enemy.setHp(enemy.getHp() - 40);
                    
                    System.out.println("has usado la habilidad 1");

                    
                    break;
                    
            case 2: enemy.setHp(enemy.getHp() - 50);
            
                    System.out.println("has usado la habilidad 2");
                    
                    break;
                    
            case 3: enemy.setHp(enemy.getHp() - 60);
            
                    System.out.println("has usado la habilidad 3");
                    
                    break;
                    
            case 4: enemy.setHp(enemy.getHp() - 70);
            
                    System.out.println("has usado la habilidad 4");
                    
                    break;
        
        }
        
    }
    
}
