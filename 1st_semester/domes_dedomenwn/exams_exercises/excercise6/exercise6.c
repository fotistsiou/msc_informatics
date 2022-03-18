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
    struct node *newNode;
    newNode = malloc(sizeof(struct node));
    newNode->data = data;
    newNode->next = head;
    head = newNode;
}

int pop() {
    struct node *tmp;
    int n;
    tmp = head;
    n = tmp->data;
    head = head->next;
    free(tmp);
    return n;
}

void printList() {
    struct node *tmp;
    tmp = head;
    if(tmp == NULL) {
        printf("Stack is Empty\n");
    } 
    while(tmp != NULL) {
        printf("%d|", tmp->data);
        tmp = tmp->next;
    }
    printf("\n");
}

int main() {
    int a, b, result;
    push(6);
    push(12);
    printList();
    a = pop();
    b = pop();
    result = a - b;
    push(result);
    printList();
    push(3);
    push(10);
    printList();
    a = pop();
    b = pop();
    result = a + b;
    push(result);
    printList();
    a = pop();
    b = pop();
    result = a * b;
    push(result);
    printList();
    push(4);
    printList();
    a = pop();
    b = pop();
    result = a - b;
    push(result);
    printf("4-[(10+3) x(12-6)] = ");
    printList();
    return 0;
}