import java.util.*;
import javax.swing.*;

public class TTT_GamePlay {
	int p1[] = new int[9]; //array for the total cell values of player 1
	int p2[] = new int[9]; //array for the total cell values of player 2
	boolean selectedCells[] = new boolean[9]; //array to check if a button has been clicked
	int[] board;		   //array to hold data for each cell
	boolean win;		   //win condition
	final int player1 = 1; // BLUE
	final int player2 = 2; // YELLOW
	int player;			   //the current player

	/**
	 * Constructor for Tic-Tac-Toe
	 */
	public TTT_GamePlay() {
		Arrays.fill(p1, 0);
		Arrays.fill(p2, 0);
		Arrays.fill(selectedCells, false);
		this.board = new int[9];
		this.player = player1;
		win = false;
	}

	/**
	 * Adds values for each piece, a win means 3 added cells across, diagonal, or up/down is
	 * equal to 15. Board values come from:
	 * http://mathworld.wolfram.com/MagicSquare.html
	 */
	public void addPieces() {
		board[0] = 8;
		board[1] = 1;
		board[2] = 6;
		board[3] = 3;
		board[4] = 5;
		board[5] = 7;
		board[6] = 4;
		board[7] = 9;
		board[8] = 2;
	}

	/**
	 * When a button is selected, put the selected value into the players array
	 * to check if they had won.
	 * 
	 * @param b
	 *            the cell the player selected
	 */
	public void markPiece(JButton b) {
		if (getPlayer() == player1) {
			p1[Integer.parseInt(b.getName())] = board[Integer.parseInt(b.getName())];
		} else if (getPlayer() == player2) {
			p2[Integer.parseInt(b.getName())] = board[Integer.parseInt(b.getName())];
		}
		selectedCells[Integer.parseInt(b.getName())] = true;

	}

	/**
	 * Return the player who's turn it is.
	 * 
	 * @return the current player
	 */
	public int getPlayer() {
		return player;
	}

	/**
	 * Switch from player 1 (Blue) to player 2 (Yellow).
	 */
	public void switchPlayer() {
		if (player == player1) {
			player = player2;
		} else {
			player = player1;
		}
	}

	/**
	 * If a sequence of 3 diagonal, across, or up/down cells add up to 15, that
	 * player wins.
	 */
	public boolean checkWin() {
		if (checkAcross() || checkDiagonal() || checkUpDown()) {
			//win = true;
			return true;
		}
		return false;
	}

	/**
	 * Check if a player has 3 consecutive cells from left to right
	 * @return true if a player has 3 consecutive cells across
	 */
	public boolean checkAcross() {
		if (p1[0] + p1[1] + p1[2] == 15)
			return true;
		else if (p1[3] + p1[4] + p1[5] == 15)
			return true;
		else if (p1[6] + p1[7] + p1[8] == 15)
			return true;
		else if (p2[0] + p2[1] + p2[2] == 15)
			return true;
		else if (p2[3] + p2[4] + p2[5] == 15)
			return true;
		else if (p2[6] + p2[7] + p2[8] == 15)
			return true;

		return false;
	}

	/**
	 * Check if a player has 3 consecutive cells up to down.
	 * @return true if a player has 3 consecutive cells up to down
	 */
	public boolean checkUpDown() {
		if (p1[0] + p1[3] + p1[6] == 15)
			return true;
		else if (p1[1] + p1[4] + p1[7] == 15)
			return true;
		else if (p1[2] + p1[5] + p1[8] == 15)
			return true;
		else if (p2[0] + p2[3] + p2[6] == 15)
			return true;
		else if (p2[1] + p2[4] + p2[7] == 15)
			return true;
		else if (p2[2] + p2[5] + p2[8] == 15)
			return true;

		return false;
	}

	/**
	 * Check if a player has 3 consecutive cells going diagonal.
	 * @return true if a player has 3 consecutive diagonal cells
	 */
	public boolean checkDiagonal() {
		if (p1[0] + p1[4] + p1[8] == 15)
			return true;
		else if (p1[2] + p1[4] + p1[6] == 15)
			return true;
		else if (p2[0] + p2[4] + p2[8] == 15)
			return true;
		else if (p2[2] + p2[4] + p2[6] == 15)
			return true;
		return false;
	}

}