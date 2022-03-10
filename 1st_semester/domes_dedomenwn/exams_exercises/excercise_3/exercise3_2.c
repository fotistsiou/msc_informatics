// Guidelines from Fotis K. Tsioumas//

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

#include <stdio.h>

struct student {
    int am;
    char name[30];
    char surname[30];
    char father_name[30];
    char address[50];
    int telephone;
    int mobile;
    char lesson[30];
};

int main() {

    struct student s[2];

    printf("Enter Records of 2 students\n");    

    for (int i = 0; i < 2; i++) {
        printf("%d Student\n", i+1);
        printf("Enter am:");
        scanf("%d", &s[i].am);
        printf("Enter name:");
        scanf("%s", &s[i].name);
        printf("Enter surname:");
        scanf("%s", &s[i].surname);
        printf("Enter father name:");
        scanf("%s", &s[i].father_name);
        printf("Enter address:");
        scanf("%s", &s[i].address);
        printf("Enter telephone:");
        scanf("%d", &s[i].telephone);
        printf("Enter mobile:");
        scanf("%d", &s[i].mobile);
        printf("Enter lesson:");
        scanf("%s", &s[i].lesson);
    }
    
    for (int i = 0; i < 2; i++) {
        printf("******************************************************\n");
        printf("Student: %d, %s %s, %s, %s, %d, %d, %s\n", s[i].am, s[i].name, s[i].surname, s[i].father_name, s[i].address, s[i].telephone, s[i].mobile, s[i].lesson);
        printf("******************************************************\n");
    }

    return 0;
}