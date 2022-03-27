// Guidelines from Fotis K. Tsioumas //

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //
#include <stdio.h>
#include <unistd.h>

int main(int argc, char *argv[]) {

  pid_t num;
  int i;

  if (fork() != 0) {
    printf("I'm the parent. PID=%d, PPID=%d.\n", getpid(), getppid());
    // Terminates quickly​
  } else {
    // Do some work so as to terminate after the parent process​
    num = 0;
    for (i = 1; i <= 10000; i++) {
        num = num + i;
    }
    printf("Num is: %d\n", num);
    printf("I'm the child.  PID=%d, PPID=%d.\n", getpid(), getppid());
  }

  return 0;
}