package database;

import java.util.StringTokenizer;

public class Utente {
	private String utente;
	private int[] cassePrelevate, nPrelievi;
	
	protected Utente(String nome, String cognome) {
		this.utente=cognome.concat(" ").concat(nome);
		this.cassePrelevate=new	int[2];
		this.nPrelievi=new int[2];
		for(int i=0;i<2;i++){
			this.cassePrelevate[i]=0;
			this.nPrelievi[i]=0;
		}
	}
	
	protected Utente(String utente, int frizzanti, int nPrelieviF, int naturali, int nPrelieviN){
		this.utente=utente;
		this.cassePrelevate[Database.frizzante]=frizzanti;
		this.nPrelievi[Database.frizzante]=nPrelieviF;
		this.cassePrelevate[Database.naturale]=naturali;
		this.nPrelievi[Database.naturale]=nPrelieviN;
	}
	
	protected Utente(String s){
		StringTokenizer st= new StringTokenizer(s,";");
		this.utente=st.nextToken();
		for(int i=0;i<2;i++){
			this.nPrelievi[i]=Integer.parseInt(st.nextToken());
			this.cassePrelevate[i]=Integer.parseInt(st.nextToken());
		}
	}
	
	protected String getUtente() {
		return this.utente;
	}
	
	protected int getCassePrelevate(int tipoAcqua) { 
		return this.cassePrelevate[tipoAcqua]; 
	}
	
	protected void setPrelievo(int tipoAcqua, int qta) { 
		this.cassePrelevate[tipoAcqua]+=qta; 
		this.nPrelievi[tipoAcqua]++;
	}
	
	@Override
	public String toString(){
		String s=this.utente;
		s.concat(Integer.toString(nPrelievi[0])).concat(",").concat(Integer.toString(cassePrelevate[0])).concat(",");
		s.concat(Integer.toString(nPrelievi[1])).concat(",").concat(Integer.toString(cassePrelevate[1])).concat(",");
		return s;
	}
}
