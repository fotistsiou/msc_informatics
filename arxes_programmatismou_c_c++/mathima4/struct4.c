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

int main4() {

    struct student *pts;

    // Use one pointer instead of two pointers
    pts = malloc(2*sizeof(struct student));

    // 1st Student
    // Replace "pts1" with "(pts+0)"
    printf("1st Student\n");
    printf("Enter am:");
    scanf("%d", &(pts+0)->am);
    printf("Enter name:");
    scanf("%s", (pts+0)->name);
    printf("Enter surname:");
    scanf("%s", (pts+0)->surname);

    // 2nd Student
    // Replace "pts2" with "(pts+1)"
    printf("2nd Student\n");
    printf("Enter am:");
    scanf("%d", &(pts+1)->am);
    printf("Enter name:");
    scanf("%s", (pts+1)->name);
    printf("Enter surname:");
    scanf("%s", (pts+1)->surname);

    // Print Students
    // Replace "pts1" with "(pts+0)" and "pts2" with "(pts+1)"
    printf("*****************************************************\n");
    printf("First Student: %s %s, with am:%d\n", (pts+0)->name, (pts+0)->surname, (pts+0)->am);
    printf("Second Student: %s %s, with am:%d\n", (pts+1)->name, (pts+1)->surname, (pts+1)->am);
    printf("*****************************************************\n");


    return 0;
}