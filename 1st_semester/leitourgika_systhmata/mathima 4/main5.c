// Guidelines from Fotis K. Tsioumas //

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {

  pid_t num;
  int k, status;
  k = 1;

  printf("Global: k = %d\n", k);
  num = fork();

  if (num == -1) {
    printf("The proccess failed");
  } else if (num != 0) {
    k = 20;
    printf("Parent 1: k = %d\n", k);
    wait(&status);            
    printf("Parent 2: k = %d\n", k);
  } else {
    sleep(2);
    printf("Child 1: k = %d\n", k);
    k = 50;
    printf("Child 2: k = %d\n", k);
  }

  return 0;
}