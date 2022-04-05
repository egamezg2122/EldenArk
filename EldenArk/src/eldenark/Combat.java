/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eldenark;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author cep
 */
public class Combat extends JFrame {

	JPanel prueba;

	Combat(Character mainCharacter, Character enemy) {

		setFrame();
		

	}

	public void setFrame() {
		JFrame f = new JFrame("Button Example");
		JButton b = new JButton("Atack");
		b.setBounds(10, 300, 100, 50);
		JButton c = new JButton("Defence");
		c.setBounds(120, 300, 100, 50);
		JButton d = new JButton("Abilities");
		d.setBounds(230, 300, 100, 50);
		f.add(b);
		f.add(c);
		f.add(d);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);

		b.addActionListener((ActionEvent e) -> {
			System.out.println("a");
			
		});
		c.addActionListener((ActionEvent e) -> {
			System.out.println("b");
			
		});
		d.addActionListener((ActionEvent e) -> {
			f.setVisible(false);
			changeFrame();
			
		});
	}

	public void changeFrame() {

		JFrame f = new JFrame("Maricon");
		JButton b = new JButton("a");
		b.setBounds(10, 300, 100, 50);
		JButton c = new JButton("b");
		c.setBounds(120, 300, 100, 50);
		JButton d = new JButton("c");
		d.setBounds(230, 300, 100, 50);
		f.add(b);
		f.add(c);
		f.add(d);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);

		b.addActionListener((ActionEvent e) -> {
			System.out.println("Bobolon");
		});
		c.addActionListener((ActionEvent e) -> {
			System.out.println("Caldo de pollo");
		});
		d.addActionListener((ActionEvent e) -> {
			changeFrame();
		});
	}

}
