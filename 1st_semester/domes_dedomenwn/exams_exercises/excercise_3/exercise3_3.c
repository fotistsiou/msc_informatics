// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct student {
    int am;
    char name[30];
    char surname[30];
    char father_name[30];
    char address[50];
    int telephone;
    int mobile;
    char lesson[30];
    struct student *next;
};

struct student *head;

void add(int am, char name[30], char surname[30], char father_name[30], char address[50], int telephone, int mobile, char lesson[30]) {
    struct student *tmp;
    tmp = malloc(sizeof(struct student));
    tmp->am = am;
    strcpy(tmp->name, name);
    strcpy(tmp->surname, surname);
    strcpy(tmp->father_name, father_name);
    strcpy(tmp->address, address);
    tmp->telephone = telephone;
    tmp->mobile = mobile;
    strcpy(tmp->lesson, lesson);
    if (head == NULL) {
        tmp->next = NULL;
        head = tmp;
    } else {
        tmp->next = head;
        head = tmp;
    }
}

void find(char les[50]) {
    struct student *tmp;
    tmp = head;
    if (tmp == NULL) {
        printf("The list is empty\n");
        return;
    }
    if (strcmp(les, tmp->lesson) == 0) {
        printf("The following students have choses the lesson: %s\n", les);
    } else {
        printf("Not found students who have choosen the lesson: %s\n", les);
    }
    while (tmp != NULL) {
        if (strcmp(les, tmp->lesson) == 0) {
            printf("AM: %d, Full Name: %s %s, Father Name: %s, Address:%s, Telephone: %d, Mobile: %d\n\n", tmp->am, tmp->name, tmp->surname, tmp->father_name, tmp->address, tmp->telephone, tmp->mobile);
        } 
        tmp = tmp->next;
    }
}

int main() {
    int num, am, telephone, mobile;
    char name[30], surname[30], father_name[30], address[50], lesson[30], les[50];
    while (1) {
        printf("1.Add Student\n");
        printf("2.Find Students who choiced a specific lesson\n");
        printf("3.Exit\n");
        printf("Enter the action number:");
        scanf("%d", &num);
        if (num == 1) {
            printf("Enter the student's am:");
            scanf("%d", &am);
            printf("Enter the student's name:");
            scanf("%s", name);
            printf("Enter the student's surname:");
            scanf("%s", surname);
            printf("Enter the student's father name:");
            scanf("%s", father_name);
            printf("Enter the student's address:");
            scanf("%s", address);
            printf("Enter the student's telephone:");
            scanf("%d", &telephone);
            printf("Enter the student's mobile:");
            scanf("%d", &mobile);
            printf("Enter the student's lesson:");
            scanf("%s", lesson);
            add(am, name, surname, father_name, address, telephone, mobile, lesson);
        }
        else if (num == 2) {
            printf("Enter the lesson:");
            scanf("%s", les);
            find(les);
        }
        else if (num == 3) {
            return 0;
        }
    }
}