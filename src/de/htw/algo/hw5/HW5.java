package de.htw.algo.hw5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.htw.algo.hw4.Sorter;

public class HW5 {
	private static Sorter sorter = new Sorter();
	private static Heap heap;
	
	public static void main(String[] args) {
		List<Integer> testNums = generateRandomNumbers(15);
		
		heap = new Heap(testNums);
		
    	printNumbers(testNums, "Input");
    	printNumbers(sorter.quicksort(testNums), "Quicksort");
    	//printNumbers(heap.sort(), "Heapsort");
	}

	private static List<Integer> generateRandomNumbers(int n){		
	    List<Integer> list = new ArrayList<Integer>(n);
	    Random random = new Random();		
	    for (int i = 0; i < n; i++) {
		    list.add(random.nextInt(n * 10));
	    }	
	    return list;
	}	
	
	public static void printNumbers(List<Integer> numbers, String type) {
    	System.out.println("=====" + type + "=====");
		for (int i = 0; i < numbers.size()-1; ++i) {
			System.out.print(numbers.get(i) + ", ");
		}
		System.out.print(numbers.get(numbers.size()-1));
		System.out.println();		
	}
}
