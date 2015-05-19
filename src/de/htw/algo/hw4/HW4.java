package de.htw.algo.hw4;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class HW4 extends Application {
	private Sorter sorter = new Sorter();
	private static long startTime, durationIns, durationQuick, durationMerge;
	private static BigInteger comparisonsQuick, comparisonsIns, comparisonsMerge;
	private static final int MAX_N = 2000;
	private static final int STEPS = 100;
	private static final int LOOPS = 500;
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override public void start(Stage stage) {   	
    	/**
    	 * Sorting Test
    	 */
    	List<Integer> testNums = generateRandomNumbers(5);
    	printNumbers(testNums, "Input");
    	printNumbers(sorter.quicksort(testNums), "Quicksort");
    	printNumbers(sorter.insertionSort(testNums), "Insertionsort");
    	printNumbers(sorter.mergeSort(testNums), "Mergesort");
    	System.out.println();
    	
        stage.setTitle("Algorithmen - HW4");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Input size n");
        yAxis.setLabel("Time in ns");
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Sorting Algorithms");     
        
        yAxis.setLabel("amount of comparisions");
        final LineChart<Number,Number> lineChartComp = 
                new LineChart<Number,Number>(xAxis,yAxis);
        lineChartComp.setTitle("Sorting Algorithms Comparisions"); 

        XYChart.Series quickSort = new XYChart.Series();
        XYChart.Series insertionSort = new XYChart.Series();
        XYChart.Series mergeSort = new XYChart.Series();
        quickSort.setName("Quicksort");        
        insertionSort.setName("Insertionsort"); 
        mergeSort.setName("Mergesort"); 
        // Amount of comparisions
        XYChart.Series quickSortComp = new XYChart.Series();
        XYChart.Series insertionSortComp = new XYChart.Series();
        XYChart.Series mergeSortComp = new XYChart.Series();
        quickSortComp.setName("Quicksort");        
        insertionSortComp.setName("Insertionsort"); 
        mergeSortComp.setName("Mergesort");
        
        for(int i = STEPS; i <= MAX_N; i+=STEPS){
        	durationIns = 0;
        	durationQuick = 0;
        	durationMerge = 0;
        	
        	sorter.comparisonsQuick = BigInteger.ZERO;
        	sorter.comparisonsIns = BigInteger.ZERO;
        	sorter.comparisonsMerge = BigInteger.ZERO;
        	
        	List<Integer> input = generateRandomNumbers(i);
        	/* 
        	 * Input für Tests mit sortierten Listen
        	List<Integer> input = new ArrayList<Integer>();
            for(int k = 0; k <= i; k++)
            	input.add(k, k);
            */
        	for(int j = 0; j < LOOPS; j++){
	        	startTime = System.nanoTime();
	        	sorter.insertionSort(input);
	    		durationIns += (System.nanoTime() - startTime);
	        	startTime = System.nanoTime();
	        	sorter.quicksort(input);
	    		durationQuick += (System.nanoTime() - startTime);
	        	startTime = System.nanoTime();
	        	sorter.mergeSort(input);
	    		durationMerge += (System.nanoTime() - startTime);
        	}
        	quickSort.getData().add(new XYChart.Data<Integer, Long>(i, (durationQuick/LOOPS)));
    		insertionSort.getData().add(new XYChart.Data<Integer, Long>(i, (durationIns/LOOPS)));
    		mergeSort.getData().add(new XYChart.Data<Integer, Long>(i, (durationMerge/LOOPS)));
    		
    		// Average amount of comparisions
    		comparisonsQuick = sorter.comparisonsQuick.divide(BigInteger.valueOf(LOOPS));
    		comparisonsIns = sorter.comparisonsIns.divide(BigInteger.valueOf(LOOPS));
    		comparisonsMerge = sorter.comparisonsMerge.divide(BigInteger.valueOf(LOOPS));
    		quickSortComp.getData().add(new XYChart.Data<Integer, BigInteger>(i, comparisonsQuick));
    		insertionSortComp.getData().add(new XYChart.Data<Integer, BigInteger>(i, comparisonsIns));
    		mergeSortComp.getData().add(new XYChart.Data<Integer, BigInteger>(i, comparisonsMerge));
    		
    		System.out.println("Ins: " + comparisonsIns + " - " + "Quick: " + comparisonsQuick + " Merge: " + comparisonsMerge);
        }

        List<Integer> sortedList = new ArrayList<Integer>();
        for(int i = 0; i <= MAX_N+STEPS; i++)
        	sortedList.add(i, i);
		
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(quickSort);
        lineChart.getData().add(insertionSort);
        lineChart.getData().add(mergeSort);
       
        stage.setScene(scene);
        stage.show();
        
        scene = new Scene(lineChartComp,800,600);
        lineChartComp.getData().add(quickSortComp);
        lineChartComp.getData().add(insertionSortComp);
        lineChartComp.getData().add(mergeSortComp);
        
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
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
		System.out.println("Numbers:");
		for (int i = 0; i < numbers.size()-1; ++i) {
			System.out.print(numbers.get(i) + ", ");
		}
		System.out.print(numbers.get(numbers.size()-1));
		System.out.println();		
	}
}