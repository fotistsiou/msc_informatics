// Guidelines from Fotis K. Tsioumas //

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //
#include <stdio.h>
#include <unistd.h> 

int main(int argc, char *argv[]) {

  pid_t num; // "pid_t" is a variable type that is provided from <inistd.h> header

  printf("I'm original process with PID=%d, PPID=%d.\n", getpid(), getppid());

  num = fork(); // "fork()" return -1 if the proccess failed or child's PID for the parent process and 0 for the child process.

  if (num == -1) {
    printf("The proccess of failed!");
  } else if (num != 0) {
    printf("I'm the parent process with PID=%d, PPID=%d.\n", getpid(), getppid());
    printf("I have a child with PID=%d.\n", num);
  } else {
    printf("I'm the child with PID=%d and PPID=%d.\n", getpid(), getppid());
  }

  printf("PID %d terminates.\n", getpid());

  return 0;
}