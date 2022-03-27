// Guidelines from Fotis K. Tsioumas //

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h> // Header for "wait()".

int main(int argc, char *argv[]) {

  pid_t num;
  int status;

  num = fork();
   
  if (num == -1) {
    printf("The proccess failed");
  } else if (num != 0) {
    printf("I am the parent and I am going to wait for the child to finish.\n");
    wait(&status);  // "&" before "status", defines passing by reference. "&status" returns the number of child's process execution. Then, we can check this number and run the corresponding commands.           
    printf("I am the parent and I got informed that the child finished.\n");
  } else {
    printf("I am the child and I am calculating now for a couple of second.\n");
    sleep(2); // simulate calculations that require 2 seconds by simply waiting.
    printf("I am the child and I finished my calculations.\n");
  }

  return 0;
}