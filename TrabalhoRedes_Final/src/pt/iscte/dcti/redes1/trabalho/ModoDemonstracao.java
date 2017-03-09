//package pt.iscte.dcti.redes1.trabalho;
//
//import java.util.Scanner;
//
//import novoTrabalho.Hamming;
//
//public class ModoDemonstracao {
//	static Trama trama_bits;
//
//	private static Trama Transmitida;
//	private static Trama ErroPadrao;
//	private Emissor e;
//	private int opcao;
//
//	public ModoDemonstracao(Emissor e, Hamming m) {
//		this.e = e;
//		menu();
//		Scanner scanner = new Scanner(System.in);
//		int opcao = scanner.nextInt();
//		switch (opcao) {
//		case 1:
//			System.out.println("Bit Paridade");
//			BitParidade bitParidade = new BitParidade();
//			//bit_dados1();
//			bits_dados(scanner);
//			Transmitida = new Trama(bitParidade.bitParidade(trama_bits));
//			padra_erro(scanner);
//			setOpcao(1);
//			break;
//		case 2:
//			System.out.println("Hamming");
//			bits_dados(scanner);
//			m.definirTramaT(trama_bits);
//			Transmitida = m.getTramaTransmitida();
//			padra_erro(scanner);
//			setOpcao(2);
//			break;
//		case 3:
//			System.out.println("CRC Grau 3");
//			bits_dados(scanner);
//			CRCReceptorGrau8 crcGrau3 = new CRCReceptorGrau8(trama_bits.getTrama());
//			Transmitida = new Trama(crcGrau3.tramaFCSEmissor());
//			padra_erro(scanner);
//			setOpcao(3);
//			break;
//			
//		case 4:
//			System.out.println("CRC Grau 8");
//			bits_dados(scanner);
//			CRCReceptorGrau8 crcGrau8 = new CRCReceptorGrau8(trama_bits.getTrama());
//			Transmitida = new Trama(crcGrau8.tramaFCSEmissor());
//			padra_erro(scanner);
//			setOpcao(3);
//			break;
//		default:
//			System.out.println("Numero errado, Tente outra vez!");
//			menu();
//			break;
//		}
//	}
//	public int getOpcao() {
//		return opcao;
//	}
//
//	public void setOpcao(int opcao) {
//		this.opcao = opcao;
//	}
//
//	public void sendTransmitida() {
//		this.e.setTramaTransmitida(Transmitida);
//		System.out.println("Trama Transmitida -> D:" + Transmitida);
//	}
//
//	public void sendErroPadrao() {
//		this.e.setErroPadrao(ErroPadrao);
//		System.out.println("Padrão de Erro -> E:" + ErroPadrao);
//	}
//
//	public Trama getTransmitida() {
//		return Transmitida;
//	}
//
//	public Trama getErroPadrao() {
//		return ErroPadrao;
//	}
//
//	public static void menu() {
//		System.out.println("Escolha da técnica (1:Bit paridade, 2:Hamming, 3:CRC)");
//	}
//
//	public static void bits_dados(Scanner scanner) {
//		System.out.print("Bits de Dados -> D:");
//		String bits = scanner.next();
//		trama_bits = new Trama(bits);
//
//	}
//	
//
//	private static void padra_erro(Scanner scanner) {
//		System.out.print("Padrão de Erro -> R:");
//		String erro = scanner.next();
//		ErroPadrao = new Trama(erro);
//	}
//	
////	public Trama bit_dados1(){
////		Random r= new Random();
////		int i=0;
////		while(i<11){
////			int bits =  r.nextInt(1);
////			trama_bits = new Trama(trama_bits.getTrama());
////			trama_bits.getTrama().add(bits);
////		
////		}
////		System.out.println("trama:" + trama_bits);
////		return trama_bits;
////		
////	}
//
//	
//}
