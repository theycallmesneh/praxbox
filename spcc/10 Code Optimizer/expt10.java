import java.io.*;
import java.util.Scanner;
class expt10{
static int i,n,j,k;
public static String op[][];
public static void main(String args[])throws IOException,NullPointerException
{
// The name of the file to open.
String line = null;
// This will reference one line at a time int n=0; inti,j,k;
String eq[]=new String[100];
op=new String[100][2];
//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("\n\tImplementing code optimization technique :- \n");
try
{
FileReader fileReader = new FileReader("inputbasic.txt");
Scanner sc = new Scanner(fileReader);
System.out.println("\tInput are:\n");
while(sc.hasNext()){
line = sc.nextLine();
System.out.println("\t\t"+(n+1)+". "+line);
eq[n]=line;
if(eq[n].contains("="))
{ op[n]=eq[n].split("=");
} n++;
}
}catch(FileNotFoundException ex) {
System.out.println("Unable to open file");
}
for(i=0;i<n;i++)
{ for(j=i+1;j<n;j++)
{ if(op[i][1]!=null && op[j][1]!=null) if(op[i][1].equals(op[j][1]))
{
op[j][1]=null; for(k=0;k<n;k++)
{
if(op[k][1]!=null) if(op[k][1].contains(op[j][0]))
{
String ns=op[k][1].replaceAll(op[j][0],op[i][0]); op[k][1]=ns;
}
}
op[j][0]=null;
}
}}
System.out.println("\n\tResult of code optimization is as follows. "); for(i=0,j=0;i<n;i++)
if(op[i][0]!=null && op[i][1]!=null)
System.out.println(" \t\t "+(++j)+". "+op[i][0]+" = "+op[i][1]);
}
}
