import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Cette classe construit et implemente l'interface d'authentification de
 * l'utilisateur de la Base De Donnees.
 * 
 * @author Zafack Billy
 * @version 2.0
 */
public class Authentification extends java.awt.Dialog implements
		ActionListener, MouseListener {

	public static String getNbase() {
		return nbase;
	}

	// Variables declaration - do not modify
	/** Recupere le nom de l'utilisateur */
	private javax.swing.JTextField admin;
	/** Variable qui contient le nom de l'utilisateur */
	private static String user;
	/** Variable contenant le mot de passe d'acces a la BD */
	private static String password;
	/** Variable contenant le nom de la base de donnee */
	private static String nbase;

	public static String getPassword() {
		return password;
	}

	public static JTextField getTest() {
		return test;
	}

	public static String getUser() {
		return user;
	}

	public static void setNbase(String nbase) {
		Authentification.nbase = nbase;
	}

	public static void setPassword(String password) {
		Authentification.password = password;
	}

	public static void setTest(JTextField test) {
		Authentification.test = test;
	}

	public static void setUser(String user) {
		Authentification.user = user;
	}

	/** Bouton annuler de l'interface de connection */
	private javax.swing.JButton annuler;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel14;

	// End of variables declaration

	private javax.swing.JLabel jLabel2;

	private javax.swing.JLabel jLabel3;

	private javax.swing.JPanel jPanel1;

	/** Bouton valider de l'interface d'authentification */
	private javax.swing.JButton valider;

	/** Champs recuperant le mot de passe de l'utilisateur */
	private JPasswordField passe;

	private JLabel lblNewLabel;
	private JButton enseignant = new JButton("Entree de L'Enseignant");

	/** Champs recuperant le nom de la base de donnee */
	private JTextField base;

	private static JTextField test;

	/**
	 * Permet la connection initial a la base de donnees
	 * 
	 * @param parent
	 *            Qui est le nom de laa classe parent(un JFrame) de la boite de
	 *            dialogue.
	 * @param modal
	 *            Ce parametre permet de rendre la boite de dialogue modal ou
	 *            pas.
	 */
	public Authentification(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setUndecorated(true);
		setTitle("AUTHENTIFICATION\r\n");
		setResizable(false);
		setModal(true);
		initComponents();

	}

	/**
	 * Cette methode definie toutes les actions possible sur l'interface de la
	 * boite de dialogue d'authentification.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == valider) {
			user = admin.getText();
			password = String.copyValueOf(passe.getPassword());
			nbase = base.getText();
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

			String ur1 = "jdbc:mysql://localhost:3306/" + nbase;
			try {
				Fenetre.setConnection(DriverManager.getConnection(ur1,
						admin.getText(),
						String.copyValueOf(passe.getPassword())));
			} catch (SQLException p) {
				p.printStackTrace();
				JOptionPane.showMessageDialog(this,
						"ERREUR DANS LA CONNECTION A LA BASE DE DONNEES",
						"ERREUR", JOptionPane.ERROR_MESSAGE);
			}
			if (Fenetre.getConnection() == null) {
				JOptionPane
						.showMessageDialog(
								this,
								"Le mot de passe que vous avez entree est incorrect. Veuillez consulter le nom d'utilisateur et mot de passe",
								"ERREUR", JOptionPane.WARNING_MESSAGE);
			} else {
				Fenetre.creationTable();
				test.setText(getTestt());
				try {
					Statement s = Fenetre.getConnection().createStatement();
					s.executeUpdate("INSERT INTO BD(Admin,Nbase,Password) VALUES (\""
							+ user
							+ "\"\""
							+ nbase
							+ "\"\""
							+ password
							+ "\");");
				} catch (SQLException d) {
					d.printStackTrace();
				}
				if (test.getText().equals("1")) {
					Authentification.this.setVisible(false);
					new Fenetre().setVisible(true);
				} else {
					JOptionPane
							.showMessageDialog(
									Authentification.this,
									"Les valeurs de votre institution commerciale n'ont pas été initialisées",
									"INITIALISATION REQUISE",
									JOptionPane.OK_OPTION);
					new Initialisation(null, true, 1).setVisible(true);
				}
			}
		}
		if (e.getSource() == annuler) {
			setVisible(false);
		}
		if (e.getSource() == enseignant) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

			setPassword("martin");
			String ur1 = "jdbc:mysql://localhost:3306/" + "gestion";
			try {
				Fenetre.setConnection(DriverManager.getConnection(ur1, "root",
						"martin"));
				Fenetre.creationTable();
				test.setText(getTestt());
			} catch (SQLException p) {
				p.printStackTrace();
				JOptionPane.showMessageDialog(this,
						"ERREUR DANS LA CONNECTION A LA BASE DE DONNEES",
						"ERREUR", JOptionPane.ERROR_MESSAGE);
			}
			if (test.getText().equals("1")) {
				setVisible(false);
				new Fenetre().setVisible(true);
			} else {
				JOptionPane
						.showMessageDialog(
								Authentification.this,
								"Les valeurs de votre institution commerciale n'ont pas été initialisées",
								"INITIALISATION REQUISE", JOptionPane.OK_OPTION);
				Authentification.this.setVisible(false);

				try {
					Statement stmt = Fenetre.getConnection().createStatement();
					stmt.executeUpdate("INSERT INTO Fournisseur(FournisseurID,Identification_F,Nom,Prenom,Entreprise,Telephone) VALUES(0,\"P0\",\"Anonyme\", \" \",\"NON-DEFINIE\",\"NON-DEFINIE\");");
					stmt.executeUpdate("INSERT INTO BD(Admin,Nbase,Password) VALUES (\""
							+ user
							+ "\",\""
							+ nbase
							+ "\",\""
							+ password
							+ "\");");
					stmt.executeUpdate("INSERT INTO Client(ClientID,Identification_C,Nom,Prenom,Profession,Telephone) VALUES(0,\"C0\",\"Anonyme\",\" \",\"NON-DEFINIE\",\"NON-DEFINIE\");");
				} catch (SQLException j) {
					j.printStackTrace();
				}

				new Initialisation(null, true, 1).setVisible(true);
			}

		}

	}

	public javax.swing.JTextField getAdmin() {
		return admin;
	}

	public javax.swing.JButton getAnnuler() {
		return annuler;
	}

	public JTextField getBase() {
		return base;
	}

	public JButton getEnseignant() {
		return enseignant;
	}

	public javax.swing.JLabel getjLabel1() {
		return jLabel1;
	}

	public javax.swing.JLabel getjLabel10() {
		return jLabel10;
	}

	public javax.swing.JLabel getjLabel14() {
		return jLabel14;
	}

	public javax.swing.JLabel getjLabel2() {
		return jLabel2;
	}

	public javax.swing.JLabel getjLabel3() {
		return jLabel3;
	}

	public javax.swing.JPanel getjPanel1() {
		return jPanel1;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public JPasswordField getPasse() {
		return passe;
	}

	public String getTestt() {
		String g = null;
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet r = stmt.executeQuery("SELECT * FROM Test");
			if (r.next()) {
				g = r.getString("Test");
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return g;
	}

	public javax.swing.JButton getValider() {
		return valider;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	/**
	 * Cette fenetre permet d'initialiser les composantes de la fenetre
	 * d'authentification.
	 * 
	 */
	private void initComponents() {

		jLabel14 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jPanel1.setBorder(new MatteBorder(3, 3, 3, 3, new Color(0, 0, 0)));
		jPanel1.setLocation(new Point(100, 100));
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		admin = new javax.swing.JTextField();
		annuler = new javax.swing.JButton();
		valider = new javax.swing.JButton();
		jLabel10 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();

		jLabel14.setText("Veuillez entrer le nom d'utilisateur et mot de passe que vous avez utilisee lors de la creation du serveur MySQL sur votre ordinateur !");

		jPanel1.setPreferredSize(new Dimension(803, 359));

		jLabel1.setText("Administrateur :");

		jLabel2.setText("Mot De Passe :");
		jLabel2.setIcon(new ImageIcon(".\\images\\password.png"));
		annuler.setText("Annuler");

		valider.setText("Valider");
		this.setLocation(250, 250);
		jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		jLabel10.setText("AUTHENTIFICATION");
		valider.addActionListener(this);
		annuler.addActionListener(this);
		jLabel3.addMouseListener(this);
		enseignant.addActionListener(this);

		jLabel3.setForeground(new java.awt.Color(255, 0, 0));
		jLabel3.setText("J'ai oublié mon mot de passe");

		passe = new JPasswordField();

		JLabel lblCeLogicielAccede = new JLabel(
				"Ce logiciel accede a une Base De Donnees securisée.");

		lblNewLabel = new JLabel(
				"Veuillez entrer le nom d'utilisateur(par defaut \"root\"), mot de passe et le nom de la base de données que vous avez cree sur votre ordinateur !");
		enseignant.setEnabled(true);
		enseignant.setText("PASSAGE");
		enseignant.setIcon(new ImageIcon(".\\images\\passage.png"));
		base = new JTextField();
		base.setColumns(10);
		annuler.setIcon(new ImageIcon(".\\images\\annuler.png"));
		valider.setIcon(new ImageIcon(".\\images\\valider.png"));
		JLabel lblBaseDeDonnees = new JLabel("Base De Données :");

		test = new JTextField();
		test.setEditable(false);
		test.setEnabled(false);
		test.setText("0");
		test.setColumns(10);
		javax.swing.GroupLayout gl_jPanel1 = new javax.swing.GroupLayout(
				jPanel1);
		gl_jPanel1
				.setHorizontalGroup(gl_jPanel1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPanel1.createSequentialGroup().addGap(231)
										.addComponent(lblCeLogicielAccede)
										.addContainerGap(313, Short.MAX_VALUE))
						.addGroup(
								gl_jPanel1
										.createSequentialGroup()
										.addGap(286)
										.addComponent(jLabel10)
										.addPreferredGap(
												ComponentPlacement.RELATED,
												288, Short.MAX_VALUE)
										.addComponent(test,
												GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
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
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_jPanel1
																										.createSequentialGroup()
																										.addGap(177)
																										.addGroup(
																												gl_jPanel1
																														.createParallelGroup(
																																Alignment.TRAILING)
																														.addGroup(
																																gl_jPanel1
																																		.createParallelGroup(
																																				Alignment.LEADING)
																																		.addComponent(
																																				lblBaseDeDonnees,
																																				Alignment.TRAILING)
																																		.addComponent(
																																				jLabel1,
																																				Alignment.TRAILING))
																														.addComponent(
																																jLabel2)))
																						.addGroup(
																								gl_jPanel1
																										.createSequentialGroup()
																										.addGap(69)
																										.addComponent(
																												valider,
																												GroupLayout.PREFERRED_SIZE,
																												99,
																												GroupLayout.PREFERRED_SIZE)))
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_jPanel1
																										.createSequentialGroup()
																										.addGap(61)
																										.addGroup(
																												gl_jPanel1
																														.createParallelGroup(
																																Alignment.LEADING,
																																false)
																														.addComponent(
																																admin,
																																GroupLayout.DEFAULT_SIZE,
																																265,
																																Short.MAX_VALUE)
																														.addComponent(
																																passe)
																														.addComponent(
																																base)
																														.addComponent(
																																jLabel3)))
																						.addGroup(
																								gl_jPanel1
																										.createSequentialGroup()
																										.addGap(24)
																										.addComponent(
																												enseignant,
																												GroupLayout.PREFERRED_SIZE,
																												133,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(175)
																										.addComponent(
																												annuler,
																												GroupLayout.PREFERRED_SIZE,
																												103,
																												GroupLayout.PREFERRED_SIZE))))
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addGap(28)
																		.addComponent(
																				lblNewLabel)))
										.addContainerGap(79, Short.MAX_VALUE)));
		gl_jPanel1
				.setVerticalGroup(gl_jPanel1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPanel1
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel10)
										.addGap(43)
										.addComponent(lblCeLogicielAccede)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(lblNewLabel)
										.addPreferredGap(
												ComponentPlacement.RELATED, 21,
												Short.MAX_VALUE)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																admin,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel1))
										.addGap(18)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																base,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblBaseDeDonnees))
										.addGap(13)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																passe,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel2))
										.addGap(18)
										.addComponent(jLabel3)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addGap(38)
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								valider)
																						.addComponent(
																								annuler)))
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addGap(18)
																		.addComponent(
																				enseignant,
																				GroupLayout.PREFERRED_SIZE,
																				34,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(30))
						.addGroup(
								gl_jPanel1
										.createSequentialGroup()
										.addComponent(test,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(333, Short.MAX_VALUE)));
		jPanel1.setLayout(gl_jPanel1);

		add(jPanel1, java.awt.BorderLayout.CENTER);

		pack();
	}// </editor-fold>

	@Override
	/**
	 * Cette methode permet de gerer les interactions(de clique) a travers la souris par l'utilisateur.
	 * Il fait ceci au travers de une instance du {@link java.awt.event.MouseListener}
	 */
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jLabel3) {
			JOptionPane
					.showMessageDialog(
							this,
							"Pour acceder a ce logiciel, vous devez entrer le nom d'utilisateur(Qui est par defaut \"root\") et \n le mot de passe utilisé dans la creation du serveur MySQL !",
							"AUTHENTIFICATION AVANCEE", 1);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void setAdmin(javax.swing.JTextField admin) {
		this.admin = admin;
	}

	public void setAnnuler(javax.swing.JButton annuler) {
		this.annuler = annuler;
	}

	public void setBase(JTextField base) {
		this.base = base;
	}

	public void setEnseignant(JButton enseignant) {
		this.enseignant = enseignant;
	}

	public void setjLabel1(javax.swing.JLabel jLabel1) {
		this.jLabel1 = jLabel1;
	}

	public void setjLabel10(javax.swing.JLabel jLabel10) {
		this.jLabel10 = jLabel10;
	}

	public void setjLabel14(javax.swing.JLabel jLabel14) {
		this.jLabel14 = jLabel14;
	}

	public void setjLabel2(javax.swing.JLabel jLabel2) {
		this.jLabel2 = jLabel2;
	}

	public void setjLabel3(javax.swing.JLabel jLabel3) {
		this.jLabel3 = jLabel3;
	}

	public void setjPanel1(javax.swing.JPanel jPanel1) {
		this.jPanel1 = jPanel1;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public void setPasse(JPasswordField passe) {
		this.passe = passe;
	}

	public void setValider(javax.swing.JButton valider) {
		this.valider = valider;
	}
}