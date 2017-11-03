import java.util.Scanner;

public class CreditCardValidation {
	public static boolean isValid(long number) {
		int size = getSize(number);
		int oddSum = sumOfOddPlace(number);
		int evenSum = sumOfDoubleEvenPlace(number);
		int sum = oddSum + evenSum;
		 
		// if all conditions are met then credit card number is valid
		if(prefixMatched(number) && size >= 13 && size <= 16 && sum % 10 == 0) { 
			return true;
		} else {
			return false;
		}
	}
	
	// adding double the number in even places, form the right. part of the Luhn Check
	public static int sumOfDoubleEvenPlace(long number) {
		int sum = 0, cardNumLength = getSize(number);
		char currentNum;
		String numString = Long.toString(number);
		
		// starting from the right side of the array by initializing i at the length of the card number minus one
		for(int i = cardNumLength - 1; i == 0; i--) {
			if(i % 2 == 0) {
				currentNum = numString.charAt(i);				
				sum += getDigit(Character.getNumericValue(currentNum) * 2);
			}
		}
		
		return sum;
	}
	
	// returns the addition of the digits of a number
	public static int getDigit(int number) {
		int sum = 0;
		
		do {
			while (number > 0) {
	            sum += number % 10;
	            number = number / 10;
	        }
		} while(sum > 9);
		
		return sum;
	}
	
	// sum of the odd digits of a number, starting from the right. part of the Luhn check
	public static int sumOfOddPlace(long number) {
		int sum = 0, cardNumLength = getSize(number);
		char currentNum;
		String numString = Long.toString(number);
		
		// starting from the right side of the array by initializing i at the length of the card number minus one
		for(int i = cardNumLength - 1; i == 0; i--) {
			if(i % 2 != 0) {
				currentNum = numString.charAt(i - 1);
				sum += Character.getNumericValue(currentNum);
			}
		}
		
		return sum;		
	}
	
	// returning boolean depending on the prefix matching one of the 4 expected cards
	public static boolean prefixMatched(long number) {
		long prefix1, prefix2;
		
		prefix1 = getPrefix(number, 1);
		prefix2 = getPrefix(number, 2);
		
		if (prefix1 == 4 || prefix1 == 5 || prefix1 == 6 || prefix2 == 37) {
			return true;
		}
		return false;
	}
	
	// returning the length of the card number
	public static int getSize(long d) {
		int length = String.valueOf(d).length();
		return length;
	}
	
	// returning the prefix for a number, for size k
	public static long getPrefix(long number, int k) {
		long digits = Long.parseLong(Long.toString(number).substring(0, k));
		return digits;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long cardNumber;
		
		// Prompt user for credit card number
		System.out.print("Enter a credit card number as a long integer:");
		cardNumber = input.nextLong();
		input.close();
		
		if(isValid(cardNumber)) {
			System.out.print(cardNumber + " is valid");
		} else {
			System.out.print(cardNumber + " is invalid");
		}
		
	}
	
}
