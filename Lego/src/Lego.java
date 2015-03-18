import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Piece{
	
	private String nom;
	
	public Piece(String nm)
	{
		this.nom=nm;
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	public String toString()
	{
		return this.nom;
	}
}


class Composant
{
	
	private Piece piece;
	private int quantite;
	
	public Composant(Piece p,int qte)
	{
		this.piece=p;
		this.quantite=qte;
	}
	
	public Piece getPiece()
	{
		return this.piece;
	}
	
	public int getQuantite()
	{
		return this.quantite;
	}
}
	
	class Simple extends Piece
	{
		private String orientation;
		
		public Simple(String nm,String or)
		{
			super(nm);
			this.orientation=or;
		}
		
		public Simple(String nm)
		{
			super(nm);
			this.orientation="aucune";
		}
		
		public String getOrientation()
		{
			return this.orientation;
		}
		
		public String toString()
		{
			if(this.orientation!="aucune")
			{
			return super.toString()+" "+this.orientation;
			}
			else
			{
				return super.toString();
			}
		}
	}


class Composee extends Piece
{
	private ArrayList<Piece> liste=new ArrayList<Piece>();
	private int maximum;
	
	public Composee(String nm,int max)
	{
		super(nm);
		this.maximum=max;
	}
	
	public int taille()
	{
		return this.liste.size();
	}
	
	public int tailleMax()
	{
		return this.maximum;
	}
	
	public void construire(Piece piece)
	{
		if(this.liste.size()<this.maximum)
		{
		this.liste.add(piece);
		}
		else
		{
			System.out.println("Construction impossible");
		}
	}
	
	public String toString()
	{
		String des="";
		for(int i=0;i<this.liste.size();i++)
		{
			des=des+this.liste.get(i).toString()+",";
		}
		des=des.substring(0,des.length()-1);
		return super.toString()+" "+"("+des+")";
	}
	
}

class Construction
{
	private ArrayList<Composant> list=new ArrayList<Composant>();
	private int max;
	
	public Construction(int m)
	{
		this.max=m;
	}
	
	public int taille()
	{
		return this.list.size();
	}
	
	public int tailleMax()
	{
		return this.max;
	}
	
	public void ajouterComposant(Piece p,int i)
	{
		Composant com=new Composant(p,i);
		if(this.list.size()<this.max)
		{
		this.list.add(com);
		}
		else
		{
			System.out.println("Ajout de composant impossible");
		}
	}
	public String toString()
	{
		String desc="";
		for(int i=0;i<this.list.size();i++)
		{
			desc=desc+this.list.get(i).getPiece().toString()+" (quantite "+this.list.get(i).getQuantite()+")"+"\n";
		}
		return desc;
	}
}
/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/

class Lego {

    public static void main(String[] args) {
        // declare un jeu de construction de 10 pieces
        Construction maison = new Construction(10);

        // ce jeu a pour premier composant: 59 briques standard
        // une brique standard a par defaut "aucune" comme orientation
        maison.ajouterComposant(new Simple("brique standard"), 59);

        // declare une piece dont le nom est "porte", composee de 2 autres pieces
        Composee porte = new Composee("porte", 2);

        // cette piece composee est constituee de deux pieces simples:
        // un cadran de porte orient'e a gauche
        // un battant orient'e a gauche
        porte.construire(new Simple("cadran porte", "gauche"));
        porte.construire(new Simple("battant", "gauche"));

        // le jeu a pour second composant: 1 porte
        maison.ajouterComposant(porte, 1);

        // déclare une piece composee de 3 autres pieces dont le nom est "fenetre"
        Composee fenetre = new Composee("fenetre", 3);

        // cette piece composee est constitu'ee des trois pieces simples:
        // un cadran de fenetre (aucune orientation)
        // un volet orient'e a gauche
        // un volet orient'e a droite
        fenetre.construire(new Simple("cadran fenetre"));
        fenetre.construire(new Simple("volet", "gauche"));
        fenetre.construire(new Simple("volet", "droit"));

        // le jeu a pour troisieme composant: 2 fenetres
        maison.ajouterComposant(fenetre, 2);

        // affiche tous les composants composants (nom de la piece et quantit'e)
        // pour les pieces compos'ees : affiche aussi chaque piece les constituant
        System.out.println("Affichage du jeu de construction : ");
        System.out.println(maison);
    }
}
