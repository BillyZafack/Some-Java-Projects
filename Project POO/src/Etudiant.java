import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import javax.swing.JList;

/**
 *
 * @author Zafack Billy
 * @version 1.0
 * La Classe Etudiant de mon projet qui implemente l'interface {@link java.io.Serializable}
 * Cette classe est l'equivalent d'un etudiant physique et contient tout les champs remplis dans le questionnaire d'inscription
 * @see Window
 * @see Inscription
 * @see Consult
 * @see Modification
 */
public class Etudiant implements Serializable {

private final String matricule1;
private final String nom1;
private final String prenom1;
Date nais1;
private final String pays1;
private  String sexe;
private  String Langues;
public Vector<String> lise=new Vector<String>();
private final JList uv=new JList();


public Etudiant(String mat1,String nm1,String prnm1,Date date,String payss1,String sx,String Langue,Vector<String> uv1)
{
	super();
	this.matricule1=mat1;
	this.nom1=nm1;
	this.prenom1=prnm1;
	this.nais1=date;
	this.pays1=payss1;
	this.sexe=sx;
	this.Langues=Langue;
    this.lise=uv1;

}
public String getSexe() {
	return sexe;
}

public void setSex(String sex) {
	this.sexe = sex;
}

public String getLangues() {
	return Langues;
}

public void setLangues(String langues) {
	Langues = langues;
}

public Vector<String> getLise() {
	return lise;
}

public void setLise(Vector<String> lise) {
	this.lise = lise;
}

public void setNais1(Date nais1) {
	this.nais1 = nais1;
}

public String getMatricule1() {
	return matricule1;
}
public String getNom1() {
	return nom1;
}
public String getPrenom1() {
	return prenom1;
}
public Date getNais1() {
	return nais1;
}
public String getPays1() {
	return pays1;
}
public JList getUv() {
	return uv;
}
}
