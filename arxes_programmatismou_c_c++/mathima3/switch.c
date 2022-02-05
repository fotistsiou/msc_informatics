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

    int num;
    printf("Give a number from 1 to 3: ");
    scanf("%d", &num);
    switch (num) {
        case 1:
            printf("Your number is: %d", num);
            break;
        case 2:
            printf("Your number is: %d", num);
            break;
        case 3:
            printf("Your number is: %d", num);
            break;
        default:
            printf("Your number is not from 1 to 3");
            break;
    }


    return 0;
}