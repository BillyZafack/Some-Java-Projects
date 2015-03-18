import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import com.jgoodies.forms.factories.DefaultComponentFactory;

@SuppressWarnings("serial")
/**
 *
 * @author Zafack Billy Ruffin
 * Etablissement ENSP
 * Departement du Genie Informatique
 * @version 1.0
 * La classe principale {@link Window} qui herite de {@link javax.swing.JFrame}
 *
 *
 *
 */
public class WindowPrime extends JFrame {

	/**
	 * 
	 * @author Zafack Billy
	 * @version 2.0 Cette classe qui implemente
	 *          {@link java.awt.event.ActionListener} est l'ecouteur des
	 *          differntes actions sur les differentes composantes de la fenetre
	 *          principale.
	 */
	class action1 implements ActionListener {
		JButton but1 = new JButton("Retour");
		JButton but2 = new JButton("Retour");
		JButton imprime = new JButton("Imprimer");

		/**
		 * @param e
		 *            qui est de type ActionEvent et permet d'identifier les
		 *            differentes actions dans la fenetre. Cette methode permet
		 *            de gerer les differentes actions sur la fenetre
		 *            principale.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			int k = 0;

			if (e.getSource() == T_Etudiant
					|| e.getSource() == RechercherEtudiant) {
				new InscriptionPm(WindowPrime.this, true).setVisible(true);
				// ////////////////////////hbbbbbbbbbbbbbbbbbbbbb///////////////////////////////////
			}

			if (e.getSource() == passage) {
				int p = JOptionPane.showConfirmDialog(WindowPrime.this,
						"Voulez vous vraiment passer en MODE CLASSIQUE?",
						"CONFIRMATION", 1);
				if (p == 0) {
					setVisible(false);
					new Window().setVisible(true);
				}
			}
			if (e.getSource() == listetds) {
				new EtatEtudiant(WindowPrime.this, true, 1).setVisible(true);

			}

			if (e.getSource() == listetduv) {
				new EtatUV(WindowPrime.this, true, 2).setVisible(true);
			}

			if (e.getSource() == listeuvetd) {

				new EtatEtudiant(WindowPrime.this, true, 2).setVisible(true);

			}
			if (e.getSource() == listeuvs) {
				new EtatUV(WindowPrime.this, true, 1).setVisible(true);

			}
			if (e.getSource() == but2) {
				setVisible(false);
				new WindowPrime().setVisible(true);
			}
			if (e.getSource() == but1) {
				setVisible(false);
				new WindowPrime().setVisible(true);
			}
			if (e.getSource() == but) {
				new Window();

			} else if (e.getSource() == Apropos) {
				JOptionPane
						.showMessageDialog(
								WindowPrime.this,
								"PROJET PROGRAMMATION ORIENTEE OBJET\n Version Profesionnelle\n Interface De Gestion D'Etudiant \n Copyright Decembre 2013 \n Zafack Billy Ruffin \n Sous la supervision de Dr/Phd Ing Batchakui Bernabe ",
								"A PROPOS", 1);
			} else if (e.getSource() == ModeOperatoire) {
				JOptionPane
						.showMessageDialog(
								WindowPrime.this,
								"Ceci est une application de gestion des Ã©tudiants dans un Ã©tablissement\n Dans la fenetre principale appelÃ©e \"Gestion Des Etudiant\" il y a trois menus principaux:\n"
										+ "-D'Abord on a le menu Fichier qui contient \'Quitter\'.\n"
										+ "   Quitter vous permet de quitter l'application\n"
										+ "-Puis on a le menu Traitement qui contient les \'Etudiant\' et \'UV\'.\n"
										+ "   Etudiant nous permet d'effectuer des traitements sur les Ã©tudiants notamment l'ajout, modification,supppression d'un etudiant\n"
										+ "   UV nous permet d'effectuer des traitements sur les UVs notamment l'ajout, modification,supppression d'une UV\n"
										+ "- Il y a ensuite le menu Aide qui affiche l'apropos, le mode operatoire, un guide interactive, la JAVADOC\n"
										+ "- La JAVADOC vous permet d'acceder a la JAVADOC des 5 classes utilisÃ©e dans la cadre de la partie Bases De Donnees De ce projet\n"
										+ "Nous avons notamment les classes : \n *InscriptionPrimeeee* \n *WindowPrime*\n*EtudiantPrime*\n*UVPrimee*\n*Authentification*\n"
										+ "L'Aide interactive est une aide beaucoup plus detaillÃ©e et avec image pour faciliter la comprehension du logiciel. FAITES EN BON USAGE\n"
										+ "- Il y a egalement le menu Etat qui vous permet de regarder et imprimer la liste des etudiants et la liste des UVs dans la base. \n"
										+ "Vous pouvez egalement consulter et imprimer la liste des UVs pour un etudiant donnÃ©e et la liste des Ã©tudiants pour une UV choisie\n"
										+ "PLUSIEURS RACCOURCIS ONT ETE MISE A VOTRE DISPOSITION\n"
										+ "     J'espere que ce logiciel vous sera utile.\n ",
								"MODE OPERATOIRE", JOptionPane.PLAIN_MESSAGE);
			}
			if (e.getSource() == Quitter) {
				int p = JOptionPane.showConfirmDialog(WindowPrime.this,
						"Voulez vous vraiment quitter?", "Confirmer", 1);
				if (p == 0) {
					System.exit(0);
				}
			}
			if (e.getSource() == statistiques) {
				int a = 0, l = 0;
				try {
					Statement stmt = connection.createStatement();
					ResultSet r = stmt.executeQuery("SELECT * FROM Etudiant");
					while (r.next()) {
						a++;
					}
					ResultSet s = stmt.executeQuery("SELECT * FROM UV");
					while (s.next()) {
						l++;
					}
				} catch (SQLException d) {
					d.printStackTrace();
				}
				JOptionPane.showMessageDialog(WindowPrime.this,
						"STATISTIQUES\n" + "- Nombre d'Etudiant Inscrit : " + a
								+ "\n" + "- Nombre D'Unites De Valeurs : " + l,
						"STATISTIQUES", JOptionPane.OK_OPTION);

			}
			if (e.getSource() == T_UV || e.getSource() == traitement) {
				java.awt.EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						UVPrimee dialog = new UVPrimee(new java.awt.Frame(),
								true);
						dialog.setVisible(true);
						dialog.setSize(800, 600);
					}
				});
			}

			if (e.getSource() == etudiantprime) {
				File f = new File(".\\doc\\EtudiantPrime.html");

				try {
					Desktop.getDesktop().open(f);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (e.getSource() == inscriptionprimeeee) {
				File f = new File(".\\doc\\InscriptionPm.html");

				try {
					Desktop.getDesktop().open(f);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane
							.showMessageDialog(
									WindowPrime.this,
									"Erreur Dans L'acces du fichier de docuentation javadoc",
									"ERREUR", JOptionPane.PLAIN_MESSAGE);

				}
			}
			if (e.getSource() == uvprimee) {
				File f = new File(".\\doc\\UVPrimee.html");

				try {
					Desktop.getDesktop().open(f);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane
							.showMessageDialog(
									WindowPrime.this,
									"Erreur Dans L'acces du fichier de docuentation javadoc",
									"ERREUR", JOptionPane.PLAIN_MESSAGE);

				}
			}
			if (e.getSource() == authentification) {
				File f = new File(".\\doc\\Authentification.html");

				try {
					Desktop.getDesktop().open(f);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane
							.showMessageDialog(
									WindowPrime.this,
									"Erreur Dans L'acces du fichier de docuentation javadoc",
									"ERREUR", JOptionPane.PLAIN_MESSAGE);

				}
			}
			if (e.getSource() == windowprime) {
				File f = new File(".\\doc\\WindowPrime.html");

				try {
					Desktop.getDesktop().open(f);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane
							.showMessageDialog(
									WindowPrime.this,
									"Erreur Dans L'acces du fichier de docuentation javadoc",
									"ERREUR", JOptionPane.PLAIN_MESSAGE);

				}
			}
			if (e.getSource() == image) {
				File f = new File(".\\CAHIER ANALYSE.docx");

				try {
					Desktop.getDesktop().open(f);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (e.getSource() == html) {
				File f = new File(".\\html\\Windows.htm");

				try {
					Desktop.getDesktop().open(f);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (e.getSource() == etatetudiant) {
				File f = new File(".\\doc\\EtatEtudiant.html");

				try {
					Desktop.getDesktop().open(f);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane
							.showMessageDialog(
									WindowPrime.this,
									"Erreur Dans L'acces du fichier de docuentation javadoc",
									"ERREUR", JOptionPane.PLAIN_MESSAGE);

				}
			}
			if (e.getSource() == etatuv) {
				File f = new File(".\\doc\\EtatUV.html");

				try {
					Desktop.getDesktop().open(f);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane
							.showMessageDialog(
									WindowPrime.this,
									"Erreur Dans L'acces du fichier de docuentation javadoc",
									"ERREUR", JOptionPane.PLAIN_MESSAGE);

				}
			}
		}

	}

	public interface Actioni extends ActionListener {
		public void actionPerformed(ActionEvent e, int i);
	}

	/** Bar de menu de la fenetre principale */
	private final JMenuBar menubar = new JMenuBar();
	/** Menu Fichier de la fenetre principale */
	private final JMenu Fichier = new JMenu();
	/** Menu Traitement de la fenetre principale */
	private final JMenu Traitement = new JMenu();
	/** Menu D'Aide de la fenetre principale */
	private final JMenu Help = new JMenu();
	/** L'item de menu Quitter */
	private static JMenuItem Quitter = new JMenuItem();
	/** L'element de menu Traitement des UVs */
	private final JMenuItem T_UV = new JMenuItem();
	/** L'element de menu Traitement des Etudiants */
	private final JMenuItem T_Etudiant = new JMenuItem();
	/** L'element de menu mode operatoire */
	private final JMenuItem ModeOperatoire = new JMenuItem();
	/** L'element de menu A propos */
	private final JMenuItem Apropos = new JMenuItem();
	/** Le bouton Traitement de etudiants */
	private JButton RechercherEtudiant = new JButton("Traitement D'Etudiant");
	/** Le bouton Traitement des UVs */
	private JButton traitement = new JButton("Traitement D'UVs");
	private Inscription J = new Inscription(this);
	private int j;
	/** Instance de la connection a la base de donnee */
	static Connection connection;

	/**
	 * Cette methode permet la creation des tables dans la base de donnees. Elle
	 * cree les trois tables Etudiant, UV et EtudiantUV qui sont indispensaables
	 * pour le bon fonctionnement du logiciel
	 */
	public static void creationTable() {
		try {
			Statement stmt = connection.createStatement();
			int a = stmt
					.executeUpdate("CREATE TABLE IF NOT EXISTS Etudiant(EtudiantID INT AUTO_INCREMENT,"
							+ "Matricule VARCHAR(30),"
							+ "Nom VARCHAR(30),"
							+ "Prenom VARCHAR(30),"
							+ "Date_Naissance VARCHAR(30),"
							+ "Pays VARCHAR(30),"
							+ "Lieu VARCHAR(30),"
							+ "CONSTRAINT PRIMARY KEY(EtudiantID)" + ");");
			int b = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS UV("
					+ "UVID INT AUTO_INCREMENT," + "Code_UV VARCHAR(30),"
					+ "Intitule_UV VARCHAR(60),"
					+ "Nombre_Credits VARCHAR(30),"
					+ "CONSTRAINT PRIMARY KEY(UVID)" + ");");
			int c = stmt
					.executeUpdate("CREATE TABLE IF NOT EXISTS EtudiantUV("
							+ "EtudiantUVID INT AUTO_INCREMENT,"
							+ "EtudiantID INT,"
							+ "UVID INT,"
							+ "CONSTRAINT PRIMARY KEY(EtudiantUVID),"
							+ "CONSTRAINT FOREIGN KEY(EtudiantID) REFERENCES Etudiant(EtudiantID),"
							+ "CONSTRAINT FOREIGN KEY(UVID) REFERENCES UV(UVID)"
							+ ");");
		} catch (SQLException n) {
			n.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public static JMenuItem getQuitter() {
		return Quitter;
	}

	public static void setConnection(Connection connection) {
		connection = connection;
	}

	public static void setQuitter(JMenuItem quitter) {
		Quitter = quitter;
	}

	/** Le bouton retour */
	private JButton but = new JButton("Retour");
	/** Le bouton permettant le passage a la version classique du projet */
	private JButton passage = new JButton("Passage a la version Classique");
	/** Le JPanel de la fenetre principale */
	private JPanel pan = new JPanel();
	/** Le menu de l'etat des etudiant */
	private final JMenu E_Etudiant = new JMenu("Etat");
	private final JLabel lblVersionProfesionnelle = new JLabel(
			"Version Professionnelle");
	/** Le menu Etudiant */
	private final JMenu Etudiants = new JMenu("Etudiants");
	/** L'element de menu montrant la liste de tout les etudiants */
	private final JMenuItem listetds = new JMenuItem("Listes D'Etudiants");
	/** L'element de menu montrant la liste d'UV pour un etudiant choisi */
	private final JMenuItem listetduv = new JMenuItem(
			"Liste D'UV pour un etudiant");
	/** Le menu UVs */
	private final JMenu UVs = new JMenu("UVs");
	/** L'element de menu s ur la liste des UVs */
	private final JMenuItem listeuvs = new JMenuItem("Liste d'UV");
	/** Liste d'etudiants pour une UV donnee */
	private final JMenuItem listeuvetd = new JMenuItem(
			"Liste d'Etudiant pour une UV");
	/** Acces aux documentations JAVADOC */
	private final JMenu mnJavadocs = new JMenu("JAVADOCs");
	private final JMenuItem inscriptionprimeeee = new JMenuItem(
			"Classe InscriptionPrimeeee");
	private final JMenuItem windowprime = new JMenuItem("Classe WindowPrime");
	private final JMenuItem etudiantprime = new JMenuItem(
			"Classe EtudiantPrime");

	private final JMenuItem authentification = new JMenuItem(
			"Classe Authentification");

	private final JMenuItem uvprimee = new JMenuItem("Classe UVPrimee");

	private final JMenuItem image = new JMenuItem(
			"Aide ImagÃ©e+Analyse(DetaillÃ©e)");
	private final JButton statistiques = new JButton("Statistiques Generales");
	private final JMenuItem etatetudiant = new JMenuItem("Classe EtatEtudiant");

	private final JMenuItem etatuv = new JMenuItem("Classe EtatUV");

	private final JMenuItem html = new JMenuItem("Aide Html(non-detaillÃ©e)");

	/**
	 * Le Constructeur de la Class {@link WindowPrime} Permet d'implementer les
	 * caracteristiques par defaut de la fenetre principale
	 */
	public WindowPrime() {
		statistiques
				.setToolTipText("Consulter les statistiques generales pour les informations dans la BD");
		creationTable();
		lblVersionProfesionnelle.setFont(new Font("Script MT Bold", Font.BOLD
				| Font.ITALIC, 16));
		this.setSize(750, 543);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Gestion Des Etudiants");
		Fichier.setMnemonic('F');
		Fichier.setBorderPainted(true);
		Quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				InputEvent.CTRL_MASK));
		Quitter.setIcon(new ImageIcon(".\\pic\\button-close-icon.png"));
		Quitter.setMnemonic('Q');
		Quitter.setToolTipText("Quitter l'application");
		Fichier.add(Quitter);
		RechercherEtudiant.setIcon(new ImageIcon(
				".\\pic\\button-contents-icon.png"));
		RechercherEtudiant.addActionListener(new action1());
		traitement.setIcon(new ImageIcon(".\\pic\\button-minimize-icon.png"));
		traitement.addActionListener(new action1());
		T_UV.setIcon(new ImageIcon(".\\pic\\button-minimize-icon.png"));
		T_UV.setOpaque(true);
		T_UV.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
				InputEvent.CTRL_MASK));
		T_UV.setToolTipText("Effectuer Des traitements sur un Etudiant");
		T_UV.setMnemonic('U');
		Traitement.setToolTipText("Rechercher un Etudiant");
		T_Etudiant.setIcon(new ImageIcon(".\\pic\\button-contents-icon.png"));
		T_Etudiant.setOpaque(true);
		T_Etudiant.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				InputEvent.CTRL_MASK));
		T_Etudiant.setRolloverEnabled(true);
		T_Etudiant.setToolTipText("Effectuer des traitements sur un etudiant");
		Traitement.add(T_Etudiant);
		Traitement.add(T_UV);
		T_Etudiant.setMnemonic('E');
		ModeOperatoire.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
				InputEvent.CTRL_MASK));
		ModeOperatoire
				.setToolTipText("Consulter le Mode Operatoire de ce logiciel");
		ModeOperatoire.setMnemonic('M');
		Help.add(ModeOperatoire);

		Help.add(mnJavadocs);
		inscriptionprimeeee
				.setToolTipText("Acceder a la documentation JAVADOC pour la classe InscriptionPrimeeee");
		inscriptionprimeeee.setMnemonic('I');
		inscriptionprimeeee.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_I, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));

		mnJavadocs.add(inscriptionprimeeee);
		windowprime
				.setToolTipText("Acceder a la documentation JAVADOC pour la classe WindowPrime");
		windowprime.setMnemonic('W');
		windowprime.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
				InputEvent.CTRL_MASK | InputEvent.ALT_MASK));

		mnJavadocs.add(windowprime);
		etudiantprime
				.setToolTipText("Acceder a la documentation JAVADOC pour la classe EtudiantPrime");
		etudiantprime.setMnemonic('E');
		etudiantprime.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				InputEvent.CTRL_MASK | InputEvent.ALT_MASK));

		mnJavadocs.add(etudiantprime);
		authentification
				.setToolTipText("Acceder a la documentation JAVADOC pour la classe Authentification");
		authentification.setMnemonic('A');
		authentification.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK | InputEvent.ALT_MASK));

		mnJavadocs.add(authentification);
		uvprimee.setToolTipText("Acceder a la documentaiton JAVADOC pour la classe UVPrimee");
		uvprimee.setMnemonic('U');
		uvprimee.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
				InputEvent.CTRL_MASK | InputEvent.ALT_MASK));

		mnJavadocs.add(uvprimee);
		etatetudiant.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,
				InputEvent.CTRL_MASK | InputEvent.ALT_MASK));

		mnJavadocs.add(etatetudiant);
		etatuv.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				InputEvent.CTRL_MASK | InputEvent.ALT_MASK));

		mnJavadocs.add(etatuv);
		image.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
				InputEvent.CTRL_MASK));

		Help.add(image);

		Help.add(html);
		Apropos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));
		Apropos.setMnemonic('A');
		Help.add(Apropos);
		Quitter.setText("Quitter");
		T_Etudiant.setText("Etudiant");
		T_UV.setText("UV");
		ModeOperatoire.setText("Mode Operatoire");
		Apropos.setText("A propos");
		Fichier.setText("Fichier");
		Traitement.setText("Traitement");
		Help.setText("Help");
		statistiques.addActionListener(new action1());
		Quitter.addActionListener(new action1());
		Apropos.addActionListener(new action1());
		listetds.setToolTipText("Consulter la liste des etudiants inscrits");
		listetds.setMnemonic('E');
		listetds.addActionListener(new action1());
		listeuvs.setToolTipText("Consulter la liste des UVs");
		listeuvs.setMnemonic('U');
		listeuvs.addActionListener(new action1());
		listetduv
				.setToolTipText("Consulter la liste d'UVs pour un etudiant precis");
		listetduv.setMnemonic('U');
		listetduv.addActionListener(new action1());
		html.addActionListener(new action1());
		listeuvetd
				.setToolTipText("Consulter la liste d'etudiants pour une UV donnee");
		listeuvetd.setMnemonic('E');
		listeuvetd.addActionListener(new action1());
		passage.setIcon(new ImageIcon(".\\pic\\sizzlejs_32x32.png"));
		passage.addActionListener(new action1());
		T_Etudiant.addActionListener(new action1());
		T_UV.addActionListener(new action1());
		ModeOperatoire.addActionListener(new action1());
		menubar.add(Fichier);
		menubar.add(Traitement);
		menubar.add(E_Etudiant);
		Etudiants.setIcon(new ImageIcon(".\\pic\\button-contents-icon.png"));

		E_Etudiant.add(Etudiants);
		listetds.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				InputEvent.CTRL_MASK | InputEvent.ALT_MASK));

		Etudiants.add(listetds);
		listetduv.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));

		Etudiants.add(listetduv);
		UVs.setIcon(new ImageIcon(".\\pic\\button-minimize-icon.png"));

		E_Etudiant.add(UVs);
		listeuvs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
				InputEvent.CTRL_MASK | InputEvent.ALT_MASK));

		UVs.add(listeuvs);
		listeuvetd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
				InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		etatuv.addActionListener(new action1());
		etatetudiant.addActionListener(new action1());
		etudiantprime.addActionListener(new action1());
		inscriptionprimeeee.addActionListener(new action1());
		uvprimee.addActionListener(new action1());
		authentification.addActionListener(new action1());
		windowprime.addActionListener(new action1());
		image.addActionListener(new action1());
		UVs.add(listeuvetd);
		menubar.add(Help);
		pan.setBorder(UIManager.getBorder("InternalFrame.border"));
		pan.setBackground(new Color(0, 206, 209));
		pan.setForeground(new Color(138, 43, 226));
		setContentPane(pan);
		setDefaultLookAndFeelDecorated(true);
		menubar.setVisible(true);
		pan.setVisible(true);

		JLabel lblGestionDesEtudiants = DefaultComponentFactory.getInstance()
				.createTitle("GESTION DES ETUDIANTS");
		lblGestionDesEtudiants.setFont(new Font("Monotype Corsiva", Font.BOLD
				| Font.ITALIC, 32));

		JLabel lblEnspgipoo = DefaultComponentFactory.getInstance()
				.createLabel("ENSP/3GI/POO");
		lblEnspgipoo.setIcon(new ImageIcon(".\\pic\\BackupPlus.ico"));
		lblEnspgipoo.setFont(new Font("Footlight MT Light", Font.ITALIC, 15));

		JLabel lblProjetgestiondeseleves = DefaultComponentFactory
				.getInstance().createLabel("Projet/GestionDesEtudiants");
		lblProjetgestiondeseleves.setFont(new Font("Goudy Old Style",
				Font.ITALIC, 15));

		JLabel lblSousLaSupervision = DefaultComponentFactory.getInstance()
				.createLabel("Sous La Supervision Du:");
		lblSousLaSupervision
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		JLabel lblDrphdBatchakuiBernabe = DefaultComponentFactory.getInstance()
				.createLabel("M. Mbouh Pryde GHOGOMU");
		lblDrphdBatchakuiBernabe.setFont(new Font("Goudy Old Style", Font.BOLD
				| Font.ITALIC, 17));

		JLabel lblCopyrightEnspgizbrDecembre = DefaultComponentFactory
				.getInstance().createLabel(
						"Copyright CMR/UY1/ENSP/3GI/ZBR Avril 2014");
		lblCopyrightEnspgizbrDecembre.setFont(new Font("Kalinga", Font.BOLD
				| Font.ITALIC, 12));

		GroupLayout gl_pan = new GroupLayout(pan);
		gl_pan.setHorizontalGroup(gl_pan
				.createParallelGroup(Alignment.LEADING)
				.addComponent(menubar, GroupLayout.DEFAULT_SIZE, 720,
						Short.MAX_VALUE)
				.addGroup(
						gl_pan.createSequentialGroup()
								.addGap(19)
								.addComponent(lblEnspgipoo)
								.addGap(195)
								.addComponent(lblVersionProfesionnelle)
								.addPreferredGap(ComponentPlacement.RELATED,
										140, Short.MAX_VALUE)
								.addComponent(statistiques))
				.addGroup(
						gl_pan.createSequentialGroup().addContainerGap()
								.addComponent(lblProjetgestiondeseleves)
								.addContainerGap(561, Short.MAX_VALUE))
				.addGroup(
						gl_pan.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblSousLaSupervision,
										GroupLayout.PREFERRED_SIZE, 160,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(550, Short.MAX_VALUE))
				.addGroup(
						gl_pan.createSequentialGroup().addContainerGap()
								.addComponent(lblDrphdBatchakuiBernabe)
								.addContainerGap(505, Short.MAX_VALUE))
				.addGroup(
						gl_pan.createSequentialGroup()
								.addContainerGap(170, Short.MAX_VALUE)
								.addComponent(lblGestionDesEtudiants)
								.addGap(146))
				.addGroup(
						gl_pan.createSequentialGroup()
								.addContainerGap()
								.addComponent(RechercherEtudiant)
								.addGap(94)
								.addComponent(passage)
								.addPreferredGap(ComponentPlacement.RELATED,
										99, Short.MAX_VALUE)
								.addComponent(traitement).addContainerGap())
				.addGroup(
						gl_pan.createSequentialGroup()
								.addContainerGap(240, Short.MAX_VALUE)
								.addComponent(lblCopyrightEnspgizbrDecembre)
								.addGap(208)));
		gl_pan.setVerticalGroup(gl_pan
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_pan.createSequentialGroup()
								.addComponent(menubar,
										GroupLayout.PREFERRED_SIZE, 33,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(
										gl_pan.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_pan.createSequentialGroup()
																.addGap(18)
																.addGroup(
																		gl_pan.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						lblEnspgipoo)
																				.addComponent(
																						lblVersionProfesionnelle))
																.addGap(18)
																.addComponent(
																		lblProjetgestiondeseleves)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		lblSousLaSupervision,
																		GroupLayout.PREFERRED_SIZE,
																		48,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		lblDrphdBatchakuiBernabe)
																.addGap(76)
																.addComponent(
																		lblGestionDesEtudiants))
												.addGroup(
														gl_pan.createSequentialGroup()
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		statistiques)))
								.addPreferredGap(ComponentPlacement.RELATED,
										93, Short.MAX_VALUE)
								.addGroup(
										gl_pan.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(traitement)
												.addComponent(
														RechercherEtudiant)
												.addComponent(passage))
								.addGap(23)
								.addComponent(lblCopyrightEnspgizbrDecembre)
								.addContainerGap()));
		pan.setLayout(gl_pan);

		setVisible(true);
	}

	public JMenuItem getApropos() {
		return Apropos;
	}

	public JMenuItem getAuthentification() {
		return authentification;
	}

	public JButton getBut() {
		return but;
	}

	public JMenu getE_Etudiant() {
		return E_Etudiant;
	}

	public JMenuItem getEtatetudiant() {
		return etatetudiant;
	}

	public JMenuItem getEtatuv() {
		return etatuv;
	}

	/**
	 * 
	 * @param mat
	 *            qui est le matricule de l'étudiant
	 * @return int qui est l'identificateur de l'étudiant de l'étudiant de
	 *         matricule mis en parametre Cette méthode nous permet d'obtenir
	 *         l'identificateur d'un étudiant a partir de son matricule.
	 */
	public int getEtdID(String mat) {
		int i = 0;
		ResultSet s;
		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT EtudiantID FROM Etudiant WHERE Matricule=?");
			stmt.setString(1, mat);
			s = stmt.executeQuery();
			if (s.next()) {
				i = s.getInt("EtudiantID");
			} else {
				i = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public JMenuItem getEtudiantprime() {
		return etudiantprime;
	}

	public JMenu getEtudiants() {
		return Etudiants;
	}

	public JMenu getFichier() {
		return Fichier;
	}

	public JMenu getHelp() {
		return Help;
	}

	public JMenuItem getImage() {
		return image;
	}

	public JMenuItem getInscriptionprimeeee() {
		return inscriptionprimeeee;
	}

	public int getJ() {
		return j;
	}

	public JLabel getLblVersionProfesionnelle() {
		return lblVersionProfesionnelle;
	}

	public JMenuItem getListetds() {
		return listetds;
	}

	public JMenuItem getListetduv() {
		return listetduv;
	}

	public JMenuItem getListeuvetd() {
		return listeuvetd;
	}

	public JMenuItem getListeuvs() {
		return listeuvs;
	}

	/**
	 * 
	 * @param id
	 * @return String qui est le matricule de l'étudiant correspondant a
	 *         l'identificateur id mis en parametre Cette methode permet
	 *         d'obtenir le matricule d'un étudiant dont l'id est donnée en
	 *         parametre
	 */
	public String getMat(int id) {
		String s = "";

		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT Matricule FROM Etudiant WHERE EtudiantID=?");
			stmt.setInt(1, id);
			ResultSet r = stmt.executeQuery();
			r.next();
			s = r.getString("Matricule");
		} catch (SQLException f) {
			f.printStackTrace();

		}
		return s;
	}

	public JMenuBar getMenubar() {
		return menubar;
	}

	public JMenu getMnJavadocs() {
		return mnJavadocs;
	}

	public JMenuItem getModeOperatoire() {
		return ModeOperatoire;
	}

	/**
	 * 
	 * @param i
	 *            qui es t l'identificateur de l'étudiant.
	 * @return String qui est le nom de l'étudiant. Cette methode nous permet
	 *         d'obtenir le nom d'un etudiant dont on a mis l'identificateur en
	 *         parametre
	 */
	public String getNom(int i) {
		String s = "";
		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT Nom,Prenom FROM Etudiant WHERE EtudiantID=?");
			stmt.setInt(1, i);
			ResultSet r = stmt.executeQuery();
			s = r.getString("Nom") + "  " + r.getString("Prenom");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	public JPanel getPan() {
		return pan;
	}

	public JButton getPassage() {
		return passage;
	}

	public JButton getRechercherEtudiant() {
		return RechercherEtudiant;
	}

	public JButton getStatistiques() {
		return statistiques;
	}

	public JMenuItem getT_Etudiant() {
		return T_Etudiant;
	}

	public JMenuItem getT_UV() {
		return T_UV;
	}

	public JMenu getTraitement() {
		return Traitement;
	}

	/**
	 * 
	 * @param mat
	 *            Le matricule de l'Ã©tudiant
	 * @return int qui est l'identificateur de l'Ã©tudiant avec le matricule mat
	 *         mis en parametre
	 */
	public int getUVID(String mat) {
		int i = 0;
		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT UVID FROM UV WHERE Code_UV=?");
			stmt.setString(1, mat);
			ResultSet r = stmt.executeQuery();
			if (r.next()) {

				i = r.getInt("UVID");
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return i;
	}

	/**
	 * 
	 * @param id
	 * @return Vector<String> qui contient la liste des UVs de l'Ã©tudiant
	 *         d'identificateur id(mis en parametre). Cette methode nous permet
	 *         de recuperer la liste des UVs a partir de son identificateur.
	 */
	public Vector<String> getUVList(int id) {
		Vector<String> v = new Vector<String>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet r = stmt
					.executeQuery("SELECT UVID FROM EtudiantUV WHERE EtudiantID= "
							+ id);
			while (r.next()) {
				ResultSet a = stmt
						.executeQuery("SELECT Intitule_UV FROM UV WHERE UVID="
								+ r.getInt("UVID"));
				a.next();
				v.add(a.getString("Intitule_UV"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return v;
	}

	public JMenuItem getUvprimee() {
		return uvprimee;
	}

	public JMenu getUVs() {
		return UVs;
	}

	public JMenuItem getWindowprime() {
		return windowprime;
	}

	public void setBut(JButton but) {
		this.but = but;
	}

	public void setJ(Inscription j) {
		J = j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public void setPan(JPanel pan) {
		this.pan = pan;
	}

	public void setPassage(JButton passage) {
		this.passage = passage;
	}

	public void setRechercherEtudiant(JButton rechercherEtudiant) {
		RechercherEtudiant = rechercherEtudiant;
	}

	public void setTraitement(JButton traitement) {
		this.traitement = traitement;
	}

}
