// Guidelines //

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ---------- Header Section ---------- //

// "stdio.h" is a header file which has the necessary information to include the input/output related functions in our program. Example printf, scanf etc.
#include <stdio.h> // Instructs the compiler to include the "stdio.h" file before compiling.

// ---------- Main Section ---------- //

int main() { // The first function of every C program that is responsible for starting the execution and termination of the program.
    printf("Hello, World!\n"); // Call the printf function, responsible for output in the screen.
    return 0; // Terminates the main function and hence our program. A return 0 means that the program will execute successfully and did what it was intended to do.
}