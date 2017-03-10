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

	public void errosBitParidade(Trama tramaRecebida) {
		ArrayList<Integer> tramaR = new ArrayList<Integer>();
		tramaR.add(tramaRecebida.getTrama().get(0));
		tramaR.add(tramaRecebida.getTrama().get(1));
		tramaR.add(tramaRecebida.getTrama().get(2));
		tramaR.add(tramaRecebida.getTrama().get(3));
		
			if (new Trama(tramaR).contador() % 2 == 0)
				if (tramaRecebida.getTrama().get(4) == 0) {
					tramaRecebida.setEstado(Estado.SEM_ERROS);
					System.out.println("Deteção bit paridade: Trama sem erro(s) detectados.");
				} else {
					tramaRecebida.setEstado(Estado.COM_ERROS);
					System.out.println("Deteção bit paridade: Trama com erro(s) detectados.");
				}
			else {
				if (tramaRecebida.getTrama().get(4) == 1) {
					tramaRecebida.setEstado(Estado.SEM_ERROS);
					System.out.println("Deteção bit paridade: Trama sem erro(s) detectados.");
				} else {
					tramaRecebida.setEstado(Estado.COM_ERROS);
					System.out.println("Deteção bit paridade: Trama com erro(s) detectados.");
				}
			}

		
	}

}
