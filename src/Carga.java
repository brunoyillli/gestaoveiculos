
public final class Carga extends Veiculo implements Calcular{
	
	int cargaMax;
	int tara;

	public int getCargaMax() {
		return cargaMax;
	}

	public final void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}

	public int getTara() {
		return tara;
	}
	
	public final void setTara(int tara) {
		this.tara = tara;
	}

	@Override
	public float calcVel(float velocMax) {
		float velocMaxCal = 0;
		velocMaxCal = velocMax * 100000;
		return velocMaxCal;
	}

	public Carga() {
		this.cargaMax = 0;
		this.tara = 0;
	}

	@Override
	public int calcular() {

		int somaNum = 0;
		
		somaNum += getMotor().getQtdPist();
		somaNum += getMotor().getPotencia();
		somaNum += getQtdRodas();
		somaNum += getVelocMax();
		somaNum += getTara();
		somaNum += getCargaMax();
		
		return somaNum;
	}
	
}
