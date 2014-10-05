package database;

public class Acqua {
	private int qta;
	
	protected Acqua(){
		qta=0;
	}
	
	protected void setQta(int qta){
		this.qta=qta;
	}
	
	protected void carico(int qta){
		this.qta+=qta;
	}
	
	protected void prelievo(int qta){
		this.qta-=qta;
	}

	protected int getQta() {
		return qta;
	}
	
	@Override
	public String toString() {
		return Integer.toString(qta);
	}
}
