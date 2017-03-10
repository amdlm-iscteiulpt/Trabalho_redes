package novoTrabalho;

import java.util.ArrayList;

public class BitParidade {

	
	public Trama calculoBitParidade(Trama t) {
		int contador = t.contador();
		ArrayList<Integer> tramaRecebida = t.getTrama();
		if (contador % 2 == 0) {
			tramaRecebida.add(0);

		} else {
			tramaRecebida.add(1);

		}
		return new Trama(tramaRecebida);
	
	}
	
	public boolean errosBitParidade(Trama tramaRecebida){
		if (tramaRecebida.contador() % 2 ==0){
			return false;
		}
		else{
			return true;
		}
		
	}


}
