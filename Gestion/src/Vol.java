import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ButtonGroup;
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
public class Vol extends javax.swing.JDialog {

	class Actionv implements ActionListener {

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
			if (e.getSource() == confirmer) {
				if (jRadioButton1.isSelected()) {
					if (!montant.getText().equals("")) {
						if (Achat.getCapital() >= Integer.parseInt(montant
								.getText())) {
							Achat.decCapital(Integer.parseInt(montant.getText()));
							JOptionPane.showMessageDialog(Vol.this,
									"Ce vol a été enregistré",
									"VOL ENREGISTRE",
									JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
						} else {
							JOptionPane
									.showMessageDialog(
											Vol.this,
											"On ne peut pas vous voler plus d'argent que vous en avez!!\n Votre capital est : "
													+ Achat.getCapital()
													+ " FCFA", "VOL ABSURDE",
											JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane
								.showMessageDialog(
										Vol.this,
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
							insertionVol();
							JOptionPane.showMessageDialog(Vol.this,
									"Ce vol a été enregistré",
									"VOL ENREGISTRE",
									JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(
									Vol.this,
									"On ne peut pas vous voler plus de "
											+ (String) nom.getSelectedItem()
											+ " que vous en avez.\n Vous avez "
											+ Vente.getStock((String) nom
													.getSelectedItem())
											+ " en stock", "VOL ABSURDE",
									JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane
								.showMessageDialog(
										Vol.this,
										"Vous n'avez pas renseigne la quantite du produit recu",
										"CHAMPS NON RENSEIGNE",
										JOptionPane.WARNING_MESSAGE);
					}
				}
			}
			if (e.getSource() == nom) {
				montant3.setText(getPIDD((String) nom.getSelectedItem()));
			}
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JButton confirmer;

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
	private ButtonGroup buttonGroup1;

	// End of variables declaration
	/**
	 * Creates new form Vol
	 */
	public Vol(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				".\\images\\fenetre.png"));
		initComponents();
		jRadioButton1.addActionListener(new Actionv());
		jRadioButton2.addActionListener(new Actionv());
		confirmer.addActionListener(new Actionv());
		reprendre.addActionListener(new Actionv());
		quitter.addActionListener(new Actionv());
		jRadioButton1.setSelected(true);
		reinitPBox();
	}

	public String getPIDD(String nom) {
		String ss = "";
		try {
			Statement stmt = Fenetre.getConnection().createStatement();
			ResultSet r = stmt
					.executeQuery("SELECT Identification_P FROM Produit WHERE Nom="
							+ nom);
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

		jLabel1 = new javax.swing.JLabel();
		buttonGroup1 = new javax.swing.ButtonGroup();
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
		date = new JCalendarCombo();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		buttonGroup1.add(jRadioButton1);
		buttonGroup1.add(jRadioButton2);

		jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		jLabel1.setText("VOL");

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

		lblDate = new JLabel("Date");

		nom = new JComboBox();
		reprendre.setIcon(new ImageIcon(".\\images\\reprendre.png"));
		quitter.setIcon(new ImageIcon(".\\images\\annuler.png"));
		confirmer.setIcon(new ImageIcon(".\\images\\ajouter.png"));
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(layout
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(160)
																.addComponent(
																		reprendre,
																		GroupLayout.PREFERRED_SIZE,
																		91,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(14)
																								.addComponent(
																										jRadioButton1))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												Alignment.LEADING)
																												.addComponent(
																														jLabel3)
																												.addComponent(
																														jLabel4)
																												.addComponent(
																														jLabel2)
																												.addComponent(
																														jLabel5)
																												.addComponent(
																														jLabel6)
																												.addComponent(
																														jLabel7))
																								.addGap(37)
																								.addGroup(
																										layout.createParallelGroup(
																												Alignment.TRAILING,
																												false)
																												.addComponent(
																														montant1,
																														Alignment.LEADING)
																												.addComponent(
																														montant3,
																														Alignment.LEADING)
																												.addComponent(
																														jRadioButton2)
																												.addComponent(
																														montant,
																														Alignment.LEADING,
																														GroupLayout.DEFAULT_SIZE,
																														190,
																														Short.MAX_VALUE)
																												.addComponent(
																														nom,
																														Alignment.LEADING,
																														0,
																														GroupLayout.DEFAULT_SIZE,
																														Short.MAX_VALUE)
																												.addComponent(
																														confirmer,
																														Alignment.LEADING,
																														GroupLayout.PREFERRED_SIZE,
																														103,
																														GroupLayout.PREFERRED_SIZE))
																								.addGap(18)
																								.addComponent(
																										jLabel8)))
																.addPreferredGap(
																		ComponentPlacement.RELATED,
																		11,
																		Short.MAX_VALUE)
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.LEADING)
																				.addGroup(
																						Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addComponent(
																										lblDate)
																								.addPreferredGap(
																										ComponentPlacement.RELATED))
																				.addGroup(
																						Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addComponent(
																										quitter,
																										GroupLayout.PREFERRED_SIZE,
																										86,
																										GroupLayout.PREFERRED_SIZE)
																								.addGap(1))))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(270)
																.addComponent(
																		jLabel1)))
								.addContainerGap(80, GroupLayout.PREFERRED_SIZE))
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(574, Short.MAX_VALUE)
								.addComponent(date, GroupLayout.PREFERRED_SIZE,
										190, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												Alignment.TRAILING, false)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel1)
																.addGap(34)
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						jRadioButton1)
																				.addComponent(
																						jRadioButton2))
																.addGap(18))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		lblDate)
																.addGap(8)))
								.addComponent(date, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(5)
								.addComponent(jLabel2)
								.addGap(55)
								.addGroup(
										layout.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														montant,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel3)
												.addComponent(jLabel8))
								.addGap(51)
								.addComponent(jLabel4)
								.addGroup(
										layout.createParallelGroup(
												Alignment.TRAILING)
												.addGroup(
														Alignment.LEADING,
														layout.createSequentialGroup()
																.addGap(37)
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						montant3,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel5))
																.addGap(31)
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						jLabel6)
																				.addComponent(
																						nom,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))
																.addGap(27)
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						montant1,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel7))
																.addPreferredGap(
																		ComponentPlacement.RELATED,
																		43,
																		Short.MAX_VALUE)
																.addComponent(
																		confirmer,
																		GroupLayout.PREFERRED_SIZE,
																		40,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(38))
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						reprendre,
																						GroupLayout.PREFERRED_SIZE,
																						34,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						quitter,
																						GroupLayout.PREFERRED_SIZE,
																						35,
																						GroupLayout.PREFERRED_SIZE))
																.addGap(26)))));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>

	public void insertionVol() {
		if (jRadioButton2.isSelected()) {
			try {
				Statement stmt = Fenetre.getConnection().createStatement();
				stmt.executeUpdate("INSERT INTO Vol(ProduitID,Argent,NbUnite,Date) VALUES("
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
				stmt.executeUpdate("INSERT INTO Vol(ProduitID,Argent,NbUnite,Date) VALUES("
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
