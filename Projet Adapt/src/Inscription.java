import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import org.freixas.jcalendar.JCalendarCombo;

/**
 *
 * @author Zafack Billy
 * @version 1.0
 * Voici une classe secondaire de mon projet, Inscription qui herite de {@link javax.swing.JDialog}
 * et implemente l'interface {@link java.awt.event.ActionListener}
 */
public class Inscription extends JDialog implements ActionListener{

	protected  JTextField nom=new JTextField();
	protected Vector<String> tmp=new Vector<String>();
	protected  JTextField prenom=new JTextField();
	protected final  JButton Enregistrer=new JButton("Enregistrer");
	protected final  JButton Reprendre=new JButton("Reprendre");
	protected final  JLabel lblPays = new JLabel("Pays");
	protected final  JButton Fermer = new JButton("Fermer");
	protected final  JComboBox pays = new JComboBox();
	protected    JList list = new JList();
	protected final  JComboBox liste = new JComboBox();
	protected final JButton vider = new JButton("Vider");
	protected final JButton Effacer = new JButton("Effacer");
	protected final  JCalendarCombo naisance= new JCalendarCombo();
	protected JRadioButton Semestre1 = new JRadioButton("Semestre 1");

	protected JRadioButton Semestre2 = new JRadioButton("Semestre 2");
	protected ButtonGroup groupe = new ButtonGroup();
	protected ArrayList<Etudiant> top;
	protected File projet1=new File("projet1");
    protected  JTextField textField = new JTextField();
    public static ArrayList<Etudiant> table = new ArrayList<Etudiant>();
    protected final JLabel Langues = new JLabel("Langues :");
    protected final JLabel lblSex = new JLabel("Sexe :");
    protected final JRadioButton Masculin = new JRadioButton("M");
    protected final JRadioButton Feminin = new JRadioButton("F");
    protected ButtonGroup groupe1 = new ButtonGroup();
    protected JCheckBox Anglais = new JCheckBox("Anglais");
    protected JCheckBox Francais = new JCheckBox("Francais");
    protected final JLabel label_1 = new JLabel("*");
    protected final JRadioButton M = new JRadioButton("M");
    protected boolean inter=false;
    protected int modificateur;


    /**
     * Le constructeur principale de la classe Inscription et herite du constructeur de {@link javax.swing.JDialog}
     * @param J
     * @wbp.parser.constructor
     */
	public Inscription(JFrame J) {
		super(J);
		lblSex.setToolTipText("Selectionnez le sexe de l'étudiant");
		lblSex.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		Langues.setToolTipText("Langues parlées par l'etudiant");
		Langues.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		getContentPane().setBackground(new Color(222, 184, 135));
		textField.setToolTipText("Entrez Le Matricule De L'Etudiant(Il doit etre unique)");
		this.textField.addActionListener(this);
		textField.setColumns(10);
		naisance.setEditable(true);
		naisance.setSize(new Dimension(350, 27));
		naisance.setLocation(new Point(537, 360));
		JScrollPane p=new JScrollPane();
		this.getContentPane().add(p);
		this.setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("K:\\BackupPlus.ico"));
		setLocationByPlatform(true);
		liste.setToolTipText("Selectionnez chacunes des UV de l'étudiant");
		this.liste.addActionListener(this);
		this.setDefaultLookAndFeelDecorated(true);
((JComponent) this.getContentPane()).setBorder(UIManager.getBorder("InternalFrame.border"));
		this.setLocation(210,10);

		setForeground(Color.BLUE);
		setTitle("Inscription");
		this.pack();
		this.setSize(1050, 774);
		this.getContentPane().add(M);
		this.setResizable(true);
		this.M.setVisible(true);
		this.M.setEnabled(false);
this.M.setSelected(false);
		this.setModal(true);
		vider.setToolTipText("Vider la liste d'UVs");
		vider.addActionListener(this);

		JLabel lblMatricule = new JLabel("Matricule :");
		lblMatricule.setToolTipText("Le Matricule De L'Etudiant");

		JLabel Inscription = new JLabel("INSCRIPTION ");
		Inscription.setFont(new Font("Tahoma", Font.BOLD, 16));
this.Enregistrer.addActionListener(this);
		nom = new JTextField();
		nom.setToolTipText("Entrez Le(s) prenoms de l'Etudiant");
		nom.setColumns(10);
		liste.addActionListener(this);
		Semestre1.setToolTipText("UVs Du Semestre 1");
		Semestre1.addActionListener(this);
		Semestre2.setToolTipText("UVs Du Semestre 2");
		Semestre2.addActionListener(this);
groupe1.add(Masculin);
groupe1.add(Feminin);
Masculin.setToolTipText("Masculin");
Masculin.addActionListener(this);
Feminin.setToolTipText("Féminin");
Feminin.addActionListener(this);
Anglais.addActionListener(this);
Francais.addActionListener(this);
textField.addActionListener(this);

		JLabel lblNom = new JLabel("Nom(s) :");
		lblNom.setToolTipText("nom(s) de l'étudiant");

		prenom = new JTextField();
		prenom.setToolTipText("Entrez le(s) nom(s) de l'étudiant");
		prenom.setColumns(10);

		JLabel lblPrenom = new JLabel("Prénom(s) :");
		lblPrenom.setToolTipText("Prenom(s) De l'étudiant");
        String tab[]={"Afghanistan"," Afrique du Sud"," Albanie"," Algérie"," Allemagne"," Andorre "," Angola"," Antigua-et-Barbuda ","Arabie saoudite"," Argentine"," Arménie ","Australie"," Autriche"," Azerbaïdjan ","Bahamas ","Bahreïn"," Bangladesh"," Barbade"," Belgique"," Belize"," Bénin"," Bhoutan"," Biélorussie"," Birmanie"," Bolivie ","Bosnie-Herzégovine"," Botswana"," Brésil"," Brunei"," Bulgarie"," Burkina Faso"," Burundi"," Cambodge"," Cameroun"," Canada"," Cap-Vert"," Centrafricaine ","Chili ","Chine"," Chypre"," Colombie"," Comores"," RDCongo"," Congo-Brazzaville"," Corée Du Nord"," Corée du Sud ","Costa Rica","Côte d'Ivoire","Croatie","Cuba","Danemark","Djibouti","Dominique","Égypte","les Émirats arabes unis","Équateur","Érythrée","Espagne","Estonie","États-Unis","Éthiopie","Fidji","Finlande","France","Gabon","Gambie","Géorgie","Ghana","Grèce","Grenade","Guatemala","Guinée","Guinée-Bissau","Guinée équatoriale","Guyana","Haiti","Honduras","Hongrie","Inde","Indonésie","Iraq","Iran","Irlande","Islande","Israël","Italie","Jamaïque","Japon","Jordanie","Kazakhstan","Kenya","Kirghizistan","Kiribati","Koweït","Laos","Lesotho","Lettonie","Liban","Libéria","Libye","Liechtenstein","Lituanie","Luxembourg","Macédoine","Madagascar","Malaisie","Malawi","Maldives","Mali","Malte","Maroc","Marshall","Maurice","Mauritanie","Mexique","Moldavie","Monaco","Mongolie","Monténégro","Mozambique","Namibie","Niger","Nigeria","Republique Centraficain","Tchad"};
        String tab1[]={"","Anglais","Architecture Des Ordinateurs","Base De Données Relationnelles","Fondements De Management","Mathematiques De Base","Outils De Mathematiques","Programmation Orientee Objet","Probabilites et Statistiques","Science De L\'information","Systemes D\'exploitation"};
        String tab2[]={"","Analyse Numerique","Anglais","Conception De Bases De Données","Management II","Programmation Orientee Objet II","Programmation Systeme","Programmation Web","Systemes Formels","Techniques De Communication"};
String tab3[]={"","Veuilez choisir un Semestre!!!"};
JLabel lblDateDeNaissance = new JLabel("Date De Naissance :");
lblDateDeNaissance.setToolTipText("Date De Naissance De L'Etudiant");

		JLabel labelliste = new JLabel("Liste UV :");
		labelliste.setToolTipText("Liste d'unite de valeur de l'étudiant");



		getEnregistrer().addActionListener(this);
		Effacer.setToolTipText("Effacer l'UV précedente");
		Effacer.addActionListener(this);
		Reprendre.addActionListener(this);
		Fermer.addActionListener(this);

			JLabel label = new JLabel("*");


			groupe.add(Semestre1);
			groupe.add(Semestre2);
			if(groupe.getSelection()!=Semestre2 && groupe.getSelection()!=Semestre1)
			{
				for (String element : tab) {
					pays.addItem(element);
				}
				for (String element : tab3) {
					liste.addItem(element);
				}

			}
			this.getEnregistrer().removeActionListener(this);


			JLabel lblInstitution = new JLabel("Institution : ENSP Yaoundé");
			lblInstitution.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));

			JLabel Departement = new JLabel("Departement : Génie Informatique");
			Departement.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));

			JLabel Classe = new JLabel("Classe : 3eme Année");
			Classe.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));





			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(Classe)
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(130)
												.addComponent(lblSex)
												.addGap(18)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(Feminin)
													.addComponent(Masculin))))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(114)
										.addComponent(Langues)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(Francais)
											.addComponent(Anglais))))
								.addGap(24)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(Semestre1)
									.addComponent(Semestre2))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblDateDeNaissance)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblMatricule)
											.addComponent(lblNom)
											.addComponent(lblPrenom)
											.addComponent(lblPays)
											.addComponent(labelliste)
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(38)
												.addComponent(Enregistrer)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(list, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(vider)
													.addComponent(Effacer)))
											.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
													.addComponent(liste, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(pays, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(nom, Alignment.LEADING)
													.addComponent(prenom, Alignment.LEADING)
													.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
												.addGap(1400)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(label)
													.addGroup(groupLayout.createSequentialGroup()
														.addGap(24)
														.addComponent(M))))
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(128)
												.addComponent(Reprendre)
												.addGap(130)
												.addComponent(Fermer))))))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblInstitution)
								.addGap(279)
								.addComponent(Inscription, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
							.addComponent(Departement))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			lblPays.setToolTipText("Pays d'origine de l'etudiant");
			pays.setToolTipText("Selectionnez le pays d'origine de l'etudiant");
			list.setToolTipText("List des UVs de l'etudiant");
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(178)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
											.addComponent(label)
											.addComponent(lblMatricule)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(44)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblNom)
											.addComponent(prenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(31)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblPrenom)
											.addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
										.addComponent(lblDateDeNaissance)
										.addGap(30)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblPays)
											.addComponent(pays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(27)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(liste, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(labelliste))
										.addGap(6))
									.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(M)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGap(5)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(Effacer)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(vider)
								.addGap(133)))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(Enregistrer)
							.addComponent(Reprendre)
							.addComponent(Fermer))
						.addContainerGap())
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(59)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblInstitution)
							.addComponent(Inscription, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(37)
						.addComponent(Departement)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(42)
								.addComponent(Classe)
								.addPreferredGap(ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
								.addComponent(Semestre1)
								.addGap(18)
								.addComponent(Semestre2)
								.addGap(13))
							.addGroup(groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(Masculin)
										.addComponent(label_1))
									.addComponent(lblSex))
								.addGap(18)
								.addComponent(Feminin)
								.addGap(35)))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(Langues)
							.addComponent(Anglais))
						.addGap(18)
						.addComponent(Francais)
						.addGap(51))
			);
		this.getContentPane().setLayout(groupLayout);
		this.getContentPane().add(naisance);

	}
	public void InsertionBD(){
		Connection connection=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		String ur1 = "jdbc:mysql://localhost:3306/ProjetPOO_Adapt";
		String user = "root"; String pass = "root";
		try{
			connection = DriverManager.getConnection(ur1, user, pass);
			Statement stmt = connection.createStatement();
			int a=stmt.executeUpdate("INSERT INTO Etudiant VALUES"+this.textField+","+this.nom+","+this.prenom+","+(String)this.naisance.getSelectedItem()+","+(String)this.pays.getSelectedItem()+";");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void SelectBD(String mat){
		Connection connection=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		String ur1 = "jdbc:mysql://localhost:3306/ProjetPOO_Adapt";
		String user = "root"; String pass = "root";
		try{
			connection = DriverManager.getConnection(ur1, user, pass);
			Statement stmt = connection.createStatement();
			ResultSet resultats=stmt.executeQuery("SELECT * FROM Etudiant");
			boolean flag=false;
			while(flag)
			{
				if(resultats.getString("Matricule").equals(mat)){
					flag=true;
				}
				else{
					resultats.next();
				}
			}
			this.nom.setText(resultats.getString("Nom"));
			this.textField.setText(resultats.getString("Matricule"));
			this.prenom.setText(resultats.getString("Prenom"));
		}
	}
	
	
	
	
	public Inscription(int i)
	{
		this.modificateur=i;
	}

	public JRadioButton getM() {
		return M;
	}

	public JTextField getNom() {
		return nom;
	}


	public void setNom(JTextField nom) {
		this.nom = nom;
	}


	public JTextField getPrenom() {
		return prenom;
	}


	public void setPrenom(JTextField prenom) {
		this.prenom = prenom;
	}


	public JComboBox getPays() {
		return pays;
	}


	public JList getList() {
		return list;
	}


	public JComboBox getListe() {
		return liste;
	}


	public JCalendarCombo getNaisance() {
		return naisance;
	}


	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField s){
		this.textField=s;
	}
	public String langue()
	{
		if(this.Anglais.isSelected()&&this.Francais.isSelected())
		{
			return "Anglais et Francais";
		}
		else if(this.Anglais.isSelected()&&!this.Francais.isSelected())
		{
			return "Anglais";
		}
		else if(!this.Anglais.isSelected()&&this.Francais.isSelected())
		{
			return "Francais";
		}
		else		{
			return "Aucune Langue";
		}

	}
	public String genre(){
		if(Masculin.isSelected())
		{
			return "Masculin";
		} else {
			return "Feminin";
		}
	}
	public void mLangue(String s)
	{
		if(s.equalsIgnoreCase("Anglais et Francais")) {

			this.Anglais.setSelected(true);
			this.Francais.setSelected(true);
		}
		if(s.equals("Anglais"))
		{
			this.Anglais.setSelected(true);
			this.Francais.setSelected(false);
		}
		if(s.equals("Francais"))
		{
			this.Anglais.setSelected(false);
			this.Francais.setSelected(true);
		}
		else
		{
			this.Anglais.setSelected(false);
			this.Francais.setSelected(false);
		}
	}
	public void mS(String s)
	{
		if(s.equals("Masculin"))
		{
			this.Masculin.setSelected(true);
		}
		else
		{
			this.Feminin.setSelected(true);
		}
	}

	/**
     * La Methode actionperformed permettant la gestion des evenements de ma fenetre principale
     * @param e Ce parametre va gerer les evenements sur l'ensemble de ma fenetre au travers de sa methode getSource
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String tab1[]={"","Anglais","Architecture Des Ordinateurs","Base De Données Relationnelles","Fondements De Management","Mathematiques De Base","Outils De Mathematiques","Programmation Orientee Objet","Probabilites et Statistiques","Science De L\'information","Systemes D\'exploitation"};
        String tab2[]={"","Analyse Numérique","Anglais","Conception De Bases De Données","Management II","Programmation Orientee Objet II","Programmation Systeme","Programmation Web","Systemes Formels","Techniques De Communication"};
		if(e.getSource()==Semestre1)
		{
			liste.removeAllItems();

				for (String element : tab1) {
					liste.addItem(element);
				}

		}
		if(e.getSource()==Semestre2) {
			liste.removeAllItems();
			for (String element : tab2) {
				liste.addItem(element);
			}
		}

		if(e.getSource()==Effacer)
		{
			tmp.remove(tmp.size()-1);
			this.list.setListData(tmp);
		}


		if(e.getSource()==getEnregistrer())
		{

					JOptionPane jop = new JOptionPane();
					jop.setLocale(Locale.FRENCH);
					int q = jop.showConfirmDialog(this, "Voulez vous vraiment enregistrer", "Confirmation", 1);

			if(q==0)
			{
				this.inter=true;
				if(this.getTextField().getText().equals(""))
				{
					JOptionPane.showMessageDialog(this,"Le Matricule est un champs Obligatoire", "Aucun Matricule", JOptionPane.OK_OPTION);
				}
				else if(!this.Masculin.isSelected()&&!this.Feminin.isSelected())
				{
					JOptionPane.showMessageDialog(this,"Le Sexe est un champs Obligatoire", "Aucun Sexe", JOptionPane.OK_OPTION);
				}
				else
				{

				boolean flig=false;
				for(int j=0;j<table.size();j++)
				{
					if(table.get(j).getMatricule1().equals(this.getTextField().getText()))
					{

						flig=true;
					}
				}

if(!flig)
{
					try{
				FileInputStream fichier1 = new FileInputStream("projet1.txt");
				ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(fichier1));
				 table = (ArrayList<Etudiant>)ois.readObject();
				ois.close();

					}
					catch (java.io.IOException e1) {
						e1.printStackTrace();
						}
						catch (ClassNotFoundException e2) {
						e2.printStackTrace();
						}
				Etudiant e1 = new Etudiant(this.textField.getText(),this.nom.getText(),this.prenom.getText(),this.naisance.getDate(),(String) this.pays.getSelectedItem(),this.genre(),this.langue(),this.tmp);
                Inscription.table.add(e1);
                try {
				FileOutputStream fichier = new FileOutputStream("projet1.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fichier);
				oos.writeObject(Inscription.table);
				oos.flush();
				oos.close();
				JOptionPane.showMessageDialog(this, "Enregistrement Avec Succes", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
				}
				catch (java.io.IOException e3) {
				e3.printStackTrace();
				}
                this.setVisible(false);

			}

else
{
	JOptionPane.showMessageDialog(this,"Cet Etudiant Existe deja", "Duplication D'Etudiant", JOptionPane.OK_OPTION);
}
			}
			}
	}

		if(e.getSource()==Fermer)
		{


			if(JOptionPane.showConfirmDialog(Inscription.this,"Voulez vous vraiment quitter","Confirmation",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			{
				Inscription.this.setVisible(false);
			}
		}
		if(e.getSource()==Reprendre)
		{
			this.nom.setText("");
			this.prenom.setText("");
			this.naisance.setDate(null);
			this.textField.setText("");
			this.Semestre1.setSelected(false);
			this.Semestre2.setSelected(false);
			this.Anglais.setSelected(false);
			this.Francais.setSelected(false);
			this.pays.setSelectedItem("Afghanistan");
			this.list.setListData(new Vector<String>());
			this.list.setSelectedValue("", true);
			tmp=new Vector<String>();
		}
		if(e.getSource()==vider)
		{
			this.list.setListData(new Vector<String>());
			tmp=new Vector<String>();
		}


		if(e.getSource()==liste )
		{
			if((String) liste.getSelectedItem()=="Veuilez choisir un Semestre!!!")
			{
				this.list.setListData(new Vector<String>());
				tmp=new Vector<String>();
			}
			boolean flag=false;
for(int i=0;i<tmp.size();i++)
{
	if(tmp.get(i)==liste.getSelectedItem())
	{
		flag=true;
	}
}
if(!flag)
{
this.tmp.add((String) liste.getSelectedItem());
}

this.list.setListData(tmp);


		}
		}


	public boolean isInter() {
		return inter;
	}

	public void setInter(boolean inter) {
		this.inter = inter;
	}

	public int getModificateur() {
		return modificateur;
	}

	public void setModificateur(int modificateur) {
		this.modificateur = modificateur;
	}

	public Vector<String> getTmp() {
		return tmp;
	}


	public void setTmp(Vector<String> tmp) {
		this.tmp = tmp;
	}

	public JButton getEnregistrer() {
		return Enregistrer;
	}
}
