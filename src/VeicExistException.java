import javax.swing.JOptionPane;

public class VeicExistException extends Exception{
	
	private static final long serialVersionUID = 1256706833070868349L;

	public VeicExistException() {
		JOptionPane.showMessageDialog(null, 
				"J� existe um ve�culo com esta placa", "Placa j� cadastrada", JOptionPane.ERROR_MESSAGE);
	}
}
