package eldenark;

import java.util.Random;

/**
 *
 * @author Gato
 *
 */
public class Merchant {

    // Begin variables
    Random rn = new Random();

    private String name;

    private int y;

    private int x;

    private int floor;

    private Character mainCharacter;

    private Object sellingObject1;

    private Object sellingObject2;

    private Equip sellingEquip;

    private int priceSmallObject = 20;

    private int priceBigObject = 50;

    private int priceEquip;

    private int quantitySmallObject = 5;

    private int quantityBigObject = 2;

    private int quantityEquip = 1;

    private int typeObject1;

    private int typeObject2;

    private String merchantImage;

    private String equipImage;

    private String smallObjImage;

    private String largeObjImage;

    public String getName() {
        return name;
    }

    public Object getSellingObject1() {
        return sellingObject1;
    }

    public Object getSellingObject2() {
        return sellingObject2;
    }

    public Equip getSellingEquip() {
        return sellingEquip;
    }

    public int getPriceSmallObject() {
        return priceSmallObject;
    }

    public int getPriceBigObject() {
        return priceBigObject;
    }

    public int getPriceEquip() {
        return priceEquip;
    }

    public String getMerchantImage() {
        return merchantImage;
    }

    public int getTypeObject1() {
        return typeObject1;
    }

    public int getTypeObject2() {
        return typeObject2;
    }

    public void setMerchantImage(String merchantImage) {
        this.merchantImage = merchantImage;
    }

    public String getSmallObjImage() {
        return smallObjImage;
    }

    public String getLargeObjImage() {
        return largeObjImage;
    }

    public String getEquipImage() {
        return equipImage;
    }

    public void setSmallObjImage(String smallObjImage) {
        this.smallObjImage = smallObjImage;
    }

    public void setLargeObjImage(String largeObjImage) {
        this.largeObjImage = largeObjImage;
    }

    public void setEquipImage(String equipImage) {
        this.equipImage = equipImage;
    }

    public void setQuantitySmallObject(int quantitySmallObject) {
        this.quantitySmallObject = quantitySmallObject;
    }

    public void setQuantityBigObject(int quantityBigObject) {
        this.quantityBigObject = quantityBigObject;
    }

    public void setQuantityEquip(int quantityEquip) {
        this.quantityEquip = quantityEquip;
    }

	public void setName(String name) {
		this.name = name;
	}

    // Merchant generator
    public Merchant(int x, int y, int floor, Character mainCharacter) {

        this.name = "Rogelio"; // Name

        this.x = x; // X position

        this.y = y; // Y position

        this.floor = floor; // Get the current floor

        this.mainCharacter = mainCharacter; // Get the current Character

        // The Marchant always generates this objects
        this.sellingObject1 = generateSmallObject(); // One Small object

        this.sellingObject2 = generateBigObject(); // One big object

        this.sellingEquip = equipGenerator(); // One Piece of equipment

        merchantImage();
        getPotionSmallImg();
        getPotionLargeImg();
        getEquipImg();
		merchantNameFloor(floor);

    }

    public Merchant(int x, int y, int floor, Character mainCharacter, int obj1, int obj1Q, int obj2, int obj2Q, int equip, int equipQ) {

        this.x = x; // X position

        this.y = y; // Y position

        this.floor = floor; // Get the current floor

        this.mainCharacter = mainCharacter; // Get the current Character

        this.sellingEquip = equipGeneratorLoad(equip);

        this.quantityEquip = equipQ;

        this.sellingObject1 = generateSmallObjectLoad(obj1);

        this.quantitySmallObject = obj1Q;

        this.sellingObject2 = generateBigObjectLoad(obj2);

        this.quantityBigObject = obj2Q;

    }

    // Function to generate one equipment
    private Equip equipGenerator() {

        int random = rn.nextInt(4);

        Equip selection = new Equip();

        switch (random) {

            case 0:

                selection = mainCharacter.newWeapons[floor];

                priceEquip = 100 * floor;

                break;

            case 1:

                selection = mainCharacter.newHelmets[floor];

                priceEquip = 60 * floor;

                break;

            case 2:

                selection = mainCharacter.newChestPlates[floor];

                priceEquip = 80 * floor;

                break;

            case 3:

                selection = mainCharacter.newLegArmors[floor];

                priceEquip = 70 * floor;

                break;
        }

        return selection;

    }

    // Function to generate a small object
    private Object generateSmallObject() {

        Potion potion;

        switch (rn.nextInt(2)) {

            case 0:

                potion = new Potion("Small Healing Potion", 30, "healing", "restores 30% health of your max HP", 2);

                typeObject1 = 0;

                break;

            case 1:

                potion = new Potion("Small Mana Potion", 30, "mana", "restores 30% health of your max MP", 2);

                typeObject1 = 2;

                break;

            default:

                potion = new Potion("Small Healing Potion", 30, "healing", "restores 30% health of your max HP", 2);

                typeObject1 = 0;

        }

        return potion;

    }

    // Function to generate a big object
    private Object generateBigObject() {

        Potion potion;

        switch (rn.nextInt(2)) {

            case 0:

                potion = new Potion("Large Healing Potion", 50, "healing", "restores 50% health of your max HP", 2);

                typeObject2 = 1;

                break;

            case 1:

                potion = new Potion("Large Mana Potion", 50, "mana", "restores 50% health of your max MP", 2);

                typeObject2 = 3;

                break;

            default:

                potion = new Potion("Large Healing Potion", 50, "healing", "restores 50% health of your max HP", 2);

                typeObject2 = 1;

        }

        return potion;

    }

    // Setting the different names of the Merchant
    public void merchantNameFloor(int floor) {

        String nameMerchant = null;

        switch (floor) {

            case 1:
				
                this.setName("Rogelio");
				
                break;

            case 2:
				this.setName("Francisco");
				
                break;

            case 3:
				this.setName("Heisenberg");
				
                break;

            case 4:

				this.setName("Almendras");
				
                break;

        }

    }

    public void trade(int option) {

        boolean exit = false, confirmation;

        merchantNameFloor(floor);

        do {

            do {

                System.out.println("\nSHOP\n");

                System.out.println("Hello I'm " + name + ", what do you want to buy?");

                System.out.println(String.format("%-30.25s %3.3s %s %8.8s", "\n\t1- " + sellingObject1.getName(), ("(" + quantitySmallObject + ")"), "|", (priceSmallObject + " Gold")));

                System.out.println(String.format("%-30.25s %3.3s %s %8.8s", "\n\t2- " + sellingObject2.getName(), ("(" + quantityBigObject + ")"), "|", (priceBigObject + " Gold")));

                System.out.println(String.format("%-30.25s %3.3s %s %8.8s", "\n\t3- " + sellingEquip.getName(), ("(" + quantityEquip + ")"), "|", (priceEquip + " Gold")));

                System.out.println(String.format("%-30.25s ", "\n\t0- " + "Exit the shop"));

                System.out.println("\nCurrent money " + mainCharacter.getGold() + " Gold");

                option = EldenArk.validation();

                if (option < 0 || option > 3) {

                    System.err.println("Invalid option.");

                }

            } while (option < 0 || option > 3);

            switch (option) {

                case 1:

                    if (mainCharacter.getGold() < priceSmallObject) {

                        System.out.println("\nYou don't have enough money");

                    } else if (quantitySmallObject > 0) {

                        confirmation = buyingConfirmation();

                        if (confirmation) {

                            System.out.println("You have bought a " + sellingObject1.toString());

                            quantitySmallObject--;

                            mainCharacter.setGold(mainCharacter.getGold() - priceSmallObject);

                            mainCharacter.getInventory()[typeObject1].setNumOfUses(mainCharacter.getInventory()[typeObject1].getNumOfUses() + 1);

                        } else {

                            System.out.println("\nYou haven't bought anything");

                        }
                    } else {

                        System.out.println("I don't have that anymore");

                    }

                    break;

                case 2:

                    if (mainCharacter.getGold() < priceBigObject) {

                        System.out.println("\nYou don't have enough money");

                    } else if (quantityBigObject > 0) {

                        confirmation = buyingConfirmation();

                        if (confirmation) {

                            System.out.println("You have bought a " + sellingObject2);

                            quantityBigObject--;

                            mainCharacter.setGold(mainCharacter.getGold() - priceBigObject);

                            mainCharacter.getInventory()[typeObject2].setNumOfUses(mainCharacter.getInventory()[typeObject2].getNumOfUses() + 1);

                        } else {

                            System.out.println("\nYou haven't bought anything");

                        }
                    } else {

                        System.out.println("I don't have that anymore");

                    }

                    break;

                case 3:

                    if (mainCharacter.getGold() < priceEquip) {

                        System.out.println("\nYou don't have enough money");

                    } else if (quantityEquip > 0) {

                        confirmation = buyingConfirmation();

                        if (confirmation) {

                            System.out.println("You have bought " + sellingEquip.getName());

                            quantityEquip--;

                            mainCharacter.setGold(mainCharacter.getGold() - priceEquip);

                            mainCharacter.changeEquip(mainCharacter.getEquipment(), sellingEquip);

                        } else {

                            System.out.println("\nYou haven't bought anything");

                        }

                    } else {

                        System.out.println("I don't have that anymore");

                    }

                    break;

                case 0:

                    System.out.println("See you ugu!");

                    exit = true;

                    System.out.println("See you <3");

                    exit = true;

                    break;

                default:

                    System.out.println("I can't sell you anything if I don't have it");

            }

        } while (!exit);

    }

    // Setting the Y position of the Merchant
    public void setY(int y) {

        this.y = y;

    }

    // Setting the X position of the Merchant
    public void setX(int x) {

        this.x = x;

    }

    // Confirming the buy action of the user
    private boolean buyingConfirmation() {

        String answer;

        boolean correct = false, confirmation = false;

        do {

            System.out.println("Are you sure you want to buy this object? (Y/N)");

            answer = Teclat.llegirString();

            answer = answer.toUpperCase();

            if (answer.equals("Y") || answer.equals("N")) {

                correct = true;

            }

        } while (!correct);

        if (answer.equals("Y")) {

            confirmation = true;

        }

        return confirmation;

    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getSmallObjectNum() {
        int smallNum = 1;
        if (sellingObject1.getName().equals("Small Healing Potion")) {
            smallNum = 0;
        }
        return smallNum;
    }

    public int getBigObjectNum() {
        int bigNum = 1;
        if (sellingObject2.getName().equals("Large Healing Potion")) {
            bigNum = 0;
        }
        return bigNum;
    }

    public int getEquipmentNum() {
        int equipNum = 0;
        switch (sellingEquip.getType()) {
            case "Weapon":
                equipNum = 0;
                break;
            case "Helmet":
                equipNum = 1;
                break;
            case "Chestplate":
                equipNum = 2;
                break;
            case "Leg Armor":
                equipNum = 3;
                break;
        }
        return equipNum;
    }

    public int getQuantitySmallObject() {
        return quantitySmallObject;
    }

    public int getQuantityBigObject() {
        return quantityBigObject;
    }

    public int getQuantityEquip() {
        return quantityEquip;
    }

    //LOADING MERCHANT
    //EQUIP GENERATOR FOR LOADING THE GAME
    private Equip equipGeneratorLoad(int equip) {

        Equip selection = new Equip();

        switch (equip) {

            case 0:

                selection = mainCharacter.newWeapons[floor];

                priceEquip = 100 * floor;

                break;

            case 1:

                selection = mainCharacter.newHelmets[floor];

                priceEquip = 60 * floor;

                break;

            case 2:

                selection = mainCharacter.newChestPlates[floor];

                priceEquip = 80 * floor;

                break;

            case 3:

                selection = mainCharacter.newLegArmors[floor];

                priceEquip = 70 * floor;

                break;
        }

        return selection;

    }

    private Object generateSmallObjectLoad(int obj) {

        Potion potion;

        switch (obj) {

            case 0:

                potion = new Potion("Small Healing Potion", 30, "healing", "restores 30% health of your max HP", 2);

                typeObject1 = 0;

                break;

            case 1:

                potion = new Potion("Small Mana Potion", 30, "mana", "restores 30% health of your max MP", 2);

                typeObject1 = 2;

                break;

            default:

                potion = new Potion("Small Healing Potion", 30, "healing", "restores 30% health of your max HP", 2);

                typeObject1 = 0;

        }

        return potion;

    }

    private Object generateBigObjectLoad(int obj) {

        Potion potion;

        switch (obj) {

            case 0:

                potion = new Potion("Large Healing Potion", 50, "healing", "restores 50% health of your max HP", 2);

                typeObject2 = 1;

                break;

            case 1:

                potion = new Potion("Large Mana Potion", 50, "mana", "restores 50% health of your max MP", 2);

                typeObject2 = 3;

                break;

            default:

                potion = new Potion("Large Healing Potion", 50, "healing", "restores 50% health of your max HP", 2);

                typeObject2 = 1;

        }

        return potion;

    }

    public void getEquipImg() {
        String path = "/FOTOS ELDEN ARK/EQUIPMENT/";
        String toReturn;
        switch (sellingEquip.getType()) {
            case "Weapon":
                toReturn = path.concat(mainCharacter.getClass().getName().substring(9) + "/" + mainCharacter.getNewWeapons()[floor].getName() + ".png");
                setEquipImage(toReturn);
                break;
            case "Helmet":
                toReturn = path.concat(mainCharacter.getClass().getName().substring(9) + "/" + mainCharacter.getNewHelmets()[floor].getName() + ".png");
                setEquipImage(toReturn);
                break;
            case "Chestplate":
                toReturn = path.concat(mainCharacter.getClass().getName().substring(9) + "/" + mainCharacter.getNewChestPlates()[floor].getName() + ".png");
                setEquipImage(toReturn);
                break;
            case "Leg Armor":
                toReturn = path.concat(mainCharacter.getClass().getName().substring(9) + "/" + mainCharacter.getNewLegArmors()[floor].getName() + ".png");
                setEquipImage(toReturn);
                break;
        }

    }

    public void getPotionSmallImg() {
        String path = "/FOTOS ELDEN ARK/POTIONS/";
        String toReturn;
        switch (typeObject1) {
            case 0:
                toReturn = path.concat("SMALL_POTION_HEAL.png");
                setSmallObjImage(toReturn);
                break;
            case 2:
                toReturn = path.concat("SMALL_POTION_MANA.png");
                setSmallObjImage(toReturn);
                break;
        }
    }

    public void getPotionLargeImg() {
        String path = "/FOTOS ELDEN ARK/POTIONS/";
        String toReturn;
        switch (typeObject2) {
            case 1:
                toReturn = path.concat("LARGE_POTION_HEAL.png");
                setLargeObjImage(toReturn);
                break;
            case 3:
                toReturn = path.concat("LARGE_POTION_MANA.png");
                setLargeObjImage(toReturn);
                break;
        }
    }

    public void merchantImage() {
        switch (floor) {
            case 1:
                setMerchantImage("/FOTOS ELDEN ARK/MERCHANT/ROGELIO.png");
                break;
            case 2:
                setMerchantImage("/FOTOS ELDEN ARK/MERCHANT/FRANCISCO.png");
                break;
            case 3:
                setMerchantImage("/FOTOS ELDEN ARK/MERCHANT/HEISENBERG.png");
                break;
            case 4:
                setMerchantImage("/FOTOS ELDEN ARK/MERCHANT/ALMENDRAS.png");
                break;
        }
    }

}
