import java.awt.Window;
import java.io.Serializable;

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

private  String matricule1;
private String nom1;
private  String prenom1;
private String nais1;
private  String pays1;


public Etudiant(String mat1,String nm1,String prnm1,String date,String payss1)
{
	super();
	this.matricule1=mat1;
	this.nom1=nm1;
	this.prenom1=prnm1;
	this.nais1=date;
	this.pays1=payss1;
}


public void setMatricule1(String matricule1) {
	this.matricule1 = matricule1;
}

public void setNom1(String nom1) {
	this.nom1 = nom1;
}

public void setPrenom1(String prenom1) {
	this.prenom1 = prenom1;
}

public void setNais1(String nais1) {
	this.nais1 = nais1;
}

public void setPays1(String pays1) {
	this.pays1 = pays1;
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

public String getPays1() {
	return pays1;
}

}
