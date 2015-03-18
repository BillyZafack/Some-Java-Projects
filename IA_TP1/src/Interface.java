import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

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
public class Interface extends javax.swing.JDialog {

	class action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == par_Fermante) {
				main_textField.setText(main_textField.getText() + ")");
				tests();
			}
			if (e.getSource() == par_Ouvre) {
				main_textField.setText(main_textField.getText() + "(");
				tests();
			}
			if (e.getSource() == pButton) {
				main_textField.setText(main_textField.getText() + "P");
				tests();
			}
			if (e.getSource() == q_Button) {
				main_textField.setText(main_textField.getText() + "Q");
				tests();
			}
			if (e.getSource() == r_Button) {
				main_textField.setText(main_textField.getText() + "R");
				tests();
			}
			if (e.getSource() == reinit) {
				main_textField.setText("");
				syntaxe_textField.setText("");
				consistant_textField.setText("");
				contingent_textField.setText("");
				valide_textField.setText("");
			}
			if (e.getSource() == s_Button) {
				main_textField.setText(main_textField.getText() + "S");
				tests();
			}
			if (e.getSource() == t_Button) {
				main_textField.setText(main_textField.getText() + "V");
				tests();
			}
			if (e.getSource() == u_Button) {
				main_textField.setText(main_textField.getText() + "U");
				tests();
			}
			if (e.getSource() == v_Button) {
				main_textField.setText(main_textField.getText() + "F");
				tests();
			}
			if (e.getSource() == w_Button) {
				main_textField.setText(main_textField.getText() + "W");
				tests();
			}
			if (e.getSource() == x_Button) {
				main_textField.setText(main_textField.getText() + "X");
				tests();
			}
			if (e.getSource() == y_Button) {
				main_textField.setText(main_textField.getText() + "Y");
				tests();
			}
			if (e.getSource() == non_OP) {
				main_textField.setText(main_textField.getText() + non_code);
				tests();
			}
			if (e.getSource() == effacer) {
				if (!main_textField.getText().equals("")) {
					main_textField.setText(main_textField.getText().substring(
							0, main_textField.getText().length() - 1));
					if (!main_textField.getText().equals("")) {
						tests();
					} else {
						syntaxe_textField.setText("");
						valide_textField.setText("");
						consistant_textField.setText("");
						contingent_textField.setText("");
					}
				}

			}
			if (e.getSource() == equiv_OP) {
				main_textField.setText(main_textField.getText()
						+ equivalent_code);
				tests();
			}
			if (e.getSource() == et_OP) {
				main_textField.setText(main_textField.getText() + et_code);
				tests();
			}
			if (e.getSource() == ou_OP) {
				main_textField.setText(main_textField.getText() + ou_code);
				tests();
			}
			if (e.getSource() == implique_OP) {
				main_textField
						.setText(main_textField.getText() + implique_code);
				tests();
			}
			if (e.getSource() == valider) {
				tests();
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
			java.util.logging.Logger.getLogger(Interface.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Interface.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Interface.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Interface.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Interface dialog = new Interface(new javax.swing.JFrame(), true);
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
	private javax.swing.JTextField consistant_textField;

	private javax.swing.JTextField contingent_textField;

	private javax.swing.JButton effacer;
	private javax.swing.JButton equiv_OP;
	private javax.swing.JButton et_OP;
	private javax.swing.JButton implique_OP;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JTextField main_textField;
	private javax.swing.JButton non_OP;
	private javax.swing.JButton ou_OP;
	private javax.swing.JButton pButton;
	private javax.swing.JButton par_Fermante;
	private javax.swing.JButton par_Ouvre;
	private javax.swing.JButton q_Button;
	private javax.swing.JButton r_Button;
	private javax.swing.JButton reinit;
	private javax.swing.JButton s_Button;
	private javax.swing.JTextField syntaxe_textField;
	private javax.swing.JButton t_Button;
	private javax.swing.JButton u_Button;
	private javax.swing.JButton v_Button;
	private javax.swing.JTextField valide_textField;
	private javax.swing.JButton valider;
	private javax.swing.JButton w_Button;
	private javax.swing.JButton x_Button;
	private final String et_code = "\u02C4";
	private final String ou_code = "\u02C5";
	private final String non_code = "\u02E5";
	private final String implique_code = "\u0186";
	private final String equivalent_code = "\u2261";

	private javax.swing.JButton y_Button;

	// End of variables declaration
	/**
	 * Creates new form SF_TP1_Interface
	 */
	public Interface(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	private void effacerActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	public boolean inconsistant1() {
		String s = main_textField.getText();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '\u02E5':
				s = s.replace("\u02E5", " non ");
				break;
			case '\u02C4':
				s = s.replace("\u02C4", " et ");
				break;
			case '\u02C5':
				s = s.replace("\u02C5", " ou ");
				break;
			case '\u0186':
				s = s.replace("\u0186", " imp ");
				break;
			case '\u2261':
				s = s.replace("\u2261", " eqv ");
				break;
			case 'V':
				s = s.replace("V", " vrai ");
				break;
			case 'F':
				s = s.replace("F", " faux ");
				break;
			}
		}
		try {
			Query q1 = new Query("consult",
					new Term[] { new Atom("Gestion.pl") });
			if (q1.hasSolution()) {
				String s1 = new String(
						"member(P,[vrai,faux]),member(Q,[vrai,faux]),member(R,[vrai,faux]),member(S,[vrai,faux]),member(U,[vrai,faux]),member(W,[vrai,faux]),member(X,[vrai,faux]),member(Y,[vrai,faux])");
				Query m = new Query(s1 + ",valeur(" + s + ",V),V=vrai .");
				if (m.hasSolution()) {
					return false;
				} else {
					return true;
				}
			} else {
				JOptionPane.showMessageDialog(this,
						"ERREUR D'OUVERTURE DU FICHIER 'Gestions.pl' !!!",
						"ERREUR !!!", JOptionPane.ERROR_MESSAGE);
				main_textField.setBackground(Color.red);
			}
		} catch (PrologException e) {
			main_textField.setBackground(Color.red);
		}
		return false;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		main_textField = new javax.swing.JTextField();
		valide_textField = new javax.swing.JTextField();
		contingent_textField = new javax.swing.JTextField();
		consistant_textField = new javax.swing.JTextField();
		syntaxe_textField = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		pButton = new javax.swing.JButton();
		v_Button = new javax.swing.JButton();
		v_Button.setBackground(Color.RED);
		x_Button = new javax.swing.JButton();
		w_Button = new javax.swing.JButton();
		t_Button = new javax.swing.JButton();
		t_Button.setBackground(Color.RED);
		u_Button = new javax.swing.JButton();
		r_Button = new javax.swing.JButton();
		s_Button = new javax.swing.JButton();
		q_Button = new javax.swing.JButton();
		y_Button = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		non_OP = new javax.swing.JButton();
		equiv_OP = new javax.swing.JButton();
		par_Fermante = new javax.swing.JButton();
		par_Ouvre = new javax.swing.JButton();
		ou_OP = new javax.swing.JButton();
		implique_OP = new javax.swing.JButton();
		et_OP = new javax.swing.JButton();
		reinit = new javax.swing.JButton();
		valider = new javax.swing.JButton();
		effacer = new javax.swing.JButton();
		par_Fermante.addActionListener(new action());
		par_Ouvre.addActionListener(new action());
		pButton.addActionListener(new action());
		q_Button.addActionListener(new action());
		r_Button.addActionListener(new action());
		reinit.addActionListener(new action());
		s_Button.addActionListener(new action());
		syntaxe_textField.addActionListener(new action());
		t_Button.addActionListener(new action());
		u_Button.addActionListener(new action());
		v_Button.addActionListener(new action());
		valide_textField.addActionListener(new action());
		valider.addActionListener(new action());
		w_Button.addActionListener(new action());
		x_Button.addActionListener(new action());
		y_Button.addActionListener(new action());
		non_OP.addActionListener(new action());
		et_OP.addActionListener(new action());
		ou_OP.addActionListener(new action());
		equiv_OP.addActionListener(new action());
		implique_OP.addActionListener(new action());
		effacer.addActionListener(new action());
		main_textField.addActionListener(new action());
		consistant_textField.addActionListener(new action());
		contingent_textField.addActionListener(new action());

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		main_textField.setEditable(false);
		main_textField.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N

		valide_textField.setEditable(false);
		valide_textField.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N

		contingent_textField.setEditable(false);
		contingent_textField.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N

		consistant_textField.setEditable(false);
		consistant_textField.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N

		syntaxe_textField.setEditable(false);
		syntaxe_textField.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N

		jLabel1.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
		jLabel1.setText("PROPOSITIONS");

		pButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		pButton.setText("P");

		v_Button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		v_Button.setText("Faux");

		x_Button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		x_Button.setText("X");

		w_Button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		w_Button.setText("W");

		t_Button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		t_Button.setText("Vrai");

		u_Button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		u_Button.setText("U");

		r_Button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		r_Button.setText("R");

		s_Button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		s_Button.setText("S");

		q_Button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		q_Button.setText("Q");

		y_Button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		y_Button.setText("Y");

		jLabel2.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
		jLabel2.setText("OPERATEURS");

		non_OP.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		non_OP.setText("˥");

		equiv_OP.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		equiv_OP.setText("≡");

		par_Fermante.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		par_Fermante.setText(")");

		par_Ouvre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		par_Ouvre.setText("(");
		par_Ouvre.setToolTipText("");

		ou_OP.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		ou_OP.setText("ᴠ");

		implique_OP.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		implique_OP.setText("=>");
		implique_OP.setToolTipText("");

		et_OP.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		et_OP.setText("ᴧ");

		reinit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		reinit.setText("CE");

		valider.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		valider.setText("VALIDER");

		effacer.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
		effacer.setText("<----");
		effacer.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				effacerActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												Alignment.TRAILING, false)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(26)
																								.addGroup(
																										layout.createParallelGroup(
																												Alignment.LEADING)
																												.addComponent(
																														q_Button,
																														GroupLayout.PREFERRED_SIZE,
																														123,
																														GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														t_Button,
																														GroupLayout.PREFERRED_SIZE,
																														123,
																														GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														w_Button,
																														GroupLayout.PREFERRED_SIZE,
																														123,
																														GroupLayout.PREFERRED_SIZE))
																								.addGap(41)
																								.addGroup(
																										layout.createParallelGroup(
																												Alignment.TRAILING)
																												.addComponent(
																														jLabel1)
																												.addComponent(
																														pButton,
																														GroupLayout.PREFERRED_SIZE,
																														123,
																														GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														r_Button,
																														GroupLayout.PREFERRED_SIZE,
																														123,
																														GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														u_Button,
																														GroupLayout.PREFERRED_SIZE,
																														123,
																														GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														x_Button,
																														GroupLayout.PREFERRED_SIZE,
																														123,
																														GroupLayout.PREFERRED_SIZE))
																								.addGroup(
																										layout.createParallelGroup(
																												Alignment.LEADING)
																												.addGroup(
																														layout.createSequentialGroup()
																																.addGap(34)
																																.addGroup(
																																		layout.createParallelGroup(
																																				Alignment.LEADING)
																																				.addGroup(
																																						layout.createSequentialGroup()
																																								.addComponent(
																																										valide_textField,
																																										GroupLayout.PREFERRED_SIZE,
																																										290,
																																										GroupLayout.PREFERRED_SIZE)
																																								.addGap(77)
																																								.addComponent(
																																										consistant_textField,
																																										GroupLayout.PREFERRED_SIZE,
																																										273,
																																										GroupLayout.PREFERRED_SIZE))
																																				.addGroup(
																																						layout.createSequentialGroup()
																																								.addGroup(
																																										layout.createParallelGroup(
																																												Alignment.TRAILING,
																																												false)
																																												.addGroup(
																																														layout.createSequentialGroup()
																																																.addComponent(
																																																		y_Button,
																																																		GroupLayout.PREFERRED_SIZE,
																																																		123,
																																																		GroupLayout.PREFERRED_SIZE)
																																																.addPreferredGap(
																																																		ComponentPlacement.RELATED,
																																																		GroupLayout.DEFAULT_SIZE,
																																																		Short.MAX_VALUE)
																																																.addComponent(
																																																		implique_OP,
																																																		GroupLayout.PREFERRED_SIZE,
																																																		101,
																																																		GroupLayout.PREFERRED_SIZE))
																																												.addGroup(
																																														Alignment.LEADING,
																																														layout.createSequentialGroup()
																																																.addComponent(
																																																		v_Button,
																																																		GroupLayout.PREFERRED_SIZE,
																																																		123,
																																																		GroupLayout.PREFERRED_SIZE)
																																																.addPreferredGap(
																																																		ComponentPlacement.RELATED,
																																																		GroupLayout.DEFAULT_SIZE,
																																																		Short.MAX_VALUE)
																																																.addComponent(
																																																		et_OP,
																																																		GroupLayout.PREFERRED_SIZE,
																																																		101,
																																																		GroupLayout.PREFERRED_SIZE))
																																												.addGroup(
																																														Alignment.LEADING,
																																														layout.createSequentialGroup()
																																																.addComponent(
																																																		s_Button,
																																																		GroupLayout.PREFERRED_SIZE,
																																																		123,
																																																		GroupLayout.PREFERRED_SIZE)
																																																.addGap(122)
																																																.addComponent(
																																																		par_Ouvre,
																																																		GroupLayout.PREFERRED_SIZE,
																																																		101,
																																																		GroupLayout.PREFERRED_SIZE)))
																																								.addGap(84)
																																								.addGroup(
																																										layout.createParallelGroup(
																																												Alignment.LEADING)
																																												.addComponent(
																																														equiv_OP,
																																														GroupLayout.PREFERRED_SIZE,
																																														101,
																																														GroupLayout.PREFERRED_SIZE)
																																												.addComponent(
																																														ou_OP,
																																														GroupLayout.PREFERRED_SIZE,
																																														101,
																																														GroupLayout.PREFERRED_SIZE)
																																												.addComponent(
																																														par_Fermante,
																																														GroupLayout.PREFERRED_SIZE,
																																														101,
																																														GroupLayout.PREFERRED_SIZE)))))
																												.addGroup(
																														layout.createSequentialGroup()
																																.addGap(360)
																																.addGroup(
																																		layout.createParallelGroup(
																																				Alignment.TRAILING)
																																				.addComponent(
																																						jLabel2)
																																				.addComponent(
																																						non_OP,
																																						GroupLayout.PREFERRED_SIZE,
																																						101,
																																						GroupLayout.PREFERRED_SIZE)))))
																				.addComponent(
																						syntaxe_textField,
																						GroupLayout.PREFERRED_SIZE,
																						291,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						reinit,
																						GroupLayout.PREFERRED_SIZE,
																						235,
																						GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		ComponentPlacement.RELATED,
																		79,
																		Short.MAX_VALUE)
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.TRAILING)
																				.addComponent(
																						contingent_textField,
																						GroupLayout.PREFERRED_SIZE,
																						235,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						effacer,
																						GroupLayout.PREFERRED_SIZE,
																						235,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						valider,
																						GroupLayout.PREFERRED_SIZE,
																						247,
																						GroupLayout.PREFERRED_SIZE)))
												.addComponent(main_textField,
														1313, 1313, 1313))
								.addContainerGap(413, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(40)
								.addComponent(main_textField,
										GroupLayout.PREFERRED_SIZE, 142,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														valide_textField,
														GroupLayout.PREFERRED_SIZE,
														64,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														consistant_textField,
														GroupLayout.PREFERRED_SIZE,
														64,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														syntaxe_textField,
														GroupLayout.PREFERRED_SIZE,
														64,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														contingent_textField,
														GroupLayout.PREFERRED_SIZE,
														64,
														GroupLayout.PREFERRED_SIZE))
								.addGap(17)
								.addGroup(
										layout.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														reinit,
														GroupLayout.PREFERRED_SIZE,
														66,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														effacer,
														GroupLayout.PREFERRED_SIZE,
														66,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(jLabel2))
								.addGap(18)
								.addGroup(
										layout.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														pButton,
														GroupLayout.PREFERRED_SIZE,
														65,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														non_OP,
														GroupLayout.PREFERRED_SIZE,
														65,
														GroupLayout.PREFERRED_SIZE))
								.addGap(10)
								.addGroup(
										layout.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														q_Button,
														GroupLayout.PREFERRED_SIZE,
														65,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														r_Button,
														GroupLayout.PREFERRED_SIZE,
														65,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														s_Button,
														GroupLayout.PREFERRED_SIZE,
														65,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														par_Ouvre,
														GroupLayout.PREFERRED_SIZE,
														65,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														par_Fermante,
														GroupLayout.PREFERRED_SIZE,
														65,
														GroupLayout.PREFERRED_SIZE))
								.addGap(6)
								.addGroup(
										layout.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						t_Button,
																						GroupLayout.PREFERRED_SIZE,
																						65,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						u_Button,
																						GroupLayout.PREFERRED_SIZE,
																						65,
																						GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addComponent(
																		w_Button,
																		GroupLayout.PREFERRED_SIZE,
																		65,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						v_Button,
																						GroupLayout.PREFERRED_SIZE,
																						65,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						et_OP,
																						GroupLayout.PREFERRED_SIZE,
																						65,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						ou_OP,
																						GroupLayout.PREFERRED_SIZE,
																						65,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						valider,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																.addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						x_Button,
																						GroupLayout.PREFERRED_SIZE,
																						65,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						y_Button,
																						GroupLayout.PREFERRED_SIZE,
																						65,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						implique_OP,
																						GroupLayout.PREFERRED_SIZE,
																						65,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						equiv_OP,
																						GroupLayout.PREFERRED_SIZE,
																						65,
																						GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(14, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>

	public void tests() {
		if (testSyntax()) {
			syntaxe_textField.setText("Syntaxe Correcte");
			if (valide1()) {
				valide_textField.setText("FBF Valide");
			} else if (!valide1()) {
				valide_textField.setText("Invalide");
			}
			if (inconsistant1()) {
				consistant_textField.setText("FBF Inconsistante");
			} else if (!inconsistant1()) {
				consistant_textField.setText("FBF Consistante");
			}
			if (!inconsistant1() && !valide1()) {
				contingent_textField.setText("FBF Contingente");
			} else if (inconsistant1() || valide1()) {
				contingent_textField.setText("FBF Non-Contingente");
			}
		} else {
			syntaxe_textField.setText("Syntaxe Incorrecte");
			consistant_textField.setText("Indefinie pour une non-FBF");
			contingent_textField.setText("Indefinie pour une non-FBF");
			valide_textField.setText("Indefinie pour une non-FBF");
		}

	}

	public boolean testSyntax() {
		String s = main_textField.getText();
		int ouvre, ferme, cons;
		boolean flag = true;
		boolean paranthese = true;
		ouvre = ferme = cons = 0;
		if (s.contains("(") || s.contains(")")) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					ouvre++;
					cons++;
				}
				if (s.charAt(i) == ')') {

					if (cons <= 0) {
						paranthese = false;
					}
					ferme++;
					cons--;
				}
			}
			if (!(paranthese && ferme == ouvre)) {
				flag = false;
			}
		}
		s = s.replace("(", "");
		s = s.replace(")", "");
		s = s.replaceAll("([PQRSVUFWXY]([PQRSVUFWXY])+)", "B");
		for (int i = 0; i < s.length(); i++) {
			s = s.replaceAll("[PQRSVUFWXY]", "A");
			s = s.replaceAll(non_code + "A", "A");
			s = s.replaceAll("A" + et_code + "A", "A");
			s = s.replaceAll("A" + ou_code + "A", "A");
			s = s.replaceAll("A" + implique_code + "A", "A");
			s = s.replaceAll("A" + equivalent_code + "A", "A");
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != 'A') {
				flag = false;
			}
		}
		return flag;
	}

	public boolean valide1() {
		String s = main_textField.getText();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '\u02E5':
				s = s.replace("\u02E5", " non ");
				break;
			case '\u02C4':
				s = s.replace("\u02C4", " et ");
				break;
			case '\u02C5':
				s = s.replace("\u02C5", " ou ");
				break;
			case '\u0186':
				s = s.replace("\u0186", " imp ");
				break;
			case '\u2261':
				s = s.replace("\u2261", " eqv ");
				break;
			case 'V':
				s = s.replace("V", " vrai ");
				break;
			case 'F':
				s = s.replace("F", " faux ");
				break;
			}
		}
		try {
			Query q1 = new Query("consult",
					new Term[] { new Atom("Gestion.pl") });
			if (q1.hasSolution()) {
				String s1 = new String(
						"member(P,[vrai,faux]),member(Q,[vrai,faux]),member(R,[vrai,faux]),member(S,[vrai,faux]),member(U,[vrai,faux]),member(W,[vrai,faux]),member(X,[vrai,faux]),member(Y,[vrai,faux])");
				System.out.println("ssss  ss " + s);
				Query l = new Query(s1 + ",valeur(" + s + ",V),V=faux.");
				Query m = new Query(s1 + ",valeur(" + s + ",V),V=vrai.");
				if (l.hasSolution()) {
					return false;
				} else {
					return true;
				}
			} else {
				JOptionPane.showMessageDialog(this,
						"ERREUR D'OUVERTURE DU FICHIER 'Prologs.pl' !!!",
						"ERREUR !!!", JOptionPane.ERROR_MESSAGE);
				main_textField.setBackground(Color.red);
			}
		} catch (PrologException e) {
			main_textField.setBackground(Color.red);
		}
		return false;

	}
}
