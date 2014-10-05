package database;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Deposito {

	private Acqua[] deposito;
	private List<Prelievo>[] prelievi, carichi;
	private int[] totali, prelevati;
	
	protected Deposito(int naturali, int frizzanti){
		this.totali= new int[2];
		this.prelevati= new int[2];
		this.deposito = new Acqua[2];
		this.prelievi= new LinkedList[2];
		this.carichi= new LinkedList[2];
		for(int i=0; i<2; i++){
			this.deposito[i]=new Acqua();
			this.prelievi[i]=new LinkedList<Prelievo>();
			this.carichi[i]=new LinkedList<Prelievo>();
		}
		deposito[Database.frizzante].setQta(frizzanti);
		deposito[Database.naturale].setQta(naturali);
	}
	
	protected int getTotali(int tipoAcqua) {
		return this.totali[tipoAcqua];
	}
	
	protected int getPrelevati(int tipoAcqua) {
		return this.prelevati[tipoAcqua];
	}
	
	protected int getRimanenti(int tipoAcqua) {
		return this.deposito[tipoAcqua].getQta();
	}
	
	protected void setTotali(int frizzanti, int naturali){
		this.totali[Database.frizzante]+=frizzanti;
		this.totali[Database.naturale]+=naturali;
		this.prelevati[Database.frizzante]=this.totali[Database.frizzante]-this.deposito[Database.frizzante].getQta();
		this.prelevati[Database.naturale]=this.totali[Database.naturale]-this.deposito[Database.naturale].getQta();
	}
	
	protected void setPrelievo(int tipoAcqua, String data, String utente, int qta){
		Prelievo p= new Prelievo(data, utente, qta);
		this.deposito[tipoAcqua].prelievo(qta);
		this.prelievi[tipoAcqua].add(p);
		this.prelevati[tipoAcqua]+=qta;
	}
	
	protected void setCarico(int tipoAcqua, String data, int qta) {
		Prelievo p= new Prelievo(data, null, qta);
		this.deposito[tipoAcqua].carico(qta);
		this.prelievi[tipoAcqua].add(p);
		this.totali[tipoAcqua]+=qta;
	}

	protected List<Prelievo> getPrelievi(int tipoAcqua) {
		return this.prelievi[tipoAcqua];
	}

	protected List<Prelievo> getCarichi(int tipoAcqua) {
		return this.carichi[tipoAcqua];
	}
	
	@SuppressWarnings("deprecation")
	protected void salva() {
		File fu=new File("acqua.dat");
		if(!fu.exists()){
			try {
				if(fu.createNewFile())
					System.out.println("Il file acqua.dat è stato creato con successo");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			PrintStream out=new PrintStream(fu.toURL().openConnection().getOutputStream());
			out.println("frizzante," + Integer.toString(getRimanenti(Database.frizzante)));
			out.println("naturale," + Integer.toString(getRimanenti(Database.naturale)));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.salvaPrelievi(Database.frizzante);
		this.salvaPrelievi(Database.naturale);
		this.salvaCarichi(Database.frizzante);
		this.salvaCarichi(Database.naturale);
	}
	
	private void salvaCarichi(int tipoAcqua) {
		File fu=new File("carichi.dat");
		if(!fu.exists()){
			try {
				if(fu.createNewFile())
					System.out.println("Il file carichi.dat è stato creato con successo");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			PrintStream out=new PrintStream(fu.toURL().openConnection().getOutputStream());
			Iterator<Prelievo> i= carichi[tipoAcqua].listIterator();
			while(i.hasNext()){
				out.println(Integer.toString(tipoAcqua)+ "," + i.next().toString());
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void salvaPrelievi(int tipoAcqua){
		File fu=new File("prelievi.dat");
		if(!fu.exists()){
			try {
				if(fu.createNewFile())
					System.out.println("Il file prelievi.dat è stato creato con successo");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			PrintStream out=new PrintStream(fu.toURL().openConnection().getOutputStream());
			Iterator<Prelievo> i= prelievi[tipoAcqua].listIterator();
			while(i.hasNext()){
				out.println(Integer.toString(tipoAcqua)+ "," + i.next().toString());
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void carica() {
		// TODO : carico da file *statici*
	}
}
