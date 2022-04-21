package eldenark;

/**
 *
 * @author egame
 *
 */
public class Warrior extends Character {

	
	//Constructors
	// MAIN
	public Warrior(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, String role, Object[] inventory) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage, role, inventory);
	}

	// ENEMIES
	//Ns si poner la clase
	public Warrior(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage);
	}
	
	// Constructor
	
		@Override
	public void changeWeapon(Equip[] equipment, Equip newEquip) {
		this.setDamage(this.getDamage() - equipment[0].getProfit());
		equipment[0] = newEquip;
		this.setDamage(this.getDamage() + equipment[0].getProfit());
	}
	
	@Override
	public void weapons(){
		Equip basicWeapon = new Equip("Basic Weapon", "Weapon", 5);
		Equip firstWeapon = new Equip("Fidelity Greatsword", "Weapon", 10);
		Equip secondWeapon = new Equip("Dimensional Greatsword", "Weapon", 20);
		Equip thirdWeapon = new Equip("Seraphic Oath Greatsword", "Weapon", 50);
		newWeapons[0] = basicWeapon;
		newWeapons[1] = firstWeapon;
		newWeapons[2] = secondWeapon;
		newWeapons[3] = thirdWeapon;
	}
	
	@Override
	public void helmet(){
		Equip basicHelmet = new Equip("Basic Helmet", "Helmet", 2);
		Equip firstHelmet = new Equip("Mask of Fallen Might", "Helmet", 4);
		Equip secondHelmet = new Equip("Terror of Fury", "Helmet", 8);
		Equip thirdHelmet = new Equip("Soul of the Banished", "Helmet", 15);
		newHelmets[0] = basicHelmet;
		newHelmets[1] = firstHelmet;
		newHelmets[2] = secondHelmet;
		newHelmets[3] = thirdHelmet;
	
	}
	
	@Override
	public void chestplate(){
		Equip basicChestplate = new Equip("Basic ChestPlate", "Chestplate", 5);
		Equip firstChestplate = new Equip("Burden of Fire", "Chestplate", 10);
		Equip secondChestplate = new Equip("Keeper of the Sky", "Chestplate", 20);
		Equip thirdChestplate = new Equip("Terror Cuirass of Wraiths", "Chestplate", 50);
		newChestPlates[0] = basicChestplate;
		newChestPlates[1] = firstChestplate;
		newChestPlates[2] = secondChestplate;
		newChestPlates[3] = thirdChestplate;
	}
	
	@Override
	public void legArmor(){
		Equip basicLegArmor = new Equip("Basic Leg Armor", "Leg Armor", 2);
		Equip firstLegArmor = new Equip("Leather Legwraps", "Leg Armor", 5);
		Equip secondLegArmor = new Equip("Liar's Silk Breeches", "Leg Armor", 10);
		Equip thirdLegArmor = new Equip("Bane of Diligence", "Leg Armor", 20);
		newLegArmors[0] = basicLegArmor;
		newLegArmors[1] = firstLegArmor;
		newLegArmors[2] = secondLegArmor;
		newLegArmors[3] = thirdLegArmor;
	}
	
	
}
