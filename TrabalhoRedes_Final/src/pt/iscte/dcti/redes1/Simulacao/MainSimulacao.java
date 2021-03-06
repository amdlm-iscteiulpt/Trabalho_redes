package pt.iscte.dcti.redes1.Simulacao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import novoTrabalho.BitParidade;
import novoTrabalho.CRC12;
import novoTrabalho.CRC7;
import novoTrabalho.CanalRuidoso;
import novoTrabalho.Emissor;
import novoTrabalho.Hamming;
import novoTrabalho.Receptor;

public class MainSimulacao {

	private static int nr_vezes = 10000000;
	public static int N_TRAMAS_SEM_ERROS = 0;
	public static int N_TRAMAS_ERROS_NAO_DETETADOS = 0;
	public static int N_TRAMAS_CORRIGIDAS = 0;
	public static int N_BITS_ERRADOS = 0;
	public static double[] pErroBit = { 0.000001, 0.00001, 0.0001, 0.001, 0.01, 0.1, 0.125, 0.25, 0.5 };

	public static void menu() {
		System.out.println("Escolha da tecnica (1:Bit Paridade, 2:Hamming, 3:CRC Grau 3, 4: CRC Grau 8)");
	}

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		int i = 0;
		menu();
		Scanner scanner = new Scanner(System.in);
		int opcao = scanner.nextInt();
		for (int y = 0; y < pErroBit.length; y++) {
			N_TRAMAS_SEM_ERROS = 0;
			N_TRAMAS_ERROS_NAO_DETETADOS = 0;
			N_TRAMAS_CORRIGIDAS = 0;
			N_BITS_ERRADOS = 0;
			
			for (int t = 0; t < nr_vezes; t++) {
				
				System.out.println( "Y-> " + y);
				
				
				Hamming m = new Hamming();
				BitParidade b = new BitParidade();
				CRC7 crc7 = new CRC7();
				CRC12 crc12 = new CRC12();
				Receptor r = new Receptor(b, m, crc7, crc12);
				Emissor e = new Emissor(m, b, crc7, crc12);
				CanalRuidoso cr = new CanalRuidoso();
				r.setProb(N_BITS_ERRADOS, N_TRAMAS_CORRIGIDAS, N_TRAMAS_ERROS_NAO_DETETADOS, N_TRAMAS_SEM_ERROS);
				r.setProb(N_BITS_ERRADOS, N_TRAMAS_CORRIGIDAS, N_TRAMAS_ERROS_NAO_DETETADOS, N_TRAMAS_SEM_ERROS);
				ModoSimulacao ms = new ModoSimulacao(e, cr, r);

				ms.inicia(opcao, pErroBit[y]);

				N_TRAMAS_SEM_ERROS = r.getN_TRAMAS_SEM_ERROS();
				N_TRAMAS_ERROS_NAO_DETETADOS = r.getN_TRAMAS_ERROS_NAO_DETETADOS();
				N_TRAMAS_CORRIGIDAS = r.getN_TRAMAS_CORRIGIDAS();
				N_BITS_ERRADOS = r.getN_BITS_ERRADOS();



			}
			Probabilidades pb = new Probabilidades(N_TRAMAS_ERROS_NAO_DETETADOS, N_TRAMAS_SEM_ERROS,
					N_TRAMAS_CORRIGIDAS, N_BITS_ERRADOS, nr_vezes, opcao);
		
			escreverFicheiro(pErroBit[y],opcao, pb.Prob_sem_erros(), pb.Valo_bits_errados(),pb.Prob_com_erros_nao_detectadas(),pb.Prb_com_erros_correctas());
		}
		
		System.out.println((System.currentTimeMillis()-inicio)/1000/60);

	}

	public static void escreverFicheiro(double y, int opcao, double Prob_sem_erros, double Valo_bits_errados, double Prob_com_erros_nao_detectadas, double Prb_com_erros_correctas) {
		File arquivo = new File("/Users/margaridamartins/Desktop" + opcao + ".txt");
		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}

			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			//bw.write("Peb	Pse	#erros	Pnd|e	Pcc|e	");
			bw.write(y+"	"+Prob_sem_erros+"	"+Valo_bits_errados+"	"+Prob_com_erros_nao_detectadas+"	"+Prb_com_erros_correctas);
			bw.newLine();

			bw.close();
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
