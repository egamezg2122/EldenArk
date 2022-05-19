package eldenark;

/**
 *
 * @author egame
 *
 */
public class Warrior extends Character {

	//Constructors
	// MAIN
	public Warrior(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, String role, Object[] inventory, String nickname) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage, role, inventory, nickname);
	}

	//FOR LOADING FILE
	public Warrior(int lvl, int xp, int hp, int mp, int x, int y, int gold, int sex, Object[] inventory, int weapon, int helmet, int chest, int leg, String nickname) {
		super(lvl, xp, hp, mp, x, y, gold, sex, inventory, weapon, helmet, chest, leg, nickname);
	}

	// ENEMIES
	//Ns si poner la clase
	public Warrior(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, int type, int floor) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage, type, floor);
	}

	// Constructor
	@Override
	public void getOtherStatsFromLevel(int level) {
		if (level == 1) {
			this.setDamage(25);
			this.setDefence(15);
			this.setMaxHP(140);
			this.setMaxMP(60);
			this.setSpecialDamage(15);
		} else {
			this.setDamage((int) (25 * 1.2) * (level - 1));
			this.setDefence((int) (15 * 1.2) * (level - 1));
			this.setMaxHP((int) (140 * 1.2) * (level - 1));
			this.setMaxMP((int) (60 * 1.2) * (level - 1));
			this.setSpecialDamage((int) (15 * 1.2) * (level - 1));
		}

	}

	@Override
	public void changeWeapon(Equip[] equipment, Equip newEquip) {
		this.setDamage(this.getDamage() - equipment[0].getProfit());
		equipment[0] = newEquip;
		this.setDamage(this.getDamage() + equipment[0].getProfit());
	}

	@Override
	public void weapons() {
		Equip basicWeapon = new Equip("Basic Weapon", "Weapon", 5);

		Equip firstWeapon = new Equip("Fidelity Greatsword", "Weapon", 10);

		Equip secondWeapon = new Equip("Dimensional Greatsword", "Weapon", 20);

		Equip thirdWeapon = new Equip("Seraphic Oath Greatsword", "Weapon", 50);

		Equip forthWeapon = new Equip("Hope's End", "Weapon", 70);

		newWeapons[0] = basicWeapon;

		newWeapons[1] = firstWeapon;

		newWeapons[2] = secondWeapon;

		newWeapons[3] = thirdWeapon;

		newWeapons[4] = forthWeapon;
	}

	@Override
	public void helmet() {

		Equip basicHelmet = new Equip("Basic Helmet", "Helmet", 2);

		Equip firstHelmet = new Equip("Mask of Fallen Might", "Helmet", 4);

		Equip secondHelmet = new Equip("Terror of Fury", "Helmet", 8);

		Equip thirdHelmet = new Equip("Soul of the Banished", "Helmet", 15);

		Equip forthHelmet = new Equip("Wit of Dark Souls", "Helmet", 25);

		newHelmets[0] = basicHelmet;

		newHelmets[1] = firstHelmet;

		newHelmets[2] = secondHelmet;

		newHelmets[3] = thirdHelmet;

		newHelmets[4] = forthHelmet;

	}

	@Override
	public void chestplate() {

		Equip basicChestplate = new Equip("Basic ChestPlate", "Chestplate", 3);

		Equip firstChestplate = new Equip("Burden of Fire", "Chestplate", 10);

		Equip secondChestplate = new Equip("Keeper of the Sky", "Chestplate", 20);

		Equip thirdChestplate = new Equip("Terror Cuirass of Wraiths", "Chestplate", 50);

		Equip forthChestplate = new Equip("Lonely Golden Vest", "Chestplate", 65);

		newChestPlates[0] = basicChestplate;

		newChestPlates[1] = firstChestplate;

		newChestPlates[2] = secondChestplate;

		newChestPlates[3] = thirdChestplate;

		newChestPlates[4] = forthChestplate;

	}

	@Override
	public void legArmor() {

		Equip basicLegArmor = new Equip("Basic Leg Armor", "Leg Armor", 2);

		Equip firstLegArmor = new Equip("Leather Legwraps", "Leg Armor", 5);

		Equip secondLegArmor = new Equip("Liar's Silk Breeches", "Leg Armor", 10);

		Equip thirdLegArmor = new Equip("Bane of Diligence", "Leg Armor", 20);

		Equip forthLegArmor = new Equip("Blight of Assassins", "Leg Armor", 30);

		newLegArmors[0] = basicLegArmor;

		newLegArmors[1] = firstLegArmor;

		newLegArmors[2] = secondLegArmor;

		newLegArmors[3] = thirdLegArmor;

		newLegArmors[4] = forthLegArmor;
	}

	@Override
	public void setAbilityNames(){
		abilities[0] = "Thor's Hammer";
		abilities[1] = "Ram load";
		abilities[2] = "Battle cry";
		abilities[3] = "Double edge";
	}
	
	@Override
	public int abilities(Character enemy, int enemyOption) {

		String abilitiesWarrior[] = {"Thor's Hammer", "Ram load", "Battle cry", "Double edge", "Heroic jump"};

		int option;

		boolean control = false;

		do {

			System.out.println("What ability do you want to use?");

			if (this.getRole().equals("Warrior")) {

				for (int i = 0; i < ((this.getLevel() / 5) + 1); i++) {

					System.out.println((i + 1) + "- " + abilitiesWarrior[i]);

				}
			}

			option = Teclat.llegirInt();

			if (option <= ((this.getLevel() / 5) + 1) && option >= 1) {

				control = true;

			} else {

				System.out.println("The ability is not available");

			}

		} while (!control);

		switch (option) {

			case 1:

				if (this.getMp() >= 20) {

					int damageDone = ((this.getSpecialDamage() * 4) - enemy.getDefence());

					enemy.setHp(enemy.getHp() - damageDone);

					this.setMp(this.getMp() - 20);

					System.out.println("\nYou used " + abilitiesWarrior[option - 1] + " on the enemy.");
					System.out.println("You did " + damageDone + " damage to the enemy.");
					System.out.println("-20 Mana");

				} else {

					System.out.println("You don't have mana");
					enemyOption = 2;

				}

				break;

			case 2:

				if (this.getMp() >= 40) {

					int damageDone = ((this.getSpecialDamage() * 5) - enemy.getDefence());

					enemy.setHp(enemy.getHp() - damageDone);

					this.setMp(this.getMp() - 40);

					System.out.println("\nYou used " + abilitiesWarrior[option - 1] + " on the enemy.");
					System.out.println("You did " + damageDone + " damage to the enemy.");
					System.out.println("-40 Mana");

				} else {

					System.out.println("You don't have mana");
					enemyOption = 2;

				}

				break;

			case 3:

				if (this.getMp() >= 60) {

					int damageDone = ((this.getSpecialDamage() * 6) - enemy.getDefence());

					enemy.setHp(enemy.getHp() - damageDone);

					this.setMp(this.getMp() - 60);

					System.out.println("\nYou used " + abilitiesWarrior[option - 1] + " on the enemy.");
					System.out.println("You did " + damageDone + " damage to the enemy.");
					System.out.println("-60 Mana");

				} else {

					System.out.println("You don't have mana");
					enemyOption = 2;
				}

				break;

			case 4:

				if (this.getMp() >= 80) {

					int damageDone = ((this.getSpecialDamage() * 7) - enemy.getDefence());

					enemy.setHp(enemy.getHp() - damageDone);

					this.setMp(this.getMp() - 80);

					System.out.println("\nYou used " + abilitiesWarrior[option - 1] + " on the enemy.");
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
			this.setCharacterLookingUp("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/WARRIOR/WARRIOR_M_BACK.png");
			this.setCharacterLookingLeft("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/WARRIOR/WARRIOR_M_LEFT.png");
			this.setCharacterLookingDown("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/WARRIOR/WARRIOR_M_FRONT.png");
			this.setCharacterLookingRight("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/WARRIOR/WARRIOR_M_RIGHT.png");
		} else {
			this.setCharacterLookingUp("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/WARRIOR/WARRIOR_W_BACK.png");
			this.setCharacterLookingLeft("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/WARRIOR/WARRIOR_W_LEFT.png");
			this.setCharacterLookingDown("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/WARRIOR/WARRIOR_W_FRONT.png");
			this.setCharacterLookingRight("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/WARRIOR/WARRIOR_W_RIGHT.png");
		}
	}

	@Override
	public void getCombatImage() {
		if (sex == 0) {
			this.setMainCharacterImg("/FOTOS ELDEN ARK/MAIN CHARACTER/WARRIOR_M.png");
		} else {
			this.setMainCharacterImg("/FOTOS ELDEN ARK/MAIN CHARACTER/WARRIOR_W.png");
		}
	}
}
