package de.htw.algo.hw5;

public class Heap {
	static int heapsize, maximum, left, right;
	static int[] a;
	
	public static void buildHeap(int []a){
		heapsize=a.length-1;
        for(int i=heapsize/2;i>=0;i--){
        	maxHeapify(a,i);
        }
    }
	
	public static void maxHeapify(int[] a, int i){ 
        left=2*i;
        right=2*i+1;
        if(left <= heapsize && a[left] > a[i]){
        	maximum=left;
        }
        else{
        	maximum=i;
        }
        
        if(right <= heapsize && a[right] > a[maximum]){
        	maximum=right;
        }
        if(maximum!=i){
        	swap(i,maximum);
        	maxHeapify(a, maximum);
        }
    }
	
	public static void swap(int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t; 
    }
	
	public void sort(int []a0){
        a=a0;
        buildHeap(a);
        
        for(int i=heapsize;i>0;i--){
            swap(0, i);
            heapsize=heapsize-1;
            maxHeapify(a, 0);
        }
    }
}