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
public class Achat extends javax.swing.JDialog {

	class Actiona implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == creerClient) {
				new Fournisseur(new Fenetre(), true).setVisible(true);
			}
			if (e.getSource() == creerProduit) {
				new Produit(new Fenetre(), true).setVisible(true);
			}
			if (e.getSource() == reprendre) {
				jTextField1.setText("");
				jTextField2.setText("");
			}
			if (e.getSource() == quitter) {
				setVisible(false);
			}
			if (e.getSource() == rf) {
				reinitFBox();
			}
			if (e.getSource() == rp) {
				reinitPBox();
			}
			if (e.getSource() == confirmer) {
				if (produit.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(Achat.this,
							"Veuillez choisir un produit!",
							"PRODUIT NON RENSEIGNE",
							JOptionPane.WARNING_MESSAGE);
				} else if (jTextField1.getText().equals("")) {
					JOptionPane.showMessageDialog(Achat.this,
							"Veuillez renseigner le nombre d'unités achetées!",
							"NOMBRE D'UNITES NON RENSEIGNE",
							JOptionPane.WARNING_MESSAGE);
				} else if (jTextField2.getText().equals("")) {
					JOptionPane.showMessageDialog(Achat.this,
							"Veuillez renseigner le prix d'achat unitaire !",
							"PRIX D'ACHAT UNITAIRE NON RENSEIGNE",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (getCapital() >= Integer.parseInt(jTextField1.getText())
							* Integer.parseInt(jTextField2.getText())) {
						insertionAchat();
						incStock((String) produit.getSelectedItem(),
								Integer.parseInt(jTextField1.getText()));
						decCapital(Integer.parseInt(jTextField1.getText())
								* Integer.parseInt(jTextField2.getText()));
						setVisible(false);
					} else {
						JOptionPane
								.showMessageDialog(
										Achat.this,
										"Vous n'avez pas assez de capital pour effectuer cet achat !!\n Votre solde s'eleve a "
												+ getCapital(),
										"CAPITAL INSUFFISANT",
										JOptionPane.WARNING_MESSAGE);

					}
				}
			}
		}

	}

	public static void decCapital(int a) {
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet r = stmt.executeQuery("SELECT Capital FROM Capital");
			r.next();
			int b = r.getInt("Capital");
			b = b - a;
			stmt.executeUpdate("UPDATE Capital SET Capital = " + b + ";");
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public static int getCapital() {
		int b = 0;
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet r = stmt.executeQuery("SELECT Capital FROM Capital");
			if (r.next()) {
				b = r.getInt("Capital");
			} else {
				b = 0;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return b;
	}

	public static int getFID(String nom) {
		ResultSet s;
		int i = 0, j = 0;
		String nm = "";
		while (nom.charAt(j) != ' ' || j < nm.length()) {
			j++;
		}
		nm = nom.substring(0, j + 1);
		try {
			PreparedStatement stmt = Fenetre.getConnection().prepareStatement(
					"SELECT FournisseurID FROM Fournisseur WHERE Nom=?");
			stmt.setString(1, nm);
			s = stmt.executeQuery();
			if (s.next()) {
				i = s.getInt("FournisseurID");
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

	public static void incStock(String nom, int n) {
		int id;
		id = getPID(nom);
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet r = stmt
					.executeQuery("SELECT NbUnite FROM Stock WHERE ProduitID="
							+ id);
			if (r.next()) {
				int a = r.getInt("NbUnite");
				a = a + n;
				stmt.executeUpdate("UPDATE Stock SET NbUnite = \"" + a
						+ "\"WHERE ProduitID =\"" + id + "\";");
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JButton confirmer;
	private javax.swing.JButton creerClient;
	private javax.swing.JButton creerProduit;
	private javax.swing.JComboBox fourn;
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
	private JButton rf;
	private JComboBox produit;
	private JButton rp;
	private JCalendarCombo date;

	private JLabel label;

	// End of variables declaration
	/**
	 * Creates new form Achats
	 */
	public Achat(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				".\\images\\fenetre.png"));
		setResizable(false);
		initComponents();
		creerClient.addActionListener(new Actiona());
		creerProduit.addActionListener(new Actiona());
		confirmer.addActionListener(new Actiona());
		quitter.addActionListener(new Actiona());
		reprendre.addActionListener(new Actiona());
		rf.addActionListener(new Actiona());
		rp.addActionListener(new Actiona());
		reinitPBox();
		reinitFBox();
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
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		creerProduit = new javax.swing.JButton();
		fourn = new javax.swing.JComboBox();
		creerClient = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		reprendre = new javax.swing.JButton();
		quitter = new javax.swing.JButton();
		confirmer = new javax.swing.JButton();
		date = new JCalendarCombo();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		jLabel1.setText("ACHAT");

		jLabel2.setText("PRODUIT : *");

		jLabel3.setText("FOURNISSEUR :");

		jLabel4.setText("NOMBRE D'UNITES : *");

		jLabel5.setText("PRIX DE ACHAT UNITAIRE : *");

		jLabel6.setText("DATE D'ACHAT :");

		creerProduit.setText("Nouveau Produit");

		fourn.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Anonyme" }));

		creerClient.setText("Nouveau Fournisseur");

		reprendre.setText("Reprendre");

		quitter.setText("Quitter");

		confirmer.setText("Confirmer");

		produit = new JComboBox();

		label = new JLabel("FCFA");

		rf = new JButton("");
		rf.setIcon(new ImageIcon(".\\images\\refresh.png"));

		rp = new JButton("");
		rp.setIcon(new ImageIcon(".\\images\\refresh.png"));
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
										.addGap(114)
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
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_jPanel1
																										.createSequentialGroup()
																										.addGap(33)
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
																																jLabel6)))
																						.addGroup(
																								gl_jPanel1
																										.createSequentialGroup()
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												reprendre,
																												GroupLayout.PREFERRED_SIZE,
																												104,
																												GroupLayout.PREFERRED_SIZE)))
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_jPanel1
																										.createSequentialGroup()
																										.addGap(14)
																										.addGroup(
																												gl_jPanel1
																														.createParallelGroup(
																																Alignment.LEADING,
																																false)
																														.addComponent(
																																jTextField2,
																																Alignment.TRAILING,
																																GroupLayout.DEFAULT_SIZE,
																																212,
																																Short.MAX_VALUE)
																														.addComponent(
																																produit,
																																0,
																																GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																fourn,
																																0,
																																212,
																																Short.MAX_VALUE)
																														.addComponent(
																																jTextField1)
																														.addComponent(
																																date,
																																Alignment.TRAILING,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)))
																						.addGroup(
																								gl_jPanel1
																										.createSequentialGroup()
																										.addGap(28)
																										.addComponent(
																												confirmer,
																												GroupLayout.PREFERRED_SIZE,
																												142,
																												GroupLayout.PREFERRED_SIZE)))
																		.addGap(18)
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								quitter,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								label,
																								GroupLayout.PREFERRED_SIZE,
																								41,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								creerProduit,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								creerClient,
																								0,
																								0,
																								Short.MAX_VALUE))
																		.addGap(18)
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								rf,
																								0,
																								0,
																								Short.MAX_VALUE)
																						.addComponent(
																								rp,
																								GroupLayout.PREFERRED_SIZE,
																								25,
																								Short.MAX_VALUE))))
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
																Alignment.LEADING)
														.addGroup(
																gl_jPanel1
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				jLabel2)
																		.addComponent(
																				produit,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				creerProduit))
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
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								jLabel3)
																						.addGroup(
																								gl_jPanel1
																										.createParallelGroup(
																												Alignment.BASELINE)
																										.addComponent(
																												fourn,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												creerClient)))
																		.addGap(39)
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								jLabel4)
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
																						.addComponent(
																								jLabel5)
																						.addComponent(
																								jTextField2,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								label))
																		.addGap(34)
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								jLabel6)
																						.addComponent(
																								date,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(32)
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.TRAILING,
																								false)
																						.addGroup(
																								gl_jPanel1
																										.createSequentialGroup()
																										.addComponent(
																												quitter,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addGap(1))
																						.addGroup(
																								gl_jPanel1
																										.createParallelGroup(
																												Alignment.BASELINE)
																										.addComponent(
																												confirmer,
																												GroupLayout.PREFERRED_SIZE,
																												37,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												reprendre,
																												GroupLayout.PREFERRED_SIZE,
																												31,
																												GroupLayout.PREFERRED_SIZE))))
														.addComponent(
																rf,
																GroupLayout.PREFERRED_SIZE,
																23,
																GroupLayout.PREFERRED_SIZE))
										.addGap(37)));
		jPanel1.setLayout(gl_jPanel1);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jPanel1,
										GroupLayout.DEFAULT_SIZE, 971,
										Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						Alignment.LEADING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jPanel1,
										GroupLayout.PREFERRED_SIZE, 447,
										Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>

	public void insertionAchat() {
		try {
			if (!((String) fourn.getSelectedItem()).equals("Anonyme")) {
				Statement stmt = Fenetre.getConnection().createStatement();
				stmt.executeUpdate("INSERT INTO Achat(ProduitID,FournisseurID,NbUnite,PrixAchat,DateAchat) VALUES("
						+ getPID((String) produit.getSelectedItem())
						+ ","
						+ getFID((String) fourn.getSelectedItem())
						+ ","
						+ jTextField1.getText()
						+ ","
						+ jTextField2.getText()
						+ ",\"" + date.getDate() + "\");");
			} else {
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
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		revalidate();
	}

	public void reinitFBox() {
		Vector<String> v = new Vector<String>();
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet res = stmt
					.executeQuery("SELECT Nom,Prenom FROM Fournisseur");
			while (res.next()) {
				v.add(res.getString("Nom") + " " + res.getString("Prenom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fourn.removeAllItems();
		for (int i = 0; i < v.size(); i++) {
			fourn.addItem(v.get(i));
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
			ResultSet res = stmt.executeQuery("SELECT Nom FROM Produit");
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
