
public class Motor {
	
	private int qtdPist;
	private int potencia;
	
	public int getQtdPist() {
		return qtdPist;
	}
	public final void setQtdPist(int qtdPist) {
		this.qtdPist = qtdPist;
	}
	public int getPotencia() {
		return potencia;
	}
	public final void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	public Motor() {
		this.qtdPist = 0;
		this.potencia = 0;
	}

}
