/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eldenark;

import java.util.Random;

/**
 *
 * @author Gato
 */
public class Merchant {

	Random rn = new Random();

	private String name;
	private int y;
	private int x;
	private int floor;
	private Character mainCharacter;
	private Object sellingObject1;
	private Object sellingObject2;
	private Equip sellingEquip;
	//private Weapon sellingWeapon1;
	private int priceSmallObject = 20;
	private int priceBigObject = 50;
	private int priceEquip;
	//private int priceWeapon = 500;
	private int quantitySmallObject = 5;
	private int quantityBigObject = 2;
	private int quantityEquip = 1;
	//private int quantityWeapon;
	private int typeObject1;
	private int typeObject2;

	public Merchant(int x, int y, int floor, Character mainCharacter) {

		this.name = "Rogelio";
		this.x = x;
		this.y = y;
		this.floor = floor;
		this.mainCharacter = mainCharacter;
		this.sellingObject1 = generateSmallObject();
		this.sellingObject2 = generateBigObject();
		this.sellingEquip = equipGenerator();

	}

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

	private Object generateSmallObject() {

		Potion a;

		switch (rn.nextInt(2)) {

			case 0:
				a = new Potion("Small Healing Potion", 30, "healing", "restores 30% health of your max HP", 2);
				typeObject1 = 0;
				break;

			case 1:

				a = new Potion("Small Mana Potion", 30, "mana", "restores 30% health of your max MP", 2);
				typeObject1 = 2;

				break;

			default:
				a = new Potion("Small Healing Potion", 30, "healing", "restores 30% health of your max HP", 2);
				typeObject1 = 0;

		}

		return a;

	}

	private Object generateBigObject() {

		Potion a;

		switch (rn.nextInt(2)) {

			case 0:
				a = new Potion("Large Healing Potion", 50, "healing", "restores 50% health of your max HP", 2);
				typeObject2 = 1;

				break;

			case 1:

				a = new Potion("Large Mana Potion", 50, "mana", "restores 50% health of your max MP", 2);
				typeObject2 = 3;

				break;

			default:
				a = new Potion("Large Healing Potion", 50, "healing", "restores 50% health of your max HP", 2);
				typeObject2 = 1;

		}

		return a;

	}

	public void trade() {

		boolean exit = false;

		do {

			System.out.println("\nSHOP\n");
			System.out.println("What do you want to buy?");
			System.out.println("\n\t1-" + sellingObject1.getName() + "\n\t2-" + sellingObject2.getName() + "\n\t3-" + sellingEquip.getName() + "\n\t0- Exit the shop");

			switch (Teclat.llegirInt()) {

				case 1:

					if (mainCharacter.getGold() < priceBigObject) {
						System.out.println("You don't have enough money");
					} else if (quantitySmallObject > 0) {

						System.out.println("You have bought a " + sellingObject1.toString());

						quantitySmallObject--;

						mainCharacter.setGold(mainCharacter.getGold() - priceSmallObject);

						mainCharacter.getInventory()[typeObject1].setNumOfUses(mainCharacter.getInventory()[typeObject1].getNumOfUses() + 1);

					}

					break;

				case 2:

					if (mainCharacter.getGold() < priceBigObject) {
						System.out.println("You don't have enough money");
					} else if (quantityBigObject > 0) {

						System.out.println("You have bought a " + sellingObject2);

						quantityBigObject--;

						mainCharacter.setGold(mainCharacter.getGold() - priceBigObject);

						mainCharacter.getInventory()[typeObject2].setNumOfUses(mainCharacter.getInventory()[typeObject2].getNumOfUses() + 1);

					}

					break;

				case 3:

					if (quantityEquip > 0 && mainCharacter.getGold() >= priceEquip) {

						System.out.println("You have bought " + sellingEquip.getName());

						quantityEquip--;

						mainCharacter.setGold(mainCharacter.getGold() - priceEquip);

						mainCharacter.changeEquip(mainCharacter.getEquipment(), sellingEquip);

					}

					break;

				case 0:

					exit = true;

					System.out.println("See you <3");

					break;

				default:
					System.out.println("I can't sell you anything if I don't have it");

			}

		} while (!exit);

	}

	public void setY(int y) {
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

}
