:- use_module(library(clpfd)).

choix([D1,D2,D3,D4,D5,D6]) :-Vars = [D1,D2,D3,D4,D5,D6],Dept = ["GI","GC","GET","GTEL","GM","GIND"],
Etd = ["E1","E2","E3","E4","E5","E6"]
Vars ins Dept,
all_different(Vars),
prefere(X,Y,Z),
A ins Etd,B ins Dept,C ins Dept,D ins Etd,
not(prefere(A,B,C)#/\prefere(B,A,D)).
