package novoTrabalho;

import java.util.ArrayList;

public class BitParidade {

	public int calculoParidadePar(Trama t) {
		ArrayList<Integer> lista = t.getTrama();
		int c = 0;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) == 1) {
				c++;
			}
		}
		return c;

	}

	public Trama calculoBitParidade(Trama t) {
		int contador = calculoParidadePar(t);
		ArrayList<Integer> tramaRecebida = t.getTrama();
		if (contador % 2 == 0) {
			tramaRecebida.add(0);

		} else {
			tramaRecebida.add(1);

		}
		Trama tramaT = new Trama(tramaRecebida);
		return tramaT;
	}
	
	public boolean errosBitParidade(Trama tramaRecebida){
		if (calculoParidadePar(tramaRecebida) % 2 ==0){
			return false;
		}
		else{
			return true;
		}
		
	}

	
	
	//utilizar para todas
//	public boolean temErros(Trama tramaRecebida,Trama tramaTransmitida){
//		ArrayList<Integer>listaTramaRecebida=tramaRecebida.getTrama();
//		ArrayList<Integer>listaTramaTransmitida=tramaTransmitida.getTrama();
//		for (int i = 0; i < listaTramaRecebida.size(); i++) {
//			if(listaTramaRecebida.get(i)!=listaTramaTransmitida.get(i)){
//				System.out.println("trama com erros");
//				return false;
//				
//			}
//		
//		}
//		System.out.println("trama sem erros");
//		return true;
//	
//		
//		
//	}
}
