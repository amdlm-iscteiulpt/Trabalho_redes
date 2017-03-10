package pt.iscte.dcti.redes1.Simulacao;

import java.util.Scanner;
import novoTrabalho.CanalRuidoso;
import novoTrabalho.Emissor;
import novoTrabalho.Receptor;
import novoTrabalho.Trama;

public class ModoSimulacao {

	private Emissor e;
	private CanalRuidoso cr;
	private Receptor r;
	private Trama tramaErroPadrao;
	private Trama tramaTransmitida;
	private Trama tramaRecebida;
	
	public ModoSimulacao(Emissor e, CanalRuidoso cr, Receptor r) {
		this.e = e;
		this.cr = cr;
		this.r = r;
	}

	public void inicia(int opcao, double perrobit) {
		Trama tramaDados = gerarTramaDados();
		if (opcao == 1 || opcao == 2 || opcao == 3 || opcao == 4) {
			tramaTransmitida = e.getTramaTransmitida(opcao, tramaDados);
			sendTransmitida();
			tramaErroPadrao = cr.gerarTramasErros(opcao, perrobit);
			sendErroPadrao();
			tramaRecebida = cr.getRecebida(tramaTransmitida, tramaErroPadrao);
			sendRecebida();
			r.verificaErros(opcao, tramaRecebida);
			r.conclusao(opcao, tramaRecebida, tramaTransmitida);
			
		} else {
			System.out.println("Numero Errado. Tente novamente.");
			menu();
		}

	}

	public void sendTransmitida() {
		System.out.println("Trama Transmitida -> T:" + tramaTransmitida);
	}

	public void sendErroPadrao() {
		System.out.println("PadraoDeErro -> E:" + tramaErroPadrao);
	}

	public void sendRecebida() {
		System.out.println("Trama Recebida -> R:" + tramaRecebida);
	}

	public void menu() {
		System.out.println("Escolha da tecnica (1:Bit Paridade, 2:Hamming, 3:CRC Grau 3, 4: CRC Grau 8)");
	}

	public Trama gerarTramaDados() {
		Trama trama = new Trama("");
		for (int i = 0; i < 4; i++) {
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

}
