
public class Dicor {

double tab[];
double val;

public Dicor(double tab1[],double v)
{
	this.tab=tab1;
	this.val=v;
}

public int rechercher(double tab2[],int d,int f,double v)
{
	int mil=(d+f)/2;
	if(d==f)
	{
		return -1;
	}
	else if(v==tab2[mil])
	{
		return mil+1;
	}
	else if(v<tab2[mil])
	{
		return rechercher(tab2,d,mil,v);
	}
	else
	{
		return rechercher(tab2,mil+1,f,v);
	}

}
}
