import javax.swing.JOptionPane;

public class Runner {

	public static void main(String[] args) {
		Object[] options = { "1 Player", "2 Player", "Quit" };
		int input = JOptionPane.showOptionDialog(null, "Select game-mode", "Welcome to TicTacToe!", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if (input == JOptionPane.OK_OPTION) {
			new SP_TicTacToe();
		} else if (input == JOptionPane.NO_OPTION)
			new TP_TicTacToe();
		else System.exit(0);
		

	}

}
