/* Write a program that plays the popular scissor-rock-paper game.
 * The program randomly generates a number 0, 1, or 2 
 * representing scissor, rock and apaper. 
 * The program prompts the user to enter a number 0, 1 or 2 
 * and displays a message indicating whether the user or 
 * the computer wins loses or draws. 
 */

import java.util.Scanner;

public class RockPaperScissor {
	public static void main(String[] args) {
		// setting variables
		Scanner input = new Scanner(System.in);
		String randWordShape = "rock", userWordShape = "rocks";
		int randShape, userShape;
		char result = 'd';
		
		
		// Generate random number between 0 and 2
		randShape = (int)(Math.random() * 3);
		
		
		// Prompt the user to enter a shape
		System.out.print("Enter either scissor (0), rock (1), or paper (2): ");
		userShape = input.nextInt();
		
		// set variables with the word for the shape choice
		switch(randShape) {
			case 0:
				randWordShape = "scissor";
				break;
			case 1:
				randWordShape = "rock";
				break;
			case 2:
				randWordShape = "paper";
				break;
		}
		
		switch(userShape) {
			case 0:
				userWordShape = "scissor";
				break;
			case 1:
				userWordShape = "rock";
				break;
			case 2:
				userWordShape = "paper";
				break;
		}
		
		// compare computer choices vs user choice and set a result depending on the match
		// result can either be 'd' (draw), 'w' (win), or 'l' (loss) for user.
		switch (randShape) {
			case 0:
				switch (userShape) {
					case 0:
						result = 'd';
						break;
					case 1:
						result = 'w';
						break;
					case 2:
						result = 'l';
						break;
				}
				break;
			case 1:
				switch (userShape) {
					case 0:
						result = 'l';
						break;
					case 1:
						result = 'd';
						break;
					case 2:
						result = 'w';
						break;
				}
				break;
			case 2:
				switch (userShape) {
					case 0:
						result = 'w';
						break;
					case 1:
						result = 'l';
						break;
					case 2:
						result = 'd';
						break;
				}
				break;
		}
		
		// print out results
		System.out.print("The computer is " + randWordShape + ". ");
		
		if (result == 'd') {
			System.out.print("You are " + userWordShape + " too. ");
		} else {
			System.out.print("You are " + userWordShape + ". ");
		}
		
		switch (result) {
			case 'w':
				System.out.println("You won!");
				break;
			case 'l':
				System.out.println("You lost!");
				break;
			case 'd':
				System.out.println("It is a draw!");
				break;
		
		}
	}
}
