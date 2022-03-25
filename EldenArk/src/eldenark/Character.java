package eldenark;

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
			System.out.println("Which direction do you want to move?\n\t1 - Up\n\tDown\n\tRight\n\tLeft");
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
		System.out.println("1-Basic Attack" + "\n2-Defend" + "\n3-Special Abilities" + "\n4-Objects");
		return 1;

	}

	public void fight() {

	}

	public void menu() {
		int op;
		System.out.println("\nMENU\n");
		System.out.println("What do you want to do?");
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
				fight();
				break;
			case 3:
				//LOOT
				break;
			case 4:
				//INVENTORY
				break;
			case 5:
				//CHECK STATS
				showStats();
				break;
			default:
				System.err.println("Error,invalid option." + " \nTry again");
		}
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
