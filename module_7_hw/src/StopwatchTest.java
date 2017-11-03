import java.util.Random;
import java.util.Date;

public class StopwatchTest {
	public static void main(String[] args) {
		// setting needed variables
		StopWatch stopWatch = new StopWatch();
		int[] randomNumbers = generateRandomArray();
		
		// sorting numbers and taking time right before and after
		stopWatch.start();
		selectionSort(randomNumbers);
		stopWatch.stop();
		
		System.out.println("The time to sort an array of 100,000 random numbers is " + stopWatch.getElapsedTime() + " milliseconds.");
	}
	
	// generating a random array
	public static int[] generateRandomArray() {
		int n = 100000;
	    int[] list = new int[n];
	    Random random = new Random();

	    for (int i = 0; i < n; i++) {
	    		list[i] = random.nextInt(n);
	    }
	    
	   return list;
	}
	
	// selection sort from the book
	public static void selectionSort(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			// Find the minimum in the list
			int currentMin = list[i];
			int currentMinIndex = i;
			
			for(int j = i + 1; j < list.length; j++) {
				if(currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			
			// swap list[i] with list[currentMinIndex] if necessary
			if(currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}
}

class StopWatch {
	private Date startTime, endTime;
	
	// construction stop watch
	StopWatch() {
		startTime = new Date();
	}
	
	// setting start time to current time
	public void start() {
		startTime = new Date();
	}
	
	// setting stop time to current time
	public void stop() {
		endTime = new Date();
	}
	
	// calculating elapsed time in milliseconds
	public double getElapsedTime() {
		return endTime.getTime() - startTime.getTime();
	}
}  
