import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		// setting variables needed
		// first player is cross
		String currentPlayer = "CROSS", state;
		int[][] board = new int[3][3];
		
		// intiating board with empty cells
		initBoard(board);
		// setting the current state of the game
		state = currentState(board);
		
		// looping through it as long as there is no winner and the game is not over
		while(state == "RUNNING") {
			displayBoard(board);
			//promting the current user for their move
			promptUserForMove(board, currentPlayer);
			//switching players
			currentPlayer = changePlayer(currentPlayer);
			// deciding if we should keep going
			state = currentState(board);
		}
		
		// displaying board one last time before showing the winner
		displayBoard(board);
		
		if(state == "CIRCLE_WINS") {
			System.out.print("O player has won!");
		} else if(state == "CROSS_WINS") {
			System.out.print("X player has won!");
		} else {
			System.out.print("It is a draw!");
		}
	}
	
	// prompting the current player for their move
	private static void promptUserForMove(int[][] board, String player) {
		// setting variables needed
		Scanner input = new Scanner(System.in);
		int col, row;
		
		System.out.print("Enter a row (0, 1, 2) for player " + player + ": ");
		row = input.nextInt();
		System.out.print("Enter a column (0, 1, 2) for player " + player + ": ");
		col = input.nextInt();
		
		setMove(board, player, row, col);
	}
	
	// setting move on board
	private static void setMove(int[][] board, String player, int row, int col) {
		if(board[row][col] != 0) {
			System.out.println("That cell has already been played! Try again!");
			promptUserForMove(board, player);
		} else {
			board[row][col] = player == "CROSS" ? -1 : 1;
		}
	}

	// displaying the board where a 1 represent a circle, a -1 represent a cross and a 0 represents an empty cell
	private static void displayBoard(int[][] board) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(j == 0) System.out.print("| ");
				if(board[i][j] == 0) {
					System.out.print("  | ");
				} else if(board[i][j] == 1) {
					System.out.print("O | ");
				} else {
					System.out.print("X | ");
				}
				if(j == 2) {
					System.out.println();
					System.out.println("-------------");
				}			
			}
		}
	}
	
	// initializing board with empty cells
	public static void initBoard(int[][] board) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				// 0 is empty, -1 is cross, and 1 is circle
				// initializing everything as empty
	            board[row][col] = 0;
	         }
	      }
	}
	
	// calculating current state
	public static String currentState(int[][] board) {
		String state = "RUNNING";
		//check columns
		state = checkForColumnWin(board, state);
		
		// check rows
		state = checkForRowWin(board, state);
		
		// check diagonals
		state = checkForDiagonalWin(board, state);
		
		// check for draw
		state = checkForDraw(board, state);
		
		return state;
	}
	
	private static String checkForDraw(int[][] board, String state) {
		boolean gameOver = true;
		
		// if there is no empty cells left then is game over and might be a draw
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[i][j] == 0) {
					gameOver = false;
					break;
				}
			}
		}
		
		if(gameOver == true && state == "RUNNING") {
			state = "DRAW";
		}
		
		return state;
	}

	private static String checkForDiagonalWin(int[][] board, String state) {
		// checking diagonals for a win
		if(state == "RUNNING") {
			if(board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
				state = board[0][0] == 1 ? "CIRCLE_WINS" : "CROSS_WINS";
			} else if(board[2][0] != 0 && board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
				state = board[2][0] == 1 ? "CIRCLE_WINS" : "CROSS_WINS";
			}
		}
		
		return state;
	}

	private static String checkForRowWin(int[][] board, String state) {
		// checking rows for a win
		if(state == "RUNNING") {
			for(int i = 0; i < 3; i++) {
				if(board[i][0] != 0 && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
					state = board[i][0] == 1 ? "CIRCLE_WINS" : "CROSS_WINS";
					break;
				}
			}
		}
		
		return state;
	}

	private static String checkForColumnWin(int[][] board, String state) {
		// checking columns for a win
		if(state == "RUNNING") {
			for(int i = 0; i < 3; i++) {
				if(board[0][i] != 0 && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
					state = board[0][i] == 1 ? "CIRCLE_WINS" : "CROSS_WINS";
					break;
				}
			}
		}
		
		return state;
	}
	
	// changing player after every move
	public static String changePlayer(String player) {
		player = player == "CROSS" ? "CIRCLE" : "CROSS"; 
		return player;
	}
}