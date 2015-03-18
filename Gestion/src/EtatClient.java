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
public class EtatClient extends javax.swing.JDialog {
	class Actionec implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == ok) {
				setVisible(false);
			}
			if (e.getSource() == recherche) {
				if (e.getSource() == recherche) {
					if (!recherchet1.getText().equals("")
							&& !recherchet2.getText().equals("")) {
						String s, ss;
						s = (String) recherche1.getSelectedItem();
						ss = (String) recherche2.getSelectedItem();
						if (s.equalsIgnoreCase("Identification")) {
							s = "Identification_C";
						} else if (s.equalsIgnoreCase("Nom Du Client")) {
							s = "Nom";
						} else if (s.equalsIgnoreCase("Prenom Du Client")) {
							s = "Prenom";
						} else if (s.equalsIgnoreCase("Profession")) {
							s = "Profession";
						} else if (s.equalsIgnoreCase("Telephone")) {
							s = "Telephone";
						}
						if (ss.equalsIgnoreCase("Identification")) {
							ss = "Identification_C";
						} else if (ss.equalsIgnoreCase("Nom Du Client")) {
							ss = "Nom";
						} else if (ss.equalsIgnoreCase("Prenom Du Client")) {
							ss = "Prenom";
						} else if (ss.equalsIgnoreCase("Profession")) {
							ss = "Profession";
						} else if (ss.equalsIgnoreCase("Telephone")) {
							ss = "Telephone";
						}
						try {
							Statement stmt = Fenetre.getConnection()
									.createStatement();
							ResultSet r = stmt
									.executeQuery("SELECT * FROM Client WHERE "
											+ s + " =" + recherchet1.getText()
											+ " AND " + ss + " ="
											+ recherchet2.getText() + ";");
							int k = 0;
							String data[][] = null;
							while (r.next()) {
								k++;
							}
							data = new String[k][5];
							r.beforeFirst();
							r.next();
							for (int i = 0; i < k; i++) {
								data[i][0] = r.getString("Identification_C");
								data[i][1] = r.getString("Nom");
								data[i][2] = r.getString("Prenom");
								data[i][3] = r.getString("Profession");
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
							ss = "Identification_C";
						} else if (ss.equalsIgnoreCase("Nom Du Client")) {
							ss = "Nom";
						} else if (ss.equalsIgnoreCase("Prenom Du Client")) {
							ss = "Prenom";
						} else if (ss.equalsIgnoreCase("Profession")) {
							ss = "Profession";
						} else if (ss.equalsIgnoreCase("Telephone")) {
							ss = "Telephone";
						}
						try {
							Statement stmt = Fenetre.getConnection()
									.createStatement();
							ResultSet r = stmt
									.executeQuery("SELECT * FROM Client WHERE "
											+ ss + " = "
											+ recherchet2.getText() + ";");
							int k = 0;
							String data[][] = null;
							while (r.next()) {
								k++;
							}
							data = new String[k][5];
							r.beforeFirst();
							r.next();
							for (int i = 0; i < k; i++) {
								data[i][0] = r.getString("Identification_P");
								data[i][1] = r.getString("Nom");
								data[i][2] = r.getString("Prenom");
								data[i][3] = r.getString("Profession");
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
							s = "Identification_C";
						} else if (s.equalsIgnoreCase("Nom Du Client")) {
							s = "Nom";
						} else if (s.equalsIgnoreCase("Prenom Du Client")) {
							s = "Prenom";
						} else if (s.equalsIgnoreCase("Profession")) {
							s = "Profession";
						} else if (s.equalsIgnoreCase("Telephone")) {
							s = "Telephone";
						}
						try {
							Statement stmt = Fenetre.getConnection()
									.createStatement();
							ResultSet r = stmt
									.executeQuery("SELECT * FROM Client WHERE "
											+ s + " = " + recherchet1.getText()
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
								data[i][0] = r.getString("Identification_C");
								data[i][1] = r.getString("Nom");
								data[i][2] = r.getString("Prenom");
								data[i][3] = r.getString("Profession");
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
	}

	private javax.swing.JLabel jLabel1;

	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel2;

	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton ok;
	private javax.swing.JButton recherche;
	private javax.swing.JComboBox recherche1;
	private javax.swing.JComboBox recherche2;
	private javax.swing.JTextField recherchet1;
	private javax.swing.JTextField recherchet2;
	private javax.swing.JTable table;

	public EtatClient() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C.\\images\\fenetre.png"));
	}

	/**
	 * Creates new form EtatClient
	 */
	public EtatClient(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		reinittab();
		ok.addActionListener(new Actionec());
		recherche.addActionListener(new Actionec());
	}

	// End of variables declaration
	public String[][] element() {
		int k = 0;
		String data[][] = null;
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM Client");
			while (res.next()) {
				k++;
			}
			data = new String[k][5];
			res.beforeFirst();
			res.next();
			for (int i = 0; i < k; i++) {
				data[i][0] = res.getString("Identification_C");
				data[i][1] = res.getString("Nom");
				data[i][2] = res.getString("Prenom");
				data[i][3] = res.getString("Profession");
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
				"Identification", "Nom Du Client", "Prenom Du Client",
				"Profession", "Telephone" }));

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel2.setText("RECHERCHE :");

		jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		jLabel1.setText("ETAT DES CLIENTS");

		recherche1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Identification", "Nom Du Client", "Prenom Du Client",
				"Profession", "Telephone" }));

		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Identification", "Nom Du Client",
				"Prenom Du Client", "Profession", "Telephone" }) {
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
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jLabel1)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel2)
																								.addGap(18,
																										18,
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
																								.addGap(18,
																										18,
																										18)
																								.addComponent(
																										recherche2,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										127,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))
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
								.addComponent(ok).addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(52, 52, 52)
								.addComponent(jLabel1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										107, Short.MAX_VALUE)
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
		String[] s = { "Identification", "Nom Du Client", "Prenom Du Client",
				"Profession", "Telephone" };
		TableModel model = new DefaultTableModel(f, s);
		table.setModel(model);
		table.revalidate();
	}

	/**
	 * Permet de mettre a jour le tableauu des etudiants
	 */
	public void reinittab1(String[][] f) {

		String[] s = { "Identification", "Nom Du Client", "Prenom Du Client",
				"Profession", "Telephone" };
		TableModel model = new DefaultTableModel(f, s);
		table.setModel(model);
		table.revalidate();
	}
}
