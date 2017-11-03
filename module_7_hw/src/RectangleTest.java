
public class RectangleTest {
	public static void main(String[] args) {
		// creating rectangles with width and height		
		Rectangle r1 = new Rectangle(4, 40);
		Rectangle r2 = new Rectangle(3.5, 35.9);
		
		// displaying width, height area and perimeter for each rectangle
		System.out.println("The width of rectangle 1 is: " + r1.width);
		System.out.println("The height of rectangle 1 is: " + r1.height);
		System.out.println("The area of rectangle 1 is: " + r1.getArea());
		System.out.println("The perimeter of rectangle 1 is: " + r1.getPerimeter());
		
		System.out.println("The width of rectangle 2 is: " + r2.width);
		System.out.println("The height of rectangle 2 is: " + r2.height);
		System.out.println("The area of rectangle 2 is: " + r2.getArea());
		System.out.println("The perimeter of rectangle 2 is: " + r2.getPerimeter());
	}
}

class Rectangle {
	double width, height;
	
	Rectangle() {
		this(1, 1);
	}
	
	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	double getArea() {
		return width * height;
	}
	
	double getPerimeter() {
		return 2*width + 2*height;
	}
}
