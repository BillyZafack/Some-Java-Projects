import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
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
public class Offert extends javax.swing.JDialog {

	class Actiono implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == jRadioButton1) {
				montant1.setEnabled(false);
				montant3.setEnabled(false);
				montant.setEnabled(true);
			}
			if (e.getSource() == jRadioButton2) {
				montant.setEnabled(false);
				montant1.setEnabled(true);

			}
			if (e.getSource() == quitter) {
				setVisible(false);
			}
			if (e.getSource() == reprendre) {
				jRadioButton1.setSelected(true);
				montant1.setText("");
				montant3.setText("");
				montant.setText("");
			}
			if (e.getSource() == creer) {
				new Produit((Frame) getParent(), true).setVisible(true);
			}
			if (e.getSource() == confirmer) {
				if (jRadioButton1.isSelected()) {
					if (!montant.getText().equals("")) {
						if (Achat.getCapital() >= Integer.parseInt(montant
								.getText())) {
							Achat.decCapital(Integer.parseInt(montant.getText()));
							JOptionPane.showMessageDialog(Offert.this,
									"Ce vol a été enregistré",
									"VOL ENREGISTRE",
									JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(Offert.this,
									"Vous n'avez pas assez d'argent pour offrir ce cadeau!!\n Votre capital est : "
											+ Achat.getCapital() + " FCFA",
									"CAPITAL INSUFFISANT",
									JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane
								.showMessageDialog(
										Offert.this,
										"Vous n'avez pas renseigne la quantite d'argent",
										"CHAMPS NON RENSEIGNE",
										JOptionPane.WARNING_MESSAGE);
					}
				} else {
					if (!montant1.getText().equals("")) {
						if (Vente.getStock((String) nom.getSelectedItem()) >= Integer
								.parseInt(montant1.getText())) {
							Vente.decStock((String) nom.getSelectedItem(),
									Integer.parseInt(montant1.getText()));
							insertionOffert();
							JOptionPane.showMessageDialog(Offert.this,
									"Ce cadeau a été enregistré",
									"Cadeau ENREGISTRE",
									JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);

						} else {
							JOptionPane
									.showMessageDialog(
											Offert.this,
											"Vous n'avez pas assez de "
													+ (String) nom
															.getSelectedItem()
													+ " pour offrir ce cadeau.\n Vous n'avez que "
													+ Vente.getStock((String) nom
															.getSelectedItem())
													+ " en stock",
											"STOCK INSUFFIANT",
											JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane
								.showMessageDialog(
										Offert.this,
										"Vous n'avez pas renseigne la quantite du produit recu",
										"CHAMPS NON RENSEIGNE",
										JOptionPane.WARNING_MESSAGE);
					}
				}
			}
			if (e.getSource() == nom) {
				montant3.setText(getPIDD((String) nom.getSelectedItem()));
				System.out.println("TEST "
						+ getPIDD((String) nom.getSelectedItem()));
			}
		}

	}

	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton confirmer;

	private javax.swing.JButton creer;

	private javax.swing.JLabel jLabel1;

	private javax.swing.JLabel jLabel2;

	private javax.swing.JLabel jLabel3;

	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JTextField montant;
	private javax.swing.JTextField montant1;
	private javax.swing.JTextField montant3;
	private javax.swing.JButton quitter;
	private javax.swing.JButton reprendre;
	private JCalendarCombo date;
	private JLabel lblDate;
	private JComboBox nom;

	// End of variables declaration
	/**
	 * Creates new form Offert
	 */
	public Offert(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				".\\images\\fenetre.png"));
		initComponents();
		jRadioButton1.setSelected(true);
		jRadioButton1.addActionListener(new Actiono());
		jRadioButton2.addActionListener(new Actiono());
		confirmer.addActionListener(new Actiono());
		reprendre.addActionListener(new Actiono());
		quitter.addActionListener(new Actiono());
		montant3.setEnabled(false);
		nom.addActionListener(new Actiono());
		creer.addActionListener(new Actiono());
		montant1.setEnabled(false);
		reinitPBox();
	}

	public String getPIDD(String nom) {
		String ss = "";
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet r = stmt
					.executeQuery("SELECT Identification_P FROM Produit WHERE Nom=\""
							+ nom + "\";");
			r.next();
			ss = r.getString("Identification_P");
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

		buttonGroup1 = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		date = new JCalendarCombo();
		jRadioButton1 = new javax.swing.JRadioButton();
		jRadioButton2 = new javax.swing.JRadioButton();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		montant = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		montant3 = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		montant1 = new javax.swing.JTextField();
		reprendre = new javax.swing.JButton();
		confirmer = new javax.swing.JButton();
		quitter = new javax.swing.JButton();
		creer = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		jLabel1.setText("CADEAU OFFERT");

		jRadioButton1.setText("Argent");
		jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton1ActionPerformed(evt);
			}
		});

		jRadioButton2.setText("Produit");
		jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton2ActionPerformed(evt);
			}
		});
		buttonGroup1.add(jRadioButton1);
		buttonGroup1.add(jRadioButton2);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel2.setText("ARGENT :");

		jLabel3.setText("Montant :");

		jLabel8.setText("FCFA");

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel4.setText("PRODUIT :");

		jLabel5.setText("Identification :");

		montant3.setEditable(false);

		jLabel6.setText("Nom :");

		jLabel7.setText("Quantite :");

		reprendre.setText("Reprendre");

		confirmer.setText("Confirmer");

		quitter.setText("Quitter");

		creer.setText("Creer Nouveau Produit");
		reprendre.setIcon(new ImageIcon(".\\images\\reprendre.png"));
		quitter.setIcon(new ImageIcon(".\\images\\annuler.png"));
		confirmer.setIcon(new ImageIcon(".\\images\\ajouter.png"));
		lblDate = new JLabel("Date ");

		nom = new JComboBox();

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(layout
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(120)
								.addComponent(reprendre,
										GroupLayout.PREFERRED_SIZE, 109,
										GroupLayout.PREFERRED_SIZE)
								.addGap(91)
								.addGroup(
										layout.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						jLabel3)
																				.addComponent(
																						jRadioButton1)
																				.addComponent(
																						jLabel6)
																				.addComponent(
																						jLabel7))
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(22)
																								.addGroup(
																										layout.createParallelGroup(
																												Alignment.TRAILING)
																												.addComponent(
																														jLabel2)
																												.addGroup(
																														layout.createParallelGroup(
																																Alignment.LEADING)
																																.addComponent(
																																		confirmer,
																																		GroupLayout.PREFERRED_SIZE,
																																		112,
																																		GroupLayout.PREFERRED_SIZE)
																																.addComponent(
																																		jLabel1))))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(35)
																								.addGroup(
																										layout.createParallelGroup(
																												Alignment.TRAILING)
																												.addComponent(
																														montant1,
																														GroupLayout.DEFAULT_SIZE,
																														190,
																														Short.MAX_VALUE)
																												.addComponent(
																														montant3,
																														GroupLayout.DEFAULT_SIZE,
																														190,
																														Short.MAX_VALUE)
																												.addGroup(
																														layout.createSequentialGroup()
																																.addComponent(
																																		montant,
																																		GroupLayout.DEFAULT_SIZE,
																																		190,
																																		Short.MAX_VALUE)
																																.addPreferredGap(
																																		ComponentPlacement.RELATED))
																												.addComponent(
																														nom,
																														0,
																														190,
																														Short.MAX_VALUE)))))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel5)
																.addPreferredGap(
																		ComponentPlacement.RELATED)))
								.addGroup(
										layout.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(4)
																.addComponent(
																		jRadioButton2)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		creer))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(19)
																.addComponent(
																		jLabel8))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(84)
																.addComponent(
																		quitter,
																		GroupLayout.PREFERRED_SIZE,
																		105,
																		GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED,
										GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												Alignment.LEADING)
												.addComponent(lblDate)
												.addComponent(
														date,
														GroupLayout.PREFERRED_SIZE,
														181,
														GroupLayout.PREFERRED_SIZE))
								.addGap(101))
				.addGroup(
						Alignment.LEADING,
						layout.createSequentialGroup().addGap(485)
								.addComponent(jLabel4)
								.addContainerGap(552, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap(
																		55,
																		Short.MAX_VALUE)
																.addComponent(
																		jLabel1)
																.addGap(36)
																.addComponent(
																		lblDate)
																.addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addComponent(
																		date,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(10)
																.addComponent(
																		jLabel2)
																.addGap(103))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(99)
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						jRadioButton2)
																				.addComponent(
																						jRadioButton1))
																.addGap(108)
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						jLabel3)
																				.addComponent(
																						montant,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel8))))
								.addGap(10)
								.addComponent(jLabel4)
								.addGap(27)
								.addGroup(
										layout.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(jLabel5)
												.addComponent(
														montant3,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(30)
								.addGroup(
										layout.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(jLabel6)
												.addComponent(
														nom,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(creer))
								.addGap(25)
								.addGroup(
										layout.createParallelGroup(
												Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		reprendre,
																		GroupLayout.PREFERRED_SIZE,
																		37,
																		GroupLayout.PREFERRED_SIZE)
																.addContainerGap())
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.TRAILING)
																				.addComponent(
																						quitter,
																						GroupLayout.PREFERRED_SIZE,
																						38,
																						GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												Alignment.BASELINE)
																												.addComponent(
																														jLabel7)
																												.addComponent(
																														montant1,
																														GroupLayout.PREFERRED_SIZE,
																														GroupLayout.DEFAULT_SIZE,
																														GroupLayout.PREFERRED_SIZE))
																								.addGap(36)
																								.addComponent(
																										confirmer,
																										GroupLayout.PREFERRED_SIZE,
																										40,
																										GroupLayout.PREFERRED_SIZE)))
																.addGap(22)))));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>

	public void insertionOffert() {
		if (jRadioButton2.isSelected()) {
			try {
				Statement stmt = Fenetre.getConnection().createStatement();
				stmt.executeUpdate("INSERT INTO CadeauOffert(ProduitID,Argent,NbUnite,Date) VALUES("
						+ Achat.getPID((String) nom.getSelectedItem())
						+ ","
						+ "NULL"
						+ ","
						+ montant1.getText()
						+ ","
						+ date.getDate() + ");");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			try {
				Statement stmt = Fenetre.getConnection().createStatement();
				stmt.executeUpdate("INSERT INTO CadeauOffert(ProduitID,Argent,NbUnite,Date) VALUES("
						+ "NULL"
						+ ","
						+ montant.getText()
						+ ","
						+ "NULL"
						+ ","
						+ date.getDate() + ");");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		revalidate();
	}

	private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

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
		nom.removeAllItems();
		for (int i = 0; i < v.size(); i++) {
			nom.addItem(v.get(i));
		}
		revalidate();
	}
}
