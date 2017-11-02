
public class PalindromicPrime {
	// Checks if an integer is prime or not.
	public static boolean isPrime(int number) {
		// 2 is a weird prime number and the only even prime number
		if (number == 2) return true;
		// if it's a multiple of 2 then return false
	    if (number % 2 == 0) return false;
	    
	    //if not, then just check the odds
	    for(int x = 3; x * x <= number; x += 2) {
	        if(number % x == 0)
	            return false;
	    }
	    return true;
	}
	
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
	
	// is palindrome if the number is equal to the reversed
	public static boolean isPalindrome(int number) {
		int reversed = reverse(number);
				
		return reversed == number;
	}

	public static void main(String[] args) {
		// setting variables, counter keeps track of total numbers, spaceCounter checks when a new line character needs to be added
		// numberToCheck starts at 2 as it is the first prime number
		int counter = 0, spaceCounter = 1, numberToCheck = 2;
		
		while(counter < 100) {
			// only printing out number if it's both palindrome and prime, also adding one to counter
			if(isPalindrome(numberToCheck) && isPrime(numberToCheck)) {
				if(spaceCounter == 10) {
					// when spaceCounter reaches 10 printing out with a new line character at the end
					// and resetting spaceCounter to 1
					System.out.println(numberToCheck + " ");
					spaceCounter = 1;
				} else {
					System.out.print(numberToCheck + " ");
					spaceCounter +=1;
				}
				counter += 1;
			}
			numberToCheck += 1;
		}
	}
}
