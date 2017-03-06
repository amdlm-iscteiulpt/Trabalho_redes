package pt.iscte.dcti.redes1.trabalho;

import java.util.ArrayList;

public class BitParidade {
	
		public ArrayList<Integer> bitParidade( Trama trama){
			ArrayList <Integer> lista= trama.getTrama() ;	
			if(trama.contador() % 2==0){
				lista.add(0);	
			}
			else{
				lista.add(1);
			}
		return lista;	
		
	}
		
		public int xor (int a , int b){
			if(a==b){
				return 0;
			}
			else{
				return 1;
			}
			
		}
		
		public ArrayList <Integer> tramaRecebida (Trama t1, Trama t2){
			ArrayList <Integer> listaTramaRecebida= new ArrayList <Integer>();
			for(int i=0; i<listaTramaRecebida.size();i++){
					 listaTramaRecebida.add(xor(t1.getTrama().get(i),t2.getTrama().get(i)));
					 
				
			}
			System.out.println(listaTramaRecebida);
			return listaTramaRecebida;
			
		}

}
