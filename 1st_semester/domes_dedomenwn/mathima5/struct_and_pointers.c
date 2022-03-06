// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ------------------------ HEADER SECTION ------------------------ //

#include <stdio.h>
#include <string.h>

// ------------------------ STRUCT DEFINITION SECTION ------------------------ //

struct Book {
    char title[50];
    int book_id;
};

// ------------------------ MAIN SECTION ------------------------ //

int main() {

    struct Book *Book1_pointer, Book1;
    Book1_pointer = &Book1;
    strcpy( Book1_pointer->title, "Programming in C"); // AS strcpy( Book1.title, "Programming in C");
    Book1_pointer->book_id = 10; // AS Book1.book_id = 10;
    printf( "Book1 title : %s\n", Book1.title);
    printf( "Book1 book_id : %d\n", Book1.book_id);


    return 0;
}