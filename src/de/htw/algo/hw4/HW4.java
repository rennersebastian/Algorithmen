package de.htw.algo.hw4;
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
	private static final int MAX_N = 2000;
	private static final int STEPS = 100;
	private static final int LOOPS = 500;
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override public void start(Stage stage) {   	
    	/**
    	 * Sorting Test
    	 */
    	List<Integer> testNums = generateRandomNumbers(25);
    	printNumbers(testNums, "Input");
    	printNumbers(sorter.quicksort(testNums), "Quicksort");
    	printNumbers(sorter.insertionSort(testNums), "Insertionsort");
    	printNumbers(sorter.mergeSort(testNums), "Mergesort");
    	
        stage.setTitle("Algorithmen - HW4");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Input size n");
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Sorting Algorithms");        

        XYChart.Series quickSort = new XYChart.Series();
        XYChart.Series insertionSort = new XYChart.Series();
        XYChart.Series mergeSort = new XYChart.Series();
        quickSort.setName("Quicksort");        
        insertionSort.setName("Insertionsort"); 
        mergeSort.setName("Mergesort"); 
        for(int i = STEPS; i <= MAX_N; i+=STEPS){
        	durationIns = 0;
        	durationQuick = 0;
        	durationMerge = 0;
        	List<Integer> rndNumbers = generateRandomNumbers(i);
        	for(int j = 0; j < LOOPS; j++){
	        	startTime = System.nanoTime();
	        	sorter.insertionSort(rndNumbers);
	    		durationIns += (System.nanoTime() - startTime);
	        	startTime = System.nanoTime();
	        	sorter.quicksort(rndNumbers);
	    		durationQuick += (System.nanoTime() - startTime);
	        	startTime = System.nanoTime();
	        	sorter.mergeSort(rndNumbers);
	    		durationMerge += (System.nanoTime() - startTime);
        	}
        	quickSort.getData().add(new XYChart.Data<Integer, Long>(i, (durationQuick/LOOPS)));
    		insertionSort.getData().add(new XYChart.Data<Integer, Long>(i, (durationIns/LOOPS)));
    		mergeSort.getData().add(new XYChart.Data<Integer, Long>(i, (durationMerge/LOOPS)));
        }

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(quickSort);
        lineChart.getData().add(insertionSort);
        lineChart.getData().add(mergeSort);
       
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