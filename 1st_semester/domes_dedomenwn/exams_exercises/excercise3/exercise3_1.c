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

    struct student s1;

    printf("1st Student\n");
    printf("Enter am:");
    scanf("%d", &s1.am);
    printf("Enter name:");
    scanf("%s", s1.name);
    printf("Enter surname:");
    scanf("%s", s1.surname);
    printf("Enter father name:");
    scanf("%s", s1.father_name);
    printf("Enter address:");
    scanf("%s", s1.address);
    printf("Enter telephone:");
    scanf("%d", &s1.telephone);
    printf("Enter mobile:");
    scanf("%d", &s1.mobile);
    printf("Enter lesson:");
    scanf("%s", s1.lesson);

    printf("First Student: %d, %s %s, %s, %s, %d, %d, %s\n", s1.am, s1.name, s1.surname, s1.father_name, s1.address, s1.telephone, s1.mobile, s1.lesson);

    return 0;
}