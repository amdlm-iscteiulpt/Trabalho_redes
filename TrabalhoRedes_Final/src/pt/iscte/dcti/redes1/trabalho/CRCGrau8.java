package pt.iscte.dcti.redes1.trabalho;

import java.util.ArrayList;
import java.util.Arrays;

public class CRCGrau8 {

	private final ArrayList<Integer> polinGerador = new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0, 0,0,1,1,1));
	private final int grauPolinGerador = 8;
	private int vezes = 0;
	private ArrayList<Integer> dadosOriginal = new ArrayList<Integer>();
	
	
	public CRCGrau8(ArrayList<Integer> dados) {
		this.dadosOriginal = dados;
	}

	
	
	
	
//	public void arrayWithZeros(ArrayList<Integer> copiaDados) {
//		for (int i = 0; i < grauPolinGerador; i++) {
//			copiaDados.add(0);
//		}
//	}
//
//	public ArrayList<Integer> getResto(ArrayList<Integer> aux) {
//		ArrayList<Integer> aux5bits = get5bits(aux);
//		System.out.println("Resto" + get5bits(aux));
//		ArrayList<Integer> resto = new ArrayList<Integer>();
//
//		if (aux5bits.size() > 4) { // se get5bits = aux size = 4 se for = bits
//			// size = 5;
//			for (int i = 0; i < 5; i++) {
//				int m = xor(aux5bits.get(i), polinGerador.get(i));
//				resto.add(m);
//			}
//
//			return resto;
//		} else {
//			return aux5bits;
//		}
//	}
//
//	// (?)
//
//	public ArrayList<Integer> divisao(ArrayList<Integer> copiaDados) {
//		arrayWithZeros(copiaDados);
//		ArrayList<Integer> resto = getResto(copiaDados);
//		while (resto.size() > 4) {
//			for (int i = vezes + 5; i < copiaDados.size(); i++) {
//				resto.add(copiaDados.get(i));
//			}
//			ArrayList<Integer> aux = resto;
//			resto = getResto(aux);
//		}
//
//		return resto;
//
//	}
//
//	public ArrayList<Integer> tramaFCS() {
//		ArrayList<Integer> copiaDados = new ArrayList<Integer>();
//		igual(copiaDados, dadosOriginal);
//		ArrayList<Integer> aux = divisao(copiaDados);
//		System.out.println("DADOS ->" + dadosOriginal);
//		System.out.println("FCS ->" + aux);
//		for (int i = 0; i < aux.size(); i++) {
//			dadosOriginal.add(aux.get(i));
//		}
//
//		return dadosOriginal;
//	}
//
//	private void igual(ArrayList<Integer> copiaDados, ArrayList<Integer> dadosOriginal) {
//		for (int i = 0; i < dadosOriginal.size(); i++) {
//			copiaDados.add(dadosOriginal.get(i));
//		}
//	}
//
	private int xor(int i, int j) {
		if (i == j) {
			return 0;
		} else {
			return 1;
		}
	}
//
//	private ArrayList<Integer> get5bits(ArrayList<Integer> aux) {
//		ArrayList<Integer> bits = new ArrayList<Integer>();
//		while (aux.get(0) != 1) {
//			vezes++;
//			aux.remove(0);
//			if (aux.size() == grauPolinGerador) {
//				return aux;
//			}
//		}
//
//		if (aux.size() > grauPolinGerador) {
//			for (int i = 0; i < 5; i++) {
//				bits.add(aux.get(i));
//			}
//		}
//		return bits;
//
//	}

}
