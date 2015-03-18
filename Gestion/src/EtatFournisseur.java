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
public class EtatFournisseur extends javax.swing.JDialog {

	class Actionef implements ActionListener {

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
					System.out.println("s is " + s);
					ss = (String) recherche2.getSelectedItem();
					System.out.println("ss is " + ss);
					if (s.equalsIgnoreCase("Identification")) {
						s = "Identification_F";
					} else if (s.equalsIgnoreCase("Nom Du Fournisseur")) {
						s = "Nom";
					} else if (s.equalsIgnoreCase("Prenom Du Fournisseur")) {
						s = "Prenom";
					} else if (s.equalsIgnoreCase("Entreprise")) {
						s = "Entreprise";
					} else if (s.equalsIgnoreCase("Telephone")) {
						s = "Telephone";
					}
					System.out.println("s is now " + s);

					if (ss.equalsIgnoreCase("Identification")) {
						ss = "Identification_F";
					} else if (ss.equalsIgnoreCase("Nom Du Fournisseur")) {
						ss = "Nom";
					} else if (ss.equalsIgnoreCase("Prenom Du Fournisseur")) {
						ss = "Prenom";
					} else if (ss.equalsIgnoreCase("Entreprise")) {
						ss = "Entreprise";
					} else if (ss.equalsIgnoreCase("Telephone")) {
						ss = "Telephone";
					}
					System.out.println("ss is now " + ss);
					try {
						Statement stmt = Fenetre.getConnection()
								.createStatement();
						ResultSet r = stmt
								.executeQuery("SELECT * FROM Fournisseur WHERE "
										+ s
										+ " = \""
										+ recherchet1.getText()
										+ "\" AND "
										+ ss
										+ " = \""
										+ recherchet2.getText() + "\";");
						int k = 0;
						String data[][] = null;
						while (r.next()) {
							k++;
						}
						data = new String[k][5];
						r.beforeFirst();
						r.next();
						for (int i = 0; i < k; i++) {
							data[i][0] = r.getString("Identification_F");
							data[i][1] = r.getString("Nom");
							data[i][2] = r.getString("Prenom");
							data[i][3] = r.getString("Entreprise");
							data[i][4] = r.getString("Telephone");
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
						ss = "Identification_F";
					} else if (ss.equalsIgnoreCase("Nom Du Fournisseur")) {
						ss = "Nom";
					} else if (ss.equalsIgnoreCase("Prenom Du Fournisseur")) {
						ss = "Prenom";
					} else if (ss.equalsIgnoreCase("Entreprise")) {
						ss = "Entreprise";
					} else if (ss.equalsIgnoreCase("Telephone")) {
						ss = "Telephone";
					}
					try {
						Statement stmt = Fenetre.getConnection()
								.createStatement();
						ResultSet r = stmt
								.executeQuery("SELECT * FROM Fournisseur WHERE "
										+ ss
										+ " = "
										+ recherchet2.getText()
										+ ";");
						int k = 0;
						String data[][] = null;
						while (r.next()) {
							k++;
						}
						data = new String[k][5];
						r.beforeFirst();
						r.next();
						for (int i = 0; i < k; i++) {
							data[i][0] = r.getString("Identification_F");
							data[i][1] = r.getString("Nom");
							data[i][2] = r.getString("Prenom");
							data[i][3] = r.getString("Entreprise");
							data[i][4] = r.getString("Telephone");
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
						s = "Identification_F";
					} else if (s.equalsIgnoreCase("Nom Du Fournisseur")) {
						s = "Nom";
					} else if (s.equalsIgnoreCase("Prenom Du Fournisseur")) {
						s = "Prenom";
					} else if (s.equalsIgnoreCase("Entreprise")) {
						s = "Entreprise";
					} else if (s.equalsIgnoreCase("Telephone")) {
						s = "Telephone";
					}
					try {
						Statement stmt = Fenetre.getConnection()
								.createStatement();
						ResultSet r = stmt
								.executeQuery("SELECT * FROM Fournisseur WHERE "
										+ s
										+ " = "
										+ recherchet1.getText()
										+ ";");
						int k = 0;
						String data[][] = null;
						while (r.next()) {
							k++;
						}
						data = new String[k][5];
						r.beforeFirst();
						r.next();
						for (int i = 0; i < k; i++) {
							data[i][0] = r.getString("Identification_F");
							data[i][1] = r.getString("Nom");
							data[i][2] = r.getString("Prenom");
							data[i][3] = r.getString("Entreprise");
							data[i][4] = r.getString("Telephone");
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
	 * Creates new form EtatFournisseur
	 */
	public EtatFournisseur(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				".\\images\\fenetre.png"));
		initComponents();
		reinittab();
		ok.addActionListener(new Actionef());
		recherche.addActionListener(new Actionef());
	}

	public String[][] element() {
		int k = 0;
		String data[][] = null;
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM Fournisseur");
			while (res.next()) {
				k++;
			}
			data = new String[k][5];
			res.beforeFirst();
			res.next();
			for (int i = 0; i < k; i++) {
				data[i][0] = res.getString("Identification_F");
				data[i][1] = res.getString("Nom");
				data[i][2] = res.getString("Prenom");
				data[i][3] = res.getString("Entreprise");
				data[i][4] = res.getString("Telephone");
				res.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		recherche1 = new javax.swing.JComboBox();
		jScrollPane1 = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		recherchet1 = new javax.swing.JTextField();
		recherche2 = new javax.swing.JComboBox();
		ok = new javax.swing.JButton();
		recherchet2 = new javax.swing.JTextField();
		recherche = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		recherche1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Identification", "Nom Du Fournisseur",
				"Prenom Du Fournisseur", "Entreprise", "Telephone" }));

		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Identification", "Nom Du Fournisseur",
				"Prenom Du Fournisseur", "Entreprise", "Telephone" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false };

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

		jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		jLabel1.setText("ETAT DES FOURNISSEURS");

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel2.setText("RECHERCHE :");

		recherche2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Identification", "Nom Du Fournisseur",
				"Prenom Du Fournisseur", "Entreprise", "Telephone" }));

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
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addComponent(jLabel1)
								.addGap(317, 317, 317))
				.addGroup(
						layout.createSequentialGroup()
								.addGap(384, 384, 384)
								.addComponent(ok)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(94, Short.MAX_VALUE)
								.addComponent(jLabel1)
								.addGap(62, 62, 62)
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
		String[] s = { "Identification", "Nom Du Fournisseur",
				"Prenom Du Fournisseur", "Entreprise", "Telephone" };
		TableModel model = new DefaultTableModel(f, s);
		table.setModel(model);
		table.revalidate();
	}

	/**
	 * Permet de mettre a jour le tableauu des etudiants
	 */
	public void reinittab1(String[][] f) {
		String[] s = { "Identification", "Nom Du Fournisseur",
				"Prenom Du Fournisseur", "Entreprise", "Telephone" };
		TableModel model = new DefaultTableModel(f, s);
		table.setModel(model);
		table.revalidate();
	}
}
