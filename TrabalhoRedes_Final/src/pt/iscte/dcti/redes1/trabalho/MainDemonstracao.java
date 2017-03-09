//package pt.iscte.dcti.redes1.trabalho;
//
//import novoTrabalho.Hamming;
//
//public class MainDemonstracao {
//
//	public MainDemonstracao(){
//		Hamming m = new Hamming();
//		Receptor r = new Receptor(m);	
//		CanalRuidoso cr = new CanalRuidoso(r);
//		Emissor e = new Emissor(cr);
//		ModoDemonstracao dm = new ModoDemonstracao(e,m);
//		dm.sendTransmitida();
//		dm.sendErroPadrao();
//		e.sendErroPadrao();
//		e.sendTransmitida();
//	
//		cr.gerarTramaRecebida();
//		cr.sendTramaRecebida();
//		System.out.println("TRAMA RECEBIDA -> T :" + r.getTramaRecebida());
//		//r.getResto();
//		r.correcaoTrama(dm.getOpcao());
//	}
//	public static void main(String[] args) {
//		new MainDemonstracao();
//	}
//}
