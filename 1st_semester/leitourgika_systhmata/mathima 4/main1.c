// Guidelines from Fotis K. Tsioumas //

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //
#include <stdio.h>
#include <unistd.h> // Header for "fork()".

int main(int argc, char *argv[]) {

  printf("Original process with PID=%d, PPID=%d.\n", getpid(), getppid()); // "getpid()": Get the Process ID, "getppid()": Get the Parent Process ID (Bush PID)
  
  fork(); // Create a child process 
  
  printf("Level 1  process with PID=%d, PPID=%d.\n", getpid(), getppid()); // It will run from parent and child process

  return 0;  
}