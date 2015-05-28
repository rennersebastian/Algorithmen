package de.htw.algo.hw5;

import java.util.ArrayList;
import java.util.List;

public class Heap {
	private static List<Integer> list = new ArrayList<Integer>();
	private static int heapSize, maximum, left, right;
	
	private static void swap(int i, int j){
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	
	private static void maxHeapify(List<Integer> a, int i){
		left = 2*i;
		right = 2*i+1;
		
		if(left <= heapSize && a.get(left) > a.get(i))
			maximum = left;
		else
			maximum = i;
		
		if(right <= heapSize && a.get(right) > a.get(maximum))
			maximum = right;
		
		if(maximum != i){
			swap(i, maximum);	
			maxHeapify(a, maximum);
		}
			
	}
	
	private static void buildMaxHeap(List<Integer> a){
		heapSize = a.size()-1;

		for(int i = heapSize/2; i >= 0; i--)
			maxHeapify(a, i);
	}
	
	public List<Integer> heapSort(List<Integer> a){
		list = a;
		buildMaxHeap(list);
		
		for(int i = heapSize; i > 0; i--){
			swap(0, i);
			heapSize -= 1;
			maxHeapify(list, 0);
		}
		
		return list;
	}
}