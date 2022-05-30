package eldenark;

/**
 *
 * @author egame
 *
 */
public class Priest extends Character {

	public static final String maleMapLookingDownPath = "/FOTOS ELDEN ARK/MAIN CHARACTER MAP/PRIEST/PRIEST_M_FRONT.png";
	public static final String femaleMapLookingDownPath = "/FOTOS ELDEN ARK/MAIN CHARACTER MAP/PRIEST/PRIEST_W_FRONT.png";
	public static final String maleCombatPath = "/FOTOS ELDEN ARK/MAIN CHARACTER/PRIEST_M.png";
	public static final String femaleCombatPath = "/FOTOS ELDEN ARK/MAIN CHARACTER/PRIEST_W.png";
	
	// MAIN
	public Priest(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, int sex, Object[] inventory, String nickname) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage, sex, inventory, nickname);
	}

	//FOR LOADING FILE
	public Priest(int lvl, int xp, int hp, int mp, int x, int y, int gold, int sex, Object[] inventory, int weapon, int helmet, int chest, int leg, String nickname) {
		super(lvl, xp, hp, mp, x, y, gold, sex, inventory, weapon, helmet, chest, leg, nickname);
	}

	// ENEMIES
	//Ns si poner la clase
	public Priest(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, int type, int floor) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage, type, floor);
	}

	// Constructor
	@Override
	public void getOtherStatsFromLevel(int level) {
		if (level == 1) {
			this.setDamage(15);
			this.setDefence(10);
			this.setMaxHP(120);
			this.setMaxMP(120);
			this.setSpecialDamage(15);
		} else {
			this.setDamage((int) (15 * 1.2) * (level - 1));
			this.setDefence((int) (10 * 1.2) * (level - 1));
			this.setMaxHP((int) (120 * 1.2) * (level - 1));
			this.setMaxMP((int) (120 * 1.2) * (level - 1));
			this.setSpecialDamage((int) (15 * 1.2) * (level - 1));
			this.setMaxXP((int) (100 * 1.5) * (level - 1));
		}

	}

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
		Equip basicWeapon = new Equip("Basic Spellbook", "Weapon", 5);
		Equip firstWeapon = new Equip("Lorekeeper", "Weapon", 10);
		Equip secondWeapon = new Equip("Eternal Lexicon", "Weapon", 20);
		Equip thirdWeapon = new Equip("Souleater", "Weapon", 50);
		Equip forthWeapon = new Equip("Diabolical Codex", "Weapon", 70);
		newWeapons[0] = basicWeapon;
		newWeapons[1] = firstWeapon;
		newWeapons[2] = secondWeapon;
		newWeapons[3] = thirdWeapon;
		newWeapons[4] = forthWeapon;
	}

	@Override
	public void helmet() {
		Equip basicHelmet = new Equip("Mask of Confidence", "Helmet", 2);
		Equip firstHelmet = new Equip("Monk Hood", "Helmet", 4);
		Equip secondHelmet = new Equip("Albinauric Mask", "Helmet", 8);
		Equip thirdHelmet = new Equip("Astrologer Hood", "Helmet", 15);
		Equip forthHelmet = new Equip("Grand Monk Hood", "Helmet", 25);
		newHelmets[0] = basicHelmet;
		newHelmets[1] = firstHelmet;
		newHelmets[2] = secondHelmet;
		newHelmets[3] = thirdHelmet;
		newHelmets[4] = forthHelmet;

	}

	@Override
	public void chestplate() {
		Equip basicChestplate = new Equip("Basic Tunic", "Chestplate", 3);
		Equip firstChestplate = new Equip("Alberich's Robe", "Chestplate", 10);
		Equip secondChestplate = new Equip("Azur's Glintstone Robe", "Chestplate", 20);
		Equip thirdChestplate = new Equip("God Monk Robe", "Chestplate", 50);
		Equip forthChestplate = new Equip("Sun God Tunic", "Chestplate", 65);
		newChestPlates[0] = basicChestplate;
		newChestPlates[1] = firstChestplate;
		newChestPlates[2] = secondChestplate;
		newChestPlates[3] = thirdChestplate;
		newChestPlates[4] = forthChestplate;
	}

	@Override
	public void legArmor() {
		Equip basicLegArmor = new Equip("Confessor Boots", "Leg Armor", 2);
		Equip firstLegArmor = new Equip("Kaiden Iron Legs", "Leg Armor", 5);
		Equip secondLegArmor = new Equip("Sun Noble Waistcloth", "Leg Armor", 10);
		Equip thirdLegArmor = new Equip("God of Sun Skirt", "Leg Armor", 20);
		Equip forthLegArmor = new Equip("Gift of the Prince", "Leg Armor", 30);
		newLegArmors[0] = basicLegArmor;
		newLegArmors[1] = firstLegArmor;
		newLegArmors[2] = secondLegArmor;
		newLegArmors[3] = thirdLegArmor;
		newLegArmors[4] = forthLegArmor;
	}

	@Override
	public void setAbilityNames() {
		abilities[0] = "Power Infusion";
		abilities[1] = "Punishment";
		abilities[2] = "Jump of Faith";
		abilities[3] = "Levitation";
	}

	@Override
	public int abilities(Character enemy, int enemyOption) {
		String abilitiesPriest[] = {"Power Infusion", "Punishment", "Jump of faith", "Levitation", "Desperate prayer"};
		int option;

		boolean control = false;

		int tempHp = this.getHp();

		do {

			System.out.println("What ability do you want to use??");

			for (int i = 0; i < ((this.getLevel() / 5) + 1); i++) {

				System.out.println((i + 1) + "- " + abilitiesPriest[i]);

			}

			option = Teclat.llegirInt();

			if (option <= ((this.getLevel() / 5) + 1) && option >= 1) {

				control = true;

			} else {

				System.out.println("The ability is not avilable");

			}

		} while (!control);

		switch (option) {

			// Hability 1 heals the Character   
			case 1:

				if (this.getMp() >= 20) {

					if (this.getHp() < this.getMaxHP()) {

						int healed = this.getSpecialDamage() * 4;

						this.setHp(this.getHp() + healed);

						this.setMp(this.getMp() - 20);

						if (this.getHp() > this.getMaxHP()) {

							this.setHp(this.checkMaxValues(this.getHp(), this.getMaxHP()));

							healed = this.getHp() - tempHp;

						}

						System.out.println("\nYou used " + abilitiesPriest[option - 1] + " on the enemy.");
						System.out.println("You healed " + healed + " Hp.");
						System.out.println("-20 Mana");

					} else {

						System.out.println("You have max HP");

					}

				} else {

					System.out.println("You don't have mana");
					enemyOption = 2;

				}

				break;

			// Hability 2 does damage    
			case 2:

				if (this.getMp() >= 40) {

					int damageDone = (this.getSpecialDamage() * 4) - enemy.getDefence();

					enemy.setHp(enemy.getHp() - damageDone);

					this.setMp(this.getMp() - 40);

					System.out.println("\nYou used " + abilitiesPriest[option - 1] + " on the enemy.");
					System.out.println("You did " + damageDone + " damage to the enemy.");
					System.out.println("-40 Mana");

				} else {

					System.out.println("You don't have mana");
					enemyOption = 2;
				}

				break;

			// Hability 3 heals the Character    
			case 3:

				if (this.getMp() >= 60) {

					if (this.getHp() < this.getMaxHP()) {

						int healed = this.getSpecialDamage() * 6;

						this.setHp(this.getHp() + healed);

						this.setMp(this.getMp() - 60);

						if (this.getHp() > this.getMaxHP()) {

							this.setHp(this.checkMaxValues(this.getHp(), this.getMaxHP()));

							healed = this.getHp() - tempHp;;

						}

						System.out.println("\nYou used " + abilitiesPriest[option - 1] + " on the enemy.");
						System.out.println("You heales " + healed + " Hp.");
						System.out.println("-60 Mana");

					} else {

						System.out.println("You have max HP");

					}

				} else {

					System.out.println("You don't have mana");
					enemyOption = 2;
				}

				break;

			// Hability 4 does damage    
			case 4:

				if (this.getMp() >= 80) {

					int damageDone = (this.getSpecialDamage() * 6) - enemy.getDefence();

					enemy.setHp(enemy.getHp() - damageDone);

					this.setMp(this.getMp() - 80);

					System.out.println("\nYou used " + abilitiesPriest[option - 1] + " on the enemy.");
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
			this.setCharacterLookingUp("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/PRIEST/PRIEST_M_BACK.png");
			this.setCharacterLookingLeft("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/PRIEST/PRIEST_M_LEFT.png");
			this.setCharacterLookingDown("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/PRIEST/PRIEST_M_FRONT.png");
			this.setCharacterLookingRight("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/PRIEST/PRIEST_M_RIGHT.png");
		} else {
			this.setCharacterLookingUp("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/PRIEST/PRIEST_W_BACK.png");
			this.setCharacterLookingLeft("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/PRIEST/PRIEST_W_LEFT.png");
			this.setCharacterLookingDown("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/PRIEST/PRIEST_W_FRONT.png");
			this.setCharacterLookingRight("/FOTOS ELDEN ARK/MAIN CHARACTER MAP/PRIEST/PRIEST_W_RIGHT.png");
		}
	}

	@Override
	public void getCombatImage() {
		if (sex == 0) {
			this.setMainCharacterImg("/FOTOS ELDEN ARK/MAIN CHARACTER/PRIEST_M.png");
		} else {
			this.setMainCharacterImg("/FOTOS ELDEN ARK/MAIN CHARACTER/PRIEST_W.png");
		}
	}
}
