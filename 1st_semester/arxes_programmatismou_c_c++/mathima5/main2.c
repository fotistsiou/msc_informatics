// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ------------------------ HEADER SECTION ------------------------ //

#include <stdio.h>

// ------------------------ MAIN SECTION ------------------------ //

int main(){
    char name[30];
    int mark,n;
    FILE *fptr;
    fptr = fopen("mydata2.txt", "wb");
    if (fptr == NULL) {
        printf("Something went wrong with the file!");
        return -1;
    }
    printf("Enter number of student:");
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        printf("For student %d, enter name:", i+1);
        scanf("%s", name);
        printf("Enter mark:");
        scanf("%d", &mark);
        fprintf(fptr, "%s,%d \n", name, mark);
    }
    fclose(fptr);
    printf("Data Saved\n");
    return 0;
}