package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JComboBox;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import database.Database;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionePrelievi extends JFrame {

	private JPanel contentPane;
	private JTextField txtNaturale;
	private JTextField txtFrizzante;
	private JTextField txtData;
	protected static JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	public GestionePrelievi() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblScegliUnNome = new JLabel("Scegli un nome");
		GridBagConstraints gbc_lblScegliUnNome = new GridBagConstraints();
		gbc_lblScegliUnNome.insets = new Insets(0, 0, 5, 0);
		gbc_lblScegliUnNome.gridx = 2;
		gbc_lblScegliUnNome.gridy = 1;
		contentPane.add(lblScegliUnNome, gbc_lblScegliUnNome);		
		comboBox = new JComboBox(SceltaAzione.db.getUtenti());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb = (JComboBox)arg0.getSource();
				String utente = (String)cb.getSelectedItem();
				cb.setName(utente);
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		contentPane.add(comboBox, gbc_comboBox);
		
		JLabel lblNaturale = new JLabel("Naturale");
		GridBagConstraints gbc_lblNaturale = new GridBagConstraints();
		gbc_lblNaturale.insets = new Insets(0, 0, 5, 0);
		gbc_lblNaturale.gridx = 2;
		gbc_lblNaturale.gridy = 3;
		contentPane.add(lblNaturale, gbc_lblNaturale);
		
		txtNaturale = new JTextField();
		txtNaturale.setText("0");
		GridBagConstraints gbc_txtNaturale = new GridBagConstraints();
		gbc_txtNaturale.insets = new Insets(0, 0, 5, 0);
		gbc_txtNaturale.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNaturale.gridx = 2;
		gbc_txtNaturale.gridy = 4;
		contentPane.add(txtNaturale, gbc_txtNaturale);
		txtNaturale.setColumns(10);
		
		JLabel lblFrizzante = new JLabel("Frizzante");
		GridBagConstraints gbc_lblFrizzante = new GridBagConstraints();
		gbc_lblFrizzante.insets = new Insets(0, 0, 5, 0);
		gbc_lblFrizzante.gridx = 2;
		gbc_lblFrizzante.gridy = 5;
		contentPane.add(lblFrizzante, gbc_lblFrizzante);
		
		txtFrizzante = new JTextField();
		txtFrizzante.setText("0");
		GridBagConstraints gbc_txtFrizzante = new GridBagConstraints();
		gbc_txtFrizzante.insets = new Insets(0, 0, 5, 0);
		gbc_txtFrizzante.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFrizzante.gridx = 2;
		gbc_txtFrizzante.gridy = 6;
		contentPane.add(txtFrizzante, gbc_txtFrizzante);
		txtFrizzante.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		GridBagConstraints gbc_lblData = new GridBagConstraints();
		gbc_lblData.insets = new Insets(0, 0, 5, 0);
		gbc_lblData.gridx = 2;
		gbc_lblData.gridy = 7;
		contentPane.add(lblData, gbc_lblData);
		
		txtData = new JTextField();
		txtData.setText("gg/mm/aaaa");
		GridBagConstraints gbc_txtData = new GridBagConstraints();
		gbc_txtData.insets = new Insets(0, 0, 5, 0);
		gbc_txtData.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtData.gridx = 2;
		gbc_txtData.gridy = 8;
		contentPane.add(txtData, gbc_txtData);
		txtData.setColumns(10);
		
		JButton btnConfermaPrelievo = new JButton("Conferma prelievo");
		btnConfermaPrelievo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u = comboBox.getName();
				int pf=Integer.parseInt(txtFrizzante.getText());
				int pn=Integer.parseInt(txtNaturale.getText());
				String data=txtData.getText();
				if(pf!=0){
					SceltaAzione.db.setPrelievo(u,data,database.Database.frizzante,pf);
					txtFrizzante.setText("0");
				}
				if(pn!=0) {
					SceltaAzione.db.setPrelievo(u,data,database.Database.naturale,pf);
					txtNaturale.setText("0");
				}
			}
		});
		GridBagConstraints gbc_btnConfermaPrelievo = new GridBagConstraints();
		gbc_btnConfermaPrelievo.gridx = 2;
		gbc_btnConfermaPrelievo.gridy = 9;
		contentPane.add(btnConfermaPrelievo, gbc_btnConfermaPrelievo);
	}

}
