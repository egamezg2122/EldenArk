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
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 100;

    Map() {

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        
        this.setBackground(Color.BLACK);
        
        this.setFocusable(true);
        
        //this.addKeyListener(new MyKeyAdapter());
        
        startGame();

    }

    public void startGame() {

    }

    public void paintComponent(Graphics g) {
        
        super.paintComponents(g);
        
        draw(g);
        
    }

    public void draw(Graphics g) {

        for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {

            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);

            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);

        }

    }

}
