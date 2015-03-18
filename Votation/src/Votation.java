import java.util.ArrayList;
import java.util.Random;

/*******************************************
 * Completez le programme à partir d'ici.
 *******************************************/
class Postulant{

	private String nom;
	private double nombre_electeurs;

	public Postulant(String nom1)
	{
		this.setNom(nom1);
		this.setVotes(0);

	}

	public void elect()
	{
		this.setVotes(this.getVotes()+1);
	}

	public void init()
	{
		this.setVotes(0);
	}

	public double getVotes()
	{
		return this.nombre_electeurs;
	}

	public String getNom()
	{
		return this.nom;
	}

	public void setVotes(double d)
	{
		this.nombre_electeurs=d;
	}

	public void setNom(String nm)
	{
		this.nom=nm;
	}
}

class Scrutin{

	private ArrayList<Postulant> post=new ArrayList<Postulant>();
	private double nom_max;
	private double nom_effect;
	private int date;
	private ArrayList<Vote> votes = new ArrayList<Vote>();

	public Scrutin(ArrayList<Postulant> p,double max,int jour)
	{
		this.post=p;
		this.nom_max=max;
		this.date=jour;
		this.nom_effect=0;
	}

	public void compterVotes()
	{
		for(int i=0;i<votes.size();i++)
		{
			if(!votes.get(i).estInvalide())
			{
				votes.get(i).getPostulant().setVotes(votes.get(i).getPostulant().getVotes()+1);
			}
		}
	}
	public void simuler(double pourcent,int jour)
	{
		int v;
		v=(int) ((int)pourcent*this.nom_max);
		for(int i=0;i<this.post.size();i++)
		{
			int a=Utils.randomInt(this.post.size());
			if(i%3==0)
			{
				this.post.get(a).elect();
			}
		}
	}
	public void calculerVotants()
	{
		double s=0;
		for(int i=0;i<this.post.size();i++)
		{
			s=s+this.post.get(i).getVotes();
		}
		this.nom_effect=s;
	}

	public void init()
	{
		for(int i=0;i<this.post.size();i++)
		{
		this.post.get(i).setVotes(0);
		}
	}

	public Postulant gagnant(){
		int mx=0;
		for(int i=0;i<this.post.size();i++)
		{
			if(this.post.get(i).getVotes()<=this.post.get(i+1).getVotes())
			{
				mx=i+1;
			}

		}
		return this.post.get(mx);
	}
public void resultats()
{

	if(this.nom_effect==0)
	{
		System.out.println("Scrutin anule, pas de votants");
	}
	else
	{
		this.calculerVotants();
		System.out.format("Taux de participation -> %.lf pour cent\n",this.nom_effect*100/this.nom_max);
		System.out.format("Nombre effectif de votants -> %.lf\n",this.nom_effect);
		System.out.format("Le chef choisi est -> "+this.gagnant().getNom()+"\n");
		System.out.println("Repartition des electeurs\n");
		for(int i=0;i<this.post.size();i++)
		{
			System.out.format(this.post.get(i).getNom()+" -> %.lf pour cent des electeurs",this.post.get(i).getVotes()*100/this.nom_effect+"\n");
		}
		System.out.println("\n");
	}
}
}


abstract class Vote{

	private Postulant p;
	private int date_effect;
	private static int date_limite;

	public abstract boolean estInvalide();

	public Vote(Postulant pi,int eff,int lim)
	{
		this.p=pi;
		this.setDate_effect(eff);
		this.date_limite=lim;
	}

	public Postulant getPostulant()
	{
		return this.p;
	}

	public int getDate()
	{
		return this.getDate_effect();
	}

	public static int getDateLimite()
	{
		return date_limite;
	}

	@Override
	public String toString()
	{
		if(this.estInvalide())
		{
		return "pour "+this.p.getNom()+" -> invalide";
		}
		else
		{
			return "pour "+this.p.getNom()+" -> valide";
		}
	}

	public int getDate_effect() {
		return date_effect;
	}

	public void setDate_effect(int date_effect) {
		this.date_effect = date_effect;
	}
}


class BulletinPapier extends Vote implements checkBulletin
{

private boolean signe;

public BulletinPapier(Postulant p,int date_e,int date_l,boolean sig)
{
	super(p, date_e, date_l);
	this.signe=sig;
}
	@Override
	public boolean estInvalide()
	{
		return !checkDate();
	}

	@Override
	public boolean checkDate()
	{
		if(this.signe)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String toString()
	{
		if(this.estInvalide())
		{
			return "vote par bulletin papier pour "+this.getPostulant().getNom()+" -> invalide";
		}
		else
		{
			return "vote par bulletin pour "+this.getPostulant().getNom()+" -> valide";
		}
	}
}

class BulletinElectronique extends Vote implements checkBulletin
{
	public BulletinElectronique(Postulant pi, int eff, int lim) {
		super(pi, eff, lim);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean estInvalide()
	{
		return !checkDate();
	}
	@Override
	public String toString()
	{
		if(this.estInvalide())
		{
			return "vote electronique pour "+this.getPostulant().getNom()+" -> invalide";
		}
		else
		{
			return "vote electronique pour "+this.getPostulant().getNom()+" -> valide";
		}
	}
	@Override
	public boolean checkDate()
	{
		if(getDate()>getDateLimite()-2)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}

interface checkBulletin
{
	public boolean checkDate();
}

class BulletinCourrier extends BulletinPapier implements checkBulletin
{
	public BulletinCourrier(Postulant p, int date_e, int date_l, boolean sig) {
		super(p, date_e, date_l, sig);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean estInvalide()
	{
		return !checkDate();
	}

	@Override
	public String toString()
	{
		if(this.estInvalide())
		{
			return "envoi par courrier d'un vote par bulletin papier pour "+this.getPostulant().getNom()+" -> invalide";
		}
		else
		{
			return "envoi par courrier d'un vote par bulletin papier pour "+this.getPostulant().getNom()+" -> valide";
		}
	}
	@Override
	public boolean checkDate()
	{
		if(super.estInvalide() || getDate_effect()>getDateLimite()-2 )
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
/*******************************************
 * Ne pas modifier les parties fournies
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/

class Utils {

    private static final Random RANDOM = new Random();

    // NE PAS UTILISER CETTE METHODE DANS LES PARTIES A COMPLETER
    public static void setSeed(long seed) {
        RANDOM.setSeed(seed);
    }

    // génère un entier entre 0 et max (max non compris)
    public static int randomInt(int max) {
        return RANDOM.nextInt(max);
    }
}

/**
 * Classe pour tester la simulation
 */

class Votation {

    public static void main(String args[]) {
        // TEST 1
        System.out.println("Test partie I:");
        System.out.println("--------------");

        ArrayList<Postulant> postulants = new ArrayList<Postulant>();
        postulants.add(new Postulant("Tarek Oxlama"));
        postulants.add(new Postulant("Nicolai Tarcozi"));
        postulants.add(new Postulant("Vlad Imirboutine"));
        postulants.add(new Postulant("Angel Anerckjel"));

        postulants.get(0).elect();
        postulants.get(0).elect();

        postulants.get(1).elect();
        postulants.get(1).elect();
        postulants.get(1).elect();

        postulants.get(2).elect();

        postulants.get(3).elect();
        postulants.get(3).elect();
        postulants.get(3).elect();
        postulants.get(3).elect();

        // 30 -> nombre maximal de votants
        // 15 jour du scrutin
        Scrutin scrutin = new Scrutin(postulants, 30, 15);
        scrutin.calculerVotants();
        scrutin.resultats();

        // FIN TEST 1

        // TEST 2
        System.out.println("Test partie II:");
        System.out.println("---------------");

        scrutin = new Scrutin(postulants, 30, 15);
        scrutin.init();
        // tous les bulletins passent le check de la date
        // les parametres de simuler sont dans l'ordre:
        // le pourcentage de votants et le jour du vote
        scrutin.simuler(0.75, 12);
        scrutin.compterVotes();
        scrutin.resultats();

        scrutin = new Scrutin(postulants, 30, 15);
        scrutin.init();
        // seuls les bulletins papier non courrier passent
        scrutin.simuler(0.75, 15);
        scrutin.compterVotes();
        scrutin.resultats();

        scrutin = new Scrutin(postulants, 30, 15);
        scrutin.init();
        // les bulletins electroniques ne passent pas
        scrutin.simuler(0.75, 15);
        scrutin.compterVotes();
        scrutin.resultats();
        //FIN TEST 2

    }
}
