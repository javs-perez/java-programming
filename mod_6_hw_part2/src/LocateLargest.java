import java.util.Scanner;

public class LocateLargest {
	public static void main(String[] args) {
		// setting variables needed
		int rows, cols;
		int[] size = new int[2], location = new int[2];
		double[][] matrix = null;
		
		// prompting the user for the size of the matrix
		size = getMatrixSize();
		rows = size[0];
		cols = size[1];
		
		// seetting memory for matrix
		matrix = new double[rows][cols];
		
		// getting the location of the max value
		location = getArrayMax(matrix, rows, cols);
		
		System.out.println("the location of the largest element is at (" + location[0] + ", " + location[1] + ")");
	}


	private static int[] getArrayMax(double[][] matrix, int rows, int cols) {
		// seeting variable
		Scanner input = new Scanner(System.in);
		double max = 0;
		int[] location = new int[2];
				
		// prompting user for array and finding the max value
		System.out.println("Enter the array: ");
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				matrix[i][j] = input.nextDouble();
	
				if(matrix[i][j] >= max) {
					location[0] = i;
					location[1] = j;
					max = matrix[i][j];
				}
			}
		}
		
		// return the location of the max value
		return location;
	}

	// prompting the user for the size of the matrix
	private static int[] getMatrixSize() {
		int[] size = new int[2];
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of rows and columns of the array: ");
		size[0] = input.nextInt();
		size[1] = input.nextInt();
		
		return size;
	}
}