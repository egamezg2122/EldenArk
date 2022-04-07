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
    
    public int showAbilities (Character mainCharacter){
        
        int option;
        
        String character;
        
        //character = mainCharacter.get        
        
        for (int i = 0; i < ((mainCharacter.getLevel() / 5) + 2); i++) {
            
            System.out.println(abilitiesWarrior[i]);
            
        }
        
        System.out.println("Que habilidad quieres usar?");
        
        option = Teclat.llegirInt();
        
        return option;
        
    }
    
    // Warrior
    
    public void warriorAbility (Character enemy, Character mainCharacter){
        
        int option;

        switch (option = showAbilities(mainCharacter)){
        
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
    
    public void priestAbility (Character mainCharacter){
    
        int option;

        switch (option = showAbilities(mainCharacter)){
        
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
    
    public void  mageAbility (Character enemy, Character mainCharacter){
    
        int option;

        switch (option = showAbilities(mainCharacter)){
        
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
