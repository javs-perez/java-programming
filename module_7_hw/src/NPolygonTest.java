
public class NPolygonTest {
	public static void main(String[] args) {
		// setting 3 new polygons
		RegularPolygon polygon1 = new RegularPolygon();
		RegularPolygon polygon2 = new RegularPolygon(6, 4);
		RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);
		
		// printing out info for polygon 1
		System.out.println("Polygon 1");
		System.out.println("Perimeter: " + polygon1.getPerimeter());
		System.out.println("Area: " + polygon1.getArea());
		
		// printing out info for polygon 2
		System.out.println("Polygon 2");
		System.out.println("Perimeter: " + polygon2.getPerimeter());
		System.out.println("Area: " + polygon2.getArea());
		
		// printing out info for polygon 3
		System.out.println("Polygon 3");
		System.out.println("Perimeter: " + polygon3.getPerimeter());
		System.out.println("Area: " + polygon3.getArea());
	}
}

class RegularPolygon {
	private int n;
	private double side, x, y;
	
	// constructing polygon with defaults
	RegularPolygon() {
		this(3, 1, 0, 0);
	}
	
	// constructing polygon with n sides and length
	RegularPolygon(int n, double side) {
		this(n, side, 0, 0);
	}
	
	// constructing polygon with sides, length, and coordinates
	RegularPolygon(int n, double side, double x, double y) {
		this.n = n;
		this.side = side;
		this.x = x;
		this.y = y;
	}
	
	// getting the sides
	public int getSides() {
		return n;
	}
	
	// getting the length of the sides
	public double getSideLength() {
		return side;
	}
	
	// getting the x coordinate
	public double getXCoordinate() {
		return x;
	}
	
	// getting the y coordinate
	public double getYCoordinate() {
		return y;
	}
	
	// setting the number of side
	public void setSides(int n) {
		this.n = n;
	}
	
	// setting the side length
	public void setSideLength(double side) {
		this.side = side;
	}
	
	// setting the x coordinate
	public void setXCoordinate(double x) {
		this.x = x;
	}
	
	// setting the y coordinate
	public void setYCoordinate(double y) {
		this.y = y;
	}
	
	// getting the perimeter
	public double getPerimeter() {
		return n * side;
	}
	
	// getting the area
	public double getArea() {
		double area;
		
		area = (n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / n));
		
		return area;
	}
	
}
