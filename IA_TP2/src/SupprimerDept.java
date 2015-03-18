import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.ListModel;

public class SupprimerDept extends JDialog {

	class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == annuler) {
				setVisible(false);
			}
			if (e.getSource() == confirmer) {
				ListModel<String> l = Init.getDepartementActuel().getModel();
				DefaultListModel<String> l1 = new DefaultListModel<String>();
				for (int i = 0; i < l.getSize(); i++) {
					l1.addElement(l.getElementAt(i));
				}
				l1.removeElement(deptCombo.getSelectedItem().toString());
				Init.getDepartementActuel().setModel(l1);
				if (Interface_TP2.getDepartements().contains(
						deptCombo.getSelectedItem().toString())) {
					Interface_TP2.getDepartements().remove(
							deptCombo.getSelectedItem().toString());
				}
				Init.getNbDepartement().setText(
						Integer.toString(Integer.parseInt(Init
								.getNbDepartement().getText()) - 1));
				setVisible(false);
			}
		}

	}

	public static void setDeptCombo(javax.swing.JComboBox deptCombo) {
		deptCombo = deptCombo;
	}

	// Variables declaration - do not modify
	private javax.swing.JButton annuler;

	private javax.swing.JComboBox deptCombo;

	private javax.swing.JLabel label_1;

	private javax.swing.JLabel lblSupprimerEtudiant;

	private javax.swing.JButton confirmer;

	// End of variables declaration
	/**
	 * Creates new form EtatClient
	 */
	public SupprimerDept(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	public javax.swing.JButton getAnnuler() {
		return annuler;
	}

	public javax.swing.JButton getConfirmer() {
		return confirmer;
	}

	public javax.swing.JComboBox getDeptCombo() {
		return deptCombo;
	}

	public javax.swing.JLabel getLabel_1() {
		return label_1;
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
		confirmer = new javax.swing.JButton();
		annuler = new javax.swing.JButton();
		label_1 = new javax.swing.JLabel();
		deptCombo = new javax.swing.JComboBox();
		confirmer.addActionListener(new Action());
		annuler.addActionListener(new Action());
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		SupprimerEtd.initDept(deptCombo);
		lblSupprimerEtudiant
				.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		lblSupprimerEtudiant.setText("SUPPRIMER  DEPARTEMENT");

		confirmer.setText("Valider");

		annuler.setText("Annuler");

		label_1.setText("NOM :");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												false)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(139,
																		139,
																		139)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						lblSupprimerEtudiant)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										label_1)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										deptCombo,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										204,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addGap(18, 18,
																		18))
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap(
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		confirmer)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		annuler)))
								.addContainerGap(143, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(62, 62, 62)
								.addComponent(lblSupprimerEtudiant)
								.addGap(89, 89, 89)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(label_1)
												.addComponent(
														deptCombo,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(104, 104, 104)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(confirmer)
												.addComponent(annuler))
								.addContainerGap(38, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	public void setAnnuler(javax.swing.JButton annuler) {
		this.annuler = annuler;
	}

	public void setConfirmer(javax.swing.JButton confirmer) {
		this.confirmer = confirmer;
	}

	public void setLabel_1(javax.swing.JLabel label_1) {
		this.label_1 = label_1;
	}

}