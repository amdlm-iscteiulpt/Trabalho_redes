package novoTrabalho;

import java.util.ArrayList;

public class CanalRuidoso {

	public Trama getRecebida(Trama tramaTransmitida, Trama tramaPadraoErro) {
		ArrayList<Integer> transmitida = tramaTransmitida.getTrama();
		ArrayList<Integer> padrao = tramaPadraoErro.getTrama();
		ArrayList<Integer> recebida = new ArrayList<Integer>();

		for (int i = 0; i < transmitida.size(); i++) {
			int x = xor(transmitida.get(i), padrao.get(i));
			recebida.add(x);

		}

		Trama tramaRecebida = new Trama(recebida);
		System.out.println("recebida" + tramaRecebida.toString());
		return tramaRecebida;

	}

	public int xor(int v1, int v2) {
		if (v1 == v2) {
			return 0;
		} else {
			return 1;
		}
	}

}
