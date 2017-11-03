import java.util.Scanner;

public class Palindrome {
	// reverse the number
	public static int reverse(int number) {
		int reversed = 0;
		
		// reversing the number with a while loop
		while(number != 0) {
			int digit = number % 10;
			reversed = reversed * 10 + digit;
			number /= 10;
		}
		
		return reversed;
	}
	
	// check to see if reverse is the same as the number
	public static boolean isPalindrome(int number) {
		int reversed = reverse(number);
				
		return reversed == number;
	}
	
	public static void main(String[] args) {
		// setting variables
		Scanner input = new Scanner(System.in);
		int testNumber;
		
		// Prompt the user to enter an integer to test
		System.out.print("Please enter an integer: ");
		testNumber = input.nextInt();
		input.close();
		
		if(isPalindrome(testNumber)) {
			System.out.print("Integer is a palindrome" );
		} else {
			System.out.print("Integer is not a palindrome" );
		}
	}
}
