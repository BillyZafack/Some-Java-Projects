import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

import jpl.Atom;
import jpl.PrologException;
import jpl.Query;
import jpl.Term;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Zafack Billy
 */
public class Interface_CC extends javax.swing.JDialog {

	class Action implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			if (e.getSource() == inserer) {
				// On ajoute l'element selectionne a la liste des symptomes
				// ICI J'enleve l'element selectionne du Combo Box pour eviter
				// les doublons dans la liste
				System.out.println("ENTERED");
				Vector<String> vect = new Vector<String>();
				String s = choix_symptome.getSelectedItem().toString();
				ComboBoxModel com = choix_symptome.getModel();
				for (int i = 0; i < com.getSize(); i++) {
					if (!com.getElementAt(i).toString().equals(s)) {
						vect.addElement(com.getElementAt(i).toString());
					}
				}
				choix_symptome.setModel(com);
				ListModel l = list_symptome.getModel();
				DefaultListModel ss = new DefaultListModel();
				for (int i = 0; i < l.getSize(); i++) {
					ss.addElement(l.getElementAt(i));
				}
				ss.addElement(s);
				list_symptome.setModel(ss);
			}

			if (e.getSource() == reinitialiser) {
				list_symptome.setListData(new Vector<String>());
				oui.setSelected(false);
				non.setSelected(false);
				adulte.setSelectedIndex(0);
				choix_symptome.setSelectedIndex(0);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

	}

	class Actiono implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == enlever) {
				if (list_symptome.getSelectedValue() != null) {
					int j = 0;
					Vector<String> vect = new Vector<String>();
					ListModel l = list_symptome.getModel();
					String s = list_symptome.getSelectedValue().toString();
					for (int i = 0; i < l.getSize(); i++) {
						if (!l.getElementAt(i).toString().equals(s)) {
							vect.addElement(l.getElementAt(i).toString());
						}
					}
					list_symptome.setListData(vect);
				} else {
					JOptionPane
							.showMessageDialog(
									Interface_CC.this,
									"Vous n'avez pas choisie de symptome a enlever !!!",
									"AUCUN SYMPTOME CHOISIE",
									JOptionPane.INFORMATION_MESSAGE);
				}
			}
			if (e.getSource() == quitter) {
				if (JOptionPane.showConfirmDialog(Interface_CC.this,
						"Voulez vous vraiment quitter ?", "CONFIRMATION",
						JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
					setVisible(false);
				}
			}
			if (e.getSource() == diagnostiquer) {
				if (oui.isSelected() || non.isSelected()) {
					Vector<String> vector = new Vector<String>();
					Vector<String> vc = new Vector<String>();
					ListModel l = list_symptome.getModel();
					for (int i = 0; i < l.getSize(); i++) {
						vc.addElement(l.getElementAt(i).toString());
					}
					vector = contactProlog(vc);
					String sd = "";
					for (int i = 0; i < vector.size(); i++) {
						sd = sd + vector.get(i) + "\n";
					}
					if (vector.isEmpty()) {
						JOptionPane
								.showMessageDialog(
										Interface_CC.this,
										"Je n'ai pas pu aboutir a un diagnostique ",
										"DIAGNOSTIQUE",
										JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane
								.showMessageDialog(Interface_CC.this,
										"Vous avez le(s) maladie(s) :" + sd,
										"DIAGNOSTIQUE",
										JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane
							.showMessageDialog(
									Interface_CC.this,
									"Vous n'avez pas renseigner les symptomes de rougeurs ou eruption",
									"CHAMPS NON-RENSEIGNES",
									JOptionPane.WARNING_MESSAGE);
				}

			}
		}

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
			java.util.logging.Logger.getLogger(Interface_CC.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Interface_CC.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Interface_CC.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Interface_CC.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Interface_CC dialog = new Interface_CC(
						new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JComboBox adulte;
	private javax.swing.ButtonGroup buttonGroup1;

	private javax.swing.JComboBox choix_symptome;

	private javax.swing.JButton diagnostiquer;

	private javax.swing.JButton enlever;
	private javax.swing.JButton inserer;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JList list_symptome;
	private javax.swing.JRadioButton non;
	private javax.swing.JRadioButton oui;
	private javax.swing.JButton quitter;
	private javax.swing.JButton reinitialiser;

	// End of variables declaration
	/**
	 * Creates new form Interface_CC
	 */
	public Interface_CC(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents1();
		enlever.addActionListener(new Actiono());
		diagnostiquer.addActionListener(new Actiono());
		inserer.addMouseListener(new Action());
		list_symptome.addMouseListener(new Action());
		quitter.addActionListener(new Actiono());
		reinitialiser.addMouseListener(new Action());
		adulte.addMouseListener(new Action());
	}

	public Vector<String> contactProlog(Vector<String> ved) {
		Vector<String> s = new Vector<String>();
		PrintWriter f = null;
		try {
			f = new PrintWriter(new FileWriter("question.pl"));
			for (int i = 0; i < ved.size(); i++) {
				String m;
				m = ved.get(i);
				f.println("symptome(\"" + m + "\").");
			}
			f.close();
			try {
				Query q1 = new Query("consult", new Term[] { new Atom(
						"regles.pl") });
				Query q2 = new Query("consult", new Term[] { new Atom(
						"question.pl") });

				if (q1.hasSolution() && q2.hasSolution()) {
					Query l = new Query("maladie(varicelle).");
					Query b = new Query("maladie(rubeole).");
					Query c = new Query("maladie(rougeole).");
					Query d = new Query("maladie(scarlatine).");
					if (l.query()) {
						s.add("Varicelle");
					}
					if (b.query()) {
						s.add("Rubeole");
					}
					if (c.query()) {
						s.add("Rougeole");
					}
					if (d.query()) {
						s.add("Scarlatine");
					}
				} else {
					JOptionPane.showMessageDialog(this,
							"ERREUR D'OUVERTURE DU FICHIER 'Prologs.pl' !!!",
							"ERREUR !!!", JOptionPane.ERROR_MESSAGE);
				}
			} catch (PrologException e) {
				e.printStackTrace();
			}

		} catch (IOException re) {
			re.printStackTrace();
			;
		}
		return s;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents1() {
		buttonGroup1 = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		oui = new javax.swing.JRadioButton();
		non = new javax.swing.JRadioButton();
		jLabel5 = new javax.swing.JLabel();
		adulte = new javax.swing.JComboBox();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		choix_symptome = new javax.swing.JComboBox();
		jLabel8 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		list_symptome = new javax.swing.JList();
		enlever = new javax.swing.JButton();
		diagnostiquer = new javax.swing.JButton();
		quitter = new javax.swing.JButton();
		reinitialiser = new javax.swing.JButton();
		inserer = new javax.swing.JButton();
		buttonGroup1.add(non);
		buttonGroup1.add(oui);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
		jLabel1.setText("L'EXPERT EN MEDECINE");

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel2.setText("Veuillez m'expliquer votre mal !! Et je ferai de mon mieux pour trouver un diagnostique fiable. ");

		jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
		jLabel3.setText("DITES MOI ...");

		jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jLabel4.setText("Parmis vos symptomes, avez vous des ERUPTIONS ou des ROUGEURS ?");

		oui.setText("OUI");

		non.setText("NON");

		jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jLabel5.setText("Etes vous un adulte ou un enfant ?");

		adulte.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Adulte", "Enfant" }));

		jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
		jLabel6.setText("QUELS SONT CONCRETEMENT VOS SYMPTOMES ?");

		jLabel7.setText("Choissisez ci-dessous ... ");

		choix_symptome.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Fievre faible", "Peau Seche", "Fievre forte",
						"Ganglions", "Pustules", "Rhume", "Boutons Isoles",
						"Boutons qui demangent", "Amygdales rouges",
						"Croute apparaissant sur pustules",
						"Croute apparaissant sur vesicules", "Mal aux yeux",
						"Taches roses sur la gorge", "Boutons en taches",
						"Desquamation", "Taches rouges" }));

		jLabel8.setText("Vos Symptomes :");

		jScrollPane1.setViewportView(list_symptome);

		enlever.setText("Enlever Symptome");

		diagnostiquer.setText("Diagnostiquer");

		quitter.setText("Quitter");

		reinitialiser.setText("Reinitialiser");
		reinitialiser.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				reinitialiserActionPerformed(evt);
			}
		});

		inserer.setText("Inserer");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(0, 187, Short.MAX_VALUE)
								.addComponent(jLabel2).addGap(139, 139, 139))
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(304,
																		304,
																		304)
																.addComponent(
																		jLabel1))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(78, 78,
																		78)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel4)
																				.addComponent(
																						jLabel5))
																.addGap(18, 18,
																		18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										oui)
																								.addGap(10,
																										10,
																										10)
																								.addComponent(
																										non))
																				.addComponent(
																						adulte,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(41, 41,
																		41)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel6)
																				.addComponent(
																						jLabel3)))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(79,
																										79,
																										79)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														jLabel8)
																												.addComponent(
																														jLabel7))
																								.addGap(33,
																										33,
																										33)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING,
																												false)
																												.addComponent(
																														choix_symptome,
																														0,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														Short.MAX_VALUE)
																												.addComponent(
																														jScrollPane1,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														377,
																														Short.MAX_VALUE)))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(113,
																										113,
																										113)
																								.addComponent(
																										reinitialiser)
																								.addGap(139,
																										139,
																										139)
																								.addComponent(
																										diagnostiquer)))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						quitter)
																				.addComponent(
																						enlever,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						inserer,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))))
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(39, 39, 39)
								.addComponent(jLabel1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jLabel2)
								.addGap(30, 30, 30)
								.addComponent(jLabel3)
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel4)
												.addComponent(oui)
												.addComponent(non))
								.addGap(29, 29, 29)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel5)
												.addComponent(
														adulte,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(36, 36, 36)
								.addComponent(jLabel6)
								.addGap(18, 18, 18)
								.addComponent(jLabel7)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														choix_symptome,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(inserer))
								.addGap(43, 43, 43)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														226,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel8)
												.addComponent(enlever))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										33, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(reinitialiser)
												.addComponent(
														diagnostiquer,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														32,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(quitter))
								.addContainerGap()));

		pack();
	}// </editor-fold>
		// /

	private void reinitialiserActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}
}
