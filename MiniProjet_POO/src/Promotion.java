import java.util.Vector;


public class Promotion {


	private Vector<Etudiant> etudiants ;
	private int annee;
	private final int ANNEE_EN_COURS=2014;


	public Promotion()
	{
		this.annee=ANNEE_EN_COURS;
		 this.etudiants=new Vector<Etudiant>();
	}

	public Promotion(int an)
	{
		this.annee=an;
		this.etudiants= new Vector<Etudiant>();
	}

	public Etudiant obtenirEtudiant(int i)
	{
		return this.etudiants.get(i);
	}

	public int nombreEtudiants()
	{
		return this.etudiants.size();
	}

	public Vector<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(Vector<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}

}
