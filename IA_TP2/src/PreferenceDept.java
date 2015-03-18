import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
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
public class PreferenceDept extends javax.swing.JDialog {

	class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == annuler) {
				setVisible(false);
			}
			if (e.getSource() == deptCombo) {
				boolean flag = false;
				ve1.removeAllElements();
				vec.removeAllElements();
				ListModel<String> l = deptPref.getModel();
				if (etdCombo.getSelectedItem() == null) {
					for (int i = 0; i < preffDept.size(); i++) {
						if (preffDept.get(i).equals(ss)) {
							flag = true;
							int k = 0;
							for (int j = 1; j <= Interface_TP2.getNbDept() - 1; j++) {
								preffDept
										.setElementAt(l.getElementAt(k), i + j);
								k++;
							}
							break;
						}
					}
					if (!flag) {
						preffDept.add(ss);
						for (int i = 0; i < l.getSize(); i++) {
							preffDept.add(l.getElementAt(i));
						}
					}
				} else {
					JOptionPane.showMessageDialog(PreferenceDept.this,
							"Veuillez assigner tout les departements !!",
							"Violation ASSIGNATION",
							JOptionPane.WARNING_MESSAGE);
				}
				ss = deptCombo.getSelectedItem().toString();
				reinit(ss);
			}
			if (e.getSource() == etdCombo) {
				ListModel<String> lk;
				lk = deptPref.getModel();
				for (int i = 0; i < lk.getSize(); i++) {
					vec.add(lk.getElementAt(i));
				}
				execo.setEnabled(true);
				if (execo.isSelected()) {
					vec.add("[Execo] " + etdCombo.getSelectedItem().toString());
					etdCombo.removeItem(etdCombo.getSelectedItem().toString());
				} else {
					vec.add(etdCombo.getSelectedItem().toString());
					etdCombo.removeItem(etdCombo.getSelectedItem().toString());
				}
				deptPref.setListData(vec);
				if (!Interface_TP2.getPrefDeptEtd().contains(ss)) {
					DefaultComboBoxModel<String> C = new DefaultComboBoxModel<String>();
					for (int i = 0; i < Interface_TP2.getEtudiants().size(); i++) {
						if (!(Interface_TP2.getDepartements().contains(
								Interface_TP2.getEtudiants().get(i)) || Interface_TP2
								.getEtudiants().get(i)
								.equalsIgnoreCase("START"))) {
							C.addElement(Interface_TP2.getEtudiants().get(i));
						}
					}
					etdCombo.setModel(C);
				}

			}

			if (e.getSource() == retirer) {
				String h = deptPref.getSelectedValue().toString();
				System.out.println("DFDFDF " + h);
				ListModel pl = new DefaultListModel<String>();
				DefaultListModel pl1 = new DefaultListModel<String>();
				pl = deptPref.getModel();
				for (int i = 0; i < pl.getSize(); i++) {
					if (!pl.getElementAt(i).equals(
							deptPref.getSelectedValue().toString())) {
						pl1.addElement(pl.getElementAt(i));
					}
				}
				deptPref.setModel(pl1);
				System.out.println("WEWEWEW " + h);
				ve1.addElement(h);
				etdCombo.setModel(ve1);
				etdCombo.revalidate();
				revalidate();
			}
			if (e.getSource() == reinit) {
				deptPref.setListData(new Vector<String>());
				SupprimerEtd.initDept(etdCombo);
			}
			if (e.getSource() == valider) {
				ecrireFichier("Notes.txt");
				new Interface_TP2(new JFrame(), true).setVisible(true);
				setVisible(false);
			}
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JButton annuler;
	private javax.swing.JComboBox deptCombo;

	private javax.swing.JComboBox<String> etdCombo;
	private javax.swing.JList deptPref;
	private javax.swing.JCheckBox execo;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lblDepartement;
	private javax.swing.JLabel lblEtudiant;
	private javax.swing.JLabel lblSupprimerEtudiant;
	private javax.swing.JButton reinit;
	private javax.swing.JButton retirer;
	private javax.swing.JButton valider;
	public String ss = new String();
	public Vector<String> preffDept = new Vector<String>();
	public Vector<String> vec = new Vector<String>();
	DefaultComboBoxModel<String> ve1 = new DefaultComboBoxModel<String>();

	// End of variables declaration

	public PreferenceDept(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		SupprimerEtd.initDept(deptCombo);
		SupprimerEtd.initEtd(etdCombo);
		String s = deptCombo.getSelectedItem().toString();
		ss = deptCombo.getSelectedItem().toString();
	}

	public void ecrireFichier(String nomfich) {
		String s = "";
		for (int i = 0; i < preffDept.size(); i++) {
			if (Interface_TP2.getDepartements().contains(preffDept.get(i))
					&& i != 0) {
				s = s + "\n" + preffDept.get(i) + " | ";
			} else {
				s = s + preffDept.get(i) + " | ";
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
		Vector<String> vec = new Vector<String>();
		lblSupprimerEtudiant = new javax.swing.JLabel();
		valider = new javax.swing.JButton();
		annuler = new javax.swing.JButton();
		lblDepartement = new javax.swing.JLabel();
		deptCombo = new javax.swing.JComboBox();
		lblEtudiant = new javax.swing.JLabel();
		etdCombo = new javax.swing.JComboBox(vec);
		reinit = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		deptPref = new javax.swing.JList();
		retirer = new javax.swing.JButton();
		execo = new javax.swing.JCheckBox();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		lblSupprimerEtudiant
				.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		lblSupprimerEtudiant.setText("PREFERENCES  DEPARTEMENT");

		annuler.addActionListener(new Action());
		retirer.addActionListener(new Action());
		valider.addActionListener(new Action());
		reinit.addActionListener(new Action());
		deptCombo.addActionListener(new Action());
		etdCombo.addActionListener(new Action());
		execo.setEnabled(false);
		valider.setText("Valider");

		annuler.setText("Annuler");

		lblDepartement.setText("Departement :");

		lblEtudiant.setText("Etudiant :");

		reinit.setText("Reinitialiser");

		jScrollPane1.setViewportView(deptPref);

		retirer.setText("Retirer");

		execo.setText("Execo");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(layout
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(23)
								.addGroup(
										layout.createParallelGroup(
												Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		reinit)
																.addGap(136)
																.addComponent(
																		valider,
																		GroupLayout.PREFERRED_SIZE,
																		128,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED,
																		41,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		lblDepartement)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		deptCombo,
																		GroupLayout.PREFERRED_SIZE,
																		204,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED,
																		66,
																		Short.MAX_VALUE)
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						execo)
																				.addComponent(
																						lblEtudiant))
																.addGap(3)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														etdCombo,
														GroupLayout.PREFERRED_SIZE,
														204,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(annuler,
														Alignment.TRAILING))
								.addContainerGap())
				.addGroup(
						layout.createSequentialGroup()
								.addGap(0, 81, Short.MAX_VALUE)
								.addComponent(jScrollPane1,
										GroupLayout.PREFERRED_SIZE, 466,
										GroupLayout.PREFERRED_SIZE).addGap(18)
								.addComponent(retirer).addGap(1))
				.addGroup(
						Alignment.LEADING,
						layout.createSequentialGroup().addGap(172)
								.addComponent(lblSupprimerEtudiant)
								.addContainerGap(183, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(53)
								.addComponent(lblSupprimerEtudiant)
								.addGap(18)
								.addComponent(execo)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblDepartement)
												.addComponent(
														deptCombo,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														etdCombo,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblEtudiant))
								.addGroup(
										layout.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(39)
																.addComponent(
																		retirer))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(18)
																.addComponent(
																		jScrollPane1,
																		GroupLayout.DEFAULT_SIZE,
																		184,
																		Short.MAX_VALUE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						annuler)
																				.addComponent(
																						reinit))
																.addGap(23))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		valider,
																		GroupLayout.PREFERRED_SIZE,
																		38,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(30)))));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>

	public void reinit(String s) {
		Vector<String> v = new Vector<String>();
		int g = 1;
		Interface_TP2.initPref();
		preffDept.add(s);
		for (int i = 0; i < Interface_TP2.getPrefDeptEtd().size(); i++) {
			if (Interface_TP2.getPrefDeptEtd().get(i).equals(s)) {
				while (!Interface_TP2.getPrefDeptEtd().get(i + g)
						.equalsIgnoreCase("START")) {
					v.add(Interface_TP2.getPrefDeptEtd().get(i + g));
					preffDept.add(Interface_TP2.getPrefDeptEtd().get(i + g));
					g++;
				}
				break;
			}
		}
		deptPref.setListData(v);
		for (int i = 0; i < v.size(); i++) {
			etdCombo.removeItem(v.get(i));
		}
	}
}
