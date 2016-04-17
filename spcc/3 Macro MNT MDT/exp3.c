#include<stdio.h>
#include<string.h>
#include<ctype.h>
FILE *fp;
struct mnt_table
{ char name[10];
int mdtindex;
}mnt[10];
struct mdt_table
{ char macrodef[100];
}mdt[30];
struct ala_table
{char arg[10];
}ala[10];
int mntp=0,mdtp=0,alap=0;
char lastsymb[10]="";
char lastpoc[10]="";
char lastmoc[10]="";
char lastrd[10]="";
static int inp=0; void
getnext(char[]); void
seenext(char[]); int
len;
char ch[1000];char word[50];
void checkmacro(char[]);
void displaymnt();
void displaymdt();
void displayala();
void replace(char string[50],char find[10],char
replace[10]); void writemnt();
void writemdt();
void writeala();
int main()
{
char c;
int j,i=0;
fp=fopen("macro.txt","r");
c=getc(fp);
while(c!=EOF)
{
ch[i++]=c;
c=getc(fp);
}
ch[i++]='\0';
puts(ch);
printf("\n");
len=i; printf("------------------------------------------------------------\n\n"); 
do{
getnext(word);
checkmacro(word);
for(j=0;j<mntp;j++)
{
if(strcmp(word,mnt[j].name)==0)
{
int x=0,i=0;
while((int)ch[inp]!=10)
{
if(ch[inp]==',')
{
word[x]='\0';
inp++;
strcpy(ala[i].arg,word);
alap++;
i++;
x=0;continue;
}
word[x]=ch[inp];
x++;
inp++;
}
word[x]='\0';
strcpy(ala[i].arg,word);
alap++;
}
}
}
while(strcmp(word,"END"));
displaymnt();
displaymdt();
displayala();
writemnt();
writemdt();
writeala();
printf("\n");
fclose(fp);
}
void getnext(char word[50])
{
int x=0;
while(inp<len)
{
if(ch[inp]==' '||ch[inp]==','||(int)ch[inp]==10)
{
word[x]='\0';
inp++;
if(word[0]=='\0')
getnext(word);
return;
}
word[x]=ch[inp];
x++;
inp++;
}
return;
}
void checkmacro(char wrd[10])
{
if(strcmp(wrd,"MACRO")==0){
int i,flag=0;
char tmp[30];
seenext(tmp);
strcpy(mnt[mntp].name,tmp);
mnt[mntp].mdtindex=mdtp;
mntp++;
do
{
seenext(tmp);
i=0;
while((int)ch[inp]!=10)
{
mdt[mdtp].macrodef[i]=ch[inp];
inp++;
i++;
}
if(flag==1)
{replace(mdt[mdtp].macrodef,"&ARG","#");
}
inp++;
mdt[mdtp].macrodef[i]='\0';
mdtp++;
flag=1;
}while(strcmp(tmp,"MEND"));
}
}
void replace(char string[50],char find[10],char replace[10])
{
char news[50]="";
char tmp[20]="";
int len,len1,len2,a=0,b=0,c=0;
len=strlen(string);
len1=strlen(find);
len2=strlen(replace);
while(a<len)
{
for(b=0;b<len1;b++)
{
tmp[b]=string[a];
if(string[a]!=find[b])
break;
a++;
}
if(b==len1){
strcat(news,replace);
c=c+len2;
}
else if(b>0)
{
strcat(news,tmp);
c=c+b;
}
else
{
news[c]=string[a];
c++;
a++;
}
}
strcpy(string,news);
}
void displaymnt()
{
int i;
printf("\n");
printf("---------------Macro Name Table----------------\n");
printf("\n\n");
printf("Index\t|\tMacro Name\t|\tMDT Index\n");
for(i=0;i<mntp;i++)
printf("%d\t|\t%s\t\t|\t%d\n",i+1,mnt[i].name,mnt[i].mdtindex+1);
}
void displaymdt()
{
int i;
printf("\n");
printf("---------------Macro Definition Table----------------\n"); 
printf("\n\n");
printf("Index\t|\tMacro Definition\n");
for(i=0;i<mdtp;i++)
printf("%d\t|\t%s\n",i+1,mdt[i].macrodef);
}
void displayala()
{
int i;
printf("\n");
printf("---------------Argument List Array----------------\n");
printf("\n\n");
printf("Index\t|\tArgument\n");
for(i=0;i<alap;i++)
{
printf("%d\t|\t%s\n",i+1,ala[i].arg);
}
}
void writemnt()
{
int i;
FILE *fp1;
fp1=fopen("MNT.txt","w");
fprintf(fp1,"---------------Macro Name Table----------------\n");
fprintf(fp1,"Index\t|\tMacro Name\t|\tMDT Index\n");
for(i=0;i<mntp;i++)
fprintf(fp1,"%d\t|\t%s\t\t|\t%d\n",i+1,mnt[i].name,mnt[i].mdtindex+1);
fclose(fp1);
}
void writemdt()
{
int i;
FILE *fp2;
fp2=fopen("MDT.txt","w");
fprintf(fp2,"---------------Macro Definition Table----------------\n");
fprintf(fp2,"Index\t|\tMacro Definition\n");
for(i=0;i<mdtp;i++)
fprintf(fp2,"%d\t|\t%s\n",i+1,mdt[i].macrodef);
fclose(fp2);
}
void writeala()
{
int i;
FILE *fp3;
fp3=fopen("ALA.txt","w");
fprintf(fp3,"---------------Argument List Array----------------\n");
fprintf(fp3,"Index\t|\tArgument\n");
for(i=0;i<alap;i++)
{
fprintf(fp3,"%d\t|\t%s\n",i+1,ala[i].arg);
}
fclose(fp3);
}
void seenext(char
tmp[10]) { int x=0,z=inp;
while(ch[z]!=' '&&ch[z]!=','&&(int)ch[z]!=10)
{tmp[x]=ch[z];
z++;
x++;
}
tmp[x]='\0';
}

