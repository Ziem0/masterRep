package com.example.spring.springexample.algorithms;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Alg1 extends JFrame implements KeyListener {{

//	public static void main(String[] args) {
//
//		String person = "@";
//
//		char[][] s = new char[10][10];
//
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				s[i][j] = (char) ((char) j+97);
//			}
//		}
//
//		while ()
//
//
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				System.out.print(s[i][j]);
//			}
//			System.out.println("");
//		}



	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyChar()) {
			case 'w':
				System.out.println("upper!");
				break;
			case 's':
				break;
			case 'a':
				break;
			case 'd':
				break;
			default:
				System.out.println("bye bye");
				System.exit(0);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
