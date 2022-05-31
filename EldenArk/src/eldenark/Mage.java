package eldenark;

/**
 *
 * @author egame
 *
 */
public class Mage extends Character {

	public static final String maleMapLookingDownPath = "/FOTOS ELDEN ARK/MAIN CHARACTER MAP/MAGE/MAGE_M_FRONT.png";
	public static final String femaleMapLookingDownPath = "/FOTOS ELDEN ARK/MAIN CHARACTER MAP/MAGE/MAGE_W_FRONT.png";
	public static final String maleCombatPath = "/FOTOS ELDEN ARK/MAIN CHARACTER/MAGE_M.png";
	public static final String femaleCombatPath = "/FOTOS ELDEN ARK/MAIN CHARACTER/MAGE_W.png";
	
	
	// MAIN 
<<<<<<< HEAD
	public Mage(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, String role, ObjectP[] inventory) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage, role, inventory);
=======
	public Mage(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, int sex, Object[] inventory, String nickname) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage, sex, inventory, nickname);
	}

	//FOR LOADING FILE
	public Mage(int lvl, int xp, int hp, int mp, int x, int y, int gold, int sex, Object[] inventory, int weapon, int helmet, int chest, int leg, String nickname) {
		super(lvl, xp, hp, mp, x, y, gold, sex, inventory, weapon, helmet, chest, leg, nickname);
>>>>>>> development
	}

	// ENEMY
	//Ns si poner la clase
	public Mage(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, int type, int floor) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage, type, floor);
	}

	//Methods
	@Override
	public void getOtherStatsFromLevel(int level) {
		if (level == 1) {
			this.setDamage(12);
			this.setDefence(5);
			this.setMaxHP(100);
			this.setMaxMP(160);
			this.setSpecialDamage(25);
		} else {
			this.setDamage((int) (12 * 1.2) * (level - 1));
			this.setDefence((int) (5 * 1.2) * (level - 1));
			this.setMaxHP((int) (100 * 1.2) * (level - 1));
			this.setMaxMP((int) (160 * 1.2) * (level - 1));
			this.setSpecialDamage((int) (25 * 1.2) * (level - 1));
			this.setMaxXP((int) (100 * 1.5) * (level - 1));
		}

	}

	@Override
	public void changeWeapon(Equip[] equipment, Equip newEquip) {
		this.setSpecialDamage(this.getSpecialDamage() - equipment[0].getProfit());
		equipment[0] = newEquip;
		this.setSpecialDamage(this.getSpecialDamage() + equipment[0].getProfit());
	}

	// Constructor
	@Override
	public void weapons() {
		Equip basicWeapon = new Equip("Basic Rod", "Weapon", 5);
		Equip firstWeapon = new Equip("Peacekeeper", "Weapon", 10);
		Equip secondWeapon = new Equip("Thundersoul Warden Staff", "Weapon", 20);
		Equip thirdWeapon = new Equip("Apocalypse", "Weapon", 50);
		Equip forthWeapon = new Equip("Proud Battletome", "Weapon", 70);
		newWeapons[0] = basicWeapon;
		newWeapons[1] = firstWeapon;
		newWeapons[2] = secondWeapon;
		newWeapons[3] = thirdWeapon;
		newWeapons[4] = forthWeapon;
	}

	@Override
	public void helmet() {
		Equip basicHelmet = new Equip("Hat", "Helmet", 2);
		Equip firstHelmet = new Equip("Adamantite Helm", "Helmet", 4);
		Equip secondHelmet = new Equip("Blight of Justice", "Helmet", 8);
		Equip thirdHelmet = new Equip("Wit of Souls", "Helmet", 15);
		Equip forthHelmet = new Equip("Death of the Dead", "Helmet", 25);
		newHelmets[0] = basicHelmet;
		newHelmets[1] = firstHelmet;
		newHelmets[2] = secondHelmet;
		newHelmets[3] = thirdHelmet;
		newHelmets[4] = forthHelmet;

	}

	@Override
	public void chestplate() {
		Equip basicChestplate = new Equip("Gray Cloth Vest", "Chestplate", 3);
		Equip firstChestplate = new Equip("Confessor Armor", "Chestplate", 10);
		Equip secondChestplate = new Equip("Cuckoo Surcoat", "Chestplate", 20);
		Equip thirdChestplate = new Equip("Depraved Perfumer Robe", "Chestplate", 50);
		Equip forthChestplate = new Equip("Prime Vest of Ice", "Chestplate", 65);
		newChestPlates[0] = basicChestplate;
		newChestPlates[1] = firstChestplate;
		newChestPlates[2] = secondChestplate;
		newChestPlates[3] = thirdChestplate;
		newChestPlates[4] = forthChestplate;
	}

	@Override
	public void legArmor() {
		Equip basicLegArmor = new Equip("Bandit Boots", "Leg Armor", 2);
		Equip firstLegArmor = new Equip("White Bull-Goat Greave", "Leg Armor", 5);
		Equip secondLegArmor = new Equip("Golden Leggings", "Leg Armor", 10);
		Equip thirdLegArmor = new Equip("Clown's Breeches", "Leg Armor", 20);
		Equip forthLegArmor = new Equip("Ruby Boots", "Leg Armor", 30);
		newLegArmors[0] = basicLegArmor;
		newLegArmors[1] = firstLegArmor;
		newLegArmors[2] = secondLegArmor;
		newLegArmors[3] = thirdLegArmor;
		newLegArmors[4] = forthLegArmor;
	}

	@Override
	public void setAbilityNames() {
		abilities[0] = "Fireball";
		abilities[1] = "Translation";
		abilities[2] = "Frost Nova";
		abilities[3] = "Thunder Weather";
	}

	@Override
	public int abilities(Character enemy, int enemyOption) {

		String abilitiesMage[] = {"Fireball", "Translation", "Frost Nova", "Thunder Weather", "Silvermoon"};

		int option;

		boolean control = false;

		do {

			System.out.println("What ability do you want to use??");

			for (int i = 0; i < ((this.getLevel() / 5) + 1); i++) {

				System.out.println((i + 1) + "- " + abilitiesMage[i]);

			}

			option = Teclat.llegirInt();

			if (option <= ((this.getLevel() / 5) + 1) && option >= 1) {

				control = true;

			} else {

				System.out.println("The ability is not avilable");

			}

		} while (!control);

		switch (option) {

			case 1:

				if (this.getMp() >= 20) {

					int damageDone = (((this.getSpecialDamage() * 4) - enemy.getDefence()));

					enemy.setHp(enemy.getHp() - damageDone);

					this.setMp(this.getMp() - 20);

					System.out.println("\nYou used " + abilitiesMage[option - 1] + " on the enemy.");
					System.out.println("You did " + damageDone + " damage to the enemy.");
					System.out.println("-20 Mana");

				} else {

					System.out.println("You don't have mana");
					enemyOption = 2;
				}

				break;

			case 2:

				if (this.getMp() >= 40) {

					int damageDone = (((this.getSpecialDamage() * 5) - enemy.getDefence()));

					enemy.setHp(enemy.getHp() - damageDone);

					this.setMp(this.getMp() - 40);

					System.out.println("\nYou used " + abilitiesMage[option - 1] + " on the enemy.");
					System.out.println("You did " + damageDone + " damage to the enemy.");
					System.out.println("-40 Mana");

				} else {

					System.out.println("You don't have mana");
					enemyOption = 2;
				}

				break;

			case 3:

				if (this.getMp() >= 60) {

					int damageDone = (((this.getSpecialDamage() * 6) - enemy.getDefence()));

					enemy.setHp(enemy.getHp() - damageDone);

					this.setMp(this.getMp() - 60);

					System.out.println("\nYou used " + abilitiesMage[option - 1] + " on the enemy.");
					System.out.println("You did " + damageDone + " damage to the enemy.");
					System.out.println("-60 Mana");

				} else {

					System.out.println("You don't have mana");
					enemyOption = 2;
				}

				break;

			case 4:

				if (this.getMp() >= 80) {

					int damageDone = (((this.getSpecialDamage() * 7) - enemy.getDefence()));

					enemy.setHp(enemy.getHp() - damageDone);

					this.setMp(this.getMp() - 80);

					System.out.println("\nYou used " + abilitiesMage[option - 1] + " on the enemy.");
					System.out.println("You did " + damageDone + " damage to the enemy.");
					System.out.println("-80 Mana");

				} else {

					System.out.println("You don't have mana");
					enemyOption = 2;

				}

				break;

		}
		return enemyOption;
	}

	@Override
	public void getImagePath() {
		if (sex == 0) {
			this.setCharacterLookingUp("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/MAGE/MAGE_M_BACK.png");
			this.setCharacterLookingLeft("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/MAGE/MAGE_M_LEFT.png");
			this.setCharacterLookingDown("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/MAGE/MAGE_M_FRONT.png");
			this.setCharacterLookingRight("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/MAGE/MAGE_M_RIGHT.png");
		} else {
			this.setCharacterLookingUp("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/MAGE/MAGE_W_BACK.png");
			this.setCharacterLookingLeft("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/MAGE/MAGE_W_LEFT.png");
			this.setCharacterLookingDown("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/MAGE/MAGE_W_FRONT.png");
			this.setCharacterLookingRight("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/MAGE/MAGE_W_RIGHT.png");
		}
	}

	@Override
	public void getCombatImage() {
		if (sex == 0) {
			this.setMainCharacterImg("/FOTOS ELDEN ARK/MAIN CHARACTER/MAGE_M.png");
		} else {
			this.setMainCharacterImg("/FOTOS ELDEN ARK/MAIN CHARACTER/MAGE_W.png");
		}
	}
}
