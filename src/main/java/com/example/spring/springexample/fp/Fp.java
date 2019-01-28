package com.example.spring.springexample.fp;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Fp {

	private static <T> Stream<T> one(Function<T, T> foo, Collection<T> list) {
		return list
				.stream()
				.map(foo);
	}

	private static Stream<Integer> two(Collection<Integer> list, Function<Integer, Predicate<Integer>> foo, Integer num) {
		return list.stream()
				.filter(foo.apply(num));
	}

	private static Stream three(Collection<Integer> list, Function<Integer, UnaryOperator<Integer>> foo, Integer i) {
		return list.stream()
				.map(foo.apply(i));
	}

	private static Stream four(Collection<Integer>list, BiFunction<Integer, String, UnaryOperator<String>> foo, String s) {
		return list.stream()
				.map(e -> foo.apply(e, s).apply(s));
	}


	private static Stream five(Collection<Integer> list, Ifun<Integer, Predicate<Integer>> ifun) {
		return list.stream()
				.map(e -> ifun.m1(e).test(e));
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 78);

		

		five(list, a -> b -> a - b == 0).forEach(System.out::println);

//		Optional<String> ziemo = Optional.ofNullable("elo ziemo");
//		ziemo.ifPresent(e -> System.out.println(e + "!!!!!"));

		//four
//		four(list, (a, b) -> c -> b.length() + a + c, "ziemo").forEach(System.out::println);


		//three
//		three(list, e -> f -> e + f, 100).forEach(System.out::println);

		//two
//		two(list, e -> pivot -> pivot > e, 4).forEach(System.out::println);

		//one
//		one(a -> a + 10, list).forEach(System.out::println);
	}
}
