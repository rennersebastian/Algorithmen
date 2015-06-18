package de.htw.algo.hw6;

import java.math.BigInteger;
import java.util.Random;

public class RabinMiller {
	private static int iteration = 1;
	private static final BigInteger ZERO = BigInteger.ZERO;
	private static final BigInteger ONE = BigInteger.ONE;
	private static final BigInteger TWO = BigInteger.valueOf(2);
	
	public boolean isPrime(BigInteger n)
    {
        if (n.equals(TWO) || n.equals(BigInteger.valueOf(3)))
            return true;
        if (n.equals(ZERO) || n.equals(ONE)|| n.mod(TWO).equals(ZERO))
            return false;
        
        int t = 0;
        
        BigInteger s = n.subtract(ONE);
        while(s.mod(TWO).equals(ZERO)){
        	s = s.divide(TWO);
        	t++;
        }
        
        for (int k = 0; k < iteration; k++){
        	BigInteger a = randomBigInteger(n);
        	BigInteger v = a.modPow(s, n);
        	
        	if(!v.equals(ONE)){
        		int i = 0;
        		while(!v.equals(n.subtract(ONE))){
        			if(i == t-1)
        				return false;
        			else{
        				v = v.pow(2).mod(n);
        				i++;
        			}
        		}
        	}
        }
        return true;        
    }
	
	public BigInteger randomBigInteger(BigInteger n) {
		BigInteger a;
	    Random rand = new Random();
		do {
            a = new BigInteger(n.bitLength(), rand);
        } while (a.compareTo(TWO) <= 0 || a.compareTo(n.subtract(ONE)) >= 0);
		
		return a;
	}
}