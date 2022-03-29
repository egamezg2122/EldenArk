package eldenark;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Map extends JFrame {
	
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
	static final int DELAY = 100;
	
	
	Map(){
            
            this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
            this.setBackground(Color.BLACK);
            this.setFocusable(true);
            this.addKeyListener(new MyKeyAdapter());
            startGame();
            
	}
	
	public void startGame(){
            
        }
        
        public void paintComponent(Graphics g){
            super.paintComponents(g);
            draw(g);
        }
        
        public void draw(Graphics g){
            for (int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++) {
                g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
            }
        }
        
	public class MyKeyAdapter extends KeyAdapter {
		
		@Override
		public void keyTyped(KeyEvent e){
			switch(e.getKeyChar()){
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
		public void keyPressed(KeyEvent e){
			switch(e.getKeyCode()){
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
		public void keyReleased(KeyEvent e){
			
		}
		
		
		
		
	}
	
}
