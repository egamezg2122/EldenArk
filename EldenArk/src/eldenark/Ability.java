package eldenark;

/**
 *
 * @author egame
 * 
 */

public class Ability {
    
    // Warrior abilities
    
    public void ability (Character enemy, Character mainCharacter ){
    
        enemy.setHp(enemy.getHp() - 40);
        
    }
    
}
