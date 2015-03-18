import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Zafack Billy
 */
public class PreferenceEtd extends javax.swing.JDialog {

	class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == annuler) {
				setVisible(false);
			}
			if (e.getSource() == etdCombo) {
				boolean flag = false;
				ve1.removeAllElements();
				vecr.removeAllElements();
				ListModel<String> l = etdPref.getModel();
				if (deptCombo1.getSelectedItem() == null) {
					for (int i = 0; i < preffEtd.size(); i++) {
						if (preffEtd.get(i).equals(ss)) {
							flag = true;
							int k = 0;
							for (int j = 1; j <= Interface_TP2.getNbDept() - 1; j++) {
								preffEtd.setElementAt(l.getElementAt(k), i + j);
								k++;
							}
							break;
						}
					}
					if (!flag) {
						preffEtd.add(ss);
						for (int i = 0; i < l.getSize(); i++) {
							preffEtd.add(l.getElementAt(i));
						}
					}
				} else {
					JOptionPane.showMessageDialog(PreferenceEtd.this,
							"Veuillez assigner tout les departements !!",
							"Violation ASSIGNATION",
							JOptionPane.WARNING_MESSAGE);
				}
				ss = etdCombo.getSelectedItem().toString();
				reinit(ss);
				if (!Interface_TP2.getPrefEtdDept().contains(ss)) {
					DefaultComboBoxModel<String> C = new DefaultComboBoxModel<String>();
					for (int i = 0; i < Interface_TP2.getDepartements().size(); i++) {
						if (!(Interface_TP2.getEtudiants().contains(
								Interface_TP2.getDepartements().get(i)) || Interface_TP2
								.getDepartements().get(i)
								.equalsIgnoreCase("START"))) {
							C.addElement(Interface_TP2.getDepartements().get(i));
						}
					}
					deptCombo1.setModel(C);
				}
			}
			if (e.getSource() == deptCombo1) {
				System.out
						.println("DDDDDDDD + " + etdPref.getModel().getSize());
				for (int i = 0; i < etdPref.getModel().getSize(); i++) {
					vecr.add(etdPref.getModel().getElementAt(i).toString());
				}
				execo.setEnabled(true);
				if (execo.isSelected()) {
					vecr.add("[Execo] "
							+ deptCombo1.getSelectedItem().toString());
					removeElt(deptCombo1.getSelectedItem().toString());
				} else {
					vecr.add(deptCombo1.getSelectedItem().toString());
					removeElt(deptCombo1.getSelectedItem().toString());
				}
				etdPref.setListData(vecr);
			}

			if (e.getSource() == retirer) {
				String h = etdPref.getSelectedValue().toString();
				System.out.println("DFDFDF " + h);
				ListModel pl = new DefaultListModel<String>();
				DefaultListModel pl1 = new DefaultListModel<String>();
				pl = etdPref.getModel();
				for (int i = 0; i < pl.getSize(); i++) {
					if (!pl.getElementAt(i).equals(
							etdPref.getSelectedValue().toString())) {
						pl1.addElement(pl.getElementAt(i));
					}
				}
				etdPref.setModel(pl1);
				System.out.println("WEWEWEW " + h);
				ve1.addElement(h);
				deptCombo1.setModel(ve1);
				deptCombo1.revalidate();
				revalidate();
			}
			if (e.getSource() == reini) {
				etdPref.setListData(new Vector<String>());
				SupprimerEtd.initDept(deptCombo1);
			}
			if (e.getSource() == valider) {
				ecrireFichier("Preferences.txt");
				new PreferenceDept(new JFrame(), true).setVisible(true);
				setVisible(false);
			}
		}

	}

	// Variables declaration - do not modify
	private javax.swing.JButton annuler;
	private javax.swing.JComboBox etdCombo;

	private javax.swing.JComboBox<String> deptCombo1;
	private javax.swing.JList etdPref;
	private javax.swing.JCheckBox execo;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel label_1;
	private javax.swing.JLabel label_2;
	private javax.swing.JLabel lblSupprimerEtudiant;
	private javax.swing.JButton reini;
	private javax.swing.JButton retirer;
	private javax.swing.JButton valider;
	public String ss = new String();
	public Vector<String> preffEtd;
	public Vector<String> vec = new Vector<String>();
	public Vector<String> vecr = new Vector<String>();
	DefaultComboBoxModel<String> ve1 = new DefaultComboBoxModel<String>();

	// End of variables declaration

	public PreferenceEtd(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		DefaultComboBoxModel<String> d = new DefaultComboBoxModel<String>();
		for (int i = 0; i < Interface_TP2.getDepartements().size(); i++) {
			if (!(Interface_TP2.getEtudiants().contains(
					Interface_TP2.getDepartements().get(i)) || Interface_TP2
					.getDepartements().get(i).equalsIgnoreCase("START"))) {
				d.addElement(Interface_TP2.getDepartements().get(i));
			}
		}
		deptCombo1.setModel(d);
		SupprimerEtd.initEtd(etdCombo);
		String s = etdCombo.getSelectedItem().toString();
		ss = etdCombo.getSelectedItem().toString();
	}

	public void ecrireFichier(String nomfich) {
		String s = "";
		for (int i = 0; i < preffEtd.size(); i++) {
			if (Interface_TP2.getEtudiants().contains(preffEtd.get(i))
					&& i != 0) {
				s = s + "\n" + preffEtd.get(i) + " | ";
			} else {
				s = s + preffEtd.get(i) + " | ";
			}
		}
		try {
			PrintWriter sortie = new PrintWriter(new FileWriter(nomfich));
			sortie.print(s);
			sortie.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		valider = new javax.swing.JButton();
		annuler = new javax.swing.JButton();
		label_1 = new javax.swing.JLabel();
		etdCombo = new javax.swing.JComboBox();
		label_2 = new javax.swing.JLabel();
		deptCombo1 = new javax.swing.JComboBox();
		reini = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		etdPref = new javax.swing.JList();
		retirer = new javax.swing.JButton();
		execo = new javax.swing.JCheckBox();
		preffEtd = new Vector<String>();
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		lblSupprimerEtudiant
				.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		lblSupprimerEtudiant.setText("PREFERENCES  ETUDIANT");

		annuler.addActionListener(new Action());
		retirer.addActionListener(new Action());
		valider.addActionListener(new Action());
		reini.addActionListener(new Action());
		etdCombo.addActionListener(new Action());
		deptCombo1.addActionListener(new Action());
		execo.setEnabled(false);
		valider.setText("Valider");

		annuler.setText("Annuler");

		label_1.setText("Etudiant :");

		label_2.setText("Departement :");

		reini.setText("Reinitialiser");

		jScrollPane1.setViewportView(etdPref);

		retirer.setText("Retirer");

		execo.setText("Execo");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		lblSupprimerEtudiant)
																.addGap(2, 2, 2))
												.addGroup(
														javax.swing.GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup()
																.addGap(23, 23,
																		23)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										reini)
																								.addGap(136,
																										136,
																										136)
																								.addComponent(
																										valider,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										128,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										43,
																										Short.MAX_VALUE))
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addComponent(
																										label_1)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										etdCombo,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										204,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														execo)
																												.addComponent(
																														label_2))
																								.addGap(3,
																										3,
																										3)))))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														deptCombo1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														204,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														annuler,
														javax.swing.GroupLayout.Alignment.TRAILING))
								.addContainerGap())
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										466,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(retirer)
								.addGap(1, 1, 1)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(54, 54, 54)
								.addComponent(lblSupprimerEtudiant)
								.addGap(17, 17, 17)
								.addComponent(execo)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(label_1)
												.addComponent(
														etdCombo,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														deptCombo1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(label_2))
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(39, 39,
																		39)
																.addComponent(
																		retirer)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(18, 18,
																		18)
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		184,
																		Short.MAX_VALUE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
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
																						annuler)
																				.addComponent(
																						reini))
																.addGap(23, 23,
																		23))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		valider,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		38,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(30, 30,
																		30)))));

		pack();
	}// </editor-fold>

	public void reinit(String s) {
		Vector<String> v = new Vector<String>();
		int g = 1;
		Interface_TP2.initPref();
		preffEtd.add(s);
		for (int i = 0; i < Interface_TP2.getPrefEtdDept().size(); i++) {
			if (Interface_TP2.getPrefEtdDept().get(i).equals(s)) {
				while (!Interface_TP2.getPrefEtdDept().get(i + g)
						.equalsIgnoreCase("START")) {
					v.add(Interface_TP2.getPrefEtdDept().get(i + g));
					preffEtd.add(Interface_TP2.getPrefEtdDept().get(i + g));
					g++;
				}
				break;
			}
		}
		etdPref.setListData(v);
		for (int i = 0; i < v.size(); i++) {
			removeElt(v.get(i));
		}
		System.out.println("REINIT " + preffEtd.size());

	}

	public void removeElt(String s) {
		ComboBoxModel<String> w;
		DefaultComboBoxModel<String> d = new DefaultComboBoxModel<>();
		w = deptCombo1.getModel();
		for (int l = 0; l < w.getSize(); l++) {
			d.addElement(w.getElementAt(l));
		}
		d.removeElement(s);
		deptCombo1.setModel(d);
	}
}
