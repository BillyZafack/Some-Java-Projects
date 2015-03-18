import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Zafack Billy
 */
public class Interface_TP3 extends javax.swing.JDialog {

	class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == quitter) {
				setVisible(false);
			}
			if (e.getSource() == generer) {
				generate();
			}
			if (e.getSource() == demarrer) {
				choix_algo = algorithme.getSelectedItem().toString();
				setVisible(false);
				new Interface_TP3_2(new JFrame(), true, trans).setVisible(true);
			}
			if (e.getSource() == choix_Manuel) {
				String s;
				do {
					s = JOptionPane
							.showInputDialog(
									Interface_TP3.this,
									"Veuillez entrer l'ordre de vos chiffre sans espaces et le vide representee par 0!!",
									"CHOIX", JOptionPane.OK_CANCEL_OPTION);
				} while (s.length() != 9);
				for (int i = 0; i < v1.size(); i++) {
					v1.get(i).setVisible(true);
				}
				setBtn(s);
				Vector<String> v = new Vector<String>();
				for (int i = 0; i < s.length(); i++) {
					v.add("" + s.charAt(i));
				}
				setTrans(v);
			}

		}

		public void generate() {
			Vector<String> v = new Vector<String>();
			Random r = new Random();
			while (v.size() < 9) {
				int i = Math.abs(r.nextInt() % 9);
				if (!v.contains(Integer.toString(i))) {
					v.add(Integer.toString(i));
				}
			}
			for (int i = 0; i < v1.size(); i++) {
				v1.get(i).setVisible(true);
			}
			for (int i = 0; i < v.size(); i++) {
				if (v.get(i).equals("0")) {
					switch (i) {
					case 0:
						button1.setText("");
						button1.setVisible(false);
						break;
					case 1:
						button2.setText("");
						button2.setVisible(false);
						break;
					case 2:
						button3.setText("");
						button3.setVisible(false);
						break;
					case 3:
						button4.setText("");
						button4.setVisible(false);
						break;
					case 4:
						button5.setText("");
						button5.setVisible(false);
						break;
					case 5:
						button6.setText("");
						button6.setVisible(false);
						break;
					case 6:
						button7.setText("");
						button7.setVisible(false);
						break;
					case 7:
						button8.setText("");
						button8.setVisible(false);
						break;
					case 8:
						button9.setText("");
						button9.setVisible(false);
						break;
					}
				} else {
					v1.get(i).setText(v.get(i));
				}
				setTrans(v);
			}

		}

		public void setBtn(String s) {

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') {
					v1.get(i).setVisible(false);
				} else {
					v1.get(i).setText("" + s.charAt(i));
				}
			}
		}
	}

	public static Vector<String> getTrans() {
		return trans;
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
			java.util.logging.Logger.getLogger(Interface_TP3.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Interface_TP3.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Interface_TP3.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Interface_TP3.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Interface_TP3 dialog = new Interface_TP3(
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

	public static void setTrans(Vector<String> trans) {
		Interface_TP3.trans = trans;
	}

	// Variables declaration - do not modify
	private javax.swing.JButton quitter;
	private javax.swing.JButton button1;
	private javax.swing.JButton button2;
	private javax.swing.JButton button3;
	private javax.swing.JButton button4;
	private javax.swing.JButton button6;
	private javax.swing.JButton button8;
	private javax.swing.JButton button9;
	private javax.swing.JComboBox algorithme;
	private javax.swing.JButton generer;
	private javax.swing.JButton button5;
	private javax.swing.JButton button7;
	private javax.swing.JInternalFrame jInternalFrame1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator4;
	private javax.swing.JLabel label_1;
	private javax.swing.JLabel lblSupprimerEtudiant;
	public static String choix_algo = new String();
	private javax.swing.JButton demarrer;
	private final JButton choix_Manuel = new JButton("Choix Manuel");
	private static Vector<String> trans = new Vector<String>();

	Vector<JButton> v1 = new Vector<JButton>();

	// End of variables declaration
	/**
	 * Creates new form EtatClient
	 */
	public Interface_TP3(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		button9.setVisible(false);
		generer.addActionListener(new Action());
		demarrer.addActionListener(new Action());
		quitter.addActionListener(new Action());
		choix_Manuel.addActionListener(new Action());
		trans.add("1");
		trans.add("2");
		trans.add("3");
		trans.add("4");
		trans.add("5");
		trans.add("6");
		trans.add("7");
		trans.add("8");
		trans.add("0");
		v1.add(button1);
		v1.add(button2);
		v1.add(button3);
		v1.add(button4);
		v1.add(button5);
		v1.add(button6);
		v1.add(button7);
		v1.add(button8);
		v1.add(button9);
	}

	private void initComponents() {

		lblSupprimerEtudiant = new javax.swing.JLabel();
		demarrer = new javax.swing.JButton();
		quitter = new javax.swing.JButton();
		label_1 = new javax.swing.JLabel();
		algorithme = new javax.swing.JComboBox();
		jLabel1 = new javax.swing.JLabel();
		jInternalFrame1 = new javax.swing.JInternalFrame();
		button1 = new javax.swing.JButton();
		button3 = new javax.swing.JButton();
		button4 = new javax.swing.JButton();
		button2 = new javax.swing.JButton();
		button5 = new javax.swing.JButton();
		button6 = new javax.swing.JButton();
		button7 = new javax.swing.JButton();
		button8 = new javax.swing.JButton();
		button9 = new javax.swing.JButton();
		jSeparator1 = new javax.swing.JSeparator();
		jSeparator2 = new javax.swing.JSeparator();
		jSeparator3 = new javax.swing.JSeparator();
		jSeparator4 = new javax.swing.JSeparator();
		jSeparator4.setOrientation(SwingConstants.VERTICAL);
		generer = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		lblSupprimerEtudiant
				.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		lblSupprimerEtudiant.setText("--- P U Z Z L E ---");

		demarrer.setText("Demarrer le Jeu");

		quitter.setText("Quitter");

		label_1.setText("Choix De L'Algorithme :");

		algorithme.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Algorithme A* avec heuristique h1",
				"Algorithme A* avec heuristique h2",
				"Algorithme Du Coût uniforme" }));

		jLabel1.setText("Choix De L'Etat Initial :");

		jInternalFrame1.setFrameIcon(new javax.swing.ImageIcon(
				".\\images\\fenetre.png")); // NOI18N
		jInternalFrame1.setVisible(true);

		button1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
		button1.setText("1");

		button3.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
		button3.setText("3");

		button4.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
		button4.setText("4");

		button2.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
		button2.setText("2");

		button5.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
		button5.setText("5");

		button6.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
		button6.setText("6");

		button7.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
		button7.setText("7");

		button8.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
		button8.setText("8");

		button9.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N

		jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

		jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

		jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

		jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);

		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);

		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);

		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.BLACK);

		javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(
				jInternalFrame1.getContentPane());
		jInternalFrame1Layout
				.setHorizontalGroup(jInternalFrame1Layout
						.createParallelGroup(Alignment.LEADING)
						.addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(
								jInternalFrame1Layout
										.createSequentialGroup()
										.addGroup(
												jInternalFrame1Layout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																jInternalFrame1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jSeparator1,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				separator_6,
																				GroupLayout.PREFERRED_SIZE,
																				125,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jInternalFrame1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				jInternalFrame1Layout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								button7,
																								Alignment.TRAILING,
																								GroupLayout.PREFERRED_SIZE,
																								125,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								Alignment.TRAILING,
																								jInternalFrame1Layout
																										.createParallelGroup(
																												Alignment.LEADING)
																										.addComponent(
																												button1,
																												Alignment.TRAILING,
																												GroupLayout.PREFERRED_SIZE,
																												125,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												button4,
																												Alignment.TRAILING,
																												GroupLayout.PREFERRED_SIZE,
																												125,
																												GroupLayout.PREFERRED_SIZE))))
														.addGroup(
																jInternalFrame1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jSeparator2,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				separator_5,
																				GroupLayout.PREFERRED_SIZE,
																				125,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(14)
										.addComponent(jSeparator4,
												GroupLayout.PREFERRED_SIZE, 2,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												jInternalFrame1Layout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																jInternalFrame1Layout
																		.createParallelGroup(
																				Alignment.TRAILING,
																				false)
																		.addComponent(
																				button8,
																				Alignment.LEADING,
																				GroupLayout.DEFAULT_SIZE,
																				125,
																				Short.MAX_VALUE)
																		.addComponent(
																				button2,
																				Alignment.LEADING,
																				GroupLayout.DEFAULT_SIZE,
																				125,
																				Short.MAX_VALUE)
																		.addComponent(
																				button5,
																				Alignment.LEADING,
																				GroupLayout.DEFAULT_SIZE,
																				125,
																				Short.MAX_VALUE))
														.addComponent(
																separator_1,
																Alignment.TRAILING)
														.addComponent(
																separator_2,
																GroupLayout.PREFERRED_SIZE,
																125,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(separator,
												GroupLayout.PREFERRED_SIZE, 2,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												jInternalFrame1Layout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																jInternalFrame1Layout
																		.createParallelGroup(
																				Alignment.LEADING)
																		.addComponent(
																				button3,
																				Alignment.TRAILING,
																				GroupLayout.PREFERRED_SIZE,
																				125,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				button6,
																				Alignment.TRAILING,
																				GroupLayout.PREFERRED_SIZE,
																				125,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				button9,
																				Alignment.TRAILING,
																				GroupLayout.PREFERRED_SIZE,
																				125,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																separator_3,
																GroupLayout.PREFERRED_SIZE,
																125,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																separator_4,
																GroupLayout.PREFERRED_SIZE,
																125,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		jInternalFrame1Layout
				.setVerticalGroup(jInternalFrame1Layout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								jInternalFrame1Layout
										.createSequentialGroup()
										.addContainerGap(71, Short.MAX_VALUE)
										.addGroup(
												jInternalFrame1Layout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																separator,
																GroupLayout.PREFERRED_SIZE,
																350,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jInternalFrame1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jInternalFrame1Layout
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								jSeparator4,
																								Alignment.TRAILING)
																						.addGroup(
																								Alignment.TRAILING,
																								jInternalFrame1Layout
																										.createSequentialGroup()
																										.addGroup(
																												jInternalFrame1Layout
																														.createParallelGroup(
																																Alignment.BASELINE)
																														.addComponent(
																																button1,
																																GroupLayout.PREFERRED_SIZE,
																																87,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																button3,
																																GroupLayout.PREFERRED_SIZE,
																																87,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																button2,
																																GroupLayout.PREFERRED_SIZE,
																																87,
																																GroupLayout.PREFERRED_SIZE))
																										.addGroup(
																												jInternalFrame1Layout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																jInternalFrame1Layout
																																		.createSequentialGroup()
																																		.addGap(14)
																																		.addComponent(
																																				jSeparator1,
																																				GroupLayout.PREFERRED_SIZE,
																																				10,
																																				GroupLayout.PREFERRED_SIZE))
																														.addGroup(
																																jInternalFrame1Layout
																																		.createSequentialGroup()
																																		.addGap(18)
																																		.addComponent(
																																				separator_1,
																																				GroupLayout.PREFERRED_SIZE,
																																				GroupLayout.DEFAULT_SIZE,
																																				GroupLayout.PREFERRED_SIZE))
																														.addGroup(
																																jInternalFrame1Layout
																																		.createSequentialGroup()
																																		.addGap(18)
																																		.addComponent(
																																				separator_4,
																																				GroupLayout.PREFERRED_SIZE,
																																				GroupLayout.DEFAULT_SIZE,
																																				GroupLayout.PREFERRED_SIZE))
																														.addGroup(
																																jInternalFrame1Layout
																																		.createSequentialGroup()
																																		.addGap(18)
																																		.addComponent(
																																				separator_6,
																																				GroupLayout.PREFERRED_SIZE,
																																				GroupLayout.DEFAULT_SIZE,
																																				GroupLayout.PREFERRED_SIZE)))
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addGroup(
																												jInternalFrame1Layout
																														.createParallelGroup(
																																Alignment.BASELINE)
																														.addComponent(
																																button4,
																																GroupLayout.PREFERRED_SIZE,
																																87,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																button5,
																																GroupLayout.PREFERRED_SIZE,
																																87,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																button6,
																																GroupLayout.PREFERRED_SIZE,
																																87,
																																GroupLayout.PREFERRED_SIZE))
																										.addGap(26)
																										.addGroup(
																												jInternalFrame1Layout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																jSeparator2,
																																GroupLayout.PREFERRED_SIZE,
																																10,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																separator_2,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																separator_3,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																separator_5,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE))
																										.addGap(18)
																										.addGroup(
																												jInternalFrame1Layout
																														.createParallelGroup(
																																Alignment.BASELINE)
																														.addComponent(
																																button7,
																																GroupLayout.PREFERRED_SIZE,
																																87,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																button8,
																																GroupLayout.PREFERRED_SIZE,
																																87,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																button9,
																																GroupLayout.PREFERRED_SIZE,
																																87,
																																GroupLayout.PREFERRED_SIZE))))
																		.addGap(11)
																		.addComponent(
																				jSeparator3,
																				GroupLayout.PREFERRED_SIZE,
																				10,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);

		generer.setText("Generer Etat Initial");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(212)
																.addComponent(
																		lblSupprimerEtudiant))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(33)
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										label_1)
																								.addPreferredGap(
																										ComponentPlacement.UNRELATED)
																								.addComponent(
																										algorithme,
																										GroupLayout.PREFERRED_SIZE,
																										337,
																										GroupLayout.PREFERRED_SIZE))
																				.addGroup(
																						layout.createParallelGroup(
																								Alignment.TRAILING)
																								.addComponent(
																										demarrer)
																								.addGroup(
																										layout.createSequentialGroup()
																												.addComponent(
																														jLabel1)
																												.addPreferredGap(
																														ComponentPlacement.RELATED)
																												.addGroup(
																														layout.createParallelGroup(
																																Alignment.LEADING,
																																false)
																																.addGroup(
																																		layout.createSequentialGroup()
																																				.addComponent(
																																						choix_Manuel)
																																				.addPreferredGap(
																																						ComponentPlacement.RELATED,
																																						GroupLayout.DEFAULT_SIZE,
																																						Short.MAX_VALUE)
																																				.addComponent(
																																						generer))
																																.addGroup(
																																		Alignment.TRAILING,
																																		layout.createParallelGroup(
																																				Alignment.LEADING)
																																				.addComponent(
																																						jInternalFrame1,
																																						GroupLayout.PREFERRED_SIZE,
																																						GroupLayout.DEFAULT_SIZE,
																																						GroupLayout.PREFERRED_SIZE)
																																				.addGroup(
																																						layout.createSequentialGroup()
																																								.addGap(8)
																																								.addComponent(
																																										quitter)))))))))
								.addContainerGap(56, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(35)
								.addComponent(lblSupprimerEtudiant)
								.addGap(35)
								.addGroup(
										layout.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(label_1)
												.addComponent(
														algorithme,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(20)
								.addGroup(
										layout.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(generer)
												.addComponent(choix_Manuel))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												Alignment.LEADING)
												.addComponent(jLabel1)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jInternalFrame1,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.TRAILING)
																				.addComponent(
																						demarrer,
																						GroupLayout.PREFERRED_SIZE,
																						35,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						quitter))))
								.addContainerGap(37, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>

}
