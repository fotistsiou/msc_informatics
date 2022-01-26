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

int main() {

    int num_choice;
    struct student *pts;

    // User choice for number of the students
    printf("Give me the number of Students:\n");
    scanf("%d", &num_choice);

    pts = malloc(num_choice*sizeof(struct student));

    // Create students according to user's choice
    for (int i = 0; i < num_choice; i++) {
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
    for (int j = 0; j < num_choice; j++) {
        printf("Student %d: %s %s, with am:%d\n", j+1, (pts+j)->name, (pts+j)->surname, (pts+j)->am);
    }
    printf("*****************************************************\n");


    return 0;
}