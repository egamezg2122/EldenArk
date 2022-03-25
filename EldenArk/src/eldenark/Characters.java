package eldenark;

public class Characters {

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

	// Constructors
	public Characters(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage) {

		this.level = 1; // Always start at level 1

		this.xp = 0; // Experience always start at 0

		this.damage = damage;

		this.defense = defense;

		this.hp = hp;

		this.maxHP = maxHP;

		this.mp = mp;

		this.maxMP = maxMP;

		this.specialDamage = specialDamage;

	}

	public Characters() {
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
		x++;
	}
	
	public Characters createEnemy(){
		Characters enemy = new Characters();
		
		return enemy;
	}
	
	//ES NECESITADO EL CAMBIO A ESTA SECCION DEL CODIGO
	public int fightMenu() {
		System.out.println("\n1-Basic Attack" + "\n2-Defend" + "\n3-Special Abilities" + "\n4-Objects");
		return Teclat.llegirInt();
	}

	public void basicAttack(Characters enemy){
		enemy.setHp(hp-damage);
	}
	
	public void defend(){
		
	}
	
	public void specialAbilities(Characters enemy){
		enemy.setHp(hp-specialDamage);
	}
	
	public void objects(){
		
	}
	
	public void fight(Characters enemy) {
		int option;
		do{
			System.out.println("How are you gonna fight?");
			option = fightMenu();
			switch(option){
			case 1:
				//BASIC ATTACK
				basicAttack(enemy);
				break;
			case 2:
				//DEFEND
				defend();
				break;
			case 3:
				//SPECIAL ABILITIES
				specialAbilities(enemy);				
				break;
			case 4:
				//OBJECTS
				objects();
				break;
			default:
				System.err.println("\nInvalid option");
		}
		}while(enemy.getHp()>0);
		
		
		
		
	}

	public void menu() {
		int op;
		System.out.println("\nMENU\n");
		System.out.println("What do you want to do?");
		System.out.println("\n\t0- Exit the game \n\t1- Move the character \n\t2- Fight \n\t3- Loot \n\t4- Show inventory \n\t5- Check Stats");
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
				fight(createEnemy());
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
