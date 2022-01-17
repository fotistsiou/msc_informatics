// Guidelines //

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ------------------------ HEADER SECTION ------------------------ //

#include <stdio.h>


// ------------------------ MAIN SECTION ------------------------ //

int main () {

    int  var[3] = {10, 100, 200};
    int i, *ptr[3];

    for ( i = 0; i < 3; i++) {
        ptr[i] = &var[i]; // assign the address of integer.
    }

    for ( i = 0; i < 3; i++) {
        printf("Value of var[%d] = %d\n", i, *ptr[i] );
    }

    return 0;
}