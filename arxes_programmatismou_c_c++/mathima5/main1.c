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
    char name[30];
    int mark;

    // "fopen()" function is a library function that is used to open a file. If the file exists then the particular file is opened else a new file is created.
    // Arguments: 1st -> filename, 2nd -> mode of operation
    // Modes: "r" = open for read, "w" = open for write, "b" = prevents the standard library from translating a few characters when reading/writing to the file

    // Declaration "fopen()" function
    FILE *fptr;
    fptr = fopen("mydata.txt", "wb");

    // Custom error handling
    if (fptr == NULL) {
        printf("Something went wrong with the file!");
        // Return code "-1" instead of "0" when sth went wrong
        return -1;
    }

    // "fprintf()" function adds content to the file
    // Arguments: 1st = filename. 2nd = text input
    fprintf(fptr, "Hello World");

    // "fclose():"" closes the file
    // Argument: 
    fclose(fptr);

    
    return 0;
}