package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;

import database.Database;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SceltaAzione extends JFrame {

	private JPanel contentPane;
	protected static Database db;
	protected static boolean modificato=true;

	/**
	 * Create the frame.
	 */
	public SceltaAzione(final Database db) {
		this.db=db;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Scegli un'azione");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[100px][][][][100px]", "[25px][][][][][][][]"));
		
		JButton btnGestisciDeposito = new JButton("Gestisci deposito");
		btnGestisciDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestioneDeposito gd= new GestioneDeposito();
				gd.setVisible(true);
			}
		});
		contentPane.add(btnGestisciDeposito, "cell 2 1,alignx center,aligny center");
		
		JButton btnGestisciPrelievi_1 = new JButton("Gestisci prelievi");
		btnGestisciPrelievi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionePrelievi gp=new GestionePrelievi();
				gp.setVisible(true);
			}
		});
		contentPane.add(btnGestisciPrelievi_1, "cell 2 3,alignx center,aligny center");
		
		JButton btnGestisciUtenti = new JButton("Gestisci utenti");
		contentPane.add(btnGestisciUtenti, "cell 2 5,alignx center,aligny center");
		
		JButton btnSalvaModifiche = new JButton("Salva modifiche");
		btnSalvaModifiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SceltaAzione.db.salva();
			}
		});
		contentPane.add(btnSalvaModifiche, "cell 2 7,alignx center,aligny center");
	}

}
