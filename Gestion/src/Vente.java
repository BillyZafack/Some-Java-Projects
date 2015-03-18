import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.freixas.jcalendar.JCalendarCombo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Zafack Billy
 */
public class Vente extends javax.swing.JDialog {

	class Actionv implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == quitter) {
				setVisible(false);
			}
			if (e.getSource() == rc) {
				reinitCBox();
			}
			if (e.getSource() == rp) {
				reinitPBox();
			}

			if (e.getSource() == reprendre) {
				jTextField1.setText("");
				jTextField2.setText("");
			}
			if (e.getSource() == creerClient) {
				new Client(new Fenetre(), true).setVisible(true);
			}
			if (e.getSource() == creerProduit) {
				new Produit(new Fenetre(), true).setVisible(true);
			}
			if (e.getSource() == confirmer) {
				if (produit.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(Vente.this,
							"Veuillez choisir un produit!",
							"PRODUIT NON RENSEIGNE",
							JOptionPane.WARNING_MESSAGE);
				} else if (jTextField1.getText().equals("")) {
					JOptionPane.showMessageDialog(Vente.this,
							"Veuillez renseigner le nombre d'unités vendues!",
							"NOMBRE D'UNITES NON RENSEIGNE",
							JOptionPane.WARNING_MESSAGE);
				} else if (jTextField2.getText().equals("")) {
					JOptionPane.showMessageDialog(Vente.this,
							"Veuillez renseigner le prix de vente unitaire !",
							"PRIX DE VENTE UNITAIRE NON RENSEIGNE",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (getStock((String) produit.getSelectedItem()) >= Integer
							.parseInt(jTextField1.getText())) {
						insertionVente();
						decStock((String) produit.getSelectedItem(),
								Integer.parseInt(jTextField1.getText()));
						incCapital(Integer.parseInt(jTextField1.getText())
								* Integer.parseInt(jTextField2.getText()));
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(Vente.this,
								"Vous n'avez assez de ce produit en stock!!",
								"STOCK INSUFFISANT!!",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}

	}

	public static void decStock(String nom, int n) {
		int id;
		id = getPID(nom);
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet r = stmt
					.executeQuery("SELECT NbUnite FROM Stock WHERE ProduitID="
							+ id);
			r.next();
			int a = r.getInt("NbUnite");
			a = a - n;
			stmt.executeUpdate("UPDATE Stock SET NbUnite = " + a
					+ " WHERE ProduitID = " + id + ";");
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public static int getCID(String nom) {
		ResultSet s;
		int i = 0, j = 0;
		String nm = "";
		while (nom.charAt(j) != ' ') {
			j++;
		}
		nm = nom.substring(0, j + 1);
		try {
			PreparedStatement stmt = Fenetre.getConnection().prepareStatement(
					"SELECT ClientID FROM Client WHERE Nom=?");
			stmt.setString(1, nm);
			s = stmt.executeQuery();
			if (s.next()) {
				i = s.getInt("ClientID");
			} else {
				i = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static int getPID(String nom) {
		ResultSet s;
		int i = 0;
		try {
			PreparedStatement stmt = Fenetre.getConnection().prepareStatement(
					"SELECT ProduitID FROM Produit WHERE Nom=?");
			stmt.setString(1, nom);
			s = stmt.executeQuery();
			if (s.next()) {
				i = s.getInt("ProduitID");
			} else {
				i = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static int getStock(String nom) {
		int m = 0;
		int id = getPID(nom);
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet r = stmt
					.executeQuery("SELECT NbUnite FROM Stock WHERE ProduitID="
							+ id);
			r.next();
			System.out.println("FEFEREFEFERE " + r.getInt("NbUnite"));
			m = r.getInt("NbUnite");
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return m;
	}

	public static void incCapital(int a) {
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet r = stmt.executeQuery("SELECT Capital FROM Capital");
			r.next();
			int b = r.getInt("Capital");
			b = b + a;
			stmt.executeUpdate("UPDATE Capital SET Capital = " + b + ";");
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JButton confirmer;
	private javax.swing.JButton creerClient;
	private javax.swing.JButton creerProduit;
	private javax.swing.JComboBox clibox;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;

	private javax.swing.JButton quitter;
	private javax.swing.JButton reprendre;

	private JCalendarCombo date;

	private JComboBox produit;

	private JLabel label;
	private JButton rp;
	private JButton rc;

	// End of variables declaration
	/**
	 * Creates new form Ventes
	 */
	public Vente(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				".\\images\\fenetre.png"));
		initComponents();
		quitter.addActionListener(new Actionv());
		confirmer.addActionListener(new Actionv());
		creerClient.addActionListener(new Actionv());
		creerProduit.addActionListener(new Actionv());
		reprendre.addActionListener(new Actionv());
		rp.addActionListener(new Actionv());
		rc.addActionListener(new Actionv());
		reinitCBox();
		reinitPBox();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		date = new JCalendarCombo();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		creerProduit = new javax.swing.JButton();
		clibox = new javax.swing.JComboBox();
		creerClient = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		reprendre = new javax.swing.JButton();
		quitter = new javax.swing.JButton();
		confirmer = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		jLabel1.setText("VENTE");

		jLabel2.setText("PRODUIT : *");

		jLabel3.setText("CLIENT :");

		jLabel4.setText("NOMBRE D'UNITES : *");

		jLabel5.setText("PRIX DE VENTE UNITAIRE : *");

		jLabel6.setText("DATE DE VENTE :");

		creerProduit.setText("Creer Nouveau Produit");

		clibox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Anonyme" }));

		creerClient.setText("Creer Nouveau Client");

		reprendre.setText("Reprendre");

		quitter.setText("Quitter");

		confirmer.setText("Confirmer");

		produit = new JComboBox();

		label = new JLabel("FCFA");

		rp = new JButton("");
		rp.setIcon(new ImageIcon(".\\images\\refresh.png"));

		rc = new JButton("");
		rc.setIcon(new ImageIcon(".\\images\\refresh.png"));
		reprendre.setIcon(new ImageIcon(".\\images\\reprendre.png"));
		quitter.setIcon(new ImageIcon(".\\images\\annuler.png"));
		confirmer.setIcon(new ImageIcon(".\\images\\ajouter.png"));

		javax.swing.GroupLayout gl_jPanel1 = new javax.swing.GroupLayout(
				jPanel1);
		gl_jPanel1
				.setHorizontalGroup(gl_jPanel1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPanel1
										.createSequentialGroup()
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addGap(265)
																		.addComponent(
																				jLabel1))
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addGap(64)
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								jLabel2)
																						.addComponent(
																								jLabel3)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								jLabel5)
																						.addComponent(
																								jLabel6))
																		.addGap(7)
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								jTextField2,
																								Alignment.TRAILING,
																								GroupLayout.DEFAULT_SIZE,
																								223,
																								Short.MAX_VALUE)
																						.addComponent(
																								clibox,
																								0,
																								213,
																								Short.MAX_VALUE)
																						.addComponent(
																								jTextField1,
																								GroupLayout.DEFAULT_SIZE,
																								213,
																								Short.MAX_VALUE)
																						.addComponent(
																								produit,
																								0,
																								213,
																								Short.MAX_VALUE)
																						.addComponent(
																								date,
																								Alignment.TRAILING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								label,
																								GroupLayout.PREFERRED_SIZE,
																								47,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_jPanel1
																										.createSequentialGroup()
																										.addGroup(
																												gl_jPanel1
																														.createParallelGroup(
																																Alignment.LEADING,
																																false)
																														.addComponent(
																																creerProduit,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																creerClient,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE))
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addGroup(
																												gl_jPanel1
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																rc,
																																GroupLayout.PREFERRED_SIZE,
																																33,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																rp,
																																GroupLayout.PREFERRED_SIZE,
																																33,
																																GroupLayout.PREFERRED_SIZE)))))
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addGap(74)
																		.addComponent(
																				reprendre,
																				GroupLayout.PREFERRED_SIZE,
																				109,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(55)
																		.addComponent(
																				confirmer,
																				GroupLayout.PREFERRED_SIZE,
																				142,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(72)
																		.addComponent(
																				quitter,
																				GroupLayout.PREFERRED_SIZE,
																				109,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		gl_jPanel1
				.setVerticalGroup(gl_jPanel1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPanel1
										.createSequentialGroup()
										.addGap(54)
										.addComponent(jLabel1)
										.addGap(28)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																creerProduit)
														.addComponent(
																produit,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																rp,
																GroupLayout.PREFERRED_SIZE,
																23,
																GroupLayout.PREFERRED_SIZE))
										.addGap(31)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(jLabel3)
														.addGroup(
																gl_jPanel1
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				clibox,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				creerClient)
																		.addComponent(
																				rc,
																				GroupLayout.PREFERRED_SIZE,
																				23,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(26)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(jLabel4)
														.addComponent(
																jTextField1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(28)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(jLabel5)
														.addComponent(
																jTextField2,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label))
										.addGap(34)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(jLabel6)
														.addComponent(
																date,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED, 36,
												Short.MAX_VALUE)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								reprendre,
																								GroupLayout.PREFERRED_SIZE,
																								34,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								quitter,
																								GroupLayout.PREFERRED_SIZE,
																								34,
																								GroupLayout.PREFERRED_SIZE))
																		.addContainerGap())
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addComponent(
																				confirmer,
																				GroupLayout.PREFERRED_SIZE,
																				37,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(31)))));
		jPanel1.setLayout(gl_jPanel1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 607, Short.MAX_VALUE)
				.addGroup(
						layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(
										layout.createSequentialGroup()
												.addGap(0, 0, Short.MAX_VALUE)
												.addComponent(
														jPanel1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(0, 0, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 430, Short.MAX_VALUE)
				.addGroup(
						layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(
										layout.createSequentialGroup()
												.addGap(0, 0, Short.MAX_VALUE)
												.addComponent(
														jPanel1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(0, 0, Short.MAX_VALUE))));

		pack();
	}// </editor-fold>

	public void insertionVente() {
		if (!((String) clibox.getSelectedItem()).equals("Anonyme")) {
			try {
				Statement stmt = Fenetre.getConnection().createStatement();
				stmt.executeUpdate("INSERT INTO Vente(ProduitID,ClientID,NbUnite,PrixVente,DateVente) VALUES("
						+ getPID((String) produit.getSelectedItem())
						+ ","
						+ getCID((String) clibox.getSelectedItem())
						+ ","
						+ jTextField1.getText()
						+ ","
						+ jTextField2.getText()
						+ ",\"" + date.getDate() + "\");");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			revalidate();
		} else {
			try {
				System.out.println("popopopoppb "
						+ getPID((String) produit.getSelectedItem()));
				Statement stmt = Fenetre.getConnection().createStatement();
				stmt.executeUpdate("INSERT INTO Achat(ProduitID,FournisseurID,NbUnite,PrixAchat,DateAchat) VALUES("
						+ getPID((String) produit.getSelectedItem())
						+ ","
						+ "1"
						+ ","
						+ jTextField1.getText()
						+ ","
						+ jTextField2.getText()
						+ ",\""
						+ date.getDate()
						+ "\");");
			} catch (SQLException g) {
				g.printStackTrace();
			}
		}
	}

	/**
	 * Permet de reinitialiser le noms des etudiants inscrit dans le JComboBox
	 * 
	 * @throws SQLException
	 *             cette methode lance une exception de type SQLException
	 */
	public void reinitCBox() {
		Vector<String> v = new Vector<String>();
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet res = stmt.executeQuery("SELECT Nom,Prenom FROM Client");
			while (res.next()) {
				v.add(res.getString("Nom") + " " + res.getString("Prenom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		clibox.removeAllItems();
		for (int i = 0; i < v.size(); i++) {
			clibox.addItem(v.get(i));
		}
		revalidate();
	}

	/**
	 * Permet de reinitialiser le noms des etudiants inscrit dans le JComboBox
	 * 
	 * @throws SQLException
	 *             cette methode lance une exception de type SQLException
	 */
	public void reinitPBox() {
		Vector<String> v = new Vector<String>();
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet res = stmt
					.executeQuery("SELECT Nom FROM Stock WHERE NbUnite<>0");
			while (res.next()) {
				v.add(res.getString("Nom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		produit.removeAllItems();
		for (int i = 0; i < v.size(); i++) {
			produit.addItem(v.get(i));
		}
		revalidate();
	}
}