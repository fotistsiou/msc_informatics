// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ------------------------ HEADER SECTION ------------------------ //

#include <stdio.h>
#include <stdlib.h>

// ------------------------ STRUCT DEFINITION SECTION ------------------------ //

struct student {
    int am;
    char name[30];
    char surname[30];
};

// ------------------------ MAIN SECTION ------------------------ //

int main3() {

    struct student *pts1, *pts2;

    // Use the malloc function in order to replace the variables:
    //      1. Include <stdlib.h> library of C in the "Header" section.
    //      2. Use the malloc() function.
    // The "malloc()" function allocates SIZE bytes of memory and takes as argument a size.
    // The "sizeof()" function returns the amount of memory is allocated to "struct student" data type.
    pts1 = malloc(sizeof(struct student));
    pts2 = malloc(sizeof(struct student));

    // 1st student
    printf("1st Student\n");
    printf("Enter am:");
    scanf("%d", &pts1->am);
    printf("Enter name:");
    scanf("%s", pts1->name);
    printf("Enter surname:");
    scanf("%s", pts1->surname);

    // 2nd student
    printf("2nd Student\n");
    printf("Enter am:");
    scanf("%d", &pts2->am);
    printf("Enter name:");
    scanf("%s", pts2->name);
    printf("Enter surname:");
    scanf("%s", pts2->surname);

    // Print Students
    printf("*****************************************************\n");
    printf("First Student: %s %s, with am:%d\n", pts1->name, pts1->surname, pts1->am);
    printf("Second Student: %s %s, with am:%d\n", pts2->name, pts2->surname, pts2->am);
    printf("*****************************************************\n");


    return 0;
}