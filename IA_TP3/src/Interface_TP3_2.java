import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
public class Interface_TP3_2 extends javax.swing.JDialog {

	// End of variables declaration
	class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == quitter) {
				setVisible(false);
			}
			if (e.getSource() == rejouer) {
				setVisible(false);
				new Interface_TP3(new JFrame(), true).setVisible(true);
			}
			if (e.getSource() == suivant) {
				if (algorithme.getText().equals(
						"Algorithme A* avec heuristique h1")
						|| algorithme.getText().equals(
								"Algorithme A* avec heuristique h2")) {
					precedent.setEnabled(true);
					System.out.println("### " + position);
					if (position + 1 < vv.size() && position + 1 > 0) {
						position++;

						setBtn(vv.get(position));
					} else {
						suivant.setEnabled(false);
						JOptionPane.showMessageDialog(Interface_TP3_2.this,
								"Le cas finale a ete atteint", "JEU TERMINE",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					precedent.setEnabled(true);
					System.out.println("### " + position1);
					if (position1 + 1 < vv.size()) {
						position1++;

						setBtn(vv.get(position1));
					} else {
						suivant.setEnabled(false);
						JOptionPane.showMessageDialog(Interface_TP3_2.this,
								"Le cas finale a ete atteint", "JEU TERMINE",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
			if (e.getSource() == precedent) {
				if (algorithme.getText().equals(
						"Algorithme A* avec heuristique h1")
						|| algorithme.getText().equals(
								"Algorithme A* avec heuristique h2")) {
					System.out.println("### " + position);
					suivant.setEnabled(true);
					if (position - 1 > 1) {
						position--;
						setBtn(vv.get(position));
					} else if (position - 1 == 0 || position - 1 == 1) {
						precedent.setEnabled(false);
					} else {
						precedent.setEnabled(false);
						JOptionPane.showMessageDialog(Interface_TP3_2.this,
								"Le cas finale a ete atteint", "JEU TERMINE",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					System.out.println("### " + position1);
					suivant.setEnabled(true);
					if (position1 - 1 > 1) {
						position1--;
						setBtn(vv.get(position1));
					} else if (position1 - 1 == 0 || position1 - 1 == 1) {
						precedent.setEnabled(false);
					} else {
						precedent.setEnabled(false);
						JOptionPane.showMessageDialog(Interface_TP3_2.this,
								"Le cas finale a ete atteint", "JEU TERMINE",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JTextField algorithme;

	private javax.swing.JButton precedent;

	private javax.swing.JButton button1;
	private javax.swing.JButton button2;
	private javax.swing.JButton button3;
	private javax.swing.JButton button4;
	private javax.swing.JButton button6;
	private javax.swing.JButton button8;
	private javax.swing.JButton button9;
	private javax.swing.JButton button5;
	private javax.swing.JButton button7;
	private javax.swing.JInternalFrame jInternalFrame1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel label_1;
	private javax.swing.JLabel lblSupprimerEtudiant;
	private javax.swing.JButton suivant;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JPanel jPanel9;
	private final Vector<String> vv = new Vector<String>();
	private final Vector<String> vv_a_star_h1 = new Vector<String>();
	private final Vector<String> vv_a_star_h2 = new Vector<String>();
	private final Vector<JButton> v1 = new Vector<JButton>();
	private final Vector<JPanel> panels = new Vector<JPanel>();
	private JButton quitter;
	private JButton rejouer;
	private Vector<String> vector = new Vector<String>();
	private int position = 1;
	private int position1 = 0;

	public Interface_TP3_2(java.awt.Frame parent, boolean modal,
			Vector<String> trans1) {
		super(parent, modal);
		initComponents2();
		precedent.setEnabled(false);
		vector = trans1;
		algorithme.setText(Interface_TP3.choix_algo);
		v1.add(button1);
		v1.add(button2);
		v1.add(button3);
		v1.add(button4);
		v1.add(button5);
		v1.add(button6);
		v1.add(button7);
		v1.add(button8);
		v1.add(button9);
		for (int i = 0; i < v1.size(); i++) {
			v1.get(i).setVisible(true);
		}
		for (int i = 0; i < trans1.size(); i++) {
			if (trans1.get(i).equals("0")) {
				v1.get(i).setVisible(false);
			} else {
				v1.get(i).setText(trans1.get(i));
			}

		}
		panels.add(jPanel2);
		panels.add(jPanel3);
		panels.add(jPanel4);
		panels.add(jPanel7);
		panels.add(jPanel5);
		panels.add(jPanel8);
		panels.add(jPanel9);
		panels.add(jPanel10);
		panels.add(jPanel11);
		jPanel2.setBounds(48, 48, 100, 100);

		reposition();

		//

		v1.get(0).setBounds(48, 48, 100, 100);
		v1.get(1).setBounds(48 + 100 + 48, 48, 100, 100);
		v1.get(2).setBounds(48 + 100 + 48 + 100 + 48, 48, 100, 100);
		v1.get(3).setBounds(48, 48 + 100 + 48, 100, 100);
		v1.get(4).setBounds(48 + 100 + 48, 48 + 100 + 48, 100, 100);
		v1.get(5).setBounds(48 + 100 + 48 + 100 + 48, 48 + 100 + 48, 100, 100);
		v1.get(6).setBounds(48, 48 + 100 + 48 + 100 + 48, 100, 100);
		v1.get(7).setBounds(48 + 100 + 48, 48 + 100 + 48 + 100 + 48, 100, 100);
		v1.get(8).setBounds(48 + 100 + 48 + 100 + 48, 48 + 100 + 48 + 100 + 48,
				100, 100);

		quitter.addActionListener(new Action());
		rejouer.addActionListener(new Action());
		precedent.addActionListener(new Action());
		suivant.addActionListener(new Action());
		switch (algorithme.getText()) {
		case "Algorithme A* avec heuristique h1":
			String ss = contactProlog_2();
			try {
				ss = ss.substring(1, ss.length() - 1);
				String[] s = ss.split("]");
				Vector<String> d = new Vector<String>();
				for (int i = 0; i < s.length; i++) {
					s[i] = s[i].replace("[", "");
					s[i] = s[i].replace("]", "");
					s[i] = s[i].replace(",", "");
					s[i] = s[i].replace(" ", "");
					s[i] = s[i].replace(")", "");
					s[i] = s[i].replace("(", "");
					s[i] = s[i].replace("'", "");
					s[i] = s[i].replace(".", "");
					d.add(s[i]);
				}

				for (int i = d.size() - 1; i >= 0; i--) {
					vv.add(d.get(i));
				}
			} catch (StringIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(this,
						"Cet disposition n'est pas solvable en temps fini",
						"NON-SOLVABLE", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				new Interface_TP3(new JFrame(), true);
			}
			break;

		case "Algorithme A* avec heuristique h2":
			String sz = contactProlog_2();
			try {
				ss = sz.substring(1, sz.length() - 1);
				String[] s = sz.split("]");
				Vector<String> d = new Vector<String>();
				for (int i = 0; i < s.length; i++) {
					s[i] = s[i].replace("[", "");
					s[i] = s[i].replace("]", "");
					s[i] = s[i].replace(",", "");
					s[i] = s[i].replace(" ", "");
					s[i] = s[i].replace(")", "");
					s[i] = s[i].replace("(", "");
					s[i] = s[i].replace("'", "");
					s[i] = s[i].replace(".", "");
					d.add(s[i]);
				}

				for (int i = d.size() - 1; i >= 0; i--) {
					vv.add(d.get(i));
				}
			} catch (StringIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(this,
						"Cet disposition n'est pas solvable en temps fini",
						"NON-SOLVABLE", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				new Interface_TP3(new JFrame(), true);
			}
			break;

		case "Algorithme Du Coût uniforme":
			String s2 = contactProlog();
			try {
				s2 = s2.substring(1, s2.length() - 1);
				String[] s = s2.split("]");
				Vector<String> d = new Vector<String>();
				for (int i = 0; i < s.length - 2; i++) {
					s[i] = s[i].replace("[", "");
					s[i] = s[i].replace("]", "");
					s[i] = s[i].replace(",", "");
					s[i] = s[i].replace(")", "");
					s[i] = s[i].replace("(", "");
					s[i] = s[i].replace("'", "");
					s[i] = s[i].replace(".", "");
					s[i] = s[i].replace(" ", "");
					d.add(s[i]);
				}
				vv.removeAllElements();
				for (int i = d.size() - 1; i >= 0; i--) {
					vv.add(d.get(i));
				}
			} catch (StringIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(this,
						"Cet disposition n'est pas solvable en temps fini",
						"NON-SOLVABLE", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				new Interface_TP3(new JFrame(), true);
			}
			break;
		}

	}

	public String contactProlog() {
		String s1 = new String();
		try {
			Query q1 = new Query("consult", new Term[] { new Atom("TP3.pl") });
			String s = new String();
			s = "[";
			for (int i = 0; i <= 8; i++) {
				if (i != 8) {
					s = s + vector.get(i) + ",";
				} else {
					s = s + vector.get(i) + "]";
				}
			}

			if (q1.hasSolution()) {
				Query l = new Query("breadth_first_search(" + s + ",A)");
				if (l.hasSolution()) {
					System.out.println("%%%%% " + l.oneSolution().toString());
					s1 = l.oneSolution().get("A").toString();
				} else {
					s1 = "false";
				}
			} else {
				JOptionPane.showMessageDialog(this,
						"ERREUR D'OUVERTURE DU FICHIER 'Prologs.pl' !!!",
						"ERREUR !!!", JOptionPane.ERROR_MESSAGE);
			}
		} catch (PrologException e) {
			e.printStackTrace();
		}
		return s1;
	}

	public String contactProlog_2() {
		String s1 = new String();
		try {
			Query q1 = new Query("consult", new Term[] { new Atom("TP3.pl") });
			String s = new String();
			s = "[[[";
			for (int i = 0; i <= 8; i++) {
				if (i != 8) {
					s = s + vector.get(i) + ",";
				} else {
					s = s + vector.get(i) + "]]]";
				}
			}

			if (q1.hasSolution()) {
				Query l = new Query("a_star(" + s
						+ ",[0,1,2,3,4,5,6,7,8],Chemin,Nb)");
				if (l.hasSolution()) {
					System.out.println("}}}}}  "
							+ l.oneSolution().get("Chemin").toString());
					s1 = l.oneSolution().get("Chemin").toString();
				} else {
					s1 = "false";
					System.out.println("}AAAA}}  "
							+ l.oneSolution().get("Chemin").toString());
				}
			} else {
				JOptionPane.showMessageDialog(this,
						"ERREUR D'OUVERTURE DU FICHIER 'Prologs.pl' !!!",
						"ERREUR !!!", JOptionPane.ERROR_MESSAGE);
			}
		} catch (PrologException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,
					"ERREUR D'OUVERTURE DU FICHIER 'Prologs.pl' !!!",
					"ERREUR !!!", JOptionPane.ERROR_MESSAGE);
		}
		return s1;
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents2() {

		lblSupprimerEtudiant = new javax.swing.JLabel();
		suivant = new javax.swing.JButton();
		precedent = new javax.swing.JButton();
		label_1 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jInternalFrame1 = new javax.swing.JInternalFrame();
		jPanel2 = new javax.swing.JPanel();
		button1 = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		button2 = new javax.swing.JButton();
		jPanel4 = new javax.swing.JPanel();
		button3 = new javax.swing.JButton();
		jPanel5 = new javax.swing.JPanel();
		button5 = new javax.swing.JButton();
		jPanel7 = new javax.swing.JPanel();
		button4 = new javax.swing.JButton();
		jPanel8 = new javax.swing.JPanel();
		button6 = new javax.swing.JButton();
		jPanel9 = new javax.swing.JPanel();
		button7 = new javax.swing.JButton();
		jPanel10 = new javax.swing.JPanel();
		button8 = new javax.swing.JButton();
		jPanel11 = new javax.swing.JPanel();
		button9 = new javax.swing.JButton();
		quitter = new javax.swing.JButton();
		algorithme = new javax.swing.JTextField();
		rejouer = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		lblSupprimerEtudiant
				.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		lblSupprimerEtudiant.setText("--- P U Z Z L E ---");

		suivant.setText("SUIVANT");

		precedent.setText("PRECEDENT");
		precedent.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				precedentActionPerformed(evt);
			}
		});

		label_1.setText("Choix De L'Algorithme :");

		jLabel1.setText("Evolution De ce Puzzle :");

		jInternalFrame1
				.setFrameIcon(new javax.swing.ImageIcon(
						"C:\\Users\\Zafack Billy\\Documents\\java_pp\\Gestion\\images\\fenetre.png")); // NOI18N
		jInternalFrame1.setVisible(true);

		jPanel2.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		button1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
		button1.setText("1");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button1, javax.swing.GroupLayout.DEFAULT_SIZE, 100,
				Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button1, javax.swing.GroupLayout.DEFAULT_SIZE, 100,
				Short.MAX_VALUE));

		jPanel3.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		button2.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
		button2.setText("2");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button2, javax.swing.GroupLayout.DEFAULT_SIZE, 102,
				Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button2, javax.swing.GroupLayout.DEFAULT_SIZE, 102,
				Short.MAX_VALUE));

		jPanel4.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		button3.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
		button3.setText("3");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button3, javax.swing.GroupLayout.DEFAULT_SIZE, 102,
				Short.MAX_VALUE));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button3, javax.swing.GroupLayout.DEFAULT_SIZE, 102,
				Short.MAX_VALUE));

		jPanel5.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		button5.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
		button5.setText("5");

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button5, javax.swing.GroupLayout.DEFAULT_SIZE, 100,
				Short.MAX_VALUE));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button5, javax.swing.GroupLayout.DEFAULT_SIZE, 100,
				Short.MAX_VALUE));

		jPanel7.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		button4.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
		button4.setText("4");

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(
				jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button4, javax.swing.GroupLayout.DEFAULT_SIZE, 102,
				Short.MAX_VALUE));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button4, javax.swing.GroupLayout.DEFAULT_SIZE, 102,
				Short.MAX_VALUE));

		jPanel8.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		button6.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
		button6.setText("6");

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(
				jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button6, javax.swing.GroupLayout.DEFAULT_SIZE, 104,
				Short.MAX_VALUE));
		jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button6, javax.swing.GroupLayout.DEFAULT_SIZE, 104,
				Short.MAX_VALUE));

		jPanel9.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		button7.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
		button7.setText("7");

		javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(
				jPanel9);
		jPanel9.setLayout(jPanel9Layout);
		jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button7, javax.swing.GroupLayout.DEFAULT_SIZE, 104,
				Short.MAX_VALUE));
		jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button7, javax.swing.GroupLayout.DEFAULT_SIZE, 104,
				Short.MAX_VALUE));

		jPanel10.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		button8.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
		button8.setText("8");

		javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(
				jPanel10);
		jPanel10.setLayout(jPanel10Layout);
		jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button8, javax.swing.GroupLayout.DEFAULT_SIZE, 104,
				Short.MAX_VALUE));
		jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button8, javax.swing.GroupLayout.DEFAULT_SIZE, 104,
				Short.MAX_VALUE));

		jPanel11.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		button9.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N

		javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(
				jPanel11);
		jPanel11.setLayout(jPanel11Layout);
		jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button9, javax.swing.GroupLayout.DEFAULT_SIZE, 102,
				Short.MAX_VALUE));
		jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				button9, javax.swing.GroupLayout.DEFAULT_SIZE, 102,
				Short.MAX_VALUE));

		javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(
				jInternalFrame1.getContentPane());
		jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
		jInternalFrame1Layout
				.setHorizontalGroup(jInternalFrame1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jInternalFrame1Layout
										.createSequentialGroup()
										.addGap(40, 40, 40)
										.addGroup(
												jInternalFrame1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jInternalFrame1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jPanel2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(38,
																				38,
																				38)
																		.addComponent(
																				jPanel3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(46,
																				46,
																				46)
																		.addComponent(
																				jPanel4,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jInternalFrame1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jPanel7,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(36,
																				36,
																				36)
																		.addComponent(
																				jPanel5,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(48,
																				48,
																				48)
																		.addComponent(
																				jPanel8,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jInternalFrame1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jPanel9,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(34,
																				34,
																				34)
																		.addComponent(
																				jPanel10,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(44,
																				44,
																				44)
																		.addComponent(
																				jPanel11,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(22, Short.MAX_VALUE)));
		jInternalFrame1Layout
				.setVerticalGroup(jInternalFrame1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jInternalFrame1Layout
										.createSequentialGroup()
										.addGap(20, 20, 20)
										.addGroup(
												jInternalFrame1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jPanel2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jPanel3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jPanel4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(26, 26, 26)
										.addGroup(
												jInternalFrame1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jPanel7,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jPanel5,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jPanel8,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(24, 24, 24)
										.addGroup(
												jInternalFrame1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jPanel9,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jPanel10,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jPanel11,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(25, Short.MAX_VALUE)));

		quitter.setText("QUITTER");

		algorithme.setEditable(false);
		algorithme.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N

		rejouer.setText("REJOUER");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup().addGap(212, 212, 212)
								.addComponent(lblSupprimerEtudiant)
								.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(33, 33,
																		33)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										label_1)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										algorithme,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										465,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														jLabel1)
																												.addComponent(
																														precedent,
																														javax.swing.GroupLayout.Alignment.TRAILING,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														108,
																														javax.swing.GroupLayout.PREFERRED_SIZE))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										jInternalFrame1,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addGap(18,
																										18,
																										18)
																								.addComponent(
																										suivant))))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(212,
																		212,
																		212)
																.addComponent(
																		quitter,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		139,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(120,
																		120,
																		120)
																.addComponent(
																		rejouer,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		125,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(37, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(35, 35, 35)
								.addComponent(lblSupprimerEtudiant)
								.addGap(35, 35, 35)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(label_1)
												.addComponent(
														algorithme,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														30,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(49, 49, 49)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel1)
																								.addGap(371,
																										371,
																										371)
																								.addComponent(
																										precedent,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										35,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addComponent(
																						suivant,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						35,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addContainerGap(
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jInternalFrame1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		38,
																		Short.MAX_VALUE)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						rejouer,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						39,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						quitter,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						39,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(28, 28,
																		28)))));

		pack();
	}// </editor-fold>

	private void precedentActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	public void reinit() {
		v1.get(0).setText("");
		for (int i = 1; i < v1.size(); i++) {
			v1.get(i).setText(Integer.toString(i));
		}
	}

	public void reposition() {
		panels.get(1).setBounds(48 + 100 + 48, 48, 100, 100);
		panels.get(2).setBounds(48 + 100 + 48 + 100 + 48, 48, 100, 100);
		panels.get(3).setBounds(48, 48 + 100 + 48, 100, 100);
		panels.get(4).setBounds(48 + 100 + 48, 48 + 100 + 48, 100, 100);
		panels.get(5).setBounds(48 + 100 + 48 + 100 + 48, 48 + 100 + 48, 100,
				100);
		panels.get(6).setBounds(48, 48 + 100 + 48 + 100 + 48, 100, 100);
		panels.get(7).setBounds(48 + 100 + 48, 48 + 100 + 48 + 100 + 48, 100,
				100);
		panels.get(8).setBounds(48 + 100 + 48 + 100 + 48,
				48 + 100 + 48 + 100 + 48, 100, 100);
	}

	public void setBtn(String s) {
		for (int j = 0; j < v1.size(); j++) {
			v1.get(j).setVisible(true);
			panels.get(j).setVisible(true);
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				v1.get(i).setVisible(false);
				panels.get(i).setVisible(false);
			} else {
				v1.get(i).setText("" + s.charAt(i));
			}
		}
		reposition();
	}
}
