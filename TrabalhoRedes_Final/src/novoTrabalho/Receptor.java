package novoTrabalho;

public class Receptor {
	
	private Trama tramaRecebida;
	private Hamming h;
	private BitParidade b;
	private CRC7 crc7;
	private CRC12 crc12;
	
	public Receptor(BitParidade b, Hamming h, CRC7 crc7, CRC12 crc12) {
		this.b = b;
		this.h = h;
		this.crc7 = crc7;
		this.crc12 = crc12;
		// TODO Auto-generated constructor stub
	}

}
