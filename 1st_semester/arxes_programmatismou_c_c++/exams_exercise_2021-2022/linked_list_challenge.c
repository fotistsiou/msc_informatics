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
	int amka;
	char name[40];
	int age;
	char gender[40];
	struct patient *next;
};

struct patient *head;
int count; 


void add(int amka, char name[40], int age, char gender[40]) {
	struct patient *pts;
	pts = malloc(sizeof(struct patient));
	count++;
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
	// struct patient *pts;
	// pts = head;
	// int men_arr[count];
	// int women_arr[count];
	// int len_men_arr = sizeof(men_arr)/sizeof(men_arr[0]);
	// int len_women_arr = sizeof(women_arr)/sizeof(women_arr[0]);
	// if (pts == NULL){
    //     printf("Not exist patients in the list!\n");
    //     return;
	// }
	// while (pts != NULL) {
	// 	if (pts->gender == "MAN") {
	// 		for (int i = 0; i < len_men_arr; i++) {
	// 			men_arr[i] = pts->age;
	// 		}
	// 	} else if (pts->gender == "WOMAN") {
	// 		for (int j = 0; j < len_women_arr; j++) {
	// 			men_arr[j] = pts->age;
	// 		}
	// 	}
	// 	pts = pts->next;
	// 	for (int i = 0; i < len_men_arr; i++) {
	// 			printf("%d\n", men_arr[i]);
	// 	}
	// 	for (int j = 0; j < len_women_arr; j++) {
	// 			printf("%d\n", men_arr[j]);
	// 	}
	// }
}

int men_arr_test[10] = {3, 4, 9 , 45, 20, 80, 99, 50, 77, 19};
int women_arr_test[10] = {3, 4, 9 , 45, 20, 80, 99, 50, 77, 19};

void print_max_min() {
	int len_men_arr_test = sizeof(men_arr_test)/sizeof(men_arr_test[0]);
	int len_women_arr_test = sizeof(women_arr_test)/sizeof(women_arr_test[0]);
	int max1 = 0;
	int max2 = 0;
	for (int i = 0; i < len_men_arr_test; i++){
		if (men_arr_test[i] > max2) {
			if (men_arr_test[i] >= max1){
				max1 = men_arr_test[i];
			} else {
				max2 = men_arr_test[i];
			}
		}
	}
	int min1 = max1;
	int min2 = max2;
	for (int i = 0; i < len_women_arr_test; i++){
		if (women_arr_test[i] < min2) {
			if (women_arr_test[i] <= min1){
				min1 = women_arr_test[i];
			} else {
				min2 = women_arr_test[i];
			}
		}
	}
	printf("Max 1: %d\n", max1);
	printf("Max 2: %d\n", max2);
	printf("Min 1: %d\n", min1);
	printf("Min 2: %d\n", min2);
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
			printf("Enter the amka:");
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