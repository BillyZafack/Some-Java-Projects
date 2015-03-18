import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
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
public class InscriptionPm extends java.awt.Dialog {

	   // Variables declaration - do not modify
	/** Bouton fermer*/
    private javax.swing.JButton Fermer_1;
    /** ComboBox des differentes UVs*/
    private javax.swing.JComboBox UVbox_1;
    private javax.swing.JLabel aide;
    private javax.swing.JButton ajout_1;
    /** Permet le choix de l'annee de naissance*/
    private javax.swing.JComboBox annee_1;
    /** Pemet le choix du pays */
    private javax.swing.JComboBox comboBox_1;
    private javax.swing.JLabel etduv;
    private javax.swing.JTextField etds;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    /** Contient le tableau(JTable)*/
    private javax.swing.JScrollPane jScrollPane1;
    /** Contient la JList*/
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField4;
    /** Combo Box permettant de choisir le jour de naissance*/
    private javax.swing.JComboBox jour_1;
    private javax.swing.JLabel lblLieuDeNaissance;
    private javax.swing.JLabel lblNbreDuvs;
    private javax.swing.JTextField lieu;
    /**Liste des UVs Selectionnees*/
    private javax.swing.JList list_1;
    private javax.swing.JButton modifier_1;
    /**Liste de mois*/
    private javax.swing.JComboBox mois_1;
    /** Pour recuperer le nom*/
    private javax.swing.JTextField nom_1;
    /** Pour recuperer le prenom*/
    private javax.swing.JTextField prenom_1;
    /** Pour la recherche*/
    private javax.swing.JButton rechercher;
    private javax.swing.JButton reinitialiser_1;
    private javax.swing.JLabel statistiques;
    private javax.swing.JButton suppressionduv_1;
    private javax.swing.JButton supprimer_1;
    private javax.swing.JTable table_1;
    private javax.swing.JTextField textField_1;
    private javax.swing.JTextField textField_4_1;
    private javax.swing.JTextField textField_5_1;
    private javax.swing.JTextField uvs;
    JLabel javadoc = new JLabel("- Javadoc De cette fenetre");
    private static int index=0;
	private static int indexu=0;
    private Vector<String> vect=new Vector<String>();
    /** Permet la reinitialisation de dla liste des UVs selectionnees*/
    private static Vector<String> vect1=new Vector<String>(); // Vecteur permettant la manipulation du contenue de la JList
    private Vector<String> vect2=new Vector<String>();
    private Vector<String> column=new Vector<String>();
    private Vector<String> vect3=new Vector<String>();

    // End of variables declaration
	/**
     * Cree une nouvelle fiche d'inscription.
     * @param parent qui est le {@link javax.swing.JFrame} qui heberge cette boite de dialog
     * @param modal un boolean qui rend la boite de dialog modal ou pas
     * C'est le constructeur de l'interface de traitement des etudiants
     */
    public InscriptionPm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        TableModel col=table_1.getModel();
		this.reinitUVBox();

		try
		{
		Statement stmnt = WindowPrime.getConnection().createStatement();

		ResultSet res=stmnt.executeQuery("SELECT * FROM Etudiant");
		int k=0;

		while(res.next())
		{
			k++;
		}
		System.out.println("Nombre d'etudiants ds la base"+k);
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
     * Cette classe permet de recuperer les differents etudiants et leurs informations dans un tableau a deux dimension renvoyé a la fin.
     * @return String[][] contenant toute les informations sur les etudiants inscrits
     * Ces informations sont obtenues d'un {@link java.sql.ResultSet}
     */
    public String[][] element()
    {
    	int k=0;
    	String data[][] = null;
    try{
    	Statement stmt= WindowPrime.getConnection().createStatement();
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

        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        suppressionduv_1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        statistiques = new javax.swing.JLabel();
        etduv = new javax.swing.JLabel();
        aide = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        etds = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblLieuDeNaissance = new javax.swing.JLabel();
        textField_1 = new javax.swing.JTextField();
        nom_1 = new javax.swing.JTextField();
        prenom_1 = new javax.swing.JTextField();
        lieu = new javax.swing.JTextField();
        jour_1 = new javax.swing.JComboBox();
        mois_1 = new javax.swing.JComboBox();
        annee_1 = new javax.swing.JComboBox();
        comboBox_1 = new javax.swing.JComboBox();
        UVbox_1 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_1 = new javax.swing.JList();
        lblNbreDuvs = new javax.swing.JLabel();
        uvs = new javax.swing.JTextField();
        ajout_1 = new javax.swing.JButton();
        modifier_1 = new javax.swing.JButton();
        supprimer_1 = new javax.swing.JButton();
        reinitialiser_1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textField_4_1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textField_5_1 = new javax.swing.JTextField();
        Fermer_1 = new javax.swing.JButton();
        rechercher = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jLabel14.setText("Vous voulez acceder a un logiciel qui a acces a une as de donnees securisee. Veuillez vous identifier en tant que proprietaire de cette base de donnees.");

        jLabel13.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel13.setText("Traitements");

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
			public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1099, 759));

        suppressionduv_1.setText("Suppression D'UV");

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel10.setText("INSCRIPTION");

        table_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        table_1.setSize(1099, 90);
        jScrollPane1.setViewportView(table_1);

        jLabel1.setText("Matricule :");

        statistiques.setForeground(new java.awt.Color(255, 51, 51));
        statistiques.setText("- Statistiques");

        etduv.setForeground(new java.awt.Color(255, 51, 51));
        etduv.setText("- Traitement des UVs");

        aide.setForeground(new java.awt.Color(255, 51, 51));
        aide.setText("AIDE CONTEXUELLE");

        jLabel2.setText("Nom :");

        etds.setEditable(false);
        etds.setText("0");

        jLabel3.setText("Prenom :");

        jLabel4.setText("Date De Naissance");

        jLabel5.setText("Pays");

        lblLieuDeNaissance.setText("Lieu De Naissance :");

        jLabel11.setText("UVs :");

        jScrollPane2.setViewportView(list_1);

        lblNbreDuvs.setText("Nbres D'UV :");

        uvs.setEditable(false);
        uvs.setText("0");

        ajout_1.setText("Ajouter+");

        modifier_1.setText("Modifier~");

        supprimer_1.setText("Suppression~");

        reinitialiser_1.setText("Re-initialiser");

        jLabel6.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel6.setText("RECHERCHE :");

        jLabel7.setText("Matricule :");

        jLabel8.setText("Nom :");

        jLabel9.setText("Prenom :");

        Fermer_1.setText("Fermer");

        rechercher.setText("Rechercher");

        jLabel12.setText("RACCOURCIS PRATIQUES");

        jLabel15.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel15.setText("Traitements");
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
			jour_1.addItem(element);
		}
		for (String vec_moi : vec_mois) {
			mois_1.addItem(vec_moi);
		}
		for (String element : vec_annee) {
			annee_1.addItem(element);
		}
		try{
			Statement stmt=WindowPrime.getConnection().createStatement();
			ResultSet fer=stmt.executeQuery("SELECT * FROM UV");
			while(fer.next())
			{
				this.UVbox_1.addItem(fer.getString("Intitule_UV"));
			}
		}
		catch(SQLException u)
		{
			u.printStackTrace();
		}
		String[] vec_UV={"","Anglais","Architecture Des Ordinateurs","Base De Données Relationnelles","Fondements De Management","Mathematiques De Base","Outils De Mathematiques","Programmation Orientee Objet","Probabilites et Statistiques","Science De L\'information","Systemes D\'exploitation","Analyse Numerique","Anglais II","Conception De Bases De Données","Management II","Programmation Orientee Objet II","Programmation Systeme","Programmation Web","Systemes Formels","Techniques De Communication"};
		String[] vec_Pays={"Afghanistan"," Afrique du Sud"," Albanie"," Algérie"," Allemagne"," Andorre "," Angola"," Antigua-et-Barbuda ","Arabie saoudite"," Argentine"," Arménie ","Australie"," Autriche"," Azerbaïdjan ","Bahamas ","Bahreïn"," Bangladesh"," Barbade"," Belgique"," Belize"," Bénin"," Bhoutan"," Biélorussie"," Birmanie"," Bolivie ","Bosnie-Herzégovine"," Botswana"," Brésil"," Brunei"," Bulgarie"," Burkina Faso"," Burundi"," Cambodge"," Cameroun"," Canada"," Cap-Vert"," Centrafricaine ","Chili ","Chine"," Chypre"," Colombie"," Comores"," RDCongo"," Congo-Brazzaville"," Corée Du Nord"," Corée du Sud ","Costa Rica","Côte d'Ivoire","Croatie","Cuba","Danemark","Djibouti","Dominique","Égypte","les Émirats arabes unis","Équateur","Érythrée","Espagne","Estonie","États-Unis","Éthiopie","Fidji","Finlande","France","Gabon","Gambie","Géorgie","Ghana","Grèce","Grenade","Guatemala","Guinée","Guinée-Bissau","Guinée équatoriale","Guyana","Haiti","Honduras","Hongrie","Inde","Indonésie","Iraq","Iran","Irlande","Islande","Israël","Italie","Jamaïque","Japon","Jordanie","Kazakhstan","Kenya","Kirghizistan","Kiribati","Koweït","Laos","Lesotho","Lettonie","Liban","Libéria","Libye","Liechtenstein","Lituanie","Luxembourg","Macédoine","Madagascar","Malaisie","Malawi","Maldives","Mali","Malte","Maroc","Marshall","Maurice","Mauritanie","Mexique","Moldavie","Monaco","Mongolie","Monténégro","Mozambique","Namibie","Niger","Nigeria","Republique Centraficain","Tchad"};

		for (String vec_Pay : vec_Pays) {
			this.comboBox_1.addItem(vec_Pay);
		}
		//Les écouteurs sur ces composants
		this.ajout_1.addActionListener(new action());
		this.reinitialiser_1.addActionListener(new action());
		this.rechercher.addActionListener(new action());
		this.suppressionduv_1.addActionListener(new action());
		this.UVbox_1.addActionListener(new action());
		this.modifier_1.addActionListener(new action());
		this.supprimer_1.addActionListener(new action());
		this.Fermer_1.addActionListener(new action());
		this.table_1.addMouseListener(new mouse());
		this.etduv.addMouseListener(new mouse());
		this.aide.addMouseListener(new mouse());
		this.statistiques.addMouseListener(new mouse());
		this.javadoc.addMouseListener(new mouse());
		this.jTextField4.addKeyListener(new Key());
		this.textField_4_1.addKeyListener(new Key());
		this.textField_5_1.addKeyListener(new Key());

        jLabel16.setFont(new java.awt.Font("Sylfaen", 3, 11)); // NOI18N
        jLabel16.setText("Faire usage des raccourcis(en rouge)");


        javadoc.setForeground(Color.RED);

        javax.swing.GroupLayout gl_jPanel1 = new javax.swing.GroupLayout(jPanel1);
        gl_jPanel1.setHorizontalGroup(
        	gl_jPanel1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel1.createSequentialGroup()
        			.addGap(37)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        						.addComponent(statistiques)
        						.addComponent(etduv)
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addComponent(jLabel3)
        							.addGap(76)
        							.addComponent(prenom_1, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
        						.addComponent(jLabel2)
        						.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING, false)
        							.addGroup(gl_jPanel1.createSequentialGroup()
        								.addComponent(jLabel5)
        								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
        							.addGroup(gl_jPanel1.createSequentialGroup()
        								.addComponent(jLabel4)
        								.addGap(18)
        								.addComponent(jour_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.UNRELATED)
        								.addComponent(mois_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
        								.addGap(18)
        								.addComponent(annee_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
        						.addComponent(jLabel1)
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addGap(125)
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        								.addComponent(nom_1)))
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel16)
        								.addComponent(javadoc))
        							.addGap(213)
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        								.addGroup(gl_jPanel1.createSequentialGroup()
        									.addComponent(jLabel10)
        									.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        										.addGroup(gl_jPanel1.createSequentialGroup()
        											.addGap(390)
        											.addComponent(aide)
        											.addGap(0, 3, Short.MAX_VALUE))
        										.addGroup(Alignment.TRAILING, gl_jPanel1.createSequentialGroup()
        											.addPreferredGap(ComponentPlacement.RELATED)
        											.addComponent(jLabel12)
        											.addGap(12))))
        								.addGroup(gl_jPanel1.createSequentialGroup()
        									.addGap(190)
        									.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
        										.addComponent(Fermer_1)
        										.addGroup(gl_jPanel1.createSequentialGroup()
        											.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
        												.addGroup(gl_jPanel1.createSequentialGroup()
        													.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
        													.addGap(60))
        												.addGroup(gl_jPanel1.createSequentialGroup()
        													.addComponent(suppressionduv_1)
        													.addGap(127)))
        											.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        												.addComponent(ajout_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        												.addComponent(modifier_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        												.addComponent(jLabel15)
        												.addComponent(supprimer_1)
        												.addComponent(reinitialiser_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
        										.addComponent(rechercher))))))
        					.addGap(38))
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addComponent(jLabel6)
        							.addGap(18)
        							.addComponent(jLabel7)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
        							.addGap(47)
        							.addComponent(jLabel8)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(textField_4_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
        							.addGap(75)
        							.addComponent(jLabel9)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(textField_5_1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
        						.addComponent(etds, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1034, GroupLayout.PREFERRED_SIZE)
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
        								.addComponent(jLabel11)
        								.addGroup(gl_jPanel1.createSequentialGroup()
        									.addComponent(lblLieuDeNaissance)
        									.addGap(18)
        									.addComponent(lieu, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
        									.addGap(129)
        									.addComponent(lblNbreDuvs)))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        								.addComponent(uvs, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
        								.addComponent(UVbox_1, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))))
        					.addGap(0, 38, Short.MAX_VALUE))))
        );
        gl_jPanel1.setVerticalGroup(
        	gl_jPanel1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel1.createSequentialGroup()
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addGap(17)
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel10)
        						.addComponent(jLabel16))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(etduv))
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addGap(16)
        					.addComponent(jLabel12)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(aide)))
        			.addGap(12)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addComponent(statistiques)
        					.addGap(17)
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addGap(27)
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        								.addComponent(jLabel1)
        								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(UVbox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel11)))
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addGap(46)
        							.addComponent(ajout_1)))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        								.addComponent(jLabel2)
        								.addComponent(nom_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        							.addGap(32)
        							.addComponent(modifier_1)
        							.addGap(46)
        							.addComponent(supprimer_1)
        							.addGap(103))
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
        								.addGroup(gl_jPanel1.createSequentialGroup()
        									.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        										.addComponent(jLabel3)
        										.addComponent(prenom_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        									.addGap(39)
        									.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        										.addComponent(jLabel4)
        										.addComponent(jour_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        										.addComponent(mois_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        										.addComponent(annee_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        									.addGap(36))
        								.addGroup(gl_jPanel1.createSequentialGroup()
        									.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        									.addGap(2)))
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
        								.addComponent(jLabel5)
        								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        								.addComponent(reinitialiser_1)
        								.addComponent(suppressionduv_1))
        							.addGap(25))))
        				.addComponent(jLabel15))
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblLieuDeNaissance)
        				.addComponent(lieu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNbreDuvs)
        				.addComponent(uvs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(7)
        			.addComponent(Fermer_1)
        			.addGap(18)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel6)
        				.addComponent(jLabel7)
        				.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel8)
        				.addComponent(textField_4_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel9)
        				.addComponent(textField_5_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(rechercher))
        			.addGap(1)
        			.addComponent(etds, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(0)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        			.addGap(300))
        		.addGroup(gl_jPanel1.createSequentialGroup()
        			.addGap(94)
        			.addComponent(javadoc)
        			.addContainerGap(790, Short.MAX_VALUE))
        );
        jPanel1.setLayout(gl_jPanel1);
setResizable(false);
        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {
        setVisible(false);
        dispose();
    }

    /**
     * Cette methode permet de reinitialiser la valeur du champ de texte etds. Ce champs de texte indique le nombre d'etudiants sur la table.
     *  Il est question de permettre le bon fonctionnement du compteur des etudiant inscrits dans l'institution
     *  @throws SQLException cette methode lance une exception de type SQLException
     */
     public void reinitetd()
     {
    try
    {
    		Statement stmnt =  WindowPrime.getConnection().createStatement();
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
    	 Statement stmt= WindowPrime.getConnection().createStatement();
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
    		 this.UVbox_1.addItem(v.get(i));
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
    	 PreparedStatement stmt= WindowPrime.getConnection().prepareStatement("SELECT UVID FROM EtudiantUV WHERE EtudiantID=?");
    	 stmt.setInt(1, this.getEtdID(mat));
    	 ResultSet set=stmt.executeQuery();
    	 while(set.next())
    	 {
    		 PreparedStatement p= WindowPrime.getConnection().prepareStatement("SELECT Intitule_UV FROM UV WHERE UVID=?");
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
    			Statement stmt =  WindowPrime.getConnection().createStatement();
    			EtudiantPrime etd=new EtudiantPrime(EtudiantPrime.getIndex(),this.textField_1.getText(),this.nom_1.getText(),this.prenom_1.getText(),naisances,(String)this.comboBox_1.getSelectedItem(),this.lieu.getText());
    			EtudiantPrime.setIndex(EtudiantPrime.getIndex()+1);
    			ResultSet set=this.SelectBD(this.getTextField_1().getText());
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
    				stmt.executeUpdate("INSERT INTO EtudiantUV(EtudiantID,UVID) VALUES("+this.getEtdID(this.getTextField_1().getText())+","+this.getUVID(this.vect1.get(i))+");");
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
    		PreparedStatement stmt= WindowPrime.getConnection().prepareStatement("SELECT EtudiantID FROM Etudiant WHERE Matricule=?");
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
    		Statement stmt =  WindowPrime.getConnection().createStatement();
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
    	PreparedStatement stmt =  WindowPrime.getConnection().prepareStatement("SELECT UVID FROM UV WHERE Intitule_UV= ?");
    	stmt.setString(1, nom);
    	set=stmt.executeQuery();
    	if(set.next())
    	{
    	i=set.getInt("UVID");
    	}
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
    	PreparedStatement s= WindowPrime.getConnection().prepareStatement("INSERT INTO Etudiant(Matricule,Nom,Prenom,Date_Naissance,Pays,Lieu)  VALUES (?,?,?,?,?,?)");
    	PreparedStatement s1= WindowPrime.getConnection().prepareStatement("INSERT INTO EtudiantUV(EtudiantID,UVID) VALUES (?,?)");
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
    			PreparedStatement stmt =  WindowPrime.getConnection().prepareStatement("SELECT * FROM Etudiant WHERE Matricule=?");
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
    		PreparedStatement stmt =  WindowPrime.getConnection().prepareStatement("DELETE FROM EtudiantUV WHERE EtudiantID=?");
    		PreparedStatement stmt1 =  WindowPrime.getConnection().prepareStatement("DELETE FROM Etudiant WHERE Matricule=?");
    		stmt.setInt(1,id );
    		stmt1.setString(1, mat);
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
    		Statement stmt =  WindowPrime.getConnection().createStatement();
    		Statement stmt1 =  WindowPrime.getConnection().createStatement();
    		Statement stmt2 =  WindowPrime.getConnection().createStatement();
    		int b=stmt.executeUpdate("DELETE FROM EtudiantUV WHERE EtudiantID="+index);
    		for(int i=0;i<this.vect1.size();i++)
    		{
    			int c=stmt1.executeUpdate("INSERT INTO EtudiantUV(EtudiantID,UVID) VALUES(\""+this.getEtdID(this.getTextField_1().getText())+"\",\""+this.getUVID(this.vect1.get(i))+"\");");
    		}
    		int a=stmt2.executeUpdate("UPDATE Etudiant SET "+att+"=\""+val+"\"WHERE EtudiantID="+index);
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
    			PreparedStatement stmt =  WindowPrime.getConnection().prepareStatement("SELECT Matricule FROM Etudiant WHERE EtudiantID=?");
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
    		PreparedStatement stmt= WindowPrime.getConnection().prepareStatement("SELECT Intitule_UV FROM UV WHERE UVID=?");
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
    		this.getTextField_1().setText("");
    		this.getNom().setText("");
    		this.getPrenom().setText("");
    		this.comboBox_1.setSelectedItem(0);
    		this.jour_1.setSelectedItem(0);
    		this.mois_1.setSelectedItem(0);
    		this.annee_1.setSelectedItem(0);
    		this.lieu.setText("");
    		ListModel li=new DefaultListModel();
    		this.list_1.setModel(li);
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
    		if(e.getSource()==supprimer_1)
    		{
    			if(!InscriptionPm.this.getTextField_1().getText().equals(""))

    				{
    				if(JOptionPane.showConfirmDialog(InscriptionPm.this, "Voulez vous vraiment supprimer l'etudiant "+table_1.getValueAt(table_1.getSelectedRow(),1)+" "+table_1.getValueAt(table_1.getSelectedRow(),2)+" \n.Cette action est IRREVERSIBLE !!","CONFIRMATION DE SUPPRESSION",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,new ImageIcon(".\\pic\\question-64"))==0)
    					{
    				suppressionBD((String) table_1.getValueAt(table_1.getSelectedRow(),0));
    				JOptionPane.showMessageDialog(InscriptionPm.this, "Etudiant Supprimee avec succes", "SUPPRESSION REUSSIE", JOptionPane.OK_OPTION,new ImageIcon(".\\pic\\4.png"));
    				reinittab();
    				reinitchamps();
    				revalidate();
    			}
    				}
    			else
    			{
    				JOptionPane.showMessageDialog(InscriptionPm.this, "Vous n'avez pas selectionné d'étudiant","Pas D'Etudiant Selectionné", JOptionPane.ERROR_MESSAGE);
    			}
    		}
    		if(e.getSource()==ajout_1)
    		{
    			int a=0;
    			String b="",c="";
    			if(textField_1.getText().equals(""))
    			{
    				JOptionPane.showMessageDialog(InscriptionPm.this, "Veuillez Entrer un Matricule", "ABSENCE DE MATRICULE", JOptionPane.WARNING_MESSAGE,new ImageIcon(".\\pic\\warning-64.png"));
    			}
    			else if(Integer.parseInt((String) jour_1.getSelectedItem())==29 && Integer.parseInt((String) annee_1.getSelectedItem())%4!=0&&(String) mois_1.getSelectedItem()=="Fevrier"||Integer.parseInt((String) jour_1.getSelectedItem())==31 && (mois_1.getSelectedItem().equals("Avril")||mois_1.getSelectedItem().equals("June")||mois_1.getSelectedItem().equals("Septembre")||mois_1.getSelectedItem().equals("Novembre"))||(Integer.parseInt((String) jour_1.getSelectedItem())==30||Integer.parseInt((String) jour_1.getSelectedItem())==31)&&mois_1.getSelectedItem().equals("Fevrier"))
    			{
    				JOptionPane.showMessageDialog(InscriptionPm.this, "Erreur Dans La Syntaxe De La Date De Naissance", "ERREUR",1);
    			}
    			else
    			{
    			String UV="";
    			String nais=jour_1.getSelectedItem()+" "+mois_1.getSelectedItem()+" "+annee_1.getSelectedItem();
    			EtudiantPrime etd=new EtudiantPrime(getIndex(),textField_1.getText(),nom_1.getText(),prenom_1.getText(),nais,(String)comboBox_1.getSelectedItem(),lieu.getText());
     			b=nom_1.getText();
    			c=prenom_1.getText();
    			if(JOptionPane.showConfirmDialog(null, "Voulez vous vraiment ajouter l'etudiant "+getNom().getText()+" "+getPrenom().getText(), "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,new ImageIcon(".\\pic\\profil-etendu.gif"))==JOptionPane.YES_OPTION)
    			{
    				a=Integer.parseInt(etds.getText());
    			InsertionBD();
    			reinitchamps();
    			reinittab();
    			InscriptionPm.this.revalidate();
    			 JOptionPane.showMessageDialog(null, "L'Etudiant "+b+" "+c+" ajoutee avec succes", "AJOUT AVEC SUCCES", JOptionPane.OK_OPTION,new ImageIcon(".\\pic\\4.png"));
    			vect1.removeAllElements();
    			}
    			}
    		}

    		if(e.getSource()==UVbox_1)
    		{
          if(UVbox_1.getItemCount()==0)
          {
        	  JOptionPane.showMessageDialog(InscriptionPm.this, "Vous n'avez pas cree d'UV", "Pas d'UV cree", JOptionPane.PLAIN_MESSAGE);
          }
    			if(!vect1.contains(getUVbox().getSelectedItem()))
    			{
    			vect1.add((String) UVbox_1.getSelectedItem());
    			}
    			list_1.setListData(vect1);
    			reinituvs();
    		}

    		if(e.getSource()==Fermer_1)
    		{
    			if(JOptionPane.showConfirmDialog(InscriptionPm.this,"Voulez vous vraiment quitter","Confirmation",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
    			{
    				InscriptionPm.this.setVisible(false);
    			}
    		}

    		if(e.getSource()==suppressionduv_1)
    		{
    vect1.removeElement(getList().getSelectedValue());
    			list_1.setListData(vect1);
    			reinituvs();
    		}

    		if(e.getSource()==rechercher)
    		{
    			if(!jTextField4.getText().equals(""))
    			{
    				try{
    					PreparedStatement stmt =  WindowPrime.getConnection().prepareStatement("SELECT * FROM Etudiant WHERE Matricule=?");
    					stmt.setString(1, InscriptionPm.this.getjTextField4().getText());
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
    					InscriptionPm.this.table_1.setModel(model);
    					reinitetd();
    					InscriptionPm.this.revalidate();
    				}
    				catch(SQLException e1)
    				{
    					e1.printStackTrace();
    				}
    			}
    			else if(!textField_4_1.getText().equals(""))
    			{
    				int k=0;
    				try{
    					PreparedStatement stmt =  WindowPrime.getConnection().prepareStatement("SELECT * FROM Etudiant WHERE Nom=?;");
    					stmt.setString(1,textField_4_1.getText());
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
    					InscriptionPm.this.table_1.setModel(model);
    					reinitetd();
    					InscriptionPm.this.revalidate();
    				}
    				catch(SQLException e1)
    				{
    					e1.printStackTrace();
    				}
    			}

    			else if(!textField_5_1.getText().equals(""))
    			{
    				int k=0;
    				try{
    					PreparedStatement stmt =  WindowPrime.getConnection().prepareStatement("SELECT * FROM Etudiant WHERE Prenom=?");
    					stmt.setString(1,textField_5_1.getText());
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
    					InscriptionPm.this.table_1.setModel(model);
    					InscriptionPm.this.revalidate();
    					reinitetd();
    				}
    				catch(SQLException e1)
    				{
    					e1.printStackTrace();
    				}
    			}
    			else if(textField_5_1.getText().equals("")&&textField_4_1.getText().equals("")&&jTextField4.getText().equals(""))
    			{
    				reinittab();
    				reinitetd();
    				table_1.revalidate();
    				revalidate();
    			}
    		}

    		if(e.getSource()==modifier_1)
    		{
    			if(!InscriptionPm.this.getTextField_1().getText().equals(""))
    			{
    			if(JOptionPane.showConfirmDialog(InscriptionPm.this, "Voulez vous vraiment modifier les informations de cet etudiant?","CONFIRMATION",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
    			{
    			String nais,liste = "";
    			nais=jour_1.getSelectedItem()+" "+mois_1.getSelectedItem()+" "+annee_1.getSelectedItem();
    			updateBD(getEtdID(getTextField_1().getText()),"Matricule",getTextField_1().getText());
    			updateBD(getEtdID(getTextField_1().getText()), "Nom", getNom().getText());
    			updateBD(getEtdID(getTextField_1().getText()), "Prenom",getPrenom().getText());
    			updateBD(getEtdID(getTextField_1().getText()), "Date_Naissance", nais);
    			updateBD(getEtdID(getTextField_1().getText()), "Pays", (String)getComboBox().getSelectedItem());
    			updateBD(getEtdID(getTextField_1().getText()), "Lieu",lieu.getText());
    			try
    			{
    			Statement stmnt =  WindowPrime.getConnection().createStatement();
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
    			InscriptionPm.this.table_1.setModel(model);
    			InscriptionPm.this.revalidate();
    			}
    			catch(SQLException e1)
    			{
    				e1.printStackTrace();

    		}
    			}
    			reinitchamps();
    			JOptionPane.showMessageDialog(InscriptionPm.this, "Modification Effectuee", "MODIFICATION", JOptionPane.OK_OPTION);
    		}

    		else
    		{
    			JOptionPane.showMessageDialog(InscriptionPm.this, "Veuillez Renseigner Le Champs Matricule !!", "ENTREZ UN MATRICULE", JOptionPane.WARNING_MESSAGE);
    		}
    		}
    		if(e.getSource()==reinitialiser_1)
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
    			nom_1.setText(etd.getNom());
    			textField_1.setText(etd.getMatricule());
    			prenom_1.setText(etd.getPrenom());
    			comboBox_1.setSelectedItem(etd.getPays());
    			lieu.setText(etd.getLieu());
    			PreparedStatement stmt= WindowPrime.getConnection().prepareStatement("SELECT UVID FROM EtudiantUV WHERE EtudiantID=?;");
    			stmt.setInt(1,getEtdID(mat));
    			ResultSet set=stmt.executeQuery();
    			DefaultListModel mod=new DefaultListModel();
    			while(set.next())
    			{
    				System.out.println(getIntituleUV(set.getInt("UVID")));
    				vect3.add(getIntituleUV(set.getInt("UVID")));
    				mod.addElement(getIntituleUV(set.getInt("UVID")));
    			}

    			list_1.setModel(mod);
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
    			jour_1.setSelectedItem(jr);
    			mois_1.setSelectedItem(ms);
    			annee_1.setSelectedItem(an);
    			}
    		}catch(SQLException e1)
    		{
    			e1.printStackTrace();
    		}

    		}
    		if(e.getSource()==aide)
    		{
    			JOptionPane.showMessageDialog(InscriptionPm.this, "Cette Fenetre vous permet d'inscrire un nouveau etudiant\n"+
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
    	Statement stmt= WindowPrime.getConnection().createStatement();
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
    	JOptionPane.showMessageDialog(InscriptionPm.this, "STATISTIQUES\n"+
    	"- Nombre d'Etudiant Inscrit : "+etd+"\n"+
    	"- Nombre D'Unites De Valeurs : "+k,"STATISTIQUES", JOptionPane.OK_OPTION);
    }
    if(e.getSource()==javadoc)
    {
File f=new File(".\\doc.InscriptionPm.html");
try{
	Desktop.getDesktop().open(f);
}
catch(IOException ew)
{
	ew.printStackTrace();
	JOptionPane.showMessageDialog(InscriptionPm.this, "Erreur dans l'acces au fichier de documentation de la JAVADOC", "ERREUR", JOptionPane.PLAIN_MESSAGE);
}
    }
    if(e.getSource()==etduv)
    {
    	if(JOptionPane.showConfirmDialog(InscriptionPm.this, "Etes vous sur de vouloir quitter la fenetre courant?\n TOUTES INFORMATION NON ENREGISTREE SERA PERDU!!", "Confirmation", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION)
    	{
    	InscriptionPm.this.setVisible(false);
    	InscriptionPm.this.getParent().setVisible(false);
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
    		public void keyPressed(KeyEvent e) {
    			// TODO Auto-generated method stub
    			System.out.println("RRRRRRRRRRRRRRRRRRRRRREEEEEEEEEEEEERRRRRRRRRRR");
if("qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM\'!@#$%^&*())1234567890[]{}_-=+,./?><{}|".contains(""+e.getKeyChar()))
		{
	System.out.println(e.getKeyChar());
	if(e.getSource()==InscriptionPm.this.jTextField4)
	{
		try{
			Statement stmt =  WindowPrime.getConnection().createStatement();
			ResultSet res=stmt.executeQuery("SELECT * FROM Etudiant WHERE Matricule LIKE '"+ InscriptionPm.this.getjTextField4().getText()+"%';");
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
			InscriptionPm.this.table_1.setModel(model);
			reinitetd();
			InscriptionPm.this.revalidate();
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}

	}
	if(e.getSource()==InscriptionPm.this.textField_4_1)
	{
		int k=0;
		try{
			Statement stmt =  WindowPrime.getConnection().createStatement();
			ResultSet res=stmt.executeQuery("SELECT * FROM Etudiant WHERE Nom LIKE '"+textField_4_1.getText()+"%';");
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
			InscriptionPm.this.table_1.setModel(model);
			reinitetd();
			InscriptionPm.this.revalidate();
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	}
	if(e.getSource()==InscriptionPm.this.getTextField_5())
	{
		int k=0;
		try{
			Statement stmt =  WindowPrime.getConnection().createStatement();
			ResultSet res=stmt.executeQuery("SELECT * FROM Etudiant WHERE Prenom LIKE '"+textField_5_1.getText()+"%'");
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
			InscriptionPm.this.table_1.setModel(model);
			InscriptionPm.this.revalidate();
			reinitetd();
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	}
		}
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

		public javax.swing.JButton getFermer_1() {
			return Fermer_1;
		}
		public void setFermer_1(javax.swing.JButton fermer_1) {
			Fermer_1 = fermer_1;
		}
		public javax.swing.JComboBox getUVbox() {
			return UVbox_1;
		}
		public void setUVbox(javax.swing.JComboBox uVbox_1) {
			UVbox_1 = uVbox_1;
		}
		public javax.swing.JLabel getAide() {
			return aide;
		}
		public void setAide(javax.swing.JLabel aide) {
			this.aide = aide;
		}
		public javax.swing.JButton getAjout() {
			return ajout_1;
		}
		public void setAjout(javax.swing.JButton ajout_1) {
			this.ajout_1 = ajout_1;
		}
		public javax.swing.JComboBox getAnnee() {
			return annee_1;
		}
		public void setAnnee(javax.swing.JComboBox annee_1) {
			this.annee_1 = annee_1;
		}
		public javax.swing.JComboBox getComboBox() {
			return comboBox_1;
		}
		public void setComboBox(javax.swing.JComboBox comboBox_1) {
			this.comboBox_1 = comboBox_1;
		}
		public javax.swing.JLabel getEtduv() {
			return etduv;
		}
		public void setEtduv(javax.swing.JLabel etduv) {
			this.etduv = etduv;
		}
		public javax.swing.JTextField getEtds() {
			return etds;
		}
		public void setEtds(javax.swing.JTextField etds) {
			this.etds = etds;
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
		public javax.swing.JLabel getjLabel12() {
			return jLabel12;
		}
		public void setjLabel12(javax.swing.JLabel jLabel12) {
			this.jLabel12 = jLabel12;
		}
		public javax.swing.JLabel getjLabel13() {
			return jLabel13;
		}
		public void setjLabel13(javax.swing.JLabel jLabel13) {
			this.jLabel13 = jLabel13;
		}
		public javax.swing.JLabel getjLabel14() {
			return jLabel14;
		}
		public void setjLabel14(javax.swing.JLabel jLabel14) {
			this.jLabel14 = jLabel14;
		}
		public javax.swing.JLabel getjLabel15() {
			return jLabel15;
		}
		public void setjLabel15(javax.swing.JLabel jLabel15) {
			this.jLabel15 = jLabel15;
		}
		public javax.swing.JLabel getjLabel16() {
			return jLabel16;
		}
		public void setjLabel16(javax.swing.JLabel jLabel16) {
			this.jLabel16 = jLabel16;
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
		public javax.swing.JTextField getjTextField4() {
			return jTextField4;
		}
		public void setjTextField4(javax.swing.JTextField jTextField4) {
			this.jTextField4 = jTextField4;
		}
		public javax.swing.JComboBox getJour() {
			return jour_1;
		}
		public void setJour(javax.swing.JComboBox jour_1) {
			this.jour_1 = jour_1;
		}
		public javax.swing.JLabel getLblLieuDeNaissance() {
			return lblLieuDeNaissance;
		}
		public void setLblLieuDeNaissance(javax.swing.JLabel lblLieuDeNaissance) {
			this.lblLieuDeNaissance = lblLieuDeNaissance;
		}
		public javax.swing.JLabel getLblNbreDuvs() {
			return lblNbreDuvs;
		}
		public void setLblNbreDuvs(javax.swing.JLabel lblNbreDuvs) {
			this.lblNbreDuvs = lblNbreDuvs;
		}
		public javax.swing.JTextField getLieu() {
			return lieu;
		}
		public void setLieu(javax.swing.JTextField lieu) {
			this.lieu = lieu;
		}
		public javax.swing.JList getList() {
			return list_1;
		}
		public void setList(javax.swing.JList list_1) {
			this.list_1 = list_1;
		}
		public javax.swing.JButton getModifier() {
			return modifier_1;
		}
		public void setModifier(javax.swing.JButton modifier_1) {
			this.modifier_1 = modifier_1;
		}
		public javax.swing.JComboBox getMois() {
			return mois_1;
		}
		public void setMois(javax.swing.JComboBox mois_1) {
			this.mois_1 = mois_1;
		}
		public javax.swing.JTextField getNom() {
			return nom_1;
		}
		public void setNom(javax.swing.JTextField nom_1) {
			this.nom_1 = nom_1;
		}
		public javax.swing.JTextField getPrenom() {
			return prenom_1;
		}
		public void setPrenom(javax.swing.JTextField prenom_1) {
			this.prenom_1 = prenom_1;
		}
		public javax.swing.JButton getRechercher() {
			return rechercher;
		}
		public void setRechercher(javax.swing.JButton rechercher) {
			this.rechercher = rechercher;
		}
		public javax.swing.JButton getReinitialiser() {
			return reinitialiser_1;
		}
		public void setReinitialiser_1(javax.swing.JButton reinitialiser_1) {
			this.reinitialiser_1 = reinitialiser_1;
		}
		public javax.swing.JLabel getStatistiques() {
			return statistiques;
		}
		public void setStatistiques(javax.swing.JLabel statistiques) {
			this.statistiques = statistiques;
		}
		public javax.swing.JButton getSuppressionduv() {
			return suppressionduv_1;
		}
		public void setSuppressionduv(javax.swing.JButton suppressionduv_1) {
			this.suppressionduv_1 = suppressionduv_1;
		}
		public javax.swing.JButton getSupprimer() {
			return supprimer_1;
		}
		public void setSupprimer(javax.swing.JButton supprimer_1) {
			this.supprimer_1 = supprimer_1;
		}
		public javax.swing.JTable getTable_1() {
			return table_1;
		}
		public void setTable_1(javax.swing.JTable table_1) {
			this.table_1 = table_1;
		}
		public javax.swing.JTextField getTextField_1() {
			return textField_1;
		}
		public void setTextField_1(javax.swing.JTextField textField_1) {
			this.textField_1 = textField_1;
		}
		public javax.swing.JTextField getTextField_4() {
			return textField_4_1;
		}
		public void setTextField_4(javax.swing.JTextField textField_4_1) {
			this.textField_4_1 = textField_4_1;
		}
		public javax.swing.JTextField getTextField_5() {
			return textField_5_1;
		}
		public void setTextField_5(javax.swing.JTextField textField_5_1) {
			this.textField_5_1 = textField_5_1;
		}
		public javax.swing.JTextField getUvs() {
			return uvs;
		}
		public void setUvs(javax.swing.JTextField uvs) {
			this.uvs = uvs;
		}
		public static int getIndex() {
			return index;
		}

		public static int getIndexu() {
			return indexu;
		}
		public static void setIndexu(int indexu) {
			InscriptionPm.indexu = indexu;
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
		public static void setVect1(Vector<String> vect1) {
			InscriptionPm.vect1 = vect1;
		}
		public Vector<String> getVect2() {
			return vect2;
		}
		public void setVect2(Vector<String> vect2) {
			this.vect2 = vect2;
		}
		public Vector<String> getColumn() {
			return column;
		}
		public void setColumn(Vector<String> column) {
			this.column = column;
		}
		public Vector<String> getVect3() {
			return vect3;
		}
		public void setVect3(Vector<String> vect3) {
			this.vect3 = vect3;
		}
		public static Connection getConnection() {
			return  WindowPrime.getConnection();
		}
		public static void setConnection(Connection connection) {
			WindowPrime.setConnection(connection);
		}
}
