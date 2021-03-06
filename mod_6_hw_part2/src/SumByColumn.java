import java.util.Scanner;

public class SumByColumn {
	public static void main(String[] args) {
		// setting variables needed
		double[][] matrix = new double[3][4];
		
		// prompting user for matrix
		promptUser(matrix);
		
		// displaying the sum of the columns
		displaySums(matrix);
	}
	
	// displays the sum of columns
	private static void displaySums(double[][] matrix) {
		for(int i = 0; i < matrix[0].length; i++) {
			System.out.println("sum of column " + i + " equals: " + sumColumn(matrix, i));
		}
	}
	
	// prompts user for a 3 by 4 matrix
	private static void promptUser(double[][] matrix) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a 3-by-4 matrix row by row:");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				matrix[i][j] = input.nextDouble();
			}	
		}
		
		input.close();
	}
	
	// returns the sum of a specific column for the matrix
	public static double sumColumn(double[][] m, int columnIndex) {
		double sum = 0;
		
		for(int i = 0; i < m.length; i++) {
			sum += m[i][columnIndex];
		}
		
		return sum;
	}
}
