import java.util.Scanner;

/* Write a program that reads three edges for a triangle and computes the perimeter
 * if the input is valid. Otherwise, display that the input is invalid. The input is valid if the
 * sum of every pair of two edges is greater than the remaining edge.
 */
public class TrianglePerimeter {
	public static void main(String[] args) {
		// setting variables
		Scanner input = new Scanner(System.in);
		double side1, side2, side3, sumA, sumB, sumC, perimeter;
		
		// Prompt the user to enter a 3 sides
		System.out.print("Enter length of three different sides of a triangle (separated by spaces e.g. 3 4 5): ");
		side1 = input.nextDouble();
		side2 = input.nextDouble();
		side3 = input.nextDouble();
	
		// calculate sum of pair
		sumA = side1 + side2;
		sumB = side2 + side3;
		sumC = side1 + side3;
		
		// calculate validity
		if (sumA > side3 && sumB > side1 && sumC > side2) {
			perimeter = side1 + side2 + side3;
			System.out.println("The perimeter of the triangle is " + perimeter + ".");
		} else {
			System.out.println("The perimeter cannot be calculated, input is invalid!");
		}
	}
}
