// Guidelines //

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

struct student {
    int am;
    char name[30];
    char surname[30];
    struct student *next;
};

struct student *head;

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

void readAll(){
    struct student *temp;
    temp = head;
    if (temp == NULL) {
        printf("*****************************************************\n");
        printf("Not exist students in the list!\n");
        printf("*****************************************************\n");
        return;
    }
    printf("*****************************************************\n");
    while ( temp != NULL) {
        printf("Student: %s %s, with am:%d\n", temp->name, temp->surname, temp->am);
        temp = temp->next;
    }
    printf("*****************************************************\n");
}

void countStudents() {
    int count = 0;
    struct student *temp;
    temp = head;
    if (temp == NULL) {
        printf("*****************************************************\n");
        printf("Not exist students in the list!\n");
        printf("*****************************************************\n");
        return;
    }
    while ( temp != NULL) {
        count++;
        temp = temp->next;
    }
    printf("*****************************************************\n");
    printf("The numbers of students are: %d\n", count);
    printf("*****************************************************\n");
}

void findStudent(int am) {
    struct student *temp;
    temp = head;
    if (temp == NULL) {
        printf("*****************************************************\n");
        printf("Not exist students in the list!\n");
        printf("*****************************************************\n");
        return;
    }
    while ( temp != NULL) {
        if (am == temp->am) {
            printf("*****************************************************\n");
            printf("The student with am:%d is %s %s\n", temp->am, temp->name, temp->surname);
            printf("*****************************************************\n");
            return;
        }
        temp = temp->next;
    }
    printf("*****************************************************\n");
    printf("The student not found!\n");
    printf("*****************************************************\n");
}

void updateStudent(int am, int new_am, char new_name[20], char new_surname[20]) {
    struct student *temp;
    temp = head;
    if (temp == NULL) {
        printf("*****************************************************\n");
        printf("Not exist students in the list!\n");
        printf("*****************************************************\n");
        return;
    }
    while ( temp != NULL) {
        if (am == temp->am) {
            temp->am = new_am;
            strcpy(temp->name,new_name);
            strcpy(temp->surname,new_surname);
            printf("*****************************************************\n");
            printf("The new student's details is: am:%d name/surname: %s %s\n", temp->am, temp->name, temp->surname);
            printf("*****************************************************\n");
            return;
        }
        temp = temp->next;
    }
    printf("*****************************************************\n");
    printf("The student not found!\n");
    printf("*****************************************************\n");
}

// ------------------------ MAIN SECTION ------------------------ //

int main(){
    int i, am, new_am;
    char name[20], surname[20];
    while (1) {
        printf("1.Add Student\n");
        printf("2.Display Students\n");
        printf("3.Number of the students\n");
        printf("4.Find Student\n");
        printf("5.Update Student's Details\n");
        printf("6.Exit\n");
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
        } else if (i==2){
            readAll();
        } else if (i==3){
            countStudents();
        } else if (i==4){
            printf("Enter the student's am:");
            scanf("%d", &am);
            findStudent(am);
        } else if (i==5){
            printf("Enter the student's am:");
            scanf("%d", &am);
            printf("Enter the new student's am:");
            scanf("%d", &new_am);
            printf("Enter the new student's name:");
            scanf("%s", name);
            printf("Enter the new student's surname:");
            scanf("%s", surname);
            updateStudent(am, new_am, name, surname);
        } else if (i==6){
            return 0;
        } else {
            printf("*****************************************************\n");
            printf("Not found action for this choice!\n");
            printf("*****************************************************\n");
        }
    }
}