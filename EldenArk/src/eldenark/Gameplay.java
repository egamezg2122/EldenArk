/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eldenark;


import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;

/**
 *
 * @author cep
 */
public class Gameplay extends KeyAdapter {

	int[][] map = new int[10][30];
	static Random rn = new Random();
	
	public static void createMap(int[][] array) {
        /* 0 - Nothing
        10 - Loot
        20 - Enemy
         */
        for (int[] array1 : array) {
            for (int j = 0; j < array.length; j++) {
                array1[j] = rn.nextInt(3);
            }
        }
    }
	
	/*	public static void generateMountains(int[][] map){
	int x, y, i;
	i = 0;
	do {
	x = rn.nextInt(30);
	y = rn.nextInt(10);
	} while (x != 15 && y != 5);
	
	do {
	try {
	map[y][x] = 10;
	} catch (indexOutOfBound e){
	
	}
	} while (i < 5);
	
	
	
	
	
	
	
	}*/
	
	public static void printMap(int[][] map, Character mainCharacter) {
        for (int i = 0; i < map.length; i++) {
            System.out.println(Color.red + "\n_____________________________________________________________\n");
            for (int j = 0; j < map[i].length; j++) {
				if (j == mainCharacter.getX() && i == mainCharacter.getY()) {
					System.out.print("|" + "\u001B[34m"+"    O" + "\u001B[30m");
				} else{
					System.out.print("|");
				}
            }
            System.out.print("|");
        }
        System.out.println("\n_____________________________________________________________");
    }
	
	
	
	
	
	
	
	/*
	Timer timer;
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyChar()) {
			case 'w':
				//Thing that happens when the 'w' key is pressed
				break;
			case 's':
				//Thing that happens when the 's' key is pressed
				break;
			case 'd':
				//Thing that happens when the 'd' key is pressed
				break;
			case 'a':
				//Thing that happens when the 'a' key is pressed
				break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				//Thing that happens when the ArrowUp key is pressed
				break;
			case KeyEvent.VK_DOWN:
				//Thing that happens when the ArrowDown key is pressed
				break;
			case KeyEvent.VK_RIGHT:
				//Thing that happens when the ArrowRight key is pressed
				break;
			case KeyEvent.VK_LEFT:
				//Thing that happens when the ArrowLeft key is pressed
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}*/

}
