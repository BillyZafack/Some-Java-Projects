import java.util.Scanner;

class Parachutiste {

	private static Scanner clavier = new Scanner(System.in);

	public static void main(String[] args) {

		double masse = 80.0;
		do {
			System.out.print("masse du parachutiste (>= 40) ? ");
			masse = clavier.nextDouble();
		} while (masse < 40.0);

		double h0 = 39000.0;
		do {
			System.out.print("hauteur de depart du parachutiste (>= 250) ? ");
			h0 = clavier.nextInt();
		} while (h0 < 250.0);

		/*******************************************
		 * Completez le programme a partir d'ici.
		 *******************************************/
		final double g=9.81;
		double t0=0;
		double surface=2.0;
		double v0=0;
		double vitesse=v0;
		double hauteur=h0;
		double accel=g;
		double t=t0;
		System.out.format("%.0f, %.4f, %.4f, %.5f\n",
				t, hauteur, vitesse, accel);
		double s=surface/masse;
		t++;
		double q=Math.exp(-s*(t-t0));
		vitesse=g/s*(1-q)+v0*q;
		hauteur=h0-g/s*(t-t0)-(v0-g/s)/s*(1-q);
		accel=g-s*vitesse;
		boolean b1=true,b2=true,b3=true;
		do
		{

			if(vitesse>343 && b1)
			{
				System.out.println("## Felix depasse la vitesse du son");
				b1=false;
			}
			if(accel<0.5 && b2)
			{
				System.out.println("## Felix a atteint sa vitesse maximale");
				b2=false;
			}
			if(hauteur<2500 && b3)
			{
				System.out.println("## Felix ouvre son parachute");
				surface=25;
				s=surface/masse;
				v0=vitesse;
				h0=hauteur;
				t0=t;
				b3=false;

			}
			System.out.format("%.0f, %.4f, %.4f, %.5f\n",
					t, hauteur, vitesse, accel);
			t++;
			q=Math.exp(-s*(t-t0));
			vitesse=g/s*(1-q)+v0*q;
			hauteur=h0-g/s*(t-t0)-(v0-g/s)/s*(1-q);
			accel=g-s*vitesse;

		}
		while(hauteur>0);


		/*******************************************
		 * Ne rien modifier apres cette ligne.
		 *******************************************/

	}
}
