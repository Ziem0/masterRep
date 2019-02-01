package com.example.spring.springexample.algorithms;

import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class PrimeFactorization {

	private static Integer getLowestPrime(int baseNumber) {
		UnaryOperator<Integer>  searcher = n -> IntStream.range(2, n+1).filter(e -> n % e == 0)
				.findFirst().getAsInt();
		Integer prime = searcher.apply(baseNumber);
		System.out.printf("%d ",prime);
		return prime;
	}

	private static void showPrimes(int originalNumber) {
		while (originalNumber != 1) {
			originalNumber /= getLowestPrime(originalNumber);
		}
	}

	public static void main(String[] args) {
		showPrimes(12);
	}

}
