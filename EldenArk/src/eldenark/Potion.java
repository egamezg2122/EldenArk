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
public class Potion extends Object{
	
	private int percentage;
	
	private int numOfUses;
	
	private String type;

	public Potion(int percentage, int numOfUses, String type) {
		this.percentage = percentage;
		this.numOfUses = numOfUses;
		this.type = type;
	}

	public int getPercentage() {
		return percentage;
	}

	public int getNumOfUses() {
		return numOfUses;
	}

	public String getType() {
		return type;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public void setNumOfUses(int numOfUses) {
		this.numOfUses = numOfUses;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Potion{" + "percentage=" + percentage + ", numOfUses=" + numOfUses + ", type=" + type + '}';
	}
	
	
	
	
	
	
	
	

}
