import javax.swing.JOptionPane;

public class VeicExistException extends Exception{
	
	private static final long serialVersionUID = 1256706833070868349L;

	public VeicExistException() {
		JOptionPane.showMessageDialog(null, 
				"Já existe um veículo com esta placa", "Placa já cadastrada", JOptionPane.ERROR_MESSAGE);
	}
}
