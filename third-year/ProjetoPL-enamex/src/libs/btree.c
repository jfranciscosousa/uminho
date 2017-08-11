#include <stdlib.h>
#include <string.h>
#include "btree.h"

static BTree newNode(char* valor){
  BTree b = malloc(sizeof(struct btree));
  b->valor = strdup(valor);
  b->left = NULL;
  b->right = NULL;
}

BTree bt_insert(BTree b, char* data){
    if(b==NULL){
      b=newNode(data);
    }
    else if(strcmp(data,b->valor)<0){
        b->left = bt_insert(b->left, data);
    }
    else if(strcmp(data,b->valor)>0){
        b->right = bt_insert(b->right, data);
    }
    return b;
}
