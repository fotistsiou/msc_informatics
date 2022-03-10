// Guidelines from Fotis K. Tsioumas //

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

#include <stdio.h>

int A[10];
int B[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int C[10] = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

int main(){
    for (int i = 0; i < 10; i++) {
        A[i] = B[i] + C[i];
        printf("A[%d] = %d\n", i, A[i]);
    }

    return 0;
}
