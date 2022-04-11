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

    pid_t pid1, pid2, pid3, pid4, pid5;
    int i, status2, status3, status4;

    pid1 = fork();

    if (pid1 != 0) {
        pid2 = fork();
        if (pid2 != 0) {
            waitpid(pid2, &status2, 0);
            printf("Proccess [P0] with PID:%d and PPID:%d.\n",getpid(),getppid());
            // sleep(2); // for simulation of process execution with different runtime 
            execvp("ps", argv);
        } else {
            pid3 = fork();
            if (pid3 != 0) {
                pid4 = fork();
                if (pid4 != 0) {
                    pid5 = fork();
                    if (pid5 != 0) {
                        wait(&status3);
                        wait(&status4);
                        printf("Proccess [P2] with PID:%d and PPID:%d.\n",getpid(),getppid());
                    } else {
                        // sleep(3); // for simulation of process execution with different runtime 
                        printf("Proccess [P5] with PID:%d and PPID:%d.\n",getpid(),getppid());
                    }
                } else {
                    // sleep(3); // for simulation of process execution with different runtime 
                    printf("Proccess [P4] with PID:%d and PPID:%d.\n",getpid(),getppid());
                }
            } else {
                // sleep(4); // for simulation of process execution with different runtime 
                printf("Proccess [P3] with PID:%d and PPID:%d.\n",getpid(),getppid());
            }     
        }
    } else {
        printf("Proccess [P1] with PID:%d and PPID:%d.\n",getpid(),getppid());
    }

    return 0;
} 