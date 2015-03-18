import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Zafack Billy
 * @version 1.0
 * La Classe Modification qui herite de {@link Inscription} et gere la modification les information d'un etudiant
 * inscrit.
 *
 */

public class Modification extends Inscription implements ActionListener
{
/**
 * Constructeur de la classe {@link Modification}
 * @param J qui est la fenetre qui lance la boite de dialogue
 * @wbp.parser.constructor
 */
	public Modification(JFrame J)
	{
		super(J);

		this.getM().setSelected(true);

	}
	/**
	 * Constructeur de la classe {@link Modification}
	 * Elle permet de gerer la modification des informations d'un etudiant.
	 * @param i represente la ligne du tableau table correspondant a l'etudiant dont on veut modifier les informations
	 * @param J represente la fentre qui lance la boite de dialogue.
	 */
	public Modification(int i,JFrame J)
	{
        super(J);
        this.getM().setSelected(true);

        this.mLangue(Inscription.table.get(i).getLangues());

		if(Inscription.table.get(i).getLangues().equalsIgnoreCase("Anglais et Francais")) {

			this.Anglais.setSelected(true);
			this.Francais.setSelected(true);
		}
		else if(Inscription.table.get(i).getLangues().equals("Anglais"))
		{
			this.Anglais.setSelected(true);
			this.Francais.setSelected(false);
		}
		else if(Inscription.table.get(i).getLangues().equals("Francais"))
		{
			this.Anglais.setSelected(false);
			this.Francais.setSelected(true);
		}
		else
		{
			this.Anglais.setSelected(false);
			this.Francais.setSelected(false);
		}
	    this.mS(Inscription.table.get(i).getSexe());
	    this.getEnregistrer().setText("Modifier");
	    this.getTextField().setText(Inscription.table.get(i).getMatricule1());
	    this.getNom().setText(Inscription.table.get(i).getNom1());
	    this.getPrenom().setText(Inscription.table.get(i).getPrenom1());
	    this.getNaisance().setDate(Inscription.table.get(i).nais1);
	    this.getPays().setSelectedItem(Inscription.table.get(i).getPays1());
	    this.getList().setListData(Inscription.table.get(i).lise);
	    this.getEnregistrer().addActionListener(this);

	}




	@Override


	public void actionPerformed(ActionEvent e)
	{

		String tab1[]={"","Anglais","Architecture Des Ordinateurs","Base De Données Relationnelles","Fondements De Management","Mathematiques De Base","Outils De Mathematiques","Programmation Orientee Objet","Probabilites et Statistiques","Science De L\'information","Systemes D\'exploitation"};
        String tab2[]={"","Analyse Numerique","Anglais","Conception De Bases De Données","Management II","Programmation Orientee Objet II","Programmation Systeme","Programmation Web","Systemes Formels","Techniques De Communication"};
		if(e.getSource()==Semestre1)
		{
			liste.removeAllItems();

				for (String element : tab1)
				{
					liste.addItem(element);
				}

		}
		if(e.getSource()==Semestre2)
		{
			liste.removeAllItems();
			for (String element : tab2)
			{
				liste.addItem(element);
			}
		}

		if(e.getSource()==Effacer)
		{
			tmp.remove(tmp.size()-1);
			this.list.setListData(tmp);
		}


		if(e.getSource()==Enregistrer)
		{

			int q = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment modifier", "Confirmation", 1);

			if(q==0)
			{
				boolean flig=false;

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
				for(int j=0;j<table.size();j++)
				{

					if(Inscription.table.get(j).getMatricule1().equals(this.getTextField().getText()))
					{

						flig=true;
					}
				}

				if(flig)
				{
					JOptionPane.showMessageDialog(this,"Ce Matricule Existe Deja Veuillez Le Changer", "Duplication De Matricule",JOptionPane.OK_OPTION);
				}
				else
				{
				Inscription.table.set(modificateur,e1);

                try
                {
				FileOutputStream fichier = new FileOutputStream("projet1.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fichier);
				oos.writeObject(Inscription.table);
				oos.flush();
				oos.close();

				}
				catch (java.io.IOException e3) {
				e3.printStackTrace();
				}
                this.setVisible(false);


			}
			}
			}
		}


		if(e.getSource()==Fermer)
		{


			if(JOptionPane.showConfirmDialog(this,"Voulez vous vraiment quitter","Confirmation",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			{
				this.setVisible(false);
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
}

