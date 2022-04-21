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

    private int hp; // Health Points

    private int maxHP;

    private int mp; // Mana Points

    private int maxMP;

    private int specialDamage;

    private int gold = 5;

    private String role;

    private int x = 10; // Position in the map

    private int y = 2; // Position in the map

    private Object[] inventory = new Object[4]; // Testing inventory

    private Equip[] equipment = new Equip[4];

    //For new Equipment
    protected Equip[] newWeapons = new Equip[5];

    protected Equip[] newHelmets = new Equip[5];

    protected Equip[] newChestPlates = new Equip[5];

    protected Equip[] newLegArmors = new Equip[5];

    // Constructors
    // Constructor for MAIN CHARACTER
    public Character(int damage, int defence, int hp, int maxHP, int mp, int maxMP, int specialDamage, String role, Object[] inventory) {

        this.level = 1; // Always start at level 1

        this.xp = 0; // Experience always start at 0

        this.maxXP = 1000;

        this.maxXP = 100;

        this.damage = damage;

        this.defence = defence;

        this.hp = hp;

        this.maxHP = maxHP;

        this.mp = mp;

        this.maxMP = maxMP;

        this.specialDamage = specialDamage;

        this.role = role;

        this.inventory = inventory;

        weapons();
        helmet();
        chestplate();
        legArmor();

        equipment[0] = newWeapons[0];
        equipment[1] = newHelmets[0];
        equipment[2] = newChestPlates[0];
        equipment[3] = newLegArmors[0];

        addEquip(equipment);

    }

    // Constructor for ENEMIES
    public Character(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage) {
        this.damage = damage;
        this.defence = defense;
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
        defence = defence * 2;
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
        System.out.println("");
        System.out.println(String.format("%-25.15s %10d", "LEVEL", level));
        System.out.println(String.format("%-25.15s %10d", "Damage", damage));
        System.out.println(String.format("%-25.15s %10d", "Defense", defence));
        System.out.println(String.format("%-25.15s %10d", "Special Damage", specialDamage));
        System.out.println(String.format("%-25.15s %10s", "HP", hp + "/" + maxHP));
        System.out.println(String.format("%-25.15s %10s", "MP", mp + "/" + maxMP));
        System.out.println(String.format("%-25.15s %10s", "EXP", xp + "/" + maxXP));
        System.out.println("");
        System.out.println(String.format("%-25.15s %10d", "GOLD", gold));

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
        defenceChar *= 1.5;
        return defenceChar;
    }

    public int enemyDefend(Character enemy, int defenceEnemy) {
        System.out.println("\nThe enemy auments his defense");
        defenceEnemy *= 1.5;
        return defenceEnemy;
    }

    /*public void specialAbilities(Character enemy, int defenceEnemy) {
    int damageDone = this.specialDamage - defenceEnemy;
    if (damageDone > 0) {
    enemy.setHp(enemy.getHp() - damageDone);
    System.out.println("You did " + (damageDone) + " damage.");
    } else {
    System.out.println("You did 0 damage. The enemy's defense is to powerfull");
    }
    }*/

    public void enemySpecialAbilities(Character enemy, int defenceChar) {
        int damageDone = enemy.getSpecialDamage() - defenceChar;
        if (damageDone > 0) {
            this.hp = hp - damageDone;
            System.out.println("The enemy uses his special ability.");
            System.out.println("The enemy did " + (damageDone) + " damage.");
        } else {
            System.out.println("The enemy did 0 damage to you. Wow, how did you not get hurt!?");
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

    public void interfaceFight(int map[][], Character mainCharacter, Character enemy, int floor, String nickname) {
        String enemyName = enemyName(map, enemy, floor);
        System.out.println("\n\n" + nickname + "(YOU)");
        System.out.println(String.format("%-25.15s %10s", "HP", hp + "/" + maxHP));
        System.out.println(String.format("%-25.15s %10s", "MP", mp + "/" + maxMP));
        System.out.println("\n\n" + enemyName);
        System.out.println(String.format("%-25.15s %10s", "HP", enemy.getHp() + "/" + enemy.getMaxHP()));
        System.out.println(String.format("%-25.15s %10s", "MP", enemy.getMp() + "/" + enemy.getMaxMP()));

    }

    //ENEMIES NAMES
    public String enemyName(int map[][], Character enemy, int floor) {
        String enemyName = null;
        int enemyType = getEnemyType(map);
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
            case 5:
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
            case 5:
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
            case 5:
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
            case 5:
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
                break;
            case 2:
                name = "Monk of the Lord Ark (Priest)";
                break;
            case 3:
                name = "Amateur Wizard (Mage)";
                break;
            default:
                name = "Soldier of Elderfell (Warrior)";
        }
        return name;
    }

    public String normalEnemyNameF2(int enemyClass) {
        String name;
        switch (enemyClass) {
            case 1:
                name = "Demon Soldier of Kushan (Warrior)";
                break;
            case 2:
                name = "Friar of Ubik (Priest)";
                break;
            case 3:
                name = "Low-Class Elf (Mage)";
                break;
            default:
                name = "Demon Soldier of Kushan(Warrior)";
        }
        return name;
    }

    public String normalEnemyNameF3(int enemyClass) {
        String name;
        switch (enemyClass) {
            case 1:
                name = "Mesh's Cavalry (Warrior)";
                break;
            case 2:
                name = "White Abbot (Priest)";
                break;
            case 3:
                name = "Old Rot Wizard (Mage)";
                break;
            default:
                name = "Mesh's Cavalry (Warrior)";
        }
        return name;
    }

    public String normalEnemyNameF4(int enemyClass) {
        String name;
        switch (enemyClass) {
            case 1:
                name = "Giant with a Maze(Warrior)";
                break;
            case 2:
                name = "Follower of Frederic (Priest)";
                break;
            case 3:
                name = "Black Magician (Mage)";
                break;
            default:
                name = "Giant with a Maze (Warrior)";
        }
        return name;
    }

    public String miniBossNameF1(int enemyClass) {
        String name;
        switch (enemyClass) {
            case 1:
                name = "Demi-Human Elder (Warrior)";
                break;
            case 2:
                name = "Grand Bishop (Priest)";
                break;
            case 3:
                name = "Ancestor Wizard (Mage)";
                break;
            default:
                name = "Demi-Human Elder (Warrior)";
        }
        return name;
    }

    public String miniBossNameF2(int enemyClass) {
        String name;
        switch (enemyClass) {
            case 1:
                name = "Moon Knight (Warrior)";
                break;
            case 2:
                name = "God Hand (Priest)";
                break;
            case 3:
                name = "Great Witch (Mage)";
                break;
            default:
                name = "Moon Knight (Warrior)";
        }
        return name;
    }

    public String miniBossNameF3(int enemyClass) {
        String name;
        switch (enemyClass) {
            case 1:
                name = "Bloody Beast (Warrior)";
                break;
            case 2:
                name = "Cardenal of Lord Void (Priest)";
                break;
            case 3:
                name = "Servant of Caster (Mage)";
                break;
            default:
                name = "Bloody Beast (Warrior)";
        }
        return name;
    }

    public String miniBossNameF4(int enemyClass) {
        String name;
        switch (enemyClass) {
            case 1:
                name = "Beast Titan (Warrior)";
                break;
            case 2:
                name = "Great Archbishop (Priest)";
                break;
            case 3:
                name = "Aklesh's Greatest Follower (Mage)";
                break;
            default:
                name = "Beast Titan (Warrior)";
        }
        return name;
    }

    public String finalBossNameF1(int enemyClass) {
        String name;
        switch (enemyClass) {
            case 1:
                name = "Wind Giant, Wind God (Warrior)";
                break;
            case 2:
                name = "Fanni the Greatest, Four Hands Queen (Priest)";
                break;
            case 3:
                name = "Midland Ancestor Spirit, Midland Hope (Mage)";
                break;
            default:
                name = "Wind Giant, Wind God (Warrior)";
        }
        return name;
    }

    public String finalBossNameF2(int enemyClass) {
        String name;
        switch (enemyClass) {
            case 1:
                name = "Skull Knight, The Vengeance (Warrior)";
                break;
            case 2:
                name = "Femto, The Black Falcon (Priest)";
                break;
            case 3:
                name = "Beherit, God's Right Hand (Mage)";
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
                break;
            case 2:
                name = "Lord Void, The Nothing (Priest)";
                break;
            case 3:
                name = "Caster, The Queen of Everything (Mage)";
                break;
            default:
                name = "Mesh, The King of Heroes (Warrior)";
        }
        return name;
    }

    public String finalBossNameF4(int enemyClass) {
        String name;
        switch (enemyClass) {
            case 1:
                name = "Troll, Troll (Warrior)";
                break;
            case 2:
                name = "Frederic, Pope of All Living Beings (Priest)";
                break;
            case 3:
                name = "Aklesh, the Demon Summoner (insert epic battle music) (Mage)";
                break;
            default:
                name = "Troll, Troll (Warrior)";
        }
        return name;
    }

    public int getEnemyType(int map[][]) {
        return map[this.getY()][this.getX()];
    }

    public int getEnemyClass(Character enemy) {
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
    public void fight(int map[][], Character enemy, int floor, String nickname) {
        int option, enemyOption;
        int mainDef = this.getDefence();
        int enemyDef = enemy.getDefence();
        boolean objectsUses;
        do {
            objectsUses = checkObjects();
            interfaceFight(map, this, enemy, floor, nickname);
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
                    abilities(enemy);
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
        interfaceFight(map, this, enemy, floor, nickname);
        if (enemy.getHp() <= 0) {
            System.out.println("\nCongrats, you defeated the enemy.");
        } else {
            System.out.println("\nYOU DIED.");
        }
    }

    /*	public void menu() {
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

	}*/
    public void showInventory() {
        for (int i = 0; i < inventory.length; i++) {
            System.out.println(inventory[i].toString());
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

    public void setRole(String role) {
        this.role = role;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void abilities(Character enemy) {

    }

    public void weapons() {

    }

    public void helmet() {

    }

    public void chestplate() {

    }

    public void legArmor() {

    }
}
