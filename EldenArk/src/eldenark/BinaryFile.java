package eldenark;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class BinaryFile {

	public static final String FILE_PATH = "file.bin";

	public static void saveGame(Gameplay gameplay) {

		RandomAccessFile randomAccess;
		long pos;
		String clase = gameplay.mainCharacter.getClass().getName().substring(9);
		int weapon = Equip.getEquipNumber(gameplay.mainCharacter.getEquipment()[0], gameplay.mainCharacter.getNewWeapons());
		int helmet = Equip.getEquipNumber(gameplay.mainCharacter.getEquipment()[1], gameplay.mainCharacter.getNewHelmets());
		int chest = Equip.getEquipNumber(gameplay.mainCharacter.getEquipment()[2], gameplay.mainCharacter.getNewChestPlates());
		int leg = Equip.getEquipNumber(gameplay.mainCharacter.getEquipment()[3], gameplay.mainCharacter.getNewLegArmors());

		try {
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
			randomAccess.writeInt(gameplay.getFloor());
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

		} catch (IOException e) {
			System.out.println("File not found\n" + e.toString());
		}
	}

	public static ArrayList<Gameplay> getSaves() {
		ArrayList<Gameplay> saves = new ArrayList<>();
		File file;
		RandomAccessFile randomAccess;
		String a;
		long fileSize;
		int gameplaySize, numSaves, pos;

		//Gameplay variables
		int[][] map = new int[Gameplay.NUM_TILES_Y][Gameplay.NUM_TILES_X];
		String nom, clase;
		byte[] bNom, bClase;
		int lvl, mp, hp, xp, gold, x, y, sex;

		int weapon, helmet, chestplate, leg;
		int obj1, obj2, obj3, obj4;
		int floor;

		int merX, merY, merObj1, merObj1Q, merObj2, merObj2Q, merEquip, merEquipQ;

		try {
			file = new File(FILE_PATH);
			if (file.exists()) {
				fileSize = file.length();
				gameplaySize = Gameplay.SIZE;
				numSaves = (int) fileSize / gameplaySize;
				randomAccess = new RandomAccessFile(file, "r");
				for (int i = 0; i < numSaves; i++) {
					pos = gameplaySize * i;
					randomAccess.seek(pos);
					
					for (int j = 0; j < map.length; j++) {
						for (int k = 0; k < map.length; k++) {
							map[j][k] = randomAccess.readInt();
						}
					}
					//Character Variables
					bNom = new byte[Gameplay.STRING_SIZE];
					randomAccess.read(bNom);
					nom = new String(bNom);
					lvl = randomAccess.readInt();
					mp = randomAccess.readInt();
					hp = randomAccess.readInt();
					xp = randomAccess.readInt();
					gold = randomAccess.readInt();
					x = randomAccess.readInt();
					y = randomAccess.readInt();
					
					bClase = new byte[Gameplay.STRING_SIZE];
					randomAccess.read(bClase);
					clase = new String(bClase);
					
					sex = randomAccess.readInt();
					floor = randomAccess.readInt();
					
					//Equipment Variables
					weapon = randomAccess.readInt();
					helmet = randomAccess.readInt();
					chestplate = randomAccess.readInt();
					leg = randomAccess.readInt();
					
					//Objects Variables
					obj1 = randomAccess.readInt();
					obj2 = randomAccess.readInt();
					obj3 = randomAccess.readInt();
					obj4 = randomAccess.readInt();
					
					//Merchant Variables
					merX = randomAccess.readInt();
					merY = randomAccess.readInt();
					merObj1 = randomAccess.readInt();
					merObj1Q = randomAccess.readInt();
					merObj2 = randomAccess.readInt();
					merObj2Q = randomAccess.readInt();
					merEquip = randomAccess.readInt();
					merEquipQ = randomAccess.readInt();
					
					EldenArk.reDoInventory(obj1, obj2, obj3, obj4);
					
					
				}
			} else{
				new Exception("No s'ha trobat l'arxiu" + FILE_PATH);
			}

		} catch (FileNotFoundException e) {
			System.out.println("No s'ha pogut accedir a l'arxiu" + FILE_PATH + "\n" + e.toString());
		} catch (IOException e) {
			System.out.println("No s'ha trobat l'arxiu" + FILE_PATH + "\n" + e.toString());
		}
		return saves;
	}
	
	public static Character getMainCharacter(int lvl, int mp, int hp, int gold, int xp, int x, int y, String clase){
		Character mainCharacter;
		
		switch(clase){
			case "Warrior":
				
				break;
			case "Mage":
				
				break;
			case "Priest":
				
				break;
			default:
				
		}
		
		return mainCharacter;
		
	}
	/*
	public static Gameplay loadGame() {
		Gameplay toReturn = new Gameplay();
		
		return toReturn;
	}
	 */
}
