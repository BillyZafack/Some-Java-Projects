:-use_module(library(clpfd)).

/*
nieme_choix_de_Etd(Rang, Etd, Dept) tous sont des entiers  : se lit le Rangieme choix de l'etudiant Etd est le departement numero Dept.
*/
 	 dynamic(prefereEtdDept,3).
	 dynamic(prefereDeptEtd,3).
	 
/* nieme_du_dept(Rang, Dept, Etd) tous sont des entiers : se lit le Rangieme du departement numero Dept est l'Etudiant numero Etd*/


	 pref_Etd(Ed, Di, Dj) :- prefereEtdDept(Ri, Ed, Di), prefereEtdDept(Rj, Ed, Dj), Ri < Rj.
	
	 pref_Dept(Dd, Ei, Ej) :- prefereDeptEtd(Ri, Dd, Ei), prefereDeptEtd(Rj, Dd, Ej), Ri < Rj.

	 
	 
/*Manipulation des listes */

	nieme_liste(1, T, [T|_]).
	nieme_liste(N, X, [_|L]) :- nieme_liste(M,X,L),  N is M + 1.

	
	
	longueur(0, []).
	longueur(N, [_|Q]) :- longueur(M, Q),  N is (M + 1).

	premier(X, [X|_]).

	dernier(X, [X]).
	dernier(X, [_|Q]) :- dernier(X, Q).	



/* stabilité nombre d'etudiants par departement.
	pour compter le nombre d'etudiants par departement on utilise le predicat nbrEtdACeDept et puis on verifie les bornes.
 */
	
	ceDeptEntre( Dlist, Dd, Nmin, Nmax)    :-  nbrEtdACeDept(Dlist, Dd, Ncontient),      Ncontient > Nmin-1,        Ncontient < Nmax+1.
	
	
	tousDeptEntre(_,  [],  _,  _).
	
/* 
pour chaque departement ettiquete par son numero on verifie si il est dans les bornes des effectives. Dlist est la repartition des departement pour 	tous  les etudiants et [Di|Ds] represente les differents departements repetes ou pas mais la totalité est requise. s'il y a 1 et 2 [Di|Ds] peut = [1,2,2].
	
 */
	tousDeptEntre( Dlist,[Di|Ds], Nmin, Nmax) :-  ceDeptEntre(Dlist, Di, Nmin, Nmax),   tousDeptEntre(Dlist, Ds, Nmin, Nmax).

	



/*Pour compter : si un departement est en tete de la repartition son effectif augmente +1 sinon de +0. puis on calcule pour le reste de la liste
	Tous les departements ont 0 pour une liste de repartition vide.
*/

	nbrEtdACeDept([], _, 0).

	nbrEtdACeDept([Dh|Dt], Dh, Nbr) :- nbrEtdACeDept(Dt, Dh, Nbr2),      Nbr is 1 + Nbr2.

	nbrEtdACeDept([Dd|Dt], Dh, Nbr) :- nbrEtdACeDept(Dt, Dh, Nbr),       Dh \== Dd.



/* Ici Ei pref Dj à Di et Dj pref Ei à Ej. Ej etant en Dj : donc instabilité est TRUE */

	instable(Ei, Ld) :- nieme_liste(Ei, Di, Ld),   pref_Etd(Ei, Dj, Di),  pref_Dept(Dj, Ei, Ej), nieme_liste(Ej, Dj, Ld).
	
	/* ici Ei pref Dj à Di et Ej est à Dj, Ei et Ej sont esquo dans Dj mais Ei pref plus Di que Dj : alors instabilité est TRUE */
	instable(Ei, Ld) :- nieme_liste(Ei, Di, Ld),   pref_Etd(Ei, Dj, Di),  prefereDeptEtd(Ri, Dj, Ei), prefereDeptEtd(Rj, Dj, Ej), Ri == Rj, nieme_liste(Ej, Dj, Ld), prefereEtdDept(Choixi, Ei, Dj), prefereEtdDept(Choixj, Ej, Dj), Choixi < Choixj.
	
	/* Pour chaque etudiant on verifie si leur position est stable (ie non instable, car la stabilité est plus complexe) avec le predicat instable qui est vrai si c'est instable est faux sinon. Par défaut une liste vide est stable. stable renvoie TRUE si personne n'est instable*/
	
	
	stable([],_).

	stable([Et|Es], Ld) :-  not(instable(Et, Ld)),stable(Es, Ld).

	
/* Ensuite la requete a pose pour resoudre un probleme de repartition de departement : 
	 Rmq : on met le label avant les contraintes de resolutions
	 Ld : contient la liste des departements de chaque etudiant soit [D1, D2, D3, D4, D5, ... , D10], 10 s'il y a 10 etudiants.
	 Ed : c'est la liste des numeros des etudiants soit [1, 2, 3, 4, ... , 10] comme il y en a 10
	 Dd : c'est la liste des numeros des departements soit [1, 2, 3] s'il y en a 3. ainsi chaque élément de Ld prend ses valeurs dans Dd
	 Borne : est une liste de 2 éléments Min et Max pour chaque departemet normalement Min = E(10 div 3) et Min = E(10 div 3) + 1
	 On pose une question ainsi : pour 4 etds, 2 depts et min = max = 2.
	 Ld = [D1, D2, D3, D4], repartition(Ld, [1,2,3,4], [1,2], [2,2]).
*/ 
	
repartition(Ld, Ed, Dd, [Min, Max]) :-  premier(Dd1, Dd),       dernier(Dd2, Dd),       Ld ins Dd1..Dd2,       label(Ld),               stable(Ed,Ld),        tousDeptEntre(Ld, Dd, Min, Max).	



