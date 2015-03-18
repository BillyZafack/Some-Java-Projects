import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import jpl.Atom;
import jpl.PrologException;
import jpl.Query;
import jpl.Term;

/**
 * 
 * @author Zafack Billy
 */
public class Interface_TP2 extends javax.swing.JDialog {

	class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == quitter) {
				setVisible(false);
			}
			if (e.getSource() == recommencer) {
				setVisible(false);
				new Init(new JFrame(), true);

			}
			if (e.getSource() == ficDept) {
				File f = new File(".\\fichiers\\notes.txt");

				try {
					Desktop.getDesktop().open(f);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane
							.showMessageDialog(
									Interface_TP2.this,
									"Erreur Dans L'acces du fichier de docuentation javadoc",
									"ERREUR", JOptionPane.PLAIN_MESSAGE);

				}
			}
			if (e.getSource() == ficEtd) {
				File f = new File(".\\fichiers\\Preferences.txt");

				try {
					Desktop.getDesktop().open(f);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane
							.showMessageDialog(
									Interface_TP2.this,
									"Erreur Dans L'acces du fichier de docuentation javadoc",
									"ERREUR", JOptionPane.PLAIN_MESSAGE);

				}
			}

		}

	}

	public static Vector<String> getDepartements() {
		return Departements;
	}

	public static Vector<String> getEtudiants() {
		return Etudiants;
	}

	// / Variables declaration - do not modify
	private javax.swing.JButton ficEtd;
	private javax.swing.JButton quitter;
	private javax.swing.JButton recommencer;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private static javax.swing.JTable jTable1;
	private javax.swing.JLabel lblSupprimerEtudiant;
	private javax.swing.JButton ficDept;
	private static Vector<String> Etudiants = new Vector<String>();
	private static Vector<String> Departements = new Vector<String>();
	private static Vector<String> prefDeptEtd = new Vector<String>();
	private static Vector<String> prefEtdDept = new Vector<String>();

	private static int nbEtd = 0;

	private static int nbDept = 0;

	public static javax.swing.JTable getJTable1() {
		return jTable1;
	}

	public static int getNbDept() {
		return nbDept;
	}

	public static int getNbEtd() {
		return nbEtd;
	}

	public static Vector<String> getPrefDeptEtd() {
		return prefDeptEtd;
	}

	public static Vector<String> getPrefEtdDept() {
		return prefEtdDept;
	}

	// End of variables declaration
	/**
	 * Creates new form Achats
	 */
	public static void initNotes() {
		BufferedReader entree = null;
		try {
			entree = new BufferedReader(new FileReader("./fichiers/notes.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("ERRREUR FIC NON-TROUVEE");
			e1.printStackTrace();
		}
		nbDept = 0;
		nbEtd = 0;
		try {
			boolean flag = true;
			while (true) {
				nbDept++;
				int j = 1;
				String ligneLue = entree.readLine();
				if (ligneLue == null) {
					break;
				}

				StringTokenizer tok = new StringTokenizer(ligneLue, "|");
				nbEtd = tok.countTokens();
				String s = "";
				/*
				 * if (nbEtd == 1) {
				 * 
				 * while (tok.hasMoreTokens()) { s = tok.nextToken(); if (s !=
				 * " ") { s.trim(); Departements.add(s); } }
				 * 
				 * } else {
				 */
				prefDeptEtd.add("START");
				while (tok.hasMoreTokens()) {
					s = tok.nextToken();
					if (!s.equals(" ")) {
						s = s.trim();
						prefDeptEtd.add(s);
					}
					if (j != 1 && flag) {
						Etudiants.add(s);
					} else if (j == 1) {
						Departements.add(s);
					}
					j++;
				}
				flag = false;/*
							 * }
							 */
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRREUR LECTURE");
			e.printStackTrace();
		}

		// prefDept_textField.setText(choix);

		try {
			entree.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initPref() {
		BufferedReader entree1 = null;

		try {
			entree1 = new BufferedReader(new FileReader(
					"./fichiers/Preferences.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("ERRREUR FIC NON-TROUVEE");
			e1.printStackTrace();
		}

		try {
			boolean flag = true;
			while (true) {

				int j = 1;
				String ligneLue = entree1.readLine();
				if (ligneLue == null) {
					break;
				}

				StringTokenizer tok = new StringTokenizer(ligneLue, "|");
				String s1 = "";
				/*
				 * if (nbEtd == 1) {
				 * 
				 * while (tok.hasMoreTokens()) { s = tok.nextToken(); if (s !=
				 * " ") { s.trim(); Departements.add(s); } }
				 * 
				 * } else {
				 */
				prefEtdDept.add("START");
				while (tok.hasMoreTokens()) {
					s1 = tok.nextToken();
					if (!s1.equals(" ")) {
						s1 = s1.trim();
						prefEtdDept.add(s1);
					}
				}/*
				 * }
				 */
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRREUR LECTURE");
			e.printStackTrace();
		}

		try {
			entree1.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//

	}

	public static void setDepartements(Vector<String> departements) {
		Departements = departements;
	}

	public static void setEtudiants(Vector<String> etudiants) {
		Etudiants = etudiants;
	}

	public static void setNbDept(int nbDept) {
		Interface_TP2.nbDept = nbDept;
	}

	public static void setNbEtd(int nbEtd) {
		Interface_TP2.nbEtd = nbEtd;
	}

	public static void setPrefDeptEtd(Vector<String> prefDeptEtd) {
		Interface_TP2.prefDeptEtd = prefDeptEtd;
	}

	public static void setPrefEtdDept(Vector<String> prefEtdDept) {
		Interface_TP2.prefEtdDept = prefEtdDept;
	}

	public Interface_TP2(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();

		initNotes();
		Hashtable<String, Integer> hEtudiant = new Hashtable<String, Integer>();
		Hashtable<String, Integer> hDepartement = new Hashtable<String, Integer>();

		for (int i = 1; i <= Etudiants.size(); i++) {
			hEtudiant.put(Etudiants.get(i - 1), i);
		}
		for (int i = 1; i <= Departements.size(); i++) {
			hDepartement.put(Departements.get(i - 1), i);
		}
		System.out.println(hEtudiant.toString());
		System.out.println(hDepartement.toString());
		System.out.println(hEtudiant.size());
		System.out.println(hDepartement.size());

		initPref();
		int n = noSolution(hEtudiant, hDepartement);
		String s = "";
		Hashtable[] reponse = prolog(hEtudiant, hDepartement);
		// //
		String[][] data1 = new String[n][nbEtd - 1];
		String s1 = "";
		for (int j = 1; j < nbDept; j++) {
			for (int k1 = 1; k1 <= n; k1++) {
				data1[k1][j] = reponse[k1].get("D" + j).toString();
			}
		}
		String title1[] = new String[nbEtd];
		for (int i = 0; i < Departements.size(); i++) {
			title1[i] = Departements.get(i);
		}
		DefaultTableModel mod1 = new DefaultTableModel(data1, title1);
		jTable1.setModel(mod1);
		getContentPane().add(new JScrollPane(jTable1));
		TableColumn col1;
		col1 = jTable1.getColumnModel().getColumn(4);
		col1.setPreferredWidth(100);

		// //

		/*
		 * System.out.println("PPPPPP " + prefDeptEtd.size()); for (int j = 0; j
		 * < nbDept; j++) { int a = 0;
		 * 
		 * do { if (k < prefDeptEtd.size() - 1) { k++; }
		 * System.out.println("PPPPPPD " + prefDeptEtd.size()); } while
		 * (!prefDeptEtd.get(k).equals("START") && k != prefDeptEtd.size() - 1);
		 * if (k != prefDeptEtd.size() - 1) { for (int l = k + 2; l < k + nbEtd
		 * + 1; l++) { System.out.println("PPPPPPF " + prefDeptEtd.size());
		 * data[a][j] = prefDeptEtd.get(l); a++; } } }
		 * 
		 * String title[] = new String[nbDept]; for (int i = 0; i <
		 * Departements.size(); i++) { title[i] = Departements.get(i);
		 * System.out.println("LL " + title[i]); }
		 */
	}

	public javax.swing.JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public javax.swing.JScrollPane getjScrollPane2() {
		return jScrollPane2;
	}

	public int getKey(Hashtable<String, Integer> H, String s) {
		int e = 0;
		for (int i = 1; i <= H.size(); i++) {
			System.out.println(H.get(i));
			if (H.get(Integer.toString(i)).equals(s)) {
				e = i;
			}
		}
		return e;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		lblSupprimerEtudiant = new javax.swing.JLabel();
		ficDept = new javax.swing.JButton();
		ficEtd = new javax.swing.JButton();
		quitter = new javax.swing.JButton();
		recommencer = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		ficDept.addActionListener(new Action());
		ficEtd.addActionListener(new Action());
		recommencer.addActionListener(new Action());
		quitter.addActionListener(new Action());

		lblSupprimerEtudiant
				.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		lblSupprimerEtudiant.setText("RESULTATS");

		ficDept.setText("Fichiers De Preference Des Departements");

		ficEtd.setText("Fichiers De Preference Des Etudiants ");

		quitter.setText("Quitter");

		recommencer.setText("RECOMMENCER");

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] {

				}));
		jScrollPane1.setViewportView(jTable1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(layout
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						layout.createSequentialGroup().addGap(366)
								.addComponent(lblSupprimerEtudiant)
								.addContainerGap(348, Short.MAX_VALUE))
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												Alignment.LEADING)
												.addComponent(ficDept)
												.addComponent(ficEtd))
								.addPreferredGap(ComponentPlacement.RELATED,
										437, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												Alignment.LEADING)
												.addComponent(quitter,
														Alignment.TRAILING)
												.addComponent(recommencer,
														Alignment.TRAILING))
								.addGap(25))
				.addGroup(
						Alignment.LEADING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane1,
										GroupLayout.PREFERRED_SIZE, 753,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(51, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(58)
								.addComponent(lblSupprimerEtudiant)
								.addGap(39)
								.addComponent(jScrollPane1,
										GroupLayout.PREFERRED_SIZE, 240,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED,
										76, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		ficDept)
																.addGap(18)
																.addComponent(
																		ficEtd)
																.addGap(18))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		recommencer)
																.addGap(18)
																.addComponent(
																		quitter)
																.addGap(23)))));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>

	public int noSolution(Hashtable<String, Integer> hEtudiant,
			Hashtable<String, Integer> hDepartement) {
		int k = 0;
		try {

			Query q1 = new Query("consult", new Term[] { new Atom("TP2r.pl") });

			if (q1.hasSolution()) {

				int i = 0;
				do {
					if (prefDeptEtd.get(i).equalsIgnoreCase("START")) {
						i++;
						System.out.println("TEESSTT "
								+ hDepartement.get("START")
								+ prefDeptEtd.get(i));
						int a = hDepartement.get(prefDeptEtd.get(i));

						i++;
						int k11 = 1;
						do {

							int b = hEtudiant.get(prefDeptEtd.get(i));
							Query m = new Query("asserta(prefereDeptEtd(" + k11
									+ "," + a + "," + b + ")).");
							k11++;
							i++;
						} while (!prefDeptEtd.get(i).equalsIgnoreCase("START"));

					} else {
						i++;
					}
				} while (i < prefDeptEtd.size());

				int i1 = 0;
				do {
					if (prefEtdDept.get(i1).equalsIgnoreCase("START")) {
						i1++;
						int a = hEtudiant.get(prefEtdDept.get(i1));
						i1++;
						int k2 = 1;
						do {
							int b = hDepartement.get(prefEtdDept.get(i1));
							Query m = new Query("asserta(prefereEtdDept(" + k2
									+ "," + a + "," + b + ")).");
							k2++;
							i1++;
						} while (!prefEtdDept.get(i1).equalsIgnoreCase("START"));
					} else {
						i1++;
					}
				} while (i1 < prefEtdDept.size());

				String etd = "[";
				String dept = "[";
				for (int i2 = 1; i2 <= Departements.size(); i2++) {
					dept = dept + i2 + ",";
				}
				dept = dept.substring(0, dept.length() - 1);
				dept = dept + "]";

				for (int i2 = 1; i2 <= Etudiants.size(); i2++) {
					etd = etd + i2 + ",";
				}
				etd = etd.substring(0, etd.length() - 1);
				etd = etd + "]";

				String S = "[";

				for (int i2 = 1; i2 <= Etudiants.size(); i2++) {
					S = S + "D" + i2 + ",";
				}
				S = S.substring(0, dept.length() - 1);
				S = S + "]";
				int i3 = Etudiants.size() / Departements.size();
				int inf = i3;
				int sup = i3 + 1;
				String borne = "[" + inf + "," + sup + "]";
				System.out.println("Etudiant :" + etd);
				System.out.println("Departement :" + dept);
				System.out.println("Borne :" + borne);
				System.out.println("Var :" + S);
				Query m = new Query("repartition(" + S + "," + etd + "," + dept
						+ "," + borne + ").");
				Hashtable[] reponse = m.allSolutions();
				while (m.hasSolution()) {
					k++;
				}
			} else {
				JOptionPane.showMessageDialog(this,
						"ERREUR D'OUVERTURE DU FICHIER 'TP2r.pl' !!!",
						"ERREUR !!!", JOptionPane.ERROR_MESSAGE);

			}
		} catch (PrologException e) {
			System.out.println("PROLOG ERROR");
		}
		return k;
	}

	public Hashtable[] prolog(Hashtable<String, Integer> hEtudiant,
			Hashtable<String, Integer> hDepartement) {
		Hashtable[] reponse = null;
		try {

			Query q1 = new Query("consult", new Term[] { new Atom("TP2r.pl") });

			if (q1.hasSolution()) {

				int i = 0;
				do {
					if (prefDeptEtd.get(i).equalsIgnoreCase("START")) {
						i++;
						System.out.println("TEESSTT "
								+ hDepartement.get("START")
								+ prefDeptEtd.get(i));
						int a = hDepartement.get(prefDeptEtd.get(i));

						i++;
						int k11 = 1;
						do {

							int b = hEtudiant.get(prefDeptEtd.get(i));
							Query m = new Query("asserta(prefereDeptEtd(" + k11
									+ "," + a + "," + b + ")).");
							k11++;
							i++;
						} while (!prefDeptEtd.get(i).equalsIgnoreCase("START"));

					} else {
						i++;
					}
				} while (i < prefDeptEtd.size());

				int i1 = 0;
				do {
					if (prefEtdDept.get(i1).equalsIgnoreCase("START")) {
						i1++;
						int a = hEtudiant.get(prefEtdDept.get(i1));
						i1++;
						int k2 = 1;
						while (!prefEtdDept.get(i1).equalsIgnoreCase("START")) {
							int b = hDepartement.get(prefEtdDept.get(i1));
							Query m = new Query("asserta(prefereEtdDept(" + k2
									+ "," + a + "," + b + ")).");
							k2++;
							i1++;
						}
					} else {
						i1++;
					}
				} while (i1 < prefEtdDept.size());

				String etd = "[";
				String dept = "[";
				for (int i2 = 1; i2 <= Departements.size(); i2++) {
					dept = dept + i2 + ",";
				}
				dept = dept.substring(0, dept.length() - 1);
				dept = dept + "]";

				for (int i2 = 1; i2 <= Etudiants.size(); i2++) {
					etd = etd + i2 + ",";
				}
				etd = etd.substring(0, etd.length() - 1);
				etd = etd + "]";

				String S = "[";

				for (int i2 = 1; i2 <= Etudiants.size(); i2++) {
					S = S + "D" + i2 + ",";
				}
				S = S.substring(0, dept.length() - 1);
				S = S + "]";
				int i3 = Etudiants.size() / Departements.size();
				int inf = i3;
				int sup = i3 + 1;
				String borne = "[" + inf + "," + sup + "]";
				System.out.println("Etudiant :" + etd);
				System.out.println("Departement :" + dept);
				System.out.println("Borne :" + borne);
				System.out.println("Var :" + S);
				Query m = new Query("repartition(" + S + "," + etd + "," + dept
						+ "," + borne + ").");
				if (m.hasSolution()) {
					reponse = m.allSolutions();
					System.out.println(reponse.toString());
				}

			} else {
				JOptionPane.showMessageDialog(this,
						"ERREUR D'OUVERTURE DU FICHIER 'TP2r.pl' !!!",
						"ERREUR !!!", JOptionPane.ERROR_MESSAGE);

			}
		} catch (PrologException e) {
			System.out.println("PROLOG ERROR");
		}
		if (reponse == null) {
			JOptionPane.showMessageDialog(null, "Reponse NULL", "ERRROOR",
					JOptionPane.WARNING_MESSAGE);
			return reponse;
		} else {
			return reponse;
		}
	}

	public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	public void setjScrollPane2(javax.swing.JScrollPane jScrollPane2) {
		this.jScrollPane2 = jScrollPane2;
	}

}
