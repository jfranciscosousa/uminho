%{
  #include <stdio.h>
  #include "sds.h"
  #include "auxiliar.c"

  typedef struct nodo{
      sds title;
      sds author;
      sds text;
      sds singer;
      int letra;
      struct nodo *next;
  } *Cancoes;

  Cancoes c;
  Cancoes list = NULL;
  Cancoes newNode();

  sds aux;
%}

%x LETRA

%%

^(?i:title):.+ {
            c->title = sdscat(c->title,yytext+6);
            c->title = trimwhitespace(c->title);
            c->text = sdscatprintf(c->text,"\\title{%s}\n",c->title);
          }

^(?i:lyrics):.+ {
            aux = sdsempty();
            aux = sdscat(aux,yytext+7);
            aux = trimwhitespace(aux);
            c->author = sdscatprintf(c->author,"Letra: %s\\\\",aux);
            sdsfree(aux);
           }

^(?i:music):.+ {
            aux = sdsempty();
            aux = sdscat(aux,yytext+6);
            aux = trimwhitespace(aux);
            c->author = sdscatprintf(c->author,"Música: %s\\\\",aux);
            sdsfree(aux);
           }

^(?i:author):.+ {
            aux = sdsempty();
            aux = sdscat(aux,yytext+7);
            aux = trimwhitespace(aux);
            c->author = sdscatprintf(c->author,"Autor: %s\\\\",aux);
            sdsfree(aux);
           }

^(?i:singer):.+ {
            c->singer = sdsempty();
            c->singer = sdscat(c->singer,yytext+7);
            c->singer = trimwhitespace(c->singer);
           }

^##-+       {
            c->text=sdscat(c->text,"\\end{verbatim}\n");
            c->text=sdscat(c->text,"\\vfill\n");
            if (c->singer){
              c->text=sdscat(c->text,"\\begin{flushright}\n");
              c->text=sdscatprintf(c->text,"\\textbf{Singer}:%s\n",c->singer);
              c->text=sdscat(c->text,"\\end{flushright}\n");
            }
            c->next=list;
            list=c;
            c=newNode();
           }

^[^#][^:\n]+$ {
            if (c->letra==0){
              c->text=sdscatprintf(c->text,"\\author{%s}\n",c->author);
              c->text=sdscat(c->text,"\\date{}\n\\maketitle\n");
              c->text=sdscat(c->text,"\\section*{Letra}\n");
              c->text=sdscat(c->text,"\\begin{verbatim}");
              c->letra=1;
            }
            yytext=trimwhitespace(yytext);
            c->text=sdscatprintf(c->text,"%s\n",yytext);
           }

.

\n

%%

Cancoes newNode(){
  Cancoes n = malloc(sizeof(struct nodo));
  n->title = sdsempty();
  n->author = sdsempty();
  n->singer = NULL;
  n->text = sdsempty();
  n->text = sdscat(n->text,"\\documentclass[12pt,a4paper]{article}\n\\usepackage[utf8]{inputenc}\n\\usepackage[portuguese]{babel}\n\\usepackage[T1]{fontenc}\n\\begin{document}\n");
  n->letra = 0;
  n->next = NULL;
  return n;
}

void freeNode(Cancoes n){
  sdsfree(n->author);
  sdsfree(n->text);
  free(n);
}

int yywrap(){
  return(1);
}

int main(int argc, char **argv){
  FILE *fp;
  c = newNode(); //inicializar primeiro nodo atual
  yylex();
  Cancoes temp;

  c->next=list; list = c; //colocar nodo atual à cabeça
  while (list != NULL){
    sds title = sdsempty();
    title = sdscatprintf(title,"%s.tex",list->title);
    fp = fopen(title,"w");
    if (list->singer==NULL)
      list->text=sdscat(list->text,"\\end{verbatim}");
    list->text=sdscat(list->text,"\\end{document}");
    fprintf(fp,list->text);
    fclose(fp);
    temp = list;
    list = list->next;
    freeNode(temp); //limpar nodo atual
  }
}
