import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Cette classe construit et gere les etats des etudiants.
 * 
 * @author Zafack Billy
 * @version 2.0
 */
public class EtatEtudiant extends JDialog implements ActionListener {

	class mousee implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == aide) {
				JOptionPane
						.showMessageDialog(
								EtatEtudiant.this,
								"AIDE CONTEXTUELLE\n -Ici vous pouvez consulter la liste d'etudian correspondant.\n Vous pouvez imprimer avec le bouton \'Imprimer\' et retourner a la fenetre principale ave le bouton \'Retour\'",
								"AIDE CONTEXTUELLE", JOptionPane.PLAIN_MESSAGE);
			}

			if (e.getSource() == statistiques) {
				int k = 0;
				k = table.getRowCount();
				etds.setText(Integer.toString(k));
				JOptionPane.showMessageDialog(EtatEtudiant.this,
						"STATISTIQUES\n -Nombre d'Etudiant: " + k,
						"STATISTIQUES", JOptionPane.PLAIN_MESSAGE);
			}
			if (e.getSource() == etatetdetd) {
				setVisible(false);
				getParent().setVisible(false);
				new InscriptionPm(new WindowPrime(), true).setVisible(true);
			}
			if (e.getSource() == jLabel2) {
				setVisible(false);
				getParent().setVisible(false);
				new EtatUV(new WindowPrime(), true, 1).setVisible(true);
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	// Variables declaration - do not modify
	/** Bouton de retour */
	private javax.swing.JButton Retour;
	/** Raccourci permettant l'acces a une fenetre d'aide contextuelle */
	private javax.swing.JLabel aide;
	/** Raccourci ver le traitement des etudiants */
	private javax.swing.JLabel etatetdetd;
	private javax.swing.JTextField etds;
	/** Bouton qui permet d'imprimer l'etat des etudiants */
	private javax.swing.JButton imprimer;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel statistiques;

	// End of variables declaration

	/** Table des etats */
	private javax.swing.JTable table;

	/**
	 * Le constructeur de la classe.
	 * 
	 * @param parent
	 *            La fenetre parent de la fenetre.
	 * @param modal
	 *            Rend le JDialog soit modal ou pas.
	 * @param a
	 *            Ce parametre permet de choisir l'execution ou pas de certain
	 *            blocs du constructeur. Ceci differencie l'interface generale
	 *            sur l'etat des etudiants et l'interface ds Us pour un
	 *            etudiant.
	 */
	public EtatEtudiant(java.awt.Frame parent, boolean modal, int a) {
		super(parent, modal);

		if (a == 1) {
			initComponents(1);
		} else if (a == 2) {
			initComponents(2);
		}
		etds.setText(Integer.toString(table.getRowCount()));
	}

	@Override
	/**
	 * Cette methode gere toute les actions sur les composantes dans l'interface de l'etat des etudiant
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Retour) {

			setVisible(false);

		}
		if (e.getSource() == imprimer) {
			int k = 0;
			try {
				Statement stmt = WindowPrime.getConnection().createStatement();
				ResultSet res = stmt
						.executeQuery("SELECT Matricule,Nom,Prenom,Lieu,Date_Naissance FROM Etudiant");
				int i = 0;

				while (res.next()) {
					k++;
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			Document document = new Document(PageSize.A4);
			try {
				PdfWriter.getInstance(document, new FileOutputStream(
						".\\EtatEtudiant.pdf"));
				document.open();
				Table tableau = new Table(4, k);
				for (int i = 0; i < k; i++) {
					tableau.addCell((String) table.getValueAt(i, 0));
					tableau.addCell((String) table.getValueAt(i, 1));
					tableau.addCell((String) table.getValueAt(i, 2));
					tableau.addCell((String) table.getValueAt(i, 3));

				}
				document.add(tableau);

			} catch (DocumentException de) {
				de.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

			document.close();
			File f = new File(".\\EtatEtudiant.pdf");

			try {
				Desktop.getDesktop().open(f);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	/**
	 * Permet d'obtenir le matricule d'un etudiant a partir de l'identificateur.
	 * 
	 * @param id
	 *            Qui est l'identificateur de l'etudiant.
	 * @return String qui est le matricule de l'étudiant correspondant a
	 *         l'identificateur id mis en parametre Cette methode permet
	 *         d'obtenir le matricule d'un étudiant dont l'id est donnée en
	 *         parametre.
	 */
	public String getMat(int id) {
		String s = "";

		try {
			Statement stmt = WindowPrime.getConnection().createStatement();
			ResultSet r = stmt
					.executeQuery("SELECT Matricule FROM Etudiant WHERE EtudiantID="
							+ id);
			r.next();
			s = r.getString("Matricule");
		} catch (SQLException f) {
			f.printStackTrace();

		}
		return s;
	}

	/**
	 * 
	 * @param i
	 *            qui es t l'identificateur de l'étudiant.
	 * @return String qui est le nom de l'étudiant. Cette methode nous permet
	 *         d'obtenir le nom d'un etudiant dont on a mis l'identificateur en
	 *         parametre.
	 */
	public String getNom(int i) {
		String s = "";
		try {
			Statement stmt = WindowPrime.getConnection().createStatement();
			ResultSet r = stmt
					.executeQuery("SELECT Nom,Prenom FROM Etudiant WHERE EtudiantID="
							+ i);
			r.next();
			s = r.getString("Nom") + "  " + r.getString("Prenom");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 
	 * @param mat
	 *            Le matricule de l'étudiant.
	 * @return int qui est l'identificateur de l'étudiant avec le matricule mat
	 *         mis en parametre.
	 */
	public int getUVID(String mat) {
		int i = 0;
		try {
			Statement stmt = WindowPrime.getConnection().createStatement();
			ResultSet r = stmt
					.executeQuery("SELECT UVID FROM UV WHERE Code_UV='" + mat
							+ "';");
			if (r.next()) {
				i = r.getInt("UVID");
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return i;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents(int j) {

		jLabel14 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		Retour = new javax.swing.JButton();
		imprimer = new javax.swing.JButton();
		jLabel10 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();
		jLabel1 = new javax.swing.JLabel();
		statistiques = new javax.swing.JLabel();
		etatetdetd = new javax.swing.JLabel();
		aide = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		etds = new javax.swing.JTextField();

		jLabel14.setText("Vous voulez acceder a un logiciel qui a acces a une as de donnees securisee. Veuillez vous identifier en tant que proprietaire de cette base de donnees.");

		jPanel1.setPreferredSize(new java.awt.Dimension(799, 559));
		jLabel2.addMouseListener(new mousee());
		Retour.setText("Retour");

		imprimer.setText("Imprimer");

		jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
		jLabel10.setText("LISTE DES ETUDIANTS");

		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null } }, new String[] { "Matricule",
				"Nom", "Prenom", "Lieu De Naissance", "Date De Naissance" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false };

			@Override
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		aide.addMouseListener(new mousee());
		statistiques.addMouseListener(new mousee());
		etatetdetd.addMouseListener(new mousee());
		if (j == 1) {
			Retour.addActionListener(this);
			imprimer.addActionListener(this);
			int k = 0;
			TableModel model = null;
			try {
				Statement stmt = WindowPrime.getConnection().createStatement();
				ResultSet res = stmt
						.executeQuery("SELECT Matricule,Nom,Prenom,Lieu,Date_Naissance FROM Etudiant");
				int i = 0;

				while (res.next()) {
					k++;
				}
				res.beforeFirst();
				String[] s = { "Matricule", "Nom", "Date De Naissance",
						"Lieu De Naissance" };
				model = new DefaultTableModel(s, k);
				while (res.next()) {
					model.setValueAt(res.getString("Matricule"), i, 0);
					model.setValueAt(
							res.getString("Nom") + "  "
									+ res.getString("Prenom"), i, 1);
					model.setValueAt(res.getString("Date_Naissance"), i, 2);
					model.setValueAt(res.getString("Lieu"), i, 3);
					i++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			table.setModel(model);
		} else if (j == 2) {
			int uvs_1 = 0;

			TableModel model = null;

			try {
				Retour.addActionListener(this);
				String s = JOptionPane
						.showInputDialog(
								this,
								"Veuillez entrer le code de l'UV pour lequel vous voulez les etudiants!",
								"CODE DE L'UV", JOptionPane.OK_CANCEL_OPTION);
				int id = getUVID(s);
				Statement stmt = WindowPrime.getConnection().createStatement();
				ResultSet r = stmt
						.executeQuery("SELECT EtudiantID FROM EtudiantUV WHERE UVID="
								+ id);
				while (r.next()) {
					uvs_1++;
				}
				r.beforeFirst();
				String[] s1 = { "Matricule", "Nom" };
				int i = 0;
				model = new DefaultTableModel(s1, uvs_1);
				while (r.next()) {
					model.setValueAt(getNom(r.getInt("EtudiantID")), i, 1);
					model.setValueAt(getMat(r.getInt("EtudiantId")), i, 0);
				}
			} catch (SQLException f) {
				f.printStackTrace();
			}
		}
		jScrollPane1.setViewportView(table);

		jLabel1.setText("RACCOURCIS PRATIQUES");

		statistiques.setForeground(new java.awt.Color(255, 51, 51));
		statistiques.setText("- Statistiques");

		etatetdetd.setForeground(new java.awt.Color(255, 51, 51));
		etatetdetd.setText("- Traitement des Etudiants");

		aide.setForeground(new java.awt.Color(255, 51, 51));
		aide.setText("- Aide Contextuelle");

		jLabel2.setForeground(new java.awt.Color(255, 51, 51));
		jLabel2.setText("- Etats Des UVs");
		recherche.setIcon(new ImageIcon(".\\images\\search.png"));

		etds.setEditable(false);
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(204, 204, 204)
										.addComponent(imprimer)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(Retour)
										.addGap(134, 134, 134))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap(70, Short.MAX_VALUE)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel2)
														.addComponent(aide)
														.addComponent(
																etatetdetd)
														.addComponent(
																statistiques)
														.addComponent(jLabel1)
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				jPanel1Layout
																						.createSequentialGroup()
																						.addComponent(
																								jLabel10)
																						.addGap(309,
																								309,
																								309))
																		.addGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				jPanel1Layout
																						.createSequentialGroup()
																						.addGroup(
																								jPanel1Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING)
																										.addComponent(
																												jScrollPane1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												743,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												etds,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												50,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGap(28,
																								28,
																								28))))));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(50, 50, 50)
										.addComponent(jLabel10)
										.addGap(27, 27, 27)
										.addComponent(jLabel1)
										.addGap(18, 18, 18)
										.addComponent(statistiques)
										.addGap(18, 18, 18)
										.addComponent(etatetdetd)
										.addGap(11, 11, 11)
										.addComponent(aide)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel2)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												23, Short.MAX_VALUE)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												205,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												etds,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(35, 35, 35)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(imprimer)
														.addComponent(Retour))
										.addGap(237, 237, 237)));
		this.setSize(700, 700);
		add(jPanel1, java.awt.BorderLayout.CENTER);

		pack();

	}

}
