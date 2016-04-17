%{

#include <stdio.h>

%}

%%

"#include <stdio.h>" printf("\nHeader file");

"if"|"else"|"if else" printf("\nconstruct %s ", yytext);

"do"|"while"|"for" printf("\nloop %s ", yytext);

"+"|"-"|"*"|"++"|"--" printf("\nArithmetic Operator %s ", yytext);

"=" printf("\nassignment operator %s ", yytext);

"printf" printf("print statement");

"main"|"()" printf("\nFunction %s ", yytext);

"("|")" printf("\nBrace %s", yytext); 
 
"," printf("\nseperator %s ", yytext);

">"|"<"|">="|"<="|"!=" printf("\nRelational operator %s ", yytext);

"int"|"float"|"double"|"char"|"short"|"long" printf("\nData type %s ", yytext);

[a-zA-Z][a-zA-Z0-9]* printf("\nWORD %s ", yytext);

[0-9]+ printf("\nInteger %s ", yytext);

\{ printf("\nOpen brace: ");

\} printf("\nClose brace: ");

\; printf("\nSEMICOLON ");

[ \t]+ /* ignore whitespace */;

%%

int main (void) {yylex(); return 0;}

int yywrap (void) {return 1;}
