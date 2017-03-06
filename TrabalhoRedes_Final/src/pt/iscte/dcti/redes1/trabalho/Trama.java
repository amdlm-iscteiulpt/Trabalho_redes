package pt.iscte.dcti.redes1.trabalho;

import java.util.ArrayList;

public class Trama {
	private int TAMANHO = 4;
	private ArrayList<Integer> trama;
	private String bits;
	
	
	public Trama(String bits){
		this.bits=bits;
		trama= new ArrayList<Integer>(TAMANHO);
		tratarBits(bits);
		
	}
	
	public int contador (){
		int c=0;
		for(int i=0; i<trama.size();i++){
			if(trama.get(i)==1){
				c++;
			}
		}
		return c;
		
	}
	
	public Trama(ArrayList<Integer> trama) {
		this.trama = trama;
		
	}

	public Trama(int bitsDados) {
		this.TAMANHO=bitsDados;
		trama= new ArrayList<Integer>(TAMANHO);
	}

	public int getTamanho(){
		return TAMANHO;
	}
	
	public ArrayList<Integer> getTrama(){
		return trama;
	}

	public void tratarBits(String s ){
		for(int i = 0; i< s.length(); i++){
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
	
	
	
	
}
