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

    // Initialization the array of string
    char str1[12] = "Hello World";
    
    // Print the entire string
    printf("String : %s\n", str1);
    
    // Print all characters of the array string. The last character is "Null".  
    int i;
    for (i = 0; i <= 11; i++) {
        printf("str1[%d] = %c\n", i, str1[i]);
    }

    return 0;
}