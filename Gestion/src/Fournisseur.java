import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
public class Fournisseur extends javax.swing.JDialog {

	class Actionf implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == pReprendre) {
				fID.setText("");
				fNom.setText("");
				fPrenom.setText("");
				fEntreprise.setText("");
				fTelephone.setText("");
			}
			if (e.getSource() == pAnnuler) {
				setVisible(false);
			}
			if (e.getSource() == fConfirmer) {
				if (JOptionPane.showConfirmDialog(Fournisseur.this,
						"Voulez vous vraiment enregistrer le fournisseur "
								+ fNom.getText() + " " + fPrenom.getText()
								+ " ?", "CONFIRMATION",
						JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
					if (fID.getText().equals("")) {
						JOptionPane
								.showMessageDialog(
										Fournisseur.this,
										"Vous n'avez pas renseigner l'identification de ce fournisseur",
										"CHAMPS NON-RENSEIGNE",
										JOptionPane.WARNING_MESSAGE);
					}

					else {
						insertionFournisseur();
						setVisible(false);

					}
				}

			}
		}

	}

	// Variables declaration - do not modify
	private javax.swing.JButton fConfirmer;

	private javax.swing.JTextField fEntreprise;

	private javax.swing.JTextField fID;

	private javax.swing.JTextField fNom;

	private javax.swing.JTextField fPrenom;

	private javax.swing.JTextField fTelephone;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JButton pAnnuler;
	private javax.swing.JButton pReprendre;

	// End of variables declaration
	/**
	 * Creates new form Fournisseurs
	 */
	public Fournisseur(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				".\\images\\fenetre.png"));
		initComponents();
		fConfirmer.addActionListener(new Actionf());
		pReprendre.addActionListener(new Actionf());
		pAnnuler.addActionListener(new Actionf());
		fID.setEnabled(false);
		String d = getLPIDD();
		System.out.println("WW " + d);
		d = d.substring(1, d.length());
		System.out.println("WW " + d);
		int i = Integer.parseInt(d);
		System.out.println("WW " + i);
		i++;
		System.out.println("WW " + i);
		fID.setText("F" + Integer.toString(i));
	}

	private void fTelephoneActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	public String getLPIDD() {
		String ss = "";
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet r = stmt
					.executeQuery("SELECT Identification_F FROM Fournisseur");

			if (r.last()) {
				ss = r.getString("Identification_F");
			} else {
				ss = "F0";
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return ss;
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
		fConfirmer = new javax.swing.JButton();
		pAnnuler = new javax.swing.JButton();
		pReprendre = new javax.swing.JButton();
		fID = new javax.swing.JTextField();
		fNom = new javax.swing.JTextField();
		fEntreprise = new javax.swing.JTextField();
		fTelephone = new javax.swing.JTextField();
		fPrenom = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		jLabel1.setText("NOUVEAU FOURNISSEUR");

		jLabel2.setText("IDENTIFICATION :");

		jLabel3.setText("NOM DU FOURNISSEUR :");

		jLabel4.setText("NUMERO DE TELEPHONE :");
		jLabel4.setIcon(new ImageIcon(".\\images\\call.png"));

		jLabel5.setText("ENTREPRISE :");

		fConfirmer.setText("Confirmer");
		fConfirmer.setIcon(new ImageIcon(".\\images\\ajouter.png"));
		pAnnuler.setText("Annuler");
		pReprendre.setIcon(new ImageIcon(".\\images\\reprendre.png"));
		pAnnuler.setIcon(new ImageIcon(".\\images\\annuler.png"));
		fConfirmer.setIcon(new ImageIcon(".\\images\\ajouter.png"));
		pReprendre.setText("Reprendre");

		fTelephone.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				fTelephoneActionPerformed(evt);
			}
		});

		jLabel7.setText("PRENOM DU FOURNISSEUR :");

		javax.swing.GroupLayout gl_jPanel1 = new javax.swing.GroupLayout(
				jPanel1);
		gl_jPanel1
				.setHorizontalGroup(gl_jPanel1
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_jPanel1.createSequentialGroup().addGap(211)
										.addComponent(jLabel1)
										.addContainerGap(328, Short.MAX_VALUE))
						.addGroup(
								gl_jPanel1
										.createSequentialGroup()
										.addGap(84)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addComponent(
																				pReprendre,
																				GroupLayout.PREFERRED_SIZE,
																				113,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(135)
																		.addComponent(
																				fConfirmer,
																				GroupLayout.PREFERRED_SIZE,
																				123,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				119,
																				Short.MAX_VALUE)
																		.addComponent(
																				pAnnuler,
																				GroupLayout.PREFERRED_SIZE,
																				99,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(96))
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								jLabel5)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								jLabel2)
																						.addComponent(
																								jLabel3)
																						.addComponent(
																								jLabel7))
																		.addGap(124)
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								fID,
																								GroupLayout.PREFERRED_SIZE,
																								259,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								fEntreprise,
																								GroupLayout.PREFERRED_SIZE,
																								259,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								fTelephone,
																								GroupLayout.PREFERRED_SIZE,
																								261,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								fPrenom,
																								GroupLayout.PREFERRED_SIZE,
																								259,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								fNom,
																								GroupLayout.PREFERRED_SIZE,
																								259,
																								GroupLayout.PREFERRED_SIZE))
																		.addContainerGap(
																				160,
																				Short.MAX_VALUE)))));
		gl_jPanel1
				.setVerticalGroup(gl_jPanel1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPanel1
										.createSequentialGroup()
										.addGap(20)
										.addComponent(jLabel1)
										.addGap(56)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																fID,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(42)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(
																fNom,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(55)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(jLabel7)
														.addComponent(
																fPrenom,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(60)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(jLabel5)
														.addComponent(
																fEntreprise,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(53)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(
																fTelephone,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				73,
																				Short.MAX_VALUE)
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								pReprendre,
																								GroupLayout.PREFERRED_SIZE,
																								31,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								pAnnuler,
																								GroupLayout.PREFERRED_SIZE,
																								33,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(20))
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addGap(68)
																		.addComponent(
																				fConfirmer,
																				GroupLayout.PREFERRED_SIZE,
																				47,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap()))));
		jPanel1.setLayout(gl_jPanel1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 789, Short.MAX_VALUE)
				.addGroup(
						layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(
										javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup()
												.addContainerGap(
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jPanel1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addContainerGap(
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 588, Short.MAX_VALUE)
				.addGroup(
						layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(
										javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup()
												.addContainerGap(
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jPanel1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addContainerGap(
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))));

		pack();
	}// </editor-fold>

	public void insertionFournisseur() {

		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet set = SelectBDF(fID.getText());
			if (set.next()) {
				JOptionPane
						.showMessageDialog(
								this,
								"Un Fournisseur ayant cet identification existe deja. Veuillez le changer !",
								"DUPLICATION D'IDENTIFICATION", 1);
			} else {
				int a = stmt
						.executeUpdate("INSERT INTO Fournisseur(Identification_F,Nom,Prenom,Entreprise,Telephone)  VALUES (\""
								+ fID.getText()
								+ "\",\""
								+ fNom.getText()
								+ "\",\""
								+ fPrenom.getText()
								+ "\",\""
								+ fEntreprise.getText()
								+ "\",\""
								+ fTelephone.getText() + "\");");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		revalidate();
	}

	/**
	 * Permet d'obtenir les informations sur un etudiant de la table Etudiant
	 * 
	 * @param mat
	 *            Le matricule de l'etudiant en question
	 * @return ResultSet des informations
	 */
	public ResultSet SelectBDF(String id) {
		ResultSet resultats = null;

		try {
			PreparedStatement stmt = Fenetre.getConnection().prepareStatement(
					"SELECT * FROM Fournisseur WHERE Identification_F=?");
			stmt.setString(1, id);
			resultats = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultats;
	}
}
