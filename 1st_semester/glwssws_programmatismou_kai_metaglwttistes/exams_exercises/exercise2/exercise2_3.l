/*** Guidelines from Fotis K. Tsioumas ***/ 

/* In order to run this code, have to follow below steps: */
/* 1. Open the terminal */
/* 2. Run: cd/<file_path> */
/* 3. Run: lex <filename.l> */
/* 4. Run: gcc lex.yy.c -o exercise2_3 */
/* 5. Run: ./exercise2_3 < text.txt */
/* For check your code press "Ctrl + D" */
/* For exit of program press "Ctrl + C" */

/*** Start Code ***/

%{
    #include <stdio.h>
    #include <stdlib.h>

    int counter;
%}


%x IDENTIFIER 
%x SYMBOL
%x TYPE
%x NEWLINE

%%

var {BEGIN(IDENTIFIER); counter = 0;}
[ \t] {}
. {printf("ERROR, I expected var!\n");}
<IDENTIFIER>[a-zA-Z][_\-0-9a-zA-Z]* {printf("Identifier: %s\n", yytext); BEGIN(SYMBOL); counter++;} 
<IDENTIFIER>[ \t] {}
<IDENTIFIER><<EOF>> {if (counter >= 0) printf("ERROR EOF, I expected identifier!\n"); exit(1);}
<IDENTIFIER>. {printf("ERROR, I expected identifier!\n"); exit(1);}
<SYMBOL>[,] {BEGIN(IDENTIFIER);}
<SYMBOL>[:] {BEGIN(TYPE);}
<SYMBOL>[ \t] {}
<SYMBOL><<EOF>> {printf("ERROR EOF, I expected ',' or ':'!\n"); exit(1);}
<SYMBOL>. {printf("ERROR, I expected ',' or ':'!\n"); exit(1);}
<TYPE>(integer92)|(real92)|(boolean92)|(char92) {printf("Type of Variables: %s\n", yytext); BEGIN(NEWLINE);}
<TYPE>[ \t] {}
<TYPE><<EOF>> {printf("ERROR EOF, I expected type of variables!\n"); exit(1);}
<TYPE>. {printf("ERROR, I expected type of variables!\n"); exit(1);}
<NEWLINE>[\n] {BEGIN(IDENTIFIER); counter = 0;}
<NEWLINE>[ \t] {}
<NEWLINE><<EOF>> {exit(1);}
<NEWLINE>. {printf("ERROR, I expected new line!\n"); exit(1);}

%%


int yywrap(){}
int main(){
    yylex();
    return 0;
}