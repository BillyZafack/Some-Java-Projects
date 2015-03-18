import java.util.Scanner;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Tirelire{
	double montant;

	double getMontant()
	{
		return this.montant;
	}
	void afficher()
	{
		if(this.getMontant()==0)
		{
			System.out.println("Vous etes sans le sous");
		}
		else
		{
			System.out.println("Vous avez : "+this.getMontant()+" euros dans votre tirelire");
		}
	}
	void secouer()
	{
		if(this.getMontant()!=0)
		{
			System.out.println("Bing bing");
		}
	}
	void remplir(double a)
	{
		if(a>=0)
		{
			this.montant=this.getMontant()+a;
		}
	}
	void vider()
	{
		this.montant=0;
	}
	void puiser(double b)
	{
		if(b>=this.getMontant())
		{
			this.vider();
		}
		else if(b>=0 && b<this.getMontant())
		{
			this.montant=this.getMontant()-b;

		}
	}
	double calculerSolde(double budget)
	{
	if(budget<=0)
	{
		return this.getMontant();
	}
	else
	{
		return this.getMontant()-budget;
	}
	}
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
public class TestTirelire {

    public static void main(String[] args) {
        Tirelire piggy = new Tirelire();

        piggy.vider();
        piggy.secouer();
        piggy.afficher();

        piggy.puiser(20.0);
        piggy.secouer();
        piggy.afficher();

        piggy.remplir(550.0);
        piggy.secouer();
        piggy.afficher();

        piggy.puiser(10.0);
        piggy.puiser(5.0);
        piggy.afficher();

        System.out.println();

        // le budget de vos vacances de rêves.
        double budget;
        Scanner clavier = new Scanner(System.in);

        System.out.println("Donnez le budget de vos vacances : ");
        budget = clavier.nextDouble();

        // ce qui resterait dans la tirelire après les
        // vacances
        double solde = piggy.calculerSolde(budget);

        if (solde >= 0) {
            System.out.print("Vous êtes assez riche pour partir en vacances !");
            System.out.print(" il vous restera " + solde + " euros");
            System.out.print(" à la rentrée \n");
            piggy.puiser(budget);
        }

        else {
            System.out.print("Il vous manque " + -solde + " euros");
            System.out.print(" pour partir en vacances !\n");
        }
    }
}
