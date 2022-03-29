package eldenark;

/**
 *
 * @author egame
 *
 */
public class Mage extends Character {

	// MAIN 
	public Mage(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, Object[] inventory, Equip[] equipment) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage, inventory, equipment);
	}

	// ENEMY
	public Mage(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage);
	}

	// Constructor
}
