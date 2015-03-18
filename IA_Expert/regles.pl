:-use_module(library(clpfd)).

maladie(rubeole):-symptome("Fievre faible"),symptome("Peau Seche"),symptome("Ganglions"),not(symptome("Pustules")),not(symptome("Rhume")).
maladie(varicelle):-symptome("Boutons Isoles"),symptome("Boutons qui demangent"),symptome("Fievre faible"), symptome("Croute apparaissant sur pustules").
maladie(varicelle):-symptome("Boutons Isoles"),symptome("Boutons qui demangent"),symptome("Fievre faible"), symptome("Croute apparaissant sur vesicules").
maladie(rougeole):-symptome("Rhume"),symptome("Mal aux yeux"),symptome("Taches roses sur la gorge"), symptome("Boutons en taches"),symptome("Fievre forte").
maladie(scarlatine):-symptome("Amygdales rouges"),symptome("Desquamation"),symptome("Fievre forte"), symptome("Taches rouges").
