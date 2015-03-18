
public class Pair {

	public boolean impair(int n)
	{
		if(n==0)
		{
			return false;
		}
		else
		{
			return pair(n-1);
		}
	}

	public boolean pair(int n)
	{
		if(n==0)
		{
			return true;
		}
		else
		{
			return impair(n-1);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair p=new Pair();
for(int i=0;i<209;i++)
{
	if(p.pair(i)==true)
	{
	System.out.println("Le nombre "+i+" est pair");
	}
	else
	{
		System.out.println("Le nombre "+i+" est impair");
	}
}
	}

}
