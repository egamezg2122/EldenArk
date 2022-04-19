package eldenark;

/**
 *
 * @author egame
 *
 */
public class Warrior extends Character {

	//Constructors
	// MAIN
	public Warrior(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, String role, Object[] inventory, Equip[] equipment) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage, role, inventory, equipment);
	}

	// ENEMIES
        //Ns si poner la clase
	public Warrior(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage);
	}
	
	// Constructor
	
	public void weapons(){
		Equip weapon = new Equip("Weapon", "WeaponType", 5);
		Equip FidelityGreatsword = new Equip("Fidelity Greatsword", "WeaponType", 10);
		Equip DimensionalGreatsword = new Equip("Dimensional Greatsword", "WeaponType", 20);
		Equip SeraphicOathGreatsword = new Equip("SeraphicOathGreatsword", "WeaponType", 50);
	}

	
	
}
