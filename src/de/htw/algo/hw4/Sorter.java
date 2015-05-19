package de.htw.algo.hw4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Sorter {
	/**
	 * QUICKSORT
	 */
	public List<Integer> quicksort(List<Integer> input) {
		if (!input.isEmpty()) {
			Integer pivot = input.get(0); // This pivot can change to get faster results

			List<Integer> less = new LinkedList<Integer>();
			List<Integer> pivotList = new LinkedList<Integer>();
			List<Integer> more = new LinkedList<Integer>();

			// Partition
			for (Integer i : input) {
				if (i.compareTo(pivot) < 0) {
					less.add(i);
				}
				else if (i.compareTo(pivot) > 0)
					more.add(i);
				else
					pivotList.add(i);
			}

			// Recursively sort sublists
			less = quicksort(less);
			more = quicksort(more);

			// Concatenate results
			less.addAll(pivotList);
			less.addAll(more);
			return less;
		}
		return input;
	}	
	/**
	 * INSERTIONSORT
	 */
	public List<Integer> insertionSort(List<Integer> input) {
		List<Integer> result = new ArrayList<Integer>();
		result.addAll(input);
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
	/**
	 * MERGESORT
	 */
	public List<Integer> mergeSort(List<Integer> input) {
		if (input.size() <= 1)
			return input;
		int middle = input.size() / 2;
		List<Integer> left = input.subList(0, middle);
		List<Integer> right = input.subList(middle, input.size());
		right = mergeSort(right);
		left = mergeSort(left);
		List<Integer> result = merge(left, right);
		return result;
	}
	
	private List<Integer> merge(List<Integer> left, List<Integer> right) {
		List<Integer> result = new ArrayList<Integer>();
		Iterator<Integer> it1 = left.iterator();
		Iterator<Integer> it2 = right.iterator();

		Integer x = it1.next();
		Integer y = it2.next();
		while (true) {
			if (x.compareTo(y) <= 0) {
				result.add(x);
				if (it1.hasNext()) {
					x = it1.next();
				} else {
					result.add(y);
					while (it2.hasNext()) {
						result.add(it2.next());
					}
					break;
				}
			} else {
				result.add(y);
				if (it2.hasNext()) {
					y = it2.next();
				} else {
					result.add(x);
					while (it1.hasNext()) {
						result.add(it1.next());
					}
					break;
				}
			}
		}
		return result;
	}
}
