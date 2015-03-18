class Souris {

    public static final int ESPERANCE_VIE_DEFAUT = 36;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    private int poids;
    private int age=0;
    private String couleur;
    private int esperanceVie=ESPERANCE_VIE_DEFAUT;
    private boolean clonee=false;
    
    public Souris(int poids,String couleur,int age)
    {
    	this.poids=poids;
    	this.couleur=couleur;
    	this.age=age;
    	System.out.println("Une nouvelle souris !");
    }
    
    public Souris(int a,String b,int c,int d)
    {
    	this.poids=a;
    	this.couleur=b;
    	this.age=c;
    	this.esperanceVie=d;
    	System.out.println("Une nouvelle souris !");
    }
    public Souris(int poid,String couleur)
    {
    	this.poids=poid;
    	this.couleur=couleur;
    	System.out.println("Une nouvelle souris !");
    }
    
    public Souris(Souris s)
    {
    	this.age=s.age;
    	this.couleur=s.couleur;
    	this.clonee=true;
    	this.poids=s.poids;
    	this.esperanceVie=(4*s.esperanceVie)/5;
    	System.out.println("Clonage d'une souris !");
    }
    public String toString(){
    	if(this.clonee)
    	{
    		return("Une souris "+this.couleur+", clonee, "+"de "+this.age+" mois et pesant "+this.poids+" grammes");
    	}
    	else
    	{
    		return("Une souris "+this.couleur+" de "+this.age+" mois et pesant "+this.poids+" grammes");
    	}
    }
    public void viellir(){
    	this.age++;
    	if(this.age>(this.esperanceVie)/2 && this.clonee)
    	{
    		this.couleur="verte";
    	}
    }
    public void evolue(){
    	while(this.age<this.esperanceVie)
    	{
    		this.viellir();
    	}
    }
}
/*******************************************
 * Ne rien modifier après cette ligne.
 *******************************************/

public class Labo {

    public static void main(String[] args) {
        Souris s1 = new Souris(50, "blanche", 2);
        Souris s2 = new Souris(45, "grise");
        Souris s3 = new Souris(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s1.evolue();
        s2.evolue();
        s3.evolue();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
