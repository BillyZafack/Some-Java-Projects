import java.awt.Color;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class Testing extends JDialog {

	public static void main(String[] args) {
		new Testing().setVisible(true);
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
	private javax.swing.JButton suivant;
	private javax.swing.JButton button5;
	private javax.swing.JButton button7;
	private javax.swing.JInternalFrame jInternalFrame1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator4;
	private javax.swing.JLabel label_1;
	private javax.swing.JLabel lblSupprimerEtudiant;
	public static String choix_algo = new String();
	private javax.swing.JButton rejouer;
	private final JButton precedent = new JButton("PRECEDENT");

	private static Vector<String> trans = new Vector<String>();
	Vector<JButton> v1 = new Vector<JButton>();

	private JTextField algorithme;

	public Testing() {
		initComponents();
	}

	private void initComponents() {

		lblSupprimerEtudiant = new javax.swing.JLabel();
		rejouer = new javax.swing.JButton();
		quitter = new javax.swing.JButton();
		label_1 = new javax.swing.JLabel();
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
		suivant = new javax.swing.JButton();

		lblSupprimerEtudiant
				.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		lblSupprimerEtudiant.setText("--- P U Z Z L E ---");

		rejouer.setText("REJOUER");

		quitter.setText("QUITTER");

		label_1.setText("Choix De L'Algorithme :");

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

		suivant.setText("SUIVANT");

		algorithme = new JTextField();
		algorithme.setColumns(10);

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
																.addGap(24)
																.addGroup(
																		layout.createParallelGroup(
																				Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										label_1)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(
																										algorithme))
																				.addGroup(
																						Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addComponent(
																										precedent,
																										GroupLayout.PREFERRED_SIZE,
																										100,
																										GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addGroup(
																										layout.createParallelGroup(
																												Alignment.LEADING)
																												.addGroup(
																														layout.createSequentialGroup()
																																.addComponent(
																																		quitter,
																																		GroupLayout.PREFERRED_SIZE,
																																		85,
																																		GroupLayout.PREFERRED_SIZE)
																																.addGap(291)
																																.addComponent(
																																		rejouer))
																												.addComponent(
																														jInternalFrame1,
																														Alignment.TRAILING,
																														GroupLayout.PREFERRED_SIZE,
																														GroupLayout.DEFAULT_SIZE,
																														GroupLayout.PREFERRED_SIZE))))))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(suivant,
										GroupLayout.PREFERRED_SIZE, 85,
										GroupLayout.PREFERRED_SIZE)));
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
								.addGap(49)
								.addGroup(
										layout.createParallelGroup(
												Alignment.TRAILING)
												.addComponent(
														precedent,
														GroupLayout.PREFERRED_SIZE,
														34,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jInternalFrame1,
														Alignment.LEADING,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(
										layout.createParallelGroup(
												Alignment.TRAILING)
												.addComponent(
														rejouer,
														GroupLayout.PREFERRED_SIZE,
														35,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														quitter,
														GroupLayout.PREFERRED_SIZE,
														35,
														GroupLayout.PREFERRED_SIZE))
								.addContainerGap(37, Short.MAX_VALUE))
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(608, Short.MAX_VALUE)
								.addComponent(suivant,
										GroupLayout.PREFERRED_SIZE, 35,
										GroupLayout.PREFERRED_SIZE).addGap(98)));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>
}
