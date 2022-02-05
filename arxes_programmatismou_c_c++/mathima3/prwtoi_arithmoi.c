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

    int i, j;
    for (i = 2; i < 30; i++) { // the smaller the condition the more understandable
        /*
            With the nested loop, we check if "i" is an even or odd number.
            If "i" is an even number, the nested loop ends with "break".
            If "i" is an odd number, "j" increase and the nested loop ends due to condition "j <= (i/j)" or "break" statement.
        */
        for ( j = 2; j <= (i/j); j++) {
            if (!(i%j)) break;
        }
        printf("i = %d, j = %d \n", i, j); // helper
        /*
            If "i" is an even number and greater than "2", the condition "j>(i/j)" is always false, therefore "i" isn't a prime number.
            If "i" is an odd number and condition "j>(i/j)" is true, "i" is a prime number.
        */
        if (j>(i/j)) printf("%d is prime \n", i);
    }


    return 0;
}