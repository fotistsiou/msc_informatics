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

    int a[6] = {2, 58, 100, 123, 343, 58};
    int b[3] = {23, 57, 1234};
    int len_a = sizeof(a)/sizeof(a[0]); // calculation length of an array
    int len_b = sizeof(b)/sizeof(b[0]); // calculation length of an array


    return 0;
}