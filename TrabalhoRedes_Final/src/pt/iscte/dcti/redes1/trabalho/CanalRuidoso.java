package pt.iscte.dcti.redes1.trabalho;

import java.util.ArrayList;

public class CanalRuidoso {
	
	private Receptor receptor;
	private Trama tramaTransmitida;
	private Trama erroPadrao;
	private Trama tramaRecebida;
	private int opcao;
	
	public CanalRuidoso(Receptor receptor){
		this.receptor = receptor;
	}
	
	private int xor(int i, int j) {
		if (i == j) {
			return 0;
		} else {
			return 1;
		}
	}
	public void gerarTramasErros(int opcao, double Pbit) {
		this.opcao=opcao;
		int tamanho;
		switch(opcao){
		case 1:
			tamanho=12;
			break;
		
		default:
			tamanho=7;
			break;
		}
		
		int i = 0;
		while (i < 1) {
			erroPadrao = (tramaErros(tamanho, Pbit));
			i++;
		}
	}

	public Trama tramaErros(int tamanho, double Pbit) {
		Trama trama = new Trama(tamanho);
		for (int i = 0; i < tamanho; i++) {
			trama.add(randomBit(Pbit));

		}
		System.out.println("Trama de Erros Gerada E: " + trama);
		this.tramaRecebida = trama;
		return trama;
	}
	
	public int randomBit(double random) {
		double r = Math.random();
		if (r > random) {
			return 0;
		}
		return 1;
	}
	
	public void gerarTramaRecebida(){
		ArrayList<Integer> bits = new ArrayList<Integer>();
		for( int i = 0; i<tramaTransmitida.getTrama().size();i++){
			int x = xor(tramaTransmitida.getTrama().get(i), erroPadrao.getTrama().get(i));
			bits.add(x);
		}
		tramaRecebida = new Trama(bits);	
	}
	
	public void sendTramaRecebida(){
		if(opcao==2){
			this.receptor.setTramaRecebida(tramaRecebida);
		}
		else{
			gerarTramaRecebida();
			this.receptor.setTramaRecebida(tramaRecebida);
		}
		
	}

	public void setTramaTransmitida(Trama transmitida) {	
		this.tramaTransmitida=transmitida;
		
	}
	public void setErroPadrao(Trama erroPadrao) {
		this.erroPadrao=erroPadrao;
		
	}
	
	
	
	
	
	
	
	

}
