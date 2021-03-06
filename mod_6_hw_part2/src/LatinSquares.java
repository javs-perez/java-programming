import java.util.Scanner;

public class LatinSquares {
	public static void main(String[] args) {
		// setting variables needed
		Scanner input = new Scanner(System.in);
		char[][] latinMatrix;
		char[] alphabetSet;
		int matrixSize;
		
		System.out.println("Enter number n: ");
		matrixSize = input.nextInt();
		
		latinMatrix = new char[matrixSize][matrixSize];
		alphabetSet = new char[matrixSize];
		
		alphabetSet = letters(matrixSize);
		
		getMatrixCells(latinMatrix, matrixSize, alphabetSet);
		
		isLatinSquare(latinMatrix);
	}
	
	// prompt user for matrix cells
	private static void getMatrixCells(char[][] latinMatrix, int matrixSize, char[] alphabetSet) {
		Scanner input = new Scanner(System.in);
		char letter;
		
		System.out.println("Enter " + matrixSize + " rows of letters separated by spaces: ");
		for(int i = 0; i < matrixSize; i++) {
			for(int j = 0; j < matrixSize; j++) {
				letter = input.next().charAt(0);
				if(letterIsInArray(alphabetSet, letter)) {
					latinMatrix[i][j] = letter;
				} else {
					System.out.println("Wrong Input! The letters must be from A to " + (char) ('A' + matrixSize));
					break;
				}
			}
		}
	}

	//  check to see if matrix is a latin square
	private static void isLatinSquare(char[][] latinMatrix) {
		boolean isLatin = true;
		int matrixSize = latinMatrix.length, count; 
		char [] tmpArray = new char[matrixSize - 1];
		char currentLetter;
		
		for(int i = 0; i < matrixSize; i++) {
			for(int j = 0; j < matrixSize; j++) {
				currentLetter = latinMatrix[i][j];
				count = 0;
				
				for(int y = 0; y < matrixSize; y++) {
					if(y != j) {
						tmpArray[count] = latinMatrix[i][y];
						count++;
					}
				}
				
				if(letterIsInArray(tmpArray, currentLetter)) {
					isLatin = false;
					break;
				} else {
					for(int x = 0; x < matrixSize; x++) {
						if(currentLetter == latinMatrix[x][j] && x != i) {
							isLatin = false;
							break;
						}
					}
				}

				if(!isLatin) break;
			}
			
			if(!isLatin) break;
		}
		
		if(isLatin) {
			System.out.println("The input array is a latin square");
		} else {
			System.out.println("The input array is not a latin square");
		}
		
	}
	
	// checks to see if letter is in array
	private static boolean letterIsInArray(char[] alphabet, char letter) {
		boolean isInArray = false;
		
		for(int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] == letter) {
				isInArray = true;
				break;
			}
		}
		
		return isInArray;
	}
	
	// gets letters that can be used
	public static char[] letters(int size) {
		char[] alphabet = new char[size];
		char currentLetter = 'A';
		
		for(int i = 0; i < size; i++) {
			alphabet[i] = currentLetter;
			currentLetter = (char) (currentLetter + 1);
		}
		
		return alphabet;
	}

}
