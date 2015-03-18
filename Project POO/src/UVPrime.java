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

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JComboBox;


public class UVPrime extends JDialog implements ActionListener,MouseListener {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private static Connection connection;
	private JButton ajouter = new JButton("Ajouter +");
	private JButton modifier = new JButton("Modifier ~");
	private JButton supprimer = new JButton("Supprimer -");
	private JButton reinitialiser = new JButton("Re-initialiser");
	private JComboBox comboBox = new JComboBox();
	private static Vector<String> vector=new Vector<String>();
	private Vector<String> std =new Vector<String>();
	private JList list = new JList();
	private JTable table=new JTable();
	private static int indice=0;
	
	
	public UVPrime (JFrame J) {
		
		super(J);
		this.setModal(true);
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		String ur1 = "jdbc:mysql://localhost:3306/ProjetPOO_Adapt";
		String user = "root"; String pass = "martin";
		try {
			connection = DriverManager.getConnection(ur1, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSize(new Dimension(1054, 770));
		
		JLabel lblUnitesDeValeurs = new JLabel("Unités De Valeurs");
		lblUnitesDeValeurs.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		
		JLabel lblCodeUv = new JLabel("Code UV :");
		
		JLabel lblIntitul = new JLabel("Intitulé UV :");
		
		JLabel lblNombreDeCredit = new JLabel("Nombre De Credit :");
		
		textField = new JTextField();
		textField.setColumns(10);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, reinitialiser, 36, SpringLayout.SOUTH, supprimer);
		springLayout.putConstraint(SpringLayout.WEST, reinitialiser, 0, SpringLayout.WEST, ajouter);
		springLayout.putConstraint(SpringLayout.NORTH, supprimer, 28, SpringLayout.SOUTH, modifier);
		springLayout.putConstraint(SpringLayout.WEST, supprimer, 0, SpringLayout.WEST, ajouter);
		springLayout.putConstraint(SpringLayout.NORTH, modifier, 30, SpringLayout.SOUTH, ajouter);
		springLayout.putConstraint(SpringLayout.WEST, modifier, 0, SpringLayout.WEST, ajouter);
		springLayout.putConstraint(SpringLayout.EAST, ajouter, -164, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblCodeUv);
		springLayout.putConstraint(SpringLayout.EAST, textField, -645, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNombreDeCredit, 254, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNombreDeCredit, 88, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblIntitul, 190, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblIntitul, 88, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblCodeUv, 129, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblCodeUv, 88, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblUnitesDeValeurs, 58, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblUnitesDeValeurs, 408, SpringLayout.WEST, getContentPane());
		getContentPane().setLayout(springLayout);
		getContentPane().add(lblUnitesDeValeurs);
		getContentPane().add(lblCodeUv);
		getContentPane().add(lblIntitul);
		getContentPane().add(lblNombreDeCredit);
		getContentPane().add(textField);
		
		int k=1;
		
		try{
			Statement stmt = connection.createStatement();
			ResultSet res=stmt.executeQuery("SELECT * FROM Etudiant WHERE Code_UV= '"+this.getTextField().getText()+"' ;");
			ResultSet res1=stmt.executeQuery("SELECT * FROM Etudiant;");
			ResultSet res2=stmt.executeQuery("SELECT * FROM UV;");
			while(res1.next())
			{
				this.comboBox.addItem(res1.getString("Nom"));
			}
			while(res2.next())
			{
				k++;
			}
			while(res.next())
			{
				this.std.add(res.getString("Nom"));
			}
		String[][] data=new String[k][3];
		for(int i=0;i<k;i++)
		{
			try {
				data[i][0]=res2.getString("Code_UV");
				data[i][1]=res2.getString("Intitule_UV");
			    data[i][2]=res2.getString("Nombre_Credits");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String v[]={"Code De L'UV","Intitule De L'UV","Nombre De Credits"};
		table=new JTable(data,v);
		table.setLocation(10, 400);
		table.setVisible(true);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getContentPane().add(new JScrollPane(table));
		
		
		
		this.list.setListData(std);
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 41, SpringLayout.EAST, lblIntitul);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, -645, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, textField_1);
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, lblIntitul);
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 6, SpringLayout.EAST, lblNombreDeCredit);
		springLayout.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		springLayout.putConstraint(SpringLayout.NORTH, list, 139, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, list, 94, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, list, -427, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, list, -266, SpringLayout.EAST, getContentPane());
		getContentPane().add(list);
		
		JLabel lblListeDetudiant = new JLabel("Liste D'Etudiant");
		springLayout.putConstraint(SpringLayout.NORTH, ajouter, -4, SpringLayout.NORTH, lblListeDetudiant);
		springLayout.putConstraint(SpringLayout.WEST, lblListeDetudiant, 0, SpringLayout.WEST, list);
		springLayout.putConstraint(SpringLayout.SOUTH, lblListeDetudiant, -6, SpringLayout.NORTH, list);
		getContentPane().add(lblListeDetudiant);
		getContentPane().add(ajouter);
		getContentPane().add(modifier);
		getContentPane().add(supprimer);
		getContentPane().add(reinitialiser);
		
		JLabel lblRechercher = new JLabel("RECHERCHER :");
		springLayout.putConstraint(SpringLayout.WEST, lblRechercher, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblRechercher, -352, SpringLayout.SOUTH, getContentPane());
		lblRechercher.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 11));
		getContentPane().add(lblRechercher);
		
		JLabel lblMatricule = new JLabel("Code :");
		springLayout.putConstraint(SpringLayout.NORTH, lblMatricule, 3, SpringLayout.NORTH, lblRechercher);
		springLayout.putConstraint(SpringLayout.WEST, lblMatricule, 37, SpringLayout.EAST, lblRechercher);
		getContentPane().add(lblMatricule);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 0, SpringLayout.NORTH, lblRechercher);
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 11, SpringLayout.EAST, lblMatricule);
		springLayout.putConstraint(SpringLayout.EAST, textField_3, -717, SpringLayout.EAST, getContentPane());
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNom = new JLabel("Intitule:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNom, 3, SpringLayout.NORTH, lblRechercher);
		springLayout.putConstraint(SpringLayout.WEST, lblNom, 48, SpringLayout.EAST, textField_3);
		getContentPane().add(lblNom);
		
		textField_4 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_4, 0, SpringLayout.NORTH, lblRechercher);
		springLayout.putConstraint(SpringLayout.WEST, textField_4, 1, SpringLayout.EAST, lblNom);
		springLayout.putConstraint(SpringLayout.EAST, textField_4, -508, SpringLayout.EAST, getContentPane());
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Credits :");
		springLayout.putConstraint(SpringLayout.NORTH, lblPrenom, 3, SpringLayout.NORTH, lblRechercher);
		springLayout.putConstraint(SpringLayout.WEST, lblPrenom, 42, SpringLayout.EAST, textField_4);
		getContentPane().add(lblPrenom);
		
		textField_5 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_5, 0, SpringLayout.NORTH, lblRechercher);
		springLayout.putConstraint(SpringLayout.WEST, textField_5, 6, SpringLayout.EAST, lblPrenom);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton rechercher = new JButton("Rechercher");
		springLayout.putConstraint(SpringLayout.EAST, rechercher, -177, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_5, -28, SpringLayout.WEST, rechercher);
		springLayout.putConstraint(SpringLayout.NORTH, rechercher, -1, SpringLayout.NORTH, lblRechercher);
		getContentPane().add(rechercher);
		
		JLabel lblEtudiant = new JLabel("Etudiants :");
		springLayout.putConstraint(SpringLayout.NORTH, lblEtudiant, 32, SpringLayout.SOUTH, lblNombreDeCredit);
		springLayout.putConstraint(SpringLayout.WEST, lblEtudiant, 0, SpringLayout.WEST, lblCodeUv);
		getContentPane().add(lblEtudiant);
		
		
		springLayout.putConstraint(SpringLayout.SOUTH, textField_2, -29, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 297, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 52, SpringLayout.EAST, lblEtudiant);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, textField);
		getContentPane().add(comboBox);
		this.ajouter.addActionListener(this);
		this.modifier.addActionListener(this);
		this.supprimer.addActionListener(this);
		this.reinitialiser.addActionListener(this);
		this.comboBox.addActionListener(this);
		
	}

	public void InsertionBD(){
		Connection connection=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		try{
			Statement stmt = connection.createStatement();
			this.indice=this.indice++;
			int a=stmt.executeUpdate("INSERT INTO UV VALUES '"+this.indice+"','"+this.textField.getText()+"','"+this.textField_1.getText()+"','"+this.textField_2.getText()+"','"+this.textField_3.getText()+"';");
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
			resultats=stmt.executeQuery("SELECT * FROM UV;");
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return resultats;
	}
	
	
	public void suppressionBD(String code)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
		Statement stmt = connection.createStatement();
		int a=stmt.executeUpdate("DELETE FROM UV WHERE Code_UV='"+code+"';");
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
		int a=stmt.executeUpdate("UPDATE UV SET "+att+"='"+val+"' WHERE UVID="+index+";");
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
			Statement stmt = connection.createStatement();
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





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ajouter)
		{
			
		}
		if(e.getSource()==this.comboBox)
		{
			vector.add((String)this.getComboBox().getSelectedItem());
			this.getList().setListData(vector);
		}
	}

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
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

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		UVPrime.connection = connection;
	}

	public JButton getAjouter() {
		return ajouter;
	}

	public void setAjouter(JButton ajouter) {
		this.ajouter = ajouter;
	}

	public JButton getModifier() {
		return modifier;
	}

	public void setModifier(JButton modifier) {
		this.modifier = modifier;
	}

	public JButton getSupprimer() {
		return supprimer;
	}

	public void setSupprimer(JButton supprimer) {
		this.supprimer = supprimer;
	}

	public JButton getReinitialiser() {
		return reinitialiser;
	}

	public void setReinitialiser(JButton reinitialiser) {
		this.reinitialiser = reinitialiser;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public static Vector<String> getVector() {
		return vector;
	}

	public static void setVector(Vector<String> vector) {
		UVPrime.vector = vector;
	}
}
