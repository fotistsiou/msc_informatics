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

    /* 
        Each variable corresponds to a memory location.
        Each memory location has a unique address in memory.
        With "&" we can access in the address of a variable in memory.
    */
    int var1;
    var1 = 15;
    printf("var1 = %d\n", var1);
    printf("Address of var1 in memory: %x\n", &var1); 

    return 0;
}