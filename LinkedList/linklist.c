#include <stdlib.h>
#include <stdio.h>

struct Node
{
  int data;
  struct Node *next;
};

struct Node *Head;

void
Display (struct Node *ptr)
{
  if (ptr != NULL)
    {
      printf ("%d\n", ptr->data);
      Display (ptr->next);
    }
}

struct Node *head;

void
create (int n, int arr[])
{
  struct Node *last, *temp;
  head = (struct Node *) (malloc (sizeof (struct Node)));
  head->data = arr[0];
  head->next = NULL;
  last = head;
  for (int i = 1; i < n; i++)
    {
      temp = (struct Node *) (malloc (sizeof (struct Node)));
      temp->data = arr[i];
      last->next = temp;
      last = temp;
    }
}

void
InsertBegining (int n, struct Node *ptr)
{
  struct Node *temp;
  temp = (struct Node *) (malloc (sizeof (struct Node)));
  temp->data = n;
  temp->next = head;
  head = temp;
}

void InsertLast(int n, struct Node *ptr){
    while(ptr->next){
        ptr=ptr->next;
    }
    struct Node *N;
    N = (struct Node*)(malloc(sizeof(struct Node)));
    N->data = n;
    N->next = NULL;
    ptr->next = N;
}

void InsertPos(int n, int pos, struct Node *right){
    while(pos-1){
        right=right->next;
        pos=pos-1;
    }
    struct Node *temp;
    temp = (struct Node *)(malloc(sizeof(struct Node)));
    temp->data = n;
    temp->next = right->next;
    right->next=temp;
}

void DeleteBegining(struct Node *head){
    head = head->next;
}

int
main ()
{
  int arr[] = { 1, 2, 3, 4, 5 };
  int n = 5;
  create (n, arr);
  InsertBegining (0, head);
  InsertPos(10,2,head);
  InsertLast(6,head);
  DeleteBegining(head);
  Display (head);
}