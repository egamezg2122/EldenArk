package eldenark;

import static eldenark.EldenArk.rn;
import java.util.InputMismatchException;

public class Character {

	// Main atributes
	private int level;

	private int xp; // Experience Points

	private int maxXP;

	private int damage;

	private int defence;

	protected int hp; // Health Points

	protected int maxHP;

	protected int mp; // Mana Points

	protected int maxMP;

	private int specialDamage;

	private int gold = 10;

	private String nickname;

	private int x = 20; // Position in the map

	private int y = 10; // Position in the map

	protected Object[] inventory = new Object[4]; // Testing inventory

	private Equip[] equipment = new Equip[4];

	//For new Equipment
	protected Equip[] newWeapons = new Equip[5];

	protected Equip[] newHelmets = new Equip[5];

	protected Equip[] newChestPlates = new Equip[5];

	protected Equip[] newLegArmors = new Equip[5];

	private String characterLookingUp;

	private String characterLookingLeft;

	private String characterLookingDown;

	private String characterLookingRight;

	private String mainCharacterImg;

	private String enemyImg = "FOTOS ELDEN ARK/ENEMY/1 FLOOR/MAGE.PNG";

	public int sex = 0; //0 - male / 1 - women
	
	protected String[] abilities = new String[4];

	// Constructors
	// Constructor for MAIN CHARACTER
	public Character(int damage, int defence, int hp, int maxHP, int mp, int maxMP, int specialDamage, int sex, Object[] inventory, String nickname) {

		this.level = 1; // Always start at level 1
		
		this.xp = 0; // Experience always start at 0

		this.maxXP = 100;

		this.damage = damage;

		this.defence = defence;

		this.hp = hp;

		this.maxHP = maxHP;

		this.mp = mp;

		this.maxMP = maxMP;

		this.specialDamage = specialDamage;

		this.sex = sex;

		this.inventory = inventory;

		this.nickname = nickname;

		weapons();
		helmet();
		chestplate();
		legArmor();

		equipment[0] = newWeapons[0];
		equipment[1] = newHelmets[0];
		equipment[2] = newChestPlates[0];
		equipment[3] = newLegArmors[0];

		addEquip(equipment);

		getImagePath();

		getCombatImage();
		
		setAbilityNames();

	}

	// Constructor for ENEMIES
	public Character(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, int type, int floor) {
		this.damage = damage;
		this.defence = defense;
		this.hp = hp;
		this.maxHP = maxHP;
		this.mp = mp;
		this.maxMP = maxMP;
		this.specialDamage = specialDamage;
		this.nickname = enemyName(type, this, floor);

	}

	//from loadFile
	public Character(int lvl, int xp, int hp, int mp, int x, int y, int gold, int sex,
			Object[] inventory, int weapon, int helmet, int chest, int leg, String nickname) {
		this.level = lvl;

		this.xp = xp;

		this.hp = hp;

		this.mp = mp;

		this.x = x;

		this.y = y;

		this.gold = gold;

		this.sex = sex;

		getOtherStatsFromLevel(this.level);

		this.inventory = inventory;

		this.nickname = nickname;

		weapons();
		helmet();
		chestplate();
		legArmor();

		equipment[0] = newWeapons[weapon];
		equipment[1] = newHelmets[helmet];
		equipment[2] = newChestPlates[chest];
		equipment[3] = newLegArmors[leg];

		addEquip(equipment);

		getImagePath();
		
		getCombatImage();
		
		setAbilityNames();
	}

	public Character() {
	}

	//METHODS
	public void levelUp() {
		level++;
		damage = (int) (damage * 1.2);
		defence = (int) (defence * 1.2);
		specialDamage = (int) (specialDamage * 1.2);
		hp = (int) ((maxHP * 1.2) - (maxHP - hp));
		maxHP = (int) (maxHP * 1.2);
		mp = (int) ((maxMP * 1.2) - (maxMP - mp));
		maxMP = (int) (maxMP * 1.2);
		xp = 0;
		maxXP *= 1.5;
		if (level % 5 == 0) {
			//get new hability
			System.out.println("NEW ABILITY UNLOCKED");
		}
	}

	public void checkLevelUp(int experience) {
		if (level == 24) {
			System.out.println("You have reached the max level. You can't gain more experience");
			this.setMaxXP(0);
			this.setXp(0);
		} else if (this.xp + experience > this.maxXP) {
			System.out.println("LEVEL UP!");
			showStats();
			levelUp();
			System.out.println("\n");
			showStats();
		} else {
			System.out.print("EXP: " + this.xp + " -> ");
			this.xp += experience;
			System.out.println(this.xp + "/" + this.maxXP);
		}

	}

	//Funtion for showing the stats of the character
	public String showStats() {
		/*
		The first String has a maximum length of 15 and has 25 blank spaces. The text is left justified.
		Then, right jutifed we have the value of each atribute
		 */
		String levelS = "LEVEL:       " + level;
		String damageS = "DAMAGE:       " + damage;
		String defenceS = "DEFENCE:       " + defence;
		String specialDmgS = "SPECIAL DAMAGE:     " + specialDamage;
		String hpS = "HP:       " + hp + "/" + maxHP;
		String mpS = "MP:       " + mp + "/" + maxMP;
		String xpS = "EXP:      " + xp + "/" + maxXP;
		String goldS = "GOLD:        " + gold;
		
		String toReturn = "";
		toReturn = toReturn.concat(levelS);
		toReturn = toReturn.concat("\n" + damageS);
		toReturn = toReturn.concat("\n" + defenceS);
		toReturn = toReturn.concat("\n" + specialDmgS);
		toReturn = toReturn.concat("\n" + hpS);
		toReturn = toReturn.concat("\n" + mpS);
		toReturn = toReturn.concat("\n" + xpS);
		toReturn = toReturn.concat("\n" + goldS);
		
		
		
		/*
		String toReturn = String.format("%-25.15s %-10d", "LEVEL", level) + "\n" + String.format("%-25.15s %10d", "Damage", damage) + "\n" +
			String.format("%-25.15s %-10d", "Defense", defence) + "\n" + String.format("%-25.15s %10d", "Special Damage", specialDamage) +  "\n" +
				String.format("%-25.15s %10s", "HP", hp + "/" + maxHP) + "\n" + String.format("%-25.15s %10s", "MP", mp + "/" + maxMP) +  "\n" +
					String.format("%-25.15s %10s", "EXP", xp + "/" + maxXP) + "\n" + String.format("%-25.15s %10d", "GOLD", gold);
		System.out.println("");
		System.out.println(String.format("%-25.15s %10d", "LEVEL", level));
		System.out.println(String.format("%-25.15s %10d", "Damage", damage));
		System.out.println(String.format("%-25.15s %10d", "Defense", defence));
		System.out.println(String.format("%-25.15s %10d", "Special Damage", specialDamage));
		System.out.println(String.format("%-25.15s %10s", "HP", hp + "/" + maxHP));
		System.out.println(String.format("%-25.15s %10s", "MP", mp + "/" + maxMP));
		System.out.println(String.format("%-25.15s %10s", "EXP", xp + "/" + maxXP));
		System.out.println("");
		System.out.println(String.format("%-25.15s %10d", "GOLD", gold));*/
		
		return toReturn;
	}

	//DO THE OVERRIDE ONES
	public void getOtherStatsFromLevel(int level) {

	}

	public void moveUP() {
		y--;
	}

	public void moveDown() {
		y++;
	}

	public void moveRight() {
		x++;
	}

	public void moveLeft() {
		x--;
	}

	public int fightMenu(boolean objectsUses) {
		int option = -1;
		System.out.println("\n1-Basic Attack" + "\n2-Defend" + "\n3-Special Abilities" + "\n4-Objects");
		try {
			option = Teclat.llegirInt();
			boolean object = objectsUses;
			if (option == 4 && !object) {
				option = checkOption4(option, object);
			}
		} catch (InputMismatchException e) {
			option = -1;
		}
		return option;
	}

	public void basicAttack(Character enemy, int defenceEnemy) {
		int damageDone = this.damage - defenceEnemy;
		System.out.println("\nYou used a basic attack.");
		if (damageDone > 0) {
			enemy.setHp(enemy.getHp() - damageDone);
			System.out.println("You did " + (damageDone) + " damage.");
		} else {
			System.out.println("You did 0 damage. The enemy's defense is to powerfull");
		}

	}

	public void enemyBasicAttack(Character enemy, int defenceChar) {
		int damageDone = enemy.getDamage() - defenceChar;
		System.out.println("\nThe enemy used his basic attack.");
		if (damageDone > 0) {
			this.hp = hp - damageDone;
			System.out.println("The enemy did " + (damageDone) + " damage.");
		} else {
			System.out.println("The enemy did 0 damage to you. Your defense is incredible");
		}

	}

	public int defend(Character enemy, int defenceChar) {
		System.out.println("\nYour defense has aumented for this turn");
		defenceChar *= 1.3;
		return defenceChar;
	}

	public int enemyDefend(Character enemy, int defenceEnemy) {
		System.out.println("\nThe enemy auments his defense");
		defenceEnemy *= 1.3;
		return defenceEnemy;
	}

	public void enemySpecialAbilities(Character enemy, int defenceChar) {
		int damageDone = enemy.getSpecialDamage() - defenceChar;
		if (enemy.getMp() >= 40) {
			if (damageDone > 0) {
				this.hp = hp - damageDone;
				System.out.println("The enemy uses his special ability.");
				System.out.println("The enemy did " + (damageDone) + " damage.");

			} else {
				System.out.println("The enemy uses his special ability.");
				System.out.println("The enemy did 0 damage to you. Wow, how did you not get hurt!?");
			}
			enemy.setMp(enemy.getMp() - 80);
			if (enemy.getMp() < 0) {
				enemy.setMp(0);
			}
		} else {
			enemyBasicAttack(enemy, defenceChar);
		}

	}

	public int defenceCheckedEnemy(Character enemy, int defenceEnemy) {
		defenceEnemy = enemy.getDefence();
		return defenceEnemy;
	}

	public boolean checkObjects() {
		int noUses = 0;
		boolean use = true;
		for (int i = 0; i < this.inventory.length; i++) {
			if (this.inventory[i].getNumOfUses() == 0) {
				noUses++;
			}
		}
		if (noUses == 4) {
			use = false;
		}
		return use;
	}

	public int objects(int enemyaction) {
		int actualEnemyOption = enemyaction;
		int option;
		boolean on = true;
		do {
			System.out.println("\nWhat object do you want to use?");
			for (int i = 0; i < this.inventory.length; i++) {
				System.out.println(i + "- " + String.format("%-25.25s %10d", this.inventory[i].getName(), this.inventory[i].getNumOfUses()));
			}
			System.out.println("4- " + String.format("%-25.25s", "Go back"));
			option = Teclat.llegirInt();
			if (option == 4) {
				on = false;
				actualEnemyOption = 2;
			} else if (option > 4) {
				on = true;
				System.err.println("Invalid option");
			} else if (this.inventory[option].getNumOfUses() > 0) {
				System.out.println(this.inventory[option].getDescription());
				if (confirmation()) {
					this.inventory[option].use(this);
					on = false;
				}
			} else {
				System.out.println("\nYou don't have this potion anymore.");
			}
		} while (on);
		return actualEnemyOption;
	}

	public boolean confirmation() {
		char afirmation;
		boolean object;
		System.out.println("Are you sure do you want to use this object? Y/N");
		afirmation = Teclat.llegirChar();
		if (afirmation == 'Y' || afirmation == 'y') {
			object = true;
		} else {
			object = false;
		}
		return object;
	}

	public int checkMaxValues(int value, int max) {
		if (value > max) {
			value = max;
		}
		return value;
	}

	/* public void interfaceFight(int map[][], Character mainCharacter, Character enemy, int floor, String nickname) {
	String enemyName = enemyName(map, enemy, floor);
	System.out.println("\n\n" + nickname + "(YOU)" + " (" + this.getClass().getName().substring(9) + ")");
	System.out.println(String.format("%-25.15s %10s", "HP", hp + "/" + maxHP));
	System.out.println(String.format("%-25.15s %10s", "MP", mp + "/" + maxMP));
	System.out.println("\n\n" + enemyName);
	System.out.println(String.format("%-25.15s %10s", "HP", enemy.getHp() + "/" + enemy.getMaxHP()));
	System.out.println(String.format("%-25.15s %10s", "MP", enemy.getMp() + "/" + enemy.getMaxMP()));
	
	}*/
	//ENEMIES NAMES
	public String enemyName(int type, Character enemy, int floor) {
		String enemyName = null;
		/*
		Enemy type
			2 - normal enemy
			4 - miniboss
			7 - boss
		 */
		int enemyType = type;
		int enemyClass = getEnemyClass(enemy);
		switch (floor) {
			case 1:
				enemyName = nameDefinitionF1(enemyType, enemyClass, enemy);
				break;
			case 2:
				enemyName = nameDefinitionF2(enemyType, enemyClass, enemy);
				break;
			case 3:
				enemyName = nameDefinitionF3(enemyType, enemyClass, enemy);
				break;
			case 4:
				enemyName = nameDefinitionF4(enemyType, enemyClass, enemy);
				break;
			default:
				enemyName = enemy.getClass().getTypeName().substring(9).toUpperCase();
		}

		return enemyName;
	}

	public String nameDefinitionF1(int enemyType, int enemyClass, Character enemy) {
		String name;
		switch (enemyType) {
			case 2:
				name = normalEnemyNameF1(enemyClass);
				break;
			case 4:
				name = miniBossNameF1(enemyClass);
				break;
			case 7:
				name = finalBossNameF1(enemyClass);
				break;
			default:
				name = enemy.getClass().getTypeName().substring(9).toUpperCase();
		}
		return name;
	}

	public String nameDefinitionF2(int enemyType, int enemyClass, Character enemy) {
		String name;
		switch (enemyType) {
			case 2:
				name = normalEnemyNameF2(enemyClass);
				break;
			case 4:
				name = miniBossNameF2(enemyClass);
				break;
			case 7:
				name = finalBossNameF2(enemyClass);
				break;
			default:
				name = enemy.getClass().getTypeName().substring(9).toUpperCase();
		}
		return name;
	}

	public String nameDefinitionF3(int enemyType, int enemyClass, Character enemy) {
		String name;
		switch (enemyType) {
			case 2:
				name = normalEnemyNameF3(enemyClass);
				break;
			case 4:
				name = miniBossNameF3(enemyClass);
				break;
			case 7:
				name = finalBossNameF3(enemyClass);
				break;
			default:
				name = enemy.getClass().getTypeName().substring(9).toUpperCase();
		}
		return name;
	}

	public String nameDefinitionF4(int enemyType, int enemyClass, Character enemy) {
		String name;
		switch (enemyType) {
			case 2:
				name = normalEnemyNameF4(enemyClass);
				break;
			case 4:
				name = miniBossNameF4(enemyClass);
				break;
			case 7:
				name = finalBossNameF4(enemyClass);
				break;
			default:
				name = enemy.getClass().getTypeName().substring(9).toUpperCase();
		}
		return name;
	}

	public String normalEnemyNameF1(int enemyClass) {
		String name;
		switch (enemyClass) {
			case 1:
				name = "Soldier of Elderfell (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/1 FLOOR/WARRIOR.png");
				break;
			case 2:
				name = "Monk of the Lord Ark (Priest)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/1 FLOOR/PRIEST.png");
				break;
			case 3:
				name = "Amateur Wizard (Mage)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/1 FLOOR/MAGE.png");
				break;
			default:
				name = "Soldier of Elderfell (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/1 FLOOR/WARRIOR.png");
		}
		return name;
	}

	public String normalEnemyNameF2(int enemyClass) {
		String name;
		switch (enemyClass) {
			case 1:
				name = "Demon Soldier of Kushan (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/2 FLOOR/WARRIOR.png");
				break;
			case 2:
				name = "Friar of Ubik (Priest)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/2 FLOOR/PRIEST.png");
				break;
			case 3:
				name = "Low-Class Elf (Mage)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/2 FLOOR/MAGE.png");
				break;
			default:
				name = "Demon Soldier of Kushan(Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/2 FLOOR/WARRIOR.png");
		}
		return name;
	}

	public String normalEnemyNameF3(int enemyClass) {
		String name;
		switch (enemyClass) {
			case 1:
				name = "Mesh's Cavalry (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/3 FLOOR/WARRIOR.png");
				break;
			case 2:
				name = "White Abbot (Priest)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/3 FLOOR/PRIEST.png");
				break;
			case 3:
				name = "Old Rot Wizard (Mage)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/3 FLOOR/MAGE.png");
				break;
			default:
				name = "Mesh's Cavalry (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/3 FLOOR/WARRIOR.png");
		}
		return name;
	}

	public String normalEnemyNameF4(int enemyClass) {
		String name;
		switch (enemyClass) {
			case 1:
				name = "Giant with a Mace (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/4 FLOOR/WARRIOR.png");
				break;
			case 2:
				name = "Follower of Frederic (Priest)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/4 FLOOR/PRIEST.png");
				break;
			case 3:
				name = "Black Magician (Mage)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/4 FLOOR/MAGE.png");
				break;
			default:
				name = "Giant with a Maze (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/4 FLOOR/WARRIOR.png");
		}
		return name;
	}

	public String miniBossNameF1(int enemyClass) {
		String name;
		switch (enemyClass) {
			case 1:
				name = "Demi-Human (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/1 FLOOR/MINIBOSS_WARRIOR.png");
				break;
			case 2:
				name = "Grand Bishop (Priest)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/1 FLOOR/MINIBOSS_PRIEST.png");
				break;
			case 3:
				name = "Ancestor Wizard (Mage)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/1 FLOOR/MINIBOSS_MAGE.png");
				break;
			default:
				name = "Demi-Human (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/1 FLOOR/MINIBOSS_WARRIOR.png");
		}
		return name;
	}

	public String miniBossNameF2(int enemyClass) {
		String name;
		switch (enemyClass) {
			case 1:
				name = "Moon Knight (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/2 FLOOR/MINIBOSS_WARRIOR.png");
				break;
			case 2:
				name = "God Hand (Priest)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/2 FLOOR/MINIBOSS_PRIEST.png");
				break;
			case 3:
				name = "Great Witch (Mage)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/2 FLOOR/MINIBOSS_MAGE.png");
				break;
			default:
				name = "Moon Knight (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/2 FLOOR/MINIBOSS_WARRIOR.png");
		}
		return name;
	}

	public String miniBossNameF3(int enemyClass) {
		String name;
		switch (enemyClass) {
			case 1:
				name = "Bloody Beast (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/3 FLOOR/MINIBOSS_WARRIOR.png");
				break;
			case 2:
				name = "Cardenal of Lord Void (Priest)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/3 FLOOR/MINIBOSS_PRIEST.png");
				break;
			case 3:
				name = "Servant of Caster (Mage)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/3 FLOOR/MINIBOSS_MAGE.png");
				break;
			default:
				name = "Bloody Beast (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/3 FLOOR/MINIBOSS_WARRIOR.png");
		}
		return name;
	}

	public String miniBossNameF4(int enemyClass) {
		String name;
		switch (enemyClass) {
			case 1:
				name = "Beast Titan (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/4 FLOOR/MINIBOSS_WARRIOR.png");
				break;
			case 2:
				name = "Great Archbishop (Priest)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/4 FLOOR/MINIBOSS_PRIEST.png");
				break;
			case 3:
				name = "Aklesh's Greatest Follower (Mage)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/4 FLOOR/MINIBOSS_MAGE.png");
				break;
			default:
				name = "Beast Titan (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/4 FLOOR/MINIBOSS_WARRIOR.png");
		}
		return name;
	}

	public String finalBossNameF1(int enemyClass) {
		String name;
		switch (enemyClass) {
			case 1:
				name = "Wind Giant, Wind God (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/1 FLOOR/BOSS_WARRIOR.png");
				break;
			case 2:
				name = "Fanni the Greatest, Four Hands Queen (Priest)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/1 FLOOR/BOSS_PRIEST.png");
				break;
			case 3:
				name = "Midland Ancestor Spirit, Midland Hope (Mage)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/1 FLOOR/BOSS_MAGE.png");
				break;
			default:
				name = "Wind Giant, Wind God (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/1 FLOOR/BOSS_WARRIOR.png");
		}
		return name;
	}

	public String finalBossNameF2(int enemyClass) {
		String name;
		switch (enemyClass) {
			case 1:
				name = "Skull Knight, The Vengeance (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/2 FLOOR/BOSS_WARRIOR.png");
				break;
			case 2:
				name = "Femto, The Black Falcon (Priest)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/2 FLOOR/BOSS_PRIEST.png");
				break;
			case 3:
				name = "Beherit, God's Right Hand (Mage)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/2 FLOOR/BOSS_MAGE.png");
				break;
			default:
				name = "Skull Knight, The Vengeance (Warrior)";
		}
		return name;
	}

	public String finalBossNameF3(int enemyClass) {
		String name;
		switch (enemyClass) {
			case 1:
				name = "Mesh, The King of Heroes (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/3 FLOOR/BOSS_WARRIOR.png");
				break;
			case 2:
				name = "Lord Void, The Nothing (Priest)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/3 FLOOR/BOSS_PRIEST.png");
				break;
			case 3:
				name = "Caster, The Queen of Everything (Mage)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/3 FLOOR/BOSS_MAGE.png");
				break;
			default:
				name = "Mesh, The King of Heroes (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/3 FLOOR/BOSS_WARRIOR.png");
		}
		return name;
	}

	public String finalBossNameF4(int enemyClass) {
		String name;
		switch (enemyClass) {
			case 1:
				name = "Troll, Troll (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/4 FLOOR/BOSS_WARRIOR.png");
				break;
			case 2:
				name = "Frederic, Pope of All Living Beings (Priest)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/4 FLOOR/BOSS_PRIEST.png");
				break;
			case 3:
				name = "Aklesh, the Demon Summoner (insert epic battle music) (Mage)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/4 FLOOR/BOSS_MAGE.png");
				break;
			default:
				name = "Troll, Troll (Warrior)";
				this.setEnemyImg("/FOTOS ELDEN ARK/ENEMY/4 FLOOR/BOSS_WARRIOR.png");
		}
		return name;
	}

	private int getEnemyClass(Character enemy) {
		int classEnemy;
		switch (enemy.getClass().getTypeName().substring(9).toUpperCase()) {
			case "WARRIOR":
				classEnemy = 1;
				break;
			case "PRIEST":
				classEnemy = 2;
				break;
			case "MAGE":
				classEnemy = 3;
				break;
			default:
				classEnemy = 1;
		}
		return classEnemy;
	}

	//ENEMIES ACTIONS
	public int enemyActions() {
		int optionEnemy;
		optionEnemy = rn.nextInt(2);
		return optionEnemy;

	}

	public void enemyAttacks(Character enemy, int defenceChar, int defenceEnemy) {
		int optionAttack;
		optionAttack = rn.nextInt(2);
		switch (optionAttack) {
			case 0:
				//BASIC ATTACK
				enemyBasicAttack(enemy, defenceChar);
				break;
			case 1:
				//SPECIAL ABILITY
				enemySpecialAbilities(enemy, defenceChar);

		}
	}

	//CHECK IF THERE IS OJECTS TO USE
	public int checkOption4(int option, boolean objectUses) {
		boolean object = objectUses;
		if (option == 4 && !object) {
			System.out.println("\nYou dont have any objects to use.");
			boolean back = true;
			do {
				System.out.println("Choose other option");
				option = Teclat.llegirInt();
				if (option <= 0 || option > 3) {
					back = false;
				} else {
					back = true;
				}
			} while (!back);
		}
		return option;
	}

	//FIGHTS
	public void fight(int map[][], Character enemy, int floor) {
		int option, enemyOption;
		int mainDef = this.getDefence();
		int enemyDef = enemy.getDefence();
		boolean objectsUses;
		do {
			objectsUses = checkObjects();
			//interfaceFight(map, this, enemy, floor, nickname);
			System.out.println("\nHow are you gonna fight?");
			option = fightMenu(objectsUses);
			enemyOption = enemyActions();
			if (enemyOption == 0 && (option >= 1 && option <= 4)) {
				enemyDef = enemyDefend(enemy, enemyDef);
			}
			switch (option) {
				case 1:
					//BASIC ATTACK
					basicAttack(enemy, enemyDef);
					break;
				case 2:
					//DEFEND
					mainDef = defend(enemy, mainDef);
					break;
				case 3:
					//SPECIAL ABILITIES
					enemyOption = abilities(enemy, enemyOption);
					break;
				case 4:
					//OBJECTS
					enemyOption = objects(enemyOption);
					this.hp = checkMaxValues(hp, maxHP);
					this.mp = checkMaxValues(mp, maxMP);
					break;
				default:
					System.err.println("Invalid option");
			}
			if (enemy.getHp() > 0 && (option >= 1 && option <= 4)) {
				if (enemyOption == 1) {
					enemyAttacks(enemy, mainDef, enemyDef);
				}
			}
			enemyDef = defenceCheckedEnemy(enemy, enemyDef);
			mainDef = this.getDefence();
		} while ((enemy.getHp() > 0 && this.hp > 0));
		//interfaceFight(map, this, enemy, floor, nickname);
		if (enemy.getHp() <= 0) {
			System.out.println("\nCongrats, you defeated the enemy.");
		} else {
			System.out.println("\nYOU DIED.");
		}
	}

	public void showInventory() {
		System.out.println("");
		for (int i = 0; i < inventory.length; i++) {
			System.out.println(i + "- " + String.format("%-20.20s %-42.42s %-9.9s", inventory[i].getName(), ("+" + inventory[i].getDescription()), "|" + inventory[i].getNumOfUses()));
		}
	}

	public void showEquipment() {
		System.out.println("");
		System.out.println(String.format("%-18.18s %17.17s", "Equipment name", "Stats"));
		System.out.println(String.format("%-20.20s %5.5s %9.9s", equipment[0].getName(), ("+" + equipment[0].getProfit()), " damage"));
		for (int i = 1; i < equipment.length; i++) {
			System.out.println(String.format("%-20.20s %5.5s %9.9s", equipment[i].getName(), ("+" + equipment[i].getProfit()), " defense"));
		}

	}

	// Generate a random enemy
	/* public static Character generateEnemy() {
	Character enemy = new Character();
	int n = rn.nextInt(3);
	switch (n) {
	case 0:
	enemy = new Warrior(5, 5, 20, 20, 5, 5, 5);
	break;
	case 1:
	enemy = new Mage(5, 5, 20, 20, 5, 5, 5);
	break;
	case 2:
	enemy = new Priest(5, 5, 20, 20, 5, 5, 5);
	}
	return enemy;
	}*/
	public void addEquip(Equip[] equipment) {
		this.setDamage(this.getDamage() + equipment[0].getProfit());
		for (int i = 1; i < equipment.length; i++) {
			this.setDefence(this.getDefence() + equipment[i].getProfit());
		}
	}

	public void changeEquip(Equip[] equipment, Equip newEquip) {
		switch (newEquip.getType()) {
			case "Weapon":
				changeWeapon(equipment, newEquip);
				break;
			case "Helmet":
				changeDefenseEquipment(equipment, newEquip, 1);
				break;
			case "Chestplate":
				changeDefenseEquipment(equipment, newEquip, 2);
				break;
			case "Leg Armor":
				changeDefenseEquipment(equipment, newEquip, 3);
				break;

		}

	}

	public void changeWeapon(Equip[] equipment, Equip newEquip) {
		this.setDamage(this.getDamage() - equipment[0].getProfit());
		equipment[0] = newEquip;
		this.setDamage(this.getDamage() + equipment[0].getProfit());
	}

	public void changeDefenseEquipment(Equip[] equipment, Equip newEquip, int i) {
		this.setDefence(this.getDefence() - equipment[i].getProfit());
		equipment[i] = newEquip;
		this.setDefence(this.getDefence() + equipment[i].getProfit());
	}

	// Getters
	public int getLevel() {

		return level;

	}

	public int getXp() {

		return xp;

	}

	public int getDamage() {

		return damage;

	}

	public int getDefence() {

		return defence;

	}

	public int getHp() {

		return hp;

	}

	public int getMaxHP() {

		return maxHP;

	}

	public int getMp() {

		return mp;

	}

	public int getMaxMP() {

		return maxMP;

	}

	public int getSpecialDamage() {

		return specialDamage;

	}

	public int getGold() {
		return gold;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Object[] getInventory() {
		return inventory;
	}

	public Equip[] getEquipment() {
		return equipment;
	}

	// Setters
	public void setLevel(int level) {

		this.level = level;

	}

	public void setXp(int xp) {

		this.xp = xp;

	}

	public void setDamage(int damage) {

		this.damage = damage;

	}

	public void setDefence(int defence) {

		this.defence = defence;

	}

	public void setHp(int hp) {

		this.hp = hp;

	}

	public void setMaxHP(int maxHP) {

		this.maxHP = maxHP;

	}

	public void setMp(int mp) {

		this.mp = mp;

	}

	public void setMaxMP(int maxMP) {

		this.maxMP = maxMP;

	}

	public void setSpecialDamage(int specialDamage) {

		this.specialDamage = specialDamage;

	}

	public void setGold(int gold) {
		this.gold = gold;
	}


	public void setMaxXP(int maxXP) {
		this.maxXP = maxXP;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int abilities(Character enemy, int enemyoption) {
		int enemyOption = 0;
		return enemyOption;
	}

	public void weapons() {

	}

	public void helmet() {

	}

	public void chestplate() {

	}

	public void legArmor() {

	}

	public void getImagePath() {

	}

	public void getCombatImage() {

	}

	public void setCharacterLookingUp(String characterLookingUp) {
		this.characterLookingUp = characterLookingUp;
	}

	public void setCharacterLookingLeft(String characterLookingLeft) {
		this.characterLookingLeft = characterLookingLeft;
	}

	public void setCharacterLookingDown(String characterLookingDown) {
		this.characterLookingDown = characterLookingDown;
	}

	public void setCharacterLookingRight(String characterLookingRight) {
		this.characterLookingRight = characterLookingRight;
	}

	public void setMainCharacterImg(String mainCharacterImg) {
		this.mainCharacterImg = mainCharacterImg;
	}

	public String getMainCharacterImg() {
		return mainCharacterImg;
	}

	public String getEnemyImg() {
		return enemyImg;
	}

	public void setEnemyImg(String enemyImg) {
		this.enemyImg = enemyImg;
	}

	public String getCharacterLookingUp() {
		return characterLookingUp;
	}

	public String getCharacterLookingLeft() {
		return characterLookingLeft;
	}

	public String getCharacterLookingDown() {
		return characterLookingDown;
	}

	public String getCharacterLookingRight() {
		return characterLookingRight;
	}

	public int getSex() {
		return sex;
	}

	public Equip[] getNewWeapons() {
		return newWeapons;
	}

	public Equip[] getNewHelmets() {
		return newHelmets;
	}

	public Equip[] getNewChestPlates() {
		return newChestPlates;
	}

	public Equip[] getNewLegArmors() {
		return newLegArmors;
	}

	public String getNickname() {
		return nickname;
	}
	
	public void setAbilityNames(){
		 
	}

}
