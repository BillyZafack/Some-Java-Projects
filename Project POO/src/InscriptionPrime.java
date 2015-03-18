import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;

import org.freixas.jcalendar.JCalendarCombo;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class InscriptionPrime extends JDialog implements ActionListener,MouseListener {
	private JTextField textField=new JTextField();
	private JTextField nom=new JTextField();
	private JTextField prenom=new JTextField();
	private JCalendarCombo Naissance=new JCalendarCombo();
	private JTable table=new JTable();
	private JTable table_1=new JTable();
	private JTextField textField_3=new JTextField();
	private JTextField textField_4=new JTextField();
	private JTextField textField_5=new JTextField();
	private JComboBox comboBox = new JComboBox();
	private JComboBox UVbox = new JComboBox();
	JScrollPane jScrollPane1=new JScrollPane();
	private JList list = new JList();
	private static int i=1;
    private	JButton ajout = new JButton("Ajout +");
	private JButton modifier = new JButton("Modifier ~");
	private JButton suppression = new JButton("Suppression -");
	private JButton Initialiser = new JButton("Initialiser");
	private JButton suppressionduv = new JButton("Suppression D'UV -");
	private JButton Rechercher = new JButton("Rechercher");
	private JButton nouveau = new JButton("Nouveau Etudiant");
	private JComboBox jour = new JComboBox();
	private JComboBox mois = new JComboBox();
	private JComboBox annee = new JComboBox();
	private JLabel lblListeDesUv = new JLabel("Liste Des UV");
	Vector<String> vect=new Vector<String>();
	Vector<String> vect1=new Vector<String>();
	Vector<String> column=new Vector<String>();
	private static Connection connection= null;
	private final JButton btnFermer = new JButton("Fermer");
	private static int index=0;
	
	
	
	
	
	public InscriptionPrime(JFrame J) {
	
		super(J);
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		this.setModal(true);
		String ur1 = "jdbc:mysql://localhost:3306/ProjetPOO_Adapt";
		String user = "root"; String pass = "martin";
		try {
			connection = DriverManager.getConnection(ur1, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSize(new Dimension(1154, 770));
		column.add("Matricule");
		column.add("Nom");
		column.add("Prenom");
		column.add("Date De Naissance");
		column.add("Pays");
		column.add("Liste D'UV");
	    	Naissance.setSize(10, 10);
	    	Naissance.setLocation(10, 10);
	    	Naissance.setVisible(true);
	    	this.getContentPane().add(Naissance);
		JLabel lblInscription = new JLabel("INSCRIPTION");
		lblInscription.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		
		JLabel lblMatricule = new JLabel("Matricule :");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		
		JLabel lblNom = new JLabel("Nom :");
		
		nom = new JTextField();
		nom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		
		prenom = new JTextField();
		prenom.setColumns(10);
		
		JLabel lblDateDeNaissance = new JLabel("Date De Naissance :");
		
		JLabel lblNewLabel = new JLabel("Pays\r\n");
			
		table = new JTable();

table_1 = new javax.swing.JTable();

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
        "Matricule", "Nom", "Prenom", "Date De Naissance", "Pays", "Liste D'UVs"
    }
) {
    Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
    };
    boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false
    };

    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }
});

table_1.setPreferredSize(new java.awt.Dimension(750, 520));

jScrollPane1.setViewportView(table_1);

		int[] vec_jour = new int[31];
		String[] vec_mois={"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","December"};
		int[] vec_annee = new int[116];
		for(int i=1;i<32;i++)
		{
			vec_jour[i-1]=i;
		}
		for(int i=1900;i<2015;i++)
		{
			vec_annee[i-1900]=i;
		}
		for(int i=0;i<vec_jour.length;i++)
		{
			jour.addItem(vec_jour[i]);
		}
		for(int i=0;i<vec_mois.length;i++)
		{
			mois.addItem(vec_mois[i]);
		}for(int i=0;i<vec_annee.length;i++)
		{
			annee.addItem(vec_annee[i]);
		}
		String[] vec_UV={"","Anglais","Architecture Des Ordinateurs","Base De Données Relationnelles","Fondements De Management","Mathematiques De Base","Outils De Mathematiques","Programmation Orientee Objet","Probabilites et Statistiques","Science De L\'information","Systemes D\'exploitation","Analyse Numerique","Anglais II","Conception De Bases De Données","Management II","Programmation Orientee Objet II","Programmation Systeme","Programmation Web","Systemes Formels","Techniques De Communication"};
		String[] vec_Pays={"Afghanistan"," Afrique du Sud"," Albanie"," Algérie"," Allemagne"," Andorre "," Angola"," Antigua-et-Barbuda ","Arabie saoudite"," Argentine"," Arménie ","Australie"," Autriche"," Azerbaïdjan ","Bahamas ","Bahreïn"," Bangladesh"," Barbade"," Belgique"," Belize"," Bénin"," Bhoutan"," Biélorussie"," Birmanie"," Bolivie ","Bosnie-Herzégovine"," Botswana"," Brésil"," Brunei"," Bulgarie"," Burkina Faso"," Burundi"," Cambodge"," Cameroun"," Canada"," Cap-Vert"," Centrafricaine ","Chili ","Chine"," Chypre"," Colombie"," Comores"," RDCongo"," Congo-Brazzaville"," Corée Du Nord"," Corée du Sud ","Costa Rica","Côte d'Ivoire","Croatie","Cuba","Danemark","Djibouti","Dominique","Égypte","les Émirats arabes unis","Équateur","Érythrée","Espagne","Estonie","États-Unis","Éthiopie","Fidji","Finlande","France","Gabon","Gambie","Géorgie","Ghana","Grèce","Grenade","Guatemala","Guinée","Guinée-Bissau","Guinée équatoriale","Guyana","Haiti","Honduras","Hongrie","Inde","Indonésie","Iraq","Iran","Irlande","Islande","Israël","Italie","Jamaïque","Japon","Jordanie","Kazakhstan","Kenya","Kirghizistan","Kiribati","Koweït","Laos","Lesotho","Lettonie","Liban","Libéria","Libye","Liechtenstein","Lituanie","Luxembourg","Macédoine","Madagascar","Malaisie","Malawi","Maldives","Mali","Malte","Maroc","Marshall","Maurice","Mauritanie","Mexique","Moldavie","Monaco","Mongolie","Monténégro","Mozambique","Namibie","Niger","Nigeria","Republique Centraficain","Tchad"};
		for(int i=0;i<vec_UV.length;i++)
		{
			this.UVbox.addItem(vec_UV[i]);
		}
		for(int i=0;i<vec_Pays.length;i++)
		{
			this.comboBox.addItem(vec_Pays[i]);
		}
		
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matricule", "Nom", "Prenom", "Date De Naissance", "Pays", "Liste D'UVs"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Object.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(98);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(117);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(111);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(131);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(104);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(135);
		table_1.setColumnSelectionAllowed(true);
		
		JLabel lblNewLabel_1 = new JLabel("Matricule :");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblRecherche = new JLabel("RECHERCHE :");
		lblRecherche.setFont(new Font("Papyrus", Font.BOLD, 9));
		
		JLabel lblNom_1 = new JLabel("Nom :");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblPrenom_1 = new JLabel("Prenom :");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(451)
							.addComponent(lblInscription)
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRecherche)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 811, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblMatricule)
											.addComponent(lblNom)
											.addComponent(lblPrenom)
											.addComponent(lblNewLabel)
											.addComponent(lblNewLabel_1))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
												.addGap(15)
												.addComponent(lblNom_1)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(55)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
													.addComponent(textField, Alignment.TRAILING)
													.addComponent(nom)
													.addComponent(prenom)
													.addComponent(comboBox, 0, 225, Short.MAX_VALUE))))
										.addGap(23)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(nouveau)
												.addGap(43)
												.addComponent(lblListeDesUv)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(list, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
													.addComponent(UVbox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblPrenom_1)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
												.addGap(48)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(suppressionduv)
													.addComponent(Rechercher))))
										.addGap(172))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblDateDeNaissance)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(jour, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(mois, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(annee, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))))
					.addGap(258)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ajout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(suppression, 0, 0, Short.MAX_VALUE)
						.addComponent(modifier, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
						.addComponent(Initialiser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(497)
					.addComponent(btnFermer)
					.addContainerGap(574, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(62, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblInscription)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMatricule)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(nouveau)
								.addComponent(ajout)
								.addComponent(lblListeDesUv)
								.addComponent(UVbox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(37)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNom)
												.addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(36)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblPrenom)
												.addComponent(prenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(39)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblDateDeNaissance)
												.addComponent(jour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(mois, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(annee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(34)
											.addComponent(modifier)
											.addGap(34)
											.addComponent(suppression)
											.addGap(18)
											.addComponent(Initialiser)))
									.addGap(26)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(20)
									.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(list, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(suppressionduv)))
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNom_1)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrenom_1)
								.addComponent(lblNewLabel_1)
								.addComponent(Rechercher)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblRecherche)
							.addGap(34)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(btnFermer)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		this.textField.setEditable(false);
		this.nom.setEditable(false);
		this.prenom.setEditable(false);
		this.comboBox.setEditable(false);
		this.UVbox.setEditable(false);
		this.list.setEnabled(false);
		this.ajout.addActionListener(this);
		this.Initialiser.addActionListener(this);
		this.Rechercher.addActionListener(this);
		this.suppressionduv.addActionListener(this);
		this.modifier.addActionListener(this);
		this.nouveau.addActionListener(this);
		this.suppression.addActionListener(this);
		this.table_1.addMouseListener(this);
	}
	public void InsertionBD(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		try{
			String naisances=this.jour.getSelectedItem()+" "+this.mois.getSelectedItem()+" "+this.annee.getSelectedItem();
			String UV="";
			for(int i=0;i<this.vect1.size();i++)
			{
				UV=UV+"|"+this.vect1.get(i);
			}
			
			Statement stmt = connection.createStatement();
			EtudiantPrime etd=new EtudiantPrime(EtudiantPrime.getIndex(),this.textField.getText(),this.nom.getText(),this.prenom.getText(),naisances,(String)this.comboBox.getSelectedItem(),UV);
			EtudiantPrime.setIndex(EtudiantPrime.getIndex()+1);
			this.setIndex(this.getIndex()+1);
			int a=stmt.executeUpdate("INSERT INTO Etudiant VALUES '"+this.index+"','"+this.textField.getText()+"','"+this.nom.getText()+"','"+this.prenom.getText()+"','"+naisances+"','"+(String)this.comboBox.getSelectedItem()+"','"+UV+"';");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
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
			Statement stmt = connection.createStatement();
			resultats=stmt.executeQuery("SELECT * FROM Etudiant;");
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return resultats;
	}
	
	public void suppressionBD(String mat)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
		Statement stmt = connection.createStatement();
		int a=stmt.executeUpdate("DELETE FROM Etudiant WHERE Matricule='"+mat+"';");
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void updateBD(int index,String att,String val)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
		Statement stmt = connection.createStatement();
		int a=stmt.executeUpdate("UPDATE Etudiant SET "+att+"='"+val+"' WHERE EtudiantID="+index+";");
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void suppressionBD(int index)
	{
		ResultSet resultats = null;
		String mat="";
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		String ur1 = "jdbc:mysql://localhost:3306/ProjetPOO_Adapt";
		String user = "root"; String pass = "martin";
		try{
			Statement stmt = connection.createStatement();
			resultats=stmt.executeQuery("SELECT Matricule FROM Etudiant WHERE EtudiantID="+index+";");
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		try {
			mat=resultats.getString("Matricule");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.suppressionBD(mat);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==nouveau)
		{
			this.textField.setEditable(true);
			this.nom.setEditable(true);
			this.prenom.setEditable(true);
			this.comboBox.setEditable(true);
			this.UVbox.setEditable(true);
			this.textField_4.setEditable(true);
			this.textField_5.setEditable(true);
			this.list.setEnabled(true);
		}
		if(e.getSource()==ajout)
		{
			if(this.textField.getText()=="")
			{
				JOptionPane.showMessageDialog(this, "Veuillez Entrer un Matricule", "ABSENCE DE MATRICULE", HIDE_ON_CLOSE);
			}
			else if(((int)this.jour.getSelectedItem()==29 && (int)this.annee.getSelectedItem()%4!=0)||((int)this.jour.getSelectedItem()==31 && (this.mois.getSelectedItem().equals("Avril")||this.mois.getSelectedItem().equals("June")||this.mois.getSelectedItem().equals("Septembre")||this.mois.getSelectedItem().equals("Novembre"))||((int)this.jour.getSelectedItem()==30||(int)this.jour.getSelectedItem()==31)&&this.mois.getSelectedItem().equals("Fevrier")))
					{
				JOptionPane.showMessageDialog(this, "Erreur Dans La Syntaxe De La Date De Naissance", "ERREUR",HIDE_ON_CLOSE);
					}
			String UV="";

			for(int j=0;j<vect1.size();j++)
			{
				UV=UV+vect1.get(j)+"|";//Se termine aussi par |
			}
			String nais=this.jour.getSelectedItem()+" "+this.mois.getSelectedItem()+" "+this.annee.getSelectedItem();
			EtudiantPrime etd=new EtudiantPrime(i,this.textField.getText(),this.nom.getText(),this.prenom.getText(),nais,(String)this.comboBox.getSelectedItem(),UV);
			i++;
			this.InsertionBD();
		}
		if(e.getSource()==UVbox)
		{
			this.vect1.add((String) UVbox.getSelectedItem());
			this.list.setListData(vect1);
		}
		if(e.getSource()==btnFermer)
		{

			if(JOptionPane.showConfirmDialog(InscriptionPrime.this,"Voulez vous vraiment quitter","Confirmation",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			{
				InscriptionPrime.this.setVisible(false);
			}
		}
		if(e.getSource()==suppressionduv)
		{
			vect1.remove(vect1.indexOf(this.list.getSelectedValues()));
			this.list.setListData(vect1);
		}
		if(e.getSource()==Rechercher)
		{
			if(!(this.textField_3.getText().equals("")))
			{
				try{
					Statement stmt = connection.createStatement();
					ResultSet res=stmt.executeQuery("SELECT * FROM Etudiant WHERE Matricule="+this.textField_3.getText());
					this.table_1.getModel().setValueAt(res.getString("Matricule"),1, 1);
					this.table_1.getModel().setValueAt(res.getString("Nom"),1, 2);
					this.table_1.getModel().setValueAt(res.getString("Prenom"),1, 3);
					this.table_1.getModel().setValueAt(res.getString("Date_Naissance"),1, 4);
					this.table_1.getModel().setValueAt(res.getString("Pays"),1, 5);
					this.table_1.getModel().setValueAt(res.getString("Liste_UV"),1, 6);
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
			else if(!(this.textField_4.getText().equals("")))
			{
				int k=0;
				try{
					Statement stmt = connection.createStatement();
					ResultSet res=stmt.executeQuery("SELECT * FROM Etudiant WHERE Nom="+this.textField_4.getText());
					while(res.next())
					{
						k++;
					}
					for(int i=0;i<=k;i++)
					{
					this.table_1.getModel().setValueAt(res.getString("Matricule"),i, 1);
					this.table_1.getModel().setValueAt(res.getString("Nom"),i, 2);
					this.table_1.getModel().setValueAt(res.getString("Prenom"),i, 3);
					this.table_1.getModel().setValueAt(res.getString("Date_Naissance"),i, 4);
					this.table_1.getModel().setValueAt(res.getString("Pays"),i, 5);
					this.table_1.getModel().setValueAt(res.getString("Liste_UV"),i, 6);
					}
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
			else if(!(this.textField_4.getText().equals("")))
			{
				int k=0;
				try{
					Statement stmt = connection.createStatement();
					ResultSet res=stmt.executeQuery("SELECT * FROM Etudiant WHERE Prenom="+this.textField_4.getText());
					while(res.next())
					{
						k++;
					}
					for(int i=0;i<=k;i++)
					{
					this.table_1.getModel().setValueAt(res.getString("Matricule"),i, 1);
					this.table_1.getModel().setValueAt(res.getString("Nom"),i, 2);
					this.table_1.getModel().setValueAt(res.getString("Prenom"),i, 3);
					this.table_1.getModel().setValueAt(res.getString("Date_Naissance"),i, 4);
					this.table_1.getModel().setValueAt(res.getString("Pays"),i, 5);
					this.table_1.getModel().setValueAt(res.getString("Liste_UV"),i, 6);
					}
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource()==ajout)
		{
			JOptionPane jop = new JOptionPane();
			jop.setLocale(Locale.FRENCH);
			int q = jop.showConfirmDialog(this, "Voulez vous vraiment ajouter", "Confirmation", 1);
			if(q==0)
			{
			this.InsertionBD();
			}
		}
		if(e.getSource()==modifier)
		{
			this.textField.setEditable(true);
			this.nom.setEditable(true);
			this.prenom.setEditable(true);
			this.comboBox.setEditable(true);
			this.UVbox.setEditable(true);
			this.textField_4.setEditable(true);
			this.textField_5.setEditable(true);
			this.list.setEnabled(true);
			String nais,liste = "";
			nais=this.jour.getSelectedItem()+" "+this.mois.getSelectedItem()+" "+this.annee.getSelectedItem();
			String UV="";
			for(int i=0;i<this.vect1.size();i++)
			{
				liste=liste+"|"+this.vect1.get(i);
			}
			
			this.updateBD(this.getIndex(),"Matricule",this.getTextField().getText());
			this.updateBD(this.getIndex(), "Nom", this.getNom().getText());
			this.updateBD(this.getIndex(), "Prenom", this.getPrenom().getText());
			this.updateBD(this.getIndex(), "Naissance", nais);
			this.updateBD(this.getIndex(), "Pays", (String)this.getComboBox().getSelectedItem());
			this.updateBD(this.getIndex(), "Liste_UV", liste);
		}
			
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.table_1)
		{
			int i=this.table_1.getSelectedRow();
			String mat=(String) this.table_1.getModel().getValueAt(i, 1);
			ResultSet resultats=this.SelectBD(mat);
			try{
			boolean flag=resultats.next();
			while(flag)
			{
				if(resultats.getString("Matricule").equals(mat))
				{
					flag=false;
				}
				else{
					resultats.next();
				}
			}
			EtudiantPrime etd=new EtudiantPrime(resultats.getInt("EtudiantID"),resultats.getString("Matricule"),resultats.getString("Nom"),resultats.getString("Prenom"),resultats.getString("Date_Naissance"),resultats.getString("Pays"),resultats.getString("Liste_UV")); 
			this.setIndex(this.getIndex()+1);
			this.nom.setText(etd.getNom());
			this.textField.setText(etd.getMatricule());
			this.prenom.setText(etd.getPrenom());
			this.comboBox.setSelectedItem(etd.getPays());
			String nais=etd.getNaissance();
			String uv=etd.getLieu();
			int k=0,m,l;
			while(nais.charAt(k)!=' ')
			{
				k++;
			}
			String jr,ms,an;
			m=k;
			if(nais.charAt(k+2)==' ')
			{
				jr=nais.substring(k+1, k+2);
			}
			else
			{
				jr=nais.substring(k+1, k+3);
			}
			l=k+4;
			while(nais.charAt(l)!=' ')
			{
				l++;
			}
			if(nais.charAt(m+2)==' ')
			{
			ms=nais.substring(k+3, l);
			}
			else
			{
				ms=nais.substring(k+4,l);
			}
			an=nais.substring(l+1,nais.length());
			this.jour.setSelectedItem(jr);
			this.mois.setSelectedItem(ms);
			this.annee.setSelectedItem(an);
			int o=0;
			for(int p=0;p<uv.length();p++)
			{
				if(uv.charAt(p)=='|')
				{
					this.vect1.add(uv.substring(o,p));
					o=p+1;
				}
			}
			this.list.setListData(vect1);
;		}catch(SQLException e1)
		{
			e1.printStackTrace();
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

	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
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
	public JCalendarCombo getNaissance() {
		return Naissance;
	}
	public void setNaissance(JCalendarCombo naissance) {
		Naissance = naissance;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public JTable getTable_1() {
		return table_1;
	}
	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}
	public JTextField getTextField_3() {
		return textField_3;
	}
	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}
	public JTextField getTextField_4() {
		return textField_4;
	}
	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}
	public JTextField getTextField_5() {
		return textField_5;
	}
	public void setTextField_5(JTextField textField_5) {
		this.textField_5 = textField_5;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
	public JComboBox getUVbox() {
		return UVbox;
	}
	public void setUVbox(JComboBox uVbox) {
		UVbox = uVbox;
	}
	public JList getList() {
		return list;
	}
	public void setList(JList list) {
		this.list = list;
	}
	public static int getI() {
		return i;
	}
	public static void setI(int i) {
		InscriptionPrime.i = i;
	}
	public JButton getAjout() {
		return ajout;
	}
	public void setAjout(JButton ajout) {
		this.ajout = ajout;
	}
	public JButton getModifier() {
		return modifier;
	}
	public void setModifier(JButton modifier) {
		this.modifier = modifier;
	}
	public JButton getSuppression() {
		return suppression;
	}
	public void setSuppression(JButton suppression) {
		this.suppression = suppression;
	}
	public JButton getInitialiser() {
		return Initialiser;
	}
	public void setInitialiser(JButton initialiser) {
		Initialiser = initialiser;
	}
	public JButton getSuppressionduv() {
		return suppressionduv;
	}
	public void setSuppressionduv(JButton suppressionduv) {
		this.suppressionduv = suppressionduv;
	}
	public JButton getRechercher() {
		return Rechercher;
	}
	public void setRechercher(JButton rechercher) {
		Rechercher = rechercher;
	}
	public JButton getNouveau() {
		return nouveau;
	}
	public void setNouveau(JButton nouveau) {
		this.nouveau = nouveau;
	}
	public JComboBox getJour() {
		return jour;
	}
	public void setJour(JComboBox jour) {
		this.jour = jour;
	}
	public JComboBox getMois() {
		return mois;
	}
	public void setMois(JComboBox mois) {
		this.mois = mois;
	}
	public JComboBox getAnnee() {
		return annee;
	}
	public void setAnnee(JComboBox annee) {
		this.annee = annee;
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
	public Vector<String> getVect1() {
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
		InscriptionPrime.connection = connection;
	}
	public static int getIndex() {
		return index;
	}
	public static void setIndex(int index) {
		InscriptionPrime.index = index;
	}
	public JButton getBtnFermer() {
		return btnFermer;
	}
}
