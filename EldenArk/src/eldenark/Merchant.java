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
    private Object sellingObject1;
    private Object sellingObject2;
    //private Weapon sellingWeapon1;
    private int priceSmallObject = 100;
    private int priceBigObject = 200;
    //private int priceWeapon = 500;
    private int quantitySmallObject = 5;
    private int quantityBigObject = 2;
    //private int quantityWeapon;
    private int typeObject1;
    private int typeObject2;

    public Merchant(int x, int y) {

        this.name = "Matias";
        this.x = x;
        this.y = y;
        this.sellingObject1 = generateSmallObject();
        this.sellingObject2 = generateBigObject();

    }

    private Object generateSmallObject() {

        Potion a;

        switch (rn.nextInt(2)) {

            case 0:
                a = new Potion("Small Healing Potion", 30, "tipo", "descripcion", 2);
                typeObject1 = 0;
                break;

            case 1:

                a = new Potion("Small Mana Potion", 30, "tipo", "descripcion", 2);
                typeObject1 = 2;

                break;

            default:
                a = new Potion("Small Healing Potion", 30, "tipo", "descripcion", 2);
                typeObject1 = 0;

        }

        return a;

    }

    private Object generateBigObject() {

        Potion a;

        switch (rn.nextInt(2)) {

            case 0:
                a = new Potion("Large Healing Potion", 50, "tipo", "descripcion", 2);
                typeObject2 = 1;

                break;

            case 1:

                a = new Potion("Large Mana Potion", 50, "tipo", "descripcion", 2);
                typeObject2 = 3;

                break;

            default:
                a = new Potion("Large Healing Potion", 50, "tipo", "descripcion", 2);
                typeObject2 = 1;

        }

        return a;

    }

    private void trade(Character mainCharacter) {
        
        boolean exit = false;
        
        do {

            System.out.println("\nSHOP\n");
            System.out.println("What do you want to buy?");
            System.out.println("\n\t1- Buy small object \n\t2- Buy large object \n\t3- Buy a weapon \n\t0- Exit the shop");

            switch (Teclat.llegirInt()) {
                
                case 1:

                    if (quantitySmallObject > 0 || gold >= priceSmallObject) {

                        System.out.println("You have bought a " + sellingObject1);

                        quantitySmallObject--;

                        mainCharacter.setGold() = mainCharacter.getGold() - priceSmallObject;

                        mainCharacter.getInventory()[typeObject1].setNumOfUses(mainCharacter.getInventory()[typeObject1].getNumOfUses() + 1);

                    }

                    break;

                case 2:

                    if (quantityBigObject > 0 || gold >= priceBigObject) {

                        System.out.println("You have bought a " + sellingObject2);

                        quantityBigObject--;

                        mainCharacter.setGold() = mainCharacter.getGold() - priceBigObject;

                        mainCharacter.getInventory()[typeObject2].setNumOfUses(mainCharacter.getInventory()[typeObject2].getNumOfUses() + 1);

                    }

                    break;
                    
                case 3:
                    
                    
                    
                    break;
                    
                case 4:
                    
                    exit = true;
                    
                    System.out.println("See you <3");
                    
                    break;
                    
                default:
                    System.out.println("I can't sell you anything if I don't have it");

            }

        } while (exit = false);

    }

}
