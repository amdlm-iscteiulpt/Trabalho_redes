package pt.iscte.dcti.redes1.Simulacao;

import java.util.ArrayList;
import java.util.Scanner;

import pt.iscte.dcti.redes1.trabalho.BitParidade;
import pt.iscte.dcti.redes1.trabalho.CRC;
import pt.iscte.dcti.redes1.trabalho.CRCReceptor;
import pt.iscte.dcti.redes1.trabalho.Emissor;
import pt.iscte.dcti.redes1.trabalho.Hamming;
import pt.iscte.dcti.redes1.trabalho.Trama;

public class Simulacao {

	private final int bitsDados = 4;
	private Emissor s;
	private int opcao;
	private Hamming m;
	

	public Simulacao(Emissor s, Hamming m, int opcao) {
		this.s = s;
		this.m=m;
		this.opcao=opcao;
		switch (opcao) {
		case 1:
			setOpcao(1);
			System.out.println("Bit Paridade");
			gerarTramasBits();
			
			break;
		case 2:
			setOpcao(2);
			System.out.println("Hamming");
			gerarTramasBits();

			
			break;
		case 3:
			setOpcao(3);
			System.out.println("CRC");
			gerarTramasBits();
			
			break;
		default:
			System.out.println("Número errado, Tente outra vez!");
			break;
		}
	}

	

	public void gerarTramasBits() {
		int i = 0;
		while (i < 1) {
			sendTransmitida(tramaBits());
			
			i++;
		}

	}

	public Trama tramaBits() {
		Trama trama = new Trama(bitsDados);
		for (int i = 0; i < bitsDados; i++) {
			trama.add(randomBit(0.5));
		}
		
		System.out.println("Trama Gerada D: " + trama);
		return trama;
	}

	public int randomBit(double random) {
		double r = Math.random();
		if (r > random) {
			return 0;
		}
		return 1;
	}

	public int getOpcao() {
		return opcao;
	}

	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}

	

	public void sendTransmitida(Trama transmitida) {
		switch(opcao){
		case 3:
			CRCReceptor crc = new CRCReceptor(transmitida.getTrama());
			Trama t = new Trama(crc.tramaFCSEmissor());
			this.s.setTramaTransmitida(t);
			System.out.println("Trama Transmitida -> T:" + t);
		break;
		case 2:
			m.definirTramaT(transmitida);
			this.s.setTramaTransmitida(m.getTramaTransmitida());
			System.out.println("Trama Transmitida -> T:" + m.getTramaTransmitida());
			break;
		case 1:
			BitParidade bitParidade = new BitParidade();
			Trama t1 = new Trama(bitParidade.bitParidade(transmitida));
			this.s.setTramaTransmitida(t1);
			System.out.println("Trama Transmitida -> T:" + t1);
		}
		
		
	}

}
