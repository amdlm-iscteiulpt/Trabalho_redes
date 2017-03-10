package pt.iscte.dcti.redes1.Simulacao;

import java.text.DecimalFormat;

public class Probabilidades {

	private int N_TRAMAS_SEM_ERROS;
	private int N_TRAMAS_ERROS_NAO_DETETADOS;
	private int N_TRAMAS_CORRIGIDAS;
	private int N_BITS_ERRADOS;
	private int N_TRAMAS;
	private int TAMANHO_TRAMAS = 5;
	private DecimalFormat formato = new DecimalFormat("0.######");

	public Probabilidades(int N_TRAMAS_ERROS_NAO_DETETADOS, int N_TRAMAS_SEM_ERROS, int N_TRAMAS_CORRIGIDAS,
			int N_BITS_ERRADOS, int N_TRAMAS) {
		this.N_TRAMAS_SEM_ERROS = N_TRAMAS_SEM_ERROS;
		this.N_TRAMAS_ERROS_NAO_DETETADOS = N_TRAMAS_ERROS_NAO_DETETADOS;
		this.N_TRAMAS_CORRIGIDAS = N_TRAMAS_CORRIGIDAS;
		this.N_BITS_ERRADOS = N_BITS_ERRADOS;
		this.N_TRAMAS = N_TRAMAS;
	}

	public double Prob_sem_erros() {
		
		return ((double) N_TRAMAS_SEM_ERROS) / N_TRAMAS;
	}

	public double Prob_com_erros_nao_detectadas() {

		return ((double)N_TRAMAS_ERROS_NAO_DETETADOS) / N_TRAMAS;
		
		
	}

	public double Prb_com_erros_correctas() {

		return ((double) N_TRAMAS_CORRIGIDAS) / N_TRAMAS;
		
	}

	public double Valo_bits_errados() {
		return ((double) N_BITS_ERRADOS) / (TAMANHO_TRAMAS * N_TRAMAS);
		
	}

}
