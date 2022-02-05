// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ------------------------ HEADER SECTION ------------------------ //

#include <stdio.h>

// ------------------------ MAIN SECTION ------------------------ //

int main() {

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


    return 0;
}