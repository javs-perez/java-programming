import java.util.Scanner;

public class PointOnLine {
	public static void main(String[] args) {
		// setting variables
		Scanner input = new Scanner(System.in);
		double x0, y0, x1, y1, x2, y2, alpha, beta;
		boolean p2Between, p2InLine;
		String onOrNotOnLine = "on";
		
		// Prompt the user to enter three points
		System.out.print("Enter three points for p0, p1, and p2: ");
		x0 = input.nextDouble();
		y0 = input.nextDouble();
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		
		// Calculate if p2 is in the line that p0 and p1 are on
		alpha = (y2 - y0) / (y1 - y0);
		beta = (x2 - x0) / (x1 - x0);
		p2InLine = alpha == beta;
		
		// Calculate if p2 is in between p0 and p1
		p2Between = (x2 >= x0 && x2 <= x1 && y2 >= y0 && y2 <= y1) || (x2 <= x0 && x2 >= x1 && y2 <= y0 && y2 >= y1);
		
		// Switch string to appear on output only if p2 not on line, as it does default to "on" line as default
		if (!p2InLine || !p2Between)
			onOrNotOnLine = "not on";
		
		// output if point is on line or not
		System.out.println("(" + x2 + ", " + y2 + ") is " + onOrNotOnLine + " the line segment from (" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
	}
}
