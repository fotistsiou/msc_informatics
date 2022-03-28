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
    char telephone[12];
    char mobile[12];
    char lesson[30];
    struct student *next;
};

struct lesson {
    struct student *pointer;
    struct lesson *next;
};

struct student *head = NULL;
struct lesson *head_2 = NULL;
char lesson_choice[] = "Domes_Dedomenwn";


void add(int am, char name[30], char surname[30], char father_name[30], char address[50], char telephone[12], char mobile[12], char lesson[30]) {
    struct student *tmp;
    tmp = malloc(sizeof(struct student));
    tmp->am = am;
    strcpy(tmp->name, name);
    strcpy(tmp->surname, surname);
    strcpy(tmp->father_name, father_name);
    strcpy(tmp->address, address);
    strcpy(tmp->telephone, telephone);
    strcpy(tmp->mobile, mobile);
    strcpy(tmp->lesson, lesson);
    tmp->next = head;
    head = tmp;

    if (strcmp(lesson_choice, tmp->lesson) == 0) {
        struct lesson *tmp_2;
        tmp_2 = malloc(sizeof(struct lesson));
        tmp_2->pointer = tmp;
        tmp_2->next = head_2;
        head_2 = tmp_2;
    }
}

void find() {
    struct lesson *tmp_2;
    tmp_2 = head_2;
    if (tmp_2 == NULL) {
        printf("The list is empty\n");
        return;
    }
    while (tmp_2 != NULL) {
        if (strcmp(lesson_choice, tmp_2->pointer->lesson) == 0) {
            printf("AM: %d, Full Name: %s %s, Father Name: %s, Address:%s, Telephone: %s, Mobile: %s\n\n", tmp_2->pointer->am, tmp_2->pointer->name, tmp_2->pointer->surname, tmp_2->pointer->father_name, tmp_2->pointer->address, tmp_2->pointer->telephone, tmp_2->pointer->mobile);
        } 
        tmp_2 = tmp_2->next;
    }
}

int main() {
    int num, am;
    char name[30], surname[30], father_name[30], address[50], telephone[12], mobile[12], lesson[30], les[50];
    while (1) {
        printf("1.Add Student\n");
        printf("2.Find Students who chose Diakrita lesson\n");
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
            scanf("%s", telephone);
            printf("Enter the student's mobile:");
            scanf("%s", mobile);
            printf("Enter the student's lesson:");
            scanf("%s", lesson);
            add(am, name, surname, father_name, address, telephone, mobile, lesson);
        }
        else if (num == 2) {
            find();
        }
        else if (num == 3) {
            return 0;
        }
    }
}