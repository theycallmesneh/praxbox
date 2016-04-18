%{
#include<stdio.h>
#include<math.h>
#include "y.tab.h"
%}
%%
[0-9]+ {
yylval.dval=atoi(yytext);
return NUMBER;
}
\n return 0;
. {return yytext[0];}
%%
void yyerror(char *str)
{
printf("Invalid Character...");
}
int main()
{
printf("Type expression like 5*3\n");
yyparse();
return(0);
}