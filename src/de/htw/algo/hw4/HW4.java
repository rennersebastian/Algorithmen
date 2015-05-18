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
	private static final long MAX_N = 1000;
	
    @Override public void start(Stage stage) {   	   	
        stage.setTitle("Sorting Algorithms");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Input size n");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Sorting Algorithms");
        

        XYChart.Series quicksort = new XYChart.Series();
        XYChart.Series insertionSort = new XYChart.Series();
        quicksort.setName("Quicksort");        
        insertionSort.setName("Insertion Sort"); 
        for(int i = 100; i <= MAX_N; i+=100){
        	durationIns = 0;
        	durationQuick = 0;
        	List<Integer> rndNumbers = generateRandomNumbers(i);
        	for(int j = 0; j < 500; j++){
	        	startTime = System.nanoTime();
	        	sorter.quicksort(rndNumbers);
	    		durationQuick += (System.nanoTime() - startTime);
	        	startTime = System.nanoTime();
	        	sorter.insertionSort(rndNumbers);
	    		durationIns += (System.nanoTime() - startTime);
        	}
    		quicksort.getData().add(new XYChart.Data<Integer, Long>(i, (durationQuick/500)/100000));
    		insertionSort.getData().add(new XYChart.Data<Integer, Long>(i, (durationIns/500)/100000));
        }

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(quicksort);
        lineChart.getData().add(insertionSort);
       
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
}