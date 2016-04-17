%{
#include<stdio.h>
#include<math.h>
#include "y.tab.h"
%}
%%
[0-9]+ {
yylval.dval=yytext[0];
return NUMBER;
}
\t;
\n return 0;
. {return yytext[0];}
%%
void yyerror(char *str)
{printf(" Invalid Character...");
}
int main()
{
printf("\n Enter Expression => ");
yyparse();
return(0);
}

