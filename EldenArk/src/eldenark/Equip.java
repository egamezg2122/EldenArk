package eldenark;

/**
 *
 * @author cep
 * 
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

    public Equip() {

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
	
	public static int getEquipNumber(Equip mainCharacterEquiped, Equip[] newEquip){
		int equipFloor = 0;
		int i = 0;
		do {
			if (mainCharacterEquiped.getName().equalsIgnoreCase(newEquip[i].getName())) {
				equipFloor = i;
			}
			i++;
		} while (i < newEquip.length && equipFloor == 0);
		
		return equipFloor;
	}

}
