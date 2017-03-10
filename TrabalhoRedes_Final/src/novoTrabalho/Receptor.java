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

	public void verificaErros(int i, Trama recebida, Trama transmitida, Trama erros) {
		switch (i) {
		case 1:
			if (b.errosBitParidade(recebida))
				System.out.println("Resultado: Trama recebida COM erros.");
			else
				igualdadeEntreReT(recebida, transmitida);

			break;
		case 2:
			if (h.errosHamming(recebida,erros)){
				System.out.println("Resultado: Trama recebida COM erros na posicao "+ h.getPosicao());
				System.out.println("Trama corrigida:" + transmitida);
			}
			else
				igualdadeEntreReT(recebida, transmitida);

			break;
		case 3:
			if (crc7.tramaErrada(recebida))
				System.out.println("Resultado: Trama recebida COM erros.");
			else
				igualdadeEntreReT(recebida, transmitida);

			break;
		case 4:
			if (crc12.tramaErrada(recebida))
				System.out.println("Resultado: Trama recebida COM erros.");
			else
				igualdadeEntreReT(recebida, transmitida);

			break;
		}

	}

	public void igualdadeEntreReT(Trama tramaRecebida, Trama tramaTransmitida) {
		System.out.println(tramaRecebida);
		System.out.println(tramaTransmitida);
		if (!tramaRecebida.getTrama().equals(tramaTransmitida.getTrama()))
			System.out.println("Resultado: Trama recebida COM erros que nao foram detetados");
		else
			System.out.println("Resultado: Trama recebida SEM erros.");

	}
}
