import java.util.Scanner;

public class Grading {
	public static void main(String[] args) {
		// setting variables needed
		Scanner input = new Scanner(System.in);
		int numStudents, max = 0;
		int[] scores;
		
		// Prompting user for amount of student scores to process
		System.out.print("Enter the number of students: ");
		numStudents = input.nextInt();
		
		// Requesting memory for array depending on user output
		scores = new int[numStudents];
		
		// Promptin user for scores
		System.out.print("Enter " + numStudents + " scores: ");
		for(int i = 0; i < scores.length; i++) {
			scores[i] = input.nextInt();
			if(scores[i] > max) {
				max = scores[i];
			}
		}
		
		// Closing input
		input.close();
		
		// Looping through scores array and printing out grade
		for(int i = 0; i < scores.length; i++) {
			displayStudentGrade(i, scores[i], max);
						
		}
	}
	
	// Display student scores and grade
	private static void displayStudentGrade(int i, int score, int max) {
		System.out.println("Student " + i + " score is " + score + " and grade is " + studentScore(score, max));
	}

	// Assigning grade depending on score and max score
	public static char studentScore(int score, int max) {
		char studentGrade;
		
		if(score >= max - 10) {
			studentGrade = 'A';
		} else if(score >= max - 20) {
			studentGrade = 'B';
		} else if(score >= max - 30) {
			studentGrade = 'C';
		} else if(score >= max - 40) {
			studentGrade = 'D';
		} else {
			studentGrade = 'F';
		}
		
		return studentGrade;
	}

}
