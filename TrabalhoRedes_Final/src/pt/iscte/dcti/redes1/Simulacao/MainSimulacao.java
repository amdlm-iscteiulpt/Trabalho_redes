package pt.iscte.dcti.redes1.Simulacao;

import java.util.Scanner;

import novoTrabalho.BitParidade;
import novoTrabalho.CRC12;
import novoTrabalho.CRC7;
import novoTrabalho.CanalRuidoso;
import novoTrabalho.Emissor;
import novoTrabalho.Hamming;
import novoTrabalho.Receptor;

public class MainSimulacao {

	private static int nr_vezes = 10;

	public static void menu() {
		System.out.println("Escolha da tecnica (1:Bit Paridade, 2:Hamming, 3:CRC Grau 3, 4: CRC Grau 8)");
	}

	public static void main(String[] args) {
		int i = 0;
		menu();
		Scanner scanner = new Scanner(System.in);
		int opcao = scanner.nextInt();
		while (i < nr_vezes) {
			Hamming m = new Hamming();
			BitParidade b = new BitParidade();
			CRC7 crc7 = new CRC7();
			CRC12 crc12 = new CRC12();
			Receptor r = new Receptor(b, m, crc7, crc12);
			Emissor e = new Emissor(m, b, crc7, crc12);
			CanalRuidoso cr = new CanalRuidoso();
			ModoSimulacao ms = new ModoSimulacao(e, cr, r);

			ms.inicia(opcao);
			i++;
		}
	}

}
