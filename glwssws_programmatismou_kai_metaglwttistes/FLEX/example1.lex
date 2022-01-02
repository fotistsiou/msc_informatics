/*** Guidelines ***/

/* In order to run this code, have to follow below steps:
/* 1. Open the terminal
/* 2. Run: cd/<file_path>
/* 3. Run: lex <filename.l> or <filename.lex>
/* 4. Run: gcc lex.yy.c
/* 5. Run: ./a.out

/*** Start Code ***/

/*** ------------------------ DEFINITION SECTION ------------------------ ***/

%{
    int count1;
    int count2;
    int count3;
%}

/*** ------------------------ RULE SECTION ------------------------ ***/

%%
[0-9]+    {printf("'%s' is integer\n", yytext); count1++;}
[a-zA-Z]+ {printf("'%s' is character\n", yytext); count2++;}
.	      {printf("'%s' is other lexeme\n", yytext); count3++;}
\n        {return 0;}
%%

/*** ------------------------ USER CODE SECTION ------------------------ ***/

int yywrap(){return 1;}
int main(){
    yylex();
    printf("Integers are: %d, Characters are: %d, Other Lexemes are: %d\n", count1, count2, count3);
    return 0;
}