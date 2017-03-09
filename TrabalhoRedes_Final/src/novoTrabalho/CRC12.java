package novoTrabalho;

import java.util.ArrayList;

public class CRC12 {
	//l
	private ArrayList<Integer> trama_recebida = new ArrayList<Integer>();

	private int C0 = 0;
	private int C1 = 0;
	private int C2 = 0;
	private int C3 = 0;
	private int C4 = 0;
	private int C5 = 0;
	private int C6 = 0;
	private int C7 = 0;
	

	private int C0_anterior = 0;
	private int C1_anterior = 0;
	private int C2_anterior = 0;
	private int C3_anterior = 0;
	private int C4_anterior = 0;
	private int C5_anterior = 0;
	private int C6_anterior = 0;
	private int C7_anterior = 0;

	public void crc() {
		C7_anterior = trama_recebida.get(0);
		C6_anterior = trama_recebida.get(1);
		C5_anterior = trama_recebida.get(2);
		C4_anterior = trama_recebida.get(3);
		C3_anterior = trama_recebida.get(4);
		C2_anterior = trama_recebida.get(5);
		C1_anterior = trama_recebida.get(6);
		C0_anterior = trama_recebida.get(7);
		
		for (int i = 8; i < trama_recebida.size(); i++) {
			C0 = xor(trama_recebida.get(i), C7_anterior);
			C1 = xor(C0_anterior, C7_anterior);
			C2 = xor(C1_anterior, C7_anterior);
			C3 =C2_anterior;
			C4 =C3_anterior;
			C5 =C4_anterior;
			C6 =C5_anterior;
			C7 =C6_anterior;
			
			C7_anterior = C7;
			C6_anterior = C6;
			C5_anterior = C5;
			C4_anterior = C4;
			C3_anterior = C3;
			C2_anterior = C2;
			C1_anterior = C1;
			C0_anterior = C0;
			
		}
	}
	
	
	private int xor(int i, int j){
		if(i!=j){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	private void setRecebida(Trama dados) {
		ArrayList<Integer> arrayDados = dados.getTrama();
		for (int i = 0; i < arrayDados.size(); i++) {
			trama_recebida.add(arrayDados.get(i));
		}
		for (int i = 0; i < 8; i++) {
			trama_recebida.add(0);
		}
	
	}
	
	public Trama getTransmitida(Trama dados) {
		setRecebida(dados);
		crc();
		ArrayList<Integer> transmitida = dados.getTrama();
		transmitida.add(C7);
		transmitida.add(C6);
		transmitida.add(C5);
		transmitida.add(C4);
		transmitida.add(C3);
		transmitida.add(C2);
		transmitida.add(C1);
		transmitida.add(C0);
		
		Trama tramaTransmitida = new Trama (transmitida);
		return tramaTransmitida;	
	}
	
	public boolean tramaErrada(Trama recebida) {
		ArrayList<Integer> arrayRecebida = recebida.getTrama();
		trama_recebida.clear();
		for (Integer i : arrayRecebida) {
			trama_recebida.add(i);
		}	
		crc();
		
		if(C7 == 0&& C6 == 0 && C5 == 0 && C4 == 0 && C3 == 0 && C2 == 0 && C1 == 0 && C0 == 0){
			return false;
		}
		else{
			return true;
		}
	}
	
	public static void main(String[] args) {
		CRC12 a = new CRC12();
		a.crc();
	}


}
