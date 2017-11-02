import java.util.Scanner;

/*
 * Write a program that prompts the user to enter the center coordinates and radii of two circles and determines
 * whether the second circle is inside the first or overlaps with the first, as shown in figure 3.10 (Hint: circle2 
 * is inside circle 1 if the distance between the two centers <= |r1 - r2| and circle2 overlaps circle1 if the distance between the two centers 
 * <= r1 + r2.)
 */

public class TwoCircles {
	public static void main(String[] args) {
		// setting variables
		Scanner input = new Scanner(System.in);
		double x1, y1, radius1, x2, y2, radius2, distance;
		
		// Prompt the user to enter circles' information
		System.out.print("Enter circle1's center x-, y-coordinates, and radius: ");
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		radius1 = input.nextDouble();
		
		System.out.print("Enter circle2's center x-, y-coordinates, and radius: ");
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		radius2 = input.nextDouble();
		
		// Calculate distance between the two centers
		distance = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
		
		// calculate if circle2 is inside or overlaps with circle1
		if (distance <= Math.abs(radius1 - radius2)) {		
			System.out.println("Circle2 is inside Circle1.");
		} else if (distance <= (radius1 + radius2)) {
			System.out.println("Circle2 and Circle1 overlap.");
		} else {
			System.out.println("Circle2 is not inside nor does it overlap with Circle1.");
		}
	}
}
