import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Zafack Billy
 */
public class Init extends javax.swing.JDialog {

	class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == quitter) {
				setVisible(false);
			}
			if (e.getSource() == creerEtd) {
				new CreerEtd(new JFrame(), true).setVisible(true);
				revalidate();
			}
			if (e.getSource() == creerDept) {
				new CreerDept(new JFrame(), true).setVisible(true);
				revalidate();
			}
			if (e.getSource() == supprimerEtd) {
				new SupprimerEtd(new JFrame(), true).setVisible(true);
				revalidate();
			}
			if (e.getSource() == supprimerDept) {
				new SupprimerDept(new JFrame(), true).setVisible(true);
				revalidate();
			}
			if (e.getSource() == avancer) {
				new PreferenceEtd(new javax.swing.JFrame(), true)
						.setVisible(true);
				revalidate();
			}
		}
	}

	/**
	 * @return the departementActuel
	 */
	public static javax.swing.JList getDepartementActuel() {
		return departementActuel;
	}

	/**
	 * @return the nbDepartement
	 */
	public static javax.swing.JTextField getNbDepartement() {
		return nbDepartement;
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
			java.util.logging.Logger.getLogger(Init.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Init.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Init.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Init.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Init dialog = new Init(new javax.swing.JFrame(), true);
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
	private javax.swing.JButton avancer;
	private static javax.swing.JList departementActuel;

	private static javax.swing.JList etudiantActuel;

	/**
	 * @return the etudiantActuel
	 */
	public static javax.swing.JList getEtudiantActuel() {
		return etudiantActuel;
	}

	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private static javax.swing.JTextField nbDepartement;
	private static javax.swing.JTextField nbEtudiants;

	/**
	 * @return the nbEtudiants
	 */
	public static javax.swing.JTextField getNbEtudiants() {
		return nbEtudiants;
	}

	private javax.swing.JButton quitter;

	private javax.swing.JButton creerDept;

	private javax.swing.JButton supprimerDept;

	private javax.swing.JButton creerEtd;

	private javax.swing.JButton supprimerEtd;

	// End of variables declaration
	/**
	 * Creates new form Init
	 */
	public Init(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		Interface_TP2.initNotes();
		Interface_TP2.initPref();
		nbEtudiants.setText(Integer.toString(Interface_TP2.getNbEtd() - 1));
		nbDepartement.setText(Integer.toString(Interface_TP2.getNbDept() - 1));
		Vector<String> e = new Vector<String>();
		Vector<String> f = new Vector<String>();
		for (int i = 0; i < Interface_TP2.getEtudiants().size(); i++) {
			if (!(Interface_TP2.getDepartements().contains(
					Interface_TP2.getEtudiants().get(i)) || Interface_TP2
					.getEtudiants().get(i).equalsIgnoreCase("START"))) {
				e.add(Interface_TP2.getEtudiants().get(i));
			}
		}
		etudiantActuel.setListData(e);
		for (int i = 0; i < Interface_TP2.getDepartements().size(); i++) {
			if (!(Interface_TP2.getEtudiants().contains(
					Interface_TP2.getDepartements().get(i)) || Interface_TP2
					.getDepartements().get(i).equalsIgnoreCase("START"))) {
				f.add(Interface_TP2.getDepartements().get(i));
			}
		}
		departementActuel.setListData(f);
	}

	/**
	 * @return the avancer
	 */
	public javax.swing.JButton getAvancer() {
		return avancer;
	}

	/**
	 * @return the creerDept
	 */
	public javax.swing.JButton getCreerDept() {
		return creerDept;
	}

	/**
	 * @return the creerEtd
	 */
	public javax.swing.JButton getCreerEtd() {
		return creerEtd;
	}

	/**
	 * @return the quitter
	 */
	public javax.swing.JButton getQuitter() {
		return quitter;
	}

	/**
	 * @return the supprimerDept
	 */
	public javax.swing.JButton getSupprimerDept() {
		return supprimerDept;
	}

	/**
	 * @return the supprimerEtd
	 */
	public javax.swing.JButton getSupprimerEtd() {
		return supprimerEtd;
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
		nbEtudiants = new javax.swing.JTextField();
		nbDepartement = new javax.swing.JTextField();
		creerDept = new javax.swing.JButton();
		avancer = new javax.swing.JButton();
		supprimerDept = new javax.swing.JButton();
		creerEtd = new javax.swing.JButton();
		supprimerEtd = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		etudiantActuel = new javax.swing.JList();
		jScrollPane2 = new javax.swing.JScrollPane();
		departementActuel = new javax.swing.JList();
		quitter = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		jLabel1.setText("DEPARTEMENT  ET  ETUDIANTS");

		creerDept.addActionListener(new Action());
		creerEtd.addActionListener(new Action());
		supprimerDept.addActionListener(new Action());
		supprimerEtd.addActionListener(new Action());
		avancer.addActionListener(new Action());
		quitter.addActionListener(new Action());

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel2.setText("ETAT    ACTUEL");

		jLabel3.setText("ETUDIANTS");

		jLabel4.setText("DEPARTEMENTS");

		nbEtudiants.setEditable(false);

		nbDepartement.setEditable(false);

		creerDept.setText("Creer Department");

		avancer.setText("AVANCER");

		supprimerDept.setText("Supprimer Department");

		creerEtd.setText("Creer Etudiant");

		supprimerEtd.setText("Supprimer Etudiant");

		jScrollPane1.setViewportView(etudiantActuel);

		jScrollPane2.setViewportView(departementActuel);

		javax.swing.GroupLayout gl_jPanel1 = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(gl_jPanel1);
		gl_jPanel1
				.setHorizontalGroup(gl_jPanel1
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								gl_jPanel1
										.createSequentialGroup()
										.addGap(0, 159, Short.MAX_VALUE)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																gl_jPanel1
																		.createSequentialGroup()
																		.addComponent(
																				jLabel2)
																		.addGap(364,
																				364,
																				364))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																gl_jPanel1
																		.createSequentialGroup()
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								nbEtudiants,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								52,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_jPanel1
																										.createSequentialGroup()
																										.addComponent(
																												creerEtd)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																										.addComponent(
																												jScrollPane1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												367,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_jPanel1
																										.createSequentialGroup()
																										.addComponent(
																												jLabel4)
																										.addGap(88,
																												88,
																												88)
																										.addComponent(
																												nbDepartement,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												52,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_jPanel1
																										.createSequentialGroup()
																										.addComponent(
																												creerDept)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																										.addComponent(
																												jScrollPane2,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												367,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								supprimerDept)
																						.addComponent(
																								supprimerEtd))
																		.addGap(94,
																				94,
																				94))))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								gl_jPanel1
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																gl_jPanel1
																		.createSequentialGroup()
																		.addComponent(
																				jLabel1)
																		.addGap(269,
																				269,
																				269))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																gl_jPanel1
																		.createSequentialGroup()
																		.addComponent(
																				jLabel3)
																		.addGap(390,
																				390,
																				390))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																gl_jPanel1
																		.createSequentialGroup()
																		.addComponent(
																				avancer,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				142,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(361,
																				361,
																				361)))));
		gl_jPanel1
				.setVerticalGroup(gl_jPanel1
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gl_jPanel1
										.createSequentialGroup()
										.addGap(26, 26, 26)
										.addComponent(jLabel1)
										.addGap(37, 37, 37)
										.addComponent(jLabel2)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												40, Short.MAX_VALUE)
										.addComponent(jLabel3)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												7, Short.MAX_VALUE)
										.addComponent(
												nbEtudiants,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				106,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addGap(46,
																				46,
																				46)
																		.addComponent(
																				creerEtd))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																gl_jPanel1
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				supprimerEtd)
																		.addGap(48,
																				48,
																				48)))
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				jLabel4))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																gl_jPanel1
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				25,
																				Short.MAX_VALUE)
																		.addComponent(
																				nbDepartement,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(
												gl_jPanel1
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																gl_jPanel1
																		.createSequentialGroup()
																		.addGroup(
																				gl_jPanel1
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								gl_jPanel1
																										.createSequentialGroup()
																										.addGap(51,
																												51,
																												51)
																										.addComponent(
																												supprimerDept))
																						.addGroup(
																								gl_jPanel1
																										.createSequentialGroup()
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																										.addComponent(
																												jScrollPane2,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												106,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																gl_jPanel1
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				creerDept)
																		.addGap(50,
																				50,
																				50)))
										.addComponent(
												avancer,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												37,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(43, 43, 43)));

		quitter.setText("Quitter");

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
																.addContainerGap()
																.addComponent(
																		jPanel1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(445,
																		445,
																		445)
																.addComponent(
																		quitter)))
								.addContainerGap(83, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(23, Short.MAX_VALUE)
								.addComponent(jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(quitter)));

		pack();
	}

	/**
	 * @param avancer
	 *            the avancer to set
	 */
	public void setAvancer(javax.swing.JButton avancer) {
		this.avancer = avancer;
	}

	/**
	 * @param creerDept
	 *            the creerDept to set
	 */
	public void setCreerDept(javax.swing.JButton creerDept) {
		this.creerDept = creerDept;
	}

	/**
	 * @param creerEtd
	 *            the creerEtd to set
	 */
	public void setCreerEtd(javax.swing.JButton creerEtd) {
		this.creerEtd = creerEtd;
	}

	/**
	 * @param departementActuel
	 *            the departementActuel to set
	 */
	public void setDepartementActuel(javax.swing.JList departementActuel) {
		this.departementActuel = departementActuel;
	}

	/**
	 * @param etudiantActuel
	 *            the etudiantActuel to set
	 */
	public void setEtudiantActuel(javax.swing.JList etudiantActuel) {
		this.etudiantActuel = etudiantActuel;
	}

	/**
	 * @param nbDepartement
	 *            the nbDepartement to set
	 */
	public void setNbDepartement(javax.swing.JTextField nbDepartement) {
		this.nbDepartement = nbDepartement;
	}

	/**
	 * @param nbEtudiants
	 *            the nbEtudiants to set
	 */
	public void setNbEtudiants(javax.swing.JTextField nbEtudiants) {
		this.nbEtudiants = nbEtudiants;
	}

	/**
	 * @param quitter
	 *            the quitter to set
	 */
	public void setQuitter(javax.swing.JButton quitter) {
		this.quitter = quitter;
	}

	/**
	 * @param supprimerDept
	 *            the supprimerDept to set
	 */
	public void setSupprimerDept(javax.swing.JButton supprimerDept) {
		this.supprimerDept = supprimerDept;
	}

	/**
	 * @param supprimerEtd
	 *            the supprimerEtd to set
	 */
	public void setSupprimerEtd(javax.swing.JButton supprimerEtd) {
		this.supprimerEtd = supprimerEtd;
	}// </editor-fold>

}