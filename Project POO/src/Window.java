import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jgoodies.forms.factories.DefaultComponentFactory;


@SuppressWarnings("serial")
/**
 *
 * @author Zafack Billy Ruffin
 * Etablissement ENSP
 * Departement du Genie Informatique
 * @version 1.0
 * La classe principale {@link Window} qui herite de {@link javax.swing.JFrame} et
 * implemente l'interface {@link java.awt.event.ActionListener}
 *
 *
 */
public class Window extends JFrame implements ActionListener{


	private final JMenuBar menubar = new JMenuBar();
	private final JMenu Fichier = new JMenu();
	private final JMenu Edition = new JMenu();
	private final JMenu Help = new JMenu();
	private final JMenuItem Nouveau = new JMenuItem();
	private final JMenuItem Consulter= new JMenuItem();
	private static JMenuItem Quitter = new JMenuItem();
	private final JMenuItem Supprimer = new JMenuItem();
	private final JMenuItem Modifier = new JMenuItem();
	private final JMenuItem Rechercher= new JMenuItem();
	private final JMenuItem ModeOperatoire = new JMenuItem();
	private final JMenuItem Apropos = new JMenuItem();
	 JButton Statistiques = new JButton("Statistiques");
     JButton RechercherEtudiant = new JButton("Rechercher Etudiant");
     JButton ConsulterEtudiants = new JButton("Consulter Etudiants");
	private Inscription J=new Inscription(this);
	private int j;
	JButton but =new JButton("Retour");
	  JButton passage = new JButton("Passage a la version Profesionnelle");

	JPanel pan = new JPanel();
	private final JMenuItem Javadoc = new JMenuItem("JavaDoc");
/**
 * Le Constructeur de la Class {@link Window}
 */
	    public Window()
	    {

		this.setSize(750, 543);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("Gestion Des Etudiants");
		Nouveau.setToolTipText("Creer un nouvel étudiant");
		Nouveau.setMnemonic('N');
		Nouveau.setRolloverEnabled(true);
		Nouveau.setIcon(new ImageIcon("C:\\Users\\Zafack Billy\\Documents\\BackupPlus.ico"));
		Nouveau.setSelectedIcon(new ImageIcon("C:\\Users\\Zafack Billy\\Documents\\BackupPlus.ico"));
		Fichier.setBorderPainted(true);
		Fichier.add(Nouveau);
		Quitter.setMnemonic('Q');
		Quitter.setToolTipText("Quitter l'application");
Consulter.setToolTipText("Consulter la liste d'étudiants");
Consulter.setMnemonic('C');
Fichier.add(Consulter);
		Fichier.add(Quitter);
		Nouveau.setSelected(true);
		Nouveau.setText("Nouveau");
		Consulter.setText("Consulter");
		Statistiques.addActionListener(this);
		RechercherEtudiant.addActionListener(this);
		ConsulterEtudiants.addActionListener(this);

passage.addActionListener(this);
		Nouveau.addActionListener(this);
		Supprimer.setToolTipText("Supprimer un Etudiant");
		Supprimer.setMnemonic('S');
		Edition.setToolTipText("Rechercher un Etudiant");
		Edition.add(Rechercher);
		Edition.add(Supprimer);
		Modifier.setToolTipText("Modifier les informations d'un Etudiant");
		Modifier.setMnemonic('M');
		Rechercher.setMnemonic('R');
		Edition.add(Modifier);
		ModeOperatoire.setToolTipText("Consulter le Mode Operatoire de ce logiciel");
		ModeOperatoire.setMnemonic('M');
		Help.add(ModeOperatoire);
		Javadoc.setMnemonic('J');
		Javadoc.setToolTipText("Consulter la Javadoc de ce programme");

		Help.add(Javadoc);
		Apropos.setMnemonic('A');
		Help.add(Apropos);
		Quitter.setText("Quitter");
		Rechercher.setText("Rechercher");
		Supprimer.setText("Supprimer");
		Modifier.setText("Modifier");
		ModeOperatoire.setText("Mode Operatoire");
		Apropos.setText("A propos");
		Fichier.setText("Fichier");
		Edition.setText("Edition");
		Help.setText("Help");
		Javadoc.addActionListener(this);
		Consulter.addActionListener(this);
		Quitter.addActionListener(this);
		Apropos.addActionListener(this);
		Rechercher.addActionListener(this);
		Supprimer.addActionListener(this);
		ModeOperatoire.addActionListener(this);
		Modifier.addActionListener(this);
	    menubar.add(Fichier);
		menubar.add(Edition);
		menubar.add(Help);
		pan.setBorder(UIManager.getBorder("InternalFrame.border"));
		pan.setBackground(new Color(255, 160, 122));
		pan.setForeground(new Color(138, 43, 226));
		this.setContentPane(pan);
	this.setDefaultLookAndFeelDecorated(true);
		menubar.setVisible(true);
		pan.setVisible(true);

        JLabel lblGestionDesEtudiants = DefaultComponentFactory.getInstance().createTitle("GESTION DES ETUDIANTS");
        lblGestionDesEtudiants.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 32));

        JLabel lblEnspgipoo = DefaultComponentFactory.getInstance().createLabel("ENSP/3GI/POO");
        lblEnspgipoo.setIcon(new ImageIcon("C:\\Users\\Zafack Billy\\Documents\\BackupPlus.ico"));
        lblEnspgipoo.setFont(new Font("Footlight MT Light", Font.ITALIC, 15));

        JLabel lblProjetgestiondeseleves = DefaultComponentFactory.getInstance().createLabel("Projet/GestionDesEtudiants");
        lblProjetgestiondeseleves.setFont(new Font("Goudy Old Style", Font.ITALIC, 15));

        JLabel lblSousLaSupervision = DefaultComponentFactory.getInstance().createLabel("Sous La Supervision Du:");
        lblSousLaSupervision.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        JLabel lblDrphdBatchakuiBernabe = DefaultComponentFactory.getInstance().createLabel("Dr/Ph.D Batchakui Bernabé");
        lblDrphdBatchakuiBernabe.setFont(new Font("Goudy Old Style", Font.BOLD | Font.ITALIC, 17));

        JLabel lblCopyrightEnspgizbrDecembre = DefaultComponentFactory.getInstance().createLabel("Copyright ENSP/3GI/ZBR Decembre 2013");
        lblCopyrightEnspgizbrDecembre.setFont(new Font("Kalinga", Font.BOLD | Font.ITALIC, 12));

        JLabel lblVersionClassique = new JLabel("Version Classique");
        lblVersionClassique.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 17));




        GroupLayout gl_pan = new GroupLayout(pan);
        gl_pan.setHorizontalGroup(
        	gl_pan.createParallelGroup(Alignment.LEADING)
        		.addComponent(menubar, GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
        		.addGroup(gl_pan.createSequentialGroup()
        			.addContainerGap(162, Short.MAX_VALUE)
        			.addComponent(lblGestionDesEtudiants)
        			.addGap(162))
        		.addGroup(gl_pan.createSequentialGroup()
        			.addGap(19)
        			.addComponent(lblEnspgipoo)
        			.addContainerGap(607, Short.MAX_VALUE))
        		.addGroup(gl_pan.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblProjetgestiondeseleves)
        			.addGap(212)
        			.addComponent(lblVersionClassique)
        			.addContainerGap(223, Short.MAX_VALUE))
        		.addGroup(gl_pan.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblSousLaSupervision, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(562, Short.MAX_VALUE))
        		.addGroup(gl_pan.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblDrphdBatchakuiBernabe)
        			.addContainerGap(517, Short.MAX_VALUE))
        		.addGroup(gl_pan.createSequentialGroup()
        			.addContainerGap(174, Short.MAX_VALUE)
        			.addComponent(lblCopyrightEnspgizbrDecembre)
        			.addGap(307))
        		.addGroup(gl_pan.createSequentialGroup()
        			.addGap(39)
        			.addComponent(RechercherEtudiant)
        			.addGap(68)
        			.addComponent(passage)
        			.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
        			.addComponent(Statistiques)
        			.addGap(82))
        		.addGroup(gl_pan.createSequentialGroup()
        			.addGap(282)
        			.addComponent(ConsulterEtudiants)
        			.addContainerGap(313, Short.MAX_VALUE))
        );
        gl_pan.setVerticalGroup(
        	gl_pan.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pan.createSequentialGroup()
        			.addComponent(menubar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addGroup(gl_pan.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pan.createSequentialGroup()
        					.addGap(18)
        					.addComponent(lblEnspgipoo)
        					.addGap(18)
        					.addComponent(lblProjetgestiondeseleves)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblSousLaSupervision, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblDrphdBatchakuiBernabe))
        				.addGroup(gl_pan.createSequentialGroup()
        					.addGap(37)
        					.addComponent(lblVersionClassique)))
        			.addGap(74)
        			.addComponent(lblGestionDesEtudiants)
        			.addGap(50)
        			.addComponent(ConsulterEtudiants)
        			.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
        			.addGroup(gl_pan.createParallelGroup(Alignment.BASELINE)
        				.addComponent(Statistiques)
        				.addComponent(RechercherEtudiant)
        				.addComponent(passage))
        			.addGap(23)
        			.addComponent(lblCopyrightEnspgizbrDecembre)
        			.addContainerGap())
        );
        pan.setLayout(gl_pan);

        setVisible(true);
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
            float[] hsbvals= new float[3] ;
          Color.RGBtoHSB(112,56,0, hsbvals) ;

              UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

UIManager.put("nimbusBase", Color.getHSBColor(hsbvals[0], hsbvals[1], hsbvals[2]));

              for(UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()){
                  if("Nimbus".equals(laf.getName())){
                      UIManager.setLookAndFeel(laf.getClassName());
                      UIManager.getLookAndFeelDefaults().put("Panel.background", Color.lightGray ) ;
                  }
              }

} catch (ClassNotFoundException | InstantiationException| IllegalAccessException | UnsupportedLookAndFeelException e) {
e.printStackTrace();
}finally{
	String sd=JOptionPane.showInputDialog(null, "Voulez vous la version avec serialisation dans un fichier [saisir \"Classique\"]\n ou la version avec BD et interface professionnelle [saisir \"Professionnelle\"]", "CHOIX D\'INTERFACE", HIDE_ON_CLOSE);
	// TODO Auto-generated method stub
	if(sd.equalsIgnoreCase("Classique"))
	{
new Window().setDefaultLookAndFeelDecorated(true);
	}
	else if(sd.equalsIgnoreCase("Professionnelle"))
	{
		Authentification a=new Authentification(null,true);
		a.setVisible(true);
	}
	else
	{
		JOptionPane.showMessageDialog(null, "Mauvaise entree", "ENTREE INCONSISTENTE", HIDE_ON_CLOSE);
	}
}
	}



public interface Actioni extends ActionListener
{
	public void actionPerformed(ActionEvent e,int i);
}

/**
 * La Methode actionperformed permettant la gestion des evenements de ma fenetre principale
 * @param e Ce parametre va gerer les evenements sur l'ensemble de ma fenetre au travers de sa methode getSource
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
if(e.getSource()==Statistiques)
{
	int i,j = 0,k = 0,l = 0;
	try{
		FileInputStream fichier1 = new FileInputStream("projet1.txt");
		ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(fichier1));
		 Inscription.table = (ArrayList<Etudiant>)ois.readObject();
		ois.close();

			}
			catch (java.io.IOException e1) {
				e1.printStackTrace();
				}
				catch (ClassNotFoundException e2) {
				e2.printStackTrace();
				}
	for(int a=0;a<Inscription.table.size();a++)
	{
		if(Inscription.table.get(a).getSexe().equalsIgnoreCase("Masculin"))
		{
			j++;
		}
		if(Inscription.table.get(a).getLangues().equalsIgnoreCase("Anglais")||Inscription.table.get(a).getLangues().equalsIgnoreCase("Anglais et Francais"))
		{
			k++;
		}
		if(Inscription.table.get(a).getLangues().equalsIgnoreCase("Francais")||Inscription.table.get(a).getLangues().equalsIgnoreCase("Anglais et Francais"))
		{
			l++;
		}

	}
	JOptionPane.showMessageDialog(this,"Nombre D'Etudiants Inscrit: "+Inscription.table.size()+"\n"+"Nombre de Garcons: "+j+"\n"+"Nombres de Filles: "+(Inscription.table.size()-j)+"\n"+"Nombre D'Etudiants s'exprimant en Anglais: "+k+"\n"+"Nombre D'Etudiants s'exprimant en Francais: "+l,"STATISTIQUES", JOptionPane.OK_OPTION);

}
		if(e.getSource()==Nouveau)
		{
			JFrame.setDefaultLookAndFeelDecorated(true);
			Inscription I=new Inscription(this);
			I.setDefaultLookAndFeelDecorated(true);
			I.setVisible(true);
		}
		else if(e.getSource()==passage)
		{
			int p=JOptionPane.showConfirmDialog(this,"Voulez vous vraiment passer en MODE PROFESIONNELLE?","CONFIRMATION", 1);
		    if(p==0)
		    {
		    	this.setVisible(false);
		    	new Authentification(null,true).setVisible(true);
		    }
		}
		else if(e.getSource()==Consulter || e.getSource()==ConsulterEtudiants)
		{
			Consult C=new Consult();
			C.setVisible(true);
			C.getContentPane().add(but);
		    but.setVisible(false);
			but.addActionListener(this);
			but.setSize(new Dimension(100,20));
			but.setLocation(310, 470);
			this.revalidate();
		}

		if(e.getSource()==Rechercher||e.getSource()==RechercherEtudiant)
		{
			boolean flag=false;
			String s=JOptionPane.showInputDialog(this,"Voulez entrer le matricule de l'étudiant","Recherche Etudiant", 1);
			try {
				FileInputStream fichier = new FileInputStream("projet1.txt");
				ObjectInputStream ois = new ObjectInputStream(fichier);
				Inscription.table = (ArrayList<Etudiant>) ois.readObject();
				ois.close();
			}
			catch (java.io.IOException ex) {
			ex.printStackTrace();
			}
			catch (ClassNotFoundException ey) {
			ey.printStackTrace();
			}
			String s1="";
				for(int i=0;i<Inscription.table.size();i++)
				{
					for(int k=0;k<Inscription.table.get(i).lise.size();k++)
					{
						s1=s1+Inscription.table.get(i).lise.get(k)+", ";
					}
					if(Inscription.table.get(i).getMatricule1().equals(s))
					{
						flag=true;
						JOptionPane.showMessageDialog(this, "Matricule : "+Inscription.table.get(i).getMatricule1()+"\n "
+ "Prenom: " +Inscription.table.get(i).getNom1()+"\n "+"Nom: "+Inscription.table.get(i).getPrenom1()+"\n "+"Date De Naissance: "+Inscription.table.get(i).getNais1()+"\n "+"Pays: "+Inscription.table.get(i).getPays1()+"\n "+
 "Langues Parl�es: "+Inscription.table.get(i).getLangues()+"\n"+"Sexe: "+Inscription.table.get(i).getSexe()+"\n"+"Liste D'UVs: "+s1, "Informations sur l'Etudiant",JOptionPane.OK_CANCEL_OPTION);
					}
				}

                if(!flag&&!s.equals(""))
				{
					JOptionPane.showMessageDialog(this, "Etudiant n'existe pas!!!", "Recherche Infructueux", 1);
				}
                try{
                ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("projet1.txt")));
				oos.writeObject(Inscription.table);
				oos.close();
                }
				catch (java.io.IOException e3) {
				e3.printStackTrace();
				}

				}


		if(e.getSource()==but)
		{
			new Window();

		}
		else if (e.getSource()==Apropos)
		{
			JOptionPane.showMessageDialog(this,"PROJET PROGRAMMATION ORIENTEE OBJET\n Interface De Gestion D'Etudiant \n Copyright Decembre 2013 \n Zafack Billy Ruffin \n Sous la supervision de Dr/Phd Ing Batchakui Bernabe ","A PROPOS",1);
		}
		else if (e.getSource()== ModeOperatoire)
		{
			JOptionPane.showMessageDialog(this, "Ceci est une application de gestion des étudiants dans un établissement\n Dans la fenetre principale appelée \"Gestion Des Etudiant\" il y a trois menus principales:\n" +
					"-D'Abord on a le menu Fichier qui contient \'Nouveau\' et \'Quitter\'.\n" +
					"   Quitter vous permet de quitter l'application\n" +
					"   Nouveau vous permet d'ajouter un nouvel étudiant au fichier de gestion d'étudiant en ouvrant une fénetre vous permettant de remplir les informations de cet etudiant.\n" +
					"-Puis on a le menu Edition qui contient les \'Supprimer\' et \'Modifier\'.\n" +
					"   Supprimer nous permet de supprimer un étudiant dont on precisera le matricule\n" +
					"   Modifier vous permet de modifier les information d'un etudiant en particulier\n" +
					"- Il y a ensuite le menu Aide qui affiche l'apropos et le mode operatoire\n" +
					"     J'espere que ce logiciel vous sera utile.\n ","MODE OPERATOIRE",JOptionPane.PLAIN_MESSAGE);
		}
		if(e.getSource()==Quitter)
		{
			int p=JOptionPane.showConfirmDialog(this,"Voulez vous vraiment quitter?","Confirmer", 1);
            if(p==0)
            {
            	System.exit(0);
            }
		}
		if(e.getSource()==Supprimer)
		{
			boolean flag=false;

			String s=JOptionPane.showInputDialog(this,"Voulez entrer le matricule de l'étudiant\n dont les informations vous voulez supprimer","Suppression", 1);
			if(s!=null)
				{
				System.out.println(s);
				try {
				FileInputStream fichier = new FileInputStream("projet1.txt");
				ObjectInputStream ois = new ObjectInputStream(fichier);
				Inscription.table = (ArrayList<Etudiant>) ois.readObject();

}
			catch (java.io.IOException ex) {
			ex.printStackTrace();
			}
			catch (ClassNotFoundException ey) {
			ey.printStackTrace();
			}
				for(int i=0;i<Inscription.table.size();i++)
				{

					if(Inscription.table.get(i).getMatricule1().equals(s))
					{
						flag=true;
						if(!s.equals(""))
						{
						Inscription.table.remove(i);
						JOptionPane.showMessageDialog(this, "Etudiant supprimé avec succes", "Suppression Effectuée", 1);
						}
					}
				}


				if(!flag&&s!="")
				{
					JOptionPane.showMessageDialog(this, "Etudiant n'existe pas!!!", "Suppression Non Effectuée", 1);
				}

			try {
				FileOutputStream fichier = new FileOutputStream("projet1.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fichier);
				oos.writeObject(Inscription.table);
				oos.flush();
				oos.close();
				}
				catch (java.io.IOException e3) {
				e3.printStackTrace();
				}
		}
		}

if(e.getSource()==Javadoc)
{
	File f = new File(".\\doc\\index.html");

try {
	Desktop.getDesktop().open(f);
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
}
		if(e.getSource()==Modifier)
		{
			boolean flag=false;
			String s=JOptionPane.showInputDialog(this,"Voulez entrer le matricule de l'étudiant\n dont les informations vous voulez modifier","Modification", 1);
			if(s!=null)
				{
				try {
				FileInputStream fichier = new FileInputStream("projet1.txt");
				ObjectInputStream ois = new ObjectInputStream(fichier);
				Inscription.table = (ArrayList<Etudiant>) ois.readObject();
				ois.close();
			}
			catch (java.io.IOException ex) {
			ex.printStackTrace();
			}
			catch (ClassNotFoundException ey) {
			ey.printStackTrace();
			}
			 int i=0;
				for( i=0;i<Inscription.table.size();i++)
				{
					if(Inscription.table.get(i).getMatricule1().equals(s))
					{

						flag=true;
						Modification I =new Modification(i,this);
						I.getEnregistrer().removeActionListener(I);
                        I.setModificateur(i);
						I.setVisible(true);


					}
				}

                if(!flag&&s!="")
				{
					JOptionPane.showMessageDialog(this, "Etudiant n'existe pas!!!", "Modification Non Effectuee", 1);
				}
                try{
                ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("projet1.txt")));
				oos.writeObject(Inscription.table);
				oos.close();
                }
				catch (java.io.IOException e3) {
				e3.printStackTrace();
				}
		}
				}


		}
	}

