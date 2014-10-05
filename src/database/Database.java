package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Database {
	
	public static int frizzante=0;
	public static int naturale=1;
	private Map<String,Utente> utenti;
	private Deposito deposito;
	
	public Database(int frizzanti, int naturali){
		utenti= new HashMap<String,Utente>();
		deposito= new Deposito(frizzanti, naturali);
	}
	
	public void addUtente(String nome, String cognome) {
		Utente u= new Utente(nome,cognome);
		utenti.put(u.getUtente(), u);
	}
	
	public void addUtente(String utente, int frizzanti, int nPrelieviF, int naturali, int nPrelieviN) {
		Utente u= new Utente(utente,frizzanti,nPrelieviF,naturali,nPrelieviN);
		utenti.put(u.getUtente(), u);
	}
	
	public void addUtente(String s) {
		Utente u= new Utente(s);
		utenti.put(u.getUtente(), u);
	}
	
	public String[] getUtenti() {
		String[] uta= new String[utenti.size()];
		int i=0;
		for(Utente u:utenti.values()) {
			uta[i]=u.getUtente();
			i++;
		}
		return uta;
	}
	
	public void setPrelievo(String utente, String data, int tipoAcqua, int qta) {
		Utente u=utenti.get(utente);
		u.setPrelievo(tipoAcqua, qta);
		deposito.setPrelievo(tipoAcqua, data, utente, qta);
		utenti.put(u.getUtente(), u);
	}
	
	public void setCarico(String data, int tipoAcqua, int qta) {
			deposito.setCarico(tipoAcqua, data, qta);
	}
	
	public int getNCarichi(int tipoAcqua) {
		return deposito.getCarichi(tipoAcqua).size();
	}
	
	public String getCarico(int tipoAcqua, int indice) {
		return deposito.getCarichi(tipoAcqua).get(indice).toString();
	}
	
	public int getTotali(int tipoAcqua) {
		return deposito.getTotali(tipoAcqua);
	}
	
	public int getPrelevati(int tipoAcqua) {
		return deposito.getPrelevati(tipoAcqua);
	}
	
	public int getRimanenti(int tipoAcqua) {
		return deposito.getRimanenti(tipoAcqua);
	}
	
	public int getNPrelievi(int tipoAcqua){
		return deposito.getPrelievi(tipoAcqua).size();
	}
	
	public String getPrelievo(int tipoAcqua, int indice) {
		String s=null;
		Prelievo p=deposito.getPrelievi(tipoAcqua).get(indice);
		if(tipoAcqua==frizzante)
			s=new String("frizzante,").concat(p.toString());
		if(tipoAcqua==naturale)
			s=new String("naturale,").concat(p.toString());
		return s;
	}
	
	public String getPrelievoUtente(String utente, int tipoAcqua, int indice) {
		String s=null;
		Prelievo p=deposito.getPrelievi(tipoAcqua).get(indice);
		if(p.effettuatoDa(utente)){
			if(tipoAcqua==frizzante)
				s=new String("frizzante,").concat(p.toString());
			if(tipoAcqua==naturale)
				s=new String("naturale,").concat(p.toString());
		}
		return s;
	}
	
	@SuppressWarnings("deprecation")
	public void salva() {
		this.deposito.salva();
		File f=new File("utenti.dat");
		if(!f.exists()){
			try {
				if(f.createNewFile())
					System.out.println("Il file utenti.dat è stato creato con successo");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		PrintStream out;
		try {
			out = new PrintStream(f.toURL().openConnection().getOutputStream());
			for(Utente u:utenti.values()){
				String s=u.toString();
				out.println(s);
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void carica() {
		String utente;
		this.deposito.carica();
		File f= new File("utenti.dat");
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(f.toURL().openStream()));
			while((utente=in.readLine())!=null){
				Utente u=new Utente(utente);
				utenti.put(u.getUtente(),u);
			}
		} catch (IOException e) {
			return;
		}				
	}
	
}
