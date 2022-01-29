#include <stdio.h>
#include <unistd.h> // Header for "fork()".

int main(int argc, char *argv[]) {

  printf("Starting\n");

  printf("Original process with PID=%d, PPID=%d.\n", getpid(), getppid()); // "getpid()": Get the Process ID, "getppid()": Get the Parent Process ID (Bush PID)
  
  fork(); // Create a child process 
  
  printf("Level 1  process with PID=%d, PPID=%d.\n", getpid(), getppid()); // It will run from parent and child process  

}