package com.example.spring.springexample.algorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener extends JFrame implements KeyListener {

	Integer[] plC = {0, 0};

	public Listener() {
		super("KeyListener Test");
		setPreferredSize(new Dimension(300, 100));
		addKeyListener(this);

		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyChar()) {
			case 'w':
				plC[0]--;
				showMap();
				break;
			case 's':
				plC[0]++;
				showMap();
				break;
			case 'a':
				plC[1]--;
				showMap();
				break;
			case 'd':
				plC[1]++;
				showMap();
				break;
			default:
				System.out.println("bye bye");
				System.exit(0);
		}
	}

	private void showMap() {

		char[][] s = new char[10][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				s[i][j] = (char) ((char) j + 97);
			}
		}

		s[plC[0]][plC[1]] = '@';

		System.out.println();
		System.out.println();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(s[i][j]);
			}
			System.out.println();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
