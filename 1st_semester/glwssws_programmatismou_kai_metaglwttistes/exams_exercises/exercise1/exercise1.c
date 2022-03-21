// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

#include <stdio.h>
#include <string.h>

#define max 51

struct stack {
	char st[max];
	int top;
} stk;

void push(char);
int pop();
void print_state();

int main() {
	char s[max];
	int i;
	stk.top = -1;
    printf("Enter a sequence of 92 max 25 times:\n");
	scanf("%s",s);
	int l = strlen(s);
	for(i = 0; i < l; i++) {
		if(s[i] == '9') {
			printf("Push!\n");
			push(s[i]);
		} else if(s[i] == '2') {
                if(stk.st[stk.top] == '9') {
					printf("Pop!\n");
                    pop();
                } else {
					printf("Fail!\n\n");
                    stk.top = 0;
                    break;
                }
		}
		print_state(s, i);
		printf("\n");
	}
    if(stk.top == -1) {
        printf("Final State: Balanced!\n");
    } else {
        printf("Final State: Unbalanced.\n");
    }
}

void push(char item) {
	if(stk.top == max-1) {
		printf("Stack Is Full.\n");
	} else {
		stk.top = stk.top+1;
		stk.st[stk.top] = item;
	}
}

int pop() {
	if(stk.top == -1) {
		printf("Stack Is Empty.\n");
	} else {
		stk.top = stk.top-1;
	}
}

void print_state(char s[], int index) {
	printf("New character: %c\n", s[index]);
	printf("Rest of the Input: %s\n", s+index+1);
	for (int i = 0; i <= stk.top; i++) {
		printf("| %c ", stk.st[i]);
	}
	printf("<-\n");
}