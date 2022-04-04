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
public abstract class Object {

	private String name;
	
	private String description;
	
	private int numOfUses;

	public Object(String name, String description, int numOfUses) {
		this.name = name;
		this.description = description;
		this.numOfUses = numOfUses;
	}

	public String getName() {
		return name;
	}

	
	public String getDescription() {
		return description;
	}

	public int getNumOfUses() {
		return numOfUses;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setNumOfUses(int numOfUses) {
		this.numOfUses = numOfUses;
	}
	
	
	public abstract void use(Character c);
	
	@Override
	public String toString() {
		return "Object{" + "name=" + name + ", description=" + description + '}';
	}
	
	
	
	

}
