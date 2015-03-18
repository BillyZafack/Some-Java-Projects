import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Zafack Billy
 */
public class EtatStock extends javax.swing.JDialog {

	class Actiones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == ok) {
				setVisible(false);
			}
			if (e.getSource() == recherche) {
				if (!recherchet1.getText().equals("")
						&& !recherchet2.getText().equals("")) {
					String s, ss;
					s = (String) recherche1.getSelectedItem();
					ss = (String) recherche2.getSelectedItem();
					if (s.equalsIgnoreCase("Identification")) {
						s = "Identification_P";
					} else if (s.equalsIgnoreCase("Nom Du Produit")) {
						s = "Nom";
					} else if (s.equalsIgnoreCase("Unité De Mésure")) {
						s = "Unite";
					} else if (s.equalsIgnoreCase("No D'Unites en Stock ")) {
						s = "NbUnite";
					} else if (s.equalsIgnoreCase("Prix D\'Achat")) {
						s = "PrixAchat";
					} else if (s.equalsIgnoreCase("Prix De Vente")) {
						s = "PrixVente";
					}
					if (ss.equalsIgnoreCase("Identification")) {
						ss = "Identification_P";
					} else if (ss.equalsIgnoreCase("Nom Du Produit")) {
						ss = "Nom";
					} else if (ss.equalsIgnoreCase("Unité De Mésure")) {
						ss = "Unite";
					} else if (s.equalsIgnoreCase("No D'Unites en Stock ")) {
						ss = "NbUnite";
					} else if (ss.equalsIgnoreCase("Prix D\'Achat")) {
						ss = "PrixAchat";
					} else if (ss.equalsIgnoreCase("Prix De Vente")) {
						ss = "PrixVente";
					}
					try {
						Statement stmt = Fenetre.getConnection()
								.createStatement();
						ResultSet r = stmt
								.executeQuery("SELECT * FROM Stock WHERE " + s
										+ " = \"" + recherchet1.getText()
										+ "\" AND " + ss + " = \""
										+ recherchet2.getText() + "\";");
						int k = 0;
						String data[][] = null;
						while (r.next()) {
							k++;
						}
						data = new String[k][6];
						r.beforeFirst();
						r.next();
						for (int i = 0; i < k; i++) {
							data[i][0] = r.getString("Identification_P");
							data[i][1] = r.getString("Nom");
							data[i][2] = r.getString("Unite");
							data[i][3] = r.getString("NbUnite");
							data[i][4] = r.getString("PrixAchat");
							data[i][5] = r.getString("PrixVente");
							r.next();
						}
						reinittab1(data);
					} catch (SQLException l) {
						l.printStackTrace();
					}
				} else if (recherchet1.getText().equals("")
						&& !recherchet2.getText().equals("")) {
					String ss;
					ss = (String) recherche2.getSelectedItem();

					if (ss.equalsIgnoreCase("Identification")) {
						ss = "Identification_P";
					} else if (ss.equalsIgnoreCase("Nom Du Produit")) {
						ss = "Nom";
					} else if (ss.equalsIgnoreCase("Unité De Mésure")) {
						ss = "Unite";
					} else if (ss.equalsIgnoreCase("No D'Unites en Stock ")) {
						ss = "NbUnite";
					} else if (ss.equalsIgnoreCase("Prix D\'Achat")) {
						ss = "PrixAchat";
					} else if (ss.equalsIgnoreCase("Prix De Vente")) {
						ss = "PrixVente";
					}
					try {
						Statement stmt = Fenetre.getConnection()
								.createStatement();
						ResultSet r = stmt
								.executeQuery("SELECT * FROM Produit WHERE "
										+ ss + " = " + recherchet2.getText()
										+ ";");
						int k = 0;
						String data[][] = null;
						while (r.next()) {
							k++;
						}
						data = new String[k][6];
						r.beforeFirst();
						r.next();
						for (int i = 0; i < k; i++) {
							data[i][0] = r.getString("Identification_P");
							data[i][1] = r.getString("Nom");
							data[i][2] = r.getString("Unite");
							data[i][3] = r.getString("NbUnite");
							data[i][4] = r.getString("PrixAchat");
							data[i][5] = r.getString("PrixVente");
							r.next();
						}
						reinittab1(data);
					} catch (SQLException l) {
						l.printStackTrace();
					}
				} else if (!recherchet1.getText().equals("")
						&& recherchet2.getText().equals("")) {
					String s;
					s = (String) recherche2.getSelectedItem();

					if (s.equalsIgnoreCase("Identification")) {
						s = "Identification_P";
					} else if (s.equalsIgnoreCase("Nom Du Produit")) {
						s = "Nom";
					} else if (s.equalsIgnoreCase("Unité De Mésure")) {
						s = "Unite";
					} else if (s.equalsIgnoreCase("No D'Unites en Stock ")) {
						s = "NbUnite";
					} else if (s.equalsIgnoreCase("Prix D\'Achat")) {
						s = "PrixAchat";
					} else if (s.equalsIgnoreCase("Prix De Vente")) {
						s = "PrixVente";
					}
					try {
						Statement stmt = Fenetre.getConnection()
								.createStatement();
						ResultSet r = stmt
								.executeQuery("SELECT * FROM Produit WHERE "
										+ s + " = " + recherchet1.getText()
										+ ";");
						int k = 0;
						String data[][] = null;
						while (r.next()) {
							k++;
						}
						data = new String[k][6];
						r.beforeFirst();
						r.next();
						for (int i = 0; i < k; i++) {
							data[i][0] = r.getString("Identification_P");
							data[i][1] = r.getString("Nom");
							data[i][2] = r.getString("Unite");
							data[i][3] = r.getString("Unite");
							data[i][4] = r.getString("PrixAchat");
							data[i][5] = r.getString("PrixVente");
							r.next();
						}
						reinittab1(data);
					} catch (SQLException l) {
						l.printStackTrace();
					}
				}
			}
		}

	}

	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;

	private javax.swing.JLabel jLabel2;

	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton ok;
	private javax.swing.JButton recherche;
	private javax.swing.JComboBox recherche1;
	private javax.swing.JComboBox recherche2;
	private javax.swing.JTextField recherchet1;
	private javax.swing.JTextField recherchet2;
	private javax.swing.JTable table;

	// End of variables declaration
	/**
	 * Creates new form EtatStock
	 */
	public EtatStock(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				".\\images\\fenetre.png"));
		initComponents();
		reinittab();
		ok.addActionListener(new Actiones());
		recherche.addActionListener(new Actiones());
	}

	public String[][] element() {
		int k = 0;
		String data[][] = null;
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM Stock");
			while (res.next()) {
				k++;
			}
			data = new String[k][6];
			res.beforeFirst();
			res.next();
			for (int i = 0; i < k; i++) {
				data[i][0] = getIDD(res.getInt("ProduitID"));
				data[i][1] = res.getString("Nom");
				data[i][2] = res.getString("Unite");
				data[i][3] = res.getString("NbUnite");
				data[i][4] = res.getString("PrixAchat");
				data[i][5] = res.getString("PrixVente");
				res.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;

	}

	public String getIDD(int n) {
		String d = null;
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet r = stmt
					.executeQuery("SELECT Identification_P FROM Produit WHERE ProduitID="
							+ n);
			r.next();
			d = r.getString("Identification_P");
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return d;
	}

	public String getNom(String n) {
		String d = null;
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet r = stmt
					.executeQuery("SELECT Nom FROM Produit WHERE Identification_P="
							+ n);
			r.next();
			d = r.getString("Nom");
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return d;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		recherche2 = new javax.swing.JComboBox();
		recherchet1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		recherche1 = new javax.swing.JComboBox();
		jScrollPane1 = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();
		ok = new javax.swing.JButton();
		recherchet2 = new javax.swing.JTextField();
		recherche = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		recherche2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Identification", "Nom Du Produit", "Unité De Mésure",
				"Prix D'Achat", "Prix De Vente" }));

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel2.setText("RECHERCHE :");

		jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		jLabel1.setText("ETAT DU STOCK");

		recherche1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Identification", "Nom Du Produit", "Unité De Mésure",
				"Prix D'Achat", "Prix De Vente" }));

		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Identification", "Nom Du Produit",
				"Unité De Mésure", "No D'Unites en Stock ", "Prix D'Achat ",
				"Prix De Vente" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false };

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(table);

		ok.setText("OK");
		ok.setIcon(new ImageIcon(".\\images\\ok.png"));
		recherche.setText("Recherche");
		recherche.setIcon(new ImageIcon(".\\images\\search.png"));
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jScrollPane1)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		jLabel2)
																.addGap(18, 18,
																		18)
																.addComponent(
																		recherche1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		127,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		recherchet1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		154,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		recherche2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		127,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		recherchet2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		160,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		recherche)
																.addGap(0,
																		0,
																		Short.MAX_VALUE)))
								.addContainerGap())
				.addGroup(
						layout.createSequentialGroup().addGap(407, 407, 407)
								.addComponent(ok).addGap(0, 0, Short.MAX_VALUE))
				.addGroup(
						layout.createSequentialGroup()
								.addGap(344, 344, 344)
								.addComponent(jLabel1)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(86, Short.MAX_VALUE)
								.addComponent(jLabel1)
								.addGap(68, 68, 68)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(
														recherche1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														recherche2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														recherchet1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														recherchet2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(recherche))
								.addGap(36, 36, 36)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										231,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(21, 21, 21).addComponent(ok)
								.addContainerGap()));

		pack();
	}// </editor-fold>

	/**
	 * Permet de mettre a jour le tableauu des etudiants
	 */
	public void reinittab() {
		String[][] f = element();
		String[] s = { "Identification", "Nom Du Produit", "Unité De Mésure",
				"No D'Unites en Stock ", "Prix D'Achat ", "Prix De Vente" };
		TableModel model = new DefaultTableModel(f, s);
		table.setModel(model);
		table.revalidate();
	}

	/**
	 * Permet de mettre a jour le tableauu des etudiants
	 */
	public void reinittab1(String[][] f) {

		String[] s = { "Identification", "Nom Du Produit", "Unité De Mésure",
				"No D'Unites en Stock ", "Prix D'Achat ", "Prix De Vente" };
		TableModel model = new DefaultTableModel(f, s);
		table.setModel(model);
		table.revalidate();
	}
}
