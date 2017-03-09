package novoTrabalho;

public class MainDemonstracao {

	public MainDemonstracao() {
		Hamming m = new Hamming();
		BitParidade b = new BitParidade();
		CRC7 crc7 = new CRC7();
		CRC12 crc12 = new CRC12();
		Receptor r = new Receptor(b, m, crc7, crc12);
		Emissor e = new Emissor(m, b, crc7, crc12);
		CanalRuidoso cr = new CanalRuidoso();
		ModoDemonstracao md = new ModoDemonstracao(e, cr, r);
		md.inicia();

	}

	public static void main(String[] args) {
		new MainDemonstracao();
	}

}
