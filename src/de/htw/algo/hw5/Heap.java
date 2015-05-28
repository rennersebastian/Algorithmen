package de.htw.algo.hw5;

import java.util.ArrayList;
import java.util.List;

public class Heap {
	private static List<Integer> list = new ArrayList<Integer>();
	
	public Heap(List<Integer> unsortedList){
		this.list = unsortedList;
	}
	
	public void setList(List<Integer> unsortedList){
		this.list = unsortedList;
	}
	
	private void swap(List<Integer> list, int i, int j){
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
}
