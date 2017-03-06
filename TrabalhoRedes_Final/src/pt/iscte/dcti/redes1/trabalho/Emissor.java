package pt.iscte.dcti.redes1.trabalho;

public class Emissor {
	private Trama tramaTransmitida;
	private Trama erroPadrao;
	private CanalRuidoso cr;

	public Emissor(CanalRuidoso cr){
		this.cr=cr;
	}
	

	public void setTramaTransmitida(Trama transmitida) {	
		this.tramaTransmitida=transmitida;
		
	}
	public void setErroPadrao(Trama erroPadrao) {
		this.erroPadrao=erroPadrao;
		
	}
	
	public void sendTransmitida(){
		this.cr.setTramaTransmitida(tramaTransmitida);
	}
	
	public void sendErroPadrao(){
		this.cr.setErroPadrao(erroPadrao);
	}
	
	
}
