// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ------------------------ HEADER SECTION ------------------------ //

#include <stdio.h>

// ------------------------ MAIN SECTION ------------------------ //

struct student{
    char name[30];
    int mark;
};

int main() {

    FILE *fptr;
    struct student s;
    fptr = fopen("mydata4.dat","r");

    if(fptr==NULL){
        printf("Something went wrong with the file!");
        return -1;
    }

    // "fread()" function adds content to the file
    // Arguments: 1st = pointer of data structure, 2nd = size of each element, 3rd = number of elements (1), 4th = filename
    while (fread(&s,sizeof(struct student),1,fptr)){
        printf("Name: %s, Mark: %d\n",s.name,s.mark);
    }

    fclose(fptr);
    printf("END OF FILE!\n");

    
    return 0;
}