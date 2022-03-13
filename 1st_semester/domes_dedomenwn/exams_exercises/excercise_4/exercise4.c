// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

#include <stdio.h>
#include <stdlib.h>

#define STACK_SIZE 10
#define TRUE 1
#define FALSE 0

typedef int elem;

struct stack {
    elem array[STACK_SIZE];
    int top;
};

typedef struct stack STACK;

void ST_init(STACK *s);
int ST_empty(STACK s);
int ST_full(STACK s);
int ST_push(STACK *s, elem x);
int ST_pop(STACK *s, elem *x);

int main() {
    int num, elem, i;
    STACK st;

    ST_init(&st);
    while (1) {
        printf("1.Add element\n");
        printf("2.Remove element\n");
        printf("3.Read the stack\n");
        printf("4.Exit\n");
        printf("Enter the action number:");
        scanf("%d", &num);
        if (num == 1) {
            printf("Give an element:");
            scanf("%d", &elem);
            if (ST_push(&st, elem)) {
                printf("Add successful\n");
            } else {
                printf("Add not successful. The stack is full!\n");
            }
        } else if (num == 2) {
            if (ST_pop(&st, &elem)) {
                printf("Remove successful. %d has removed\n", elem);
            } else {
                printf("Remove not successful. The stack is empty!\n");
            }
        } else if (num == 3) {
            printf("The stack has %d elements:\n", st.top+1);
            for (i = 0; i <= st.top; i++) {
                printf("%d\n", st.array[i]);
            }
        } else if (num == 4) {
            return 0;
        }
    }
}

void ST_init(STACK *s) {
    s->top = -1;
}

int ST_empty(STACK s){
    return s.top == -1;
}

int ST_full(STACK s){
    return s.top == STACK_SIZE-1;
}

int ST_push(STACK *s, elem x){
    if (ST_full(*s)) {
        return FALSE;
    } else {
        s->top++;
        s->array[s->top] = x;
        return TRUE;
    }
}

int ST_pop(STACK *s, elem *x){
    if (ST_empty(*s)) {
        return FALSE;
    } else {
        *x = s->array[s->top];
        s->top--;
        return TRUE;
    }
}