package eldenark;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;


public class BinaryFile {
	
	public static final String FILE_PATH = "file.bin";
	
	public static void saveGame (Gameplay gameplay){
		
		
		RandomAccessFile randomAccess;
		long pos;
		String clase = gameplay.mainCharacter.getClass().getName().substring(9);
		int weapon = Equip.getEquipNumber(gameplay.mainCharacter.getEquipment()[0], gameplay.mainCharacter.getNewWeapons());
		int helmet = Equip.getEquipNumber(gameplay.mainCharacter.getEquipment()[1], gameplay.mainCharacter.getNewHelmets());
		int chest = Equip.getEquipNumber(gameplay.mainCharacter.getEquipment()[2], gameplay.mainCharacter.getNewChestPlates());
		int leg = Equip.getEquipNumber(gameplay.mainCharacter.getEquipment()[3], gameplay.mainCharacter.getNewLegArmors());
		
		
		try{
			randomAccess = new RandomAccessFile(FILE_PATH, "rw");
			pos = randomAccess.length();
			randomAccess.seek(pos);
			//Saving the map 800int (40x20)
			for (int j = 0; j < gameplay.map.length; j++) {
				for (int k = 0; k < gameplay.map[j].length; k++) {
					randomAccess.writeInt(gameplay.map[j][k]);
				}
			}
			randomAccess.write(Gameplay.stringParser(gameplay.nickname).getBytes(Charset.defaultCharset()));
			randomAccess.writeInt(gameplay.mainCharacter.getLevel());
			randomAccess.writeInt(gameplay.mainCharacter.getMp());
			randomAccess.writeInt(gameplay.mainCharacter.getHp());
			randomAccess.writeInt(gameplay.mainCharacter.getXp());
			randomAccess.writeInt(gameplay.mainCharacter.getGold());
			randomAccess.writeInt(gameplay.mainCharacter.getX());
			randomAccess.writeInt(gameplay.mainCharacter.getY());
			randomAccess.write(Gameplay.stringParser(clase).getBytes(Charset.defaultCharset()));
			randomAccess.writeInt(gameplay.mainCharacter.getSex());
			randomAccess.writeInt(weapon);
			randomAccess.writeInt(helmet);
			randomAccess.writeInt(chest);
			randomAccess.writeInt(leg);
			randomAccess.writeInt(gameplay.mainCharacter.getInventory()[0].getNumOfUses());
			randomAccess.writeInt(gameplay.mainCharacter.getInventory()[1].getNumOfUses());
			randomAccess.writeInt(gameplay.mainCharacter.getInventory()[2].getNumOfUses());
			randomAccess.writeInt(gameplay.mainCharacter.getInventory()[3].getNumOfUses());
			randomAccess.writeInt(gameplay.merchant.getX());
			randomAccess.writeInt(gameplay.merchant.getY());
			randomAccess.writeInt(gameplay.merchant.getSmallObjectNum());
			randomAccess.writeInt(gameplay.merchant.getQuantitySmallObject());
			randomAccess.writeInt(gameplay.merchant.getBigObjectNum());
			randomAccess.writeInt(gameplay.merchant.getQuantityBigObject());
			randomAccess.writeInt(gameplay.merchant.getEquipmentNum());
			randomAccess.writeInt(gameplay.merchant.getQuantityEquip());
			
			
			
			
			
			
			
			randomAccess.close();
			
		} catch(IOException e) {
			System.out.println("File not found\n" + e.toString());
		}
	}
	/*
	public static Gameplay loadGame() {
		Gameplay toReturn = new Gameplay();
		
		return toReturn;
	}
*/
}
