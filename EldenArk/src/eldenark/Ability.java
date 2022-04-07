package eldenark;

/**
 *
 * @author egame
 * 
 */

public class Ability {
    
    Character mainCharacter;
    
    Character enemy;
    
    String abilitiesWarrior[] = {"Habilidad 1 warrior", "Habilidad 2 warrior", "Habilidad 3 warrior", "Habilidad 4 warrior", "Habilidad 5 warrior"};
    
    String abilitiesMage[] = {"Habilidad 1 mage", "Habilidad 2 mage", "Habilidad 3 mage", "Habilidad 4 mage", "Habilidad 5 mage"};
    
    String abilitiesPriest[] = {"Habilidad 1 priest", "Habilidad 2 priest", "Habilidad 3 priest", "Habilidad 4 priest", "Habilidad 5 priest"};
    
      
    public Ability(Character mainCharacter, Character enemy) {
        
        this.mainCharacter = mainCharacter;
        
        this.enemy = enemy;
        
        //llama a la funcion X
        
        if (mainCharacter.getClass().equals("class eldenark.Warrior")) {
            
            warriorAbility(enemy, mainCharacter);
            
        }
        
        else if (mainCharacter.getClass().equals("class eldenark.Mague")) {
                      
            mageAbility(enemy, mainCharacter);
            
        } 
        
        else {
            
            priestAbility(mainCharacter);;
            
        }
        
    } 
    
    public void showAbilities (){      
        
        for (int i = 0; i < ((mainCharacter.getLevel() / 5) + 2); i++) {
            
            System.out.println();
            
        }

    }
   
   
    // Warrior
    
    public static void warriorAbility (Character enemy, Character mainCharacter){
    
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
