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

    /* ------------------- 1-dimensional array ------------------- */

    int a[5];
    int *b;
    b = &a;

    for (int i = 0; i < 5; i++) {
        a[i] = i;
        printf("value of a[%d]: %d and address of &a[%d]: %d\n", i, *b, i, b);
        b++;
    }

    /* ------------------- 2-dimensional array ------------------- */

    int c[3][2];
    int i, j;
    int *d;

    // Initialization of arrays elements
    for (i = 0; i < 3; i++) {
        for (j = 0; j < 2; j++) {
            c[i][j] = i + j + i * j;
            printf("Value of c[%d][%d] is: %d\n", i, j, c[i][j]);
        }
    }

    // Pointer Management
    d = c[0];
    for (i = 0; i < 6; i++) {
        printf("Address stored in d variable: %d, Value of *d variable: %d\n", d, *d);
        d++;
    }



    return 0;
}