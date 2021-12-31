// Guidelines //

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ------------------------ HEADER SECTION ------------------------ //

#include <stdio.h>
#include <string.h>

// ------------------------ STRUCT DEFINITION SECTION ------------------------ //

union number {
    int i;
    float f;
    char str[50];
};

// ------------------------ MAIN SECTION ------------------------ //

int main() {

    union number mynumber;
    mynumber.f = 1024.5;
    strcpy( mynumber.str, "perigrafi arithmou");
    mynumber.i = 200;
    printf( "%f\n", mynumber.f);
    printf( "%s\n", mynumber.str);
    printf( "%d\n", mynumber.i); 
    

    return 0;
}