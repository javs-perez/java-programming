
public class quizhw {
	public static void main(String[] args) {
		double[] myList = {2, 3, 9, 4, 1, 100, 30};
		double min = myList[0];
		for ( int i = 0; i < myList.length; i++) {
		   if(myList[i] < min) {
			   min = myList[i];
		   }
		}
		
		System.out.print(min);
		
	}
}
