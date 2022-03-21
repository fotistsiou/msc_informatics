// Guidelines from Fotis K. Tsioumas //

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct patient {
	char name[40];
	int age;
	char gender[40];
	char disease[40];
	char date[40];
	struct patient *next;
};

struct patient *head;

void add(char name[40], int age, char gender[40], char disease[40], char date[40]) {
	struct patient *pts;
	pts = malloc(sizeof(struct patient));
	strcpy(pts->name, name);
	pts->age = age;
	strcpy(pts->gender, gender);
	strcpy(pts->disease, disease);
	strcpy(pts->date, date);
	if (head == NULL){
		pts->next = NULL;
		head = pts;
	} else {
		pts->next = head;
		head = pts;
	}
}

void count() {
	int num_patients = 0;
	struct patient *pts;
	pts = head;
	if (pts == NULL){
        printf("Not exist patients in the list!\n");
        return;
	}
	while (pts != NULL) {
		num_patients++;
		pts = pts->next;
	}
	printf("Number of Patients: %d\n", num_patients);
}


void readAll() {
	struct patient *temp;
	temp = head;
	if (temp == NULL){
		printf("Not exist patients in the list!\n");
		return;
	}
	while (temp != NULL) {
		printf("Name of Patient: %s\n", temp->name);
		temp = temp->next;
	}
}

int main() {
	int num, age;
	char name[40], gender[40], disease[40], date[40];
	while (1){
		printf("1. Add patient\n");
		printf("2. Count patients\n");
		printf("3. Print patients\n");
		printf("4. Exit\n");
		printf("Give action number:\n");
		scanf("%d", &num);
		if (num == 1) {
			printf("Enter the name:");
            scanf("%s", name);
            printf("Enter the age:");
            scanf("%d", &age);
            printf("Enter the gender:");
            scanf("%s", gender);
            printf("Enter the desease:");
            scanf("%s", disease);
            printf("Enter the date:");
            scanf("%s", date);
			add(name, age, gender, disease, date);
		} else if (num == 2) {
			count();
		} else if (num == 3) {
			readAll();
		} else if (num == 4) {
			return 0;
		}
	}
}
