or(P,Q):-P,Q.
and(P,Q):-P,Q.
imply(P,Q):-not(P);Q.
equivalente(P,Q):-implique(P,Q),implique(Q,P).
p(a).
op(+200,+yf,:non).
op(300,yfx,et).
op(400,yfx,ou).
op(500,yfx,implique).
op(600,yfx,equivalent).
nonP:-not(P).
PetQ:-and(P,Q).
PouQ:-or(P,Q).
PimpliqueQ:-imply(P,Q).
PequivalentQ:-equivalente(P,Q);