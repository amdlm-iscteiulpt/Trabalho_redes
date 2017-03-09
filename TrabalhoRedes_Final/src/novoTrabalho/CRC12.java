package novoTrabalho;

public class CRC12 {
	//l
	private int[] trama_recebida = {1,1,1,1,0,0,0,0,0,0,0,0};

	private int C0 = 0;
	private int C1 = 0;
	private int C2 = 0;
	private int C3 = 0;
	private int C4 = 0;
	private int C5 = 0;
	private int C6 = 0;
	private int C7 = 0;
	

	private int C0_anterior = 0;
	private int C1_anterior = 0;
	private int C2_anterior = 0;
	private int C3_anterior = 0;
	private int C4_anterior = 0;
	private int C5_anterior = 0;
	private int C6_anterior = 0;
	private int C7_anterior = 0;

	public void crc() {
		C7_anterior = trama_recebida[0];
		C6_anterior = trama_recebida[1];
		C5_anterior = trama_recebida[2];
		C4_anterior = trama_recebida[3];
		C3_anterior = trama_recebida[4];
		C2_anterior = trama_recebida[5];
		C1_anterior = trama_recebida[6];
		C0_anterior = trama_recebida[7];
		
		for (int i = 8; i < trama_recebida.length; i++) {
			C0 = xor(trama_recebida[i], C7_anterior);
			C1 = xor(C0_anterior, C7_anterior);
			C2 = xor(C1_anterior, C7_anterior);
			C3 =C2_anterior;
			C4 =C3_anterior;
			C5 =C4_anterior;
			C6 =C5_anterior;
			C7 =C6_anterior;
			
			C7_anterior = C7;
			C6_anterior = C6;
			C5_anterior = C5;
			C4_anterior = C4;
			C3_anterior = C3;
			C2_anterior = C2;
			C1_anterior = C1;
			C0_anterior = C0;
			
		}
		
		System.out.println(C7);
		System.out.println(C6);
		System.out.println(C5);
		System.out.println(C4);
		System.out.println(C3);
		System.out.println(C2);
		System.out.println(C1);
		System.out.println(C0);
	}
	
	
	private int xor(int i, int j){
		if(i!=j){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	public static void main(String[] args) {
		CRC12 a = new CRC12();
		a.crc();
	}


}
