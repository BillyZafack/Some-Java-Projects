
public class Tas {

	private int longueur;
	private int taille;
	private double[] table=new double[this.taille];

	public Tas(int l,int t,double[] tab)
	{
		int i=0;
		while(i<this.taille)
			{
			this.table[i]=tab[i];

			i++;
			}
		this.longueur=l;
		this.taille=t;
	}

	public double racine()
	{
		return this.table[1];
	}

	public int parent(int i)
	{
		if(i==1)
		{
			System.out.println("C'est la racine du tableau et n'a pas de sans parent");
		return -1;
		}
		else
		{
		return i/2;
		}
	}

	public int gauche(int i)
	{
		if(2*i<=this.taille)
		{
			return 2*i;
		}
		else
		{
			System.out.println("Il n'a pas de fils gauche");
			return -1;
		}
	}

	public void echange(double a,double b)
	{
		double temp;
		temp=a;
		a=b;
		b=temp;
	}

	public void echange(int a,int b)
	{
		int temp;
		temp=a;
		a=b;
		b=temp;
	}

	public int droit(int i)
	{
		if(2*i+1<=this.taille)
		{
			return 2*i+1;
		}
		else
		{
			System.out.println("Il n'a pas de fils droit");
			return -1;
		}
	}

	public void entasserMax(double [] d,int i)
	{
		int l=this.gauche(i);
		int r=this.droit(i);
		int max;

		if(l<this.taille && d[l]>d[i])
		{
			max=l;
		}
		else
		{
			max=i;
		}
		if(r<this.taille && d[max]<d[r])
		{
			max=r;
		}
		if(max!=i)
		{
			this.echange(max, i);
			this.entasserMax(d, max);
		}
	}

	public void entasserMin(double [] d, int i)
	{
		int min;
		int l=this.gauche(i);
		int r=this.droit(i);
		if(l<this.taille && d[l]<d[i])
		{
			min=l;
		}
		else
		{
			min=i;
		}
		if(r<this.taille && r<d[min])
		{
			min=r;
		}
		if(min!=i)
		{
			this.echange(min, i);
			this.entasserMin(d, min);
		}
	}

	public void construireMax(double [] d)
	{
		for(int i=d.length/2;i>=0;i--)
		{
			this.entasserMax(d, i);
		}
	}

	public void construireMin(double [] d)
	{
		for(int i=d.length/2;i>=0;i--)
		{
			this.entasserMin(d, i);
		}
	}

	public double[] triParTas(double[] d)
	{
		this.construireMax(d);
		for(int i=this.longueur;i>=2;i--)
		{
			this.echange(d[i], d[1]);
			this.taille--;
			this.entasserMax(d,1);
		}
		return d;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
double[] tableau={1,2,3,4,4,5,5,6,7,6,45,2,3,2,4,5,4,2,3,4,2,35,4,3,41,2,3,4,2,3,2};
	Tas t=new Tas(tableau.length,10,tableau);
	System.out.println(t.gauche(4));
	System.out.println(t.parent(1));
	System.out.println(t.racine());
	System.out.println(t.droit(11));

	}

}
