/**
 *
 * @author Zafack Billy
 * Cette classe est une representation d'un etudiant sous forme d'objet
 */
public class EtudiantPrime {

	private static int index;
	private String matricule;
	private String nom;
	private String prenom;
	private String naissance;
	private String pays;
	private String lieu;

	/**
	 *
	 * @param i Son identificateur
	 * @param mat Son matricule
	 * @param nm Son nom
	 * @param prnm Son prenom
	 * @param naiss Sa date de naissance
	 * @param pys Son pays d'origine
	 * @param Son lieu de naissance
	 */
	public EtudiantPrime(int i,String mat,String nm,String prnm,String naiss,String pys,String l)
	{
		this.index=i;
		this.matricule=mat;
		this.nom=nm;
		this.prenom=prnm;
		this.naissance=naiss;
		this.pays=pys;
		this.lieu=l;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		EtudiantPrime.index = index;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNaissance() {
		return naissance;
	}

	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String uV) {
		lieu = uV;
	}


}
