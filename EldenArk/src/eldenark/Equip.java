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
public class Equip {

	private String name;

	private String type;

	private int profit;

	public Equip(String name, String type, int profit) {
		this.name = name;
		this.type = type;
		this.profit = profit;
	}

	//GETTERS
	public String getName() {
		return name;
	}

	public int getProfit() {
		return profit;
	}

	public String getType() {
		return type;
	}

	//SETTERS
	public void setName(String name) {
		this.name = name;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public void setType(String type) {
		this.type = type;
	}



}
