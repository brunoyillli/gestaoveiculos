
public final class Passeio extends Veiculo implements Calcular{
	
	int qtdPassageiros;
	
	public int getQtdPassageiros() {
		return qtdPassageiros;
	}

	public final void setQtdPassageiros(int qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
	}

	@Override
	public float calcVel(float velocMax) {
		float velocMaxConv = 0;
		velocMaxConv = velocMax * 1000;
		return velocMaxConv;
	}

	public Passeio() {
		this.qtdPassageiros = 0;
	}

	@Override
	public int calcular() {
		int somaLetras = 0;
		
		somaLetras += getPlaca().length();
		somaLetras += getMarca().length();
		somaLetras += getModelo().length();
		somaLetras += getCor().length();
		
		return somaLetras;
	}

}
