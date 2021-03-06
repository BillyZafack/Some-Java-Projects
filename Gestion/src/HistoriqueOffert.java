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
public class HistoriqueOffert extends javax.swing.JDialog {

	class Actionho implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == ok) {
				setVisible(false);
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
	 * Creates new form HistoriqueOffert
	 */
	public HistoriqueOffert(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				".\\images\\fenetre.png"));
		initComponents();
		ok.addActionListener(new Actionho());
		reinittab();
	}

	public String[][] element() {
		int k = 0;
		String data[][] = null;
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM CadeauOffert");
			while (res.next()) {
				k++;
			}
			data = new String[k][5];
			res.beforeFirst();
			res.next();
			for (int i = 0; i < k; i++) {
				if (res.getString("ProduitID") == null) {
					data[i][1] = res.getString("Argent");
					data[i][4] = res.getString("Date");
				} else {
					data[i][0] = getNom(res.getString("ProduitID"));
					data[i][2] = res.getString("NbUnite");
					data[i][4] = res.getString("Date");
				}
				res.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	public String getNom(String n) {
		String d = null;
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet r = stmt
					.executeQuery("SELECT Nom FROM Produit WHERE ProduitID="
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

		recherche = new javax.swing.JButton();
		recherchet2 = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();
		ok = new javax.swing.JButton();
		recherche2 = new javax.swing.JComboBox();
		jLabel1 = new javax.swing.JLabel();
		recherchet1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		recherche1 = new javax.swing.JComboBox();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		recherche.setText("Recherche");

		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Nom Du Produit", "Quantité D'Argent", "No D'Unites",
				"Date" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false };

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
		recherche2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"model\tNom du Produit", "Quantité D'Argent",
				"No D'Unités Offert", "Date" }));

		jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		jLabel1.setText("HISTORIQUE DES CADEAUX OFFERTS");

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel2.setText("RECHERCHE :");

		recherche1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Nom du Produit", "Quantité D'Argent", "No D'Unités Offert",
				"Date" }));
		recherche1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				recherche1ActionPerformed(evt);
			}
		});
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
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addComponent(jLabel1)
								.addGap(245, 245, 245)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(71, Short.MAX_VALUE)
								.addComponent(jLabel1)
								.addGap(65, 65, 65)
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

	private void recherche1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * Permet de mettre a jour le tableauu des etudiants
	 */
	public void reinittab() {
		String[][] f = element();
		String[] s = { "Nom Du Produit", "Quantité D'Argent", "No D'Unites",
				"Date" };
		TableModel model = new DefaultTableModel(f, s);
		table.setModel(model);
		table.revalidate();
	}
}
