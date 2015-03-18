import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Zafack Billy
 */
public class Initialisation extends javax.swing.JDialog {

	class Actioninit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == terminer) {
				setVisible(false);
				String s = "";
				Vector<String> v = getStock();
				for (int i = 0; i < v.size() - 1; i = i + 2) {
					s = s + "-->" + v.get(i) + " -- " + v.get(i + 1) + "\n";
				}
				JOptionPane
						.showMessageDialog(
								null,
								"Votre institution commerciale a les attributs initiales suivants :\n CAPITAL\n"
										+ getCapital()
										+ " FCFA"
										+ "\n PRODUIT \n" + s,
								"DONNEES INITIALES",
								JOptionPane.INFORMATION_MESSAGE);
				new Fenetre().setVisible(true);
				try {
					Statement stmt = Fenetre.getConnection().createStatement();
					stmt.executeUpdate("INSERT INTO Test VALUES (\"1\")");
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			if (e.getSource() == suivant1) {
				if (String.copyValueOf(password1.getPassword()).equals(
						String.copyValueOf(password2.getPassword()))) {
					if (!String.copyValueOf(password1.getPassword()).equals("")) {
						password = String.copyValueOf(password1.getPassword());
						try {
							Statement stmt = Fenetre.getConnection()
									.createStatement();
							stmt.executeUpdate("INSERT INTO Password VALUES (\""
									+ password + "\");");
						} catch (SQLException r) {
							r.printStackTrace();
						}
						setVisible(false);
						new Initialisation(null, true, 2).setVisible(true);
					} else {
						JOptionPane.showMessageDialog(Initialisation.this,
								"Vous devez entrer un mot de passe",
								"AUCUN MOt DE PASSE ENTRE",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {

					JOptionPane.showMessageDialog(Initialisation.this,
							"Les deux champs n'ont pas le meme mot de passe",
							"MOTS DE PASSE INCOMPATIBLE",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			if (e.getSource() == suivant2) {
				if (capitalinit.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Vous n'avez pas entrée le capital initial !!",
							"CAPITAL NON RENSEIGNEE",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					try {
						Statement stmt = Fenetre.getConnection()
								.createStatement();
						stmt.executeUpdate("INSERT INTO Capital(Capital) VALUES ("
								+ capitalinit.getText() + ");");
						System.out
								.println("jjjjjjjjjj" + capitalinit.getText());
					} catch (SQLException s) {
						s.printStackTrace();
					}
					setVisible(false);
					new Initialisation(null, true, 3).setVisible(true);
				}
			}
			if (e.getSource() == precedent2) {
				setVisible(false);
				new Initialisation(null, true, 1).setVisible(true);
			}
			if (e.getSource() == precedent3) {
				setVisible(false);
				new Initialisation(null, true, 2).setVisible(true);
			}
			if (e.getSource() == quitter1 || e.getSource() == quitter2
					|| e.getSource() == quitter3) {
				if (JOptionPane
						.showConfirmDialog(
								Initialisation.this,
								"Etes vous de vouloir quitter ce processus d'initialisation",
								"CONFIRMER", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
					setVisible(false);
				}
			}
			if (e.getSource() == ajoutProduit) {
				new Stock(null, true).setVisible(true);
			}
			if (e.getSource() == jButton2) {
				new EtatStock(null, true).setVisible(true);
			}
			if (e.getSource() == supprimerProduit) {
				String s = JOptionPane
						.showInputDialog(
								null,
								"Quel est le nom du produit que vous voulez supprimer?",
								"SUPPRESSION DE PRODUIT",
								JOptionPane.OK_CANCEL_OPTION);
				supprimerProduit(s);
				JOptionPane.showMessageDialog(null, "Le produit " + s
						+ " a été supprimé avec succes",
						"SUPPRESSION EFFECTUEE",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Initialisation.password = password;
	}

	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;

	private javax.swing.JLabel jLabel10;

	private javax.swing.JLabel jLabel2;

	private javax.swing.JLabel jLabel3;

	private javax.swing.JLabel jLabel4;

	private javax.swing.JLabel jLabel5;

	private static String password;

	private javax.swing.JLabel jLabel6;

	private javax.swing.JLabel jLabel7;

	private javax.swing.JLabel jLabel8;

	private javax.swing.JLabel jLabel9;

	private javax.swing.JPasswordField password1;

	private javax.swing.JPasswordField password2;

	private javax.swing.JButton precedent1;

	private javax.swing.JButton quitter1;

	private javax.swing.JButton suivant1;

	// End of variables declaration
	// Variables declaration - do not modify
	private javax.swing.JButton ajoutProduit;

	private javax.swing.JTextField capitalinit;

	private javax.swing.JLabel fcfaa;

	private javax.swing.JLabel init;

	private javax.swing.JButton jButton2;

	private javax.swing.JLabel labelCapital;

	private javax.swing.JLabel labelllele;

	private javax.swing.JLabel labelllll;

	private javax.swing.JLabel lstock;

	private javax.swing.JButton precedent2;

	private javax.swing.JButton quitter2;

	private javax.swing.JButton suivant2;

	private javax.swing.JButton supprimerProduit;

	// End of variables declaration
	// Variables declaration - do not modify
	private javax.swing.JLabel finalisation;

	private javax.swing.JLabel labela1;

	private javax.swing.JLabel labela34;

	private javax.swing.JButton precedent3;

	private javax.swing.JButton quitter3;

	private javax.swing.JButton terminer;

	// End of variables declaration
	/**
	 * Creates new form Initialisation
	 */
	public Initialisation(java.awt.Frame parent, boolean modal, int a) {

		super(parent, modal);
		setUndecorated(true);
		if (a == 1) {
			initComponents();
			password1.addActionListener(new Actioninit());
			password2.addActionListener(new Actioninit());
			precedent1.addActionListener(new Actioninit());
			suivant1.addActionListener(new Actioninit());
			quitter1.addActionListener(new Actioninit());
			precedent1.setIcon(new ImageIcon(".\\images\\previous.png"));
			suivant1.setIcon(new ImageIcon(".\\images\\next.png"));
			jLabel9.setIcon(new ImageIcon(".\\images\\password.png"));
			jLabel10.setIcon(new ImageIcon(".\\images\\password.png"));
		} else if (a == 2) {
			initComponents1();
			precedent2.addActionListener(new Actioninit());
			suivant2.addActionListener(new Actioninit());
			quitter2.addActionListener(new Actioninit());
			ajoutProduit.addActionListener(new Actioninit());
			supprimerProduit.addActionListener(new Actioninit());
			jButton2.addActionListener(new Actioninit());
			precedent2.setIcon(new ImageIcon(".\\images\\previous.png"));
			suivant2.setIcon(new ImageIcon(".\\images\\next.png"));
			ajoutProduit.setIcon(new ImageIcon(".\\images\\ajouter.png"));
			supprimerProduit.setIcon(new ImageIcon(".\\images\\delete.png"));
		} else {
			initComponents2();
			precedent3.addActionListener(new Actioninit());
			quitter3.addActionListener(new Actioninit());
			terminer.addActionListener(new Actioninit());
			precedent3.setIcon(new ImageIcon(".\\images\\previous.png"));

		}
	}

	public javax.swing.JButton getAjoutProduit() {
		return ajoutProduit;
	}

	public String getCapital() {
		String s = null;
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet r = stmt.executeQuery("SELECT Capital FROM Capital");
			if (r.next()) {
				s = r.getString("Capital");
			}
		} catch (SQLException s1) {
			s1.printStackTrace();
		}
		return s;
	}

	public javax.swing.JTextField getCapitalinit() {
		return capitalinit;
	}

	public javax.swing.JLabel getFinalisation() {
		return finalisation;
	}

	public javax.swing.JLabel getInit() {
		return init;
	}

	public javax.swing.JButton getjButton2() {
		return jButton2;
	}

	public javax.swing.JPasswordField getPassword1() {
		return password1;
	}

	public javax.swing.JPasswordField getPassword2() {
		return password2;
	}

	public javax.swing.JButton getPrecedent1() {
		return precedent1;
	}

	public javax.swing.JButton getPrecedent2() {
		return precedent2;
	}

	public javax.swing.JButton getPrecedent3() {
		return precedent3;
	}

	public javax.swing.JButton getQuitter1() {
		return quitter1;
	}

	public javax.swing.JButton getQuitter2() {
		return quitter2;
	}

	public javax.swing.JButton getQuitter3() {
		return quitter3;
	}

	public Vector<String> getStock() {
		Vector<String> v = new Vector<String>();
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet r = stmt.executeQuery("SELECT Nom,NbUnite FROM Stock");
			while (r.next()) {
				v.add(r.getString("Nom"));
				v.add(r.getString("NbUnite"));
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return v;
	}

	public javax.swing.JButton getSuivant1() {
		return suivant1;
	}

	public javax.swing.JButton getSuivant2() {
		return suivant2;
	}

	public javax.swing.JButton getSupprimerProduit() {
		return supprimerProduit;
	}

	public javax.swing.JButton getTerminer() {
		return terminer;
	}

	public String getTest() {
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			stmt.executeUpdate("UPDATE Test SET Test = 1");
		} catch (SQLException sa) {
			sa.printStackTrace();
		}
		return "1";
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		password1 = new javax.swing.JPasswordField();
		password2 = new javax.swing.JPasswordField();
		suivant1 = new javax.swing.JButton();
		quitter1 = new javax.swing.JButton();
		precedent1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("DigifaceWide", 0, 18)); // NOI18N
		jLabel1.setText("SOYEZ LA BIENVENUE");
		this.setLocation(250, 250);
		jLabel2.setText("V&A est un logiciel qui vous permet de gerer toute transaction commerciale comme la vente et l'achat de produits, la gestion du capital,");

		jLabel3.setText("des clients, fournisseurs, profit/pertes etc. Bref, ce logiciel est votre la solution a tout probleme d'ordre commerciales. Les diferentes ");

		jLabel4.setText("fonctionnalites de ce logiciel seront presentes plutard. Pour l'instant il faut que vous initialisez les donnees de votre entreprise commerciale");

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel5.setText("PARAMETRES D'AUTHENTIFICATION");

		jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel6.setText("MOT DE PASSE");

		jLabel7.setText("Veuillez entrer le mot de passe qui vous permettra d'avoir les droits administratifs sur votre gestion de produits. Ce mot de passe est sensible a la  ");

		jLabel8.setText(" casse. Donc il faut vous assurer d'utiliser un mot de passe que vous n'oublierai pas.");

		jLabel9.setText("Mot De Passe :");

		jLabel10.setText("Confirmer Mot De Passe :");

		suivant1.setText("Suivant");

		quitter1.setText("Quitter");

		precedent1.setText("Precedent");
		precedent1.setEnabled(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(250,
																										250,
																										250)
																								.addComponent(
																										jLabel1))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(53,
																										53,
																										53)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														jLabel3)
																												.addComponent(
																														jLabel2)
																												.addComponent(
																														jLabel4)
																												.addComponent(
																														jLabel8)
																												.addGroup(
																														layout.createSequentialGroup()
																																.addGap(108,
																																		108,
																																		108)
																																.addGroup(
																																		layout.createParallelGroup(
																																				javax.swing.GroupLayout.Alignment.TRAILING)
																																				.addComponent(
																																						jLabel10)
																																				.addComponent(
																																						jLabel9))
																																.addPreferredGap(
																																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																																.addGroup(
																																		layout.createParallelGroup(
																																				javax.swing.GroupLayout.Alignment.LEADING,
																																				false)
																																				.addComponent(
																																						password1)
																																				.addComponent(
																																						password2,
																																						javax.swing.GroupLayout.DEFAULT_SIZE,
																																						172,
																																						Short.MAX_VALUE)))))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(239,
																										239,
																										239)
																								.addComponent(
																										jLabel5))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(305,
																										305,
																										305)
																								.addComponent(
																										jLabel6)))
																.addGap(0,
																		39,
																		Short.MAX_VALUE))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGap(0,
																		0,
																		Short.MAX_VALUE)
																.addComponent(
																		jLabel7)))
								.addContainerGap())
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(86, 86, 86)
								.addComponent(precedent1)
								.addGap(164, 164, 164)
								.addComponent(quitter1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addComponent(suivant1)
								.addGap(102, 102, 102)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(30, 30, 30)
								.addComponent(jLabel1)
								.addGap(36, 36, 36)
								.addComponent(jLabel2)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jLabel3)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jLabel4)
								.addGap(41, 41, 41)
								.addComponent(jLabel5)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jLabel6)
								.addGap(18, 18, 18)
								.addComponent(jLabel7)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jLabel8)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel9)
												.addComponent(
														password1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel10)
												.addComponent(
														password2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(quitter1)
												.addComponent(suivant1)
												.addComponent(precedent1))
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void initComponents1() {

		init = new javax.swing.JLabel();
		lstock = new javax.swing.JLabel();
		labelllll = new javax.swing.JLabel();
		ajoutProduit = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		supprimerProduit = new javax.swing.JButton();
		labelCapital = new javax.swing.JLabel();
		labelllele = new javax.swing.JLabel();
		capitalinit = new javax.swing.JTextField();
		fcfaa = new javax.swing.JLabel();
		precedent2 = new javax.swing.JButton();
		quitter2 = new javax.swing.JButton();
		suivant2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		init.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		init.setText("INITIALISATION DU STOCK ET CAPITAL");

		lstock.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
		lstock.setText("STOCK");

		labelllll
				.setText("Veuillez initialiser le contenu de vote stock. Cet a dire les differents produits que vous avez couramment en stock.");
		this.setLocation(250, 250);
		ajoutProduit.setText("Ajouter Produit ");

		jButton2.setText("Consulter Stock");

		supprimerProduit.setText("Supprimer Produit");

		labelCapital.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
		labelCapital.setText("CAPITAL");

		labelllele.setText("Veuillez initialiser le capital.");

		fcfaa.setText("FCFA");

		precedent2.setText("Precedent");
		precedent2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				precedent2ActionPerformed(evt);
			}
		});

		quitter2.setText("Quitter");
		quitter2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				quitter2ActionPerformed(evt);
			}
		});

		suivant2.setText("Suivant");
		suivant2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				suivant2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addComponent(init)
								.addGap(195, 195, 195))
				.addGroup(
						layout.createSequentialGroup()
								.addGap(57, 57, 57)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						labelllll)
																				.addComponent(
																						lstock))
																.addContainerGap(
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						labelllele)
																				.addComponent(
																						labelCapital)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										capitalinit,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										187,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										fcfaa)))
																.addGap(0,
																		0,
																		Short.MAX_VALUE))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										ajoutProduit)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										jButton2))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										precedent2)
																								.addGap(190,
																										190,
																										190)
																								.addComponent(
																										quitter2)
																								.addGap(0,
																										19,
																										Short.MAX_VALUE)))
																.addGap(156,
																		156,
																		156)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						suivant2,
																						javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						supprimerProduit,
																						javax.swing.GroupLayout.Alignment.TRAILING))
																.addGap(78, 78,
																		78)))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(55, 55, 55)
								.addComponent(init)
								.addGap(25, 25, 25)
								.addComponent(lstock)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(labelllll)
								.addGap(27, 27, 27)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(ajoutProduit)
												.addComponent(jButton2)
												.addComponent(supprimerProduit))
								.addGap(28, 28, 28)
								.addComponent(labelCapital)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(labelllele)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														capitalinit,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(fcfaa))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										40, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						precedent2)
																				.addComponent(
																						suivant2))
																.addGap(23, 23,
																		23))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		quitter2)
																.addGap(32, 32,
																		32)))));

		pack();
	}// </editor-fold>

	private void initComponents2() {

		finalisation = new javax.swing.JLabel();
		labela1 = new javax.swing.JLabel();
		labela34 = new javax.swing.JLabel();
		precedent3 = new javax.swing.JButton();
		terminer = new javax.swing.JButton();
		quitter3 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		finalisation.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		finalisation.setText("FINALISATION");

		labela1.setText("Ayant fini les differentes etapes d'initialisation, vous pouvez continuer vers l'utilisation de votre logiciel. Les differentes fonctionnalites vous seront ");

		labela34.setText("presentes. Il y a egalement une documentation complete sur l'utlisation du logiciel dans l'interface du logiciel.");

		precedent3.setText("Precedent");

		terminer.setText("Terminer");

		quitter3.setText("Annuler");
		this.setLocation(250, 250);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(302,
																										302,
																										302)
																								.addComponent(
																										finalisation))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(53,
																										53,
																										53)
																								.addComponent(
																										labela34)))
																.addGap(0,
																		186,
																		Short.MAX_VALUE))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGap(0,
																		0,
																		Short.MAX_VALUE)
																.addComponent(
																		labela1)))
								.addContainerGap())
				.addGroup(
						layout.createSequentialGroup()
								.addGap(88, 88, 88)
								.addComponent(precedent3)
								.addGap(164, 164, 164)
								.addComponent(terminer,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										111,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addComponent(quitter3)
								.addGap(60, 60, 60)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(61, 61, 61)
								.addComponent(finalisation)
								.addGap(19, 19, 19)
								.addComponent(labela1)
								.addGap(18, 18, 18)
								.addComponent(labela34)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										188, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(precedent3)
												.addComponent(
														terminer,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														39,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(quitter3))
								.addGap(33, 33, 33)));

		pack();
	}// </editor-fold>

	private void precedent2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void quitter2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	public void setAjoutProduit(javax.swing.JButton ajoutProduit) {
		this.ajoutProduit = ajoutProduit;
	}

	public void setCapitalinit(javax.swing.JTextField capitalinit) {
		this.capitalinit = capitalinit;
	}

	public void setFinalisation(javax.swing.JLabel finalisation) {
		this.finalisation = finalisation;
	}

	public void setInit(javax.swing.JLabel init) {
		this.init = init;
	}

	public void setjButton2(javax.swing.JButton jButton2) {
		this.jButton2 = jButton2;
	}

	public void setPassword1(javax.swing.JPasswordField password1) {
		this.password1 = password1;
	}

	public void setPassword2(javax.swing.JPasswordField password2) {
		this.password2 = password2;
	}

	public void setPrecedent1(javax.swing.JButton precedent1) {
		this.precedent1 = precedent1;
	}

	public void setPrecedent2(javax.swing.JButton precedent2) {
		this.precedent2 = precedent2;
	}

	public void setPrecedent3(javax.swing.JButton precedent3) {
		this.precedent3 = precedent3;
	}

	public void setQuitter1(javax.swing.JButton quitter1) {
		this.quitter1 = quitter1;
	}

	public void setQuitter2(javax.swing.JButton quitter2) {
		this.quitter2 = quitter2;
	}

	public void setQuitter3(javax.swing.JButton quitter3) {
		this.quitter3 = quitter3;
	}

	public void setSuivant1(javax.swing.JButton suivant1) {
		this.suivant1 = suivant1;
	}

	public void setSuivant2(javax.swing.JButton suivant2) {
		this.suivant2 = suivant2;
	}

	public void setSupprimerProduit(javax.swing.JButton supprimerProduit) {
		this.supprimerProduit = supprimerProduit;
	}

	public void setTerminer(javax.swing.JButton terminer) {
		this.terminer = terminer;
	}

	private void suivant2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	public void supprimerProduit(String s) {
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			stmt.executeUpdate("DELETE FROM Stock WHERE Nom=\"" + s + "\"");
		} catch (SQLException s1) {
			s1.printStackTrace();
		}
	}
}
