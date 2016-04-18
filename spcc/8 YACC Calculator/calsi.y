%{
#include<stdio.h>
#include<math.h>
int yylex(void);
%}
%union
{
float dval;
}
%token <dval> NUMBER
%left '+' '-'
%left '*' '/' '!'
%right '^' %nonassoc UMINUS
%nonassoc UPLUS
%type <dval> exp
%%
state : exp {printf("Answer = %f\n",$1);}
;
exp : NUMBER
| exp '+' exp {$$=$1+$3;}
| exp '-' exp {$$=$1-$3;}
| exp '*' exp {$$=$1*$3;}
| exp '/' exp {$$=$1/$3;}
| exp '^' exp {int i,j=$1;
for(i=1;i<$3;i++)
{
j=j*$1;
$$=j;
}}
| exp '!' {int i,j=1;
for(i=1;i<=$1;i++)
{
j=j*i;
$$=j;
}
}
| '('exp')' {$$=$2;}
| '-' exp %prec UMINUS {$$=-$2;}
| '+' exp %prec UPLUS {$$=+$2;}
//| exp '^' exp {$$=$1^$3;}
;
%%