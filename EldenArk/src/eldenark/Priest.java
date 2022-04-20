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
	@Override
	public void changeWeapon(Equip[] equipment, Equip newEquip) {
		this.setDefence(this.getDefence() - equipment[0].getProfit());
		this.setMaxMP(this.getMaxMP() - equipment[0].getProfit());
		equipment[0] = newEquip;
		this.setDefence(this.getDefence() + equipment[0].getProfit());
		this.setMaxMP(this.getMaxMP() + equipment[0].getProfit());
		this.setMp(this.getMp() + equipment[0].getProfit());
	}

	@Override
	public void weapons() {
		Equip basicWeapon = new Equip("Basic Spellbook", "WeaponType", 5);
		Equip firstWeapon = new Equip("Lorekeeper", "WeaponType", 10);
		Equip secondWeapon = new Equip("Eternal Lexicon", "WeaponType", 20);
		Equip thirdWeapon = new Equip("Souleater", "WeaponType", 50);
		newWeapons[0] = basicWeapon;
		newWeapons[1] = firstWeapon;
		newWeapons[2] = secondWeapon;
		newWeapons[3] = thirdWeapon;
	}

	@Override
	public void helmet() {
		Equip basicHelmet = new Equip("Mask of Confidence", "HelmetType", 2);
		Equip firstHelmet = new Equip("Monk Hood", "HelmetType", 4);
		Equip secondHelmet = new Equip("Albinauric Mask", "HelmetType", 8);
		Equip thirdHelmet = new Equip("Astrologer Hood", "HelmetType", 15);
		newHelmets[0] = basicHelmet;
		newHelmets[1] = firstHelmet;
		newHelmets[2] = secondHelmet;
		newHelmets[3] = thirdHelmet;

	}

	@Override
	public void chestplate() {
		Equip basicChestplate = new Equip("Basic Tunic", "ChestType", 5);
		Equip firstChestplate = new Equip("Alberich's Robe", "ChestType", 10);
		Equip secondChestplate = new Equip("Azur's Glintstone Robe", "ChestType", 20);
		Equip thirdChestplate = new Equip("God Monk Robe", "ChestType", 50);
		newChestPlates[0] = basicChestplate;
		newChestPlates[1] = firstChestplate;
		newChestPlates[2] = secondChestplate;
		newChestPlates[3] = thirdChestplate;
	}

	@Override
	public void legArmor() {
		Equip basicLegArmor = new Equip("Confessor Boots", "LegType", 2);
		Equip firstLegArmor = new Equip("Kaiden Iron Legs", "LegType", 5);
		Equip secondLegArmor = new Equip("Lionel's Greaves", "LegType", 10);
		Equip thirdLegArmor = new Equip("God of Sun Greaves", "LegType", 20);
		newLegArmors[0] = basicLegArmor;
		newLegArmors[1] = firstLegArmor;
		newLegArmors[2] = secondLegArmor;
		newLegArmors[3] = thirdLegArmor;
	}
}
