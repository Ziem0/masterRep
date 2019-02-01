package com.example.spring.springexample.algorithms;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class MineSweeper {

	private char[][] table;
	private int x;
	private int y;


	public MineSweeper(int x1, int y1) {
		this.x = x1;
		this.y = y1;
		this.table = createTable();
	}

	private char[][] createTable() {
		table = new char[x][y];
		int minesAmmount = (int) Math.round((x * y) * 0.3);

		List<Integer> randomX = new Random().ints(minesAmmount, 0,x).boxed().collect(Collectors.toList());
		List<Integer> randomY = new Random().ints(minesAmmount,0,y).boxed().collect(Collectors.toList());

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {

				if (randomX.size() > 0) {
					table[randomX.remove(0)][randomY.remove(0)] = '*';
				}

				if (table[i][j] != '*') {
					table[i][j] = '.';
				}
			}
		}
		return table;
	}

	private void showTable() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(table[i][j]);
			}
			System.out.println();
		}
	}

	public void convertTable() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (table[i][j] != '*') {
					table[i][j] = calculate(i,j);
				}
			}
		}
	}

	private char calculate(int i, int j) {
		char counter = 48;

		int[] scope = {-1, 0, 1};

		for (int w : scope) {
			for (int l : scope) {
				if (getChar(i + w, j + l).isPresent() && getChar(i + w, j + l).get() == '*') {
					counter++;
				}
			}
		}
		return counter;
	}

	private Optional<Character> getChar(int i, int j) {
		Character character = null;
		try {
			character = table[i][j];
		} catch (IndexOutOfBoundsException e) {
		}
		Optional<Character> ch = Optional.ofNullable(character);
		return ch;
	}



	public static void main(String[] args) {
		MineSweeper mineSweeper = new MineSweeper(10, 10);
		mineSweeper.convertTable();
		mineSweeper.showTable();
	}
}
