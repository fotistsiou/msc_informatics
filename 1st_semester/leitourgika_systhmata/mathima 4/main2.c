// Guidelines from Fotis K. Tsioumas //

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //
#include <stdio.h>
#include <unistd.h>

int main(int argc, char *argv[]) {

  printf("Original process with PID=%d, PPID=%d.\n", getpid(), getppid());

  fork();

  printf("Level 1  process with PID=%d, PPID=%d.\n", getpid(), getppid()); // It will run n**1 times

  fork();

  printf("Level 2  process with PID=%d, PPID=%d.\n", getpid(), getppid()); // It will run n**2 times

  fork();

  printf("Level 3  process with PID=%d, PPID=%d.\n", getpid(), getppid()); // It will run n**3 times

} 