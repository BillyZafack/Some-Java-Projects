import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Cette classe construit et gere les differentes actions sur l'interface de traitement des etudiants inscrits.
 * @author Zafack Billy
 * Class Inscription Primeeee qui herite de {@link javax.swing.JDialog}
 *
 * @version 2.0
 */
public class InscriptionPrimeeee extends java.awt.Dialog{

 // Variables declaration - do not modify
    private javax.swing.JButton Fermer=new JButton(); // Le bouton Fermer de l'interface
    private JButton Fermer_1;
    private javax.swing.JButton Rechercher=new JButton(); // Le bouton Rechercher
    private JButton Rechercher_1;
    private javax.swing.JComboBox UVbox=new JComboBox(); //Le combo box contenant les differentes UVs
    private JComboBox UVbox_1;
    private javax.swing.JButton ajout=new JButton(); // Le bouton ajout de l'interface d'inscription
    private JButton ajout_1;
    private javax.swing.JComboBox annee=new JComboBox(); // Le combo box contenant les differents jours
    private JComboBox annee_1;
    private javax.swing.JComboBox comboBox=new JComboBox();
    private JComboBox comboBox_1;
    private static int i=1; //Compteur des nombres d'etudiants inscrit.
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable table_1=new JTable(); // Table des Etudiants inscrit
    private javax.swing.JComboBox jour=new JComboBox(); // Combo box des jours du mois
    private JComboBox jour_1;
    private javax.swing.JList list=new JList(); //La liste contenant les Uv selectionnees
    private javax.swing.JButton modifier=new JButton(); // Le bouton modifier de l'interface
    private JButton modifier_1;
    private javax.swing.JComboBox mois=new JComboBox(); // Combo Box des mois de l'annee
    private JComboBox mois_1;
    private javax.swing.JTextField nom=new JTextField(); // Le champs du nom de l'etudiant
    private JTextField nom_1;
    private javax.swing.JTextField prenom=new JTextField(); // Le champs du prenom de l'etudiant
    private JTextField prenom_1;
    private javax.swing.JButton reinitialiser=new JButton(); // Le bouton re-initialiser
    private JButton reinitialiser_1;
    private javax.swing.JButton suppressionduv=new JButton(); // Le bouton permettant d'enlever des UVs selectionnees
    private JButton suppressionduv_1;
    private javax.swing.JButton supprimer=new JButton(); // Le bouton supprimer de l'interface
    private JButton supprimer_1;
    private javax.swing.JTextField textField=new JTextField(); // Le champs de texte matricule de l'interface
    private JTextField textField_1;
    private javax.swing.JTextField textField_3=new JTextField(); // Le champs de recherche matricule
    private JTextField textField_3_1;
    private javax.swing.JTextField textField_4=new JTextField(); // Le champs de recherche nom
    private JTextField textField_4_1;
    private javax.swing.JTextField textField_5=new JTextField(); //La champs de recherche prenom
    private JTextField textField_5_1;
    private JLabel lblListeDesUv = new JLabel("Liste Des UV");
    private Vector<String> vect=new Vector<String>();
    private static Vector<String> vect1=new Vector<String>(); // Vecteur permettant la manipulation du contenue de la JList
    private Vector<String> vect2=new Vector<String>();
    private Vector<String> column=new Vector<String>();
    private Vector<String> vect3=new Vector<String>();
	public static Connection connection= null; // La connection a la Base De Donnees ProjetPOO_Adapt
	private final JButton btnFermer = new JButton("Fermer");
	private static int index=0;
	private static int indexu=0;
	private JButton nouveau=new JButton();
	private JLabel lblLieuDeNaissance;
	private JTextField lieu; // Le champs de texte du lieu de naissance
	private JTextField uvs; // Le compteur des uvs selectionnees
	private JLabel lblNbreDuvs;
	private JTextField etds; // Le compteur des etudiants dans le tableau
	JLabel etduv = new JLabel("-Traitement D'UVs");
	 JLabel aide = new JLabel("AIDE CONTEXTUELLE");
     JLabel javadoc = new JLabel("- JAVADOC");
     JLabel statistiques = new JLabel("- Statistiques");
     private JLabel lblRaccourcisPratiques;
    // End of variables declaration

	/**
     * Cree une nouvelle fiche d'inscription.
     * @param parent qui est le {@link javax.swing.JFrame} qui heberge cette boite de dialog
     * @param modal un boolean qui rend la boite de dialog modal ou pas
     * C'est le constructeur de l'interface de traitement des etudiants
     */
   public InscriptionPrimeeee(java.awt.Frame parent, boolean modal) {

    	super(parent, modal);
    	setResizable(false);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		this.setModal(true);
		String ur1 = "jdbc:mysql://localhost:3306/ProjetPOO_Adapt";
		String user = "root"; String pass = "martin";
		try {
			connection = DriverManager.getConnection(ur1, user, pass);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initComponents();
		TableModel col=table_1.getModel();
		this.reinitUVBox();

		try
		{
		Statement stmnt = connection.createStatement();

		ResultSet res=stmnt.executeQuery("SELECT * FROM Etudiant");
		int k=0;

		while(res.next())
		{
			k++;
		}
		System.out.println("Nombre d'etudiants ds la base"+k);
		this.setIndex(k);
		EtudiantPrime.setIndex(k);
		this.etds.setText(Integer.toString(k));
		this.uvs.setText(Integer.toString(0));
		String[] s={"Matricule","Nom","Prenom","Date_Naissance","Pays","Lieu"};
		String data[][]=new String[k][6];
		res.beforeFirst();
		res.next();
		for(int i=0;i<k;i++)
		{
			System.out.println(k+res.getString("Matricule")+res.getString("Nom"));
			data[i][0]=res.getString("Matricule");
			data[i][1]=res.getString("Nom");
			data[i][2]=res.getString("Prenom");
			data[i][3]=res.getString("Date_Naissance");
			data[i][4]=res.getString("Pays");
			data[i][5]=res.getString("Lieu");
			res.next();
		}
		TableModel model=new DefaultTableModel(data,s);
		table_1.setModel(model);
		jScrollPane1.add(table_1);
		jPanel1.setLayout(null);
		jPanel1.add(lblRaccourcisPratiques);
		etduv.setBounds(17, 39, 86, 14);
		jPanel1.add(etduv);
		jPanel1.add(jLabel10);
		aide.setBounds(955, 39, 102, 14);
		jPanel1.add(aide);
		statistiques.setBounds(17, 58, 63, 14);
		jPanel1.add(statistiques);
		javadoc.setBounds(17, 83, 54, 14);
		jPanel1.add(javadoc);
		jPanel1.add(jLabel13);
		jPanel1.add(jLabel1);
		jPanel1.add(textField_1);
		jPanel1.add(jLabel11);
		jPanel1.add(UVbox_1);
		jPanel1.add(jSeparator4);
		jPanel1.add(ajout_1);
		jPanel1.add(jLabel2);
		jPanel1.add(jLabel3);
		jPanel1.add(nom_1);
		jPanel1.add(prenom_1);
		jPanel1.add(jScrollPane2);
		jPanel1.add(modifier_1);
		jPanel1.add(supprimer_1);
		jPanel1.add(jLabel4);
		jPanel1.add(jour_1);
		jPanel1.add(mois_1);
		jPanel1.add(annee_1);
		jPanel1.add(suppressionduv_1);
		jPanel1.add(reinitialiser_1);
		jPanel1.add(jLabel5);
		jPanel1.add(comboBox_1);
		jPanel1.add(lblLieuDeNaissance);
		jPanel1.add(lieu);
		jPanel1.add(lblNbreDuvs);
		jPanel1.add(uvs);
		jPanel1.add(Fermer_1);
		jPanel1.add(jLabel6);
		jPanel1.add(jLabel7);
		jPanel1.add(textField_3_1);
		jPanel1.add(jLabel8);
		jPanel1.add(textField_4_1);
		jPanel1.add(jLabel9);
		jPanel1.add(textField_5_1);
		jPanel1.add(Rechercher_1);
		jPanel1.add(etds);
		jPanel1.add(jScrollPane1);
		initComponents();
		if(k>=1)
		{
		res.beforeFirst();
		res.next();

		this.reinitetd();
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
/**
 *
 */

    /**
     * Cette classe permet de recuperer les differents etudiants et leurs informations dans un tableau a deux dimension renvoyé a la fin.
     * @return String[][] contenant toute les informations sur les etudiants inscrits
     * Ces informations sont obtenues d'un {@link java.sql.ResultSet}
     */
    public String[][] element()
    {
    	int k=0;
    	String data[][] = null;
    try{
    	Statement stmt=connection.createStatement();
    	ResultSet res=stmt.executeQuery("SELECT * FROM Etudiant");
    	while(res.next())
    	{
    		k++;
    	}
    	 data=new String[k][6];
		res.beforeFirst();
		res.next();
		for(int i=0;i<k;i++)
		{
			data[i][0]=res.getString("Matricule");
			data[i][1]=res.getString("Nom");
			data[i][2]=res.getString("Prenom");
			data[i][3]=res.getString("Date_Naissance");
			data[i][4]=res.getString("Pays");
			data[i][5]=res.getString("Lieu");
			res.next();
		}
    }
    catch(SQLException e)
    {
    	e.printStackTrace();
    }
		return data;

    }

    /**
     * Cette methode permet d'intialiser les composants de la fenetre et les écouteurs sur ces composants.
     */
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(17, 124, 62, 14);
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setBounds(17, 202, 28, 14);
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setBounds(17, 276, 43, 14);
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setBounds(17, 327, 97, 14);
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setBounds(17, 382, 30, 14);
        textField_1 = new javax.swing.JTextField();
        textField_1.setBounds(135, 125, 265, 20);
        nom_1 = new javax.swing.JTextField();
        nom_1.setBounds(135, 199, 265, 20);
        prenom_1 = new javax.swing.JTextField();
        prenom_1.setBounds(135, 273, 265, 20);
        comboBox_1 = new javax.swing.JComboBox();
        comboBox_1.setBounds(132, 379, 268, 20);
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBounds(27, 557, 1082, 183);
        table_1 = new javax.swing.JTable();
        jour_1 = new javax.swing.JComboBox();
        jour_1.setBounds(132, 324, 44, 20);
        mois_1 = new javax.swing.JComboBox();
        mois_1.setBounds(182, 324, 141, 20);
        annee_1 = new javax.swing.JComboBox();
        annee_1.setBounds(329, 324, 71, 20);
        Fermer_1 = new javax.swing.JButton();
        Fermer_1.setBounds(929, 485, 67, 23);
        jLabel6 = new javax.swing.JLabel();
        jLabel6.setBounds(17, 486, 110, 23);
        jLabel7 = new javax.swing.JLabel();
        jLabel7.setBounds(202, 511, 50, 14);
        textField_3_1 = new javax.swing.JTextField();
        textField_3_1.setBounds(252, 508, 129, 20);
        jLabel8 = new javax.swing.JLabel();
        jLabel8.setBounds(414, 511, 28, 14);
        textField_4_1 = new javax.swing.JTextField();
        textField_4_1.setBounds(452, 508, 159, 20);
        jLabel9 = new javax.swing.JLabel();
        jLabel9.setBounds(642, 511, 43, 14);
        textField_5_1 = new javax.swing.JTextField();
        textField_5_1.setBounds(695, 508, 152, 20);
        Rechercher_1 = new javax.swing.JButton();
        Rechercher_1.setBounds(909, 523, 87, 23);
        jLabel10 = new javax.swing.JLabel();
        jLabel10.setBounds(505, 32, 119, 25);
        jLabel11 = new javax.swing.JLabel();
        jLabel11.setBounds(647, 128, 18, 14);
        UVbox_1 = new javax.swing.JComboBox();
        UVbox_1.setBounds(683, 125, 223, 20);
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane2.setBounds(683, 174, 223, 148);
        list = new javax.swing.JList();
        suppressionduv_1 = new javax.swing.JButton();
        suppressionduv_1.setBounds(732, 333, 115, 23);
        ajout_1 = new javax.swing.JButton();
        ajout_1.setBounds(965, 124, 97, 23);
        modifier_1 = new javax.swing.JButton();
        modifier_1.setBounds(965, 188, 97, 23);
        supprimer_1 = new javax.swing.JButton();
        supprimer_1.setBounds(965, 262, 97, 23);
        reinitialiser_1 = new javax.swing.JButton();
        reinitialiser_1.setBounds(965, 347, 97, 23);
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator4.setBounds(917, 124, 16, 0);
        jLabel13 = new javax.swing.JLabel();
        jLabel13.setBounds(955, 75, 89, 23);


        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
			public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setText("Matricule :");

        jLabel2.setText("Nom :");

        jLabel3.setText("Prenom :");

        jLabel4.setText("Date De Naissance :");

        jLabel5.setText("Pays :");

        table_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Matricule", "Nom", "Prenom", "Date De Naissance", "Pays", "Lieu De Naissance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            @Override
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_1.setRowHeight(28);

        table_1.setPreferredSize(new java.awt.Dimension(750, 1520));
        jScrollPane1.setViewportView(table_1);

        Fermer_1.setText("Fermer");

        jLabel6.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel6.setText("RECHERCHE :");

        jLabel7.setText("Matricule :");

        jLabel8.setText("Nom :");

        jLabel9.setText("Prenom :");

        Rechercher_1.setText("Rechercher");

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel10.setText("INSCRIPTION");

        jLabel11.setText("UVs");

        jScrollPane2.setViewportView(list);

        suppressionduv_1.setText("Suppression D'UV");

        ajout_1.setText("Ajouter +");

        modifier_1.setText("Modifier ~");

        supprimer_1.setText("Suppression -");

        reinitialiser_1.setText("Re-initialiser");

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel13.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel13.setText("Traitements");
        String[] vec_jour = new String[31];
		String[] vec_mois={"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","December"};
		String[] vec_annee = new String[116];
		for(int i=1;i<32;i++)
		{
			vec_jour[i-1]=Integer.toString(i);
		}
		for(int i=1900;i<2015;i++)
		{
			vec_annee[i-1900]=Integer.toString(i);
		}
		for (String element : vec_jour) {
			jour.addItem(element);
		}
		for (String vec_moi : vec_mois) {
			mois.addItem(vec_moi);
		}
		for (String element : vec_annee) {
			annee.addItem(element);
		}
		String[] vec_UV={"","Anglais","Architecture Des Ordinateurs","Base De Données Relationnelles","Fondements De Management","Mathematiques De Base","Outils De Mathematiques","Programmation Orientee Objet","Probabilites et Statistiques","Science De L\'information","Systemes D\'exploitation","Analyse Numerique","Anglais II","Conception De Bases De Données","Management II","Programmation Orientee Objet II","Programmation Systeme","Programmation Web","Systemes Formels","Techniques De Communication"};
		String[] vec_Pays={"Afghanistan"," Afrique du Sud"," Albanie"," Algérie"," Allemagne"," Andorre "," Angola"," Antigua-et-Barbuda ","Arabie saoudite"," Argentine"," Arménie ","Australie"," Autriche"," Azerbaïdjan ","Bahamas ","Bahreïn"," Bangladesh"," Barbade"," Belgique"," Belize"," Bénin"," Bhoutan"," Biélorussie"," Birmanie"," Bolivie ","Bosnie-Herzégovine"," Botswana"," Brésil"," Brunei"," Bulgarie"," Burkina Faso"," Burundi"," Cambodge"," Cameroun"," Canada"," Cap-Vert"," Centrafricaine ","Chili ","Chine"," Chypre"," Colombie"," Comores"," RDCongo"," Congo-Brazzaville"," Corée Du Nord"," Corée du Sud ","Costa Rica","Côte d'Ivoire","Croatie","Cuba","Danemark","Djibouti","Dominique","Égypte","les Émirats arabes unis","Équateur","Érythrée","Espagne","Estonie","États-Unis","Éthiopie","Fidji","Finlande","France","Gabon","Gambie","Géorgie","Ghana","Grèce","Grenade","Guatemala","Guinée","Guinée-Bissau","Guinée équatoriale","Guyana","Haiti","Honduras","Hongrie","Inde","Indonésie","Iraq","Iran","Irlande","Islande","Israël","Italie","Jamaïque","Japon","Jordanie","Kazakhstan","Kenya","Kirghizistan","Kiribati","Koweït","Laos","Lesotho","Lettonie","Liban","Libéria","Libye","Liechtenstein","Lituanie","Luxembourg","Macédoine","Madagascar","Malaisie","Malawi","Maldives","Mali","Malte","Maroc","Marshall","Maurice","Mauritanie","Mexique","Moldavie","Monaco","Mongolie","Monténégro","Mozambique","Namibie","Niger","Nigeria","Republique Centraficain","Tchad"};
		for (String element : vec_UV) {
			this.UVbox.addItem(element);
		}
		for (String vec_Pay : vec_Pays) {
			this.comboBox.addItem(vec_Pay);
		}
		//Les écouteurs sur ces composants
		this.ajout_1.addActionListener(new action());
		this.reinitialiser_1.addActionListener(new action());
		this.Rechercher_1.addActionListener(new action());
		this.suppressionduv_1.addActionListener(new action());
		this.UVbox_1.addActionListener(new action());
		this.modifier_1.addActionListener(new action());
		this.supprimer_1.addActionListener(new action());
		this.Fermer_1.addActionListener(new action());
		this.table_1.addMouseListener(new mouse());
		this.etduv.addMouseListener(new mouse());
		this.javadoc.addMouseListener(new mouse());
		this.aide.addMouseListener(new mouse());
		this.statistiques.addMouseListener(new mouse());

        lblLieuDeNaissance = new JLabel("Lieu De Naissance :");
        lblLieuDeNaissance.setBounds(17, 434, 93, 14);

        lieu = new JTextField();
        lieu.setBounds(132, 431, 268, 20);
        lieu.setColumns(10);

        uvs = new JTextField();
        uvs.setBounds(683, 431, 86, 20);
        uvs.setEditable(false);
        uvs.setColumns(10);

        lblNbreDuvs = new JLabel("Nbre D'UVs :");
        lblNbreDuvs.setBounds(605, 434, 60, 14);

        etds = new JTextField();
        etds.setBounds(27, 536, 86, 20);
        etds.setEditable(false);
        etds.setColumns(10);

        lblRaccourcisPratiques = new JLabel("RACCOURCIS PRATIQUES");
        lblRaccourcisPratiques.setBounds(972, 12, 127, 14);


        etduv.setForeground(Color.RED);

        statistiques.setForeground(Color.RED);


        javadoc.setForeground(Color.RED);


        aide.setForeground(Color.RED);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>
/**
 * Cette methode permet de reinitialiser la valeur du champ de texte etds. Ce champs de texte indique le nombre d'etudiants sur la table.
 *  Il est question de permettre le bon fonctionnement du compteur des etudiant inscrits dans l'institution
 *  @throws SQLException cette methode lance une exception de type SQLException
 */
 public void reinitetd()
 {
try
{
		Statement stmnt = connection.createStatement();
		ResultSet res=stmnt.executeQuery("SELECT * FROM Etudiant");
		int k=0;

		while(res.next())
		{
			k++;
		}
this.etds.setText(Integer.toString(k));

}
catch(SQLException e)
{
	e.printStackTrace();
}
 }


 /**
  * Cette methode permet quant a elle de reinitialiser le champs de texte uvs. Ce champs de texte indique le nombre de uvs choisi
  * par l'utilisateur
  */
 public void reinituvs()
 {
	 this.uvs.setText(Integer.toString(this.vect1.size()));
	 this.revalidate();
 }


 /**
  * Permet de reinitialiser le noms des etudiants inscrit dans le JComboBox
  * @throws SQLException cette methode lance une exception de type SQLException
  */
 public void reinitUVBox()
 {
	 Vector<String> v=new Vector<String>();
	 try{
	 Statement stmt=connection.createStatement();
	 ResultSet res=stmt.executeQuery("SELECT Intitule_UV FROM UV");
	 while(res.next())
	 {
		 v.add(res.getString("Intitule_UV"));
	 }
	 }
	 catch(SQLException e)
	 {
		 e.printStackTrace();
	 }
	 for(int i=0;i<v.size();i++)
	 {
		 this.UVbox.addItem(v.get(i));
	 }
	 this.revalidate();
 }

 /**
  *
  * @param mat :Le matricule de l'etudiant
  * @return retourne le vecteur des UVs de l'etudiant de matriucle mat
  * @throws SQLException cette methode lance une exception de type SQLException
  */
 public Vector<String> reinitUVList(String mat)
 {
	 Vector<String> v=new Vector<String>();
	 try{
	 PreparedStatement stmt=connection.prepareStatement("SELECT UVID FROM EtudiantUV WHERE EtudiantID=?");
	 stmt.setInt(1, this.getEtdID(mat));
	 ResultSet set=stmt.executeQuery();
	 while(set.next())
	 {
		 PreparedStatement p=connection.prepareStatement("SELECT Intitule_UV FROM UV WHERE UVID=?");
		 p.setInt(1, set.getInt("UVID"));////////////////////oihihoi
	 ResultSet set1=stmt.executeQuery();
	 v.add(set1.getString("Intitule_UV"));
	 }
	 }catch(SQLException e)
	 {
		 e.printStackTrace();
	 }
	 this.revalidate();
	 return v;
 }

 /**
  * Permet l'insertion d'un nouveau etudiant dans la base donnees. Donc dans la table Etudiant et dans la table EtudiantUV
  * @throws SQLException cette methode lance une exception de type SQLException
  */
public void InsertionBD(){

		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}

		try{

			String naisances=this.jour_1.getSelectedItem()+" "+this.mois_1.getSelectedItem()+" "+this.annee_1.getSelectedItem();
			Statement stmt = connection.createStatement();
			EtudiantPrime etd=new EtudiantPrime(EtudiantPrime.getIndex(),this.textField_1.getText(),this.nom_1.getText(),this.prenom_1.getText(),naisances,(String)this.comboBox_1.getSelectedItem(),this.lieu.getText());
			EtudiantPrime.setIndex(EtudiantPrime.getIndex()+1);
			this.setIndex(this.getIndex()+1);
			ResultSet set=this.SelectBD(this.getTextField().getText());
			if(set.next())
			{
				JOptionPane.showMessageDialog(this, "Un Etudiant ayant ce matricule existe deja. Veuillez le changer !", "DUPLICATION DE MATRICULE", 1);
			}
			else
			{
			int a=stmt.executeUpdate("INSERT INTO Etudiant(Matricule,Nom,Prenom,Date_Naissance,Pays,Lieu)  VALUES (\""+ this.textField_1.getText()+"\",\""+this.nom_1.getText()+"\",\""+this.prenom_1.getText()+"\",\""+naisances+"\",\""+(String)this.getComboBox().getSelectedItem()+"\",\""+this.getLieu().getText()+"\");");
			int nbre=this.getVect1().size();
			this.reinittab();
			for(int i=0;i<nbre;i++)
			{
				stmt.executeUpdate("INSERT INTO EtudiantUV(EtudiantID,UVID) VALUES("+this.getEtdID(this.getTextField().getText())+","+this.getUVID(this.vect1.get(i))+");");
			this.reinittab();
			}
			}
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.revalidate();
		this.table_1.revalidate();
	}

/**
 * Permet d'obtenir l'identificateur d'un etudiant a partir de son matricule
 * @param mat: Qui est le matricule de l'etudiant
 * @return int: Qui est l'identificateur de l'etudiant
 * @throws SQLException cette methode lance une exception de type SQLException
 */
public static int getEtdID(String mat)
{
	ResultSet s;
	int i=0;
	try
	{
		PreparedStatement stmt=connection.prepareStatement("SELECT EtudiantID FROM Etudiant WHERE Matricule=?");
		stmt.setString(1, mat);
		s=stmt.executeQuery();
		if(s.next())
		{
		i=s.getInt("EtudiantID");
		}
		else
		{
			i=-1;
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return i;
}

/**
 * Cette methode permet l'obtenir l'identificateur du dernier etudiant inscrit
 *@throws SQLException cette methode lance une exception de type SQLException
 * @return int correspondant a l'identificateur du dernier etudiant inscrit
 */
public int getLastEtdID()
{
	ResultSet set;
	int k = 0,id=0;
	try
	{
		Statement stmt = connection.createStatement();
		set=stmt.executeQuery("SELECT * FROM Etudiant");
		set.beforeFirst();
		while(set.next())
		{
			k++;
		}
		id=set.getInt("EtudiantID");
	}
	catch(SQLException f)
	{
		f.printStackTrace();
	}
	return id+1;
}

/**
 * Cette methode permet d'obtenir l'identificateur de l'etudiant dont le nom est donnee en parametre.
 * @param nom
 * @return int: Qui correspond a l'identificateur de l'etudiant dont le nom est passee en parametre
 * @throws SQLException cette methode lance une exception de type SQLException
 *
 *
 */
public static int getUVID(String nom)
{
	ResultSet set;
	int i=0;
	try
	{
	PreparedStatement stmt = connection.prepareStatement("SELECT UVID FROM UV WHERE Intitule_UV= ?");
	stmt.setString(1, nom);
	set=stmt.executeQuery();
	set.next();
	i=set.getInt("UVID");
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return i;
}

/**
 *Cette methode est a but purement orientee code. Elle permet d'inserer un etudiant dans la Table Etudiant de la Base De Donnee avec les differentes informations mise en parametre.
 * @param index correspondant a l'identificateur de l'etudiant
 * @param matricule correspondant au matricule de l'etudiant a inserer
 * @param nom correspondant au nom de l'etudiant a inserer
 * @param prenom correspondant au prenom de l'etudiant a inserer
 * @param nais correspondant au prenom
 * @param pays
 * @param lie
 *
 *  */
public void InsererEtudiant(int index,String matricule,String nom,String prenom,String nais,String pays,String lie)
{
	try
	{
	PreparedStatement s=connection.prepareStatement("INSERT INTO Etudiant(Matricule,Nom,Prenom,Date_Naissance,Pays,Lieu)  VALUES (?,?,?,?,?,?)");
	PreparedStatement s1=connection.prepareStatement("INSERT INTO EtudiantUV(EtudiantID,UVID) VALUES (?,?)");
	s.setString(1, matricule);
	s.setString(2, nom);
	s.setString(3, prenom);
	s.setString(4, nais);
	s.setString(5, pays);
	s.setString(6, lie);
	s1.setInt(1, this.getEtdID(matricule));
	s1.setInt(2, 1);
	ResultSet set=this.SelectBD(matricule);
	if(set.next())
	{
		JOptionPane.showMessageDialog(this, "Un Etudiant ayant ce matricule existe deja. Veuillez le changer !", "DUPLICATION DE MATRICULE", 1);
	}
	else
	{
	int r=s.executeUpdate();
	int a=s1.executeUpdate();
	this.reinitetd();
	}
	this.setIndex(this.getIndex()+1);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
}

/**
 * Permet d'obtenir les informations sur un etudiant de la table Etudiant
 * @param mat Le matricule de l'etudiant en question
 * @return ResultSet des informations
 */
	public ResultSet SelectBD(String mat){
		ResultSet resultats = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		String ur1 = "jdbc:mysql://localhost:3306/ProjetPOO_Adapt";
		String user = "root"; String pass = "martin";
		try{
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Etudiant WHERE Matricule=?");
			stmt.setString(1, mat);
			resultats=stmt.executeQuery();

		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return resultats;
	}

/**
 * Permet la suppression d'un etudiant de la base de donnees.
 * @param mat Le matricule de l'etudiant a supprimer
 * @exception SQLException
 */
	public void suppressionBD(String mat)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			int id=this.getEtdID(mat);
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM EtudiantUV WHERE EtudiantID=?");
		PreparedStatement stmt1 = connection.prepareStatement("DELETE FROM Etudiant WHERE Matricule=?");
		stmt.setInt(1,id );
		stmt.setString(1, mat);
		int b=stmt.executeUpdate();
		int a=stmt1.executeUpdate();
		this.reinittab();
		this.revalidate();
		this.table_1.revalidate();
	    }
		catch (SQLException e)
		{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

/**
 * Permet de modifier les informations d'un etudiant
 * @param index L'identifiacteur de l'etudiant dont on veut modifer
 * @param att L'attribut de l'etudiant que l'on veur modifier
 * @param val La mouvel
 * @throws SQLException
 */
	public void updateBD(int index,String att,String val)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM EtudiantUV WHERE EtudiantID=?");
		PreparedStatement stmt1 = connection.prepareStatement("INSERT INTO EtudiantUV(EtudiantID,UVID) VALUES(?,?)");
		PreparedStatement stmt2 = connection.prepareStatement("UPDATE Etudiant SET ?=? WHERE EtudiantID=?;");
		stmt.setInt(1, index);
		stmt1.setInt(1, this.getEtdID(this.getTextField().getText()));
		stmt1.setInt(2, this.getUVID(this.vect1.get(i)));
		stmt2.setString(1, att);
		stmt2.setString(2, val);
		stmt2.setInt(3, index);
		int b=stmt.executeUpdate();
		for(int i=0;i<this.vect1.size();i++)
		{
			int c=stmt1.executeUpdate();
		}
		int a=stmt2.executeUpdate();
	    this.revalidate();
	    this.table_1.revalidate();
	    }
		catch (SQLException e)
	    {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    }

/**
 * Permet la suppression d'un etudiant a partir de son identificateur
 * @param index
 */
	public void suppressionBD(int index)
	{
		ResultSet resultats = null;
		String mat="";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		String ur1 = "jdbc:mysql://localhost:3306/ProjetPOO_Adapt";
		String user = "root"; String pass = "martin";
		try
		{
			PreparedStatement stmt = connection.prepareStatement("SELECT Matricule FROM Etudiant WHERE EtudiantID=?");
			stmt.setInt(1,index);
			resultats=stmt.executeQuery();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			resultats.beforeFirst();
			mat=resultats.getString("Matricule");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.suppressionBD(mat);
	}

	/**
	 * Permet de mettre a jour le tableauu des etudiants
	 */
	public void reinittab()
	{
		String [][] f=this.element();
		String [] s={"Matricule","Nom","Prenom","Date De Naissance","Pays","Lieu De Naissance"};
		TableModel model = new DefaultTableModel(f,s);
		table_1.setModel(model);
		this.reinitetd();
		this.table_1.revalidate();
	}

/**
 * Permet d'obtenir l'intitule d'une UV a partir de son identificateur
 * @param id
 * @return
 */
	public String getIntituleUV(int id)
	{
		String d="";
		ResultSet s;
		try{
		PreparedStatement stmt=connection.prepareStatement("SELECT Intitule_UV FROM UV WHERE UVID=?");
	    stmt.setInt(1, id);
		s=stmt.executeQuery();
		s.next();
		d=s.getString("Intitule_UV");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return d;
	}

	/**
	 * Permet de vider la different champs du questionnaire.
	 */
	public void reinitchamps()
	{
		this.getTextField().setText("");
		this.getNom().setText("");
		this.getPrenom().setText("");
		this.comboBox_1.setSelectedItem(0);
		this.jour_1.setSelectedItem(0);
		this.mois_1.setSelectedItem(0);
		this.annee_1.setSelectedItem(0);
		this.lieu.setText("");
		ListModel li=new DefaultListModel();
		this.list.setModel(li);
	}

	/**
	 * Est l'ecouteur des composants de la fenetre inscription
	 * @author Zafack Billy
	 *
	 */
class action implements ActionListener{
	@Override
	/**
	 * @see java.awt.ActionListener#actionPerformed
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==supprimer)
		{
			if(JOptionPane.showConfirmDialog(InscriptionPrimeeee.this, "Voulez vous vraiment supprimer l'etudiant "+table_1.getValueAt(table_1.getSelectedRow(),1)+" "+table_1.getValueAt(table_1.getSelectedRow(),2)+" \n.Cette action est IRREVERSIBLE !!","CONFIRMATION DE SUPPRESSION",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,new ImageIcon(".\\pic\\question-64"))==0)
			{
				suppressionBD((String) table_1.getValueAt(table_1.getSelectedRow(),0));
				JOptionPane.showMessageDialog(InscriptionPrimeeee.this, "Etudiant Supprimee avec succes", "SUPPRESSION REUSSIE", JOptionPane.OK_OPTION,new ImageIcon(".\\pic\\4.png"));
				reinittab();
				reinitchamps();
				revalidate();
			}
		}
		if(e.getSource()==ajout)
		{
			int a=0;
			String b="",c="";
			if(textField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(InscriptionPrimeeee.this, "Veuillez Entrer un Matricule", "ABSENCE DE MATRICULE", JOptionPane.WARNING_MESSAGE,new ImageIcon(".\\pic\\warning-64.png"));
			}
			else if(Integer.parseInt((String) jour.getSelectedItem())==29 && Integer.parseInt((String) annee.getSelectedItem())%4!=0&&(String) mois.getSelectedItem()=="Fevrier"||Integer.parseInt((String) jour.getSelectedItem())==31 && (mois.getSelectedItem().equals("Avril")||mois.getSelectedItem().equals("June")||mois.getSelectedItem().equals("Septembre")||mois.getSelectedItem().equals("Novembre"))||(Integer.parseInt((String) jour.getSelectedItem())==30||Integer.parseInt((String) jour.getSelectedItem())==31)&&mois.getSelectedItem().equals("Fevrier"))
			{
				JOptionPane.showMessageDialog(InscriptionPrimeeee.this, "Erreur Dans La Syntaxe De La Date De Naissance", "ERREUR",1);
			}
			else
			{
			String UV="";
			String nais=jour.getSelectedItem()+" "+mois.getSelectedItem()+" "+annee.getSelectedItem();
			EtudiantPrime etd=new EtudiantPrime(getIndex(),textField.getText(),nom.getText(),prenom.getText(),nais,(String)comboBox.getSelectedItem(),lieu.getText());
			setIndex(getIndex()+1);
			b=nom.getText();
			c=prenom.getText();
			if(JOptionPane.showConfirmDialog(null, "Voulez vous vraiment ajouter l'etudiant "+getNom().getText()+" "+getPrenom().getText(), "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,new ImageIcon(".\\pic\\profil-etendu.gif"))==JOptionPane.YES_OPTION)
			{
				a=Integer.parseInt(etds.getText());
			InsertionBD();
			reinitchamps();
			reinittab();
			InscriptionPrimeeee.this.revalidate();
			 JOptionPane.showMessageDialog(null, "L'Etudiant "+b+" "+c+" ajoutee avec succes", "AJOUT AVEC SUCCES", JOptionPane.OK_OPTION,new ImageIcon(".\\pic\\4.png"));
			vect1.removeAllElements();
			}
			}
		}

		if(e.getSource()==UVbox)
		{
			if(!vect1.contains(getUVbox().getSelectedItem()))
			{
			vect1.add((String) UVbox.getSelectedItem());
			}
			list.setListData(vect1);
			reinituvs();
		}

		if(e.getSource()==Fermer)
		{
			if(JOptionPane.showConfirmDialog(InscriptionPrimeeee.this,"Voulez vous vraiment quitter","Confirmation",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			{
				InscriptionPrimeeee.this.setVisible(false);
			}
		}

		if(e.getSource()==suppressionduv)
		{
vect1.removeElement(getList().getSelectedValue());
			list.setListData(vect1);
			reinituvs();
		}

		if(e.getSource()==Rechercher)
		{
			if(!textField_3.getText().equals(""))
			{
				try{
					PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Etudiant WHERE Matricule=?");
					stmt.setString(1, InscriptionPrimeeee.this.getTextField_3().getText());
					ResultSet res=stmt.executeQuery();
					res.next();
					table_1.removeAll();
					String[][] data = new String[1][6];
					data[0][0]=res.getString("Matricule");
					data[0][1]=res.getString("Nom");
					data[0][2]=res.getString("Prenom");
					data[0][3]=res.getString("Date_Naissance");
					data[0][4]=res.getString("Pays");
					data[0][5]=res.getString("Lieu");
					String[] s={"Matricule","Nom","Prenom","Date De Naissance","Pays","Lieu De Naissance"};
					TableModel model=new DefaultTableModel(data,s);
					InscriptionPrimeeee.this.table_1.setModel(model);
					InscriptionPrimeeee.this.revalidate();
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
			else if(!textField_4.getText().equals(""))
			{
				int k=0;
				try{
					PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Etudiant WHERE Nom=?;");
					stmt.setString(1,textField_4.getText());
					ResultSet res=stmt.executeQuery();
					while(res.next())
					{
						k++;
					}
					res.beforeFirst();
					res.next();
					String data[][]=new String[k][6];
					for(int i=0;i<k;i++)
					{
					data[i][0]=res.getString("Matricule");
					data[i][1]=res.getString("Nom");
					data[i][2]=res.getString("Prenom");
					data[i][3]=res.getString("Date_Naissance");
					data[i][4]=res.getString("Pays");
					data[i][5]=res.getString("Lieu");
					res.next();
					}
					String[] s={"Matricule","Nom","Prenom","Date De Naissance","Pays","Lieu De Naissance"};
					TableModel model=new DefaultTableModel(data,s);
					InscriptionPrimeeee.this.table_1.setModel(model);
					InscriptionPrimeeee.this.revalidate();
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}

			else if(!textField_5.getText().equals(""))
			{
				int k=0;
				try{
					PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Etudiant WHERE Prenom=?");
					stmt.setString(1,textField_4.getText());
					ResultSet res=stmt.executeQuery();
					while(res.next())
					{
						k++;
					}
					res.beforeFirst();
					res.next();
					String data[][]= new String[k][6];
					for(int i=0;i<k;i++)
					{
					data[i][0]=res.getString("Matricule");
					data[i][1]=res.getString("Nom");
					data[i][2]=res.getString("Prenom");
					data[i][3]=res.getString("Date_Naissance");
					data[i][4]=res.getString("Pays");
					data[i][5]=res.getString("Lieu");
					res.next();
					}
					String[] s={"Matricule","Nom","Prenom","Date De Naissance","Pays","Lieu De Naissance"};
					TableModel model=new DefaultTableModel(data,s);
					InscriptionPrimeeee.this.table_1.setModel(model);
					InscriptionPrimeeee.this.revalidate();
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		}

		if(e.getSource()==modifier)
		{
			if(JOptionPane.showConfirmDialog(InscriptionPrimeeee.this, "Voulez vous vraiment modifier les informations de cet etudiant?","CONFIRMATION",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			{
			String nais,liste = "";
			nais=jour.getSelectedItem()+" "+mois.getSelectedItem()+" "+annee.getSelectedItem();
			updateBD(getEtdID(getTextField().getText()),"Matricule",getTextField().getText());
			updateBD(getEtdID(getTextField().getText()), "Nom", getNom().getText());
			updateBD(getEtdID(getTextField().getText()), "Prenom",getPrenom().getText());
			updateBD(getEtdID(getTextField().getText()), "Date_Naissance", nais);
			updateBD(getEtdID(getTextField().getText()), "Pays", (String)getComboBox().getSelectedItem());
			updateBD(getEtdID(getTextField().getText()), "Lieu",lieu.getText());
			try
			{
			Statement stmnt = connection.createStatement();
			ResultSet res=stmnt.executeQuery("SELECT * FROM Etudiant;");
			int k=0;
			while(res.next())
			{
				k++;
			}
			res.beforeFirst();
			res.next();
			String data[][]=new String[k][6];
			for(int i=0;i<k;i++)
			{
			data[i][0]=res.getString("Matricule");
			data[i][1]=res.getString("Nom");
			data[i][2]=res.getString("Prenom");
			data[i][3]=res.getString("Date_Naissance");
			data[i][4]=res.getString("Pays");
			data[i][5]=res.getString("Lieu");
			res.next();
			}
			String[] s={"Matricule","Nom","Prenom","Date De Naissance","Pays","Lieu De Naissance"};
			TableModel model=new DefaultTableModel(data,s);
			InscriptionPrimeeee.this.table_1.setModel(model);
			InscriptionPrimeeee.this.revalidate();
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();

		}
			}
			reinitchamps();
			JOptionPane.showMessageDialog(InscriptionPrimeeee.this, "Modification Effectuee", "MODIFICATION", JOptionPane.OK_OPTION);
		}
		if(e.getSource()==reinitialiser)
		{
			reinitchamps();
		}

	}

}

/**
 * Cette classe ecoute les cliques de souris sur le tableau
 * @author Zafack Billy
 *
 */
	class mouse implements MouseListener
	{

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource()==table_1)
		{
			int i=table_1.getSelectedRow();
			String mat=(String) table_1.getModel().getValueAt(i, 0);
			ResultSet resultats=SelectBD(mat);
			System.out.println(mat+"okokoko");
			try
			{
			boolean flag=resultats.next();
			resultats.beforeFirst();
			resultats.next();
			while(flag)
			{
				if(resultats.getString("Matricule").equals(mat))
				{
					flag=false;
				}
				else
				{
					flag= resultats.next();
				}
			}
			resultats.beforeFirst();
			if(resultats.next())
			{
			EtudiantPrime etd=new EtudiantPrime(resultats.getInt("EtudiantID"),resultats.getString("Matricule"),resultats.getString("Nom"),resultats.getString("Prenom"),resultats.getString("Date_Naissance"),resultats.getString("Pays"),resultats.getString("Lieu"));
			nom.setText(etd.getNom());
			textField.setText(etd.getMatricule());
			prenom.setText(etd.getPrenom());
			comboBox.setSelectedItem(etd.getPays());
			lieu.setText(etd.getLieu());
			PreparedStatement stmt=connection.prepareStatement("SELECT UVID FROM EtudiantUV WHERE EtudiantID=?;");
			stmt.setInt(1,getEtdID(mat));
			ResultSet set=stmt.executeQuery();
			DefaultListModel mod=new DefaultListModel();
			while(set.next())
			{
				System.out.println(getIntituleUV(set.getInt("UVID")));
				vect3.add(getIntituleUV(set.getInt("UVID")));
				mod.addElement(getIntituleUV(set.getInt("UVID")));
			}

			list.setModel(mod);
			vect1.removeAllElements();
			vect1=vect3;
			String nais=etd.getNaissance();
			System.out.println("Date_naiss "+nais);
			int k=0,m,l;
			while(nais.charAt(k)!=' ')
			{
				k++;
			}
			String jr,ms,an;
			m=k;
			jr=nais.substring(0, k);
			k++;
			while(nais.charAt(k)!=' ')
			{
				k++;
			}

			ms=nais.substring(m+1, k);
			an=nais.substring(k+1,nais.length());
			jr.replaceAll(" ", "");
			ms.replaceAll(" ", "");
			an.replaceAll(" ", "");
			jour.setSelectedItem(jr);
			mois.setSelectedItem(ms);
			annee.setSelectedItem(an);
			}
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}

		}
		if(e.getSource()==aide)
		{
			JOptionPane.showMessageDialog(InscriptionPrimeeee.this, "Cette Fenetre vous permet d'inscrire un nouveau etudiant\n"+
		"Vous avez les champs Matricule,Date De Naissance,Lieu De Naissance,Pays,Nom et Prenom. Mais le champs Matricule est OBLIGATOIRE et unique\n"+
		"Vous  avez les traitements *Ajouter*,*Modifier*,*Supprimer* et *Re-initialiser*\n"+
		"*Ajouter* vous permet d'ajouter l'etudiant dont vous avez rempli les informations si et seulement si vous avez rensignee le champs Matricule et vous ne l'avez pas dupliquee \n"+
		"*Supprimer* vous permet de supprimer l'etudiant que vous avez selectionnee dans le tableau\n"+
		"*Modifier* vous permet de modifier les informations de l'etudiant que vous avez selectionnee dans le tableau\n"+
		"*Re-initialiser* vous permet de re-initialiser le champs du questionnaire\n"+
		"-Le bouton *Rechercher* vous permet de rechercher un etudiant dans le tableau apres que vous ayez fixee les parametres dans les champs Matricule,Nom et Prenom\n"+
		"-Il y a egalement un tres grand nombre de raccourcis vous permettant d'aller d'une fenetre a l'autre. FAITES en bon usage\n"+
		"-Les UVs sont renseignee a partir d'un combo-box","AIDE CONTEXTUELLE", JOptionPane.OK_OPTION);
		}
if(e.getSource()==statistiques)
{
	int k=0;
	String etd=etds.getText();
	try{
	Statement stmt=connection.createStatement();
	ResultSet r=stmt.executeQuery("SELECT * FROM UV");
	while(r.next())
	{
		k++;
	}
	}
	catch(SQLException s)
	{
		s.printStackTrace();
	}
	JOptionPane.showMessageDialog(InscriptionPrimeeee.this, "STATISTIQUES\n"+
	"- Nombre d'Etudiant Inscrit : "+etd+"\n"+
	"- Nombre D'Unites De Valeurs : "+k,"STATISTIQUES", JOptionPane.OK_OPTION);
}
if(e.getSource()==javadoc)
{

}
if(e.getSource()==etduv)
{
	if(JOptionPane.showConfirmDialog(InscriptionPrimeeee.this, "Etes vous sur de vouloir quitter la fenetre courant?\n TOUTES INFORMATION NON ENREGISTREE SERA PERDU!!", "Confirmation", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION)
	{
	InscriptionPrimeeee.this.setVisible(false);
	InscriptionPrimeeee.this.getParent().setVisible(false);
	new UVPrimee(new WindowPrime(),true).setVisible(true);
	}
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

	class Key implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {
        setVisible(false);
        dispose();
    }

    /**
     * @param args the command line arguments
     */

	public javax.swing.JButton getFermer() {
		return Fermer_1;
	}

	public void setFermer(javax.swing.JButton fermer) {
		Fermer_1 = fermer;
	}

	public javax.swing.JButton getRechercher() {
		return Rechercher_1;
	}

	public void setRechercher(javax.swing.JButton rechercher) {
		Rechercher_1 = rechercher;
	}

	public javax.swing.JComboBox getUVbox() {
		return UVbox_1;
	}

	public void setUVbox(javax.swing.JComboBox uVbox) {
		UVbox_1 = uVbox;
	}

	public javax.swing.JButton getAjout() {
		return ajout_1;
	}

	public void setAjout(javax.swing.JButton ajout) {
		this.ajout_1 = ajout;
	}

	public javax.swing.JComboBox getAnnee() {
		return annee_1;
	}

	public void setAnnee(javax.swing.JComboBox annee) {
		this.annee_1 = annee;
	}

	public javax.swing.JComboBox getComboBox() {
		return comboBox_1;
	}

	public void setComboBox(javax.swing.JComboBox comboBox) {
		this.comboBox_1 = comboBox;
	}

	public javax.swing.JLabel getjLabel1() {
		return jLabel1;
	}

	public void setjLabel1(javax.swing.JLabel jLabel1) {
		this.jLabel1 = jLabel1;
	}

	public javax.swing.JLabel getjLabel10() {
		return jLabel10;
	}

	public void setjLabel10(javax.swing.JLabel jLabel10) {
		this.jLabel10 = jLabel10;
	}

	public javax.swing.JLabel getjLabel11() {
		return jLabel11;
	}

	public void setjLabel11(javax.swing.JLabel jLabel11) {
		this.jLabel11 = jLabel11;
	}

	public javax.swing.JLabel getjLabel13() {
		return jLabel13;
	}

	public void setjLabel13(javax.swing.JLabel jLabel13) {
		this.jLabel13 = jLabel13;
	}

	public javax.swing.JLabel getjLabel2() {
		return jLabel2;
	}

	public void setjLabel2(javax.swing.JLabel jLabel2) {
		this.jLabel2 = jLabel2;
	}

	public javax.swing.JLabel getjLabel3() {
		return jLabel3;
	}

	public void setjLabel3(javax.swing.JLabel jLabel3) {
		this.jLabel3 = jLabel3;
	}

	public javax.swing.JLabel getjLabel4() {
		return jLabel4;
	}

	public void setjLabel4(javax.swing.JLabel jLabel4) {
		this.jLabel4 = jLabel4;
	}

	public javax.swing.JLabel getjLabel5() {
		return jLabel5;
	}

	public void setjLabel5(javax.swing.JLabel jLabel5) {
		this.jLabel5 = jLabel5;
	}

	public javax.swing.JLabel getjLabel6() {
		return jLabel6;
	}

	public void setjLabel6(javax.swing.JLabel jLabel6) {
		this.jLabel6 = jLabel6;
	}

	public javax.swing.JLabel getjLabel7() {
		return jLabel7;
	}

	public void setjLabel7(javax.swing.JLabel jLabel7) {
		this.jLabel7 = jLabel7;
	}

	public javax.swing.JLabel getjLabel8() {
		return jLabel8;
	}

	public void setjLabel8(javax.swing.JLabel jLabel8) {
		this.jLabel8 = jLabel8;
	}

	public javax.swing.JLabel getjLabel9() {
		return jLabel9;
	}

	public void setjLabel9(javax.swing.JLabel jLabel9) {
		this.jLabel9 = jLabel9;
	}

	public javax.swing.JPanel getjPanel1() {
		return jPanel1;
	}

	public void setjPanel1(javax.swing.JPanel jPanel1) {
		this.jPanel1 = jPanel1;
	}

	public javax.swing.JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	public javax.swing.JScrollPane getjScrollPane2() {
		return jScrollPane2;
	}

	public void setjScrollPane2(javax.swing.JScrollPane jScrollPane2) {
		this.jScrollPane2 = jScrollPane2;
	}

	public javax.swing.JSeparator getjSeparator4() {
		return jSeparator4;
	}

	public void setjSeparator4(javax.swing.JSeparator jSeparator4) {
		this.jSeparator4 = jSeparator4;
	}

	public javax.swing.JTable getjTable1() {
		return table_1;
	}

	public void setjTable1(javax.swing.JTable jTable1) {
		this.table_1 = jTable1;
	}

	public javax.swing.JComboBox getJour() {
		return jour_1;
	}

	public void setJour(javax.swing.JComboBox jour) {
		this.jour_1 = jour;
	}

	public javax.swing.JList getList() {
		return list;
	}

	public void setList(javax.swing.JList list) {
		this.list = list;
	}

	public javax.swing.JButton getModifier() {
		return modifier_1;
	}

	public void setModifier(javax.swing.JButton modifier) {
		this.modifier_1 = modifier;
	}

	public javax.swing.JComboBox getMois() {
		return mois_1;
	}

	public void setMois(javax.swing.JComboBox mois) {
		this.mois_1 = mois;
	}

	public javax.swing.JTextField getNom() {
		return nom_1;
	}

	public void setNom(javax.swing.JTextField nom) {
		this.nom_1 = nom;
	}

	public javax.swing.JTextField getPrenom() {
		return prenom_1;
	}

	public void setPrenom(javax.swing.JTextField prenom) {
		this.prenom_1 = prenom;
	}

	public javax.swing.JButton getReinitialiser() {
		return reinitialiser_1;
	}

	public void setReinitialiser(javax.swing.JButton reinitialiser) {
		this.reinitialiser_1 = reinitialiser;
	}

	public javax.swing.JButton getSuppressionduv() {
		return suppressionduv_1;
	}

	public void setSuppressionduv(javax.swing.JButton suppressionduv) {
		this.suppressionduv_1 = suppressionduv;
	}

	public javax.swing.JButton getSupprimer() {
		return supprimer_1;
	}

	public void setSupprimer(javax.swing.JButton supprimer) {
		this.supprimer_1 = supprimer;
	}

	public javax.swing.JTextField getTextField() {
		return textField_1;
	}

	public void setTextField(javax.swing.JTextField textField) {
		this.textField_1 = textField;
	}

	public javax.swing.JTextField getTextField_3() {
		return textField_3_1;
	}

	public void setTextField_3(javax.swing.JTextField textField_3) {
		this.textField_3_1 = textField_3;
	}

	public javax.swing.JTextField getTextField_4() {
		return textField_4_1;
	}

	public void setTextField_4(javax.swing.JTextField textField_4) {
		this.textField_4_1 = textField_4;
	}

	public javax.swing.JTextField getTextField_5() {
		return textField_5_1;
	}

	public void setTextField_5(javax.swing.JTextField textField_5) {
		this.textField_5_1 = textField_5;
	}

	public JLabel getLblListeDesUv() {
		return lblListeDesUv;
	}

	public void setLblListeDesUv(JLabel lblListeDesUv) {
		this.lblListeDesUv = lblListeDesUv;
	}

	public Vector<String> getVect() {
		return vect;
	}

	public void setVect(Vector<String> vect) {
		this.vect = vect;
	}

	public static Vector<String> getVect1() {
		return vect1;
	}

	public void setVect1(Vector<String> vect1) {
		this.vect1 = vect1;
	}

	public Vector<String> getColumn() {
		return column;
	}

	public void setColumn(Vector<String> column) {
		this.column = column;
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		InscriptionPrimeeee.connection = connection;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		InscriptionPrimeeee.index = index;
	}

	public JButton getNouveau() {
		return nouveau;
	}

	public void setNouveau(JButton nouveau) {
		this.nouveau = nouveau;
	}

	public JButton getBtnFermer() {
		return btnFermer;
	}

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		InscriptionPrimeeee.i = i;
	}

	public javax.swing.JTable getTable_1() {
		return table_1;
	}

	public void setTable_1(javax.swing.JTable table_1) {
		this.table_1 = table_1;
	}

	public Vector<String> getVect2() {
		return vect2;
	}

	public void setVect2(Vector<String> vect2) {
		this.vect2 = vect2;
	}

	public Vector<String> getVect3() {
		return vect3;
	}

	public void setVect3(Vector<String> vect3) {
		this.vect3 = vect3;
	}

	public static int getIndexu() {
		return indexu;
	}

	public static void setIndexu(int indexu) {
		InscriptionPrimeeee.indexu = indexu;
	}

	public JLabel getLblLieuDeNaissance() {
		return lblLieuDeNaissance;
	}

	public void setLblLieuDeNaissance(JLabel lblLieuDeNaissance) {
		this.lblLieuDeNaissance = lblLieuDeNaissance;
	}

	public JTextField getLieu() {
		return lieu;
	}

	public void setLieu(JTextField lieu) {
		this.lieu = lieu;
	}

	public JTextField getUvs() {
		return uvs;
	}

	public void setUvs(JTextField uvs) {
		this.uvs = uvs;
	}

	public JLabel getLblNbreDuvs() {
		return lblNbreDuvs;
	}

	public void setLblNbreDuvs(JLabel lblNbreDuvs) {
		this.lblNbreDuvs = lblNbreDuvs;
	}

	public JTextField getEtds() {
		return etds;
	}

	public void setEtds(JTextField etds) {
		this.etds = etds;
	}
}
