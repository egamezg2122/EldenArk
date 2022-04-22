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

	public String merchantNameFloor(int floor) {
		String nameMerchant = null;
		switch (floor) {
			case 1:
				nameMerchant = "Rogelio";
				break;
			case 2:
				nameMerchant = "Francisco";
				break;
			case 3:
				nameMerchant = "Heisenberg";
				break;
			case 4:
				nameMerchant = "Almendras";
				break;

		}
		return nameMerchant;
	}

	public void trade() {
		int option;
		boolean exit = false, confirmation;
		name = merchantNameFloor(floor);
		do {
			do {
				System.out.println("\nSHOP\n");
				System.out.println("Hello I'm " + name + ", what do you want to buy?");
				System.out.println(String.format("%-30.25s %3.3s %s %8.8s", "\n\t1- " + sellingObject1.getName(), ("(" + quantitySmallObject + ")"), "|", (priceSmallObject + " Gold")));
				System.out.println(String.format("%-30.25s %3.3s %s %8.8s", "\n\t2- " + sellingObject2.getName(), ("(" + quantityBigObject + ")"), "|", (priceBigObject + " Gold")));
				System.out.println(String.format("%-30.25s %3.3s %s %8.8s", "\n\t3- " + sellingEquip.getName(), ("(" + quantityEquip + ")"), "|", (priceEquip + " Gold")));
				System.out.println(String.format("%-30.25s ", "\n\t0- " + "Exit the shop"));
				//System.out.println("\n\t1-" + sellingObject1.getName() + " (" + quantitySmallObject + ")" + " | " + priceSmallObject + " Gold" + "\n\t2-" + sellingObject2.getName() + " (" + quantityBigObject + ")" + " | " + priceBigObject + " Gold" + "\n\t3-" + sellingEquip.getName() + " (" + sellingEquip.getType() + ")" + " (" + quantityEquip + ")" + " | " + priceEquip + " Gold" + "\n\t0- Exit the shop");
				System.out.println("\nCurrent money " + mainCharacter.getGold() + " Gold");
				option = EldenArk.validation();
				if (option <= 0 || option > 3) {
					System.err.println("Invalid option.");
				}
			} while (option <= 0 || option > 3);
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

}
