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
		return "Potion{" + "percentage=" + percentage + ", numOfUses=" + numOfUses + ", type=" + type + '}';
	}

	@Override
	public void use() {
		
		this.setNumOfUses(this.getNumOfUses() - 1);
	}
	
	
	
	
	
	
	
	

}
