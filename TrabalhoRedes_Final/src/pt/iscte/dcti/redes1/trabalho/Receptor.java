package pt.iscte.dcti.redes1.trabalho;

public class Receptor {

	private Trama tramaRecebida;
	private Hamming m;

	public Receptor(Hamming m) {
		this.m = m;
	}

	public void getResto() {
		CRCReceptorGrau8 crc = new CRCReceptorGrau8(tramaRecebida.getTrama());
		Trama trama = new Trama(crc.tramaFCS());
		if (trama.contador() == 0) {
			System.out
					.println("Trama sem erros ou tem erros mas não são detetáveis");
		} else {
			System.out.println("Trama com erros");
		}

	}

	public void setTramaRecebida(Trama tramaRecebida) {
		this.tramaRecebida = tramaRecebida;

	}

	public Trama getTramaRecebida() {
		return tramaRecebida;
	}

	public void correcaoTrama(int i) {
		switch (i) {
		case 1:
			bitParidade();
			break;
		case 2:
			getTramaRecebidaHamming();
			break;
		case 3:
			getResto();
			break;
		default:
			break;
		}
	}

	private void bitParidade() {
		int ultimoBit = tramaRecebida.getTrama().remove(
				tramaRecebida.getTrama().size() - 1);
		if (ultimoBit == 0 && !isPar(tramaRecebida)) {
			System.out.println("Trama com erros");
		} else {
			if (ultimoBit == 1 && isPar(tramaRecebida)) {
				System.out.println("Trama com erros");
			} else {
				System.out.println("Trama sem erros");
			}
		}
	}

	public boolean isPar(Trama trama) {
		if (trama.contador() % 2 == 0) {
			return true;
		}
		return false;
	}

	public void getTramaRecebidaHamming() {
		m.definirTramaR(tramaRecebida);
		int c1 = m.calculoC1();
		System.out.println("C1 -> " + c1);
		int c2 = m.calculoC2();
		System.out.println("C2 -> " + c2);
		int c4 = m.calculoC4();
		System.out.println("C4 -> " + c4);

		if (c1 == 0 && c2 == 0 && c4 == 0) {
			System.out.println("TRAMA NAO TEM ERROS!!");
		}

		String posicao = "" + c4 + c2 + c1;
		int po = Integer.parseInt(posicao, 2);
		System.out.println("TRAMA COM ERRO!! -> POSICAO " + po);

	}

}
