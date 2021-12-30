// Guidelines //

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ------------------------ HEADER SECTION ------------------------ //

#include <stdio.h>

// ------------------------ MAIN SECTION ------------------------ //

int main() {

    int i;
    do { // Loop will run at least once, because condition is in the end of loop
        printf("value of i: %d\n", i);
        i++;
    } while(i<10);


    return 0;
}