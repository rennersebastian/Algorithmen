package de.htw.algo.hw5;

import java.util.Random;

public class HW5{
	private static Heap heap = new Heap();;
	private static long startTime, durationQuick, durationHeap;
	private static final int MAX_N = 10000;
	private static final int STEPS = 2000;
	private static final int LOOPS = 100;

	public static void main(String[] args) {
		/**
    	 * Sorting Test
    	 */
    	int[] testNums = generateRandomNumbers(25);
    	int[] heapnums = testNums.clone();
    	printNumbers(testNums, "Input");
    	quickSort(testNums,0,testNums.length-1);
    	printNumbers(testNums, "Quicksort");
    	heap.sort(heapnums);
    	printNumbers(heapnums, "HeapSort");
    	System.out.println();
        
        for(int i = 10000; i <= MAX_N; i+=STEPS){
        	durationQuick = 0;
        	
        	int[] input = generateRandomNumbers(i);
        	int[] heapNums = input.clone();

        	for(int j = 0; j < LOOPS; j++){
	        	startTime = System.nanoTime();
	        	quickSort(input, 0, input.length-1);
	    		durationQuick += (System.nanoTime() - startTime);
	        	startTime = System.nanoTime();
	        	heap.sort(heapNums);
	        	durationHeap += (System.nanoTime() - startTime);
        	}
        }
        System.out.println((durationQuick/LOOPS)/10000 + " ms");
        System.out.println((durationHeap/LOOPS)/10000 + " ms");
    }
	
	public static void quickSort(int[] A, int al, int ar){
	    if (al<ar){
	        int pivot = A[al], i=al, j=ar+1;
	        while (true){
	            while (A[++i]<pivot && i<ar){}
	            while (A[--j]>pivot && j>al){}
	            if (i<j) swap(A, i, j);
	            else break;
	        }
	        swap(A, j, al);
	        
	        quickSort(A, al, j-1);
	        quickSort(A, j+1, ar);
	    }
	}
	public static void swap(int[] A, int i, int j){
	    int t=A[i]; A[i]=A[j]; A[j]=t;
	}

	
	private static int[] generateRandomNumbers(int n){		
	    int[] rndNumbers = new int[n];
	    Random random = new Random();		
	    for (int i = 0; i < n; i++) {
		    rndNumbers[i] = random.nextInt(n * 10);
	    }	
	    return rndNumbers;
	}	
	
	public static void printNumbers(int[] numbers, String type) {
    	System.out.println("=====" + type + "=====");
		for (int i = 0; i < numbers.length-1; ++i) {
			System.out.print(numbers[i] + ", ");
		}
		System.out.print(numbers[numbers.length-1]);
		System.out.println();		
	}
}
