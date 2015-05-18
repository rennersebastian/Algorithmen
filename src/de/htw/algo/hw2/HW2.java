package de.htw.algo.hw2;

import java.math.BigInteger;

public class HW2 {
	static int steps;
	static long startTime, endTime, duration;
	
	public static void main(String[] args) {
		steps = 0;
		BigInteger n = new BigInteger("1");
		BigInteger m = new BigInteger("3");
		
		startTime = System.nanoTime();
		BigInteger result = ackermann(m,n);
		endTime = System.nanoTime();		
		duration = (endTime - startTime);
		
		System.out.println("=====Ackermann=====");
		System.out.println("m: " + m + ", n: " + n);
		System.out.println("Result: " + result);
		System.out.println("Steps: " + steps);
		System.out.println("CPU-Time: " + duration);
	}
	
	public static BigInteger ackermann(BigInteger m, BigInteger n){
		steps++;
		if(m.equals(BigInteger.ZERO))
			return n.add(BigInteger.ONE);
		else if(n.equals(BigInteger.ZERO))
			return ackermann(m.subtract(BigInteger.ONE), BigInteger.ONE);
		else
			return ackermann(m.subtract(BigInteger.ONE), ackermann(m, n.subtract(BigInteger.ONE)));
	}
}
