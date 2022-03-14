// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

#include <stdio.h>

#define SIZE 5

int arr[SIZE];
int top = -1;

int isStackFull() {
    if(top == SIZE - 1) {
        return 1;
    } else {
        return 0;
    }
}

void push(int val) {
    if(isStackFull()) {
        printf("Unable to push. Stack Is Full!\n");
    } else {
        top++; 
        arr[top] = val;
    }
}

int isStackEmpty() {
    if(top == -1) {
        return 1;
    } else {
        return 0;
    }    
}

void pop() {
    if(isStackEmpty()) {
        printf("Stack Is Empty!\n");
    } else {
        printf("Popped element = %d\n",arr[top]);
        top--;
    }
}

int main() {
    push(10);
    push(13);
    push(5);
    push(26);
    push(100);
    push(78);       
    pop();          
    pop();          
    pop();          
    pop();          
    pop();          
    pop();          
    return 0;
}