package novoTrabalho;

public class Receptor {

	private Hamming h;
	private BitParidade b;
	private CRC7 crc7;
	private CRC12 crc12;

	public Receptor(BitParidade b, Hamming h, CRC7 crc7, CRC12 crc12) {
		this.b = b;
		this.h = h;
		this.crc7 = crc7;
		this.crc12 = crc12;
	}

	public void verificaErros(int i, Trama recebida, Trama transmitida) {
		switch (i) {
		case 1:
			// tramaTransmitida = b.calculoBitParidade(tramaDados);
			break;
		case 2:
			// h.definirTramaT(tramaDados);
			// tramaTransmitida = h.getTramaTransmitida();
			break;
		case 3:
			if (crc7.tramaErrada(recebida)) {
				System.out.println("Resultado: Trama recebida COM erros.");
			} else {
				if (recebida.equals(transmitida))
					System.out.println("Resultado: Trama recebida COM erros que não foram detectados");
				else
					System.out.println("Resultado: Trama recebida SEM erros.");
			}
			break;
		case 4:
			if (crc12.tramaErrada(recebida)) {
				System.out.println("Resultado: Trama recebida COM erros.");
			} else {
				if (recebida.equals(transmitida))
					System.out.println("Resultado: Trama recebida COM erros que não foram detectados");
				else
					System.out.println("Resultado: Trama recebida SEM erros.");
			}
			break;
		}

	}

}
