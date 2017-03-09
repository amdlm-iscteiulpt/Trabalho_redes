package novoTrabalho;



public class Emissor {

	private Trama tramaTransmitida;
	private Hamming h;
	private BitParidade b;
//	private CRC7 crc7;
//	private CRC12 crc12;

	public Emissor(Hamming h, BitParidade b) {
		this.h = h;
		this.b = b;
	}
	
	public Trama getTramaTransmitida(int i, Trama tramaDados) {
		switch (i) {
		case 1:
			tramaTransmitida = b.calculoBitParidade(tramaDados);
			break;
		case 2:
			h.definirTramaT(tramaDados);
			tramaTransmitida = h.getTramaTransmitida();
			break;
		case 3:
//			System.out.println("CRC Grau 3");
//			CRCReceptorGrau8 crcGrau3 = new CRCReceptorGrau8(dados);
//			Transmitida = new Trama(crcGrau3.tramaFCSEmissor());
//			break;

		case 4:
//			System.out.println("CRC Grau 8");
//			CRCReceptorGrau8 crcGrau8 = new CRCReceptorGrau8(trama_bits.getTrama());
//			Transmitida = new Trama(crcGrau8.tramaFCSEmissor());
//			break;
		}

		return tramaTransmitida;

	}

}
