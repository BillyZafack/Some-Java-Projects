import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
 *
 * @author Zafack Billy
 * @version 2.0
 */
public class UVPrimee extends java.awt.Dialog implements ActionListener{

    /**
     * Creates new form InscriptionPrimee
     */

	// Variables declaration - do not modify
	/** Bouton fermer*/
    private javax.swing.JButton Fermer;
    private javax.swing.JLabel Prenom;
    /** Bouton de recherche*/
    private javax.swing.JButton Rechercher;
    /** Bouton d'ajout d'une UV*/
    private javax.swing.JButton ajout;
    /** Contient les differents pays*/
    private javax.swing.JComboBox comboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    /** Pour la table des UVs*/
    private javax.swing.JScrollPane jScrollPane1;
    /** Pour la liste des UVs*/
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    /** Liste des etudiants selectionnes*/
    private javax.swing.JList list;
    /** Bouton de modification d'une UV*/
    private javax.swing.JButton modifier;
    /** Bouton de reinitialisation des champs*/
    private javax.swing.JButton reinitialiser;
    /** Bouton de suppression des UVs*/
    private javax.swing.JButton suppressionduv;
    private javax.swing.JButton supprimer;
    private javax.swing.JTextField textField;
    private javax.swing.JTextField textField_1;
    private javax.swing.JTextField textField_2;
    private javax.swing.JTextField textField_3;
    private javax.swing.JTextField textField_4;
    private javax.swing.JTextField textField_5;
    private static Vector<String> vector=new Vector<String>();
	private Vector<String> std =new Vector<String>();
	private Vector<String> add =new Vector<String>();
	private static int indice=0;
	private JTextField uvs;
	private JTextField etds;
	private JLabel lblRaccourcisPratiques;
	private JLabel uvetd;
	private JLabel statistiques;
	private JLabel javadoc;
	private JLabel aide;
	private JLabel lblCliquerSurLes;
    // End of variables declaration

    public UVPrimee(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("TRAITEMENT D'UVs");
int k=0;
initComponents();
		try{
			Statement stmt = WindowPrime.getConnection().createStatement();
    	  	ResultSet res1=stmt.executeQuery("SELECT * FROM Etudiant;");

			while(res1.next())
			{
				this.comboBox.addItem(res1.getString("Nom")+" "+res1.getString("Prenom"));
			}
			ResultSet res2=stmt.executeQuery("SELECT * FROM UV;");
			while(res2.next())
			{
				k++;
			}
			this.uvs.setText(Integer.toString(k));
			this.etds.setText(Integer.toString(0));
			 res2.beforeFirst();
			 String[][] data=new String[k][3];
			 System.out.println(res2.next()+" "+k+" POOooOOOOOOL");
			 res2.beforeFirst();

			 if(res2.next()){
	      for(int i=0;i<k;i++)
		{
			try {
				data[i][0]=res2.getString("Code_UV");
				data[i][1]=res2.getString("Intitule_UV");
			    data[i][2]=res2.getString("Nombre_Credits");
			    res2.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}

		String v[]={"Code De L'UV","Intitule De L'UV","Nombre De Credits"};
		TableModel model =new DefaultTableModel(data,v);
		jTable1.setModel(model);
		jTable1.setLocation(10, 400);
		jTable1.setVisible(true);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				this.reinitetds();
				this.reinituvs();
		this.list.setListData(std);
		this.setSize(1103, 780);
		GroupLayout gl_jPanel1 = new GroupLayout(jPanel1);
		gl_jPanel1.setHorizontalGroup(
			gl_jPanel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(29)
					.addComponent(lblRaccourcisPratiques))
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(10)
					.addComponent(lblCliquerSurLes))
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(17)
					.addComponent(uvetd)
					.addGap(1479)
					.addComponent(aide))
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
						.addComponent(statistiques)
						.addComponent(javadoc))
					.addGap(370)
					.addComponent(jLabel10)
					.addGap(268)
					.addComponent(ajout, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(579)
					.addComponent(jLabel13))
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(17)
					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addGap(162)
					.addComponent(jLabel11)
					.addGap(10)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addGap(109)
					.addComponent(modifier, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(508)
					.addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(17)
					.addComponent(jLabel2)
					.addGap(38)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addGap(217)
					.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addGap(109)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
						.addComponent(supprimer)
						.addComponent(reinitialiser, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(17)
					.addComponent(jLabel3)
					.addGap(20)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(659)
					.addComponent(suppressionduv)
					.addGap(147)
					.addComponent(Fermer, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(506)
					.addComponent(jLabel6))
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(53)
					.addComponent(jLabel7)
					.addGap(4)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(90)
					.addComponent(jLabel8)
					.addGap(7)
					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addGap(147)
					.addComponent(Prenom)
					.addGap(10)
					.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(Rechercher, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(27)
					.addComponent(uvs, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(29)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1027, GroupLayout.PREFERRED_SIZE))
		);
		gl_jPanel1.setVerticalGroup(
			gl_jPanel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(7)
					.addComponent(lblRaccourcisPratiques)
					.addGap(6)
					.addComponent(lblCliquerSurLes)
					.addGap(18)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
						.addComponent(uvetd)
						.addComponent(aide))
					.addGap(4)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(2)
							.addComponent(statistiques)
							.addGap(9)
							.addComponent(javadoc))
						.addComponent(jLabel10)
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(16)
							.addComponent(ajout))
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(22)
							.addComponent(jLabel13)))
					.addGap(32)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(4)
							.addComponent(jLabel1))
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(5)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(8)
							.addComponent(jLabel11))
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(5)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(modifier)
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(4)
							.addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(17)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(45)
							.addComponent(jLabel2))
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(42)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(16)
							.addComponent(supprimer)
							.addGap(51)
							.addComponent(reinitialiser)))
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(3)
							.addComponent(jLabel3))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
						.addComponent(suppressionduv)
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(21)
							.addComponent(Fermer)))
					.addGap(4)
					.addComponent(jLabel6)
					.addGap(29)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(4)
							.addComponent(jLabel7))
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(1)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(4)
							.addComponent(jLabel8))
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(1)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(4)
							.addComponent(Prenom))
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGap(1)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(Rechercher))
					.addGap(6)
					.addComponent(uvs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
		);
		jPanel1.setLayout(gl_jPanel1);
       this.ajout.addActionListener(this);
       this.comboBox.addActionListener(this);
       this.Fermer.addActionListener(this);
       this.jTable1.addMouseListener(new mouse1());
       this.aide.addMouseListener(new mouse1());
       this.javadoc.addMouseListener(new mouse1());
       this.uvetd.addMouseListener(new mouse1());
       this.statistiques.addMouseListener(new mouse1());
       this.modifier.addActionListener(this);
       this.Rechercher.addActionListener(this);
       this.suppressionduv.addActionListener(this);
       this.reinitialiser.addActionListener(this);
       this.supprimer.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setPreferredSize(new Dimension(0, 0));
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textField = new javax.swing.JTextField();
        textField_1 = new javax.swing.JTextField();
        textField_2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Fermer = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textField_3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textField_4 = new javax.swing.JTextField();
        Prenom = new javax.swing.JLabel();
        textField_5 = new javax.swing.JTextField();
        Rechercher = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboBox = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        suppressionduv = new javax.swing.JButton();
        ajout = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        reinitialiser = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
			public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setText("Code UV :");

        jLabel2.setText("Intitule De L'UV :");

        jLabel3.setText("Nombre De Credits :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Code De L'UV", "Intitule De L'UV", "Nombre De Credits"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        jTable1.setPreferredSize(new java.awt.Dimension(750, 520));
        jScrollPane1.setViewportView(jTable1);
        this.jTable1.setRowHeight(28);
        Fermer.setText("Fermer");

        jLabel6.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel6.setText("RECHERCHE");

        jLabel7.setText("Code D'UV :");

        jLabel8.setText("Intitule D'UV :");

        Prenom.setText("Credits :");

        Rechercher.setText("Rechercher");

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel10.setText("UNITES DE VALEURS");

        jLabel11.setText("Etudiants");

        suppressionduv.setText("Suppression D'Etudiant");

        ajout.setText("Ajouter +");

        modifier.setText("Modifier ~");

        supprimer.setText("Suppression -");

        reinitialiser.setText("Re-initialiser");

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel13.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel13.setText("Traitements");

        uvs = new JTextField();
        uvs.setEditable(false);
        uvs.setColumns(10);

        etds = new JTextField();
        etds.setEditable(false);
        etds.setColumns(10);

        lblRaccourcisPratiques = new JLabel("RACCOURCIS PRATIQUES");
        lblRaccourcisPratiques.setFont(new Font("Tahoma", Font.BOLD, 11));

        uvetd = new JLabel("- Traitement D'Etudiants");
        uvetd.setForeground(Color.RED);

        statistiques = new JLabel("- Statistiques");
        statistiques.setForeground(Color.RED);

        javadoc = new JLabel("- JavaDoc De la Classe");
        javadoc.setForeground(Color.RED);

        aide = new JLabel("AIDE CONTEXTUELLE");
        aide.setForeground(Color.RED);

        lblCliquerSurLes = new JLabel("Cliquer sur les raccourcis(en rouge)");
        lblCliquerSurLes.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 11));
        list = new javax.swing.JList();
        jScrollPane2.setViewportView(list);

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


    public void reinitEtdBox()
    {
   	 Vector<String> v=new Vector<String>();
   	 try{
   	 Statement stmt=WindowPrime.getConnection().createStatement();
   	 ResultSet res=stmt.executeQuery("SELECT Nom FROM Etudiant");
   	 while(res.next())
   	 {
   		 v.add(res.getString("Nom"));
   	 }
   	 }
   	 catch(SQLException e)
   	 {
   		 e.printStackTrace();
   	 }
   	 for(int i=0;i<v.size();i++)
   	 {
   		 this.comboBox.addItem(v.get(i));
   	 }
    }

    public Vector<String> reinitEtdList(String code)
    {
   	 Vector<String> v=new Vector<String>();
   	 try{
   	 Statement stmt=WindowPrime.getConnection().createStatement();
   	 ResultSet set=stmt.executeQuery("SELECT EtudiantID FROM EtudiantUV WHERE UVID="+this.getUVID(code));
   	 while(set.next())
   	 {
   	 ResultSet set1=stmt.executeQuery("SELECT Nom,Prenom FROM Etudiant WHERE EtudiantID="+set.getInt("EtudiantID"));
   	 if(set1.next())
   			 {
   	 v.add(set1.getString("Nom")+" "+set1.getString("Prenom"));
   			 }
   			 }
   	 }catch(SQLException e)
   	 {
   		 e.printStackTrace();
   	 }
   	 return v;
    }

    public int getEtdID(String nom)
    {
      int a=0;
      try{
    	Statement stmt=WindowPrime.getConnection().createStatement();
    	ResultSet res=stmt.executeQuery("SELECT EtudiantID FROM Etudiant WHERE Nom=\""+nom+"\";");
    	if(res.next())
    	{
    	a=res.getInt("EtudiantID");
    	}
      }
      catch(SQLException e)
      {
    	  e.printStackTrace();
      }
      return a;
    }

    public int getUVID(String code)
    {
    	int i=0;
    	try
    	{
    	Statement stmt=WindowPrime.getConnection().createStatement();
    	ResultSet s=stmt.executeQuery("SELECT UVID FROM UV WHERE Code_UV=\""+code+"\";");
    	if(s.next())
    	{
    	i=s.getInt("UVID");
    	}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return i;
    }


    public String getEtdsN(int id)
    {
    	String s = "";
    	try
    	{
    	Statement stmt=WindowPrime.getConnection().createStatement();
    	ResultSet ss=stmt.executeQuery("SELECT Nom FROM Etudiant WHERE EtudiantID="+id);
    	s=ss.getString("Nom");
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return s;
    	}


    public void reinituvs()
    {
   try
    {
   		Statement stmnt = WindowPrime.getConnection().createStatement();
   		ResultSet res=stmnt.executeQuery("SELECT * FROM UV");
   		int k=0;

   		while(res.next())
   		{
   			k++;
   		}
   this.uvs.setText(Integer.toString(k));
   }
   catch(SQLException e)
   {
   	e.printStackTrace();
   }
    }

    public void reinitetds()
    {
   	 this.etds.setText(Integer.toString(this.vector.size()));
    }


    public void InsertionBD()
    {
	try
	{
			Class.forName("com.mysql.jdbc.Driver");
	}
	catch(ClassNotFoundException e)
	{
			e.printStackTrace();
	}

		try{
			Statement stmt = WindowPrime.getConnection().createStatement();
			this.indice=this.indice++;
			ResultSet s=stmt.executeQuery("SELECT UVID FROM UV WHERE Code_UV=\""+this.getTextField().getText()+"\";");
			if(!s.next())
			{
			int a=stmt.executeUpdate("INSERT INTO UV(Code_UV,Intitule_UV,Nombre_Credits) VALUES (\""+this.textField.getText()+"\",\""+this.textField_1.getText()+"\",\""+this.textField_2.getText()+"\");");
			for(int i=0;i<std.size();i++)
			{
			int b=stmt.executeUpdate("INSERT INTO EtudiantUV(EtudiantID,UVID) VALUES ("+this.getEtdID(this.std.get(i))+","+this.getUVID(this.textField.getText())+");");
			}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Une UV avec cette intitule existe deja. Veuillez changer le code de l'uv ","DUPLICATION DU CODE DE L'UV", JOptionPane.OK_OPTION);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public ResultSet SelectBD(String mat)
	{
		ResultSet resultats = null;
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
			Statement stmt = WindowPrime.getConnection().createStatement();
			resultats=stmt.executeQuery("SELECT * FROM UV WHERE Code_UV = \""+mat+"\";");

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return resultats;
	}


	public void suppressionBD(String code)
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
		Statement stmt = WindowPrime.getConnection().createStatement();
		int b=stmt.executeUpdate("DELETE FROM EtudiantUV WHERE UVID="+this.getUVID(code));
		int a=stmt.executeUpdate("DELETE FROM UV WHERE Code_UV=\""+code+"\";");
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
		Statement stmt = WindowPrime.getConnection().createStatement();
		int a=stmt.executeUpdate("UPDATE UV SET "+att+"=\""+val+"\" WHERE UVID="+index+";");
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void suppressionBD(int index)
	{
		ResultSet resultats = null;
		String code="";
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		String ur1 = "jdbc:mysql://localhost:3306/ProjetPOO_Adapt";
		String user = "root"; String pass = "root";
		try{
			Statement stmt = WindowPrime.getConnection().createStatement();
			resultats=stmt.executeQuery("SELECT CodeUV FROM UV WHERE UVID="+index+";");

		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		try {
			code=resultats.getString("Code_UV");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.suppressionBD(code);
	}

public String[][] elements()
{
	int k=0;
	String[][] data=null;
	try{
	Statement stmt =WindowPrime.getConnection().createStatement();
	ResultSet res =stmt.executeQuery("SELECT * FROM UV");
	while(res.next())
	{
		k++;
	}
	res.beforeFirst();
	res.next();
	for(int i=0;i<k;i++)
	{
		data[i][0]=res.getString("Code_UV");
		data[i][1]=res.getString("Intitule_UV");
		data[i][2]=res.getString("Nombre_Credits");
		res.next();
	}
}
catch(SQLException t)
{
	t.printStackTrace();
}
return data;
}

public void reinittable()
{
	 String[][] dat=this.elements();
	    String[] s={"Code De L'UV","Intitule De L'UV","Nombre De Credits"};
	    TableModel model=new DefaultTableModel(dat,s);
	    this.jTable1.setModel(model);
	    this.jTable1.revalidate();
	    this.reinituvs();
}

public void reinitchamp()
{
	this.getTextField().setText("");
	this.getTextField_1().setText("");
	this.getTextField_2().setText("");
	this.getTextField_3().setText("");
	this.getTextField_4().setText("");
	this.getTextField_5().setText("");
	this.getComboBox().setSelectedIndex(0);
	ListModel model =new DefaultListModel();
	this.list.setModel(model);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ajout)
		{
			try{

			ResultSet s=UVPrimee.this.SelectBD(UVPrimee.this.getTextField().getText());
			if(JOptionPane.showConfirmDialog(this,"Voulez vous vraiment ajouter ?","CONFIRMATION D'AJOUT", JOptionPane.OK_CANCEL_OPTION)==0)
			{

				if(this.getTextField().getText().equals(""))
				{
					JOptionPane.showMessageDialog(this, "Veuillez renseigner le champs Code De L'Intitule !!", "ABSENCE DU CODE DE L'UV", JOptionPane.OK_OPTION);
				}

				else if(s.next())
				{
					JOptionPane.showMessageDialog(UVPrimee.this, "Ce Code d'UV existe deja !", "DUPLICATION DE CODE D'UV", JOptionPane.WARNING_MESSAGE);
				}
				else if(JOptionPane.showConfirmDialog(this, "Voulez vous vraiment ajouter cette UV?", "CONFIRMATION", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				{
			    this.InsertionBD();
			    JOptionPane.showMessageDialog(this, "L'Unite De Valeur "+this.getTextField_1().getText()+" a ete ajoutee avec succes", "INSERTION AVEC SUCCES", JOptionPane.OK_OPTION);
			   this.reinittable();
			   this.reinitchamp();
			   }
			}
			this.reinituvs();
			this.revalidate();
			}
			catch(SQLException r)
			{
				r.printStackTrace();
			}
		}
		if(e.getSource()==reinitialiser)
		{
			this.reinitchamp();
			this.revalidate();
		}
		if(e.getSource()==this.suppressionduv)
		{
			this.vector.removeElement(this.list.getSelectedValue());
			this.list.setListData(vector);
			this.reinitetds();
		}
		if(e.getSource()==this.comboBox)
		{
			 if(comboBox.getItemCount()==0)
	          {
	        	  JOptionPane.showMessageDialog(UVPrimee.this, "Vous n'avez pas cree d'etudiant", "Pas d'etudiant cree", JOptionPane.PLAIN_MESSAGE);
	          }
			if(!std.contains(getComboBox().getSelectedItem()))
			{
			std.add((String)this.getComboBox().getSelectedItem());
			}
			this.getList().setListData(std);
			vector.add((String)this.getComboBox().getSelectedItem());
			this.reinitetds();
		}
		if(e.getSource()==Fermer)
		{
			if(JOptionPane.showConfirmDialog(this, "Voulez vous vraiment quitter?", "CONFIRMATION", JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_OPTION)
		    {
				this.setVisible(false);
		    }
		}
		if(e.getSource()==modifier)
		{
			if(!UVPrimee.this.getTextField().getText().equals(""))
			{
			try{
			ResultSet t = UVPrimee.this.SelectBD(UVPrimee.this.getTextField().getText());
			if(!UVPrimee.this.getTextField().getText().equals("")&& !t.next())
			{
			if(JOptionPane.showConfirmDialog(UVPrimee.this, "Voulez vous vraiment modifier les informations de cet etudiant?", "CONFIRMATION", JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_OPTION)
			{
			updateBD(getUVID(getTextField().getText()),"Code_UV",getTextField().getText());
			updateBD(getUVID(getTextField().getText()), "Intitule_UV", getTextField_1().getText());
			updateBD(getUVID(getTextField().getText()), "Nombre_Credit",getTextField_2().getText());
			try
			{
			Statement stmnt = WindowPrime.getConnection().createStatement();
			ResultSet res=stmnt.executeQuery("SELECT * FROM UV;");
			int k=0;
			while(res.next())
			{
				k++;
			}
			res.beforeFirst();
			res.next();
			String data[][]=new String[k][3];
			for(int i=0;i<k;i++)
			{
			data[i][0]=res.getString("Code_UV");
			data[i][1]=res.getString("Intitule_UV");
			data[i][2]=res.getString("Nombre_Credits");
			res.next();
			}
			String[] s={"Code De UV","Intitule De UV","Nombre De Credits"};
			TableModel model=new DefaultTableModel(data,s);
			UVPrimee.this.jTable1.setModel(model);
			UVPrimee.this.revalidate();
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();

		}
			JOptionPane.showMessageDialog(UVPrimee.this, "Les informations de cet etudiant on ete modifiee", "MODIFICATION EFFECTUEE", JOptionPane.OK_OPTION);
			this.reinitchamp();
			}
			}
			else if(UVPrimee.this.getTextField().getText().equals(""))
			{
				JOptionPane.showMessageDialog(UVPrimee.this, "Veuillez Renseigner Le Champs Matricule", "ENTREZ UN MATRICULE", JOptionPane.PLAIN_MESSAGE);
			}
			else if(t.next())
			{
				JOptionPane.showMessageDialog(UVPrimee.this, "Ce Code Existe Deja. Veuillez le changer!", "DUPLICATION DE CODE", JOptionPane.PLAIN_MESSAGE);

			}

			}
			catch(SQLException or)
			{
				or.printStackTrace();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(UVPrimee.this, "Vous n'avez pas selectionnée d'UV", "Aucune UV selectionné", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==supprimer)
		{
			if(!UVPrimee.this.getTextField().getText().equals(""))
			{
			if(JOptionPane.showConfirmDialog(UVPrimee.this, "Voulez vous vraiment supprimer cette UV "+jTable1.getValueAt(jTable1.getSelectedRow(),1)+" "+jTable1.getValueAt(jTable1.getSelectedRow(),2)+". \nCette action est IRREVERSIBLE !!", "CONFIRMATION DE SUPPRESSION", JOptionPane.OK_CANCEL_OPTION)==0)
			{
				suppressionBD((String) jTable1.getValueAt(jTable1.getSelectedRow(),0));
				JOptionPane.showMessageDialog(UVPrimee.this, "Etudiant Supprimee avec succes", "SUPPRESSION REUSSIE", JOptionPane.OK_OPTION);
				reinittable();
				reinitchamp();
				revalidate();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(UVPrimee.this, "Vous n'avez pas selectionnée d'UV", "Aucun UV selctionné", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==Rechercher)
		{
			if(!textField_3.getText().equals(""))
			{
				try{
					Statement stmt = WindowPrime.getConnection().createStatement();
					ResultSet res=stmt.executeQuery("SELECT * FROM UV WHERE Code_UV=\""+textField_3.getText()+"\";");
					res.next();
					jTable1.removeAll();
					String[][] data = new String[1][3];
					data[0][0]=res.getString("Code_UV");
					data[0][1]=res.getString("Intitule_UV");
					data[0][2]=res.getString("Nombre_Credits");
					String[] s={"Code De L'UV","Intitule De L'UV","Nombre De Credits"};
					TableModel model=new DefaultTableModel(data,s);
					UVPrimee.this.jTable1.setModel(model);
					UVPrimee.this.revalidate();
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
					Statement stmt = WindowPrime.getConnection().createStatement();
					ResultSet res=stmt.executeQuery("SELECT * FROM UV WHERE Intitule_UV=\""+textField_4.getText()+"\";");
					while(res.next())
					{
						k++;
					}
					res.beforeFirst();
					res.next();
					String data[][]=new String[k][3];
					for(int i=0;i<k;i++)
					{
					data[i][0]=res.getString("Code_UV");
					data[i][1]=res.getString("Intitule_UV");
					data[i][2]=res.getString("Nombre_Credits");
					res.next();
					}
					String[] s={"Code De L'UV","Intitule De L'UV","Nombre De Credits"};
					TableModel model=new DefaultTableModel(data,s);
					UVPrimee.this.jTable1.setModel(model);
					UVPrimee.this.revalidate();
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
			else if(textField_5.getText().equals("")&&textField_4.getText().equals("")&&textField_3.getText().equals(""))
			{
				UVPrimee.this.reinittable();
				UVPrimee.this.jTable1.revalidate();
				UVPrimee.this.revalidate();
			}
			else if(!textField_5.getText().equals(""))
			{
				int k=0;
				try{
					Statement stmt = WindowPrime.getConnection().createStatement();
					ResultSet res=stmt.executeQuery("SELECT * FROM UV WHERE Nombre_Credits=\""+textField_4.getText()+"\";");
					while(res.next())
					{
						k++;
					}
					res.beforeFirst();
					res.next();
					String data[][]= new String[k][6];
					for(int i=0;i<k;i++)
					{
					data[i][0]=res.getString("Code_UV");
					data[i][1]=res.getString("Intitule_UV");
					data[i][2]=res.getString("Nombre_Credits");
					res.next();
					}
					String[] s={"Code_UV","Intitule_UV","Nombre_Credits"};
					TableModel model=new DefaultTableModel(data,s);
					UVPrimee.this.jTable1.setModel(model);
					UVPrimee.this.revalidate();
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		}
	}

	class mouse1 implements MouseListener
	{
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jTable1)
		{
			int i=jTable1.getSelectedRow();
			String code=(String) jTable1.getModel().getValueAt(i, 0);
			ResultSet resultats=SelectBD(code);
			try{
			boolean flag=resultats.next();
			while(flag)
			{
				if(resultats.getString("Code_UV").equals(code))
				{
					flag=false;
				}
				else{
					resultats.next();
				}
			}

			textField.setText(resultats.getString("Code_UV"));
			textField_1.setText(resultats.getString("Intitule_UV"));
			textField_2.setText(resultats.getString("Nombre_Credits"));
			Statement stmt = WindowPrime.getConnection().createStatement();
			ResultSet res1 = stmt.executeQuery("SELECT * FROM EtudiantUV WHERE UVID="+getUVID(code)+";");
			reinitEtdBox();
			list.setListData(reinitEtdList(textField.getText()));
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}

		}
		reinitetds();

		if(e.getSource()==statistiques)
		{
			String uv=UVPrimee.this.uvs.getText();
			String etdc=UVPrimee.this.etds.getText();
			int k=0;
			try{
			Statement stmt = WindowPrime.getConnection().createStatement();
			ResultSet res=stmt.executeQuery("SELECT * FROM Etudiant");
			while(res.next())
			{
				k++;
			}
			JOptionPane.showMessageDialog(UVPrimee.this, "STATISTIQUES\n Nombre D'Etudiants Inscrits : "+k+"\n"+
					"-Nombre De UVs au programme : "+uv+"\n"+
					"-Nombre D'Etudiant pour l'UV en cours de creation : "+etdc+"\n", "Statistiques Generales",JOptionPane.OK_OPTION);
			}
			catch(SQLException d)
			{
				d.printStackTrace();
			}
			}
		if(e.getSource()==javadoc)
		{
File f =new File(".\\doc\\UVPrimee.html");
try{
Desktop.getDesktop().open(f);
}
catch(IOException e3){
	e3.printStackTrace();
	JOptionPane.showMessageDialog(UVPrimee.this, "Erreur Dans L'acces du fichier de docuentation javadoc", "ERREUR", JOptionPane.PLAIN_MESSAGE);
}
		}
		if(e.getSource()==aide)
		{
			JOptionPane.showMessageDialog(UVPrimee.this, "AIDE CONTEXTUELLE(FENETRE DE TRAITEMENT D'UV)\n"+
		"Cette vous permet d'effectuer de differents traitement sur les unites d'enseignement(UV)"+
					"Nous avons notamment les champs Code De L'UV, L'Intitule De L'UV et le Nombre De Credits. Le champs Code de L'UV est OBLIGATOIRE et le code ne doit pas etre dupliquee\n"+
					"Vous  avez les traitements *Ajouter*,*Modifier*,*Supprimer* et *Re-initialiser*\n"+
					"*Ajouter* vous permet d'ajouter une UV dont vous avez rempli les informations si et seulement si vous avez rensignee le champs \'Code De L\'UV\' et vous ne l'avez pas dupliquee \n"+
					"*Supprimer* vous permet de supprimer une UV que vous avez selectionnee dans le tableau\n"+
					"*Modifier* vous permet de modifier les informations de l'UV que vous avez selectionnee dans le tableau\n"+
					"*Re-initialiser* vous permet de re-initialiser le champs du questionnaire\n"+
					"-Le bouton *Rechercher* vous permet de rechercher une UV dans le tableau apres que vous ayez fixee les parametres dans les champs Code De L'UV, Intitule de L'Uv et Nombre De Credits\n"+
					"-Il y a egalement un tres grand nombre de raccourcis vous permettant d'aller d'une fenetre a l'autre. FAITES en bon usage\n"+
					"-Les Etudiant sont renseignee a partir d'un combo-box", "AIDE CONTEXTUELLE",JOptionPane.OK_OPTION);
		}
		if(e.getSource()==uvetd)
		{
			if(JOptionPane.showConfirmDialog(UVPrimee.this, "Etes vous sures de vouloir quitter cette fenetre?\n TOUTE INFORMATION NON ENREGISTREE SERA PERDUE !!", "Attention",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
			{
				UVPrimee.this.setVisible(false);
				UVPrimee.this.getParent().setVisible(false);
				new InscriptionPm(new WindowPrime(),true).setVisible(true);
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




	public javax.swing.JButton getFermer() {
		return Fermer;
	}

	public void setFermer(javax.swing.JButton fermer) {
		Fermer = fermer;
	}

	public javax.swing.JLabel getPrenom() {
		return Prenom;
	}

	public void setPrenom(javax.swing.JLabel prenom) {
		Prenom = prenom;
	}

	public javax.swing.JButton getRechercher() {
		return Rechercher;
	}

	public void setRechercher(javax.swing.JButton rechercher) {
		Rechercher = rechercher;
	}

	public javax.swing.JButton getAjout() {
		return ajout;
	}

	public void setAjout(javax.swing.JButton ajout) {
		this.ajout = ajout;
	}

	public javax.swing.JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(javax.swing.JComboBox comboBox) {
		this.comboBox = comboBox;
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
		return jTable1;
	}

	public void setjTable1(javax.swing.JTable jTable1) {
		this.jTable1 = jTable1;
	}

	public javax.swing.JList getList() {
		return list;
	}

	public void setList(javax.swing.JList list) {
		this.list = list;
	}

	public javax.swing.JButton getModifier() {
		return modifier;
	}

	public void setModifier(javax.swing.JButton modifier) {
		this.modifier = modifier;
	}

	public javax.swing.JButton getReinitialiser() {
		return reinitialiser;
	}

	public void setReinitialiser(javax.swing.JButton reinitialiser) {
		this.reinitialiser = reinitialiser;
	}

	public javax.swing.JButton getSuppressionduv() {
		return suppressionduv;
	}

	public void setSuppressionduv(javax.swing.JButton suppressionduv) {
		this.suppressionduv = suppressionduv;
	}

	public javax.swing.JButton getSupprimer() {
		return supprimer;
	}

	public void setSupprimer(javax.swing.JButton supprimer) {
		this.supprimer = supprimer;
	}

	public javax.swing.JTextField getTextField() {
		return textField;
	}

	public void setTextField(javax.swing.JTextField textField) {
		this.textField = textField;
	}

	public javax.swing.JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(javax.swing.JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public javax.swing.JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(javax.swing.JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public javax.swing.JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(javax.swing.JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public javax.swing.JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(javax.swing.JTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public javax.swing.JTextField getTextField_5() {
		return textField_5;
	}

	public void setTextField_5(javax.swing.JTextField textField_5) {
		this.textField_5 = textField_5;
	}

	public static Connection getConnection() {
		return WindowPrime.getConnection();
	}

	public static void setConnection(Connection connection) {
		WindowPrime.setConnection(connection);
	}

	public static Vector<String> getVector() {
		return vector;
	}

	public static void setVector(Vector<String> vector) {
		UVPrimee.vector = vector;
	}

	public Vector<String> getStd() {
		return std;
	}

	public void setStd(Vector<String> std) {
		this.std = std;
	}

	public static int getIndice() {
		return indice;
	}

	public static void setIndice(int indice) {
		UVPrimee.indice = indice;
	}
}
