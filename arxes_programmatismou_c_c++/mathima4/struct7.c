// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ------------------------ HEADER SECTION ------------------------ //

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// ------------------------ STRUCT, POINTERS AND FUNCTIONS DEFINITION SECTION ------------------------ //

// Each student's node will have an am, a name, a surname and a pointer which show address of the next student's node.
struct student {
    int am;
    char name[30];
    char surname[30];
    struct student *next; // The student's "next" pointer shows address of the next student's node.
};

struct student *head; // The "head" pointer shows address of the current student's node.

// Definition the "add()" function, which accepts 3 arguments (student's am, student's name, student's surname).
// The "add()" function creates students with use linked list
// The creation of the students' nodes is implemented from the end to the beginning of the list.
void add(int am, char name[20], char surname[20]) {
    struct student *pts;
    pts = malloc(sizeof(struct student));
    pts->am = am;
    strcpy(pts->name,name);
    strcpy(pts->surname,surname);
    if (head==NULL) {
        pts->next = NULL;
        head = pts;
    } else {
        pts->next = head;
        head = pts;
    }
}

// Definition the "readAll()" function, which read all students with use linked list.
// The student's read is implemented from the beginning to the end of the list.
void readAll(){
    struct student *temp; // The "temp" pointer shows the student's node.
    temp = head; // The "temp" pointer takes the value of the "head" pointer each time, so that we don't lose the value of the "head" and as a result we don't destroy our list.
    if (temp == NULL) {
        return;
    }
    printf("*****************************************************\n");
    while ( temp != NULL) {
        printf("Student: %s %s, with am:%d\n", temp->name, temp->surname, temp->am);
        temp = temp->next;
    }
    printf("*****************************************************\n");
}

// ------------------------ MAIN SECTION ------------------------ //

int main(){
    int i, am;
    char name[20], surname[20];
    while (1) {
        printf("1.Add Student\n");
        printf("2.Display Students\n");
        printf("3.Exit\n");
        printf("Enter your choice:");
        scanf("%d", &i);
        if (i==1) {
            printf("Enter the student's am:");
            scanf("%d", &am);
            printf("Enter the student's name:");
            scanf("%s", name);
            printf("Enter the student's surname:");
            scanf("%s", surname);
            add(am, name, surname);
        }
        else if (i==2){
            readAll();
        }
        else if (i==3){
            return 0;
        }
    }
}