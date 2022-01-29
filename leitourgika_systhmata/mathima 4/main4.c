#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {

  pid_t num;

  int status;
  
  num = fork(); 

  if (num != 0) {
    printf("I am the parent and I am going to wait for the child to finish.\n");
    wait(&status);  // "&" before "status", defines passing by reference. "&status" returns the number of child's process execution. Then, we can check this number and run the corresponding commands.           
    printf("I am the parent and I got informed that the chils finished.\n");
  } else {
    printf("I am the child and I am calculating now for a couple of second.\n");
    sleep(2); // simulate calculations that require 2 seconds by simply waiting.
    printf("I am the child and I finished my calculations.\n");
  }

}