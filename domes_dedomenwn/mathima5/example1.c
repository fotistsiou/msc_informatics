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
    int i = 10; // actual variable declaration
    int *ia; // pointer variable declaration
    ia = &i; // store address of var in pointer variable

    printf("%d, %d\n", i, &i); // value of "i" variable, address of "i" variable
    printf("%d, %d, %d\n", &ia, *ia, ia); // address of "ia" pointer, value of "i" variable, address of "i" variable

    return 0;
}