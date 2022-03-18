// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
};

struct node *head = NULL;

void push(int data) {
    struct node *newNode = malloc(sizeof(struct node));
    newNode->data = data;
    newNode->next = head;
    head = newNode;
}

void pop() {
    struct node *tmp;
    tmp = head;
    printf("Poped element = %d\n", tmp->data);
    head = head->next;
    free(tmp);
}

void printList() {
    struct node *tmp = head;
    if(tmp == NULL) {
        printf("Stack is Empty\n");
    } 
    while(tmp != NULL) {
        printf("%d\n", tmp->data);
        tmp = tmp->next;
    }
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
    pop();
    printList();
    return 0;
}