package novoTrabalho;



public class Emissor {

	private Trama tramaTransmitida;
	private Hamming h;
	private BitParidade b;
	private CRC7 crc7;
	private CRC12 crc12;

	public Emissor(Hamming h, BitParidade b, CRC7 crc7, CRC12 crc12) {
		this.h = h;
		this.b = b;
		this.crc12 = crc12;
		this.crc7 = crc7;
	}
	
	public Trama getTramaTransmitida(int i, Trama tramaDados) {
		switch (i) {
		case 1:
			tramaTransmitida = b.calculoBitParidade(tramaDados);
			break;
		case 2:
			tramaTransmitida = h.calculoHamming(tramaDados);
			break;
		case 3:
			tramaTransmitida = crc7.getTransmitida(tramaDados);
			break;
		case 4:
			tramaTransmitida = crc12.getTransmitida(tramaDados);
			break;
		}

		return tramaTransmitida;

	}

}
