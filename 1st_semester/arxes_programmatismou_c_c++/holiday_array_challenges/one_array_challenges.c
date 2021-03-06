// Guidelines from Fotis K. Tsioumas //

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ------------------------ HEADER SECTION ------------------------ //

#include <stdio.h>

// ------------------------ MAIN SECTION ------------------------ //

int main() {

    int a[6] = {2, 58, 100, 123, 343, 58};
    int len_a = sizeof(a)/sizeof(a[0]); // calculation length of an array

    // Max item of the array
    int max = a[0];
    int i;
    for (i = 1; i < len_a; i++) {
        if (a[i] > max) {
            max = a[i];
        }
    }
    printf("The max item of 'a' array is: %d\n", max);

    // Second max item of the array
    int max2 = a[0];
    for (i = 0; i < len_a; i++) {
        if (a[i] < max && a[i] > max2) {
            max2 = a[i];
        }
    }
    printf("The second max item of 'a' array is: %d\n", max2);

    // Position of the max items
    for (i = 0; i < len_a; i++) {
        if (a[i] == max) {
            printf("The max number %d exist in the position: %d\n", max, i);
        }
    }

    // Min item of the array
    int min = a[0];
    for (i = 1; i < len_a; i++) {
        if (a[i] < min) {
            min = a[i];
        }
    }
    printf("The min item of 'a' array is: %d\n", min);

    // Second min item of the array
    int min2 = max;
    for (i = 0; i < len_a; i++) {
        if (a[i] > min && a[i] < min2) {
            min2 = a[i];
        }
    }
    printf("The second min item of 'a' array is: %d\n", min2);

    // Position of the min items
    for (i = 0; i < len_a; i++) {
        if (a[i] == min) {
            printf("The min number %d exist in the position: %d\n", min, i);
        }
    }

    // Find an item of an array
    int num;
    int in_array = 0;
    printf("Give an integer number: \n");
    scanf("%d", &num);
    for (i = 0; i < len_a; i++) {
        if (num == a[i]) {
            in_array = 1;
        }
    }
    if (in_array == 0) {
        printf("The number %d doesn't exist in 'a' array...\n", num);
    } else {
        printf("The number %d EXISTS in 'a' array!\n", num);
    }

    // How many times there is an item in the array
    int num2;
    int in_array2 = 0;
    printf("Give an integer number: \n");
    scanf("%d", &num2);
    for (i = 0; i < len_a; i++) {
        if (num2 == a[i]) {
            in_array2 += 1;
        }
    }
    if (in_array2 == 0) {
        printf("The number %d doesn't exist in 'a' array...\n", num2);
    } else {
        printf("The number %d EXISTS in 'a' array and exists %d times!\n", num2, in_array2);
    }


    return 0;
}