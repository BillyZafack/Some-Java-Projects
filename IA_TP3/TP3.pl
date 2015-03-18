:-use_module(library(clpfd)).

positionEsp(X,L):-X=[0,A,B,C,D,E,F,G,H],L=1.
positionEsp(X,L):-X=[A,0,B,C,D,E,F,G,H],L=2.
positionEsp(X,L):-X=[A,B,0,C,D,E,F,G,H],L=3.
positionEsp(X,L):-X=[A,B,C,0,D,E,F,G,H],L=4.
positionEsp(X,L):-X=[A,B,C,D,0,E,F,G,H],L=5.
positionEsp(X,L):-X=[A,B,C,D,E,0,F,G,H],L=6.
positionEsp(X,L):-X=[A,B,C,D,E,F,0,G,H],L=7.
positionEsp(X,L):-X=[A,B,C,D,E,F,G,0,H],L=8.
positionEsp(X,L):-X=[A,B,C,D,E,F,G,H,0],L=9.

gauche(X,Y,1):-X=[0,A,B,C,D,E,F,G,H],Y=[A,0,B,C,D,E,F,G,H].
gauche(X,Y,2):-X=[A,0,B,C,D,E,F,G,H],Y=[A,B,0,C,D,E,F,G,H].
gauche(X,Y,4):-X=[A,B,C,0,D,E,F,G,H],Y=[A,B,C,D,0,E,F,G,H].
gauche(X,Y,5):-X=[A,B,C,D,0,E,F,G,H],Y=[A,B,C,D,E,0,F,G,H].
gauche(X,Y,7):-X=[A,B,C,D,E,F,0,G,H],Y=[A,B,C,D,E,F,G,0,H].
gauche(X,Y,8):-X=[0,A,B,C,D,E,F,G,H],Y=[A,0,B,C,D,E,F,G,H].

arriver([0,1,2,3,4,5,6,7,8]).

droit(X,Y,2):-X=[A,0,B,C,D,E,F,G,H],Y=[0,A,B,C,D,E,F,G,H].
droit(X,Y,3):-X=[A,B,0,C,D,E,F,G,H],Y=[A,0,B,C,D,E,F,G,H].
droit(X,Y,5):-X=[A,B,C,D,0,E,F,G,H],Y=[A,B,C,0,D,E,F,G,H].
droit(X,Y,6):-X=[A,B,C,D,E,0,F,G,H],Y=[A,B,C,D,0,E,F,G,H].
droit(X,Y,8):-X=[A,B,C,D,E,F,G,0,H],Y=[A,B,C,D,E,F,0,G,H].
droit(X,Y,9):-X=[A,B,C,D,E,F,G,H,0],Y=[A,B,C,D,E,F,G,0,H].


haut(X,Y,4):-X=[A,B,C,0,D,E,F,G,H],Y=[A,B,C,F,D,E,0,G,H].
haut(X,Y,2):-X=[A,0,B,C,D,E,F,G,H],Y=[A,D,B,C,0,E,F,G,H].
haut(X,Y,3):-X=[A,B,0,C,D,E,F,G,H],Y=[A,B,E,C,D,0,F,G,H].
haut(X,Y,1):-X=[0,A,B,C,D,E,F,G,H],Y=[C,A,B,0,D,E,F,G,H].
haut(X,Y,5):-X=[A,B,C,D,0,E,F,G,H],Y=[A,B,C,D,G,E,F,0,H].
haut(X,Y,6):-X=[A,B,C,D,E,0,F,G,H],Y=[A,B,C,D,E,H,F,G,0].

bas(X,Y,4):-X=[A,B,C,0,D,E,F,G,H],Y=[0,B,C,A,D,E,F,G,H].
bas(X,Y,5):-X=[A,B,C,D,0,E,F,G,H],Y=[A,0,C,D,B,E,F,G,H].
bas(X,Y,6):-X=[A,B,C,D,E,0,F,G,H],Y=[A,B,0,D,E,C,F,G,H].
bas(X,Y,7):-X=[A,B,C,D,E,F,0,G,H],Y=[A,B,C,0,E,F,D,G,H].
bas(X,Y,8):-X=[A,B,C,D,E,F,G,0,H],Y=[A,B,C,D,0,F,G,E,H].
bas(X,Y,9):-X=[A,B,C,D,E,F,G,H,0],Y=[A,B,C,D,E,0,G,H,F].

% chemin(A,B,D):-chemin(A,C),Y1 ins
% [1,2,4,5,7,8],gauche(C,B,Y1),D=[B|C];chemin(A,C),Y2 ins
% [1,2,3,4,5,6],haut(C,B,Y2);chemin(A,C),Y3 ins
% [4,5,6,7,8,9],bas(C,B,Y3);chemin(A,C),Y4 ins
% [2,3,5,6,8,9],droit(C,B,Y4).

% Reflexion No 1 Parcours en Profondeur Prolog
chemin(Init,Init1,L1):-L1=[Init],s(Init,Init1,1).
chemin(Init,Fini,Liste):-s(C,Fini,1),append(L1,C,Liste),chemin(Init,C,L1).

valeur_test(X) :-  X= [3,4,0,5,1,2,8,6,7].
but(X):-arriver(X).

arbre(valeur_test(X),A):-A=[eval(valeur_test(X)),gauche(valeur_test(X),Y,3),haut(valeur_test(X),M,3)].

goal(X):-but(X).

s(X,Y,1):-gauche(X,Y,1);gauche(X,Y,2);gauche(X,Y,4);gauche(X,Y,5);gauche(X,Y,7);gauche(X,Y,8);droit(X,Y,2);droit(X,Y,3);droit(X,Y,5);droit(X,Y,6);droit(X,Y,8);droit(X,Y,9);haut(X,Y,1);haut(X,Y,2);haut(X,Y,3);haut(X,Y,4);haut(X,Y,5);haut(X,Y,6);bas(X,Y,4);bas(X,Y,5);bas(X,Y,6);bas(X,Y,7);bas(X,Y,8);bas(X,Y,9).

expand([Node | Path], ExpandedPaths) :-bagof([Node1, Node | Path],
(s(Node, Node1,1), \+ member(Node1, Path)),
ExpandedPaths).

%% breadth_first_search(+Node, -Path)
breadth_first_search(Node, Path) :-bf_search_aux([[Node]], Path).
bf_search_aux([[Node | Path] | _], [Node | Path]) :-goal(Node).

bf_search_aux([CurrentPath | NextPaths],
FinalPath) :-expand(CurrentPath, ExpandedPaths),
append(NextPaths, ExpandedPaths, NewPaths),
bf_search_aux(NewPaths, FinalPath).

expand([Node | Path], ExpandedPaths) :-bagof(
[Node1, Node | Path],
(s(Node, Node1,1), \+ member(Node1, Path)),
ExpandedPaths),
!.

expand(Path, []).

breadth_first([[Goal|Path]|_],Goal,[Goal|Path],0).
breadth_first([Path|Queue],Goal,FinalPath,N) :-
    extend(Path,NewPaths),
    append(Queue,NewPaths,NewQueue),
    breadth_first(NewQueue,Goal,FinalPath,M),
    N is M+1.



hh(State, Value) :-
    h(State,Value),
    number(Value), !.
hh(State, Value) :-
   write('Incorrect heuristic functionh: '),
   write(h(State, Value)), nl,
   abort.
h(_,1).  % default value (must be redefined for each problem)
f([X|T],F) :-                   % for A* search
    reverse_path_cost([X|T],G), % calculate G
    hh(X,H),                    % calculate H
    F is G+H.                   % F = G + H

reverse_path_cost([A,B],Cost) :-
    s(B,A,Cost).
reverse_path_cost([A,B|T],Cost) :-
    s(B,A,Cost1),
    reverse_path_cost([B|T],Cost2),
    Cost is Cost1+Cost2.

extend([Node|Path],NewPaths) :-
    findall([NewNode,Node|Path],
            (s(Node,NewNode,1),
            \+ member(NewNode,Path)), % for avoiding loops
            NewPaths).

a_star([[Goal|Path]|_],Goal,[Goal|Path],0).
a_star([Path|Queue],Goal,FinalPath,N) :-
    extend(Path,NewPaths),
    append(Queue,NewPaths,Queue1),
    sort_queue2(Queue1,NewQueue),wrq(NewQueue),
    a_star(NewQueue,Goal,FinalPath,M),
    N is M+1.

sort_queue2(L,L2) :-
    swap2(L,L1), !,
    sort_queue2(L1,L2).
sort_queue2(L,L).

swap2([X,Y|T],[Y,X|T]) :-
    f(X,DX),
    f(Y,DY),
    DX>DY.
swap2([X|T],[X|V]) :-
    swap2(T,V).

wrq(Q) :- length(Q,N), writeln(N).
















