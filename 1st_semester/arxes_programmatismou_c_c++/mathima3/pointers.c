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

    /* 
        Each variable corresponds to a memory location.
        Each memory location has a unique address in memory.
        With "&" we can access in the address of a variable in memory.
        In a pointer we save the address of a variable to access its value through the pointer.
    */
    int var;
    var = 15;
    int *ptr;
    ptr = &var;
    printf("var = %d\n", var);
    printf("Address of var in memory = %d\n", &var);
    printf("Print var with use pointer = %d\n", *ptr);
    printf("Print address of var in memory with use pointer = %d\n", ptr);


    return 0;
}