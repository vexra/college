color(red).
color(green).
color(blue).

% DECLARING
male(haji).
male(lex).
male(bili).
male(enggal).
male(jokowi).
male(gibran).
male(bobby).
male(kaesang).
male(ethes).
male(nahyan).

female(hajah).
female(sedah).
female(kahiyang).
female(selvi).
female(iriana).

% RELATION
parent(haji, lex).
parent(haji, bili).
parent(haji, enggal).
parent(hajah, lex).
parent(hajah, bili).
parent(hajah, enggal).

parent(iriana, gibran).
parent(jokowi, gibran).
parent(iriana, bobby).
parent(jokowi, bobby).
parent(iriana, kaesang).
parent(jokowi, kaesang).
parent(gibran, ethes).
parent(selvi, ethes).
parent(kahiyang, sedah).
parent(bobby, sedah).
parent(kahiyang, nahyan).
parent(bobby, nahyan).

% RULES
father(X, Y):- parent(X, Y), male(X).
mother(X, Y):- parent(X, Y), female(X).
grandfather(X, Z):- parent(X, Y), parent(Y, Z), male(X).
grandmother(X, Z):- parent(X, Y), parent(Y, Z), female(X).
husband(X, Y):- male(X), female(Y), parent(X, Z), parent(Y, Z).
wife(X, Y):- female(X), male(Y), parent(X, Z), parent(Y, Z).
sister(X, Y):- female(X), parent(Z, X), parent(Z, Y), X \= Y.
brother(X, Y):- male(X), parent(Z, X), parent(Z, Y), X \= Y.
uncle(X, Y):- male(X), parent(Z, Y), brother(X, Z).
