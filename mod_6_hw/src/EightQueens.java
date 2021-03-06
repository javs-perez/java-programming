public class EightQueens {
	// brute force approach to place 8 queens that cannot attach each other
	// in a 8x8 chess board
	public static void main(String[] args) {
		// setting variables needed
		int queenNum = 8;
		int[][] chessBoard = new int[queenNum][queenNum];
		
		// calling method to place 8 queens on chessboard
		placeQueens(chessBoard, queenNum);
		
		// displaying the finished chess board
		displayChessboard(chessBoard);
	}
	
	// method to place the 8 queens in the board
	private static void placeQueens(int[][] chessBoard, int queenNum) {
		for(int i = 0; i < chessBoard.length; i++) {
			chessBoard[i] = new int[queenNum];
			// if a queen cannot be placed because another queen can attack it, we start placing
			// queens again until we find the positions that work
			if(!placeQueenInRow(chessBoard, queenNum, i)) {
				i = -1;
			}		
		}
	}
	
	// method that places a queen in a row of the board only if it fits harmoniously with the other pieces
	// because it randomly places the queen, it checks up to 20 times if it cannot place it harmoniously
	// then it returns false meaning it could not place it
	private static boolean placeQueenInRow(int[][] chessBoard, int queenNum, int i) {
		boolean harmonious;
		int count = 0;
		
		do {
			int queenPlace = (int) (Math.random() * queenNum);
			chessBoard[i][queenPlace] = 1;
			harmonious = isHarmonious(chessBoard, i, queenPlace);
			
			if(!harmonious)
				chessBoard[i][queenPlace] = 0;
			
			count++;
		} while(!harmonious && count <= 20);
		
		return harmonious;
	}
	
	// displays the chessboard
	private static void displayChessboard(int[][] chessBoard) {
		for(int i = 0; i < chessBoard.length; i++) {
			for(int j = 0; j < chessBoard[i].length; j++) {
				if(j == 0) System.out.print("|");
				if(chessBoard[i][j] == 1) {
					System.out.print("Q|");
				} else {
					System.out.print(" |");
				}
				if(j == 7) System.out.println();
					
			}
		}		
	}

	// method checks to see if queen can go where it is right now
	// goes through each row and makes sure that queen cannot be attacked by another queen
	private static boolean isHarmonious(int[][] chessBoard, int rowIndex, int queenPlace) {
		for(int i = 0; i < chessBoard.length; i++) {
			int[] row = chessBoard[i];
			int nonPlacement1, nonPlacement2;
			
			nonPlacement1 = queenPlace + Math.abs(rowIndex - i);
			nonPlacement2 = queenPlace - Math.abs(rowIndex - i);
			
			if(rowIndex != i) {
				if(row[queenPlace] == 1) 
					return false;
				if(nonPlacement1 <= 7 && row[nonPlacement1] == 1)
					return false;
				if(nonPlacement2 >= 0 && row[nonPlacement2] == 1)
					return false;
			}
		}
		return true;
	}
}