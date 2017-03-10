package novoTrabalho;

import java.util.ArrayList;

public class CanalRuidoso {

	public final double[] pErroBit = { 0.000001, 0.00001, 0.0001, 0.001, 0.01, 0.1, 0.125, 0.25, 0.5 };
	private Trama tramaPadraoErro;

	public Trama getRecebida(Trama tramaTransmitida, Trama tramaPadraoErro) {
		this.tramaPadraoErro = tramaPadraoErro;

		ArrayList<Integer> recebida = new ArrayList<Integer>();

		for (int i = 0; i < tramaTransmitida.getTrama().size(); i++) {
			int x = xor(tramaTransmitida.getTrama().get(i), tramaPadraoErro.getTrama().get(i));
			recebida.add(x);
		}

		Trama tramaRecebida = new Trama(recebida);
		return tramaRecebida;

	}

	public Trama gerarTramasErros(int opcao) {

		int tamanho;
		switch (opcao) {
		case 1:
			tamanho = 5;
			break;

		case 4:
			tamanho = 12;
			break;

		default:
			tamanho = 7;
			break;
		}

		for (int y = 0; y < pErroBit.length; y++) {
			tramaPadraoErro = (tramaErros(tamanho, pErroBit[y]));
			//System.out.println("Trama de Erros Gerada E: " + tramaPadraoErro);
		}
		return tramaPadraoErro;

	}

	public Trama tramaErros(int tamanho, double Pbit) {
		Trama trama = new Trama(tamanho);
		for (int i = 0; i < tamanho; i++) {
			
			trama.add(randomBit(Pbit));
		}

		return trama;
	}

	public int randomBit(double Pb) {
		double r = Math.random();
		if (r > Pb) {
			return 1;
		}
		return 0;
	}

	public int xor(int v1, int v2) {
		if (v1 == v2) {
			return 0;
		} else {
			return 1;
		}
	}

}