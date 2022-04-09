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

  int k, status;
  k = 1;

  printf("Global: k = %d\n", k);

  if (fork() != 0) {
    k = 20;
    printf("Parent 1: k = %d\n", k); // k == 1
    wait(&status);            
    printf("Parent 2: k = %d\n", k); // k == 20
  } else {
    sleep(2);
    printf("Child 1: k = %d\n", k); // k == 1
    k = 50;
    printf("Child 2: k = %d\n", k); // k == 50
  }

  return 0;
}