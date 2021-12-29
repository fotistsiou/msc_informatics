// Guidelines //

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ------------------------ HEADER SECTION ------------------------ //

#include <stdio.h>

// ------------------------ FUNCTION PROTOTYPE SECTION ------------------------ //

void my_method(); // my_method() function prototype
int add2numbers(int a, int b); // add2numbers() function prototype

// ------------------------ MAIN SECTION ------------------------ //

int main() {

// ------ printf(), scanf() ------ //

    int user_input;
    printf("Please enter a number:");
    scanf("%d", &user_input);
    printf("You entered: %d\n", user_input);

// ------ END printf(), scanf() ------ //


// ------ IF Conditional Statement ------ //

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

// ------ END IF Conditional Statement ------ //


// ------ WHILE Loop ------ //

    int user_choice;
    printf("Give a number:");
    scanf("%d", &user_choice);

// --- 1st way --- //
    int counter=1;
    while (counter<=user_choice){
        my_method(); // 1st my_method() function call
        counter++;
    }

// --- 2nd way --- //
    while (user_choice){
        my_method(); // 2nd my_method() function call
        user_choice--;
    }

// ------ END WHILE Loop ------ //


// ------  FOR Loop  ------ //

// --- 1st example --- //
    int user_choice;
    printf("Give a number:");
    scanf("%d", &user_choice);
    for (int i = 0; i < user_choice; ++i){
        printf("You entered: %d\n", user_choice);
    }

// --- 2nd example --- // FOR without arguments
    int j = 0;
    for(;;){
        printf("%d", j);
        j++;
        if(j>=10) return 0;
    }

// ------  END FOR Loop  ------ //


    return 0;
}

// my_method() function definition
void my_method() {
    printf("Hello\n");
}

// add2numbers() function definition
int add2numbers(int a, int b) {
    int c = a + b;
    return c;
}