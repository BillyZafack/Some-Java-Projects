import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Zafack Billy
 */
public class Fenetre extends javax.swing.JFrame {

	class Action implements ActionListener {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == tClient || e.getSource() == nClient) {
				new Client(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == tAchat) {
				new Achat(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == tproduit) {
				new Produit(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == ehAchat) {
				new HistoriqueAchat(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == ehVente) {
				new HistoriqueVente(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == ehVol) {
				new HistoriqueVol(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == eProduit) {
				new EtatProduit(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == eFournisseur || e.getSource() == cFournisseur) {
				new EtatFournisseur(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == eClient || e.getSource() == cClient) {
				new EtatClient(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == eStock) {
				new EtatStock(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == ehRecu) {
				new HistoriqueRecu(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == ehOffert) {
				new HistoriqueOffert(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == mntmProduit) {
				new Produit(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == tVente || e.getSource() == aVente) {
				new Vente(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == tRecu || e.getSource() == mntmCadeauRecu) {
				new Recu(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == tOffert || e.getSource() == aOffert) {
				new Offert(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == tVol || e.getSource() == aVol) {
				new Vol(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == tFournisseur || e.getSource() == nFournisseur) {
				new Fournisseur(Fenetre.this, true).setVisible(true);
			}
			if (e.getSource() == quitter) {
				System.exit(0);
			}
			if (e.getSource() == btnAjouter) {
				aRecu.show(btnAjouter, 0, btnAjouter.getY() / 2);
			}
			if (e.getSource() == btnNouveau) {
				nProduit.show(btnNouveau, 0, btnNouveau.getY() / 2);
			}
			if (e.getSource() == btnConsulter) {
				popupMenu_2.show(btnConsulter, 0, btnConsulter.getY() / 2);
			}
			if (e.getSource() == btnSupprimer) {
				popupMenu.show(btnSupprimer, 0, btnSupprimer.getY() / 2);
			}
			if (e.getSource() == reinit) {
				reinitfen();

			}
			if (e.getSource() == jMenuItem6 || e.getSource() == cCapital) {
				JOptionPane.showMessageDialog(Fenetre.this,
						"Votre capital actuel est de : " + Achat.getCapital(),
						"CAPITAL", JOptionPane.INFORMATION_MESSAGE);
			}
			if (e.getSource() == tsProduit || e.getSource() == sProduit) {
				String s = new String("");
				s = JOptionPane
						.showInputDialog(
								Fenetre.this,
								"Veuillez entrer le nom du produit que vous voulez supprimer",
								"SUPPRESSION", JOptionPane.OK_CANCEL_OPTION);
				System.out.println("THTHTHTHT " + s);
				if (s != null) {

					if (!s.equalsIgnoreCase("")) {
						if (s.charAt(0) == 'P') {
							delete("Produit", "Nom", s);
						} else {
							JOptionPane
									.showMessageDialog(
											Fenetre.this,
											"Identificateur de produit est invalide !!",
											"IDENTIFICATEUR INVALIDE",
											JOptionPane.WARNING_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(Fenetre.this,
								"Aucun identificateur entree!", "ERREUR",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
			if (e.getSource() == tsClient || e.getSource() == sClient) {
				String s = new String("");
				s = JOptionPane
						.showInputDialog(
								Fenetre.this,
								"Veuillez entrer l'identification du client que vous voulez supprimer",
								"SUPPRESSION", JOptionPane.OK_CANCEL_OPTION);
				if (s != null) {
					if (!s.equalsIgnoreCase("")) {
						if (s.charAt(0) == 'C') {
							delete("Client", "Identification_C", s);
						} else {
							JOptionPane.showMessageDialog(Fenetre.this,
									"Identificateur de client est invalide !!",
									"IDENTIFICATEUR INVALIDE",
									JOptionPane.WARNING_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(Fenetre.this,
								"Aucun identificateur entree!", "ERREUR",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
			if (e.getSource() == tsFournisseur || e.getSource() == sFournisseur) {
				String s = new String("");
				s = JOptionPane
						.showInputDialog(
								Fenetre.this,
								"Veuillez entrer l'identification du fournisseur que vous voulez supprimer",
								"SUPPRESSION", JOptionPane.OK_CANCEL_OPTION);
				if (s != null) {
					if (!s.equalsIgnoreCase("")) {
						if (s.charAt(0) == 'F') {
							delete("Fournisseur", "Identification_F", s);
						} else {
							JOptionPane
									.showMessageDialog(
											Fenetre.this,
											"Identificateur de fournisseur est invalide !!",
											"IDENTIFICATEUR INVALIDE",
											JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(Fenetre.this,
								"Aucun identificateur entree!", "ERREUR",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public static void creationTable() {
		try {
			Statement stmt = connection.createStatement();
			int a = stmt
					.executeUpdate("CREATE TABLE IF NOT EXISTS Produit(ProduitID INT AUTO_INCREMENT,"
							+ "Identification_P VARCHAR(30),"
							+ "Nom VARCHAR(30),"
							+ "Unite VARCHAR(30),"
							+ "PrixAchat VARCHAR(30),"
							+ "PrixVente VARCHAR(30),"
							+ "CONSTRAINT PRIMARY KEY(ProduitID)" + ");");
			int b = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Client("
					+ "ClientID INT AUTO_INCREMENT,"
					+ "Identification_C VARCHAR(30)," + "Nom VARCHAR(60),"
					+ "Prenom VARCHAR(30)," + "Profession VARCHAR(30),"
					+ "Telephone VARCHAR(30),"
					+ "CONSTRAINT PRIMARY KEY(ClientID)" + ");");
			int d = stmt
					.executeUpdate("CREATE TABLE IF NOT EXISTS Fournisseur("
							+ "FournisseurID INT AUTO_INCREMENT,"
							+ "Identification_F VARCHAR(30),"
							+ "Nom VARCHAR(60)," + "Prenom VARCHAR(30),"
							+ "Entreprise VARCHAR(30),"
							+ "Telephone VARCHAR(30),"
							+ "CONSTRAINT PRIMARY KEY(FournisseurID)" + ");");
			int c = stmt
					.executeUpdate("CREATE TABLE IF NOT EXISTS Achat("
							+ "AchatID INT AUTO_INCREMENT,"
							+ "ProduitID INT,"
							+ "FournisseurID INT,"
							+ "NbUnite INT,"
							+ "PrixAchat VARCHAR(30),"
							+ "DateAchat VARCHAR(60),"
							+ "CONSTRAINT PRIMARY KEY(AchatID),"
							+ "CONSTRAINT ck_Achat CHECK(ProduitID>0),"
							+ "CONSTRAINT ck_Achat1 CHECK(FournisseurID>0),"
							+ "CONSTRAINT ck_Achat2 CHECK(NbUnite>=0),"
							+ "CONSTRAINT ck_Achat3 CHECK(PrixAchat>=0),"
							+ "CONSTRAINT FOREIGN KEY(ProduitID) REFERENCES Produit(ProduitID),"
							+ "CONSTRAINT FOREIGN KEY(FournisseurID) REFERENCES Fournisseur(FournisseurID)"
							+ ");");
			int e = stmt
					.executeUpdate("CREATE TABLE IF NOT EXISTS Vente("
							+ "VenteID INT AUTO_INCREMENT,"
							+ "ProduitID INT,"
							+ "ClientID INT,"
							+ "NbUnite INT,"
							+ "PrixVente VARCHAR(30),"
							+ "DateVente VARCHAR(60),"
							+ "CONSTRAINT PRIMARY KEY(VenteID),"
							+ "CONSTRAINT ck_Vente CHECK(ProduitID>0),"
							+ "CONSTRAINT ck_Vente1 CHECK(ClientID>0),"
							+ "CONSTRAINT ck_Vente2 CHECK(NbUnite>=0),"
							+ "CONSTRAINT ck_Vente3 CHECK(PrixVente>=0),"
							+ "CONSTRAINT FOREIGN KEY(ProduitID) REFERENCES Produit(ProduitID),"
							+ "CONSTRAINT FOREIGN KEY(ClientID) REFERENCES Client(ClientID)"
							+ ");");
			int f = stmt
					.executeUpdate("CREATE TABLE IF NOT EXISTS CadeauRecu("
							+ "RecuID INT AUTO_INCREMENT,"
							+ "ProduitID INT,"
							+ "Argent VARCHAR(30),"
							+ "NbUnite INT,"
							+ "Date VARCHAR(60),"
							+ "CONSTRAINT PRIMARY KEY(RecuID),"
							+ "CONSTRAINT ck_Recu CHECK(ProduitID>0),"
							+ "CONSTRAINT ck_Recu1 CHECK(Argent>=0),"
							+ "CONSTRAINT ck_Recu2 CHECK(NbUnite>=0),"
							+ "CONSTRAINT FOREIGN KEY(ProduitID) REFERENCES Produit(ProduitID)"
							+ ");");
			int g = stmt
					.executeUpdate("CREATE TABLE IF NOT EXISTS CadeauOffert("
							+ "OffertID INT AUTO_INCREMENT,"
							+ "ProduitID INT,"
							+ "Argent VARCHAR(30),"
							+ "NbUnite INT,"
							+ "Date VARCHAR(60),"
							+ "CONSTRAINT PRIMARY KEY(OffertID),"
							+ "CONSTRAINT ck_Offert CHECK(ProduitID>0),"
							+ "CONSTRAINT ck_Offert1 CHECK(Argent>=0),"
							+ "CONSTRAINT ck_Offert2 CHECK(NbUnite>=0),"
							+ "CONSTRAINT FOREIGN KEY(ProduitID) REFERENCES Produit(ProduitID)"
							+ ");");

			int h = stmt
					.executeUpdate("CREATE TABLE IF NOT EXISTS Stock(ProduitID INT AUTO_INCREMENT,"
							+ "Identification_P VARCHAR(30),"
							+ "Nom VARCHAR(30),"
							+ "Unite VARCHAR(30),"
							+ "NbUnite INT,"
							+ "PrixAchat VARCHAR(30),"
							+ "PrixVente VARCHAR(30),"
							+ "CONSTRAINT ck_Stock CHECK(NbUnite>=0),"
							+ "CONSTRAINT PRIMARY KEY(ProduitID)" + ");");

			int i = stmt
					.executeUpdate("CREATE TABLE IF NOT EXISTS Vol("
							+ "VolID INT AUTO_INCREMENT,"
							+ "ProduitID INT,"
							+ "Argent VARCHAR(30),"
							+ "NbUnite INT,"
							+ "Date DATE,"
							+ "CONSTRAINT PRIMARY KEY(VolID),"
							+ "CONSTRAINT ck_Offert CHECK(ProduitID>0),"
							+ "CONSTRAINT ck_Offert1 CHECK(Argent>=0),"
							+ "CONSTRAINT ck_Offert2 CHECK(NbUnite>=0),"
							+ "CONSTRAINT FOREIGN KEY(ProduitID) REFERENCES Produit(ProduitID)"
							+ ");");

			int j = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Capital("
					+ "Capital VARCHAR(30) ,"
					+ "CONSTRAINT ck_Capital CHECK(Capital>=0),"
					+ "CONSTRAINT PRIMARY KEY(Capital)" + ");");

			int k = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Password("
					+ "Password VARCHAR(60) ,"
					+ "CONSTRAINT PRIMARY KEY(Password)" + ");");

			int l = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Test("
					+ "Test INT DEFAULT 0 ," + "CONSTRAINT PRIMARY KEY(Test)"
					+ ");");

			int m = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS BD("
					+ "BDID INT AUTO_INCREMENT,"
					+ "Admin VARCHAR(30) DEFAULT NULL,"
					+ "Nbase VARCHAR(30) DEFAULT NULL,"
					+ "Password VARCHAR(30) DEFAULT NULL,"
					+ "CONSTRAINT PRIMARY KEY(BDID)" + ");");

		} catch (SQLException n) {
			n.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Fenetre.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Fenetre.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Fenetre.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Fenetre.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Authentification(null, true).setVisible(true);
			}
		});
	}

	public static void setConnection(Connection connection) {
		Fenetre.connection = connection;
	}

	// Variables declaration - do not modify
	private javax.swing.JMenuItem aHtml;

	private javax.swing.JMenuItem aPropos;

	private javax.swing.JMenuItem aResume;
	private javax.swing.JMenu eCapital;
	private javax.swing.JMenuItem eClient;
	private JPanel panel;
	private javax.swing.JMenuItem eProfit;
	private javax.swing.JMenuItem eStock;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenu jMenu6;
	private javax.swing.JMenu jMenu7;
	private javax.swing.JMenu jMenu8;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JMenuItem quitter;
	private javax.swing.JMenuItem tAchat;
	private javax.swing.JMenuItem tClient;
	private javax.swing.JMenuItem tOffert;
	private JMenuItem ehRecu;
	private javax.swing.JMenuItem tFournisseur;
	private JMenuItem ehOffert;
	private JMenuItem nFournisseur;
	private javax.swing.JMenuItem tRecu;
	private javax.swing.JMenuItem tVente;
	private javax.swing.JMenuItem tVol;
	private javax.swing.JMenuItem tproduit;
	private static Connection connection;
	private JButton btnAjouter;
	private JPopupMenu aRecu;
	private JToolBar toolBar;
	private JMenuItem ehVol;
	private JMenuItem aAchat;
	private JMenuItem mntmProduit;
	private JMenuItem tsProduit;
	private JMenuItem aVente;
	private JMenuItem mntmCadeauRecu;
	private JMenuItem aOffert;
	private JMenuItem aVol;
	private JMenuItem nClient;
	private JButton btnConsulter;
	private JPopupMenu popupMenu_2;
	private JMenuItem cCapital;
	private JMenuItem cProduit;
	private JMenuItem cClient;
	private JMenuItem cFournisseur;
	private JButton btnSupprimer;
	private JPopupMenu popupMenu;
	private JMenuItem ehAchat;
	private JMenuItem ehVente;
	private JButton btnNouveau;
	private JPopupMenu nProduit;
	private JMenuItem sProduit;
	private JMenuItem sClient;
	private JMenuItem tsFournisseur;
	private JMenuItem sFournisseur;
	private JMenuItem tsClient;
	private JButton reinit;
	private JLabel label;

	private JMenuItem eFournisseur;
	private JMenuItem eProduit;

	// End of variables declaration
	/**
	 * Creates new form NewJFrame
	 */
	public Fenetre() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				".\\images\\fenetre.png"));
		initComponents();
		setBD(Authentification.getUser(), Authentification.getNbase(),
				Authentification.getPassword());
		setPassword(Initialisation.getPassword());
		aHtml.addActionListener(new Action());
		aPropos.addActionListener(new Action());
		aResume.addActionListener(new Action());
		eCapital.addActionListener(new Action());
		eClient.addActionListener(new Action());
		eStock.addActionListener(new Action());
		eProfit.addActionListener(new Action());
		tAchat.addActionListener(new Action());
		tClient.addActionListener(new Action());
		sFournisseur.addActionListener(new Action());
		tFournisseur.addActionListener(new Action());
		tproduit.addActionListener(new Action());
		tVente.addActionListener(new Action());
		tVol.addActionListener(new Action());
		tOffert.addActionListener(new Action());
		tRecu.addActionListener(new Action());
		aAchat.addActionListener(new Action());
		aOffert.addActionListener(new Action());
		aVol.addActionListener(new Action());
		aVente.addActionListener(new Action());
		ehAchat.addActionListener(new Action());
		ehOffert.addActionListener(new Action());
		ehRecu.addActionListener(new Action());
		ehVente.addActionListener(new Action());
		ehVol.addActionListener(new Action());
		eClient.addActionListener(new Action());
		cFournisseur.addActionListener(new Action());
		eFournisseur.addActionListener(new Action());
		eProduit.addActionListener(new Action());
		eProfit.addActionListener(new Action());
		eStock.addActionListener(new Action());
		mntmCadeauRecu.addActionListener(new Action());
		sClient.addActionListener(new Action());
		sFournisseur.addActionListener(new Action());
		tsClient.addActionListener(new Action());
		tsFournisseur.addActionListener(new Action());
		mntmProduit.addActionListener(new Action());
		sProduit.addActionListener(new Action());
		btnAjouter.addActionListener(new Action());
		btnConsulter.addActionListener(new Action());
		btnNouveau.addActionListener(new Action());
		btnSupprimer.addActionListener(new Action());
		jMenuItem6.addActionListener(new Action());
		cCapital.addActionListener(new Action());
		cClient.addActionListener(new Action());
		reinit.addActionListener(new Action());
		btnAjouter.setIcon(new ImageIcon(".\\images\\fleche.png"));
		btnConsulter.setIcon(new ImageIcon(".\\images\\fleche.png"));
		btnNouveau.setIcon(new ImageIcon(".\\images\\fleche.png"));
		btnSupprimer.setIcon(new ImageIcon(".\\images\\fleche.png"));
		reinit.setIcon(new ImageIcon(".\\images\\89374.jpg"));

	}

	private void aResumeActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	public void delete(String a, String b, String c) {
		if (JOptionPane.showConfirmDialog(Fenetre.this,
				"Etes vous sur de vouloir supprimer ce " + a + "?",
				"CONFIRMATION", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
			try {
				Statement s = Fenetre.getConnection().createStatement();
				s.executeUpdate("DELETE FROM " + a + " WHERE " + b + " = " + c);
			} catch (SQLException j) {
				j.printStackTrace();
			}
			JOptionPane.showMessageDialog(Fenetre.this, "Le " + a
					+ " a été supprimé avec succès", "SUPPRESSION EFFECTUE",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public javax.swing.JMenuItem getaHtml() {
		return aHtml;
	}

	public javax.swing.JMenuItem getaPropos() {
		return aPropos;
	}

	public javax.swing.JMenuItem getaResume() {
		return aResume;
	}

	public javax.swing.JMenu geteCapital() {
		return eCapital;
	}

	public javax.swing.JMenuItem geteClient() {
		return eClient;
	}

	public javax.swing.JMenuItem geteProfit() {
		return eProfit;
	}

	public javax.swing.JMenuItem geteStock() {
		return eStock;
	}

	/**
	 * 
	 * @param id
	 * @return String qui est l'identification du client correspondant a
	 *         l'identificateur id mis en parametre Cette methode permet
	 *         d'obtenir l'identification d'un client dont l'id est donnée en
	 *         parametre
	 */
	public String getIDC(int id) {
		String s = "";

		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT Identification_C FROM Client WHERE ClientID=?");
			stmt.setInt(1, id);
			ResultSet r = stmt.executeQuery();
			r.next();
			s = r.getString("Identification_C");
		} catch (SQLException f) {
			f.printStackTrace();

		}
		return s;
	}

	/**
	 * 
	 * @param id
	 * @return String qui est l'identification du fournisseur correspondant a
	 *         l'identificateur id mis en parametre Cette methode permet
	 *         d'obtenir l'identification du fournisseur dont l'id est donnée en
	 *         parametre
	 */
	public String getIDF(int id) {
		String s = "";

		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT Identification_F FROM Fournisseur WHERE FournisseurID=?");
			stmt.setInt(1, id);
			ResultSet r = stmt.executeQuery();
			r.next();
			s = r.getString("FournisseurID");
		} catch (SQLException f) {
			f.printStackTrace();

		}
		return s;
	}

	/**
	 * 
	 * @param id
	 * @return String qui est l'identification du produit correspondant a
	 *         l'identificateur id mis en parametre Cette methode permet
	 *         d'obtenir le matricule d'un étudiant dont l'id est donnée en
	 *         parametre
	 */
	public String getIDP(int id) {
		String s = "";

		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT Identification_P FROM Produit WHERE ProduitID=?");
			stmt.setInt(1, id);
			ResultSet r = stmt.executeQuery();
			r.next();
			s = r.getString("Identification_P");
		} catch (SQLException f) {
			f.printStackTrace();

		}
		return s;
	}

	public javax.swing.JMenu getjMenu1() {
		return jMenu1;
	}

	public javax.swing.JMenu getjMenu2() {
		return jMenu2;
	}

	public javax.swing.JMenu getjMenu3() {
		return jMenu3;
	}

	public javax.swing.JMenu getjMenu4() {
		return jMenu4;
	}

	public javax.swing.JMenu getjMenu6() {
		return jMenu6;
	}

	public javax.swing.JMenu getjMenu7() {
		return jMenu7;
	}

	public javax.swing.JMenu getjMenu8() {
		return jMenu8;
	}

	public javax.swing.JMenuBar getjMenuBar1() {
		return jMenuBar1;
	}

	public javax.swing.JMenuItem getjMenuItem6() {
		return jMenuItem6;
	}

	public javax.swing.JMenuItem getQuitter() {
		return quitter;
	}

	public javax.swing.JMenuItem gettAchat() {
		return tAchat;
	}

	public javax.swing.JMenuItem gettClient() {
		return tClient;
	}

	public javax.swing.JMenuItem gettOffert() {
		return tOffert;
	}

	public javax.swing.JMenuItem getTproduit() {
		return tproduit;
	}

	public javax.swing.JMenuItem gettRecu() {
		return tRecu;
	}

	public javax.swing.JMenuItem gettVente() {
		return tVente;
	}

	public javax.swing.JMenuItem gettVol() {
		return tVol;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jMenu6 = new javax.swing.JMenu();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu2 = new javax.swing.JMenu();
		quitter = new javax.swing.JMenuItem();
		jMenu1 = new javax.swing.JMenu();
		jMenu8 = new javax.swing.JMenu();
		tproduit = new javax.swing.JMenuItem();
		tClient = new javax.swing.JMenuItem();
		tFournisseur = new javax.swing.JMenuItem();
		jMenu3 = new javax.swing.JMenu();
		tVente = new javax.swing.JMenuItem();
		tAchat = new javax.swing.JMenuItem();
		jMenu4 = new javax.swing.JMenu();
		tRecu = new javax.swing.JMenuItem();
		tOffert = new javax.swing.JMenuItem();
		tVol = new javax.swing.JMenuItem();
		eCapital = new javax.swing.JMenu();
		jMenuItem6 = new javax.swing.JMenuItem();
		eStock = new javax.swing.JMenuItem();
		eClient = new javax.swing.JMenuItem();
		eProfit = new javax.swing.JMenuItem();
		jMenu7 = new javax.swing.JMenu();
		aResume = new javax.swing.JMenuItem();
		aHtml = new javax.swing.JMenuItem();
		aPropos = new javax.swing.JMenuItem();

		jMenu6.setText("jMenu6");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jMenu2.setText("Fichier");

		quitter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_Q,
				java.awt.event.InputEvent.CTRL_MASK));
		quitter.setText("Quitter");
		jMenu2.add(quitter);

		jMenuBar1.add(jMenu2);

		jMenu1.setText("Traitement");

		jMenu8.setText("Ajouter");

		tproduit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_P,
				java.awt.event.InputEvent.SHIFT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		tproduit.setText("Produit");
		jMenu8.add(tproduit);

		tClient.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_C,
				java.awt.event.InputEvent.SHIFT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		tClient.setText("Client");
		jMenu8.add(tClient);

		tFournisseur.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F,
				java.awt.event.InputEvent.SHIFT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		tFournisseur.setText("Fournisseur");
		jMenu8.add(tFournisseur);

		jMenu1.add(jMenu8);

		jMenu3.setText("Nouveau");

		tVente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_V,
				java.awt.event.InputEvent.CTRL_MASK));
		tVente.setText("Vente");
		jMenu3.add(tVente);

		tAchat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_A,
				java.awt.event.InputEvent.CTRL_MASK));
		tAchat.setText("Achat");
		jMenu3.add(tAchat);

		jMenu4.setText("Cadeau");

		tRecu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_R,
				java.awt.event.InputEvent.CTRL_MASK));
		tRecu.setText("Recu");
		jMenu4.add(tRecu);

		tOffert.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_O,
				java.awt.event.InputEvent.CTRL_MASK));
		tOffert.setText("Offert");
		jMenu4.add(tOffert);

		jMenu3.add(jMenu4);

		tVol.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_V,
				java.awt.event.InputEvent.CTRL_MASK));
		tVol.setText("Vol");
		jMenu3.add(tVol);

		jMenu1.add(jMenu3);

		jMenuBar1.add(jMenu1);

		JMenu mnSupprimer = new JMenu("Supprimer");
		jMenu1.add(mnSupprimer);

		tsProduit = new JMenuItem("Produit");
		mnSupprimer.add(tsProduit);

		tsClient = new JMenuItem("Client");
		mnSupprimer.add(tsClient);

		tsFournisseur = new JMenuItem("Fournisseur");
		mnSupprimer.add(tsFournisseur);

		eCapital.setText("Etat");

		jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_C,
				java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem6.setText("Capital");
		eCapital.add(jMenuItem6);

		eStock.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_S,
				java.awt.event.InputEvent.CTRL_MASK));
		eStock.setText("Stock");
		eCapital.add(eStock);

		JMenu mnNewMenu = new JMenu("Historique");
		eCapital.add(mnNewMenu);

		ehAchat = new JMenuItem("Achats");
		mnNewMenu.add(ehAchat);

		ehVente = new JMenuItem("Ventes");
		mnNewMenu.add(ehVente);

		JMenu mnCadeaux = new JMenu("Cadeaux");
		mnNewMenu.add(mnCadeaux);

		ehRecu = new JMenuItem("Reçu");
		mnCadeaux.add(ehRecu);

		ehOffert = new JMenuItem("Offert");
		mnCadeaux.add(ehOffert);

		ehVol = new JMenuItem("Vols");
		mnNewMenu.add(ehVol);

		eProduit = new JMenuItem("Produit");
		eCapital.add(eProduit);

		eClient.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_C,
				java.awt.event.InputEvent.ALT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		eClient.setText("Client");
		eCapital.add(eClient);

		eFournisseur = new JMenuItem("Fournisseur");
		eCapital.add(eFournisseur);

		eProfit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_P,
				java.awt.event.InputEvent.CTRL_MASK));
		eProfit.setText("Profit/Perte");
		eCapital.add(eProfit);

		jMenuBar1.add(eCapital);

		jMenu7.setText("Aide");

		aResume.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_R,
				java.awt.event.InputEvent.SHIFT_MASK));
		aResume.setText("Aide Résumé");
		aResume.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				aResumeActionPerformed(evt);
			}
		});
		jMenu7.add(aResume);

		aHtml.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_H,
				java.awt.event.InputEvent.SHIFT_MASK));
		aHtml.setText("Aide HTML");
		jMenu7.add(aHtml);

		aPropos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_A,
				java.awt.event.InputEvent.CTRL_MASK));
		aPropos.setText("A propos");
		jMenu7.add(aPropos);

		jMenuBar1.add(jMenu7);

		setJMenuBar(jMenuBar1);

		toolBar = new JToolBar();

		panel = new JPanel();

		panel.setLayout(null);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 666,
						Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 666,
						Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(toolBar,
										GroupLayout.PREFERRED_SIZE, 65,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE,
										327, Short.MAX_VALUE)));

		label = new JLabel("");
		label.setIcon(new ImageIcon(".\\images\\iconc.png"));
		label.setBounds(0, 0, 666, 327);
		panel.add(label);

		btnNouveau = new JButton("Nouveau ");
		toolBar.add(btnNouveau);

		nProduit = new JPopupMenu();
		addPopup(btnNouveau, nProduit);

		mntmProduit = new JMenuItem("Produit");
		nProduit.add(mntmProduit);

		nClient = new JMenuItem("Client");
		nProduit.add(nClient);

		nFournisseur = new JMenuItem("Fournisseur");
		nProduit.add(nFournisseur);

		btnAjouter = new JButton("Ajouter");
		toolBar.add(btnAjouter);

		aRecu = new JPopupMenu();
		addPopup(btnAjouter, aRecu);

		aAchat = new JMenuItem("Achat");
		aRecu.add(aAchat);

		aVente = new JMenuItem("Vente");
		aRecu.add(aVente);

		mntmCadeauRecu = new JMenuItem("Cadeau Recu");
		aRecu.add(mntmCadeauRecu);

		aOffert = new JMenuItem("Cadeau Offert");
		aRecu.add(aOffert);

		aVol = new JMenuItem("Vol");
		aRecu.add(aVol);

		btnConsulter = new JButton("Consulter");
		toolBar.add(btnConsulter);

		popupMenu_2 = new JPopupMenu();
		addPopup(btnConsulter, popupMenu_2);

		cCapital = new JMenuItem("Capital");
		popupMenu_2.add(cCapital);

		cProduit = new JMenuItem("Produits");
		popupMenu_2.add(cProduit);

		cClient = new JMenuItem("Clients");
		popupMenu_2.add(cClient);

		cFournisseur = new JMenuItem("Fournisseurs");
		popupMenu_2.add(cFournisseur);

		btnSupprimer = new JButton("Supprimer");
		toolBar.add(btnSupprimer);

		popupMenu = new JPopupMenu();
		addPopup(btnSupprimer, popupMenu);

		sProduit = new JMenuItem("Produit");
		popupMenu.add(sProduit);

		sClient = new JMenuItem("Client");
		popupMenu.add(sClient);

		sFournisseur = new JMenuItem("Fournisseur");
		popupMenu.add(sFournisseur);

		reinit = new JButton("REINITIALISER LES DONNEES");
		toolBar.add(reinit);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>

	public void reinitfen() {
		if (JOptionPane
				.showConfirmDialog(
						this,
						"Etes vous sur de vouloir reinitialiser les donnees!! \nCet action est IRREVERSIBLE!!!",
						"CONFIRMATION", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
			if (JOptionPane
					.showInputDialog(
							this,
							"Cette Operation Etant Tres Sensible Veuillez Vous Authentifier !!! \n Entrez le mot de passe en respectant la casse",
							"AUTHENTIFICATION", JOptionPane.OK_CANCEL_OPTION)
					.equals(Authentification.getPassword())) {
				try {
					Statement stmt = Fenetre.getConnection().createStatement();
					int r = stmt.executeUpdate("TRUNCATE Produit");
					stmt.executeUpdate("TRUNCATE Client");
					stmt.executeUpdate("TRUNCATE Fournisseur");
					stmt.executeUpdate("TRUNCATE Achat");
					stmt.executeUpdate("TRUNCATE Vente");
					stmt.executeUpdate("TRUNCATE Vol");
					stmt.executeUpdate("TRUNCATE CadeauRecu");
					stmt.executeUpdate("TRUNCATE CadeauOffert");
					stmt.executeUpdate("TRUNCATE Stock");
					stmt.executeUpdate("TRUNCATE BD");
					stmt.executeUpdate("TRUNCATE Password");
					stmt.executeUpdate("TRUNCATE Capital");
					stmt.executeUpdate("TRUNCATE Test");
					stmt.executeUpdate("INSERT INTO Test VALUES (\"0\")");
				} catch (SQLException s) {
					s.printStackTrace();
				}
				JOptionPane
						.showMessageDialog(
								Fenetre.this,
								"Les valeurs de votre institution commerciale n'ont pas été initialisées",
								"INITIALISATION REQUISE", JOptionPane.OK_OPTION);
				new Initialisation(null, true, 1).setVisible(true);

			} else {
				JOptionPane
						.showMessageDialog(
								this,
								"Mot De Passe Incorrect !!! \n Vous ne pouvez donc pas effectuer cette re-initialisation.",
								"ACCES REFUSE", JOptionPane.OK_OPTION);
			}
		}
	}

	public void setaHtml(javax.swing.JMenuItem aHtml) {
		this.aHtml = aHtml;
	}

	public void setaPropos(javax.swing.JMenuItem aPropos) {
		this.aPropos = aPropos;
	}

	public void setaResume(javax.swing.JMenuItem aResume) {
		this.aResume = aResume;
	}

	public void setBD(String admin, String nbase, String passwd) {
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			stmt.executeUpdate("UPDATE BD SET Admin =" + admin);
			stmt.executeUpdate("UPDATE BD SET Nbase =" + nbase);
			stmt.executeUpdate("UPDATE BD SET Password =\"" + passwd + "\"");
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void seteCapital(javax.swing.JMenu eCapital) {
		this.eCapital = eCapital;
	}

	public void seteClient(javax.swing.JMenuItem eClient) {
		this.eClient = eClient;
	}

	public void seteProfit(javax.swing.JMenuItem eProfit) {
		this.eProfit = eProfit;
	}

	public void seteStock(javax.swing.JMenuItem eStock) {
		this.eStock = eStock;
	}

	public void setjMenu1(javax.swing.JMenu jMenu1) {
		this.jMenu1 = jMenu1;
	}

	public void setjMenu2(javax.swing.JMenu jMenu2) {
		this.jMenu2 = jMenu2;
	}

	public void setjMenu3(javax.swing.JMenu jMenu3) {
		this.jMenu3 = jMenu3;
	}

	public void setjMenu4(javax.swing.JMenu jMenu4) {
		this.jMenu4 = jMenu4;
	}

	public void setjMenu6(javax.swing.JMenu jMenu6) {
		this.jMenu6 = jMenu6;
	}

	public void setjMenu7(javax.swing.JMenu jMenu7) {
		this.jMenu7 = jMenu7;
	}

	public void setjMenu8(javax.swing.JMenu jMenu8) {
		this.jMenu8 = jMenu8;
	}

	public void setjMenuBar1(javax.swing.JMenuBar jMenuBar1) {
		this.jMenuBar1 = jMenuBar1;
	}

	public void setjMenuItem6(javax.swing.JMenuItem jMenuItem6) {
		this.jMenuItem6 = jMenuItem6;
	}

	public void setPassword(String s) {
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			stmt.executeUpdate("UPDATE Password SET Password =\"" + s + "\"");
		} catch (SQLException s1) {
			s1.printStackTrace();
		}
	}

	public void setQuitter(javax.swing.JMenuItem quitter) {
		this.quitter = quitter;
	}

	public void settAchat(javax.swing.JMenuItem tAchat) {
		this.tAchat = tAchat;
	}

	public void settClient(javax.swing.JMenuItem tClient) {
		this.tClient = tClient;
	}

	public void settOffert(javax.swing.JMenuItem tOffert) {
		this.tOffert = tOffert;
	}

	public void setTproduit(javax.swing.JMenuItem tproduit) {
		this.tproduit = tproduit;
	}

	public void settRecu(javax.swing.JMenuItem tRecu) {
		this.tRecu = tRecu;
	}

	public void settVente(javax.swing.JMenuItem tVente) {
		this.tVente = tVente;
	}

	public void settVol(javax.swing.JMenuItem tVol) {
		this.tVol = tVol;
	}
}
