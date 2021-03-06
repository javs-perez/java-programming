import java.util.Arrays;
import java.util.Scanner;

public class Distinct {
	public static void main(String[] args) {
		// setting variables needed
		Scanner input = new Scanner(System.in);
		int[] numbers = new int[10];
		int dupCount;
		
		// Prompting user for 10 numbers
		System.out.print("Enter ten numbers: ");
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextInt();
		}
			
		// closing input
		input.close();
		
		// calculating dup count only once and passing it throug
		dupCount = duplicateCount(numbers);
				
		// printing the number of distinct numbers
		System.out.println("The number of distinct numbers is: " + (10 - dupCount));
		
		// printing out the distinct numbers array
		System.out.print("The distinct nums are: " + Arrays.toString(findDistinctNums(dupCount, numbers)));
	}
	
	private static int duplicateCount(int[] numbers) {
		int duplicateCount = 0;
		
		// calculating how many numbers are duplicates
		for(int i = 0; i < numbers.length; i++) {
			if(isDuplicate(numbers[i], i, numbers)) {
				duplicateCount++;
			}
		}
		
		return duplicateCount;
	}

	// finding the distinct numbers
	private static int[] findDistinctNums(int dupCount, int[] numbers) {
		int distinctNumsIndex = 0;
		int[] distinctNums;

		// Setting memory for distinct nums which is 10 minus the duplicate count
		distinctNums = new int[10 - dupCount];
		
		for(int i = 0; i < numbers.length; i++) {
			if(!isDuplicate(numbers[i], i, numbers)) {
				distinctNums[distinctNumsIndex] = numbers[i];
				distinctNumsIndex++;		
			}
		}
		
		return distinctNums;
		
	}

	private static boolean isDuplicate(int num, int index, int[] numbers) {
		boolean duplicate = false;
		
		for(int i = index + 1; i < numbers.length; i++) {
			if(num == numbers[i]) {
				duplicate = true;
				break;
			}
		}
		
		return duplicate;
	}
}
