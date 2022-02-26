// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ------------------------ HEADER SECTION ------------------------ //

#include <stdio.h>

// ------------------------ MAIN SECTION ------------------------ //

int main(){  

    char buff[100];
    FILE *fptr;
    fptr = fopen("mydata2.txt", "r"); 

    if (fptr == NULL) {
        printf("Something went wrong with the file!");
        return -1;
    }

    // "fscanf()" function is used to read the formatted input from the given stream in the C language.
    // Arguments: 1st = filename , 2nd = data format, 3rd = temporary position
    while (fscanf(fptr, "%s", buff) != EOF) { 
        printf("%s\n", buff);
    }

    fclose(fptr);
    printf("END OF FILE!\n");

    
    return 0;
}