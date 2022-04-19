package eldenark;

import static eldenark.EldenArk.rn;

public class Character {

	// Main atributes
	private int level;

	private int xp; // Experience Points

	private int maxXP;

	private int damage;

	private int defense;

	private int hp; // Health Points

	private int maxHP;

	private int mp; // Mana Points

	private int maxMP;

	private int specialDamage;

	private int gold;
        
        private String role;

	private int x = 10; // Position in the map

	private int y = 2; // Position in the map

	private Object[] inventory = new Object[4]; // Testing inventory

	private Equip[] equipment = new Equip[4];

	// Constructors
	// Constructor for MAIN CHARACTER
	public Character(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, String role, Object[] inventory, Equip[] equipment) {

		this.level = 1; // Always start at level 1

		this.xp = 0; // Experience always start at 0
		
		this.maxXP = 1000;

		this.maxXP = 100;

		this.damage = damage;

		this.defense = defense;

		this.hp = hp;

		this.maxHP = maxHP;

		this.mp = mp;

		this.maxMP = maxMP;

		this.specialDamage = specialDamage;
                
                this.role = role;

		this.inventory = inventory;

		this.equipment = equipment;
	}

	// Constructor for ENEMIES
	public Character(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage) {
		this.damage = damage;
		this.defense = defense;
		this.hp = hp;
		this.maxHP = maxHP;
		this.mp = mp;
		this.maxMP = maxMP;
		this.specialDamage = specialDamage;
	}

	public Character() {

	}

	//METHODS
	//ESTARIA BIEN QUE LVLUP FUESE ABSTRACT
	public void levelUp() {
		level++;
		damage = damage * 2;
		defense = defense * 2;
		specialDamage = specialDamage * 2;
		hp = (maxHP * 2) - (maxHP - hp);
		maxHP = maxHP * 2;
		mp = (maxMP * 2) - (maxMP - mp);
		maxMP = maxMP * 2;
		xp = 0;
		maxXP *= 2;
		if (level % 5 == 0) {
			//get new hability
			System.out.println("NEW ABILITY UNLOCKED");
		}
	}
	
	public void checkLevelUp(int experience) {
		if (this.xp + experience > this.maxXP) {
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
	public void showStats() {
		/*
		The first String has a maximum length of 15 and has 25 blank spaces. The text is left justified.
		Then, right jutifed we have the value of each atribute
		 */
		System.out.println(String.format("%-25.15s %10d", "LEVEL", level));
		System.out.println(String.format("%-25.15s %10d", "Damage", damage));
		System.out.println(String.format("%-25.15s %10d", "Defense", defense));
		System.out.println(String.format("%-25.15s %10d", "Special Damage", specialDamage));
		System.out.println(String.format("%-25.15s %10s", "HP", hp + "/" + maxHP));
		System.out.println(String.format("%-25.15s %10s", "MP", mp + "/" + maxMP));
		System.out.println(String.format("%-25.15s %10s", "EXP", xp + "/" + maxXP));
	}

	/*	public void move() {
	int option;
	do {
	System.out.println("Which direction do you want to move?\n\t1 - Up\n\t2 - Down\n\t3 - Right\n\t4 - Left");
	option = Teclat.llegirInt();
	switch (option) {
	case 1:
	y++;
	break;
	case 2:
	y--;
	break;
	case 3:
	x++;
	break;
	case 4:
	x--;
	break;
	default:
	System.err.println("Not a valid option\nTry Again");
	}
	} while (option < 1 && option > 4);
	
	}*/
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
		System.out.println("\n1-Basic Attack" + "\n2-Defend" + "\n3-Special Abilities" + "\n4-Objects");
		int option = Teclat.llegirInt();
		boolean object = objectsUses;
		if (option == 4 && !object) {
			option = checkOption4(option, object);
		}
		return option;
	}


	public void basicAttack(Character enemy, int defenceEnemy) {
		System.out.println("\nYou used a basic attack.");
		enemy.setHp(enemy.getHp() - (this.damage - defenceEnemy));
		System.out.println("You did " + (this.damage - defenceEnemy) + " damage.");
	}

	public void enemyBasicAttack(Character enemy, int defenceChar) {
		System.out.println("\nThe enemy used his basic attack.");
		this.hp = hp - (enemy.getDamage() - defenceChar);
		System.out.println("The enemy did " + (enemy.getDamage() - defenceChar) + " damage.");
	}

	public int defend(Character enemy, int defenceChar) {
		System.out.println("\nYour defense has aumented for this turn");
		defenceChar *= 1.5;
		return defenceChar;
	}

	public int enemyDefend(Character enemy, int defenceEnemy) {
		System.out.println("\nThe enemy auments his defense");
		defenceEnemy *= 1.5;
		return defenceEnemy;
	}

	public void specialAbilities(Character enemy, int defenceEnemy) {
		System.out.println("\nYou used your special ability.");
		enemy.setHp(enemy.getHp() - (this.specialDamage - defenceEnemy));
		System.out.println("You did " + (this.specialDamage - defenceEnemy) + " damage.");
	}

	public void enemySpecialAbilities(Character enemy, int defenceChar) {
		System.out.println("\nThe enemy used his special ability.");
		this.hp = hp - (enemy.getSpecialDamage() - defenceChar);
		System.out.println("The enemy did " + (enemy.getSpecialDamage() - defenceChar) + " damage.");
	}

	public int defenceCheckedEnemy(Character enemy, int defenceEnemy) {
		defenceEnemy = enemy.getDefense();
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

	public void objects() {
		int option;
		boolean on = true;
		do {
			System.out.println("\nWhat object do you want to use?");
			for (int i = 0; i < this.inventory.length; i++) {
				System.out.println(i + "- " + String.format("%-25.15s %10d", this.inventory[i].getName(), this.inventory[i].getNumOfUses()));
			}
			option = Teclat.llegirInt();
			if (this.inventory[option].getNumOfUses() > 0) {
				System.out.println(this.inventory[option].getDescription());
				if (confirmation()) {
					this.inventory[option].use(this);
					on = false;
				}
			} else {
				System.out.println("\nYou don't have this potion anymore.");
			}
		} while (on);


		/*
		System.out.println("What Potion do you want to use?");
		System.out.println("\n\t1- Use healing potion \n\t2- Use mana regeneration potion");
		showInventory();
		int option;
		option = Teclat.llegirInt();
		switch (option) {
			case 1:
				//HEALING OPTION
				this.hp = hp + (maxHP * 30 / 100);
				checkMaxValues(hp, maxHP);
				break;
			case 2:
				//MANA REGENERATION
				this.mp = mp + (maxMP * 30 / 100);
				checkMaxValues(mp, maxMP);
				break;
			default:
				System.err.println("\nInvalid option");
		}
		 */
	}

	public boolean confirmation() {
		char afirmation;
		boolean x;
		System.out.println("Are you sure do you want to use this object? Y/N");
		afirmation = Teclat.llegirChar();
		if (afirmation == 'Y' || afirmation == 'y') {
			x = true;
		} else {
			x = false;
		}
		return x;
	}

	public int checkMaxValues(int value, int max) {
		if (value > max) {
			value = max;
		}
		return value;
	}

	public void interfaceFight(Character enemy) {
		System.out.println("\n\nYOU");
		System.out.println(String.format("%-25.15s %10s", "HP", hp + "/" + maxHP));
		System.out.println(String.format("%-25.15s %10s", "MP", mp + "/" + maxMP));
		System.out.println("\nENEMY");
		System.out.println(String.format("%-25.15s %10s", "HP", enemy.getHp() + "/" + enemy.getMaxHP()));
		System.out.println(String.format("%-25.15s %10s", "MP", enemy.getMp() + "/" + enemy.getMaxMP()));

	}

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

	public void fight(Character enemy) {
		int option, enemyOption;
		int mainDef = this.getDefense();
		int enemyDef = enemy.getDefense();
		boolean objectsUses;
		do {
			objectsUses = checkObjects();
			interfaceFight(enemy);
			System.out.println("\nHow are you gonna fight?");
			option = fightMenu(objectsUses);
			enemyOption = enemyActions();
			if (enemyOption == 0 &&(option >= 1 && option <=4)) {
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
                                        new Ability(this, enemy);
					specialAbilities(enemy, enemyDef);
					break;
				case 4:
					//OBJECTS
					objects();
					this.hp = checkMaxValues(hp, maxHP);
					this.mp = checkMaxValues(mp, maxMP);
					break;
				default:
					System.err.println("\nInvalid option");
			}
			if (enemy.getHp() > 0 && (option >= 1 && option <=4)) {
				if (enemyOption == 1) {
					enemyAttacks(enemy, mainDef, enemyDef);
				}
			}
			enemyDef = defenceCheckedEnemy(enemy, enemyDef);
			mainDef = this.getDefense();
		} while ((enemy.getHp() > 0 && this.hp > 0));
		interfaceFight(enemy);
		if (enemy.getHp() <= 0) {
			System.out.println("\nCongrats, you defeated the enemy.");
			//XP
			System.out.println("You got");
			//CHECKEAR LEVEL POR SI SUBE DE NIVEL.
			//CHECKLEVEL
			//GENERARLOOT
		} else {
			System.out.println("\nYOU DIED.");
		}
	}

	public void menu() {
		int op;
		do {
			System.out.println("\nMENU\n");
			System.out.println("What do you want to do?");
			System.out.println("\n\t0- Exit the game \n\t1- Move the character \n\t2- Fight \n\t3- Loot \n\t4- Show inventory \n\t5- Check stats \n\t6- Show equipment");
			//SE TIENE QUE CHECKEAR LA CASILLA
			Character enemy = generateEnemy();
			//Print the menu
			op = Teclat.llegirInt();
			switch (op) {
				case 0:
					//EXIT THE GAME
					break;
				case 1:
					//MOVE
					//move();
					break;
				case 2:
					//FIGHT
					fight(enemy);
					break;
				case 3:
					//LOOT
					break;
				case 4:
					//INVENTORY
					showInventory();
					break;
				case 5:
					//CHECK STATS
					showStats();
					break;
				case 6:
					//EQUIPMENT
					showEquipment();
					break;
				default:
					System.err.println("\nError,invalid option." + " \nTry again");
			}
		} while (op != 0);

	}

	public void showInventory() {
		for (int i = 0; i < inventory.length; i++) {
			System.out.println(inventory[i].toString());
		}
	}

	public void showEquipment() {
		System.out.println(String.format("%-18.18s %14.14s", "Equipment name", "Stats"));
		System.out.println("\n" + String.format("%-20.20s %2.2s %9.9s", equipment[0].getName(), ("+" + equipment[0].getProfit()), " damage"));
		for (int i = 1; i < equipment.length; i++) {
			System.out.println(String.format("%-20.20s %2.2s %9.9s", equipment[i].getName(), ("+" + equipment[i].getProfit()), " defense"));
		}

	}

	// Generate a random enemy
	public static Character generateEnemy() {
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
	}

	public void addEquip(Equip[] equipment) {
		this.setDamage(this.getDamage() + equipment[0].getProfit());
		for (int i = 1; i < equipment.length; i++) {
			this.setDefense(this.getDefense() + equipment[i].getProfit());
		}
	}

	public void changeEquip(Equip[] equipment, Equip newEquip) {
		switch (newEquip.getType()) {
			case "WeaponType":
				changeWeapon(equipment, newEquip);
			case "HelmetType":
				changeDefenseEquipment(equipment, newEquip, 1);
			case "ChestType":
				changeDefenseEquipment(equipment, newEquip, 2);
			case "LegType":
				changeDefenseEquipment(equipment, newEquip, 3);

		}

	}

	public void changeWeapon(Equip[] equipment, Equip newEquip) {
		this.setDamage(this.getDamage() - equipment[0].getProfit());
		equipment[0] = newEquip;
		this.setDamage(this.getDamage() + equipment[0].getProfit());
	}

	public void changeDefenseEquipment(Equip[] equipment, Equip newEquip, int i) {
		this.setDefense(this.getDefense() - equipment[i].getProfit());
		equipment[i] = newEquip;
		this.setDefense(this.getDefense() + equipment[i].getProfit());
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

	public int getDefense() {

		return defense;

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
        
        public String getRole() {
		return role;
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

	public void setDefense(int defense) {

		this.defense = defense;

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
        
        public void setRole(String role) {
		this.role = role;
	}
}
