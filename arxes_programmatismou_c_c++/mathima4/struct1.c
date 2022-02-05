// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ------------------------ HEADER SECTION ------------------------ //

#include <stdio.h>

// ------------------------ STRUCT DEFINITION SECTION ------------------------ //

struct student {
    int am;
    char name[30];
    char surname[30];
};

// ------------------------ MAIN SECTION ------------------------ //

int main1() {

    // Declaration two struct type variables
    struct student s1, s2;

    // 1st Student
    printf("1st Student\n");
    printf("Enter am:");
    scanf("%d", &s1.am);
    printf("Enter name:");
    scanf("%s", s1.name);
    printf("Enter surname:");
    scanf("%s", s1.surname);

    // 2nd Student
    printf("2nd Student\n");
    printf("Enter am:");
    scanf("%d", &s2.am);
    printf("Enter name:");
    scanf("%s", s2.name);
    printf("Enter surname:");
    scanf("%s", s2.surname);

    // Print students
    printf("*****************************************************\n");
    printf("First Student: %s %s, with am:%d\n", s1.name, s1.surname, s1.am);
    printf("Second Student: %s %s, with am:%d\n", s2.name, s2.surname, s2.am);
    printf("*****************************************************\n");


    return 0;
}