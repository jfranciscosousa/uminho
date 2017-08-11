#ifndef __BTREE_H
#define __BTREE_H

typedef struct btree{
  char* valor;
  struct btree* left;
  struct btree* right;
} *BTree;

typedef struct btree *BTree;

BTree bt_insert(BTree b, char* data);

#endif
