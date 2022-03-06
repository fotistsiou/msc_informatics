#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct patient {
	int amka;
	char name[40];
	int age;
	char gender[40];
	struct patient *next;
};

struct patient *head;

void add(int amka, char name[40], int age, char gender[40]) {
	struct patient *pts;
	pts = malloc(sizeof(struct patient));
	pts->amka = amka;
	strcpy(pts->name, name);
	pts->age = age;
	strcpy(pts->gender, gender);
	if (head == NULL){
		pts->next = NULL;
		head = pts;
	} else {
		pts->next = head;
		head = pts;
	}
}

void generate_arrays() {
	
}


void print_max_min() {
	
}

int main() {
	int num, amka, age;
	char name[40], gender[40];
	while (1){
		printf("1. Add patient\n");
		printf("2. Generate arrays\n");
		printf("3. Print max and min\n");
		printf("4. Exit\n");
		printf("Give action number:\n");
		scanf("%d", &num);
		if (num == 1) {
			printf("Enter the age:");
            scanf("%d", &amka);
			printf("Enter the name:");
            scanf("%s", name);
            printf("Enter the age:");
            scanf("%d", &age);
            printf("Enter the gender:");
            scanf("%s", gender);
			add(amka, name, age, gender);
		} else if (num == 2) {
			generate_arrays();
		} else if (num == 3) {
			print_max_min();
		} else if (num == 4) {
			return 0;
		}
	}
}
