package database;

import java.util.StringTokenizer;

public class Prelievo {
	private String data, utente;
	private int qta;
	
	protected Prelievo(String data, String utente, int qta) {
		this.data=data;
		this.utente=utente;
		this.qta=qta;
	}
	
	protected Prelievo(String s) {
		StringTokenizer st= new StringTokenizer(s);
		this.utente=st.nextToken();
		this.qta=Integer.parseInt(st.nextToken());
		this.data=st.nextToken();
	}
	
	protected boolean effettuatoDa(String utente) {
		if(utente.compareTo(this.utente)==0) {
			return true;
		} 
		return false;
	}
	
	@Override
	public String toString() {
		String s;
		if(this.utente!=null){
			s=this.utente.concat(",");
			s.concat(Integer.toString(qta)).concat(",").concat(data);
		} else { 
			s=Integer.toString(qta).concat(",").concat(data);
		}		
		return s;
	}
}
