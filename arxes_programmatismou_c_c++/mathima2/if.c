// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ------------------------ HEADER SECTION ------------------------ //

#include <stdio.h>

// ------------------------ FUNCTION PROTOTYPE SECTION ------------------------ //

int add2numbers(int a, int b); // add2numbers() function prototype

// ------------------------ MAIN SECTION ------------------------ //

int main() {

    int n1,n2;
    printf("Please enter a number 1:");
    scanf("%d", &n1);
    printf("Please enter a number 2:");
    scanf("%d", &n2);
    int sum = add2numbers(n1, n2); // 1st add2numbers() function call

    // --- 1st way --- //
    if (sum>10){
        printf("Sum of two variables is greater than 10\n");
    } else {
        printf("Sum of two variables is less or equal than 10\n");
    }

    // --- 2nd way --- //
    if (sum>10){
        printf("Sum of two variables is greater than 10\n");
        return 0;
    }
    printf("Sum of two variables is less or equal than 10\n");

    // --- 3rd way --- //
    if (sum>10){
        printf("Sum of two variables is greater than 10\n");
    }
    if (sum<=10){
        printf("Sum of two variables is less or equal than 10\n");
    }

    // --- 4th way --- //
    if (sum>10){
        printf("Sum of two variables is greater than 10\n");
        return 0;
    }
    if (sum<=10){
        printf("Sum of two variables is less or equal than 10\n");
    }

    // --- 5th way --- // WRONG way because 2nd print will run in each case
    if(sum>10)
      printf("Sum of two variables is greater than 10\n");
    printf("Sum of two variables is less or equal than 10\n");


    return 0;
}

// add2numbers() function definition
int add2numbers(int a, int b) {
    int c = a + b;
    return c;
}