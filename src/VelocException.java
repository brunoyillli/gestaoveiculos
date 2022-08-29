import javax.swing.JOptionPane;

public class VelocException extends Exception {

	private static final long serialVersionUID = 825286265287881545L;
	
	public VelocException() {
		JOptionPane.showMessageDialog(null, "A velocidade máxima está fora dos limites brasileiros",
				"Velocidade invlida", JOptionPane.ERROR_MESSAGE);
	}
}
