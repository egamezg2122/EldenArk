/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eldenark;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

	Combat(Character mainCharacter, Character enemy) {
		this.mainCharacter = mainCharacter;
		this.enemy = enemy;
		
		setFrame();
		

	}
	
	

	public void setFrame() {
		
		f = new JFrame("Combat");
		ImageIcon icon = new ImageIcon("KAYO_icon.png");
		JButton attack = new JButton("Basic Attack");
		attack.setBounds(10, 300, 100, 50);
		JButton defence = new JButton("Defence");
		defence.setBounds(120, 300, 100, 50);
		JButton abilities = new JButton("Abilities");
		abilities.setBounds(230, 300, 100, 50);
		JButton objects = new JButton("Objects");
		objects.setBounds(340, 300, 100, 50);
		JLabel nombre = new JLabel(icon);
		f.add(nombre);
		f.pack();
		f.add(attack);
		f.add(defence);
		f.add(abilities);
		f.add(objects);
		
		f.setLayout(new LayoutManager());
		
        f.setContentPane(new JLabel(new ImageIcon("fondo.jfif")));
        f.setLayout(new FlowLayout());
        // Just for refresh :) Not optional!
        
		
		f.setSize(599, 399);
		f.setSize(600, 400);
		f.setLayout(null);
		f.setVisible(true);

		attack.addActionListener((ActionEvent e) -> {
			System.out.println("Basic Attack");
			nombre.setLocation(nombre.getX() + 20, nombre.getY());
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

}


