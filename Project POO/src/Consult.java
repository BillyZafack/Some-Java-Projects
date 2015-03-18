import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
/**
*
* @author Zafack Billy Ruffin
* Etablissement ENSP
* Departement du Genie Informatique
* @version 1.0
* La classe Consult {@link Window} qui herite de {@link javax.swing.JFrame} et
* implemente l'interface {@link java.awt.event.ActionListener}
* Il gere le tableau des etudiants inscrits
*
*/
public class Consult extends JFrame {
	/**
	 * Constructeur de ma classe Consult
	 */
public Consult(){
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
this.setLocationRelativeTo(null);
this.setLocation(100, 100);

this.setTitle("Tableau D'Etudiants");
this.setSize(800,620);

String[][] data = new String[Inscription.table.size()][6];
int i,j;
String s="";

for( i=0;i<Inscription.table.size();i++)
{

		data[i][0]=Inscription.table.get(i).getMatricule1();
		data[i][1]=Inscription.table.get(i).getNom1();
		data[i][2]=Inscription.table.get(i).getPrenom1();
		data[i][3]=Inscription.table.get(i).getPays1();

		for(int k=0;k<Inscription.table.get(i).lise.size();k++)
		{

		s=s+"\n  "+Inscription.table.get(i).lise.get(k);
		}

		data[i][4]=s;



}
String  title[] = {"Matricule","Prenom","Nom", "Date De Naissance","Liste D'UVs"};
JTable tableau = new JTable(data, title);
this.getContentPane().add(new JScrollPane(tableau));
TableColumn col;
col=tableau.getColumnModel().getColumn(4);
col.setPreferredWidth(100);
}
}