
public class ChanceAtWinning {
	// setting a random number for dice to use from 1 to 6
		public static int randomFace() {
			return 1 + (int)(Math.random() * 6);
		}
		
		// running game and returning win or lose
		public static String runGame() {
			String winOrLose = "";
			int dice1, dice2, sum, points;
			
			dice1 = randomFace();
			dice2 = randomFace();
			sum = dice1 + dice2;
			
			if(sum == 2 || sum == 3 || sum == 12) {
				winOrLose = "lose";
			} else if(sum == 7 || sum == 11) {
				winOrLose = "win";
			} else {
				points = sum;
				
				while(winOrLose == "") {
					dice1 = randomFace();
					dice2 = randomFace();
					sum = dice1 + dice2;
					
					if(sum == 7) {
						winOrLose = "lose";
					} else if(sum == points) {
						winOrLose = "win";
					} 
				}
			}
			
			return winOrLose;
		}
		
		public static void main(String[] args) {
			int winCount = 0;
			String result;
			
			// running game 10000 times and keeping count of wins
			for(int i = 0; i < 10000; i++) {
				result = runGame();
				
				if(result == "win") {
					winCount += 1;
				}
			}
			
			// printing out the amount of wins
			System.out.println("Win Count = " + winCount);
		}
}
