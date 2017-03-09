package novoTrabalho;

import java.util.Scanner;

public class ModoDemonstracao {

	private static Trama tramaDados;
	private static Trama tramaErroPadrao;
	private Trama tramaTransmitida;
	private Trama tramaRecebida; //usem esta para achar erros 
	private Emissor emissor;
	private CanalRuidoso canalRuidoso;

	public ModoDemonstracao(Emissor e, CanalRuidoso cr) {
		this.emissor = e;
		this.canalRuidoso = cr;
	}

	public void inicia() {
		menu();
		Scanner scanner = new Scanner(System.in);	
		int opcao = scanner.nextInt();
		bitsDados(scanner);
		switch (opcao) {
		case 1:
			System.out.println("Bit Paridade");
			tramaTransmitida = emissor.getTramaTransmitida(1, tramaDados);
			getRecebida(scanner);
			break;
		case 2:
			System.out.println("Hamming");
			tramaTransmitida = emissor.getTramaTransmitida(2, tramaDados);
			getRecebida(scanner);
			break;
		case 3:
			System.out.println("CRC Grau 3");
			
			// CRCReceptorGrau8 crcGrau3 = new
			// CRCReceptorGrau8(trama_bits.getTrama());
			// Transmitida = new Trama(crcGrau3.tramaFCSEmissor());
			
			break;

		case 4:
			System.out.println("CRC Grau 8");
			// bits_dados(scanner);
			// CRCReceptorGrau8 crcGrau8 = new
			// CRCReceptorGrau8(trama_bits.getTrama());
			// Transmitida = new Trama(crcGrau8.tramaFCSEmissor());
			// padra_erro(scanner);
			break;
		default:
			System.out.println("Numero errado, Tente outra vez!");
			menu();
			break;
		}
	}

	public void sendTransmitida() {
		System.out.println("Trama Transmitida -> T:" + tramaTransmitida);
	}

	public void sendErroPadrao() {
		System.out.println("PadraoDeErro -> E:" + tramaErroPadrao);
	}

	public void sendRecebida() {
		System.out.println("Trama Recebida -> R:" + tramaRecebida);
	}

	public void menu() {
		System.out.println("Escolha da tecnica (1:Bit Paridade, 2:Hamming, 3:CRC Grau 3, 4: CRC Grau 8)");
	}

	public static void bitsDados(Scanner scanner) {
		System.out.print("Bits de Dados -> D:");
		String bits = scanner.next();
		tramaDados = new Trama(bits);

	}

	private static void padraoErros(Scanner scanner) {
		System.out.print("Padrão de Erro -> E:");
		String erro = scanner.next();
		tramaErroPadrao = new Trama(erro);
	}

	private void getRecebida(Scanner scanner) {
		sendTransmitida();
		padraoErros(scanner);
		tramaRecebida = canalRuidoso.getRecebida(tramaTransmitida, tramaErroPadrao);
		sendRecebida();
	}

}
