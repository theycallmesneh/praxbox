%{
#include<stdio.h>
int yylex(void);
int k=0;
int i;
char sym[26];
FILE *fp;
%}
%union
{
char dval;
}
%token <dval> NUMBER
%left '+' '-'
%left '*' '/'
%nonassoc UMINUS
%type <dval> state
%type <dval> exp
%%
state :exp {
printf("\n Converted Postfix expression is => ");

fp=fopen("postfix.txt","w");
for(i=0;i<k;i++)
{
fprintf(fp,"%c",sym[i]);
printf("%c",sym[i]);
}
fclose(fp);
printf("\n\n");
}
;

exp : NUMBER {$$=$1;sym[k]=(char)$$;k++;}| exp '+' exp {sym[k]='+';k++;}
| exp '-' exp {sym[k]='-';k++;}
| exp '*' exp {sym[k]='*';k++;}
| exp '/' exp {sym[k]='/';k++;}
;
%%
