package de.htw.algo.hw3;

public class HW3 {
	static int steps;
	static long startTime, endTime, duration;

	public static void main(String[] args) {
		steps = 0;
		int x = 2;
		int n = 16;
		
		startTime = System.nanoTime();
		int result = exp(x,n);
		endTime = System.nanoTime();		
		duration = (endTime - startTime);
		
		System.out.println("=====Exponential=====");
		System.out.println("x: " + x + ", n: " + n);
		System.out.println("Result: " + result);
		System.out.println("Steps: " + steps);
		System.out.println("CPU-Time: " + duration);
		
		steps=0;
		startTime = System.nanoTime();
		result = expLog(x,n);
		endTime = System.nanoTime();		
		duration = (endTime - startTime);
		
		System.out.println("=====Exponential=====");
		System.out.println("x: " + x + ", n: " + n);
		System.out.println("Result: " + result);
		System.out.println("Steps: " + steps);
		System.out.println("CPU-Time: " + duration);
	}
	
	private static int exp(int x,int n){
		steps++;
		if (n==1)
			return x;
		else
			return x*exp(x,n-1);
	}
	
	private static int expLog(int x,int n){
		steps++;
		if (n==1)
			return x;
		else if(n % 2 == 0)
			return expLog(x*x,n/2);
		else
			return x*expLog(x,n-1);
	}
}
