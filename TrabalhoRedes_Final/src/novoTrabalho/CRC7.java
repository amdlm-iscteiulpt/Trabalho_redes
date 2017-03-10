package novoTrabalho;

import java.util.ArrayList;

public class CRC7 {

	private ArrayList<Integer> trama_recebida = new ArrayList<Integer>();

	private int C0 = 0;
	private int C1 = 0;
	private int C2 = 0;

	private int C0_anterior = 0;
	private int C1_anterior = 0;
	private int C2_anterior = 0;

	public void crc() {
		C2_anterior = trama_recebida.get(0);
		C1_anterior = trama_recebida.get(1);
		C0_anterior = trama_recebida.get(2);

		for (int i = 3; i < trama_recebida.size(); i++) {
			C0 = xor(trama_recebida.get(i), C2_anterior);
			C1 = xor(C0_anterior, C2_anterior);
			C2 = C1_anterior;

			C2_anterior = C2;
			C1_anterior = C1;
			C0_anterior = C0;

		}
	}

	private int xor(int i, int j) {
		if (i != j) {
			return 1;
		} else {
			return 0;
		}
	}

	private void setRecebida(Trama dados) {
		ArrayList<Integer> arrayDados = dados.getTrama();
		for (int i = 0; i < arrayDados.size(); i++) {
			trama_recebida.add(arrayDados.get(i));
		}
		trama_recebida.add(0);
		trama_recebida.add(0);
		trama_recebida.add(0);
		
	
	}
	
	public void tramaErrada(Trama recebida) {
		ArrayList<Integer> arrayRecebida = recebida.getTrama();
		trama_recebida.clear();
		for (Integer i : arrayRecebida) {
			trama_recebida.add(i);
		}	
		crc();

		if (C2 == 0 && C1 == 0 && C0 == 0) {
			recebida.setEstado(Estado.SEM_ERROS);
			System.out.println("Deteção CRC 7 bits: Trama sem erro(s) detectados.");
		} else {
			recebida.setEstado(Estado.COM_ERROS);
			System.out.println("Deteção CRC 7 bits: Trama com erro(s) detectados.");
		}
	}

	public Trama getTransmitida(Trama dados) {
		setRecebida(dados);
		crc();
		ArrayList<Integer> transmitida = dados.getTrama();
		transmitida.add(C2);
		transmitida.add(C1);
		transmitida.add(C0);

		Trama tramaTransmitida = new Trama(transmitida);

		return tramaTransmitida;

	}

}
