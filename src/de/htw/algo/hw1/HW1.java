package de.htw.algo.hw1;

import java.math.BigInteger;

public class HW1 {

	static int steps;
	static long startTime, endTime, duration;
	static BigInteger a, b, result;
	
	public static void main(String[] args) {
		steps = 0;
		a = new BigInteger("121393");
		b = new BigInteger("75025");
		
		startTime = System.nanoTime();
		result = gcd(a, b);
		endTime = System.nanoTime();		
		duration = (endTime - startTime);
		
		System.out.println("=====GCD=====");
		System.out.println("GCD: " + result);
		System.out.println("Steps: " + steps);
		System.out.println("CPU-Time: " + duration);
		
		steps = 0;
		startTime = System.nanoTime();
		result = gcdMod(a, b);
		endTime = System.nanoTime();		
		duration = (endTime - startTime);
		
		System.out.println("=====GCD Modulo=====");
		System.out.println("GCD: " + result);
		System.out.println("Steps: " + steps);
		System.out.println("CPU-Time: " + duration);
		

		steps = 0;
		startTime = System.nanoTime();
		result = fib(new BigInteger("33"));
		endTime = System.nanoTime();		
		duration = (endTime - startTime);
		
		System.out.println("=====Fibonacci=====");
		System.out.println("Fibonacci: " + result);
		System.out.println("Steps: " + steps);
		System.out.println("CPU-Time: " + duration);
	}

	public static BigInteger gcd(BigInteger a, BigInteger b){
		while(!b.equals(BigInteger.ZERO)){
			steps++;
			if(a.compareTo(b) > 0)
				a = a.subtract(b);
			else
				b = b.subtract(a);
		}		
		return a;
	}
	
	public static BigInteger gcdMod(BigInteger a, BigInteger b){
		BigInteger t = null;		
		while(!b.equals(BigInteger.ZERO)){
			steps++;
			t = b;
			b = a.mod(b);
			a = t;
		}		
		return a;
	}
	
	public static BigInteger fib(BigInteger n){
		steps++;
		if(n.equals(BigInteger.ZERO))
			return BigInteger.ZERO;
		if(n.equals(BigInteger.ONE))
			return BigInteger.ONE;
		else
			return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(new BigInteger("2"))));
	}
}
