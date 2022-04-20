package eldenark;

/**
 *
 * @author egame
 *
 */
public class Priest extends Character {

	// MAIN
	public Priest(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, String role, Object[] inventory) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage, role, inventory);
	}

	// ENEMIES
        //Ns si poner la clase
	public Priest(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage);
	}

	// Constructor
}
