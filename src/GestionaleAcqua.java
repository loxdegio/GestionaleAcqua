import gui.SceltaAzione;
import database.Database;



public class GestionaleAcqua {

	public static void main(String[] args) {
		Database db= new Database(0,0);
		SceltaAzione sa=null;
		
		db.carica();
		
		sa=new SceltaAzione(db);
		sa.setVisible(true);
	}

}
