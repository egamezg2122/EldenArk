package eldenark;

/**
 *
 * @author egame
 *
 */
public class Warrior extends Character {

	//Constructors
	// MAIN
	public Warrior(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, String role, Object[] inventory) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage, role, inventory);
	}

	// ENEMIES
	//Ns si poner la clase
	public Warrior(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage);
	}

	// Constructor
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
		Equip basicChestplate = new Equip("Basic ChestPlate", "Chestplate", 5);
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
        public void abilities (Character enemy) {
        
            String abilitiesWarrior[] = {"Martillo de Thor", "Carga de ariete", "Grito de combate", "Doble filo", "Salto heroico"};
            
            int option;

            boolean control = false;

            do {

                System.out.println("What ability do you want to use?");

                if (this.getRole().equals("Warrior")) {

                    for (int i = 0; i < ((this.getLevel() / 5) + 1); i++) {

                    System.out.println(abilitiesWarrior[i]);

                    }
                } 
                
                option = Teclat.llegirInt();

                if (option < ((this.getLevel() / 5) + 1) && option >= 1) {

                    control = true;

                } else {

                    System.out.println("The ability is not avilable, caldo de pollo");

                }

            } while (!control);

            switch (option) {

                case 1:
                    
                    enemy.setHp(enemy.getHp() - 40);

                    this.setMp(this.getMp() - 5);

                    break;

                case 2:
                    
                    enemy.setHp(enemy.getHp() - 50);

                    this.setMp(this.getMp() - 10);

                    break;

                case 3:
                    
                    enemy.setHp(enemy.getHp() - 60);

                    this.setMp(this.getMp() - 15);

                    break;

                case 4:
                    
                    enemy.setHp(enemy.getHp() - 70);

                    this.setMp(this.getMp() - 20);

                    break;

            }

            
        }
	

}
