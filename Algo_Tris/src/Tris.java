
public class Tris {

	private double[] d;
	private int n=d.length;

	public Tris(double [] e,int w)
	{
		this.d=e;
		this.n=w;
	}
/*
 * Codage des differents Tris, Selection,Insertion,Bulles,Fusion,Shell
 * en recursive et iterative.
 */

	public void echanger(double a,double b)
	{
		double c;
		c=a;
		a=b;
		b=c;
	}

	public double[] insertionIterative(double [] d)
	{
		double aux;
		int j;
		for(int i=1;i<d.length;i++)
		{
			aux=d[i];
			j=i;
			while(j>=0 && d[j]>aux)
			{
				d[j]=d[j-1];
				j--;
			}
			d[j]=aux;
		}
		return d;
	}

	public void insertionRecursive(int n)
	{
		double aux;
		int j=n;
		if(n>0)
		{
			this.insertionRecursive(n-1);
			aux=this.d[n];
			while(j>=0 && this.d[j]>aux)
			{
				this.d[j]=this.d[j-1];
				j--;
			}
			this.d[j]=aux;
		}
	}

	public double[] selectionIterative(double[] d)
	{
		double aux;
		for(int i=0;i<n-2;i++)
		{
			aux=d[i];
			for(int j=i+1;i<n-1;i++)
			{
				if(d[j]>aux)
				{
					aux=d[j];
				}
			}
			if(aux!=d[i])
			{
			this.echanger(d[i], aux);
			}
		}
		return d;
	}

	public double[] bullesIterative(double[] d)
	{
		for(int i=d.length;i>=0)
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
