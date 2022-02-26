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

struct student {
    int am;
    char name[30];
    char surname[30];
    struct student *next; 
};

struct student *head; 

void add(int am, char name[30], char surname[30]) {
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
        return;
    }
    printf("*****************************************************\n");
    while ( temp != NULL) {
        printf("Student: %s %s, with am:%d\n", temp->name, temp->surname, temp->am);
        temp = temp->next;
    }
    printf("*****************************************************\n");
}

// Save data in a file with use a linked list 
void save(){
    struct student *r;
    r = head;
    if (r == NULL) {
        return;
    }
    FILE *fptr;
    fptr = fopen("./mydata6.dat", "wb");
    if (fptr == NULL) {
        printf("Something went wrong with the file!");
        return;
    }
    while (r != NULL) {
        fwrite(r, sizeof(struct student), 1, fptr);
        r = r->next;
    }
    fclose(fptr);
    printf("List save successful!\n");
}

// Load data in a linked list in order to display it from "./mydata6.dat" file after ends and starts my code.
// In order to run this code, have to follow below steps:
// 1. Compile and Run the executed file
// 2. Press 1 so that add a student 
// 3. Press 3 so that save the student in "./mydata6.dat"
// 4. Press 5 so that end the program
// 5. Run the executed file
// 6. Press 4 so that loads the student from "./mydata6.dat" to the linked list 
// 7. Press 2 so that show the student
void load(){
    struct student s; 
    head = NULL;
    FILE *fptr;
    fptr = fopen("./mydata6.dat","r"); 
    if(fptr==NULL){
        printf("Something went wrong with the file!");
        return;
    }
    while (fread(&s,sizeof(struct student),1,fptr)){
        add(s.am, s.name, s.surname);
    }
    fclose(fptr);
    printf("Data loaded to linked list!\n");
}

// ------------------------ MAIN SECTION ------------------------ //

int main(){
    int i, am;
    char name[20], surname[20];
    while (1) {
        printf("1.Add Student\n");
        printf("2.Display Students\n");
        printf("3.Save List\n");
        printf("4.Load List\n");
        printf("5.Exit\n");
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
            save();
        }
        else if (i==4){
            load();
        }
        else if (i==5){
            return 0;
        }
    }
}