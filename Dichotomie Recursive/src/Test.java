
public class Test {
public static void main(String[] args)
{
	double[] tab={1,2,3,4,15,16,27,38,99};
	Dicor dic= new Dicor(tab,3);
	int x=dic.rechercher(tab, 0, tab.length, dic.val);
	if(x==-1)
	{
		System.out.println("Le nombre "+dic.val+" n'est pas dans le tableau");
	}
	else
	{
		System.out.println("Le nombre "+dic.val+" est dans le tableau a l'indice "+x);
	}
}
}
