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

// ------------------------ MAIN SECTION ------------------------ //

int main() {

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


    return 0;
}

// my_method() function definition
void my_method() {
    printf("Hello\n");
}