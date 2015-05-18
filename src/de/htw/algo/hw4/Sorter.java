package de.htw.algo.hw4;

import java.util.ArrayList;
import java.util.List;

public class Sorter {
	/**
	 * QUICKSORT
	 */
	public List<Integer> quicksort(List<Integer> input){		
		if(input.size() <= 1){
			return input;
		}		
		int middle = (int) Math.ceil((double)input.size() / 2);
		int pivot = input.get(middle); 
		List<Integer> less = new ArrayList<Integer>();
		List<Integer> greater = new ArrayList<Integer>();		
		for (int i = 0; i < input.size(); i++) {
			if(input.get(i) <= pivot){
				if(i == middle){
					continue;
				}
				less.add(input.get(i));
			}
			else{
				greater.add(input.get(i));
			}
		}		
		return concat(quicksort(less), pivot, quicksort(greater));
	}
	
	public List<Integer> concat(List<Integer> less, int pivot, List<Integer> greater){		
		List<Integer> list = new ArrayList<Integer>();		
		for (int i = 0; i < less.size(); i++) {
			list.add(less.get(i));
		}		
		list.add(pivot);		
		for (int i = 0; i < greater.size(); i++) {
			list.add(greater.get(i));
		}		
		return list;
	}
	/**
	 * INSERTION SORT
	 */
	public List<Integer> insertionSort(List<Integer> list) {
		List<Integer> result = new ArrayList<Integer>();
		result.addAll(list);
		int size = result.size();
		for (int i = 1; i < size; i++) {
			Integer value = result.get(i);
			int j = i-1;
			while (j >= 0 && result.get(j).compareTo(value) > 0) {
				result.set(j+1, result.get(j));
				j = j-1;
			}
			result.set(j+1, value);
		}		
		return result;
	}
}
