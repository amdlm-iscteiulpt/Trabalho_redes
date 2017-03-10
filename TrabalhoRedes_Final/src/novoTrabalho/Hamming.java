package novoTrabalho;

import java.util.ArrayList;

public class Hamming {

	private ArrayList<Integer> listaP4 = new ArrayList<Integer>();
	private ArrayList<Integer> listaP2 = new ArrayList<Integer>();
	private ArrayList<Integer> listaP1 = new ArrayList<Integer>();
	private int p1;
	private int p2;
	private int p4;
	private int posicao;

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
		ArrayList<Integer >listaDados = dados.getTrama();
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
		addMatriz();
		ArrayList<Integer>listaDados = dados.getTrama();
		p1 = calculoP_C(listaP1, dados);
		p2 = calculoP_C(listaP2, dados);
		p4 = calculoP_C(listaP4, dados);

		Trama tramaTransmitida = new Trama(
				"" + p1 + p2 + listaDados.get(0) + p4 + listaDados.get(1) + listaDados.get(2) + listaDados.get(3));

		return tramaTransmitida;
	}

	public boolean errosHamming(Trama tramaRecebida, Trama padraoErros) {
		
		ArrayList<Integer>listaRecebida= tramaRecebida.getTrama();
		
		Trama tramaX= new Trama(""+listaRecebida.get(2)+listaRecebida.get(4)+listaRecebida.get(5)+listaRecebida.get(6));
		
		int c1 = xor(listaRecebida.get(0), calculoP_C(listaP1, tramaX));
		int c2 = xor(listaRecebida.get(1), calculoP_C(listaP2, tramaX));
		int c4 = xor(listaRecebida.get(3), calculoP_C(listaP4, tramaX));
		
		String bin = "" + c4 + c2 + c1;
		posicao = Integer.parseInt(bin, 2);
		
		int c=0;
		for(int i=0 ; i<padraoErros.getTrama().size();i++){
			if(padraoErros.getTrama().get(i)==1){
				c++;
			}
			
		}
	
		if (posicao != 0 && c==1) {	
			return true;
		} else {
			return false;
		}

	}
	
	public int getPosicao(){
		return posicao;
	}

}
