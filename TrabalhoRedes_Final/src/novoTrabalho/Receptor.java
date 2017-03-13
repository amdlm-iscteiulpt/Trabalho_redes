package novoTrabalho;

public class Receptor {

	private Hamming h;
	private BitParidade b;
	private CRC7 crc7;
	private CRC12 crc12;

	public int N_TRAMAS_SEM_ERROS;
	public int N_TRAMAS_ERROS_NAO_DETETADOS;
	public int N_TRAMAS_CORRIGIDAS;
	public int N_BITS_ERRADOS;

	public Receptor(BitParidade b, Hamming h, CRC7 crc7, CRC12 crc12) {
		this.b = b;
		this.h = h;
		this.crc7 = crc7;
		this.crc12 = crc12;
	}

	public void verificaErros(int i, Trama recebida) {
		switch (i) {
		case 1:
			b.errosBitParidade(recebida);
			break;
		case 2:
			h.errosHamming(recebida);
			break;
		case 3:
			crc7.tramaErrada(recebida);
			break;
		case 4:
			crc12.tramaErrada(recebida);
			break;
		}
	}

	public void conclusao(int i, Trama recebida, Trama transmitida) {
		switch (recebida.getEstado()) {
		case SEM_ERROS:
			if (igualdadeEntreReT(recebida, transmitida)) {
				System.out.println("Conclusão: Trama sem erro(s).");
				N_TRAMAS_SEM_ERROS++;
				break;
			} else {
				recebida.setEstado(Estado.COM_ERROS_NAO_DETETADOS);
				System.out.println("Conclusão: Trama com erro(s) não detectado(s).");
				N_TRAMAS_ERROS_NAO_DETETADOS++;
				break;
			}
		case COM_ERROS:
			if (i == 2) {
				if (!recebida.getTrama().equals(transmitida.getTrama())) {
					System.out.println("Conclusão: Trama com erro(s) detectado(s) e não corrigida(s).");

					recebida.setEstado(Estado.COM_ERROS_MAL_CORRIGIDA);
				} else {
					recebida.setEstado(Estado.COM_ERROS_CORRIGIDA);
					System.out.println("Conclusão: Trama com erro(s) detectado(s) e corrigida(s).");
					N_TRAMAS_CORRIGIDAS++;

				}

			}
			System.out.println("Conclusão: Trama com erro(s) detectado(s).");

			break;
		}
		
		N_BITS_ERRADOS = N_BITS_ERRADOS + bitsDiferentes(recebida,transmitida);
	}

	public int getN_TRAMAS_SEM_ERROS() {
		return N_TRAMAS_SEM_ERROS;
	}

	public int getN_TRAMAS_ERROS_NAO_DETETADOS() {
		return N_TRAMAS_ERROS_NAO_DETETADOS;
	}

	public int getN_TRAMAS_CORRIGIDAS() {
		return N_TRAMAS_CORRIGIDAS;
	}

	public int getN_BITS_ERRADOS() {
		return N_BITS_ERRADOS;
	}

	public int bitsDiferentes(Trama tramaRecebida, Trama tramaTransmitida) {
		int c = 0;
		if (tramaRecebida.getTrama().equals(tramaTransmitida.getTrama()))
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
		
		else
			return true;
		

	}

	public void setProb(int N_BITS_ERRADOS, int N_TRAMAS_CORRIGIDAS, int N_TRAMAS_ERROS_NAO_DETETADOS,
			int N_TRAMAS_SEM_ERROS) {
		
		this.N_BITS_ERRADOS = N_BITS_ERRADOS;
		this.N_TRAMAS_CORRIGIDAS = N_TRAMAS_CORRIGIDAS;
		this.N_TRAMAS_ERROS_NAO_DETETADOS = N_TRAMAS_ERROS_NAO_DETETADOS;
		this.N_TRAMAS_SEM_ERROS = N_TRAMAS_SEM_ERROS;
		

	}
}
