// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

#include <stdio.h>

int main(){

    int arraysize ; 
    printf("Give the arrays size\n");
    scanf("%d", &arraysize);  

    int arrayA[arraysize], arrayB[arraysize], arrayC[arraysize];
    
    for(int i = 0; i < arraysize; i++){
        printf("Give B[%d] value:\n", i);
        scanf("%d", &arrayB[i]);
        printf("Give C[%d] value:\n", i);
        scanf("%d", &arrayC[i]);
    }   

    for(int i = 0; i < arraysize; i++){
        arrayA[i] = arrayB[i] + arrayC[i];
        printf("A[%d] = B[%d] + C[%d] = %d\n", i, i, i, arrayA[i]);
    }

    return 0;
}