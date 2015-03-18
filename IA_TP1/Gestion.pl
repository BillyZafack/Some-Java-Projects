
valeur(vrai,vrai).
valeur(faux,faux).


valeur(eqv(X,Y),V):-valeur(et(imp(X,Y),imp(Y,X)),V).
valeur(imp(X,Y),V):-valeur(ou(non(X),Y),V).

valeur(et(X,Y),V):-valeur(X,V1),valeur(Y,V2),valeur_et(V1,V2,V).
valeur(ou(X,Y),V):-valeur(X,V1),valeur(Y,V2),valeur_ou(V1,V2,V).
valeur(non(X),V):-valeur(X,V1),valeur_non(V1,V).

valeur_et(vrai,vrai,vrai).
valeur_et(faux,vrai,faux).
valeur_et(vrai,faux,faux).
valeur_et(faux,faux,faux).

valeur_ou(vrai,vrai,vrai).
valeur_ou(vrai,faux,vrai).
valeur_ou(faux,vrai,vrai).
valeur_ou(faux,faux,faux).

valeur_non(vrai,faux).
valeur_non(faux,vrai).

/*2*/
:-op(100,fy,non).
:-op(200,xfy,et).
:-op(300,xfy,ou).
:-op(400,xfy,'imp').
:-op(600,xfy,'eqv').

/*3*/

%
% S est écrit ici sous forme logique avec les expressions "non", "et" et "ou" sur P, Q et R
%

/*4*/
%member(P,[vrai,faux]), member(Q,[vrai,faux]), member(R,[vrai,faux]), valeur(S,V), V == vrai,!, M = formule_consistante.



