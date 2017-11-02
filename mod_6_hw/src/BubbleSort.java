import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		// setting variables needed
		Scanner input = new Scanner(System.in);
		double[] numbers = new double[10];
		
		// Prompting user for 10 numbers
		System.out.print("Enter ten numbers: ");
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextDouble();
		}
		
		// closing input
		input.close();
		
		// running bubble sort on array of numbers
		bubbleSort(numbers);
		displayArray(numbers);
	}
	
	// displays sorted numbers array
	private static void displayArray(double[] numbers) {
		System.out.print("Sorted numbers: " + Arrays.toString(numbers));
		
	}
	
	// passing numbers array and sorting it with bubble sort
	private static void bubbleSort(double[] numbers) {
		double temp;
		boolean notSorted = true;
		
		while(notSorted) {
			notSorted = false;
			
			for(int i = 0; i < numbers.length - 1; i++) {
				if(numbers[i] > numbers[i + 1]) {
					notSorted = true;
					//create a temp number and switch numbers
					temp = numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i + 1] = temp;
				}
			}
		} 	
	}
}

// 2 3 8 2 3 9 1 7 8 9