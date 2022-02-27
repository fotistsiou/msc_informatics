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
    char author[50];
    char subject[100];
    int book_id;
};

// ------------------------ MAIN SECTION ------------------------ //

int main() {

    struct Book Book1;
    strcpy(Book1.title, "Programming in C");
    strcpy(Book1.author, "Fotis Tsioumas");
    strcpy(Book1.subject, "Basic steps in C programming language");
    Book1.book_id = 12345;
    printf("Book1 title : %s\n", Book1.title);
    printf("Book1 author : %s\n", Book1.author);
    printf("Book1 subject : %s\n", Book1.subject);
    printf("Book1 book_id : %d\n", Book1.book_id);
    

    return 0;
}