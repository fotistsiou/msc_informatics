#include <stdio.h>
#include<stdlib.h>

struct node {
    int data;
    struct node *next;
};

struct node *head;

void push(int val) {
    struct node *newNode;
    newNode = malloc(sizeof(struct node));
    newNode->data = val;
    if (head == NULL) {
        newNode->next = NULL;
        head = newNode;
    } else {
        newNode->next = head;
        head = newNode;
    }
}

void pop() {
    struct node *tmp;
    if(head == NULL) {
        printf("Stack is Empty\n");
    } else {
        printf("Poped element = %d\n", head->data);
        tmp = head;
        head = head->next;
        free(tmp);
    }
}

void printList() {
    struct node *tmp;
    tmp = head;
    if(tmp == NULL) {
        printf("Stack is Empty\n");
        return;
    }
    while(tmp != NULL) {
        printf("%d\n", tmp->data);
        tmp = tmp->next;
    }
    printf("NULL\n");
}

int main() {
    push(10);
    push(20);
    push(30);
    printf("The Stack:\n");
    printList();
    pop();
    printf("After the pop, the new stack:\n");
    printList();
    pop();
    printf("After the pop, the new stack:\n");
    printList();
    return 0;
}