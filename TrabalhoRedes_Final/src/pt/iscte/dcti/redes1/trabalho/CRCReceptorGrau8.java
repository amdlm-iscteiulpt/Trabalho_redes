//package pt.iscte.dcti.redes1.trabalho;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class CRCReceptorGrau8 {
//	private final ArrayList<Integer> polinGerador = new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0, 1));
//	private final int grauPolinGerador = 4;
//	private int vezes = 0;
//	private ArrayList<Integer> dadosOriginal = new ArrayList<Integer>();
//
////	public CRCReceptorGrau8(Trama dados) {
////		this.dadosOriginal = dados;
////	}
////
////	public void arrayWithZeros(ArrayList<Integer> aux) {
////		// ArrayList<Integer> dadosAux = dados;
////		for (int i = 0; i < grauPolinGerador; i++) {
////			aux.add(0);
////		}
////		// return dadosAux;
////	}
//
//	public ArrayList<Integer> getResto(ArrayList<Integer> aux) {
//		ArrayList<Integer> aux5bits = get5bits(aux);
//		ArrayList<Integer> resto = new ArrayList<Integer>();
//		if (!aux5bits.equals(polinGerador)) {
//			if (aux5bits.size() > 4) { // se get5bits = aux size = 4 se for =
//										// bits
//										// size = 5;
//				for (int i = 0; i < 5; i++) {
//					int m = xor(aux5bits.get(i), polinGerador.get(i));
//					resto.add(m);
//				}
//
//				return resto;
//			} else {
//				return aux5bits;
//			}
//
//		}
//		return new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
//
//	}
//
//	// (?)
//
//	public ArrayList<Integer> divisao(ArrayList<Integer> copiaDados) {
//		ArrayList<Integer> resto = getResto(copiaDados);
//		while (resto.size() > 4) {
//			for (int i = vezes + 5; i < dadosOriginal.size(); i++) {
//				resto.add(dadosOriginal.get(i));
//			}
//			ArrayList<Integer> aux = resto;
//			if (aux.contains(1)) {
//				resto = getResto(aux);
//			} else {
//				return resto;
//			}
//
//		}
//
//		return resto;
//
//	}

//	public ArrayList<Integer> tramaFCSEmissor() {
//		ArrayList<Integer> copiaDados = new ArrayList<Integer>();
//		igual(copiaDados, dadosOriginal);
////		arrayWithZeros(copiaDados);
////		ArrayList<Integer> aux = divisao(copiaDados);
//
//
//		ArrayList<Integer> aux2;
//		if (aux.contains(1)) {
//			aux2 = new ArrayList<Integer>();
//			int i = aux.size();
//			while (i < 4) {
//				aux2.add(0);
//				i++;
//			}
//			for (int t = 0; t < aux.size(); t++) {
//				aux2.add(aux.get(t));
//			}
//		} else {
//			aux2 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0));
//		}
//
//		for (int t = 0; t < aux2.size(); t++) {
//			dadosOriginal.add(aux2.get(t));
//		}
//		return dadosOriginal;
//	}
//
//	public ArrayList<Integer> tramaFCS() {
//		ArrayList<Integer> copiaDados = new ArrayList<Integer>();
//		igual(copiaDados, dadosOriginal);
//		ArrayList<Integer> aux = divisao(copiaDados);
//		if(!aux.contains(1)){
//			aux = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0));
//		}
//		System.out.println("Erros -> " + aux);
//		return aux;
//
//	}
//
//	private void igual(ArrayList<Integer> copiaDados, ArrayList<Integer> dadosOriginal) {
//		for (int i = 0; i < dadosOriginal.size(); i++) {
//			copiaDados.add(dadosOriginal.get(i));
//		}
//	}
//
//	private int xor(int i, int j) {
//		if (i == j) {
//			return 0;
//		} else {
//			return 1;
//		}
//	}
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
//
//}
