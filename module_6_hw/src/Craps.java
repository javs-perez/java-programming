
public class Craps {
	// setting a random number for dice to use from 1 to 6
	public static int randomFace() {
		return 1 + (int)(Math.random() * 6);
	}
	
	// setting a random number for dice to use from 1 to 6
	public static void printResults(int x, int y, int s) {
		System.out.println("You rolled " + x + " + " + y + " = " + s);
	}
	
	public static void main(String[] args) {
		String winOrLose = "";
		int dice1, dice2, sum, points;
		
		// starting with two random integers for the dice
		dice1 = randomFace();
		dice2 = randomFace();
		sum = dice1 + dice2;
		
		printResults(dice1, dice2, sum);
		if(sum == 2 || sum == 3 || sum == 12) {
			winOrLose = "lose";
		} else if(sum == 7 || sum == 11) {
			winOrLose = "win";
		} else { // when neither 2, 3, 12, 7 or 11 come out the first time then set the points
			System.out.println("Point is " + sum);
			points = sum;
			
			// once points are set, only get out when there is either a win or lose scenario
			while(winOrLose == "") {
				dice1 = randomFace();
				dice2 = randomFace();
				sum = dice1 + dice2;
				
				printResults(dice1, dice2, sum);
				if(sum == 7) {
					winOrLose = "lose";
				} else if(sum == points) {
					winOrLose = "win";
				} else {
					System.out.println("Roll again");
				}
			}
		}
		
		// printing out results
		System.out.println("You " + winOrLose);
	}
}
