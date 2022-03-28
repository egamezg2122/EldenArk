package eldenark;

import static eldenark.EldenArk.rn;

public class Character {

	// Main atributes
	private int level;

	private int xp; // Experience Points

	private int damage;

	private int defense;

	private int hp; // Health Points

	private int maxHP;

	private int mp; // Mana Points

	private int maxMP;

	private int specialDamage;

	private int x = 5; // Position in the map

	private int y = 5; // Position in the map

	private Object[] inventory = new Object[4]; // Testing inventory

	// Constructors
	// Constructor for MAIN CHARACTER
	public Character(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, Object[] inventory) {

		this.level = 1; // Always start at level 1

		this.xp = 0; // Experience always start at 0

		this.damage = damage;

		this.defense = defense;

		this.hp = hp;

		this.maxHP = maxHP;

		this.mp = mp;

		this.maxMP = maxMP;

		this.specialDamage = specialDamage;

		this.inventory = inventory;

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
		if (level % 5 == 0) {
			//get new hability
			System.out.println("NEW ABILITY MARICONNNNN");
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
	}

	public void move() {
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

	}

	//ES NECESITADO EL CAMBIO A ESTA SECCION DEL CODIGO
	public int fightMenu() {
		System.out.println("\n1-Basic Attack" + "\n2-Defend" + "\n3-Special Abilities" + "\n4-Objects");
		return Teclat.llegirInt();
	}

	public void basicAttack(Character enemy) {
		enemy.setHp(enemy.getHp() - damage);
	}

	public void enemyBasicAttack(Character enemy) {
		this.hp = hp - enemy.getDamage();
	}

	public void defend(Character enemy) {
		this.hp = hp - (enemy.getDamage() - defense);
	}

	public void enemyDefend(Character enemy) {
		enemy.setHp(enemy.getHp() - (this.damage - enemy.getDefense()));
	}

	public void specialAbilities(Character enemy) {
		enemy.setHp(enemy.getHp() - specialDamage);
	}

	public void enemySpecialAbilities(Character enemy) {
		this.hp = hp - enemy.getSpecialDamage();
	}

	public void objects() {
		int option;
		System.out.println("What object do you want to use?");
		for (int i = 0; i < this.inventory.length; i++) {
				System.out.println(String.format("%-25.15s %10d", this.inventory[i].getName(), this.inventory[i].getNumOfUses()));
		}
		option = Teclat.llegirInt();
		if (this.inventory[option].getNumOfUses() > 0) {
			System.out.println(this.inventory[option].getDescription());
			System.out.println("Are you sure do you want to use this object?");
			if (confirmation()) {
				this.inventory[option].use();
			} else{
				
			}
			
		}
		
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

	public boolean confirmation(){
		char afirmation;
		boolean x;
		System.out.println("Are you sure do you want to use this object? Y/N");
		afirmation = Teclat.llegirChar();
		if (afirmation == 'Y' || afirmation == 'y') {
			x = true;
		} else{
			x = false;
		}
		return x;
	}
	
	
	public void checkMaxValues(int value, int max) {
		if (value > max) {
			value = max;
		}
	}

	public void interfaceFight(Character enemy) {
		System.out.println("YOU");
		System.out.println(String.format("%-25.15s %10s", "HP", hp + "/" + maxHP));
		System.out.println(String.format("%-25.15s %10s", "MP", mp + "/" + maxMP));
		System.out.println("ENEMY");
		System.out.println(String.format("%-25.15s %10s", "HP", enemy.getHp() + "/" + enemy.getMaxHP()));
		System.out.println(String.format("%-25.15s %10s", "MP", enemy.getMp() + "/" + enemy.getMaxMP()));

	}

	public void enemyActions(Character enemy) {
		int optionEnemy;
		optionEnemy = rn.nextInt(3);
		switch (optionEnemy) {
			case 0:
				//BASIC ATTACK
				enemyBasicAttack(enemy);
				System.out.println("The enemy did " + enemy.getDamage());
				break;
			case 1:
				//DEFEND
				enemyDefend(enemy);
				break;
			case 2:
				//SPECIAL ABILITIES
				enemySpecialAbilities(enemy);
				System.out.println("The enemy did " + enemy.getSpecialDamage());
				break;
		}

	}

	
	
	public void fight(Character enemy) {
		int option;
		do {
			interfaceFight(enemy);
			System.out.println("How are you gonna fight?");
			option = fightMenu();
			switch (option) {
				case 1:
					//BASIC ATTACK
					basicAttack(enemy);
					//QUE DAÑO LE HACES...
					break;
				case 2:
					//DEFEND
					defend(enemy);
					break;
				case 3:
					//SPECIAL ABILITIES
					specialAbilities(enemy);
					//QUE DAÑO LE HACES...
					break;
				case 4:
					//OBJECTS
					objects();
					break;
				default:
					System.err.println("\nInvalid option");
			}
			enemyActions(enemy);
			// TE HACE DAÑO
		} while (enemy.getHp() > 0);
	}

	public void menu() {
		int op;
		do {
			System.out.println("\nMENU\n");
			System.out.println("What do you want to do?");
			System.out.println("\n\t0- Exit the game \n\t1- Move the character \n\t2- Fight \n\t3- Loot \n\t4- Show inventory \n\t5- Check stats");
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
					move();
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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

}
