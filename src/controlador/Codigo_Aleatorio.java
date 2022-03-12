package controlador;

import java.util.Random;
import java.util.UUID;

public class Codigo_Aleatorio {

	public static String codigo_alfanumerico_numero() {
		/**/
		Random aleatorio = new Random();

		String claveAleatoria = UUID.randomUUID().toString().toUpperCase().substring(0, 8)
				+ UUID.randomUUID().toString().toUpperCase().substring(0, 2);

		int digito = aleatorio.nextInt(10);

		String clave = claveAleatoria + "-" + digito;

		return clave;
	}

	public static String codigo_alfanumerico_caracter() {
		Random aleatorio1 = new Random();
		char letra = (char) (aleatorio1.nextInt(26) + 'a');

		String claveAleatoria = UUID.randomUUID().toString().toUpperCase().substring(0, 8)
				+ UUID.randomUUID().toString().toUpperCase().substring(0, 2);

		String clave = claveAleatoria + "-" + letra;

		return clave.toUpperCase();
	}

}
