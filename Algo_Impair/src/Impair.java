
public class Impair {


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
Impair i = new Impair();
for(int i1=0;i1<400;i1++)
{
	if(i.impair(i1)==true)
	{
		System.out.println("Le nombre "+i1+" est impair");
	}
	else
	{
		System.out.println("Le nombre "+i1+" est pair");
	}
}
	}

}
