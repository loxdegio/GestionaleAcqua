package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextArea;

import database.Database;

public class GestioneDeposito extends JFrame {

	private JPanel contentPane;
	private JTextField txtCariconat;
	private JTextField txtCaricofriz;

	/**
	 * Create the frame.
	 */
	public GestioneDeposito() {
		setTitle("Gestione Deposito");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JTextArea txtrCarichiPrecedenti = new JTextArea();
		txtrCarichiPrecedenti.setEditable(false);
		txtrCarichiPrecedenti.setRows(SceltaAzione.db.getNCarichi(database.Database.frizzante) + SceltaAzione.db.getNCarichi(database.Database.naturale));
		GridBagConstraints gbc_txtrCarichiPrecedenti = new GridBagConstraints();
		gbc_txtrCarichiPrecedenti.insets = new Insets(0, 0, 5, 5);
		gbc_txtrCarichiPrecedenti.fill = GridBagConstraints.BOTH;
		gbc_txtrCarichiPrecedenti.gridx = 5;
		gbc_txtrCarichiPrecedenti.gridy = 1;
		for(int i=0;i<2;i++){
			for(int j=0;j<SceltaAzione.db.getNCarichi(i);j++){
				txtrCarichiPrecedenti.append(SceltaAzione.db.getCarico(i,j));
			}					
		}
		contentPane.add(txtrCarichiPrecedenti, gbc_txtrCarichiPrecedenti);
		
		JLabel lblNaturali = new JLabel("Naturali");
		GridBagConstraints gbc_lblNaturali = new GridBagConstraints();
		gbc_lblNaturali.insets = new Insets(0, 0, 5, 5);
		gbc_lblNaturali.gridx = 3;
		gbc_lblNaturali.gridy = 3;
		contentPane.add(lblNaturali, gbc_lblNaturali);
		
		JLabel lblFrizzanti = new JLabel("Frizzanti");
		GridBagConstraints gbc_lblFrizzanti = new GridBagConstraints();
		gbc_lblFrizzanti.gridwidth = 2;
		gbc_lblFrizzanti.insets = new Insets(0, 0, 5, 5);
		gbc_lblFrizzanti.gridx = 6;
		gbc_lblFrizzanti.gridy = 3;
		contentPane.add(lblFrizzanti, gbc_lblFrizzanti);
		
		JLabel lblTotali = new JLabel("Totali");
		GridBagConstraints gbc_lblTotali = new GridBagConstraints();
		gbc_lblTotali.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotali.gridx = 1;
		gbc_lblTotali.gridy = 5;
		contentPane.add(lblTotali, gbc_lblTotali);
		
		JLabel lblNattot = new JLabel(Integer.toString(SceltaAzione.db.getTotali(1)));
		GridBagConstraints gbc_lblNattot = new GridBagConstraints();
		gbc_lblNattot.insets = new Insets(0, 0, 5, 5);
		gbc_lblNattot.gridx = 3;
		gbc_lblNattot.gridy = 5;
		contentPane.add(lblNattot, gbc_lblNattot);
		
		JLabel lblFriztot = new JLabel(Integer.toString(SceltaAzione.db.getTotali(0)));
		GridBagConstraints gbc_lblFriztot = new GridBagConstraints();
		gbc_lblFriztot.insets = new Insets(0, 0, 5, 5);
		gbc_lblFriztot.gridx = 7;
		gbc_lblFriztot.gridy = 5;
		contentPane.add(lblFriztot, gbc_lblFriztot);
		
		JLabel lblPresenti = new JLabel("Presenti");
		GridBagConstraints gbc_lblPresenti = new GridBagConstraints();
		gbc_lblPresenti.insets = new Insets(0, 0, 5, 5);
		gbc_lblPresenti.gridx = 1;
		gbc_lblPresenti.gridy = 7;
		contentPane.add(lblPresenti, gbc_lblPresenti);
		
		JLabel lblNatpres = new JLabel(Integer.toString(SceltaAzione.db.getRimanenti(1)));
		GridBagConstraints gbc_lblNatpres = new GridBagConstraints();
		gbc_lblNatpres.insets = new Insets(0, 0, 5, 5);
		gbc_lblNatpres.gridx = 3;
		gbc_lblNatpres.gridy = 7;
		contentPane.add(lblNatpres, gbc_lblNatpres);
		
		JLabel lblFrizpres = new JLabel(Integer.toString(SceltaAzione.db.getRimanenti(0)));
		GridBagConstraints gbc_lblFrizpres = new GridBagConstraints();
		gbc_lblFrizpres.insets = new Insets(0, 0, 5, 5);
		gbc_lblFrizpres.gridx = 7;
		gbc_lblFrizpres.gridy = 7;
		contentPane.add(lblFrizpres, gbc_lblFrizpres);
		
		JLabel lblPrelevate = new JLabel("Prelevate");
		GridBagConstraints gbc_lblPrelevate = new GridBagConstraints();
		gbc_lblPrelevate.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrelevate.gridx = 1;
		gbc_lblPrelevate.gridy = 9;
		contentPane.add(lblPrelevate, gbc_lblPrelevate);
		
		JLabel lblNatprel = new JLabel(Integer.toString(SceltaAzione.db.getPrelevati(1)));
		GridBagConstraints gbc_lblNatprel = new GridBagConstraints();
		gbc_lblNatprel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNatprel.gridx = 3;
		gbc_lblNatprel.gridy = 9;
		contentPane.add(lblNatprel, gbc_lblNatprel);
		
		JLabel lblFrizprel = new JLabel(Integer.toString(SceltaAzione.db.getPrelevati(0)));
		GridBagConstraints gbc_lblFrizprel = new GridBagConstraints();
		gbc_lblFrizprel.insets = new Insets(0, 0, 5, 5);
		gbc_lblFrizprel.gridx = 7;
		gbc_lblFrizprel.gridy = 9;
		contentPane.add(lblFrizprel, gbc_lblFrizprel);
		
		JLabel lblCarico = new JLabel("Effettua Carico");
		GridBagConstraints gbc_lblCarico = new GridBagConstraints();
		gbc_lblCarico.insets = new Insets(0, 0, 5, 5);
		gbc_lblCarico.gridx = 1;
		gbc_lblCarico.gridy = 11;
		contentPane.add(lblCarico, gbc_lblCarico);
		
		txtCariconat = new JTextField();
		txtCariconat.setText("0");
		GridBagConstraints gbc_txtCariconat = new GridBagConstraints();
		gbc_txtCariconat.insets = new Insets(0, 0, 5, 5);
		gbc_txtCariconat.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCariconat.gridx = 3;
		gbc_txtCariconat.gridy = 11;
		contentPane.add(txtCariconat, gbc_txtCariconat);
		txtCariconat.setColumns(10);
		
		txtCaricofriz = new JTextField();
		txtCaricofriz.setText("0");
		GridBagConstraints gbc_txtCaricofriz = new GridBagConstraints();
		gbc_txtCaricofriz.insets = new Insets(0, 0, 5, 5);
		gbc_txtCaricofriz.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCaricofriz.gridx = 7;
		gbc_txtCaricofriz.gridy = 11;
		contentPane.add(txtCaricofriz, gbc_txtCaricofriz);
		txtCaricofriz.setColumns(10);
		
		JButton btnEffettuaCarico = new JButton("Effettua Carico");
		btnEffettuaCarico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GregorianCalendar gc = new GregorianCalendar();
				int giorno=gc.get(Calendar.DATE);
				int mese=gc.get(Calendar.MONTH)+1;
				int anno=gc.get(Calendar.YEAR);
				String data=new String(Integer.toString(giorno)).concat("/");
				data.concat(Integer.toString(mese)).concat("/").concat(Integer.toString(anno));
				
				String cf = txtCaricofriz.getText();
				String cn = txtCariconat.getText();
				
				if(cf.compareTo("0")!=0){
					int qta=Integer.parseInt(cf);
					SceltaAzione.db.setCarico(data,database.Database.frizzante,qta);
					txtCaricofriz.setText("0");
					SceltaAzione.modificato=true;
				}
				
				if(cn.compareTo("0")!=0){
					int qta=Integer.parseInt(cf);
					SceltaAzione.db.setCarico(data,database.Database.naturale,qta);
					txtCariconat.setText("0");
					SceltaAzione.modificato=true;
				}
			}
		});
		GridBagConstraints gbc_btnEffettuaCarico = new GridBagConstraints();
		gbc_btnEffettuaCarico.gridwidth = 2;
		gbc_btnEffettuaCarico.insets = new Insets(0, 0, 5, 5);
		gbc_btnEffettuaCarico.gridx = 4;
		gbc_btnEffettuaCarico.gridy = 12;
		contentPane.add(btnEffettuaCarico, gbc_btnEffettuaCarico);
	}

}
