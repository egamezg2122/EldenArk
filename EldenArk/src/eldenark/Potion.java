/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eldenark;

/**
 *
 * @author cep
 */
public class Potion extends ObjectP {

	private int percentage;

	private String type;

    public Potion(String name, int percentage, String type, String description, int numOfUses) {

        super(name, description, numOfUses);

        this.percentage = percentage;

        this.type = type;

    }




    public int getPercentage() {

        return percentage;

    }

    public String getType() {

        return type;

    }

    public void setPercentage(int percentage) {

        this.percentage = percentage;

    }

    public void setType(String type) {

        this.type = type;

    }


    @Override
    public String toString() {

        return this.getName() 

                + " which " + this.getDescription();

    }



    @Override
    public void use(Character c) {

            switch(this.type){

                    case "healing":

                            c.setHp(c.getHp() + (c.getMaxHP() * this.percentage  / 100));

                            c.checkMaxValues(c.getHp(),c.getMaxHP());

                            break;

                    case "mana":

                            c.setMp(c.getMp()+ (c.getMaxMP() * this.percentage  / 100));

                            c.checkMaxValues(c.getMp(),c.getMaxMP());
            }

            this.setNumOfUses(this.getNumOfUses() - 1);
    }
}
