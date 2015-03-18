import java.util.Scanner;

public class Dico {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entrer la taille du tableau :\n");
		int u = sc.nextInt();
		double Tab[] = new double[u];
		System.out.println("Veuillez remplir le tableau :\n");
		for (int i = 0; i < u; i++) {
			System.out.println("Entrez l'element " + (i + 1));
			Tab[i] = sc.nextDouble();
		}
		System.out.println("Entrez la valeur a rechercher :\n");
		double v = sc.nextDouble();
		Dico dic = new Dico(Tab, v);
		int w = dic.Recherche(Tab, v);
		if (w != -1) {
			System.out.println("Le nombre " + v
					+ " est dans le tableau a l'indice numero " + w);
		} else {
			System.out.println("Le nombre " + v + " n'estpas dans le tableau");
		}

	}

	double Table[];

	double x;

	public Dico(double Table[], double y) {
		this.Table = Table;
		x = y;
	}

	public int Recherche(double Tab[], double y) {
		int a = 1;
		int b = Tab.length;
		int mil, val = -1;
		while (a <= b) {
			mil = (a + b) / 2;
			if (y == Tab[mil]) {
				val = mil;
			} else if (y < Tab[mil]) {
				a = mil - 1;
			} else {
				b = mil + 1;
			}
		}
		return val;
	}

}
