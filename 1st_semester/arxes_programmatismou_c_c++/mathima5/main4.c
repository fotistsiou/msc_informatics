// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ------------------------ HEADER SECTION ------------------------ //

#include <stdio.h>

// ------------------------ MAIN SECTION ------------------------ //

struct student {
   char name[30];
   int mark; 
}; 

int main() {
    struct student s;
    int n;
    FILE *fptr;
    fptr = fopen("mydata4.dat","wb");

    if (fptr == NULL) {
        printf("Something went wrong with the file!");
        return -1;
    }

    printf("Enter number of student:");
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        printf("For student %d, enter name:", i+1);
        scanf("%s", s.name);
        printf("Enter mark:");
        scanf("%d", &(s.mark));

    // "fwrite()" function adds content to the file
    // Arguments: 1st = pointer of data structure, 2nd = size of each element, 3rd = number of elements (1), 4th = filename
        fwrite(&s, sizeof(struct student), 1, fptr);
    }

    fclose(fptr);
    printf("Data Saved\n");
    return 0;
}