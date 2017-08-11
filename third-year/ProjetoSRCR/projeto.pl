% SICStus PROLOG: Declaracoes iniciais

:- set_prolog_flag( discontiguous_warnings,off ).
:- set_prolog_flag( single_var_warnings,off ).
:- set_prolog_flag( unknown,fail ).

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% SICStus PROLOG: definicoes iniciais

:- op( 900,xfy,'::' ).

% automovel(Matricula, Marca, Modelo, Cor, Estado, Ano, Registo/Dono)
:- dynamic automovel/7.

%exemplos


% Automóveis com informação completa
automovel('11-AA-11','Audi','A4','Preto',10,2014,'António Moças').
automovel('16-KB-11','Citroen','AX','Preto',3,1987,'João Carlos').

% Automóveis em que não se sabe a data de fabrico, nem nunca se poderá saber.
automovel('98-CV-32','Ford','Corcel','Vermelho',4,impossibru,'Berta').
automovel('56-FG-89','Fiat','Uno','Bege',2,impossibru,'Rui Gomes').

% Automóvel ou é do Castro ou do Destro.
excecao(automovel('22-BB-33','Opel','Corsa','Azul',7,1999,'Castro')).
excecao(automovel('22-BB-33','Opel','Corsa','Azul',7,1999,'Destro')).

% Automóvel que não se sabe o dono.
automovel('48-PP-41','Mercedes','Benz','Cinzento',7,2000,unknown).
automovel('85-TM-94','Volvo','S60','Cinzento',9,2011,unknown).

% Automóvel em que a data de fabrico está entre 1980 e 1990.
excecao( automovel('56-PG-37','Chevrolet','Classic','Bege',6,ANO,'António Moças')):- ANO >= 1980, ANO =< 1990.

% Não se conhece o dono do automóvel com matricula "15-RW-09", mas sabe-se que
% não é o "Filipe Amaro", nem a "Adriana Flor".
-automovel('15-RW-09','Honda','Civic','Azul',9,2012,'Filipe Amaro').
-automovel('15-RW-09','Honda','Civic','Azul',9,2012,'Adriana Flor').
automovel('15-RW-09','Honda','Civic','Azul',9,2012,unknown).

% Sabe-se que o carro conduzido por "Joana Sousa" é:
% um Kia Carens ou um Kia Cadenza
excecao(automovel('15-OF-67','Kia','Carens','Verde',5,2001,'Joana Sousa')).
excecao(automovel('15-OF-67','Kia','Cardenza','Verde',5,2001,'Joana Sousa')).

% --------------------------------------------------------------------------

% Definir como exceção os veículos que não têm data de fabrico .
excecao( automovel( A,B,C,D,E,F,G ) ) :-
    automovel( A,B,C,D,E,impossibru,G ).

% Definir como exceção os veículos que não se sabe o dono.
excecao( automovel( A,B,C,D,E,F,G ) ) :-
    automovel( A,B,C,D,E,F,unknown ).

nulo( impossibru).

-automovel(A,B,C,D,F,G,H) :-
    nao( automovel(A,B,C,D,F,G,H) ),
    nao( excecao( automovel(A,B,C,D,F,G,H) ) ).

% não deixar adicionar data de fabrico a alguns automóveis
+automovel(A,B,C,D,F,G,H) :: (
      solucoes( (ANO),(automovel('98-CV-32','Ford','Corcel','Vermelho',4,ANO,'Berta'),nao(nulo(ANO))),S ),
      comprimento( S,N ),
      N == 0).

+automovel(A,B,C,D,F,G,H) :: (
      solucoes( (ANO),(automovel('56-FG-89','Fiat','Uno','Bege',2,ANO,'Rui Gomes'),nao(nulo(ANO))),S ),
      comprimento( S,N ),
      N == 0).

% Não podem haver dois automóveis com matriculas iguais.
+automovel(Matricula,_,_,_,_,_,_) :: (
    solucoes(Mat,automovel(Matricula,_,_,_,_,_,_),S),
    comprimento( S,N ),
    N == 1).

% Todos os automoveis têm que ter um estado de conservação entre 1 e 10.
+automovel(_,_,_,_,Estado,_,_) :: (
    number(Estado),
    Estado =< 10,
    Estado >= 1).

% Todos os automoveis têm que ter no ano um numero inteiro
+automovel(_,_,_,_,_,Ano,_) :: (
    number(Ano)).

% Não permitir adicionar mais do que um automóvel igual - Substituído pelo
%invariante que não permite matriculas iguais.
%+automovel(A,B,C,D,E,F,G) :: (solucoes( (A,B,C,D,E,F,G),automovel(A,B,C,D,E,F,G),S),
%                  comprimento( S,N ), N == 1
%                  ).

% substitui o termovelho pelo novo termo, restaura as alteraçoes caso
% o novo termo viole os invariantes
substituir( automovel(Av,Bv,Cv,Dv,Ev,Fv,Gv) , automovel(A,B,C,D,E,F,G)) :-
    automovel(Av,Bv,Cv,Dv,Ev,Fv,Gv), %se nao existir o termo velho, nao podemos continuar
    remove( automovel(Av,Bv,Cv,Dv,Ev,Fv,Gv) ),
    adicionar( automovel(A,B,C,D,E,F,G) ).

remove( Termo ) :-
    retract( Termo ).
remove( Termo ) :-
    assert( Termo ),!,fail.

adicionar( automovel(A,B,C,D,E,F,G) ) :-
    solucoes( Invariante,+automovel(A,B,C,D,E,F,G)::Invariante,Lista ),
    inserir( automovel(A,B,C,D,E,F,G) ),
    teste( Lista ).

inserir( Termo ) :-
    assert( Termo ).
inserir( Termo ) :-
    retract( Termo ),!,fail.

teste( [] ).
teste( [R|LR] ) :-
    R,
    teste( LR ).

demo([],_).

%demo conjunção

%resposta é verdadeira se todas as questoes tambem o forem
demo([Questao|Questoes],verdadeiro) :-
    Questao,
    demo(Questoes,verdadeiro).

%uma questão que seja falsa torna a resposta falsa
demo([Questao|Questoes],falso) :-
    -Questao, !.

%uma questão cuja valor de verdade seja desconhecido torna a resposta desconhecida
demo([Questao|Questoes],desconhecido) :-
    nao( Questao ),
    nao( -Questao ), !.

nao( Questao ) :-
    Questao, !, fail.
nao( Questao ).

solucoes( X,Y,Z ) :-
    findall( X,Y,Z ).

comprimento( S,N ) :-
    length( S,N ).
