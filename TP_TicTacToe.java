import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TP_TicTacToe extends JFrame implements ActionListener {
	TTT_GamePlay game;
	int count;
	int input;
	Object[] options = { "New Game", "Quit" };

	/**
	 * Constructor for Tic-Tac-Toe GUI.
	 */
	public TP_TicTacToe() {
		setName("Welcome to TicTacToe");
		this.game = new TTT_GamePlay();
		this.game.addPieces();
		this.count = 0;

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 9; i++) {
			JButton b = new JButton();
			b.setBackground(Color.LIGHT_GRAY);
			p.add(b);
			b.setName(i + "");
			b.addActionListener(this);
		}
		this.add(p);

		setVisible(true);
		setSize(600, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Action Listener for each selectable cell.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (game.getPlayer() == game.player1) {
			button.setBackground(Color.BLUE);
		} else if (game.getPlayer() == game.player2) {
			button.setBackground(Color.YELLOW);
		}
		game.markPiece(button);
		button.setEnabled(false);
		
		nextTurn();
	}
	
	/**
	 * Checks if the game has been won following every move.
	 */
	public void nextTurn() {
		count++;
		if (!game.checkWin())
			game.switchPlayer();
		else {
			if (count == 9) {
				input = JOptionPane.showOptionDialog(null, "It's a draw!", "Game Over!", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			} else
				input = JOptionPane.showOptionDialog(null, "Player " + game.getPlayer() + " wins!", "Game Over!",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			if (input == JOptionPane.OK_OPTION) {
				this.dispose();
				Runner.main(null);;
			} else
				System.exit(0);
		}
	}
}