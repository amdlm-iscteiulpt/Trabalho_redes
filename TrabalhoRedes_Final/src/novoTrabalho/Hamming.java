package novoTrabalho;

import java.util.ArrayList;

public class Hamming {

	private ArrayList<Integer> listaP4 = new ArrayList<Integer>();
	private ArrayList<Integer> listaP2 = new ArrayList<Integer>();
	private ArrayList<Integer> listaP1 = new ArrayList<Integer>();
	private ArrayList<Integer> listaDados;
	private int p1;
	private int p2;
	private int p4;

	public void addMatriz() {
		int[][] matriz = { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 1 } };

		for (int i = 0; i < 4; i++) {
			if (matriz[i][0] == 1) {
				listaP4.add(i);
			}
			if (matriz[i][1] == 1) {
				listaP2.add(i);
			}
			if (matriz[i][2] == 1) {
				listaP1.add(i);
			}

		}

	}

	public int calculoP_C(ArrayList<Integer> p, Trama dados) {
		addMatriz();
		ArrayList<Integer> listaDados = dados.getTrama();
		ArrayList<Integer> lista = new ArrayList<>();
		int c = 0;
		for (int i = 0; i < p.size(); i++) {
			lista.add(listaDados.get(p.get(i)));
		}

		for (int i = 0; i < lista.size(); i++) {
			c = xor(c, lista.get(i));
		}
		return c;

	}

	public int xor(int a, int b) {
		if (a == b) {
			return 0;
		}
		return 1;

	}

	public Trama calculoHamming(Trama dados) {
		listaDados = dados.getTrama();
		p1 = calculoP_C(listaP1, dados);
		p2 = calculoP_C(listaP2, dados);
		p4 = calculoP_C(listaP4, dados);

		Trama tramaTransmitida = new Trama(
				"" + p1 + p2 + listaDados.get(0) + p4 + listaDados.get(1) + listaDados.get(2) + listaDados.get(3));

		return tramaTransmitida;
	}

	public boolean errosHamming(Trama tramaRecebida) {

		int c1 = xor(p1, calculoP_C(listaP1, tramaRecebida));
		int c2 = xor(p2, calculoP_C(listaP2, tramaRecebida));
		int c4 = xor(p4, calculoP_C(listaP4, tramaRecebida));

		String bin = "" + c4 + c2 + c1;
		int posicao = Integer.parseInt(bin, 2);

		if (posicao != 0) {
			System.out.println("Resultado: Existe um erro na Posicao " + posicao + ".");
			return true;
		} else {
			System.out.println("Resultado: Não existem Erros.");
			return false;
		}

	}

}
