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

	public void verificaErros(int i, Trama recebida, Trama erros) {
		switch (i) {
		case 1:
			b.errosBitParidade(recebida);
			break;
		case 2:
			h.errosHamming(recebida, erros);
			break;
		case 3:
			crc7.tramaErrada(recebida);
			break;
		case 4:
			crc12.tramaErrada(recebida);
			break;
		}
	}

	public void conclusao(int i, Trama recebida, Trama transmitida, Trama erros) {
		switch (recebida.getEstado()) {
		case SEM_ERROS:
			if (bitsDiferentes(recebida, transmitida) == 0) {
				break;
			} else {
				recebida.setEstado(Estado.COM_ERROS_NAO_DETETADOS);
			}
		case COM_ERROS:
			if (i == 3) {
				// recebida = h.tramaCorrigida(h.getPosicao(), recebida);
				if (!recebida.getTrama().equals(transmitida.getTrama())) {
					// System.out.println("Trama mal corrigida: "+ recebida);
					recebida.setEstado(Estado.COM_ERROS_MAL_CORRIGIDA);
				} else {
					recebida.setEstado(Estado.COM_ERROS_CORRIGIDA);
					// System.out.println("Trama bem corrigida: "+ recebida);
				}
			}
			break;
		}
	}

	public int bitsDiferentes(Trama tramaRecebida, Trama tramaTransmitida) {
		int c = 0;
		if (!tramaRecebida.getTrama().equals(tramaTransmitida.getTrama()))
			return 0;
		else
			for (int i = 0; i < tramaRecebida.getTrama().size(); i++) {
				if (!tramaRecebida.getTrama().get(i).equals(tramaTransmitida.getTrama().get(i))) {
					c++;
				}
			}
		return c;
	}

	public boolean igualdadeEntreReT(Trama tramaRecebida, Trama tramaTransmitida) {

		if (!tramaRecebida.getTrama().equals(tramaTransmitida.getTrama()))
			return false;
		// System.out.println("Resultado: Trama recebida COM erros que nao foram
		// detetados");
		else
			return true;
		// System.out.println("Resultado: Trama recebida SEM erros.");

	}
}
