import java.util.Scanner;

public class QuadraticTest {
	public static void main(String[] args) {
		// setting variables
		Scanner input = new Scanner(System.in);
		QuadraticEquation equation;
		double a, b, c;
		
		// prompting user for a b and c values
		System.out.print("Enter values for a, b and c: ");
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		
		// constructing equation from inputs
		equation = new QuadraticEquation(a, b, c);
		
		// displaying results
		displayResults(equation);
		
		// closing input
		input.close();
	}
	
	// function to handle output
	public static void displayResults(QuadraticEquation equation) {
		// setting vars
		double discriminant = equation.getDiscriminant();
		
		// if statement to handle output depending on discriminant
		if(discriminant == 0) {
			System.out.println("Equation has only 1 root.");
			System.out.println("The one root is: " + equation.getRoot1());
		} else if(discriminant > 0) {
			System.out.println("Equation has 2 roots.");
			System.out.println("Root number one is: " + equation.getRoot1());
			System.out.println("Root number two is: " + equation.getRoot2());
		} else {
			System.out.println("The equation has no roots.");
		}		
	}
}

class QuadraticEquation {
	// setting var
	private double a, b, c;
	
	// construct for equation with 3 vars
	QuadraticEquation(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	// calculating disriminant
	public double getDiscriminant() {
		double discriminant;
		
		discriminant = Math.pow(b, 2) - (4 * a * c);

		return discriminant;
	}
	
	// getting root 1, plus discriminant
	public double getRoot1() {
		double discriminant = getDiscriminant(), root;
		
		if(discriminant < 0) {
			root = 0;
		} else {
			root = ((b * -1) + Math.sqrt(discriminant)) / (2 * a);
		}
		
		return root;
	}
	
	// getting root 2, minus discriminant
	public double getRoot2() {
		double discriminant = getDiscriminant(), root;
		
		if(discriminant < 0) {
			root = 0;
		} else {
			root = ((b * -1) - Math.sqrt(discriminant)) / (2 * a);
		}
		
		return root;
	}
}
