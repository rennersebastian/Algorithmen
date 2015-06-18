package de.htw.algo.hw6;

import java.math.BigInteger;
import java.util.Random;

public class HW6 {

	public static void main(String[] args) {
		RabinMiller rm = new RabinMiller();

		int countBI = 0;
		int countRM = 0;
		for(int i = 1; i <= 1000000; i++){
			if(BigInteger.valueOf(i).isProbablePrime(64)){
				countBI++;
				if(!rm.isPrime(BigInteger.valueOf(i)))
					System.out.println(i + " - Not found");
				else
					countRM++;
			}
		}
		System.out.println("BigInteger Primes found: " + countBI);
		System.out.println("Rabin Miller Primes found: " + countRM + "\n");
		
		Random rnd = new Random();
		BigInteger bit;
		while(true){
			bit = new BigInteger(512, rnd);
			if(rm.isPrime(bit)){
				System.out.println("512 Bit (pseudo) Random number: " + bit);
				break;
			}				
		}
		
		while(true){
			bit = new BigInteger(32, rnd);
			
			if(!bit.isProbablePrime(64)){
				if(rm.isPrime(bit)){
					System.out.println(bit + " false detection");
					break;
				}
			}
		}
	}
}