package novoTrabalho;

import java.util.ArrayList;

public class BitParidade {

	public int calculoParidadePar(Trama t) {
		ArrayList<Integer> lista = t.getListaTrama();
		int c = 0;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) == 1) {
				c++;
			}
		}
		return c;

	}

	public ArrayList<Integer> calculoBitParidade(Trama t) {
		int contador = calculoParidadePar(t);
		ArrayList<Integer> tramaRecebida = t.getListaTrama();
		if (contador % 2 == 0) {
			tramaRecebida.add(0);

		} else {
			tramaRecebida.add(0);

		}
		return tramaRecebida;
	}
}
