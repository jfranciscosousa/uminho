%{
#include <stdio.h>
#include <string.h>
#include "libs/auxiliar.c"
#include "libs/btree.h"

BTree noms = NULL; //nomes
BTree locs = NULL; //locais
BTree orgs = NULL; //organizações

%}


%s nome
%s localidade
%s organizacao
%%
"<ENAMEX TYPE=\"PERSON\">"               BEGIN nome;
<nome>[^\n<]+                            {noms = bt_insert(noms, trim(yytext));}
"</ENAMEX>"                              BEGIN INITIAL;
("<ENAMEX TYPE=\"LOCATION\""[^\n<]*">")  BEGIN localidade;
<localidade>[^\n<]+                      {locs = bt_insert(locs, trim(yytext));}
("<ENAMEX TYPE=\"ORGANIZATION\">")       BEGIN organizacao;
<organizacao>[^\n<]+                     {orgs = bt_insert(orgs, trim(yytext));}
.|\n
%%

int yywrap(){
		return(1);
}

void print(BTree bt){
	if (bt==NULL) return;
	print(bt->left);
	printf("<p>%s</p>\n",bt->valor);
	print(bt->right);
}

int main(){
		puts("<!DOCTYPE html>");
		//definir encoding
		printf("<meta http-equiv=\"Content-Type\"");
	  printf("content=\"text/html; charset=UTF-8\">");
		puts("<html>");
		puts("<head>");
		puts("<title>Resultados filtro ENAMEX</title>");
		puts("</head>");

		yylex();

		puts("<body>");
		puts("<h1>Nomes</h1>");
		print(noms);

		puts("<h1>Países e Cidades</h1>");
		print(locs);

		puts("<h1>Organizações</h1>");
		print(orgs);

		puts("</body>");
		puts("</html>");
		return 0;
}
