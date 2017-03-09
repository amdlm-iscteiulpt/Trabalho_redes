package novoTrabalho;

public class MainDemonstracao {

	public MainDemonstracao() {
		Hamming m = new Hamming();
		BitParidade b = new BitParidade();
		//Receptor r = new Receptor();
		Emissor e = new Emissor(m, b);
		CanalRuidoso cr = new CanalRuidoso();

		ModoDemonstracao md = new ModoDemonstracao(e, cr);
		md.inicia();

	}

	public static void main(String[] args) {
		new MainDemonstracao();
	}

}
