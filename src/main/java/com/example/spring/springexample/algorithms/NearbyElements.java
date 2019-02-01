package com.example.spring.springexample.algorithms;

import java.util.Arrays;
import java.util.Optional;

public class NearbyElements {

	private int[][] multi = new int[][]{
			{2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323},
			{1, 3, 5, 7},
			{321, 320, 32, 3, 41241, -11, -12, -13, -66, -688}
	};

	/*
	first approach
	 */
	public void nearby(int x, int y, int range) {
		int[] row = multi[y];

		for (int i = x - range; i < x + range + 1; i++) {
			getNumber(i,row);
		}
	}

	private void getNumber(int x, int[] row) {
		String number = null;
		try {
			number = String.valueOf(row[x]);
		} catch (IndexOutOfBoundsException ignored) {
		}
		Optional.ofNullable(number).ifPresent(System.out::println);
	}

	/*
	second approach
	 */

	public int[] nearby2(int x, int y, int range){
		int[] selectedRow = multi[y];

		return Arrays.stream(selectedRow).filter(e -> {
			boolean isCorrect = false;
			for (int i = x-range; i <= x+range; i++) {
				if (getNumber2(i, selectedRow) && selectedRow[i] == e && i!=x) {
					isCorrect = true;
				}
			}
			return isCorrect;
		})
				.toArray();
	}

	private boolean getNumber2(int x, int[] row) {
		String number = null;
		try {
			number = String.valueOf(row[x]);
		} catch (IndexOutOfBoundsException ignored) {
		}
		return Optional.ofNullable(number).isPresent();
	}



	public static void main(String[] args) {
		NearbyElements nearbyElements = new NearbyElements();

		nearbyElements.nearby(0, 0, 100);

		System.out.println("-------");

		for (int i : nearbyElements.nearby2(0, 0, 2)) {
			System.out.println(i);
		}

	}
}
