// Guidelines //

// In order to run this code, have to follow below steps:
// 1. Open the terminal
// 2. Run: cd/<file_path>
// 3. Run: gcc <c_file.c> -o <executable_filename>

// Start Code //

// ------------------------ HEADER SECTION ------------------------ //

#include <stdio.h>

// ------------------------ MAIN SECTION ------------------------ //

int main() {

   // --- BREAK --- //

   // one break //

   int i;
   int j;
   for (i = 0; i <= 4; i++) {
       for (j = 0; j <= 4; j++) {
         if (j == 2) break;
         printf("i = %d, and j = %d\n", i, j);
       }
   }

   // two break //

   int i;
   int j;
   for (i = 0; i <= 4; i++) {
       if (i == 2) break;
       for (j = 0; j <= 4; j++) {
           if (j == 2) break;
           printf("i = %d, and j = %d\n", i, j);
       }
   }


   // --- CONTINUE --- //

   // one continue //

   int i;
   int j;
   for (i = 0; i <= 4; i++) {
       for (j = 0; j <= 4; j++) {
           if (j == 2) continue;
           printf("i = %d, and j = %d\n", i, j);
       }
   }

   // two continue //

   int i;
   int j;
   for (i = 0; i <= 4; i++) {
       if (i == 2) continue;
       for (j = 0; j <= 4; j++) {
           if (j == 2) continue;
           printf("i = %d, and j = %d\n", i, j);
       }
   }

   // --- RETURN --- //

   // one return //

   int i;
   int j;
   for (i = 0; i <= 4; i++) {
       for (j = 0; j <= 4; j++) {
           if (j == 2) return 0;
           printf("i = %d, and j = %d\n", i, j);
       }
   }

   // two return //

   int i;
   int j;
   for (i = 0; i <= 4; i++) {
       if (i == 2) return 0;
       for (j = 0; j <= 4; j++) {
            if (j == 2) return 0;
            printf("i = %d, and j = %d\n", i, j);
       }
   }


   return 0;
}