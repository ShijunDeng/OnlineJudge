package com.whitedew.algorithm.utils;

import java.util.List;

public class PrintUtil {
	public static void printIL(List<Integer> L) {
		for (Integer e : L) {
			System.out.print(e + " ");
		}
	}
	public static void printSL(List<String> L) {
		for (String e : L) {
			System.out.print(e + " ");
		}
	}
	public static void printILL(List<List<Integer>> LL) {
		for (List<Integer> e : LL) {
			printIL(e);
			System.out.println();
		}
	}

	public static void printAR(char[] array) {
		for (char e : array) {
			System.out.print(e + " ");
		}
	}

	public static void print2AR(char[][] arrays) {
		for (char[] e : arrays) {
			printAR(e);
			System.out.println();
		}
	}
}
