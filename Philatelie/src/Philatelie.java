import java.util.ArrayList;

class Timbre {

    public static final int ANNEE_COURANTE = 2014;
    public static final int VALEUR_TIMBRE_DEFAUT = 1;
    public static final String PAYS_DEFAUT = "Suisse";
    public static final String CODE_DEFAUT = "lambda";

    public static final int BASE_1_EXEMPLAIRES = 100;
    public static final int BASE_2_EXEMPLAIRES = 1000;
    public static final double PRIX_BASE_1 = 600;
    public static final double PRIX_BASE_2 = 400;
    public static final double PRIX_BASE_3 = 50;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    private String code;
    private int annee;
    private String pays;
    private double valeur_f;
    
    public Timbre()
    {
    	this.code=CODE_DEFAUT;
    	this.annee=ANNEE_COURANTE;
    	this.pays=PAYS_DEFAUT;
    	this.valeur_f=VALEUR_TIMBRE_DEFAUT;
    }
    
    public Timbre(String code)
    {
    	this.code=code;
    	this.annee=ANNEE_COURANTE;
    	this.pays=PAYS_DEFAUT;
    	this.valeur_f=VALEUR_TIMBRE_DEFAUT;
    }
    
    public Timbre(String code,int annee)
    {
    	this.code=code;
    	this.annee=annee;
    	this.pays=PAYS_DEFAUT;
    	this.valeur_f=VALEUR_TIMBRE_DEFAUT;
    }
    
    public Timbre(String code,int annee,String pays)
    {
    	this.code=code;
    	this.annee=annee;
    	this.pays=pays;
    	this.valeur_f=VALEUR_TIMBRE_DEFAUT;
    }
    
    public Timbre(String code,int annee,String pays,double val)
    {
    	this.code=code;
    	this.annee=annee;
    	this.pays=pays;
    	this.valeur_f=val;
    }
    public double vente()
    {
    if(ANNEE_COURANTE-this.annee>=5)
    {
    	return(this.valeur_f*(ANNEE_COURANTE-this.annee)*2.5);
    }
    else
    {
    	return(this.valeur_f);
    }
    }
    
    public String toString()
    {
    	return("Timbre de code "+this.code+" datant de "+this.annee+" (provenance "+this.pays+")"+" ayant pour valeur faciale "+this.valeur_f+" francs");
    }
    
    public int age()
    {
    return ANNEE_COURANTE-this.annee;	
    }
    
    public String getCode()
    {
    	return this.code;
    }
    
    public int getAnnee()
    {
    	return this.annee;
    }
    
    public String getPays()
    {
    	return this.pays;
    }
    
    public double getValeurFaciale()
    {
    	return this.valeur_f;
    }
    
}

class Rare extends Timbre{
	
	private int exemplaires=0;

	public Rare(String code,int annee,String pays,double val,int nombre)
	{
		super(code,annee,pays,val);
		this.exemplaires=nombre;
	}
	
	public Rare(String code,int annee,String pays,int nombre)
	{
		super(code,annee,pays);
		this.exemplaires=nombre;
	}
	
	public Rare(String code,int annee,int nombre)
	{
		super(code,annee);
		this.exemplaires=nombre;
	}
	
	public Rare(String code,int nombre)
	{
		super(code);
		this.exemplaires=nombre;
	}
	
	public Rare(int nombre)
	{
		super();
		this.exemplaires=nombre;
	}
	
	public int getExemplaire()
	{
		return this.exemplaires;
	}
	
	public String toString()
	{
		return super.toString()+"\n"+"Nombre d'exemplaires -> "+this.exemplaires;
	}	
		
	public double vente()
	{
	if(this.exemplaires<BASE_1_EXEMPLAIRES)
	{
		return PRIX_BASE_1*((ANNEE_COURANTE-this.getAnnee())/10.0);
	}
	else if(this.exemplaires>=BASE_1_EXEMPLAIRES&&this.exemplaires<=BASE_2_EXEMPLAIRES)
	{
		return PRIX_BASE_2*((ANNEE_COURANTE-this.getAnnee())/10.0);
	}
	else
	{
		return PRIX_BASE_3*((ANNEE_COURANTE-this.getAnnee())/10.0);
	}
	}
	
}


class Commemoratif extends Timbre{

	public Commemoratif()
	{
		super();
	}
	
	public Commemoratif(String code)
	{
		super(code);
	}
	
	public Commemoratif(String code,int annee)
	{
		super(code,annee);
	}
	
	public Commemoratif(String code,int annee,String pays)
	{
		super(code,annee,pays);
	}
	
	public Commemoratif(String code,int annee,String pays,double val)
	{
		super(code,annee,pays,val);
	}
	
	public String toString()
	{
		return super.toString()+"\n"+"Timbre celebrant un evenement";
	}
	
	public double vente()
	{
		return 2*super.vente();
	}
	
	
}
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

class Philatelie {

    public static void main(String[] args) {

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale,
        // nombre d'exemplaires
        Rare t1 = new Rare("Guarana-4574", 1960, "Mexique", 0.2, 98);

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale
        Commemoratif t2 = new Commemoratif("700eme-501", 2002, "Suisse", 1.5);
        Timbre t3 = new Timbre("Setchuan-302", 2004, "Chine", 0.2);

        Rare t4 = new Rare("Yoddle-201", 1916, "Suisse", 0.8, 3);


        ArrayList<Timbre> collection = new ArrayList<Timbre>();

        collection.add(t1);
        collection.add(t2);
        collection.add(t3);
        collection.add(t4);

        for (Timbre timbre : collection) {
            System.out.println(timbre);
            System.out.println("Prix vente : " + timbre.vente() + " francs");
            System.out.println();
        }
    }
}

