package pt.iscte.dcti.redes1.trabalho;

import java.util.ArrayList;
public class Hamming {
	
	private ArrayList<Integer> tramaR = new ArrayList<Integer>();
	private ArrayList<Integer> tramaInicio = new ArrayList<Integer>();
	private ArrayList<Integer> arrayP1 = new ArrayList<Integer>();
	private ArrayList<Integer> arrayP2 = new ArrayList<Integer>();
	private ArrayList<Integer> arrayP4 = new ArrayList<Integer>();
	
	
	public void definirTramaR(Trama trama){
		for (int i = 0; i < trama.getTrama().size(); i++) {
			tramaR.add(trama.getTrama().get(i));
		}
		
	}
	
	public void definirTramaT(Trama trama){
		
		for (int i = 0; i < trama.getTrama().size(); i++) {
			tramaInicio.add(trama.getTrama().get(i));
		}
		definirMatriz();
	}
	
	
	public void definirMatriz(){
		int[][] matriz= { {0,1,1},{1,0,1}, {1,1,0}, {1,1,1} };
		
			for (int i = 0; i < 4; i++) {
				if(matriz[i][0] == 1){
					arrayP4.add(i);	
				}
				if(matriz[i][1] == 1){
					arrayP2 .add(i);
				}
				if(matriz[i][2] == 1){
					arrayP1.add(i);
				}

		}
		System.out.println("arrayP1 " + arrayP1.toString());
		System.out.println("arrayP2 " + arrayP2.toString());
		System.out.println("arrayP4 " + arrayP4.toString());
			
	}
	
	public int calculoP(ArrayList<Integer> array){
		ArrayList<Integer> p= new ArrayList<Integer> ();
		for (int i = 0; i < array.size(); i++) {	
			p.add(tramaInicio.get(array.get(i)));

		}	
		int nr = (xor(xor(p.get(0), p.get(1)), p.get(2)));
		
		return nr;
	}
	
	
	public int calculoC1(){
		int p = xor(calculoP(arrayP1), tramaR.get(0));
		return p;
	}
	
	public int calculoC2(){
		int p = xor(calculoP(arrayP2), tramaR.get(1));
		return p;
	}
	public int calculoC4(){
		int p = xor(calculoP(arrayP4), tramaR.get(3));
		return p;
	}

	
	
	public Trama getTramaTransmitida(){
		//BITS DE PARIDADE
		int p1 = calculoP(arrayP1);
		int p2 = calculoP(arrayP2);
		int p4 = calculoP(arrayP4);
		
		Trama tramaTransmitida = new Trama(""  + p1 + p2 + tramaInicio.get(0) + p4 + tramaInicio.get(1) + tramaInicio.get(2)+
				tramaInicio.get(3) );
		System.out.println("tramaT:" + tramaTransmitida.toString());

		return tramaTransmitida;
	}
	
	
	public Trama getTramaRecebida() {
		int c1 = calculoC1();
		System.out.println("C1 -> " + c1);
		int c2 = calculoC2();
		System.out.println("C2 -> " + c2);
		int c4 = calculoC4();
		System.out.println("C4 -> " + c4);
				
		if(c1 == 0 && c2 == 0 && c4 == 0 ){
			System.out.println("NAO TEM ERROS!!");
		}
		else{
			String posicao = "" + c4 + c2 + c1;
			int po = Integer.parseInt(posicao, 2);
			System.out.println("TEM ERRO!! -> POSICAO " + po );
			return getTramaTransmitida();
		}
		return null;
		
		
	}

	public int xor (int v1, int v2){
		if(v1 == v2 ){
			return 0;
		}
		else{
			return 1;
		}
	}

	public ArrayList<Integer> getArrayP1() {
		return arrayP1;
	}

	public ArrayList<Integer> getArrayP2() {
		return arrayP2;
	}

	public ArrayList<Integer> getArrayP4() {
		return arrayP4;
	}
	

	

}
