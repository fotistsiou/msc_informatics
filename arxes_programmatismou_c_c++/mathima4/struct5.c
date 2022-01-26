// Guidelines //

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

int main5() {

    struct student *pts;

    pts = malloc(2*sizeof(struct student));

    // Create 1st and 2nd Students with use for loop
    for (int i = 0; i < 2; i++) {
        printf("Student %d\n", i+1);
        printf("Enter am:");
        scanf("%d", &(pts+i)->am);
        printf("Enter name:");
        scanf("%s", (pts+i)->name);
        printf("Enter surname:");
        scanf("%s", (pts+i)->surname);
    }

    // Print students with for loop
    printf("*****************************************************\n");
    for (int j = 0; j < 2; j++) {
        printf("Student %d: %s %s, with am:%d\n", j+1, (pts+j)->name, (pts+j)->surname, (pts+j)->am);
    }
    printf("*****************************************************\n");


    return 0;
}