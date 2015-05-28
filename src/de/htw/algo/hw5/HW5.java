package de.htw.algo.hw5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.htw.algo.hw4.Sorter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class HW5 extends Application {
	private static Sorter sorter = new Sorter();
	private static Heap heap = new Heap();;
	private static long startTime, durationQuick, durationHeap;
	private static final int MAX_N = 500;
	private static final int STEPS = 100;
	private static final int LOOPS = 100;
	
	@Override
	public void start(Stage stage) { 
		List<Integer> testNums = generateRandomNumbers(15);
		
    	printNumbers(testNums, "Input");
    	printNumbers(sorter.quicksort(testNums), "Quicksort");
    	printNumbers(heap.heapSort(testNums), "Heapsort");
    	
    	stage.setTitle("Algorithmen - HW5");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Input size n");
        yAxis.setLabel("Time in ns");
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Sorting Algorithms");     

        XYChart.Series quickSort = new XYChart.Series();
        XYChart.Series heapSort = new XYChart.Series();
        quickSort.setName("Quicksort");
        heapSort.setName("Heapsort");
        
        for(int i = STEPS; i <= MAX_N; i+=STEPS){
        	durationQuick = 0;
        	durationHeap = 0;
        	List<Integer> input = generateRandomNumbers(i);
        	
        	for(int j = 0; j < LOOPS; j++){
	        	startTime = System.nanoTime();
	        	sorter.quicksort(input);
	    		durationQuick += (System.nanoTime() - startTime);
	        	startTime = System.nanoTime();
	        	heap.heapSort(input);
	    		durationHeap += (System.nanoTime() - startTime);
        	}
        	quickSort.getData().add(new XYChart.Data<Integer, Long>(i, (durationQuick/LOOPS)));
        	heapSort.getData().add(new XYChart.Data<Integer, Long>(i, (durationHeap/LOOPS)));
        }
		
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(quickSort);
        lineChart.getData().add(heapSort);
       
        stage.setScene(scene);
        stage.show();
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

	public static void main(String[] args) {
        launch(args);
    }
}
