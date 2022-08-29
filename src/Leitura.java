import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {
	public String entDados(String rotulo) {
		
		System.out.println(rotulo);
		
		InputStreamReader tec = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(tec);

		String texto = "";
		
		try {
			texto = buff.readLine();
		} catch (IOException ioe) {
			System.out.println("\n Erro no sistema");
		}
		
		return texto;
	}
}
