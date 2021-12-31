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

    // Max item of "a" and "b" arrays
    int max_a_and_b = a[0];
    int i;
    int j;
    for (i = 0; i < len_a; i++) {
        if (max_a_and_b < a[i]) {
            max_a_and_b = a[i];
        }
        for (j = 0; j < len_b; j++) {
            if (max_a_and_b < b[i]) {
                max_a_and_b = b[i];
            }
        }
    }
    printf("The max item of 'a' and 'b' arrays is: %d\n", max_a_and_b);


    // Min item of "a" and "b" arrays
    int min_a_and_b = a[0];
    for (i = 0; i < len_a; i++) {
        if (min_a_and_b > a[i]) {
            min_a_and_b = a[i];
        }
        for (j = 0; j < len_b; j++) {
            if (min_a_and_b > b[i]) {
                min_a_and_b = b[i];
            }
        }
    }
    printf("The max item of 'a' and 'b' arrays is: %d\n", min_a_and_b);


    return 0;
}