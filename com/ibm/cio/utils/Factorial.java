package com.ibm.cio.utils;

public class Factorial {
	
	public static void main(String[] args) {
		System.out.println("Starting  recurrsive at "+new java.util.Date().getTime());
		System.out.println(args[0]+"!="+Factorial.recursive(Integer.parseInt(args[0])));
		System.out.println("Completed recurrsive at "+new java.util.Date().getTime());
		System.out.println("Starting  iterative  at "+new java.util.Date().getTime());
		System.out.println(args[0]+"!="+Factorial.iterative(Integer.parseInt(args[0])));
		System.out.println("Completed iterative  at "+new java.util.Date().getTime());
		
	}
	
	public static long recursive(int number) {
		switch (checkValidNumber(number)) {
			case 0:
				return 1;
			default:
				return recursive(number-1)*number;
		}
		
	}
	
	public static long iterative(int number) {
		checkValidNumber(number);
		long result = 1;
		for (int i=number; i>0; i--) result *= i;
		return result;
	}
	
	private static int checkValidNumber(int number) {
		if (number<0) throw new IllegalArgumentException();
		return number;
	}
	
}
