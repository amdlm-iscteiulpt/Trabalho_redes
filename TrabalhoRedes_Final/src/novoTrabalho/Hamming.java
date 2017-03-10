package novoTrabalho;

import java.util.ArrayList;

public class Hamming {

	private int posicao;

	public int xor(int a, int b) {
		if (a == b) {
			return 0;
		}
		return 1;
	}

	public Trama calculoTramaTransmitida(Trama dados) {
		ArrayList<Integer> listaDados = dados.getTrama();
		int p1 = xor(xor(listaDados.get(0), listaDados.get(1)), listaDados.get(3));
		int p2 = xor(xor(listaDados.get(0), listaDados.get(2)), listaDados.get(3));
		int p4 = xor(xor(listaDados.get(1), listaDados.get(2)), listaDados.get(3));
		Trama tramaTransmitida = new Trama(
				"" + p1 + p2 + listaDados.get(0) + p4 + listaDados.get(1) + listaDados.get(2) + listaDados.get(3));
		return tramaTransmitida;
	}

	public void errosHamming(Trama tramaRecebida) {

		ArrayList<Integer> listaRecebida = tramaRecebida.getTrama();
		System.out.println(tramaRecebida);
		int c1 = xor(xor(xor(listaRecebida.get(0), listaRecebida.get(2)), listaRecebida.get(4)), listaRecebida.get(6));
		int c2 = xor(xor(xor(listaRecebida.get(1), listaRecebida.get(2)), listaRecebida.get(5)), listaRecebida.get(6));
		int c4 = xor(xor(xor(listaRecebida.get(3), listaRecebida.get(4)), listaRecebida.get(5)), listaRecebida.get(6));

		String bin = "" + c4 + c2 + c1;
		posicao = Integer.parseInt(bin, 2);

		if (posicao != 0) {
			tramaRecebida.setEstado(Estado.COM_ERROS);
			System.out.println("Deteção Hamming: Trama com erro(s) detectados.");
		} else {
			tramaRecebida.setEstado(Estado.SEM_ERROS);
			System.out.println("Deteção Hamming: Trama sem erro(s) detectados.");
		}

	}

	public Trama tramaCorrigida(int posicao, Trama recebida) {

		if (recebida.getTrama().get(posicao - 1) == 0) {
			recebida.getTrama().set(posicao - 1, 1);
		} else {
			recebida.getTrama().set(posicao - 1, 0);
		}

		return recebida;
	}

	public int getPosicao() {
		return posicao;
	}

}