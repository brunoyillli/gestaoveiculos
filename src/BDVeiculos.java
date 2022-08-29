import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {
	
	private List<Passeio> listaPasseio = new ArrayList<Passeio>();
	
	private List<Carga> listaCarga = new ArrayList<Carga>(); 

	public BDVeiculos() {
	}
	
	public List<Passeio> getListaPasseio() {
		return listaPasseio;
	}

	public void setListaPasseio(List<Passeio> listaPasseio) {
		this.listaPasseio = listaPasseio;
	}

	public List<Carga> getListaCarga() {
		return listaCarga;
	}

	public void setListaCarga(List<Carga> listaCarga) {
		this.listaCarga = listaCarga;
	}

}
