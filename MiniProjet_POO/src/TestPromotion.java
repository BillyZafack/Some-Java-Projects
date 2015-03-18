
public class TestPromotion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Etudiant e1=new Etudiant("11P001","Romes","Jules","12 Janvier 1993","Cameroun");
Etudiant e2=new Etudiant("11P002","Jones","Sam","1 Fevrier 1988","Etats-Unis");
Etudiant e3=new Etudiant("11P003","Atibita","Jores","3 Mai 1990","France");
Etudiant e4=new Etudiant("12P001","Tomfeu","Ted","2 Decembre 1987","Togo");
Etudiant e5=new Etudiant("12P002","Fommum","Jean","2 Janvier 1992","Benin");
Etudiant e6=new Etudiant("12P003","Polt","Kerry","22 Janvier 1986","Nigeria");
Etudiant e7=new Etudiant("13P001","Atangana","Pierre","14 Novembre 1991","Zambie");
Etudiant e8=new Etudiant("13P002","Nde","Garvin","23 Juillet 1995","Cameroun");
Etudiant e9=new Etudiant("14P001","Lester","Nick","9 Juin 1994","Lesotho");
Etudiant e10=new Etudiant("14P010","Seal","Jean","2 Mars 1992","Gabon");

Promotion prom_2011 = new Promotion(2011);
Promotion prom_2012 = new Promotion(2012);
Promotion prom_2013 = new Promotion(2013);
Promotion prom_2014 = new Promotion(); //Annee par defaut est 2014(annee courante)

prom_2011.getEtudiants().add(e1);
prom_2011.getEtudiants().add(e2);
prom_2011.getEtudiants().add(e3);

prom_2012.getEtudiants().add(e4);
prom_2012.getEtudiants().add(e5);
prom_2012.getEtudiants().add(e6);

prom_2013.getEtudiants().add(e7);
prom_2013.getEtudiants().add(e8);

prom_2014.getEtudiants().add(e9);
prom_2014.getEtudiants().add(e10);

for(int i=0;i<prom_2011.nombreEtudiants();i++)
{
	if(i+1!=1)
	{
	System.out.println("Le "+(i+1)+"eme etudiant de la promotion 2011 est "+prom_2011.obtenirEtudiant(i).getNom1()+" "+prom_2011.obtenirEtudiant(i).getPrenom1());
	}
	else
	{
		System.out.println("Le "+(i+1)+"er etudiant de la promotion 2011 est "+prom_2011.obtenirEtudiant(i).getNom1()+" "+prom_2011.obtenirEtudiant(i).getPrenom1());

	}
	}
for(int i=0;i<prom_2012.nombreEtudiants();i++)
{
	if(i+1!=1)
	{
	System.out.println("Le "+(i+1)+"eme etudiant de la promotion 2012 est "+prom_2012.obtenirEtudiant(i).getNom1()+" "+prom_2012.obtenirEtudiant(i).getPrenom1());
	}
	else
	{
		System.out.println("Le "+(i+1)+"er etudiant de la promotion 2012 est "+prom_2012.obtenirEtudiant(i).getNom1()+" "+prom_2012.obtenirEtudiant(i).getPrenom1());

	}
	}

for(int i=0;i<prom_2013.nombreEtudiants();i++)
{
	if(i+1!=1)
	{
	System.out.println("Le "+(i+1)+"eme etudiant de la promotion 2013 est "+prom_2013.obtenirEtudiant(i).getNom1()+" "+prom_2013.obtenirEtudiant(i).getPrenom1());
	}
	else
	{
		System.out.println("Le "+(i+1)+"er etudiant de la promotion 2013 est "+prom_2013.obtenirEtudiant(i).getNom1()+" "+prom_2013.obtenirEtudiant(i).getPrenom1());

	}

	}

for(int i=0;i<prom_2014.nombreEtudiants();i++)
{
	if(i+1!=1)
	{
	System.out.println("Le "+(i+1)+"eme etudiant de la promotion 2014 est "+prom_2014.obtenirEtudiant(i).getNom1()+" "+prom_2014.obtenirEtudiant(i).getPrenom1());
	}
	else
	{
		System.out.println("Le "+(i+1)+"er etudiant de la promotion 2013 est "+prom_2014.obtenirEtudiant(i).getNom1()+" "+prom_2014 k.obtenirEtudiant(i).getPrenom1());

	}
	}



	}

}
