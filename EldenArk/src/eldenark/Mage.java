package eldenark;

/**
 *
 * @author egame
 *
 */
public class Mage extends Character {

	// MAIN 
	public Mage(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, String role, Object[] inventory) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage, role, inventory);
	}

	// ENEMY
	//Ns si poner la clase
	public Mage(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage);
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
		Equip basicChestplate = new Equip("Blue Cloth Vest", "Chestplate", 5);
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
		Equip firstLegArmor = new Equip("Green Bull-Goat Kilt", "Leg Armor", 5);
		Equip secondLegArmor = new Equip("Golden Leggings", "Leg Armor", 10);
		Equip thirdLegArmor = new Equip("Eccentric's Breeches", "Leg Armor", 20);
		Equip forthLegArmor = new Equip("Diamond Boots", "Leg Armor", 30);
		newLegArmors[0] = basicLegArmor;
		newLegArmors[1] = firstLegArmor;
		newLegArmors[2] = secondLegArmor;
		newLegArmors[3] = thirdLegArmor;
		newLegArmors[4] = forthLegArmor;
	}
        
      
        @Override
        public void abilities(Character enemy){
                
            String abilitiesMage[] = {"Bola de fuego", "Traslación", "Nova de Escarcha", "Clima de Trueno", "Lunargenta"};

            int option;

            boolean control = false;

            do {

                System.out.println("What ability do you want to use??");

                if (this.getRole().equals("Mage")) {

                    for (int i = 0; i < ((this.getLevel() / 5) + 1); i++) {

                    System.out.println(abilitiesMage[i]);

                    }
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
                    
                    enemy.setHp(enemy.getHp() - ((this.getSpecialDamage() * 4) - enemy.getDefence()));

                    this.setMp(this.getMp() - 20);

                    break;

                case 2:
                    
                    enemy.setHp(enemy.getHp() - ((this.getSpecialDamage() * 4) - enemy.getDefence()));

                    this.setMp(this.getMp() - 40);

                    break;

                case 3:
                    
                    enemy.setHp(enemy.getHp() - ((this.getSpecialDamage() * 4) - enemy.getDefence()));

                    this.setMp(this.getMp() - 60);

                    break;

                case 4:
                    
                    enemy.setHp(enemy.getHp() - ((this.getSpecialDamage() * 4) - enemy.getDefence()));

                    this.setMp(this.getMp() - 80);

                    break;

            }
            
        }
       
}
