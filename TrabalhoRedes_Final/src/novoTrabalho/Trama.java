package novoTrabalho;

import java.util.ArrayList;

public class Trama {
	private int TAMANHO = 4;
	private ArrayList<Integer> trama;
	private Estado estado;

	public Trama(String bits) {
		trama = new ArrayList<Integer>(TAMANHO);
		tratarBits(bits);

	}
	
	public Trama(ArrayList<Integer> trama) {
		this.trama = trama;

	}

	public ArrayList<Integer> getTrama() {
		return trama;
	}
	
	public Trama(int tamanho) {
		trama = new ArrayList<Integer>(tamanho);
		//tratarBits(bits);

	}
	
	public int contador() {
		int c = 0;
		for (int i = 0; i < trama.size(); i++) {
			if (trama.get(i) == 1) {
				c++;
			}
		}
		return c;

	}

	


	public int getTamanho() {
		return TAMANHO;
	}

	

	public void tratarBits(String s) {
		for (int i = 0; i < s.length(); i++) {
			trama.add(Integer.parseInt("" + s.charAt(i)));
		}
	}

	@Override
	public String toString() {
		return "[" + trama + "]";
	}

	public void add(int randomBit) {
		trama.add(randomBit);

	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
