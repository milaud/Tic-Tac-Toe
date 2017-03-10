import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SP_TicTacToe extends JFrame implements ActionListener {
	TTT_GamePlay game;
	int count;
	int input;
	Object[] options = { "New Game", "Quit" };
	JButton[] buttons;

	/**
	 * Constructor for Tic-Tac-Toe GUI.
	 */
	public SP_TicTacToe() {
		setName("Welcome to TicTacToe");
		this.game = new TTT_GamePlay();
		this.game.addPieces();
		this.count = 0;
		buttons = new JButton[9]; // array of buttons for cpu to select from

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 9; i++) {
			JButton b = new JButton();
			b.setBackground(Color.LIGHT_GRAY);
			p.add(b);
			b.setName(i + ""); // gives each button a number to be identified
								// with
			b.addActionListener(this);
			buttons[i] = b;
		}
		this.add(p);

		setVisible(true);
		setSize(600, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Action Listener for each clickable cell.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (game.getPlayer() == game.player1) {
			button.setBackground(Color.BLUE);
			game.markPiece(button);
			button.setEnabled(false);
		}

		nextTurn();
		if (count != 9)
			cpuClick();
	}

	/**
	 * Simulates a random cell selection by the computer.
	 */
	public void cpuClick() {
		if (!game.checkWin()) {
			int notTrue = 0;
			double randomDouble = Math.random() * game.selectedCells.length;
			int randomCellIndex = (int) randomDouble;
			do {
				randomDouble = Math.random() * game.selectedCells.length;
				randomCellIndex = (int) randomDouble;
			} while (game.selectedCells[randomCellIndex] == true);
			notTrue = randomCellIndex;

			JButton ran = buttons[notTrue];
			if (game.getPlayer() == game.player2) {
				if (ran.isEnabled() == true)
					ran.setBackground(Color.YELLOW);

				game.markPiece(ran);
				ran.setEnabled(false);
			}
			nextTurn();
		}
	}

	/**
	 * Switches from one player to the next, checks if there is a winner.
	 */
	public void nextTurn() {
		count++;
		if (count == 9 && !game.checkWin()) {
			input = JOptionPane.showOptionDialog(null, "It's a draw!", "Game Over!", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (input == JOptionPane.OK_OPTION) {
				this.dispose();
				Runner.main(null);
			} else
				System.exit(0);
		}
		if (!game.checkWin())
			game.switchPlayer();
		else {
			input = JOptionPane.showOptionDialog(null, "Player " + game.getPlayer() + " wins!", "Game Over!",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (input == JOptionPane.OK_OPTION) {
				this.dispose();
				Runner.main(null);
			} else
				System.exit(0);
		}
	}

}
