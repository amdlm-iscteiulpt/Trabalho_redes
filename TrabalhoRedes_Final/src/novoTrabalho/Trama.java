package novoTrabalho;

import java.util.ArrayList;

public class Trama {
	
	private int tamanho ;
	private String bits; //dados
	private ArrayList<Integer> listaTrama;
	
	public Trama(String bits, int tamanho){
		this.tamanho=tamanho;
		this.bits=bits;
		listaTrama= new ArrayList<Integer>(tamanho);
		addTrama(bits);
	}
	
	public void addTrama(String bits){
		for(int i=0; i<bits.length();i++){
			listaTrama.add(Integer.parseInt(""+bits.charAt(i)));
		}
		}
	
	
	
	public ArrayList<Integer> getListaTrama() {
		return listaTrama;
	}

	public void setListaTrama(ArrayList<Integer> listaTrama) {
		this.listaTrama = listaTrama;
	}
	
	

}
