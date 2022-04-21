package eldenark;

/**
 *
 * @author egame
 *
 */
public class Priest extends Character {

	// MAIN
	public Priest(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage, String role, Object[] inventory) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage, role, inventory);
	}

	// ENEMIES
	//Ns si poner la clase
	public Priest(int damage, int defense, int hp, int maxHP, int mp, int maxMP, int specialDamage) {
		super(damage, defense, hp, maxHP, mp, maxMP, specialDamage);
	}

	// Constructor
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
		newWeapons[0] = basicWeapon;
		newWeapons[1] = firstWeapon;
		newWeapons[2] = secondWeapon;
		newWeapons[3] = thirdWeapon;
	}

	@Override
	public void helmet() {
		Equip basicHelmet = new Equip("Mask of Confidence", "Helmet", 2);
		Equip firstHelmet = new Equip("Monk Hood", "Helmet", 4);
		Equip secondHelmet = new Equip("Albinauric Mask", "Helmet", 8);
		Equip thirdHelmet = new Equip("Astrologer Hood", "Helmet", 15);
		newHelmets[0] = basicHelmet;
		newHelmets[1] = firstHelmet;
		newHelmets[2] = secondHelmet;
		newHelmets[3] = thirdHelmet;

	}

	@Override
	public void chestplate() {
		Equip basicChestplate = new Equip("Basic Tunic", "Chestplate", 5);
		Equip firstChestplate = new Equip("Alberich's Robe", "Chestplate", 10);
		Equip secondChestplate = new Equip("Azur's Glintstone Robe", "Chestplate", 20);
		Equip thirdChestplate = new Equip("God Monk Robe", "Chestplate", 50);
		newChestPlates[0] = basicChestplate;
		newChestPlates[1] = firstChestplate;
		newChestPlates[2] = secondChestplate;
		newChestPlates[3] = thirdChestplate;
	}

	@Override
	public void legArmor() {
		Equip basicLegArmor = new Equip("Confessor Boots", "Leg Armor", 2);
		Equip firstLegArmor = new Equip("Kaiden Iron Legs", "Leg Armor", 5);
		Equip secondLegArmor = new Equip("Lionel's Greaves", "Leg Armor", 10);
		Equip thirdLegArmor = new Equip("God of Sun Greaves", "Leg Armor", 20);
		newLegArmors[0] = basicLegArmor;
		newLegArmors[1] = firstLegArmor;
		newLegArmors[2] = secondLegArmor;
		newLegArmors[3] = thirdLegArmor;
	}
       
        @Override
        
        public void abilities (Character enemy){
            
            String abilitiesPriest[] = {"Infusión de poder", "Punición", "Salto de fe", "Levitación", "Rezo desesperado"};
            
            int option;

            boolean control = false;

            do {

                System.out.println("Que habilidad quieres usar?");

                if (this.getRole().equals("Priest")) {

                    for (int i = 0; i < ((this.getLevel() / 5) + 1); i++) {

                    System.out.println(abilitiesPriest[i]);

                    }
                } 
                
                option = Teclat.llegirInt();

                if (option <= ((this.getLevel() / 5) + 1) && option >= 1) {

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
