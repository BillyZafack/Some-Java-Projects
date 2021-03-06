import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Cette classe construit et implemente l'interface d'authentification de l'utilisateur de la Base De Donnees.
 * @author Zafack Billy
 * @version 2.0
 */
public class Authentification extends java.awt.Dialog implements ActionListener,MouseListener {

	  // Variables declaration - do not modify
	/** Recupere le nom de l'utilisateur*/
    private javax.swing.JTextField admin;
    /** Variable qui contient le nom de l'utilisateur*/
    private static String user;
    /** Variable contenant le mot de passe d'acces a la BD*/
    private static String password;
    /** Variable contenant le nom de la base de donnee*/
    private static String nbase;
    /** Bouton annuler de l'interface de connection*/
    private javax.swing.JButton annuler;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    /** Bouton valider de l'interface d'authentification*/
    private javax.swing.JButton valider;
    /** Champs recuperant le mot de passe de l'utilisateur*/
    private JPasswordField passe;
    private JLabel lblNewLabel;
    private JButton enseignant = new JButton("Entree de L'Enseignant");
   /** Champs recuperant le nom de la base de donnee*/
    private JTextField base;

    // End of variables declaration

    /**
     * Permet la connection initial a la base de donnees
     * @param parent Qui est le nom de laa classe parent(un JFrame) de la boite de dialogue.
     * @param modal  Ce parametre permet de rendre la boite de dialogue modal ou pas.
     */
    public Authentification(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        setTitle("AUTHENTIFICATION\r\n");
        setResizable(false);
        setModal(true);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    /**
     * Cette fenetre permet d'initialiser les composantes de la fenetre d'authentification.
     *
     */
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBorder(new MatteBorder(3, 3, 3, 3, new Color(0, 0, 0)));
        jPanel1.setLocation(new Point(100, 100));
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        admin = new javax.swing.JTextField();
        annuler = new javax.swing.JButton();
        valider = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel14.setText("Veuillez entrer le nom d'utilisateur et mot de passe que vous avez utilisee lors de la creation du serveur MySQL sur votre ordinateur !");


        jPanel1.setPreferredSize(new Dimension(803, 359));

        jLabel1.setText("Administrateur :");

        jLabel2.setText("Mot De Passe :");

        annuler.setText("Annuler");

        valider.setText("Valider");
this.setLocation(250, 250);
        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel10.setText("AUTHENTIFICATION");
        this.valider.addActionListener(this);
        this.annuler.addActionListener(this);
        this.jLabel3.addMouseListener(this);
        this.enseignant.addActionListener(this);

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("J'ai oublié mon mot de passe");

        passe = new JPasswordField();

        JLabel lblCeLogicielAccede = new JLabel("Ce logiciel accede a une Base De Donnees securisée.");

        lblNewLabel = new JLabel("Veuillez entrer le nom d'utilisateur(par defaut \"root\"), mot de passe et le nom de la base de donnee que vous avez cree sur votre ordinateur !");
this.enseignant.setEnabled(false);

        base = new JTextField();
        base.setColumns(10);

        JLabel lblBaseDeDonnees = new JLabel("Base De Donnees :");
        javax.swing.GroupLayout gl_jPanel1 = new javax.swing.GroupLayout(jPanel1);
        gl_jPanel1.setHorizontalGroup(
        	gl_jPanel1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel1.createSequentialGroup()
        			.addContainerGap(106, Short.MAX_VALUE)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
        				.addComponent(valider, Alignment.LEADING)
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
        								.addComponent(lblBaseDeDonnees)
        								.addComponent(jLabel1))
        							.addGap(61))
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
        							.addGap(46)))
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(admin, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        						.addComponent(passe)
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
        								.addComponent(enseignant)
        								.addComponent(jLabel3)))
        						.addComponent(base))))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(annuler)
        			.addGap(116))
        		.addGroup(gl_jPanel1.createSequentialGroup()
        			.addGap(231)
        			.addComponent(lblCeLogicielAccede)
        			.addContainerGap(230, Short.MAX_VALUE))
        		.addGroup(gl_jPanel1.createSequentialGroup()
        			.addGap(260)
        			.addComponent(jLabel10)
        			.addContainerGap(264, Short.MAX_VALUE))
        		.addGroup(gl_jPanel1.createSequentialGroup()
        			.addGap(28)
        			.addComponent(lblNewLabel)
        			.addContainerGap(35, Short.MAX_VALUE))
        );
        gl_jPanel1.setVerticalGroup(
        	gl_jPanel1.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_jPanel1.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel10)
        			.addGap(43)
        			.addComponent(lblCeLogicielAccede)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lblNewLabel)
        			.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(admin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel1))
        			.addGap(18)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(base, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblBaseDeDonnees))
        			.addGap(13)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(passe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2))
        			.addGap(45)
        			.addComponent(jLabel3)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addGap(24)
        					.addComponent(enseignant))
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        						.addComponent(annuler)
        						.addComponent(valider))))
        			.addGap(48))
        );
        jPanel1.setLayout(gl_jPanel1);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>



/**
 * Cette methode definie toutes les actions possible sur l'interface de la boite de dialogue d'authentification.
 *
 */
@Override
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==this.valider)
	{
		this.user=admin.getText();
		this.password=String.copyValueOf(this.passe.getPassword());
		this.nbase=this.base.getText();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e1)
		{
			e1.printStackTrace();
		}

		String ur1 = "jdbc:mysql://localhost:3306/"+this.nbase;
		try{
		WindowPrime.connection=DriverManager.getConnection(ur1, this.admin.getText(),String.copyValueOf(this.passe.getPassword()) );
		}
		catch(SQLException p)
		{
			p.printStackTrace();
			JOptionPane.showMessageDialog(this, "ERREUR DANS LA CONNECTION A LA BASE DE DONNEES", "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		if(WindowPrime.connection==null)
		{
			JOptionPane.showMessageDialog(this, "Le mot de passe que vous avez entree est incorrect. Veuillez consulter le nom d'utilisateur et mot de passe", "ERREUR", JOptionPane.WARNING_MESSAGE);
		}
		else
		{

			this.setVisible(false);
			new WindowPrime();
		}
	}
if(e.getSource()==this.annuler)
{
this.setVisible(false);
}
if(e.getSource()==this.enseignant)
{
	this.setVisible(false);
	JOptionPane.showMessageDialog(null, "BIENVENUE", "Bienvenue Monsieur", JOptionPane.OK_OPTION);
	new WindowPrime().setDefaultLookAndFeelDecorated(true);
}

}

@Override
/**
 * Cette methode permet de gerer les interactions(de clique) a travers la souris par l'utilisateur.
 * Il fait ceci au travers de une instance du {@link java.awt.event.MouseListener}
 */
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==this.jLabel3)
	{
		JOptionPane.showMessageDialog(this,"Pour acceder a ce logiciel, vous devez entrer le nom d'utilisateur(Qui est par defaut \"root\") et \n le mot de passe utilisé dans la creation du serveur MySQL !","AUTHENTIFICATION AVANCEE", 1);
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

public javax.swing.JTextField getAdmin() {
	return admin;
}

public void setAdmin(javax.swing.JTextField admin) {
	this.admin = admin;
}

public static String getUser() {
	return user;
}

public static void setUser(String user) {
	Authentification.user = user;
}

public static String getPassword() {
	return password;
}

public static void setPassword(String password) {
	Authentification.password = password;
}

public static String getNbase() {
	return nbase;
}

public static void setNbase(String nbase) {
	Authentification.nbase = nbase;
}

public javax.swing.JButton getAnnuler() {
	return annuler;
}

public void setAnnuler(javax.swing.JButton annuler) {
	this.annuler = annuler;
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

public javax.swing.JLabel getjLabel14() {
	return jLabel14;
}

public void setjLabel14(javax.swing.JLabel jLabel14) {
	this.jLabel14 = jLabel14;
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

public javax.swing.JPanel getjPanel1() {
	return jPanel1;
}

public void setjPanel1(javax.swing.JPanel jPanel1) {
	this.jPanel1 = jPanel1;
}

public javax.swing.JButton getValider() {
	return valider;
}

public void setValider(javax.swing.JButton valider) {
	this.valider = valider;
}

public JPasswordField getPasse() {
	return passe;
}

public void setPasse(JPasswordField passe) {
	this.passe = passe;
}

public JLabel getLblNewLabel() {
	return lblNewLabel;
}

public void setLblNewLabel(JLabel lblNewLabel) {
	this.lblNewLabel = lblNewLabel;
}

public JButton getEnseignant() {
	return enseignant;
}

public void setEnseignant(JButton enseignant) {
	this.enseignant = enseignant;
}

public JTextField getBase() {
	return base;
}

public void setBase(JTextField base) {
	this.base = base;
}

}