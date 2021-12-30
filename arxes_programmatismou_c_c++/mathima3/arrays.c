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

    // Initialization an one-dimensional array with 5-positions size and assignment a value in the first position
    int a[5];
    a[0] = 1;
    printf("a[0] = %d\n", a[0]); // Print first item

    // Initialization an one-dimensional array with 5-positions size and assignment a value in all positions
    int b[5] = {1, 2, 3, 4, 5};
    printf("b[0] = %d\n", b[0]); // Print first item

    // Print all items of an one-dimensional array
    int i;
    for (i = 0; i < 5; i++) {
        printf("b[%d] = %d\n", i, b[i]);
    }

    // Initialization a multidimensional array with 3x4-positions size and assignment a value in all positions
    int c[3][4] = {
        {0, 1, 2, 3},
        {4, 5, 6, 7},
        {8, 9, 10, 11}
    };
    printf("c[0][0] = %d\n", c[0][0]); // Print the first item of the first array

    // Print all items of a multidimensional array
    int j, w;
    for (j = 0; j < 3; j++) {
        for (w = 0; w < 4; w++) {
            printf("c[%d][%d] = %d\n", j, w, c[j][w]);
        }
    }


    return 0;
}