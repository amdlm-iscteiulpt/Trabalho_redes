package pt.iscte.dcti.redes1.Simulacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import pt.iscte.dcti.redes1.trabalho.CanalRuidoso;
import pt.iscte.dcti.redes1.trabalho.Emissor;
import pt.iscte.dcti.redes1.trabalho.Hamming;
import pt.iscte.dcti.redes1.trabalho.Receptor;
import pt.iscte.dcti.redes1.trabalho.Trama;

public class Main {

	public static final double[] pErroBit = {0.000001, 0.00001, 0.0001, 0.001, 0.01, 0.1, 0.125, 0.25, 0.5};
	public static HashMap<Integer, Integer> xBitsErrados = new HashMap<Integer, Integer>();
	//main
	
	public static void main(String[] args) {
		int i = 0;
		System.out.println("Escolha da técnica (1:Bit paridade, 2:Hamming, 3:CRC)");
		int opcao = new Scanner(System.in).nextInt();
		
		while(i<100){
		Hamming m = new Hamming();
		Receptor r = new Receptor(m);	
		CanalRuidoso cr = new CanalRuidoso(r);
		Emissor e = new Emissor(cr);
		Simulacao sm = new Simulacao(e,m,opcao);
		
		e.sendTransmitida();
		for(int y = 0; y< pErroBit.length; y++){
			cr.gerarTramasErros(sm.getOpcao(), pErroBit[y]);
		}
		
		cr.sendTramaRecebida();
		
		System.out.println("Trama Recebida -> R :" + r.getTramaRecebida());
		//r.getResto();
		r.correcaoTrama(sm.getOpcao());
		i++;
		}
		
	}
}
