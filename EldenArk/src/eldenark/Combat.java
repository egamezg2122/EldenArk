/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eldenark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author cep
 */
public class Combat extends JFrame {

	JFrame f;
    JPanel prueba;
    Character mainCharacter;
    Character enemy;
    JLabel enemyImage;
    JTextField stats;
    int hp = 200;

    Combat() {
        setFrame();
    }

    Combat(Character mainCharacter, Character enemy) {
        this.mainCharacter = mainCharacter;
        this.enemy = enemy;

        setFrame();

    }

    public void setFrame() {

        this.setName("Combat");
        JButton attack = new JButton("Basic Attack");
        attack.setBounds(10, 300, 100, 50);
        JButton defence = new JButton("Defence");
        defence.setBounds(120, 300, 100, 50);
        JButton abilities = new JButton("Abilities");
        abilities.setBounds(230, 300, 100, 50);
        JButton objects = new JButton("Objects");
        objects.setBounds(340, 300, 100, 50);

        /*
                ImageIcon icon = new ImageIcon("KAYO_icon.png");
		JLabel nombre = new JLabel(icon);
                nombre.setIcon(icon);
		f.add(nombre);
		nombre.setLocation(700, 100);
         */
        addBackground();

        // Buttons
        this.add(attack);
        this.add(defence);
        this.add(abilities);
        this.add(objects);
        this.pack();
        this.setLayout(null);
        this.setVisible(true);

        addEnemy();

        stats = new JTextField();
        stats.setBounds(20, 50, 280, 30);
        this.add(stats);
        stats.setBackground(Color.red);
        recheckStats();

        attack.addActionListener((ActionEvent e) -> {
            hp--;
            recheckStats();
        });
        defence.addActionListener((ActionEvent e) -> {
            System.out.println("Caldo de pollo");
        });
        abilities.addActionListener((ActionEvent e) -> {
            changeFrame();
        });
    }

    public void changeFrame() {

    }

    public void addEnemy() {
        ImageIcon icon = new ImageIcon("KAYO_icon.png");
        JLabel nombre = new JLabel(icon);
        this.add(nombre);
        nombre.setLocation(700, 100);
        this.pack();
    }

    public void addBackground() {

        this.setContentPane(new JLabel(new ImageIcon("prueba.jpg")));
        final ImageIcon background = new ImageIcon("prueba.jpg");
        JTextArea text = new JTextArea() {
            Image img = background.getImage();
            // instance initializer

            {
                setOpaque(false);
            }

            @Override
            public void paintComponent(Graphics graphics) {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }
        };
        JScrollPane pane = new JScrollPane(text);
        Container content = this.getContentPane();
        content.add(pane, BorderLayout.CENTER);

    }

    public void recheckStats() {
        String actualStats;
        actualStats = ("HP: " + hp + "/" + hp + "\tMP: " + hp + "/" + hp);

        stats.setText(actualStats);
    }
}
