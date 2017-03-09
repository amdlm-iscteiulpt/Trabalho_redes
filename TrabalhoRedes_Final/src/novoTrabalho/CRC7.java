package novoTrabalho;

public class CRC7 {

	private int[] trama_recebida = {1,1,1,1,0,0,0};

	private int C0 = 0;
	private int C1 = 0;
	private int C2 = 0;

	private int C0_anterior = 0;
	private int C1_anterior = 0;
	private int C2_anterior = 0;

	public void crc(Trama dados) {
		C2_anterior = trama_recebida[0];
		C1_anterior = trama_recebida[1];
		C0_anterior = trama_recebida[2];
		
		for (int i = 3; i < trama_recebida.length; i++) {
			C0 = xor(trama_recebida[i], C2_anterior);
			C1 = xor(C0_anterior, C2_anterior);
			C2 = C1_anterior;
			
			C2_anterior = C2;
			C1_anterior = C1;
			C0_anterior = C0;
			
		}
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
		CRC7 a = new CRC7();
		a.crc();
	}
}
