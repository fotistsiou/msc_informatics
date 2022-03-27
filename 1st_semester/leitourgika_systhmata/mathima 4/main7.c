// Guidelines from Fotis K. Tsioumas //

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>


int main (int argc, char *argv[]) {

  pid_t pid1, pid2;
  int i, status1, status2;
  
  pid1 = fork();

  if (pid1 != 0) {
    wait(&status1);
    for (i = 21; i <= 30; i++) {
      printf("%d\n", i);
    }
  } else {
    pid2 = fork();
    if (pid2 != 0) {
      wait(&status2);
      for (i = 11; i <= 20; i++) {
        printf("%d\n", i);
      }
    } else {
      for (i = 1; i <= 10; i++) {
        printf("%d\n", i);
      }
    }
  }

  return 0;
}